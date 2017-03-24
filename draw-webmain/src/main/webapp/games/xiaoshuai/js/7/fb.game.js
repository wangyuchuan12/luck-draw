var fb = {
	status: {},
	stage: null,
	loader: null,
	loadfilelist: [],
	loadCB: null,
	birdconfig: {},
	obj: {},
	offset: {
		birdinit: {},
		jumpamount: 90,
		jumptime: 300,
		gap: 250,
		masterPipeDelay: 70
	},
	fn: {
		initComplete: null,
		setCounter: null,
		fallToTheGround: null,
		crashToThePipese: null,
		dead: null,
		alertRelive: null,
		restart: null
	},
	init: function(stageID, callback) {
		fb.fn.initComplete = callback;
		fb.stage = new createjs.Stage(stageID);
		createjs.Touch.enable(fb.stage);
		fb.loadFile(fb.loadfilelist, fb.initComplete);
	},
	initComplete: function() {
		fb.stage.w = fb.stage.canvas.width;
		fb.stage.h = fb.stage.canvas.height;
		fb.offset.birdinit.x = (fb.stage.w / 2);
		fb.offset.birdinit.y = (fb.stage.h / 2);
		fb.offset.wiggleDelta = 18;
		var groundImg = fb.loader.getResult("ground");
		fb.obj.ground = new createjs.Shape();
		fb.obj.ground.graphics.beginBitmapFill(groundImg).drawRect(0, 0, fb.stage.w + groundImg.width, groundImg.height);
		fb.obj.ground.tileW = groundImg.width;
		fb.obj.ground.y = fb.stage.h - groundImg.height;
		fb.birdconfig.images = [fb.loader.getResult("bird")];
		fb.obj.bird = new createjs.Sprite((new createjs.SpriteSheet(fb.birdconfig)));
		fb.obj.bird.setTransform(fb.offset.birdinit.x, fb.offset.birdinit.y, 1, 1);
		fb.obj.bird.framerate = fb.birdconfig.framerate || 30;
		fb.obj.pipes = new createjs.Container();
		fb.stage.addChild(fb.obj.pipes);
		fb.stage.addChild(fb.obj.bird, fb.obj.ground);
		fb.loadSounds();
		fb.reInit(true);
		createjs.Ticker.timingMode = createjs.Ticker.RAF;
		createjs.Ticker.addEventListener("tick", fb.tickEvent);
		fb.stage.addEventListener("stagemousedown", fb.tapdownEvent);
		fb.callback('initComplete');
	},
	reInit: function(init) {
		createjs.Tween.removeTweens(fb.obj.bird);
		fb.obj.bird.x = fb.offset.birdinit.x;
		fb.obj.bird.y = fb.offset.birdinit.y;
		fb.obj.bird.rotation = 0;
		createjs.Tween.get(fb.obj.bird, {
			loop: true
		}).to({
			y: fb.offset.birdinit.y + fb.offset.wiggleDelta
		}, 380, createjs.Ease.sineInOut).to({
			y: fb.offset.birdinit.y
		}, 380, createjs.Ease.sineInOut);
		fb.obj.bird.gotoAndPlay("fly");
		fb.offset.pipesWidth = fb.loader.getResult("pipe").width >> 0;
		fb.offset.pipesInsetX = fb.offset.pipesWidth * 0.1 >> 0;
		fb.offset.pipesInsetY = fb.offset.pipesInsetX * 2 >> 0;
		fb.status = {
			wait: false,
			invincible: false,
			dead: false,
			started: false,
			startjump: false,
			pipeDelay: fb.offset.masterPipeDelay,
			score: 0,
			relivetime: 1
		}
		fb.counter(0);
	},
	restart: function() {
		fb.obj.pipes.removeAllChildren();
		fb.reInit();
		fb.callback('restart');
		fb.birdJump();
	},
	tapdownEvent: function() {
		if (fb.status.dead || fb.status.wait) return;
		if (!fb.status.started) {
			fb.status.started = true;
		}
		fb.birdJump();
	},
	tickEvent: function(event) {
		if (!fb.status.wait) {
			var deltaS = event.delta / 1000;
			if (fb.obj.bird.y > (fb.obj.ground.y - fb.birdconfig.frames.regY - 1)) {
				if (!fb.status.dead) {
					fb.fallToTheGround();
				}
				if (fb.obj.bird.y > (fb.obj.ground.y - 30)) {
					createjs.Tween.removeTweens(fb.obj.bird)
				}
			}
			if (!fb.status.dead) {
				fb.obj.ground.x = (fb.obj.ground.x - deltaS * 300) % fb.obj.ground.tileW;
			}
			if (fb.status.started && !fb.status.dead && !fb.status.wait) {
				fb.checkPipesCrash(deltaS);
				if (fb.status.pipeDelay == 0) {
					fb.createPipes();
				} else {
					fb.status.pipeDelay -= 1;
				}
			}
			fb.status.birdjump = false;
		}
		fb.stage.update(event);
	},
	createPipes: function() {
		pipe = new createjs.Bitmap(fb.loader.getResult("pipe"));
		pipe.x = fb.stage.w + 600;
		pipe.y = (fb.obj.ground.y - fb.offset.gap * 2) * Math.random() + fb.offset.gap * 1.5;
		fb.obj.pipes.addChild(pipe);
		pipe2 = new createjs.Bitmap(fb.loader.getResult("pipe"));
		pipe2.scaleX = -1;
		pipe2.rotation = 180;
		pipe2.x = pipe.x;
		pipe2.y = pipe.y - fb.offset.gap;
		fb.obj.pipes.addChild(pipe2);
		fb.status.pipeDelay = fb.offset.masterPipeDelay;
	},
	checkPipesCrash: function(deltaS) {
		var len = fb.obj.pipes.getNumChildren(),
			crashed = false;
		for (var i = 0; i < len; i++) {
			pipe = fb.obj.pipes.getChildAt(i);
			if (pipe) {
				if (!fb.status.invincible) {
					var c = ndgmr.checkRectCollision(pipe, fb.obj.bird, 1, true),
						cw = fb.offset.pipesWidth / 2;
					if (c && (parseInt(c.width) - 16) > fb.offset.pipesInsetX && (parseInt(c.height) - 16) > fb.offset.pipesInsetY) {
						if ((parseInt(c.height) - 9) > cw || ((parseInt(c.width) - 9) > cw ? (parseInt(c.width) - 9) >= (cw - (parseInt(c.height) - 9)) : ((parseInt(c.width) - 9) - cw) >= (parseInt(c.height) - 9))) {
							crashed = fb.crashToThePipese();
						}
					}
				}
				pipe.x = (pipe.x - deltaS * 300);
				if (!crashed && pipe.x <= fb.stage.w / 2 - fb.offset.pipesWidth / 2 && pipe.rotation == 0 && pipe.name != "counted") {
					pipe.name = "counted"
					if (!fb.status.invincible) fb.counter(fb.status.score + 1)
				}
				if (pipe.x + pipe.image.width <= -pipe.w) {
					fb.obj.pipes.removeChild(pipe)
				}
			}
		}
		return crashed;
	},
	counter: function(n) {
		createjs.Sound.play("Point");
	},
	die: function() {
		alert("die");
		if (fb.status.wait) {
			return;
		}
		createjs.Tween.removeTweens(fb.obj.bird);
		createjs.Sound.play("Crash");
		if (fb.status.relivetime > 0) {
			fb.status.relivetime--;
			fb.obj.bird.gotoAndPlay("fly");
			if (fb.callback('alertRelive')) {
				fb.status.wait = true;
				return;
			}
		}
		fb.status.dead = true;
		fb.obj.bird.gotoAndPlay("dive");
		createjs.Tween.get(fb.obj.bird).wait(0).to({
			y: fb.obj.bird.y + 200
		}, (380) / 1.5, createjs.Ease.linear).call(fb.diveBird).to({
			y: fb.obj.ground.y - fb.birdconfig.frames.regY,
			rotation: 60
		}, (fb.stage.h - (fb.obj.bird.y + 200)) / 1.5, createjs.Ease.linear);
		fb.dead();
	},
	dead: function() {
		alert();
		
		fb.callback('dead');
	},
	reLive: function() {
		fb.status.wait = false;
		fb.status.invincible = true;
		fb.obj.bird.gotoAndPlay("super");
		createjs.Tween.removeTweens(fb.obj.bird);
		createjs.Tween.get(fb.obj.bird).to({
			y: fb.offset.birdinit.y,
			x: fb.offset.birdinit.x,
			rotation: 0
		}, 1000, createjs.Ease.linear)
		setTimeout(function() {
			fb.status.invincible = false;
			fb.obj.bird.gotoAndPlay("fly");
		}, 2000);
	},
	crashToThePipese: function() {
		if (fb.callback('crashToThePipese') !== false) {
			clearInterval(t);
			fb.die();
			return true;
		}
		return false;
	},
	fallToTheGround: function() {
		alert("fallToTheGround");
		if (fb.callback('fallToTheGround') !== false) {
			clearInterval(t);
			fb.die();
		}
	},
	birdJump: function() {
		if (!fb.status.dead && !fb.status.birdjump) {
			createjs.Tween.removeTweens(fb.obj.bird);
			createjs.Sound.play("Tap");
			fb.status.birdjump == true;
			var bireTween = createjs.Tween.get(fb.obj.bird);
			var rotationDelta = fb.obj.bird.roation < 0 ? (-fb.obj.bird.rotation - 20) / 5 : (fb.obj.bird.rotation + 20) / 5;
			if (fb.obj.bird.y < fb.birdconfig.frames.regY) {
				fb.obj.bird.y = 0;
			}
			bireTween.to({
				y: fb.obj.bird.y - rotationDelta,
				rotation: -20
			}, rotationDelta, createjs.Ease.linear).to({
				y: fb.obj.bird.y - fb.offset.jumpamount,
				rotation: -20
			}, fb.offset.jumptime - rotationDelta, createjs.Ease.quadOut).to({
				y: fb.obj.bird.y
			}, fb.offset.jumptime, createjs.Ease.quadIn);
			bireTween.to({
				y: fb.obj.bird.y + 200,
				rotation: 90
			}, (380) / 1.5, createjs.Ease.linear);
			bireTween.to({
				y: fb.obj.ground.y - fb.birdconfig.frames.regY,
				rotation: 60
			}, (fb.stage.h - (fb.obj.bird.y + 200)) / 1.5, createjs.Ease.linear);
		}
		getElement('#gameName').rmCls('HIDE');
	},
	diveBird: function() {
		fb.obj.bird.gotoAndPlay("dive");
	},
	loadFile: function(list, callback) {
		fb.loader = new createjs.LoadQueue(false);
		fb.loader.addEventListener("complete", callback);
		fb.loader.loadManifest(list);
	},
	loadSounds: function() {},
	callback: function(callback, opt) {
		if (fb.status.wait) return;
		if (typeof(callback) == 'string') {
			callback = fb.fn[callback];
		}
		if (typeof(callback) == 'function') {
			return callback.apply(fb, slice(arguments, 1));
		}
	}
};