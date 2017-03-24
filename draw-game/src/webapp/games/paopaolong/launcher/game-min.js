var egret;
(function(d) {
	d.egret_string_code = {};
	d.egret_string_code[-1] = "不存在的stringId:{0}";
	d.egret_string_code[1E3] = "Browser.isMobile接口参数已经变更，请尽快调整用法为 egret.MainContext.deviceType == egret.MainContext.DEVICE_MOBILE";
	d.egret_string_code[1001] = "该方法目前不应传入 resolutionPolicy 参数，请在 docs/1.0_Final_ReleaseNote中查看如何升级";
	d.egret_string_code[1002] = "egret.Ticker是框架内部使用的单例，不允许在外部实例化，计时器请使用egret.Timer类！";
	d.egret_string_code[1003] = "Ticker#setTimeout方法即将废弃,请使用egret.setTimeout";
	d.egret_string_code[1004] = "ExternalInterface调用了js没有注册的方法: {0}";
	d.egret_string_code[1005] = "设置了已经存在的blendMode: {0}";
	d.egret_string_code[1006] = "child不在当前容器内";
	d.egret_string_code[1007] = "提供的索引超出范围";
	d.egret_string_code[1008] = "child未被addChild到该parent";
	d.egret_string_code[1009] = "设置了已经存在的适配模式:{0}";
	d.egret_string_code[1010] = "addEventListener侦听函数不能为空";
	d.egret_string_code[1011] = 'BitmapText找不到文字所对应的纹理:"{0}"';
	d.egret_string_code[1012] = "egret.BitmapTextSpriteSheet已废弃，请使用egret.BitmapFont代替。";
	d.egret_string_code[1013] = "TextField.setFocus 没有实现";
	d.egret_string_code[1014] = "Ease不能被实例化";
	d.egret_string_code[1015] = "xml not found!";
	d.egret_string_code[1016] = "{0}已经废弃";
	d.egret_string_code[1017] = "JSON文件格式不正确: {0}\ndata: {1}";
	d.egret_string_code[1018] = "egret_html5_localStorage.setItem保存失败,key={0}&value={1}";
	d.egret_string_code[1019] = "网络异常:{0}";
	d.egret_string_code[1020] = "无法初始化着色器";
	d.egret_string_code[1021] = "当前浏览器不支持webgl";
	d.egret_string_code[1022] = "{0} ArgumentError";
	d.egret_string_code[1023] = "此方法在ScrollView内不可用!";
	d.egret_string_code[1024] = "使用了尚未实现的ScaleMode";
	d.egret_string_code[1025] = "遇到文件尾";
	d.egret_string_code[1026] = "EncodingError! The code point {0} could not be encoded.";
	d.egret_string_code[1027] = "DecodingError";
	d.egret_string_code[1028] = "调用了未配置的注入规则:{0}。 请先在项目初始化里配置指定的注入规则，再调用对应单例。";
	d.egret_string_code[1029] = "Function.prototype.bind - what is trying to be bound is not callable";
	d.egret_string_code[1030] = "该API已废弃";
	d.egret_string_code[2E3] = "RES.createGroup()传入了配置中不存在的键值: {0}";
	d.egret_string_code[2001] = 'RES加载了不存在或空的资源组:"{0}"';
	d.egret_string_code[3E3] = "主题配置文件加载失败: {0}";
	d.egret_string_code[3001] = "找不到主题中所配置的皮肤类名: {0}";
	d.egret_string_code[3002] = '索引:"{0}"超出集合元素索引范围';
	d.egret_string_code[3003] = "在此组件中不可用，若此组件为容器类，请使用";
	d.egret_string_code[3004] = "addChild(){0}addElement()代替";
	d.egret_string_code[3005] = "addChildAt(){0}addElementAt()代替";
	d.egret_string_code[3006] = "removeChild(){0}removeElement()代替";
	d.egret_string_code[3007] = "removeChildAt(){0}removeElementAt()代替";
	d.egret_string_code[3008] = "setChildIndex(){0}setElementIndex()代替";
	d.egret_string_code[3009] = "swapChildren(){0}swapElements()代替";
	d.egret_string_code[3010] = "swapChildrenAt(){0}swapElementsAt()代替";
	d.egret_string_code[3011] = '索引:"{0}"超出可视元素索引范围';
	d.egret_string_code[3012] = "此方法在Scroller组件内不可用!";
	d.egret_string_code[3013] = "UIStage是GUI根容器，只能有一个此实例在显示列表中！";
	d.egret_string_code[4E3] = "An Bone cannot be added as a child to itself or one of its children (or children's children, etc.)";
	d.egret_string_code[4001] = "Abstract class can not be instantiated!";
	d.egret_string_code[4002] = "Unnamed data!";
	d.egret_string_code[4003] = "Nonsupport version!";
	d.egret_string_code[3100] = "当前浏览器不支持WebSocket";
	d.egret_string_code[3101] = "请先连接WebSocket";
	d.egret_string_code[3102] = "请先设置type为二进制类型"
})(egret || (egret = {}));
var __extends = this.__extends ||
function(d, f) {
	function g() {
		this.constructor = d
	}
	for (var e in f) f.hasOwnProperty(e) && (d[e] = f[e]);
	g.prototype = f.prototype;
	d.prototype = new g
};
(function(d) {
	function f(e) {
		for (var c = [], b = 1; b < arguments.length; b++) c[b - 1] = arguments[b];
		if (b = d.egret_string_code[e]) for (var a = c.length, h = 0; h < a; h++) b = b.replace("{" + h + "}", c[h]);
		return b
	}
	var g = function() {
			function e() {}
			e.openLogByType = function(c) {
				null == e.logFuncs && (e.logFuncs = {
					error: console.error,
					debug: console.debug,
					warn: console.warn,
					info: console.info,
					log: console.log
				});
				switch (c) {
				case e.OFF:
					console.error = function() {};
				case e.ERROR:
					console.warn = function() {};
				case e.WARN:
					console.info = function() {}, console.log = function() {};
				case e.INFO:
					console.debug = function() {}
				}
				switch (c) {
				case e.ALL:
					console.debug = e.logFuncs.debug;
				case e.INFO:
					console.log = e.logFuncs.log, console.info = e.logFuncs.info;
				case e.WARN:
					console.warn = e.logFuncs.warn;
				case e.ERROR:
					console.error = e.logFuncs.error
				}
			};
			e.fatal = function(c, b) {
				void 0 === b && (b = null);
				d.Logger.traceToConsole("Fatal", c, b);
				throw Error(d.Logger.getTraceCode("Fatal", c, b));
			};
			e.info = function(c, b) {
				void 0 === b && (b = null);
				d.Logger.traceToConsole("Info", c, b)
			};
			e.warning = function(c, b) {
				void 0 === b && (b = null);
				d.Logger.traceToConsole("Warning", c, b)
			};
			e.fatalWithErrorId = function(c) {
				for (var b = [], a = 1; a < arguments.length; a++) b[a - 1] = arguments[a];
				b.unshift(c);
				(b = f.apply(null, b)) ? e.fatal(b) : e.warning(f(-1, c))
			};
			e.infoWithErrorId = function(c) {
				for (var b = [], a = 1; a < arguments.length; a++) b[a - 1] = arguments[a];
				b.unshift(c);
				(b = f.apply(null, b)) ? e.info(b) : e.warning(f(-1, c))
			};
			e.warningWithErrorId = function(c) {
				for (var b = [], a = 1; a < arguments.length; a++) b[a - 1] = arguments[a];
				b.unshift(c);
				(b = f.apply(null, b)) ? e.warning(b) : e.warning(f(-1, c))
			};
			e.traceToConsole = function(c, b, a) {
				console.log(d.Logger.getTraceCode(c, b, a))
			};
			e.getTraceCode = function(c, b, a) {
				return "[" + c + "]" + b + (null == a ? "" : ":" + a)
			};
			e.ALL = "all";
			e.DEBUG = "debug";
			e.INFO = "info";
			e.WARN = "warn";
			e.ERROR = "error";
			e.OFF = "off";
			return e
		}();
	d.Logger = g;
	g.prototype.__class__ = "egret.Logger";
	d.getString = f
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {
				this._hashCode = d.hashCount++
			}
			Object.defineProperty(d.prototype, "hashCode", {
				get: function() {
					return this._hashCode
				},
				enumerable: !0,
				configurable: !0
			});
			d.hashCount = 1;
			return d
		}();
	d.HashObject = f;
	f.prototype.__class__ = "egret.HashObject"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b) {
				void 0 === b && (b = 300);
				d.call(this);
				this.objectPool = [];
				this._length = 0;
				1 > b && (b = 1);
				this.autoDisposeTime = b;
				this.frameCount = 0
			}
			__extends(e, d);
			var c = e.prototype;
			c._checkFrame = function() {
				this.frameCount--;
				0 >= this.frameCount && this.dispose()
			};
			Object.defineProperty(c, "length", {
				get: function() {
					return this._length
				},
				enumerable: !0,
				configurable: !0
			});
			c.push = function(b) {
				var a = this.objectPool; - 1 == a.indexOf(b) && (a.push(b), b.__recycle && b.__recycle(), this._length++, 0 == this.frameCount && (this.frameCount = this.autoDisposeTime, e._callBackList.push(this)))
			};
			c.pop = function() {
				if (0 == this._length) return null;
				this._length--;
				return this.objectPool.pop()
			};
			c.dispose = function() {
				0 < this._length && (this.objectPool = [], this._length = 0);
				this.frameCount = 0;
				var b = e._callBackList,
					a = b.indexOf(this); - 1 != a && b.splice(a, 1)
			};
			e._callBackList = [];
			return e
		}(d.HashObject);
	d.Recycler = f;
	f.prototype.__class__ = "egret.Recycler"
})(egret || (egret = {}));
(function(d) {
	d.__START_TIME;
	d.getTimer = function() {
		return Date.now() - d.__START_TIME
	}
})(egret || (egret = {}));
(function(d) {
	d.__callLaterFunctionList = [];
	d.__callLaterThisList = [];
	d.__callLaterArgsList = [];
	d.callLater = function(f, g) {
		for (var e = [], c = 2; c < arguments.length; c++) e[c - 2] = arguments[c];
		d.__callLaterFunctionList.push(f);
		d.__callLaterThisList.push(g);
		d.__callLaterArgsList.push(e)
	};
	d.__callAsyncFunctionList = [];
	d.__callAsyncThisList = [];
	d.__callAsyncArgsList = [];
	d.__callAsync = function(f, g) {
		for (var e = [], c = 2; c < arguments.length; c++) e[c - 2] = arguments[c];
		d.__callAsyncFunctionList.push(f);
		d.__callAsyncThisList.push(g);
		d.__callAsyncArgsList.push(e)
	}
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function g() {}
			var e = g.prototype;
			e.call = function(c) {
				this.callback && this.callback.call(this.thisObject, c)
			};
			e.dispose = function() {
				this.thisObject = this.callback = null;
				g.__freeList.push(this)
			};
			g.push = function(c, b) {
				var a;
				a = g.__freeList.length ? g.__freeList.pop() : new d.RenderCommand;
				a.callback = c;
				a.thisObject = b;
				d.MainContext.__DRAW_COMMAND_LIST.push(a)
			};
			g.__freeList = [];
			return g
		}();
	d.RenderCommand = f;
	f.prototype.__class__ = "egret.RenderCommand"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b, a, h) {
				void 0 === a && (a = !1);
				void 0 === h && (h = !1);
				g.call(this);
				this.data = null;
				this._type = "";
				this._cancelable = this._bubbles = !1;
				this._eventPhase = 2;
				this._target = this._currentTarget = null;
				this._isPropagationImmediateStopped = this._isPropagationStopped = this._isDefaultPrevented = !1;
				this.isNew = !0;
				this._type = b;
				this._bubbles = a;
				this._cancelable = h
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "type", {
				get: function() {
					return this._type
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "bubbles", {
				get: function() {
					return this._bubbles
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "cancelable", {
				get: function() {
					return this._cancelable
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "eventPhase", {
				get: function() {
					return this._eventPhase
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "currentTarget", {
				get: function() {
					return this._currentTarget
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "target", {
				get: function() {
					return this._target
				},
				enumerable: !0,
				configurable: !0
			});
			c.isDefaultPrevented = function() {
				return this._isDefaultPrevented
			};
			c.preventDefault = function() {
				this._cancelable && (this._isDefaultPrevented = !0)
			};
			c.stopPropagation = function() {
				this._bubbles && (this._isPropagationStopped = !0)
			};
			c.stopImmediatePropagation = function() {
				this._bubbles && (this._isPropagationImmediateStopped = !0)
			};
			c._reset = function() {
				this.isNew ? this.isNew = !1 : (this._isPropagationImmediateStopped = this._isPropagationStopped = this._isDefaultPrevented = !1, this._currentTarget = this._target = null, this._eventPhase = 2)
			};
			c.__recycle = function() {
				this.data = this._target = this._currentTarget = null
			};
			e._dispatchByTarget = function(b, a, h, c, e, g) {
				void 0 === e && (e = !1);
				void 0 === g && (g = !1);
				var f = b.eventRecycler;
				f || (f = b.eventRecycler = new d.Recycler);
				var k = f.pop();
				k ? k._type = h : k = new b(h);
				k._bubbles = e;
				k._cancelable = g;
				if (c) for (var l in c) k[l] = c[l], null !== k[l] && (c[l] = null);
				b = a.dispatchEvent(k);
				f.push(k);
				return b
			};
			e._getPropertyData = function(b) {
				var a = b._props;
				a || (a = b._props = {});
				return a
			};
			e.dispatchEvent = function(b, a, h, c) {
				void 0 === h && (h = !1);
				var d = e._getPropertyData(e);
				void 0 != c && (d.data = c);
				e._dispatchByTarget(e, b, a, d, h)
			};
			e.ADDED_TO_STAGE = "addedToStage";
			e.REMOVED_FROM_STAGE = "removedFromStage";
			e.ADDED = "added";
			e.REMOVED = "removed";
			e.COMPLETE = "complete";
			e.LOOP_COMPLETE = "loopcomplete";
			e.ENTER_FRAME = "enterFrame";
			e.RENDER = "render";
			e.FINISH_RENDER = "finishRender";
			e.FINISH_UPDATE_TRANSFORM = "finishUpdateTransform";
			e.LEAVE_STAGE = "leaveStage";
			e.RESIZE = "resize";
			e.CHANGE = "change";
			e.ACTIVATE = "activate";
			e.DEACTIVATE = "deactivate";
			e.CLOSE = "close";
			e.CONNECT = "connect";
			return e
		}(d.HashObject);
	d.Event = f;
	f.prototype.__class__ = "egret.Event"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(c, b, a) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				d.call(this, c, b, a);
				this._status = 0
			}
			__extends(e, d);
			Object.defineProperty(e.prototype, "status", {
				get: function() {
					return this._status
				},
				enumerable: !0,
				configurable: !0
			});
			e.dispatchHTTPStatusEvent = function(c, b) {
				null == e.httpStatusEvent && (e.httpStatusEvent = new e(e.HTTP_STATUS));
				e.httpStatusEvent._status = b;
				c.dispatchEvent(e.httpStatusEvent)
			};
			e.HTTP_STATUS = "httpStatus";
			e.httpStatusEvent = null;
			return e
		}(d.Event);
	d.HTTPStatusEvent = f;
	f.prototype.__class__ = "egret.HTTPStatusEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(c, b, a) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				g.call(this, c, b, a)
			}
			__extends(e, g);
			e.dispatchIOErrorEvent = function(c) {
				d.Event._dispatchByTarget(e, c, e.IO_ERROR)
			};
			e.IO_ERROR = "ioError";
			return e
		}(d.Event);
	d.IOErrorEvent = f;
	f.prototype.__class__ = "egret.IOErrorEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b, a, h, c, e, d, f, k, l, m) {
				void 0 === a && (a = !0);
				void 0 === h && (h = !0);
				void 0 === c && (c = 0);
				void 0 === e && (e = 0);
				void 0 === d && (d = 0);
				void 0 === f && (f = !1);
				void 0 === k && (k = !1);
				void 0 === m && (m = !1);
				g.call(this, b, a, h);
				this._stageY = this._stageX = 0;
				this.touchPointID = NaN;
				this.touchDown = this.altKey = this.shiftKey = this.ctrlKey = !1;
				this.touchPointID = c;
				this._stageX = e;
				this._stageY = d;
				this.ctrlKey = f;
				this.altKey = k;
				this.touchDown = m
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "stageX", {
				get: function() {
					return this._stageX
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "stageY", {
				get: function() {
					return this._stageY
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "localX", {
				get: function() {
					return this._currentTarget.globalToLocal(this._stageX, this._stageY, d.Point.identity).x
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "localY", {
				get: function() {
					return this._currentTarget.globalToLocal(this._stageX, this._stageY, d.Point.identity).y
				},
				enumerable: !0,
				configurable: !0
			});
			e.dispatchTouchEvent = function(b, a, h, c, g, f, r, k, l) {
				void 0 === h && (h = 0);
				void 0 === c && (c = 0);
				void 0 === g && (g = 0);
				void 0 === f && (f = !1);
				void 0 === r && (r = !1);
				void 0 === k && (k = !1);
				void 0 === l && (l = !1);
				var m = d.Event._getPropertyData(e);
				m.touchPointID = h;
				m._stageX = c;
				m._stageY = g;
				m.ctrlKey = f;
				m.altKey = r;
				m.shiftKey = k;
				m.touchDown = l;
				d.Event._dispatchByTarget(e, b, a, m, !0, !0)
			};
			e.TOUCH_TAP = "touchTap";
			e.TOUCH_MOVE = "touchMove";
			e.TOUCH_BEGIN = "touchBegin";
			e.TOUCH_END = "touchEnd";
			e.TOUCH_RELEASE_OUTSIDE = "touchReleaseOutside";
			e.TOUCH_ROLL_OUT = "touchRollOut";
			e.TOUCH_ROLL_OVER = "touchRollOver";
			e.TOUCH_OUT = "touchOut";
			e.TOUCH_OVER = "touchOver";
			return e
		}(d.Event);
	d.TouchEvent = f;
	f.prototype.__class__ = "egret.TouchEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(c, b, a) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				g.call(this, c, b, a)
			}
			__extends(e, g);
			e.dispatchTimerEvent = function(c, b) {
				d.Event._dispatchByTarget(e, c, b)
			};
			e.TIMER = "timer";
			e.TIMER_COMPLETE = "timerComplete";
			return e
		}(d.Event);
	d.TimerEvent = f;
	f.prototype.__class__ = "egret.TimerEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(c, b, a, h) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				void 0 === h && (h = "");
				g.call(this, c, b, a);
				this.text = h
			}
			__extends(e, g);
			e.dispatchTextEvent = function(c, b, a) {
				var h = d.Event._getPropertyData(e);
				h.text = a;
				d.Event._dispatchByTarget(e, c, b, h)
			};
			e.LINK = "link";
			return e
		}(d.Event);
	d.TextEvent = f;
	f.prototype.__class__ = "egret.TextEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(c, b, a, h, e) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				void 0 === h && (h = 0);
				void 0 === e && (e = 0);
				g.call(this, c, b, a);
				this.bytesTotal = this.bytesLoaded = 0;
				this.bytesLoaded = h;
				this.bytesTotal = e
			}
			__extends(e, g);
			e.dispatchProgressEvent = function(c, b, a, h) {
				void 0 === a && (a = 0);
				void 0 === h && (h = 0);
				d.Event._dispatchByTarget(e, c, b, {
					bytesLoaded: a,
					bytesTotal: h
				})
			};
			e.PROGRESS = "progress";
			e.SOCKET_DATA = "socketData";
			return e
		}(d.Event);
	d.ProgressEvent = f;
	f.prototype.__class__ = "egret.ProgressEvent"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.CAPTURING_PHASE = 1;
			d.AT_TARGET = 2;
			d.BUBBLING_PHASE = 3;
			return d
		}();
	d.EventPhase = f;
	f.prototype.__class__ = "egret.EventPhase"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b) {
				void 0 === b && (b = null);
				g.call(this);
				this._captureEventsMap = this._eventsMap = this._eventTarget = null;
				this._eventTarget = b ? b : this
			}
			__extends(e, g);
			var c = e.prototype;
			c.addEventListener = function(b, a, h, c, e) {
				void 0 === c && (c = !1);
				void 0 === e && (e = 0);
				"undefined" === typeof c && (c = !1);
				"undefined" === typeof e && (e = 0);
				a || d.Logger.fatalWithErrorId(1010);
				c ? (this._captureEventsMap || (this._captureEventsMap = {}), c = this._captureEventsMap) : (this._eventsMap || (this._eventsMap = {}), c = this._eventsMap);
				var g = c[b];
				g || (g = c[b] = []);
				this._insertEventBin(g, a, h, e)
			};
			c._insertEventBin = function(b, a, h, c, e) {
				void 0 === e && (e = void 0);
				for (var d = -1, g = b.length, f = 0; f < g; f++) {
					var l = b[f];
					if (l.listener == a && l.thisObject == h && l.display == e) return !1; - 1 == d && l.priority < c && (d = f)
				}
				a = {
					listener: a,
					thisObject: h,
					priority: c
				};
				e && (a.display = e); - 1 != d ? b.splice(d, 0, a) : b.push(a);
				return !0
			};
			c.removeEventListener = function(b, a, h, c) {
				void 0 === c && (c = !1);
				if (c = c ? this._captureEventsMap : this._eventsMap) {
					var e = c[b];
					e && (this._removeEventBin(e, a, h), 0 == e.length && delete c[b])
				}
			};
			c._removeEventBin = function(b, a, h, c, e) {
				void 0 === c && (c = void 0);
				void 0 === e && (e = 0);
				for (var d = b.length; e < d; e++) {
					var g = b[e];
					if (g.listener == a && g.thisObject == h && g.display == c) return b.splice(e, 1), !0
				}
				return !1
			};
			c.hasEventListener = function(b) {
				return !!(this._eventsMap && this._eventsMap[b] || this._captureEventsMap && this._captureEventsMap[b])
			};
			c.willTrigger = function(b) {
				return this.hasEventListener(b)
			};
			c.dispatchEvent = function(b) {
				b._reset();
				b._target = this._eventTarget;
				b._currentTarget = this._eventTarget;
				return this._notifyListener(b)
			};
			c._notifyListener = function(b) {
				var a = 1 == b._eventPhase ? this._captureEventsMap : this._eventsMap;
				if (!a) return !0;
				a = a[b._type];
				if (!a) return !0;
				var h = a.length;
				if (0 == h) return !0;
				for (var a = a.concat(), c = 0; c < h; c++) {
					var e = a[c];
					e.listener.call(e.thisObject, b);
					if (b._isPropagationImmediateStopped) break
				}
				return !b._isDefaultPrevented
			};
			c.dispatchEventWith = function(b, a, h) {
				void 0 === a && (a = !1);
				d.Event.dispatchEvent(this, b, a, h)
			};
			return e
		}(d.HashObject);
	d.EventDispatcher = f;
	f.prototype.__class__ = "egret.EventDispatcher"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this.stage = this.deviceContext = this.netContext = this.touchContext = this.rendererContext = null;
				this.reuseEvent = new d.Event("")
			}
			__extends(e, g);
			var c = e.prototype;
			c.run = function() {
				d.Ticker.getInstance().run();
				d.Ticker.getInstance().register(this.renderLoop, this, Number.NEGATIVE_INFINITY);
				d.Ticker.getInstance().register(this.broadcastEnterFrame, this, Number.POSITIVE_INFINITY);
				this.touchContext.run();
				this._profileInstance = d.Profiler.getInstance()
			};
			c.renderLoop = function(b) {
				if (0 < d.__callLaterFunctionList.length) {
					var a = d.__callLaterFunctionList;
					d.__callLaterFunctionList = [];
					var h = d.__callLaterThisList;
					d.__callLaterThisList = [];
					var c = d.__callLaterArgsList;
					d.__callLaterArgsList = []
				}
				b = this.stage;
				var g = e.cachedEvent;
				g._type = d.Event.RENDER;
				this.dispatchEvent(g);
				d.Stage._invalidateRenderFlag && (this.broadcastRender(), d.Stage._invalidateRenderFlag = !1);
				a && this.doCallLaterList(a, h, c);
				0 < d.__callAsyncFunctionList.length && this.doCallAsyncList();
				a = this.rendererContext;
				a.onRenderStart();
				a.clearScreen();
				e.__DRAW_COMMAND_LIST = [];
				e._renderLoopPhase = "updateTransform";
				b._updateTransform();
				e._renderLoopPhase = "draw";
				g._type = d.Event.FINISH_UPDATE_TRANSFORM;
				this.dispatchEvent(g);
				e.__use_new_draw ? this._draw(a) : b._draw(a);
				g._type = d.Event.FINISH_RENDER;
				this.dispatchEvent(g);
				this._profileInstance._isRunning && this._profileInstance._drawProfiler(a);
				a.onRenderFinish()
			};
			c._draw = function(b) {
				for (var a = e.__DRAW_COMMAND_LIST, h = a.length, c = 0; c < h; c++) {
					var d = a[c];
					d.call(b);
					d.dispose()
				}
			};
			c.broadcastEnterFrame = function(b) {
				b = this.reuseEvent;
				b._type = d.Event.ENTER_FRAME;
				this.dispatchEvent(b);
				for (var a = d.DisplayObject._enterFrameCallBackList.concat(), h = a.length, c = 0; c < h; c++) {
					var e = a[c];
					b._target = e.display;
					b._currentTarget = e.display;
					e.listener.call(e.thisObject, b)
				}
				a = d.Recycler._callBackList;
				for (c = a.length - 1; 0 <= c; c--) a[c]._checkFrame()
			};
			c.broadcastRender = function() {
				var b = this.reuseEvent;
				b._type = d.Event.RENDER;
				for (var a = d.DisplayObject._renderCallBackList.concat(), h = a.length, c = 0; c < h; c++) {
					var e = a[c],
						g = e.display;
					b._target = g;
					b._currentTarget = g;
					e.listener.call(e.thisObject, b)
				}
			};
			c.doCallLaterList = function(b, a, h) {
				for (var c = b.length, e = 0; e < c; e++) {
					var d = b[e];
					null != d && d.apply(a[e], h[e])
				}
			};
			c.doCallAsyncList = function() {
				var b = d.__callAsyncFunctionList.concat(),
					a = d.__callAsyncThisList.concat(),
					h = d.__callAsyncArgsList.concat();
				d.__callAsyncFunctionList.length = 0;
				d.__callAsyncThisList.length = 0;
				for (var c = d.__callAsyncArgsList.length = 0; c < b.length; c++) {
					var e = b[c];
					null != e && e.apply(a[c], h[c])
				}
			};
			e.deviceType = null;
			e.DEVICE_PC = "web";
			e.DEVICE_MOBILE = "native";
			e.RUNTIME_HTML5 = "runtimeHtml5";
			e.RUNTIME_NATIVE = "runtimeNative";
			e.__DRAW_COMMAND_LIST = [];
			e.__use_new_draw = !0;
			e.cachedEvent = new d.Event("");
			return e
		}(d.EventDispatcher);
	d.MainContext = f;
	f.prototype.__class__ = "egret.MainContext"
})(egret || (egret = {}));
var testDeviceType = function() {
		if (!this.navigator) return !0;
		var d = navigator.userAgent.toLowerCase();
		return -1 != d.indexOf("mobile") || -1 != d.indexOf("android")
	},
	testRuntimeType = function() {
		return this.navigator ? !0 : !1
	};
egret.MainContext.instance = new egret.MainContext;
egret.MainContext.deviceType = testDeviceType() ? egret.MainContext.DEVICE_MOBILE : egret.MainContext.DEVICE_PC;
egret.MainContext.runtimeType = testRuntimeType() ? egret.MainContext.RUNTIME_HTML5 : egret.MainContext.RUNTIME_NATIVE;
delete testDeviceType;
delete testRuntimeType;
(function(d) {
	var f = function() {
			function g() {
				this._preDrawCount = this._updateTransformPerformanceCost = this._renderPerformanceCost = this._logicPerformanceCost = this._lastTime = 0;
				this._calculatePreDrawCount = !0;
				this._txt = null;
				this._tick = 0;
				this._maxDeltaTime = 500;
				this._totalDeltaTime = 0;
				this._isRunning = !1
			}
			var e = g.prototype;
			g.getInstance = function() {
				null == g.instance && (g.instance = new g);
				return g.instance
			};
			e.stop = function() {
				alert("stop");
				if (this._isRunning) {
					this._isRunning = !1;
					d.Ticker.getInstance().unregister(this.update, this);
					var c = d.MainContext.instance;
					c.removeEventListener(d.Event.ENTER_FRAME, this.onEnterFrame, this);
					c.removeEventListener(d.Event.RENDER, this.onStartRender, this);
					c.removeEventListener(d.Event.FINISH_RENDER, this.onFinishRender, this);
					c.removeEventListener(d.Event.FINISH_UPDATE_TRANSFORM, this.onFinishUpdateTransform, this)
				}
			};
			e.run = function() {
				alert("run");
				null == this._txt && (this._txt = new d.TextField, this._txt.size = 28, this._txt.multiline = !0, this._txt._parent = new d.DisplayObjectContainer);
				if (!this._isRunning) {
					this._isRunning = !0;
					d.Ticker.getInstance().register(this.update, this);
					var c = d.MainContext.instance;
					c.addEventListener(d.Event.ENTER_FRAME, this.onEnterFrame, this);
					c.addEventListener(d.Event.RENDER, this.onStartRender, this);
					c.addEventListener(d.Event.FINISH_RENDER, this.onFinishRender, this);
					c.addEventListener(d.Event.FINISH_UPDATE_TRANSFORM, this.onFinishUpdateTransform, this)
				}
			};
			e._drawProfiler = function(c) {
				"_drawWebGL" in c && c._drawWebGL();
				this._calculatePreDrawCount = !1;
				this._txt._updateTransform();
				this._txt._draw(c)
			};
			e._setTxtFontSize = function(c) {
				this._txt.size = c
			};
			e.onEnterFrame = function(c) {
				this._lastTime = d.getTimer()
			};
			e.onStartRender = function(c) {
				c = d.getTimer();
				this._logicPerformanceCost = c - this._lastTime;
				this._lastTime = c
			};
			e.onFinishUpdateTransform = function(c) {
				c = d.getTimer();
				this._updateTransformPerformanceCost = c - this._lastTime;
				this._lastTime = c
			};
			e.onFinishRender = function(c) {
				c = d.getTimer();
				this._renderPerformanceCost = c - this._lastTime;
				this._lastTime = c
			};
			e.update = function(c) {
				this._tick++;
				this._totalDeltaTime += c;
				if (this._totalDeltaTime >= this._maxDeltaTime) {
					c = this._preDrawCount.toString();
					var b = Math.ceil(this._logicPerformanceCost).toString() + "," + Math.ceil(this._updateTransformPerformanceCost).toString() + "," + Math.ceil(this._renderPerformanceCost).toString() + "," + Math.ceil(d.MainContext.instance.rendererContext.renderCost).toString();
					this._txt.text = "draw:" + c + "\ncost:" + b + "\nFPS:" + Math.floor(1E3 * this._tick / this._totalDeltaTime).toString();
					this._tick = this._totalDeltaTime = 0
				}
				this._preDrawCount = 0;
				this._calculatePreDrawCount = !0
			};
			e.onDrawImage = function() {
				this._calculatePreDrawCount && this._preDrawCount++
			};
			return g
		}();
	d.Profiler = f;
	f.prototype.__class__ = "egret.Profiler"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this._timeScale = 1;
				this._paused = !1;
				this._callIndex = -1;
				this.callBackList = [];
				null != e.instance && d.Logger.fatalWithErrorId(1002)
			}
			__extends(e, g);
			var c = e.prototype;
			c.run = function() {
				d.__START_TIME = (new Date).getTime();
				d.MainContext.instance.deviceContext.executeMainLoop(this.update, this)
			};
			c.update = function(b) {
				if (!this._paused) {
					b *= this._timeScale;
					b *= this._timeScale;
					this._callList = this.callBackList.concat();
					for (this._callIndex = 0; this._callIndex < this._callList.length; this._callIndex++) {
						var a = this._callList[this._callIndex];
						a.listener.call(a.thisObject, b)
					}
					this._callIndex = -1;
					this._callList = null
				}
			};
			c.register = function(b, a, h) {
				void 0 === h && (h = 0);
				this._insertEventBin(this.callBackList, b, a, h)
			};
			c.unregister = function(b, a) {
				this._removeEventBin(this.callBackList, b, a);
				this._callList && -1 < this._callIndex && this._removeEventBin(this._callList, b, a, null, this._callIndex + 1)
			};
			c.setTimeout = function(b, a, h) {
				for (var c = [], e = 3; e < arguments.length; e++) c[e - 3] = arguments[e];
				d.Logger.warningWithErrorId(1003);
				d.setTimeout.apply(null, [b, a, h].concat(c))
			};
			c.setTimeScale = function(b) {
				this._timeScale = b
			};
			c.getTimeScale = function() {
				return this._timeScale
			};
			c.pause = function() {
				this._paused = !0
			};
			c.resume = function() {
				this._paused = !1
			};
			e.getInstance = function() {
				null == e.instance && (e.instance = new e);
				return e.instance
			};
			return e
		}(d.EventDispatcher);
	d.Ticker = f;
	f.prototype.__class__ = "egret.Ticker"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.LEFT = "left";
			d.RIGHT = "right";
			d.CENTER = "center";
			d.JUSTIFY = "justify";
			d.CONTENT_JUSTIFY = "contentJustify";
			return d
		}();
	d.HorizontalAlign = f;
	f.prototype.__class__ = "egret.HorizontalAlign"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.TOP = "top";
			d.BOTTOM = "bottom";
			d.MIDDLE = "middle";
			d.JUSTIFY = "justify";
			d.CONTENT_JUSTIFY = "contentJustify";
			return d
		}();
	d.VerticalAlign = f;
	f.prototype.__class__ = "egret.VerticalAlign"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b, a) {
				void 0 === a && (a = 0);
				g.call(this);
				this._currentCount = 0;
				this._running = !1;
				this.lastTime = 0;
				this.delay = b;
				this.repeatCount = a
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "currentCount", {
				get: function() {
					return this._currentCount
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "running", {
				get: function() {
					return this._running
				},
				enumerable: !0,
				configurable: !0
			});
			c.reset = function() {
				this.stop();
				this._currentCount = 0
			};
			c.start = function() {
				this._running || (this.lastTime = d.getTimer(), d.Ticker.getInstance().register(this.onEnterFrame, this), this._running = !0)
			};
			c.stop = function() {
				this._running && (d.Ticker.getInstance().unregister(this.onEnterFrame, this), this._running = !1)
			};
			c.onEnterFrame = function(b) {
				b = d.getTimer();
				b - this.lastTime > this.delay && (this.lastTime = b, this._currentCount++, d.TimerEvent.dispatchTimerEvent(this, d.TimerEvent.TIMER), 0 < this.repeatCount && this._currentCount >= this.repeatCount && (this.stop(), d.TimerEvent.dispatchTimerEvent(this, d.TimerEvent.TIMER_COMPLETE)))
			};
			return e
		}(d.EventDispatcher);
	d.Timer = f;
	f.prototype.__class__ = "egret.Timer"
})(egret || (egret = {}));
(function(d) {
	function f(d) {
		d = d.prototype ? d.prototype : Object.getPrototypeOf(d);
		if (d.hasOwnProperty("__class__")) return d.__class__;
		var e = d.constructor.toString(),
			c = e.indexOf("("),
			e = e.substring(9, c);
		Object.defineProperty(d, "__class__", {
			value: e,
			enumerable: !1,
			writable: !0
		});
		return e
	}
	d.getQualifiedClassName = f;
	d.getQualifiedSuperclassName = function(d) {
		d = d.prototype ? d.prototype : Object.getPrototypeOf(d);
		if (d.hasOwnProperty("__superclass__")) return d.__superclass__;
		var e = Object.getPrototypeOf(d);
		if (null == e) return null;
		e = f(e.constructor);
		if (!e) return null;
		Object.defineProperty(d, "__superclass__", {
			value: e,
			enumerable: !1,
			writable: !0
		});
		return e
	}
})(egret || (egret = {}));
(function(d) {
	var f = {};
	d.getDefinitionByName = function(d) {
		if (!d) return null;
		var e = f[d];
		if (e) return e;
		for (var c = d.split("."), b = c.length, e = __global, a = 0; a < b; a++) if (e = e[c[a]], !e) return null;
		return f[d] = e
	}
})(egret || (egret = {}));
var __global = __global || this;
(function(d) {
	function f(c) {
		for (var b in g) {
			var a = g[b];
			a.delay -= c;
			0 >= a.delay && (a.listener.apply(a.thisObject, a.params), delete g[b])
		}
	}
	var g = {},
		e = 0;
	d.setTimeout = function(c, b, a) {
		for (var h = [], u = 3; u < arguments.length; u++) h[u - 3] = arguments[u];
		h = {
			listener: c,
			thisObject: b,
			delay: a,
			params: h
		};
		0 == e && d.Ticker.getInstance().register(f, null);
		e++;
		g[e] = h;
		return e
	};
	d.clearTimeout = function(c) {
		delete g[c]
	}
})(egret || (egret = {}));
(function(d) {
	d.hasDefinition = function(f) {
		return d.getDefinitionByName(f) ? !0 : !1
	}
})(egret || (egret = {}));
(function(d) {
	d.toColorString = function(d) {
		if (isNaN(d) || 0 > d) d = 0;
		16777215 < d && (d = 16777215);
		for (d = d.toString(16).toUpperCase(); 6 > d.length;) d = "0" + d;
		return "#" + d
	}
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b, a, h, c, e, d) {
				void 0 === b && (b = 1);
				void 0 === a && (a = 0);
				void 0 === h && (h = 0);
				void 0 === c && (c = 1);
				void 0 === e && (e = 0);
				void 0 === d && (d = 0);
				g.call(this);
				this.a = b;
				this.b = a;
				this.c = h;
				this.d = c;
				this.tx = e;
				this.ty = d
			}
			__extends(e, g);
			var c = e.prototype;
			c.prepend = function(b, a, h, c, e, d) {
				var g = this.tx;
				if (1 != b || 0 != a || 0 != h || 1 != c) {
					var f = this.a,
						l = this.c;
					this.a = f * b + this.b * h;
					this.b = f * a + this.b * c;
					this.c = l * b + this.d * h;
					this.d = l * a + this.d * c
				}
				this.tx = g * b + this.ty * h + e;
				this.ty = g * a + this.ty * c + d;
				return this
			};
			c.append = function(b, a, h, c, e, d) {
				var g = this.a,
					f = this.b,
					l = this.c,
					m = this.d;
				if (1 != b || 0 != a || 0 != h || 1 != c) this.a = b * g + a * l, this.b = b * f + a * m, this.c = h * g + c * l, this.d = h * f + c * m;
				this.tx = e * g + d * l + this.tx;
				this.ty = e * f + d * m + this.ty;
				return this
			};
			c.prependTransform = function(b, a, h, c, e, g, f, k, l) {
				if (e % 360) {
					var m = d.NumberUtils.cos(e);
					e = d.NumberUtils.sin(e)
				} else m = 1, e = 0;
				if (k || l) this.tx -= k, this.ty -= l;
				g || f ? (this.prepend(m * h, e * h, -e * c, m * c, 0, 0), this.prepend(d.NumberUtils.cos(f), d.NumberUtils.sin(f), -d.NumberUtils.sin(g), d.NumberUtils.cos(g), b, a)) : this.prepend(m * h, e * h, -e * c, m * c, b, a);
				return this
			};
			c.appendTransform = function(b, a, h, c, e, g, f, k, l) {
				if (e % 360) {
					var m = d.NumberUtils.cos(e);
					e = d.NumberUtils.sin(e)
				} else m = 1, e = 0;
				g || f ? (this.append(d.NumberUtils.cos(f), d.NumberUtils.sin(f), -d.NumberUtils.sin(g), d.NumberUtils.cos(g), b, a), this.append(m * h, e * h, -e * c, m * c, 0, 0)) : this.append(m * h, e * h, -e * c, m * c, b, a);
				if (k || l) this.tx -= k * this.a + l * this.c, this.ty -= k * this.b + l * this.d;
				return this
			};
			c.rotate = function(b) {
				var a = Math.cos(b);
				b = Math.sin(b);
				var h = this.a,
					c = this.c,
					e = this.tx;
				this.a = h * a - this.b * b;
				this.b = h * b + this.b * a;
				this.c = c * a - this.d * b;
				this.d = c * b + this.d * a;
				this.tx = e * a - this.ty * b;
				this.ty = e * b + this.ty * a;
				return this
			};
			c.skew = function(b, a) {
				this.append(d.NumberUtils.cos(a), d.NumberUtils.sin(a), -d.NumberUtils.sin(b), d.NumberUtils.cos(b), 0, 0);
				return this
			};
			c.scale = function(b, a) {
				this.a *= b;
				this.d *= a;
				this.c *= b;
				this.b *= a;
				this.tx *= b;
				this.ty *= a;
				return this
			};
			c.translate = function(b, a) {
				this.tx += b;
				this.ty += a;
				return this
			};
			c.identity = function() {
				this.a = this.d = 1;
				this.b = this.c = this.tx = this.ty = 0;
				return this
			};
			c.identityMatrix = function(b) {
				this.a = b.a;
				this.b = b.b;
				this.c = b.c;
				this.d = b.d;
				this.tx = b.tx;
				this.ty = b.ty;
				return this
			};
			c.invert = function() {
				var b = this.a,
					a = this.b,
					h = this.c,
					c = this.d,
					e = this.tx,
					d = b * c - a * h;
				this.a = c / d;
				this.b = -a / d;
				this.c = -h / d;
				this.d = b / d;
				this.tx = (h * this.ty - c * e) / d;
				this.ty = -(b * this.ty - a * e) / d;
				return this
			};
			e.transformCoords = function(b, a, h) {
				var c = d.Point.identity;
				c.x = b.a * a + b.c * h + b.tx;
				c.y = b.d * h + b.b * a + b.ty;
				return c
			};
			c.toArray = function(b) {
				this.array || (this.array = new Float32Array(9));
				b ? (this.array[0] = this.a, this.array[1] = this.b, this.array[2] = 0, this.array[3] = this.c, this.array[4] = this.d, this.array[5] = 0, this.array[6] = this.tx, this.array[7] = this.ty) : (this.array[0] = this.a, this.array[1] = this.b, this.array[2] = this.tx, this.array[3] = this.c, this.array[4] = this.d, this.array[5] = this.ty, this.array[6] = 0, this.array[7] = 0);
				this.array[8] = 1;
				return this.array
			};
			e.identity = new e;
			e.DEG_TO_RAD = Math.PI / 180;
			return e
		}(d.HashObject);
	d.Matrix = f;
	f.prototype.__class__ = "egret.Matrix"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b, a) {
				void 0 === b && (b = 0);
				void 0 === a && (a = 0);
				d.call(this);
				this.x = b;
				this.y = a
			}
			__extends(e, d);
			var c = e.prototype;
			c.clone = function() {
				return new e(this.x, this.y)
			};
			c.equals = function(b) {
				return this.x == b.x && this.y == b.y
			};
			e.distance = function(b, a) {
				return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y))
			};
			e.identity = new e(0, 0);
			return e
		}(d.HashObject);
	d.Point = f;
	f.prototype.__class__ = "egret.Point"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b, a, h, c) {
				void 0 === b && (b = 0);
				void 0 === a && (a = 0);
				void 0 === h && (h = 0);
				void 0 === c && (c = 0);
				d.call(this);
				this.x = b;
				this.y = a;
				this.width = h;
				this.height = c
			}
			__extends(e, d);
			var c = e.prototype;
			Object.defineProperty(c, "right", {
				get: function() {
					return this.x + this.width
				},
				set: function(b) {
					this.width = b - this.x
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "bottom", {
				get: function() {
					return this.y + this.height
				},
				set: function(b) {
					this.height = b - this.y
				},
				enumerable: !0,
				configurable: !0
			});
			c.initialize = function(b, a, h, c) {
				this.x = b;
				this.y = a;
				this.width = h;
				this.height = c;
				return this
			};
			c.contains = function(b, a) {
				return this.x <= b && this.x + this.width >= b && this.y <= a && this.y + this.height >= a
			};
			c.intersects = function(b) {
				return Math.max(this.x, b.x) <= Math.min(this.right, b.right) && Math.max(this.y, b.y) <= Math.min(this.bottom, b.bottom)
			};
			c.setEmpty = function() {
				this.height = this.width = this.y = this.x = 0
			};
			c.clone = function() {
				return new e(this.x, this.y, this.width, this.height)
			};
			c.containsPoint = function(b) {
				return this.x < b.x && this.x + this.width > b.x && this.y < b.y && this.y + this.height > b.y ? !0 : !1
			};
			e.identity = new e(0, 0, 0, 0);
			return e
		}(d.HashObject);
	d.Rectangle = f;
	f.prototype.__class__ = "egret.Rectangle"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this._isSupportDOMParser = this._xmlDict = this._parser = null;
				this._xmlDict = {};
				window.DOMParser ? (this._isSupportDOMParser = !0, this._parser = new DOMParser) : this._isSupportDOMParser = !1
			}
			__extends(e, g);
			var c = e.prototype;
			e.getInstance = function() {
				e._instance || (e._instance = new e);
				return e._instance
			};
			c.parserXML = function(b) {
				for (var a = 0;
				"\n" == b.charAt(a) || "\t" == b.charAt(a) || "\r" == b.charAt(a) || " " == b.charAt(a);) a++;
				0 != a && (b = b.substring(a, b.length));
				this._isSupportDOMParser ? a = this._parser.parseFromString(b, "text/xml") : (a = new ActiveXObject("Microsoft.XMLDOM"), a.async = "false", a.loadXML(b));
				null == a && d.Logger.infoWithErrorId(1015);
				return a
			};
			e._instance = null;
			return e
		}(d.HashObject);
	d.SAXParser = f;
	f.prototype.__class__ = "egret.SAXParser"
})(egret || (egret = {}));
(function(d) {
	var f = function(a) {
			function b() {
				a.call(this);
				this._designHeight = this._designWidth = 0;
				this._scaleY = this._scaleX = 1;
				this._stageHeight = this._stageWidth = this._offSetY = 0
			}
			__extends(b, a);
			var c = b.prototype;
			b.getInstance = function() {
				null == b.instance && (e.initialize(), b.instance = new b);
				return b.instance
			};
			c.setDesignSize = function(a, b, h) {
				this._designWidth = a;
				this._designHeight = b;
				h && (d.Logger.warningWithErrorId(1001), this._setResolutionPolicy(h))
			};
			c._setResolutionPolicy = function(a) {
				this._resolutionPolicy = a;
				a.init(this);
				a._apply(this, this._designWidth, this._designHeight)
			};
			c.getScaleX = function() {
				return this._scaleX
			};
			c.getScaleY = function() {
				return this._scaleY
			};
			c.getOffSetY = function() {
				return this._offSetY
			};
			b.canvas_name = "egretCanvas";
			b.egret_root_div = "gameDiv";
			b.canvas_div_name = "canvasDiv";
			return b
		}(d.HashObject);
	d.StageDelegate = f;
	f.prototype.__class__ = "egret.StageDelegate";
	var g = function() {
			function a(a, b) {
				this._containerStrategy = a;
				this._contentStrategy = b
			}
			var b = a.prototype;
			b.init = function(a) {
				this._containerStrategy.init(a);
				this._contentStrategy.init(a)
			};
			b._apply = function(a, b, h) {
				this._containerStrategy._apply(a, b, h);
				this._contentStrategy._apply(a, b, h)
			};
			return a
		}();
	d.ResolutionPolicy = g;
	g.prototype.__class__ = "egret.ResolutionPolicy";
	var e = function() {
			function a() {}
			var b = a.prototype;
			a.initialize = function() {
				a.EQUAL_TO_FRAME = new c
			};
			b.init = function(a) {};
			b._apply = function(a, b, h) {};
			b._setupContainer = function() {
				var a = document.body,
					b;
				a && (b = a.style) && (b.paddingTop = b.paddingTop || "0px", b.paddingRight = b.paddingRight || "0px", b.paddingBottom = b.paddingBottom || "0px", b.paddingLeft = b.paddingLeft || "0px", b.borderTop = b.borderTop || "0px", b.borderRight = b.borderRight || "0px", b.borderBottom = b.borderBottom || "0px", b.borderLeft = b.borderLeft || "0px", b.marginTop = b.marginTop || "0px", b.marginRight = b.marginRight || "0px", b.marginBottom = b.marginBottom || "0px", b.marginLeft = b.marginLeft || "0px")
			};
			return a
		}();
	d.ContainerStrategy = e;
	e.prototype.__class__ = "egret.ContainerStrategy";
	var c = function(a) {
			function b() {
				a.apply(this, arguments)
			}
			__extends(b, a);
			b.prototype._apply = function(a) {
				this._setupContainer()
			};
			return b
		}(e);
	d.EqualToFrame = c;
	c.prototype.__class__ = "egret.EqualToFrame";
	g = function() {
		function a() {}
		var b = a.prototype;
		b.init = function(a) {};
		b._apply = function(a, b, h) {};
		b.setEgretSize = function(a, b, h, c, e, g) {
			void 0 === g && (g = 0);
			d.StageDelegate.getInstance()._stageWidth = Math.round(a);
			d.StageDelegate.getInstance()._stageHeight = Math.round(b);
			a = document.getElementById(f.canvas_div_name);
			b = document.getElementById(f.egret_root_div);
			a || (a = d.Browser.getInstance().$new("div"), a.id = f.canvas_div_name, b.appendChild(a));
			a.style.width = h + "px";
			a.style.height = c + "px";
			b.style.width = h + "px";
			b.style.height = c + "px";
			b.style.top = g + "px"
		};
		b._getClientWidth = function() {
			return document.documentElement.clientWidth
		};
		b._getClientHeight = function() {
			return document.documentElement.clientHeight
		};
		return a
	}();
	d.ContentStrategy = g;
	g.prototype.__class__ = "egret.ContentStrategy";
	var b = function(a) {
			function b(h) {
				void 0 === h && (h = 0);
				a.call(this);
				this.minWidth = NaN;
				this.minWidth = h
			}
			__extends(b, a);
			b.prototype._apply = function(a, b, h) {
				b = this._getClientWidth();
				var c = this._getClientHeight(),
					e = c / h,
					d = b / e,
					g = 1;
				0 != this.minWidth && (g = Math.min(1, d / this.minWidth));
				this.setEgretSize(d / g, h, b, c * g);
				a._scaleX = e * g;
				a._scaleY = e * g
			};
			return b
		}(g);
	d.FixedHeight = b;
	b.prototype.__class__ = "egret.FixedHeight";
	b = function(a) {
		function b(h) {
			void 0 === h && (h = 0);
			a.call(this);
			this.minHeight = NaN;
			this.minHeight = h
		}
		__extends(b, a);
		b.prototype._apply = function(a, b, h) {
			h = this._getClientWidth();
			var c = this._getClientHeight(),
				e = h / b,
				d = c / e,
				g = 1;
			0 != this.minHeight && (g = Math.min(1, d / this.minHeight));
			this.setEgretSize(b, d / g, h * g, c, h * (1 - g) / 2);
			a._scaleX = e * g;
			a._scaleY = e * g
		};
		return b
	}(g);
	d.FixedWidth = b;
	b.prototype.__class__ = "egret.FixedWidth";
	b = function(a) {
		function b(h, c) {
			a.call(this);
			this.width = h;
			this.height = c
		}
		__extends(b, a);
		b.prototype._apply = function(a, b, h) {
			h = this.width;
			var c = this.height,
				e = h / b;
			this.setEgretSize(b, c / e, h, c);
			a._scaleX = e;
			a._scaleY = e
		};
		return b
	}(g);
	d.FixedSize = b;
	b.prototype.__class__ = "egret.FixedSize";
	b = function(a) {
		function b() {
			a.call(this)
		}
		__extends(b, a);
		b.prototype._apply = function(a, b, h) {
			this.setEgretSize(b, h, b, h, Math.floor((b - b) / 2));
			a._scaleX = 1;
			a._scaleY = 1
		};
		return b
	}(g);
	d.NoScale = b;
	b.prototype.__class__ = "egret.NoScale";
	b = function(a) {
		function b() {
			a.call(this)
		}
		__extends(b, a);
		b.prototype._apply = function(a, b, h) {
			var c = this._getClientWidth(),
				e = this._getClientHeight(),
				d = c,
				g = e,
				f = d / b < g / h ? d / b : g / h,
				d = b * f,
				g = h * f,
				c = Math.floor((c - d) / 2);
			a._offSetY = Math.floor((e - g) / 2);
			this.setEgretSize(b, h / 1, 1 * d, g, c, a._offSetY);
			a._scaleX = 1 * f;
			a._scaleY = 1 * f
		};
		return b
	}(g);
	d.ShowAll = b;
	b.prototype.__class__ = "egret.ShowAll";
	g = function(a) {
		function b() {
			a.call(this)
		}
		__extends(b, a);
		b.prototype._apply = function(a, b, h) {
			var c = this._getClientWidth(),
				e = this._getClientHeight(),
				c = c / b,
				e = e / h;
			this.setEgretSize(b, h, b * c, h * e);
			a._scaleX = c;
			a._scaleY = e
		};
		return b
	}(g);
	d.FullScreen = g;
	g.prototype.__class__ = "egret.FullScreen"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this._originalData = {};
				this._drawAreaList = []
			}
			__extends(e, g);
			var c = e.prototype;
			e.getInstance = function() {
				null == e.instance && (e.instance = new e);
				return e.instance
			};
			c.addDrawArea = function(b) {
				this._drawAreaList.push(b)
			};
			c.clearDrawArea = function() {
				this._drawAreaList = []
			};
			c.drawImage = function(b, a, h, c, g, f, r, k, l, m, n) {
				void 0 === n && (n = void 0);
				r = r || 0;
				k = k || 0;
				var p = a._texture_to_render;
				if (null != p && 0 != f && 0 != g && 0 != l && 0 != m) {
					var q = d.MainContext.instance.rendererContext._texture_scale_factor;
					g /= q;
					f /= q;
					if (0 != this._drawAreaList.length && d.MainContext.instance.rendererContext._cacheCanvasContext) {
						q = d.DisplayObject.getTransformBounds(a._getSize(e.identityRectangle), a._worldTransform);
						a._worldBounds.initialize(q.x, q.y, q.width, q.height);
						q = this._originalData;
						q.sourceX = h;
						q.sourceY = c;
						q.sourceWidth = g;
						q.sourceHeight = f;
						q.destX = r;
						q.destY = k;
						q.destWidth = l;
						q.destHeight = m;
						for (var x = this.getDrawAreaList(), z = 0; z < x.length; z++) if (!this.ignoreRender(a, x[z], q.destX, q.destY)) {
							b.drawImage(p, h, c, g, f, r, k, l, m, n);
							break
						}
					} else b.drawImage(p, h, c, g, f, r, k, l, m, n)
				}
			};
			c.ignoreRender = function(b, a, h, c) {
				var e = b._worldBounds;
				h *= b._worldTransform.a;
				c *= b._worldTransform.d;
				return e.x + e.width + h <= a.x || e.x + h >= a.x + a.width || e.y + e.height + c <= a.y || e.y + c >= a.y + a.height ? !0 : !1
			};
			c.getDrawAreaList = function() {
				var b;
				0 == this._drawAreaList.length ? (this._defaultDrawAreaList || (this._defaultDrawAreaList = [new d.Rectangle(0, 0, d.MainContext.instance.stage.stageWidth, d.MainContext.instance.stage.stageHeight)], d.MainContext.instance.stage.addEventListener(d.Event.RESIZE, this.onResize, this)), b = this._defaultDrawAreaList) : b = this._drawAreaList;
				return b
			};
			c.onResize = function() {
				d.MainContext.instance.stage.removeEventListener(d.Event.RESIZE, this.onResize, this);
				this._defaultDrawAreaList = null
			};
			e.identityRectangle = new d.Rectangle;
			return e
		}(d.HashObject);
	d.RenderFilter = f;
	f.prototype.__class__ = "egret.RenderFilter"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function g() {}
			g.mapClass = function(e, c, b) {
				void 0 === b && (b = "");
				e = this.getKey(e) + "#" + b;
				this.mapClassDic[e] = c
			};
			g.getKey = function(e) {
				return "string" == typeof e ? e : d.getQualifiedClassName(e)
			};
			g.mapValue = function(e, c, b) {
				void 0 === b && (b = "");
				e = this.getKey(e) + "#" + b;
				this.mapValueDic[e] = c
			};
			g.hasMapRule = function(e, c) {
				void 0 === c && (c = "");
				var b = this.getKey(e) + "#" + c;
				return this.mapValueDic[b] || this.mapClassDic[b] ? !0 : !1
			};
			g.getInstance = function(e, c) {
				void 0 === c && (c = "");
				var b = this.getKey(e) + "#" + c;
				if (this.mapValueDic[b]) return this.mapValueDic[b];
				var a = this.mapClassDic[b];
				if (a) return a = new a, this.mapValueDic[b] = a, delete this.mapClassDic[b], a;
				throw Error(d.getString(1028, b));
			};
			g.mapClassDic = {};
			g.mapValueDic = {};
			return g
		}();
	d.Injector = f;
	f.prototype.__class__ = "egret.Injector"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			return function() {
				this.type = null
			}
		}();
	d.Filter = f;
	f.prototype.__class__ = "egret.Filter"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(c, b) {
				d.call(this);
				this.blurX = c;
				this.blurY = b;
				this.type = "blur"
			}
			__extends(e, d);
			return e
		}(d.Filter);
	d.BlurFilter = f;
	f.prototype.__class__ = "egret.BlurFilter"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.NORMAL = "normal";
			d.ADD = "add";
			d.ERASE = "erase";
			d.ERASE_REVERSE = "eraseReverse";
			return d
		}();
	d.BlendMode = f;
	f.prototype.__class__ = "egret.BlendMode"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this.__hack_local_matrix = null;
				this._sizeDirty = this._normalDirty = !0;
				this._parent = this._texture_to_render = this.name = this._sizeChangeCallTarget = this._sizeChangeCallBack = null;
				this._y = this._x = 0;
				this._scaleY = this._scaleX = 1;
				this._anchorY = this._anchorX = this._anchorOffsetY = this._anchorOffsetX = 0;
				this._visible = !0;
				this._rotation = 0;
				this._alpha = 1;
				this._skewY = this._skewX = 0;
				this._touchEnabled = !1;
				this._scrollRect = this.blendMode = null;
				this._explicitHeight = this._explicitWidth = NaN;
				this._hasHeightSet = this._hasWidthSet = !1;
				this._worldBounds = this.mask = null;
				this.worldAlpha = 1;
				this.needDraw = this._isContainer = !1;
				this._hitTestPointTexture = null;
				this._rectH = this._rectW = 0;
				this._stage = null;
				this._cacheAsBitmap = !1;
				this.renderTexture = null;
				this._cacheDirty = !1;
				this._filter = this._colorTransform = null;
				this._worldTransform = new d.Matrix;
				this._worldBounds = new d.Rectangle(0, 0, 0, 0);
				this._cacheBounds = new d.Rectangle(0, 0, 0, 0)
			}
			__extends(e, g);
			var c = e.prototype;
			c._setDirty = function() {
				this._normalDirty = !0
			};
			c.getDirty = function() {
				return this._normalDirty || this._sizeDirty
			};
			c._setParentSizeDirty = function() {
				var b = this._parent;
				!b || b._hasWidthSet || b._hasHeightSet || b._setSizeDirty()
			};
			c._setSizeDirty = function() {
				this._sizeDirty || (this._sizeDirty = !0, this._setDirty(), this._setCacheDirty(), this._setParentSizeDirty(), null != this._sizeChangeCallBack && (this._sizeChangeCallTarget == this._parent ? this._sizeChangeCallBack.call(this._sizeChangeCallTarget) : this._sizeChangeCallTarget = this._sizeChangeCallBack = null))
			};
			c._clearDirty = function() {
				this._normalDirty = !1
			};
			c._clearSizeDirty = function() {
				this._sizeDirty = !1
			};
			Object.defineProperty(c, "parent", {
				get: function() {
					return this._parent
				},
				enumerable: !0,
				configurable: !0
			});
			c._parentChanged = function(b) {
				this._parent = b
			};
			Object.defineProperty(c, "x", {
				get: function() {
					return this._x
				},
				set: function(b) {
					this._setX(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setX = function(b) {
				d.NumberUtils.isNumber(b) && this._x != b && (this._x = b, this._setDirty(), this._setParentSizeDirty())
			};
			Object.defineProperty(c, "y", {
				get: function() {
					return this._y
				},
				set: function(b) {
					this._setY(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setY = function(b) {
				d.NumberUtils.isNumber(b) && this._y != b && (this._y = b, this._setDirty(), this._setParentSizeDirty())
			};
			Object.defineProperty(c, "scaleX", {
				get: function() {
					return this._scaleX
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._scaleX != b && (this._scaleX = b, this._setDirty(), this._setParentSizeDirty())

				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "scaleY", {
				get: function() {
					return this._scaleY
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._scaleY != b && (this._scaleY = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "anchorOffsetX", {
				get: function() {
					return this._anchorOffsetX
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._anchorOffsetX != b && (this._anchorOffsetX = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "anchorOffsetY", {
				get: function() {
					return this._anchorOffsetY
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._anchorOffsetY != b && (this._anchorOffsetY = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "anchorX", {
				get: function() {
					return this._anchorX
				},
				set: function(b) {
					this._setAnchorX(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setAnchorX = function(b) {
				d.NumberUtils.isNumber(b) && this._anchorX != b && (this._anchorX = b, this._setDirty(), this._setParentSizeDirty())
			};
			Object.defineProperty(c, "anchorY", {
				get: function() {
					return this._anchorY
				},
				set: function(b) {
					this._setAnchorY(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setAnchorY = function(b) {
				d.NumberUtils.isNumber(b) && this._anchorY != b && (this._anchorY = b, this._setDirty(), this._setParentSizeDirty())
			};
			Object.defineProperty(c, "visible", {
				get: function() {
					return this._visible
				},
				set: function(b) {
					this._setVisible(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setVisible = function(b) {
				this._visible != b && (this._visible = b, this._setSizeDirty())
			};
			Object.defineProperty(c, "rotation", {
				get: function() {
					return this._rotation
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._rotation != b && (this._rotation = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "alpha", {
				get: function() {
					return this._alpha
				},
				set: function(b) {
					this._setAlpha(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setAlpha = function(b) {
				d.NumberUtils.isNumber(b) && this._alpha != b && (this._alpha = b, this._setDirty(), this._setCacheDirty())
			};
			Object.defineProperty(c, "skewX", {
				get: function() {
					return this._skewX
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._skewX != b && (this._skewX = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "skewY", {
				get: function() {
					return this._skewY
				},
				set: function(b) {
					d.NumberUtils.isNumber(b) && this._skewY != b && (this._skewY = b, this._setDirty(), this._setParentSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "touchEnabled", {
				get: function() {
					return this._touchEnabled
				},
				set: function(b) {
					this._setTouchEnabled(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setTouchEnabled = function(b) {
				this._touchEnabled = b
			};
			Object.defineProperty(c, "scrollRect", {
				get: function() {
					return this._scrollRect
				},
				set: function(b) {
					this._setScrollRect(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setScrollRect = function(b) {
				this._scrollRect = b;
				this._setSizeDirty()
			};
			Object.defineProperty(c, "measuredWidth", {
				get: function() {
					return this._measureBounds().width
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "measuredHeight", {
				get: function() {
					return this._measureBounds().height
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "explicitWidth", {
				get: function() {
					return this._explicitWidth
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "explicitHeight", {
				get: function() {
					return this._explicitHeight
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "width", {
				get: function() {
					return this._getWidth()
				},
				set: function(b) {
					this._setWidth(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._getWidth = function() {
				return this._getSize(d.Rectangle.identity).width
			};
			Object.defineProperty(c, "height", {
				get: function() {
					return this._getHeight()
				},
				set: function(b) {
					this._setHeight(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._getHeight = function() {
				return this._getSize(d.Rectangle.identity).height
			};
			c._setWidth = function(b) {
				this._setSizeDirty();
				this._setCacheDirty();
				this._explicitWidth = b;
				this._hasWidthSet = d.NumberUtils.isNumber(b)
			};
			c._setHeight = function(b) {
				this._setSizeDirty();
				this._setCacheDirty();
				this._explicitHeight = b;
				this._hasHeightSet = d.NumberUtils.isNumber(b)
			};
			c._draw = function(b) {
				if (this._visible && !this.drawCacheTexture(b)) {
					var a = d.MainContext.__use_new_draw && this._isContainer;
					this._filter && !a && b.setGlobalFilter(this._filter);
					this._colorTransform && !a && b.setGlobalColorTransform(this._colorTransform.matrix);
					b.setAlpha(this.worldAlpha, this.blendMode);
					b.setTransform(this._worldTransform);
					var h = this.mask || this._scrollRect;
					h && !a && b.pushMask(h);
					this._render(b);
					h && !a && b.popMask();
					this._colorTransform && !a && b.setGlobalColorTransform(null);
					this._filter && !a && b.setGlobalFilter(null)
				}
				this.destroyCacheBounds()
			};
			c._setGlobalFilter = function(b) {
				b.setGlobalFilter(this._filter)
			};
			c._removeGlobalFilter = function(b) {
				b.setGlobalFilter(null)
			};
			c._setGlobalColorTransform = function(b) {
				b.setGlobalColorTransform(this._colorTransform.matrix)
			};
			c._removeGlobalColorTransform = function(b) {
				b.setGlobalColorTransform(null)
			};
			c._pushMask = function(b) {
				b.setTransform(this._worldTransform);
				var a = this.mask || this._scrollRect;
				a && b.pushMask(a)
			};
			c._popMask = function(b) {
				b.popMask()
			};
			c.drawCacheTexture = function(b) {
				if (!1 == this._cacheAsBitmap) return !1;
				var a = this.getBounds(d.Rectangle.identity);
				if (this._cacheDirty || null == this._texture_to_render || 1 < a.width - this._texture_to_render._textureWidth || 1 < a.height - this._texture_to_render._textureHeight) this._cacheDirty = !this._makeBitmapCache();
				if (null == this._texture_to_render) return !1;
				var h = this._texture_to_render,
					a = h._offsetX,
					c = h._offsetY,
					e = h._textureWidth,
					h = h._textureHeight;
				this._updateTransform();
				b.setAlpha(this.worldAlpha, this.blendMode);
				b.setTransform(this._worldTransform);
				d.RenderFilter.getInstance().drawImage(b, this, 0, 0, e, h, a, c, e, h);
				return !0
			};
			c._updateTransform = function() {
				this._visible && (this._calculateWorldTransform(), "updateTransform" == d.MainContext._renderLoopPhase && (this.needDraw || this._texture_to_render || this._cacheAsBitmap) && d.RenderCommand.push(this._draw, this))
			};
			c._calculateWorldTransform = function() {
				var b = this._worldTransform,
					a = this._parent;
				b.identityMatrix(a._worldTransform);
				this._getMatrix(b);
				var h = this._scrollRect;
				h && b.append(1, 0, 0, 1, -h.x, -h.y);
				this.worldAlpha = a.worldAlpha * this._alpha
			};

			c._render = function(b) {};
			c.getBounds = function(b, a) {
				void 0 === a && (a = !0);
				var h = this._measureBounds(),
					c = this._hasWidthSet ? this._explicitWidth : h.width,
					e = this._hasHeightSet ? this._explicitHeight : h.height;
				this._rectW = h.width;
				this._rectH = h.height;
				this._clearSizeDirty();
				var g = h.x,
					h = h.y,
					f = 0,
					k = 0;
				a && (0 != this._anchorX || 0 != this._anchorY ? (f = c * this._anchorX, k = e * this._anchorY) : (f = this._anchorOffsetX, k = this._anchorOffsetY));
				this._cacheBounds.initialize(g - f, h - k, c, e);
				c = this._cacheBounds;
				b || (b = new d.Rectangle);
				return b.initialize(c.x, c.y, c.width, c.height)
			};
			c.destroyCacheBounds = function() {
				this._cacheBounds.x = 0;
				this._cacheBounds.y = 0;
				this._cacheBounds.width = 0;
				this._cacheBounds.height = 0
			};
			c._getConcatenatedMatrix = function() {
				for (var b = e.identityMatrixForGetConcatenated.identity(), a = this; null != a;) {
					if (0 != a._anchorX || 0 != a._anchorY) {
						var h = a._getSize(d.Rectangle.identity);
						b.prependTransform(a._x, a._y, a._scaleX, a._scaleY, a._rotation, a._skewX, a._skewY, h.width * a._anchorX, h.height * a._anchorY)
					} else b.prependTransform(a._x, a._y, a._scaleX, a._scaleY, a._rotation, a._skewX, a._skewY, a._anchorOffsetX, a._anchorOffsetY);
					a._scrollRect && b.prepend(1, 0, 0, 1, -a._scrollRect.x, -a._scrollRect.y);
					a = a._parent
				}
				return b
			};
			c.localToGlobal = function(b, a, h) {
				void 0 === b && (b = 0);
				void 0 === a && (a = 0);
				var c = this._getConcatenatedMatrix();
				c.append(1, 0, 0, 1, b, a);
				h || (h = new d.Point);
				h.x = c.tx;
				h.y = c.ty;
				return h
			};
			c.globalToLocal = function(b, a, h) {
				void 0 === b && (b = 0);
				void 0 === a && (a = 0);
				var c = this._getConcatenatedMatrix();
				c.invert();
				c.append(1, 0, 0, 1, b, a);
				h || (h = new d.Point);
				h.x = c.tx;
				h.y = c.ty;
				return h
			};
			c.hitTest = function(b, a, h) {
				void 0 === h && (h = !1);
				if (!this._visible || !h && !this._touchEnabled) return null;
				h = this.getBounds(d.Rectangle.identity, !1);
				b -= h.x;
				a -= h.y;
				return 0 <= b && b < h.width && 0 <= a && a < h.height ? this.mask || this._scrollRect ? this._scrollRect && b > this._scrollRect.x && a > this._scrollRect.y && b < this._scrollRect.x + this._scrollRect.width && a < this._scrollRect.y + this._scrollRect.height || this.mask && this.mask.x <= b && b < this.mask.x + this.mask.width && this.mask.y <= a && a < this.mask.y + this.mask.height ? this : null : this : null
			};
			c.hitTestPoint = function(b, a, h) {
				b = this.globalToLocal(b, a);
				return h ? (this._hitTestPointTexture || (this._hitTestPointTexture = new d.RenderTexture), h = this._hitTestPointTexture, h.drawToTexture(this), 0 != h.getPixel32(b.x - this._hitTestPointTexture._offsetX, b.y - this._hitTestPointTexture._offsetY)[3] ? !0 : !1) : !! this.hitTest(b.x, b.y, !0)
			};
			c._getMatrix = function(b) {
				b || (b = d.Matrix.identity.identity());
				var a, h;
				h = this._getOffsetPoint();
				a = h.x;
				h = h.y;
				var c = this.__hack_local_matrix;
				c ? (b.append(c.a, c.b, c.c, c.d, c.tx, c.ty), b.append(1, 0, 0, 1, -a, -h)) : b.appendTransform(this._x, this._y, this._scaleX, this._scaleY, this._rotation, this._skewX, this._skewY, a, h);
				return b
			};
			c._getSize = function(b) {
				if (this._hasHeightSet && this._hasWidthSet) return this._clearSizeDirty(), b.initialize(0, 0, this._explicitWidth, this._explicitHeight);
				this._measureSize(b);
				this._hasWidthSet && (b.width = this._explicitWidth);
				this._hasHeightSet && (b.height = this._explicitHeight);
				return b
			};
			c._measureSize = function(b) {
				this._sizeDirty ? (b = this._measureBounds(), this._rectW = b.width, this._rectH = b.height, this._clearSizeDirty()) : (b.width = this._rectW, b.height = this._rectH);
				b.x = 0;
				b.y = 0;
				return b
			};
			c._measureBounds = function() {
				return d.Rectangle.identity.initialize(0, 0, 0, 0)
			};
			c._getOffsetPoint = function() {
				var b = this._anchorOffsetX,
					a = this._anchorOffsetY;
				if (0 != this._anchorX || 0 != this._anchorY) a = this._getSize(d.Rectangle.identity), b = this._anchorX * a.width, a = this._anchorY * a.height;
				var h = d.Point.identity;
				h.x = b;
				h.y = a;
				return h
			};
			c._onAddToStage = function() {
				this._stage = d.MainContext.instance.stage;
				d.DisplayObjectContainer.__EVENT__ADD_TO_STAGE_LIST.push(this)
			};
			c._onRemoveFromStage = function() {
				d.DisplayObjectContainer.__EVENT__REMOVE_FROM_STAGE_LIST.push(this)
			};
			Object.defineProperty(c, "stage", {
				get: function() {
					return this._stage
				},
				enumerable: !0,
				configurable: !0
			});
			c.addEventListener = function(b, a, h, c, f) {
				void 0 === c && (c = !1);
				void 0 === f && (f = 0);
				g.prototype.addEventListener.call(this, b, a, h, c, f);
				((c = b == d.Event.ENTER_FRAME) || b == d.Event.RENDER) && this._insertEventBin(c ? e._enterFrameCallBackList : e._renderCallBackList, a, h, f, this)
			};
			c.removeEventListener = function(b, a, h, c) {
				void 0 === c && (c = !1);
				g.prototype.removeEventListener.call(this, b, a, h, c);
				((c = b == d.Event.ENTER_FRAME) || b == d.Event.RENDER) && this._removeEventBin(c ? e._enterFrameCallBackList : e._renderCallBackList, a, h, this)
			};
			c.dispatchEvent = function(b) {
				if (!b._bubbles) return g.prototype.dispatchEvent.call(this, b);
				for (var a = [], h = this; h;) a.push(h), h = h._parent;
				b._reset();
				this._dispatchPropagationEvent(b, a);
				return !b._isDefaultPrevented
			};
			c._dispatchPropagationEvent = function(b, a, h) {
				h = a.length;
				for (var c = 1, e = h - 1; 0 <= e; e--) {
					var d = a[e];
					b._currentTarget = d;
					b._target = this;
					b._eventPhase = c;
					d._notifyListener(b);
					if (b._isPropagationStopped || b._isPropagationImmediateStopped) return
				}
				d = a[0];
				b._currentTarget = d;
				b._target = this;
				b._eventPhase = 2;
				d._notifyListener(b);
				if (!b._isPropagationStopped && !b._isPropagationImmediateStopped) for (c = 3, e = 1; e < h && (d = a[e], b._currentTarget = d, b._target = this, b._eventPhase = c, d._notifyListener(b), !b._isPropagationStopped && !b._isPropagationImmediateStopped); e++);
			};
			c.willTrigger = function(b) {
				for (var a = this; a;) {
					if (a.hasEventListener(b)) return !0;
					a = a._parent
				}
				return !1
			};
			Object.defineProperty(c, "cacheAsBitmap", {
				get: function() {
					return this._cacheAsBitmap
				},
				set: function(b) {
					(this._cacheAsBitmap = b) ? d.callLater(this._makeBitmapCache, this) : this._texture_to_render = null
				},
				enumerable: !0,
				configurable: !0
			});
			c._makeBitmapCache = function() {
				this.renderTexture || (this.renderTexture = new d.RenderTexture);
				var b = this.renderTexture.drawToTexture(this);
				this._texture_to_render = b ? this.renderTexture : null;
				return b
			};
			c._setCacheDirty = function(b) {
				void 0 === b && (b = !0);
				this._cacheDirty = b
			};
			e.getTransformBounds = function(b, a) {
				var h = b.x,
					c = b.y,
					e = b.width,
					d = b.height;
				(h || c) && a.appendTransform(0, 0, 1, 1, 0, 0, 0, -h, -c);
				var g = e * a.a,
					e = e * a.b,
					f = d * a.c,
					d = d * a.d,
					l = a.tx,
					m = a.ty,
					n = l,
					p = l,
					q = m,
					x = m;
				(h = g + l) < n ? n = h : h > p && (p = h);
				(h = g + f + l) < n ? n = h : h > p && (p = h);
				(h = f + l) < n ? n = h : h > p && (p = h);
				(c = e + m) < q ? q = c : c > x && (x = c);
				(c = e + d + m) < q ? q = c : c > x && (x = c);
				(c = d + m) < q ? q = c : c > x && (x = c);
				return b.initialize(n, q, p - n, x - q)
			};
			Object.defineProperty(c, "colorTransform", {
				get: function() {
					return this._colorTransform
				},
				set: function(b) {
					this._colorTransform = b
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "filter", {
				get: function() {
					return this._filter
				},
				set: function(b) {
					this._filter = b
				},
				enumerable: !0,
				configurable: !0
			});
			e.identityMatrixForGetConcatenated = new d.Matrix;
			e._enterFrameCallBackList = [];
			e._renderCallBackList = [];
			return e
		}(d.EventDispatcher);
	d.DisplayObject = f;
	f.prototype.__class__ = "egret.DisplayObject";
	f = function() {
		function d() {
			this.matrix = null
		}
		d.prototype.updateColor = function(e, c, b, a, h, d, g, f) {};
		return d
	}();
	d.ColorTransform = f;
	f.prototype.__class__ = "egret.ColorTransform"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this._touchChildren = !0;
				this._children = [];
				this._isContainer = !0
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "touchChildren", {
				get: function() {
					return this._touchChildren
				},
				set: function(b) {
					this._touchChildren = b
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "numChildren", {
				get: function() {
					return this._children.length
				},
				enumerable: !0,
				configurable: !0
			});
			c.setChildIndex = function(b, a) {
				this.doSetChildIndex(b, a)
			};
			c.doSetChildIndex = function(b, a) {
				var h = this._children.indexOf(b);
				0 > h && d.Logger.fatalWithErrorId(1006);
				this._children.splice(h, 1);
				0 > a || this._children.length <= a ? this._children.push(b) : this._children.splice(a, 0, b)
			};
			c.addChild = function(b) {
				var a = this._children.length;
				b._parent == this && a--;
				return this._doAddChild(b, a)
			};
			c.addChildAt = function(b, a) {
				return this._doAddChild(b, a)
			};
			c._doAddChild = function(b, a, h) {
				void 0 === h && (h = !0);
				if (b == this) return b;
				if (0 > a || a > this._children.length) return d.Logger.fatalWithErrorId(1007), b;
				var c = b._parent;
				if (c == this) return this.doSetChildIndex(b, a), b;
				if (c) {
					var g = c._children.indexOf(b);
					0 <= g && c._doRemoveChild(g)
				}
				this._children.splice(a, 0, b);
				b._parentChanged(this);
				h && b.dispatchEventWith(d.Event.ADDED, !0);
				if (this._stage) for (b._onAddToStage(), a = e.__EVENT__ADD_TO_STAGE_LIST; 0 < a.length;) c = a.shift(), h && c.dispatchEventWith(d.Event.ADDED_TO_STAGE);
				b._setDirty();
				this._setSizeDirty();
				return b
			};
			c.removeChild = function(b) {
				b = this._children.indexOf(b);
				if (0 <= b) return this._doRemoveChild(b);
				d.Logger.fatalWithErrorId(1008);
				return null
			};
			c.removeChildAt = function(b) {
				if (0 <= b && b < this._children.length) return this._doRemoveChild(b);
				d.Logger.fatalWithErrorId(1007);
				return null
			};
			c._doRemoveChild = function(b, a) {
				void 0 === a && (a = !0);
				var h = this._children,
					c = h[b];
				a && c.dispatchEventWith(d.Event.REMOVED, !0);
				if (this._stage) {
					c._onRemoveFromStage();
					for (var g = e.__EVENT__REMOVE_FROM_STAGE_LIST; 0 < g.length;) {
						var f = g.shift();
						a && f.dispatchEventWith(d.Event.REMOVED_FROM_STAGE);
						f._stage = null
					}
				}
				c._parentChanged(null);
				h.splice(b, 1);
				this._setSizeDirty();
				return c
			};
			c.getChildAt = function(b) {
				if (0 <= b && b < this._children.length) return this._children[b];
				d.Logger.fatalWithErrorId(1007);
				return null
			};
			c.contains = function(b) {
				for (; b;) {
					if (b == this) return !0;
					b = b._parent
				}
				return !1
			};
			c.swapChildrenAt = function(b, a) {
				0 <= b && b < this._children.length && 0 <= a && a < this._children.length ? this._swapChildrenAt(b, a) : d.Logger.fatalWithErrorId(1007)
			};
			c.swapChildren = function(b, a) {
				var h = this._children.indexOf(b),
					c = this._children.indexOf(a); - 1 == h || -1 == c ? d.Logger.fatalWithErrorId(1008) : this._swapChildrenAt(h, c)
			};
			c._swapChildrenAt = function(b, a) {
				if (b != a) {
					var h = this._children,
						c = h[b];
					h[b] = h[a];
					h[a] = c
				}
			};
			c.getChildIndex = function(b) {
				return this._children.indexOf(b)
			};
			c.removeChildren = function() {
				for (var b = this._children.length - 1; 0 <= b; b--) this._doRemoveChild(b)
			};
			c._updateTransform = function() {
				if (this._visible) {
					this._filter && d.RenderCommand.push(this._setGlobalFilter, this);
					this._colorTransform && d.RenderCommand.push(this._setGlobalColorTransform, this);
					var b = this.mask || this._scrollRect;
					b && d.RenderCommand.push(this._pushMask, this);
					g.prototype._updateTransform.call(this);
					if (!this._cacheAsBitmap || !this._texture_to_render) for (var a = 0, h = this._children, c = h.length; a < c; a++) h[a]._updateTransform();
					b && d.RenderCommand.push(this._popMask, this);
					this._colorTransform && d.RenderCommand.push(this._removeGlobalColorTransform, this);
					this._filter && d.RenderCommand.push(this._removeGlobalFilter, this)
				}
			};
			c._render = function(b) {
				if (!d.MainContext.__use_new_draw) for (var a = 0, h = this._children, c = h.length; a < c; a++) h[a]._draw(b)
			};
			c._measureBounds = function() {
				for (var b = 0, a = 0, h = 0, c = 0, e = this._children, g = e.length, f = 0; f < g; f++) {
					var k = e[f];
					if (k._visible) {
						var l = k.getBounds(d.Rectangle.identity, !1),
							m = l.x,
							n = l.y,
							p = l.width,
							l = l.height,
							k = k._getMatrix(),
							k = d.DisplayObject.getTransformBounds(d.Rectangle.identity.initialize(m, n, p, l), k),
							m = k.x,
							n = k.y,
							p = k.width + k.x,
							k = k.height + k.y;
						if (m < b || 0 == f) b = m;
						if (p > a || 0 == f) a = p;
						if (n < h || 0 == f) h = n;
						if (k > c || 0 == f) c = k
					}
				}
				return d.Rectangle.identity.initialize(b, h, a - b, c - h)
			};
			c.hitTest = function(b, a, h) {
				void 0 === h && (h = !1);
				var c;
				if (!this._visible) return null;
				if (this._scrollRect) {
					if (b < this._scrollRect.x || a < this._scrollRect.y || b > this._scrollRect.x + this._scrollRect.width || a > this._scrollRect.y + this._scrollRect.height) return null
				} else if (this.mask && (this.mask.x > b || b > this.mask.x + this.mask.width || this.mask.y > a || a > this.mask.y + this.mask.height)) return null;
				for (var e = this._children, f = this._touchChildren, r = e.length - 1; 0 <= r; r--) {
					var k = e[r],
						l = k._getMatrix(),
						m = k._scrollRect;
					m && l.append(1, 0, 0, 1, -m.x, -m.y);
					l.invert();
					l = d.Matrix.transformCoords(l, b, a);
					if (k = k.hitTest(l.x, l.y, !0)) {
						if (!f) return this;
						if (k._touchEnabled && f) return k;
						c = this
					}
				}
				return c ? c : this._texture_to_render ? g.prototype.hitTest.call(this, b, a, h) : null
			};
			c._onAddToStage = function() {
				g.prototype._onAddToStage.call(this);
				for (var b = this._children.length, a = 0; a < b; a++) this._children[a]._onAddToStage()
			};
			c._onRemoveFromStage = function() {
				g.prototype._onRemoveFromStage.call(this);
				for (var b = this._children, a = b.length, h = 0; h < a; h++) b[h]._onRemoveFromStage()
			};
			c.getChildByName = function(b) {
				for (var a = this._children, h = a.length, c, e = 0; e < h; e++) if (c = a[e], c.name == b) return c;
				return null
			};
			e.__EVENT__ADD_TO_STAGE_LIST = [];
			e.__EVENT__REMOVE_FROM_STAGE_LIST = [];
			return e
		}(d.DisplayObject);
	d.DisplayObjectContainer = f;
	f.prototype.__class__ = "egret.DisplayObjectContainer"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.NO_BORDER = "noBorder";
			d.NO_SCALE = "noScale";
			d.SHOW_ALL = "showAll";
			d.EXACT_FIT = "exactFit";
			return d
		}();
	d.StageScaleMode = f;
	f.prototype.__class__ = "egret.StageScaleMode"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b, a) {
				void 0 === b && (b = 480);
				void 0 === a && (a = 800);
				g.call(this);
				this._changeSizeDispatchFlag = !0;
				this._scaleMode = "";
				this._stageHeight = this._stageWidth = NaN;
				this.touchEnabled = !0;
				this._stage = this;
				this._stageWidth = b;
				this._stageHeight = a
			}
			__extends(e, g);
			var c = e.prototype;
			c.invalidate = function() {
				e._invalidateRenderFlag = !0
			};
			Object.defineProperty(c, "scaleMode", {
				get: function() {
					return this._scaleMode
				},
				set: function(b) {
					this._scaleMode != b && (this._scaleMode = b, this.setResolutionPolicy())
				},
				enumerable: !0,
				configurable: !0
			});
			c.changeSize = function() {
				this._changeSizeDispatchFlag && (this.setResolutionPolicy(), this.dispatchEventWith(d.Event.RESIZE))
			};
			c.setResolutionPolicy = function() {
				var b = e.SCALE_MODE_ENUM[this._scaleMode];
				if (!b) throw Error(d.getString(1024));
				var a = new d.EqualToFrame,
					b = new d.ResolutionPolicy(a, b);
				d.StageDelegate.getInstance()._setResolutionPolicy(b);
				this._stageWidth = d.StageDelegate.getInstance()._stageWidth;
				this._stageHeight = d.StageDelegate.getInstance()._stageHeight
			};
			Object.defineProperty(c, "stageWidth", {
				get: function() {
					return this._stageWidth
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "stageHeight", {
				get: function() {
					return this._stageHeight
				},
				enumerable: !0,
				configurable: !0
			});
			c.hitTest = function(b, a, h) {
				if (!this._touchEnabled) return null;
				var c;
				if (!this._touchChildren) return this;
				h = this._children;
				for (var e = h.length - 1; 0 <= e; e--) {
					c = h[e];
					var g = c._getMatrix(),
						f = c._scrollRect;
					f && g.append(1, 0, 0, 1, -f.x, -f.y);
					g.invert();
					g = d.Matrix.transformCoords(g, b, a);
					if ((c = c.hitTest(g.x, g.y, !0)) && c._touchEnabled) return c
				}
				return this
			};
			c.getBounds = function(b) {
				b || (b = new d.Rectangle);
				return b.initialize(0, 0, this._stageWidth, this._stageHeight)
			};
			c._updateTransform = function() {
				for (var b = 0, a = this._children.length; b < a; b++) this._children[b]._updateTransform()
			};
			Object.defineProperty(c, "focus", {
				get: function() {
					return null
				},
				enumerable: !0,
				configurable: !0
			});
			e.registerScaleMode = function(b, a, h) {
				e.SCALE_MODE_ENUM[b] && !h ? d.Logger.warningWithErrorId(1009, b) : e.SCALE_MODE_ENUM[b] = a
			};
			e._invalidateRenderFlag = !1;
			e.SCALE_MODE_ENUM = {};
			return e
		}(d.DisplayObjectContainer);
	d.Stage = f;
	f.prototype.__class__ = "egret.Stage"
})(egret || (egret = {}));
egret.Stage.SCALE_MODE_ENUM[egret.StageScaleMode.NO_SCALE] = new egret.NoScale;
egret.Stage.SCALE_MODE_ENUM[egret.StageScaleMode.SHOW_ALL] = new egret.ShowAll;
egret.Stage.SCALE_MODE_ENUM[egret.StageScaleMode.NO_BORDER] = new egret.FixedWidth;
egret.Stage.SCALE_MODE_ENUM[egret.StageScaleMode.EXACT_FIT] = new egret.FullScreen;
(function(d) {
	var f = function(g) {
			function e(b) {
				void 0 === b && (b = null);
				g.call(this);
				this._lastTouchPosition = new d.Point(0, 0);
				this._touchStartPosition = new d.Point(0, 0);
				this._scrollStarted = !1;
				this._lastTouchTime = 0;
				this._lastTouchEvent = null;
				this._velocitys = [];
				this._isVTweenPlaying = this._isHTweenPlaying = !1;
				this._vScrollTween = this._hScrollTween = null;
				this.scrollBeginThreshold = 10;
				this.scrollSpeed = 1;
				this._content = null;
				this._horizontalScrollPolicy = this._verticalScrollPolicy = "auto";
				this._scrollTop = this._scrollLeft = 0;
				this._vCanScroll = this._hCanScroll = !1;
				this.touchBeginTimer = this.delayTouchBeginEvent = null;
				this.touchEnabled = !0;
				b && this.setContent(b)
			}
			__extends(e, g);
			var c = e.prototype;
			c.setContent = function(b) {
				this._content !== b && (this.removeContent(), b && (this._content = b, g.prototype.addChild.call(this, b), this._addEvents()))
			};
			c.removeContent = function() {
				this._content && (this._removeEvents(), g.prototype.removeChildAt.call(this, 0));
				this._content = null
			};
			Object.defineProperty(c, "verticalScrollPolicy", {
				get: function() {
					return this._verticalScrollPolicy
				},
				set: function(b) {
					b != this._verticalScrollPolicy && (this._verticalScrollPolicy = b)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "horizontalScrollPolicy", {
				get: function() {
					return this._horizontalScrollPolicy
				},
				set: function(b) {
					b != this._horizontalScrollPolicy && (this._horizontalScrollPolicy = b)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "scrollLeft", {
				get: function() {
					return this._scrollLeft
				},
				set: function(b) {
					b != this._scrollLeft && (this._scrollLeft = b, this._validatePosition(!1, !0), this._updateContentPosition())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "scrollTop", {
				get: function() {
					return this._scrollTop
				},
				set: function(b) {
					b != this._scrollTop && (this._scrollTop = b, this._validatePosition(!0, !1), this._updateContentPosition())
				},
				enumerable: !0,
				configurable: !0
			});
			c.setScrollPosition = function(b, a, h) {
				void 0 === h && (h = !1);
				if (!h || 0 != b || 0 != a) if (h || this._scrollTop != b || this._scrollLeft != a) {
					if (h) {
						h = this._isOnTheEdge(!0);
						var c = this._isOnTheEdge(!1);
						this._scrollTop += h ? b / 2 : b;
						this._scrollLeft += c ? a / 2 : a
					} else this._scrollTop = b, this._scrollLeft = a;
					this._validatePosition(!0, !0);
					this._updateContentPosition()
				}
			};
			c._isOnTheEdge = function(b) {
				void 0 === b && (b = !0);
				var a = this._scrollTop,
					h = this._scrollLeft;
				return b ? 0 > a || a > this.getMaxScrollTop() : 0 > h || h > this.getMaxScrollLeft()
			};
			c._validatePosition = function(b, a) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				if (b) {
					var h = this.height,
						c = this._getContentHeight();
					this._scrollTop = Math.max(this._scrollTop, (0 - h) / 2);
					this._scrollTop = Math.min(this._scrollTop, c > h ? c - h / 2 : h / 2)
				}
				a && (h = this.width, c = this._getContentWidth(), this._scrollLeft = Math.max(this._scrollLeft, (0 - h) / 2), this._scrollLeft = Math.min(this._scrollLeft, c > h ? c - h / 2 : h / 2))
			};
			c._setWidth = function(b) {
				this._explicitWidth != b && (g.prototype._setWidth.call(this, b), this._updateContentPosition())
			};
			c._setHeight = function(b) {
				this._explicitHeight != b && (g.prototype._setHeight.call(this, b), this._updateContentPosition())
			};
			c._updateContentPosition = function() {
				var b = this.getBounds(d.Rectangle.identity);
				this.scrollRect = new d.Rectangle(this._scrollLeft, this._scrollTop, b.width, b.height);
				this.dispatchEvent(new d.Event(d.Event.CHANGE))
			};
			c._checkScrollPolicy = function() {
				var b = this.__checkScrollPolicy(this._horizontalScrollPolicy, this._getContentWidth(), this.width);
				this._hCanScroll = b;
				var a = this.__checkScrollPolicy(this._verticalScrollPolicy, this._getContentHeight(), this.height);
				this._vCanScroll = a;
				return b || a
			};
			c.__checkScrollPolicy = function(b, a, h) {
				return "on" == b ? !0 : "off" == b ? !1 : a > h
			};
			c._addEvents = function() {
				this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this._onTouchBegin, this);
				this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this._onTouchBeginCapture, this, !0);
				this.addEventListener(d.TouchEvent.TOUCH_END, this._onTouchEndCapture, this, !0)
			};
			c._removeEvents = function() {
				this.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this._onTouchBegin, this);
				this.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this._onTouchBeginCapture, this, !0);
				this.removeEventListener(d.TouchEvent.TOUCH_END, this._onTouchEndCapture, this, !0)
			};
			c._onTouchBegin = function(b) {
				!b._isDefaultPrevented && this._checkScrollPolicy() && (this._touchStartPosition.x = b.stageX, this._touchStartPosition.y = b.stageY, (this._isHTweenPlaying || this._isVTweenPlaying) && this._onScrollFinished(), this.stage.addEventListener(d.TouchEvent.TOUCH_MOVE, this._onTouchMove, this), this.stage.addEventListener(d.TouchEvent.TOUCH_END, this._onTouchEnd, this), this.stage.addEventListener(d.TouchEvent.LEAVE_STAGE, this._onTouchEnd, this), this.addEventListener(d.Event.ENTER_FRAME, this._onEnterFrame, this), this._logTouchEvent(b), b.preventDefault())
			};
			c._onTouchBeginCapture = function(b) {
				var a = this._checkScrollPolicy();
				if (a) {
					for (var h = b.target; h != this;) {
						if ("_checkScrollPolicy" in h && (a = h._checkScrollPolicy())) return;
						h = h.parent
					}
					b.stopPropagation();
					this.delayTouchBeginEvent = this.cloneTouchEvent(b);
					this.touchBeginTimer || (this.touchBeginTimer = new d.Timer(100, 1), this.touchBeginTimer.addEventListener(d.TimerEvent.TIMER_COMPLETE, this._onTouchBeginTimer, this));
					this.touchBeginTimer.start();
					this._onTouchBegin(b)
				}
			};
			c._onTouchEndCapture = function(b) {
				this.delayTouchBeginEvent && this._onTouchBeginTimer()
			};
			c._onTouchBeginTimer = function() {
				this.touchBeginTimer.stop();
				var b = this.delayTouchBeginEvent;
				this.delayTouchBeginEvent = null;
				this.stage && this.dispatchPropagationEvent(b)
			};
			c.dispatchPropagationEvent = function(b) {
				for (var a = [], h = b._target, c = 0; h;) h == this && (c = a.length), a.push(h), h = h.parent;
				h = a.slice(0, c);
				h = h.reverse();
				a = h.concat(a);
				this._dispatchPropagationEvent(b, a, c)
			};
			c._dispatchPropagationEvent = function(b, a, h) {
				for (var c = a.length, e = 0; e < c; e++) {
					var d = a[e];
					b._currentTarget = d;
					b._eventPhase = e < h ? 1 : e == h ? 2 : 3;
					d._notifyListener(b);
					if (b._isPropagationStopped || b._isPropagationImmediateStopped) break
				}
			};
			c._onTouchMove = function(b) {
				if (this._lastTouchPosition.x != b.stageX || this._lastTouchPosition.y != b.stageY) {
					if (!this._scrollStarted) {
						var a = b.stageX - this._touchStartPosition.x,
							h = b.stageY - this._touchStartPosition.y;
						if (Math.sqrt(a * a + h * h) < this.scrollBeginThreshold) {
							this._logTouchEvent(b);
							return
						}
					}
					this._scrollStarted = !0;
					this.delayTouchBeginEvent && (this.delayTouchBeginEvent = null, this.touchBeginTimer.stop());
					this.touchChildren = !1;
					a = this._getPointChange(b);
					this.setScrollPosition(a.y, a.x, !0);
					this._calcVelocitys(b);
					this._logTouchEvent(b)
				}
			};
			c._onTouchEnd = function(b) {
				this.touchChildren = !0;
				this._scrollStarted = !1;
				d.MainContext.instance.stage.removeEventListener(d.TouchEvent.TOUCH_MOVE, this._onTouchMove, this);
				d.MainContext.instance.stage.removeEventListener(d.TouchEvent.TOUCH_END, this._onTouchEnd, this);
				d.MainContext.instance.stage.removeEventListener(d.TouchEvent.LEAVE_STAGE, this._onTouchEnd, this);
				this.removeEventListener(d.Event.ENTER_FRAME, this._onEnterFrame, this);
				this._moveAfterTouchEnd()
			};
			c._onEnterFrame = function(b) {
				b = d.getTimer();
				100 < b - this._lastTouchTime && 300 > b - this._lastTouchTime && this._calcVelocitys(this._lastTouchEvent)
			};
			c._logTouchEvent = function(b) {
				this._lastTouchPosition.x = b.stageX;
				this._lastTouchPosition.y = b.stageY;
				this._lastTouchEvent = this.cloneTouchEvent(b);
				this._lastTouchTime = d.getTimer()
			};
			c._getPointChange = function(b) {
				return {
					x: !1 === this._hCanScroll ? 0 : this._lastTouchPosition.x - b.stageX,
					y: !1 === this._vCanScroll ? 0 : this._lastTouchPosition.y - b.stageY
				}
			};
			c._calcVelocitys = function(b) {
				var a = d.getTimer();
				if (0 == this._lastTouchTime) this._lastTouchTime = a;
				else {
					var h = this._getPointChange(b),
						a = a - this._lastTouchTime;
					h.x /= a;
					h.y /= a;
					this._velocitys.push(h);
					5 < this._velocitys.length && this._velocitys.shift();
					this._lastTouchPosition.x = b.stageX;
					this._lastTouchPosition.y = b.stageY
				}
			};
			c._getContentWidth = function() {
				return this._content.explicitWidth || this._content.width
			};
			c._getContentHeight = function() {
				return this._content.explicitHeight || this._content.height
			};
			c.getMaxScrollLeft = function() {
				var b = this._getContentWidth() - this.width;
				return Math.max(0, b)
			};
			c.getMaxScrollTop = function() {
				var b = this._getContentHeight() - this.height;
				return Math.max(0, b)
			};
			c._moveAfterTouchEnd = function() {
				if (0 != this._velocitys.length) {
					for (var b = 0, a = 0, h = 0, c = 0; c < this._velocitys.length; c++) var d = this._velocitys[c],
						g = e.weight[c],
						b = b + d.x * g,
						a = a + d.y * g,
						h = h + g;
					this._velocitys.length = 0;
					0 >= this.scrollSpeed && (this.scrollSpeed = 1);
					b = b / h * this.scrollSpeed;
					a = a / h * this.scrollSpeed;
					d = Math.abs(b);
					h = Math.abs(a);
					g = this.getMaxScrollLeft();
					c = this.getMaxScrollTop();
					b = 0.02 < d ? this.getAnimationDatas(b, this._scrollLeft, g) : {
						position: this._scrollLeft,
						duration: 1
					};
					a = 0.02 < h ? this.getAnimationDatas(a, this._scrollTop, c) : {
						position: this._scrollTop,
						duration: 1
					};
					this.setScrollLeft(b.position, b.duration);
					this.setScrollTop(a.position, a.duration)
				}
			};
			c._onTweenFinished = function(b) {
				b == this._vScrollTween && (this._isVTweenPlaying = !1);
				b == this._hScrollTween && (this._isHTweenPlaying = !1);
				!1 == this._isHTweenPlaying && !1 == this._isVTweenPlaying && this._onScrollFinished()
			};
			c._onScrollStarted = function() {};
			c._onScrollFinished = function() {
				d.Tween.removeTweens(this);
				this._vScrollTween = this._hScrollTween = null;
				this._isVTweenPlaying = this._isHTweenPlaying = !1;
				this.dispatchEvent(new d.Event(d.Event.COMPLETE))
			};
			c.setScrollTop = function(b, a) {
				void 0 === a && (a = 0);
				var h = Math.min(this.getMaxScrollTop(), Math.max(b, 0));
				if (0 == a) return this.scrollTop = h, null;
				var c = d.Tween.get(this).to({
					scrollTop: b
				}, a, d.Ease.quartOut);
				h != b && c.to({
					scrollTop: h
				}, 300, d.Ease.quintOut);
				this._isVTweenPlaying = !0;
				this._vScrollTween = c;
				c.call(this._onTweenFinished, this, [c]);
				this._isHTweenPlaying || this._onScrollStarted();
				return c
			};
			c.setScrollLeft = function(b, a) {
				void 0 === a && (a = 0);
				var h = Math.min(this.getMaxScrollLeft(), Math.max(b, 0));
				if (0 == a) return this.scrollLeft = h, null;
				var c = d.Tween.get(this).to({
					scrollLeft: b
				}, a, d.Ease.quartOut);
				h != b && c.to({
					scrollLeft: h
				}, 300, d.Ease.quintOut);
				this._isHTweenPlaying = !0;
				this._hScrollTween = c;
				c.call(this._onTweenFinished, this, [c]);
				this._isVTweenPlaying || this._onScrollStarted();
				return c
			};
			c.getAnimationDatas = function(b, a, h) {
				var c = Math.abs(b),
					e = 0,
					d = a + 500 * b;
				if (0 > d || d > h) for (d = a; Infinity != Math.abs(b) && 0.02 < Math.abs(b);) d += b, b = 0 > d || d > h ? 0.998 * b * 0.95 : 0.998 * b, e++;
				else e = 500 * -Math.log(0.02 / c);
				return {
					position: Math.min(h + 50, Math.max(d, -50)),
					duration: e
				}
			};
			c.cloneTouchEvent = function(b) {

				var a = new d.TouchEvent(b._type, b._bubbles, b.cancelable);
				a.touchPointID = b.touchPointID;
				a._stageX = b._stageX;
				a._stageY = b._stageY;
				a.ctrlKey = b.ctrlKey;
				a.altKey = b.altKey;
				a.shiftKey = b.shiftKey;
				a.touchDown = b.touchDown;
				a._isDefaultPrevented = !1;
				a._target = b._target;
				return a
			};
			c.throwNotSupportedError = function() {
				throw Error(d.getString(1023));
			};
			c.addChild = function(b) {
				this.throwNotSupportedError();
				return null
			};
			c.addChildAt = function(b, a) {
				this.throwNotSupportedError();
				return null
			};
			c.removeChild = function(b) {
				this.throwNotSupportedError();
				return null
			};
			c.removeChildAt = function(b) {
				this.throwNotSupportedError();
				return null
			};
			c.setChildIndex = function(b, a) {
				this.throwNotSupportedError()
			};
			c.swapChildren = function(b, a) {
				this.throwNotSupportedError()
			};
			c.swapChildrenAt = function(b, a) {
				this.throwNotSupportedError()
			};
			c.hitTest = function(b, a, h) {
				void 0 === h && (h = !1);
				var c = g.prototype.hitTest.call(this, b, a, h);
				return c ? c : d.DisplayObject.prototype.hitTest.call(this, b, a, h)
			};
			e.weight = [1, 1.33, 1.66, 2, 2.33];
			return e
		}(d.DisplayObjectContainer);
	d.ScrollView = f;
	f.prototype.__class__ = "egret.ScrollView"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.REPEAT = "repeat";
			d.SCALE = "scale";
			return d
		}();
	d.BitmapFillMode = f;
	f.prototype.__class__ = "egret.BitmapFillMode"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e(b) {
				g.call(this);
				this.scale9Grid = this._texture = null;
				this.fillMode = "scale";
				b && (this._texture = b, this._setSizeDirty());
				this.needDraw = !0
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "texture", {
				get: function() {
					return this._texture
				},
				set: function(b) {
					b != this._texture && (this._setSizeDirty(), this._texture = b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._render = function(b) {
				var a = this._texture;
				a ? (this._texture_to_render = a, e._drawBitmap(b, this._hasWidthSet ? this._explicitWidth : a._textureWidth, this._hasHeightSet ? this._explicitHeight : a._textureHeight, this)) : this._texture_to_render = null
			};
			e._drawBitmap = function(b, a, h, c) {
				var d = c._texture_to_render;
				if (d) {
					var g = d._textureWidth,
						f = d._textureHeight;
					if ("scale" == c.fillMode) {
						var k = c.scale9Grid || d.scale9Grid;
						if (k && g - k.width < a && f - k.height < h) e.drawScale9GridImage(b, c, k, a, h);
						else {
							var k = d._offsetX,
								l = d._offsetY,
								m = d._bitmapWidth || g,
								n = d._bitmapHeight || f;
							a /= g;
							k = Math.round(k * a);
							a = Math.round(m * a);
							h /= f;
							l = Math.round(l * h);
							h = Math.round(n * h);
							e.renderFilter.drawImage(b, c, d._bitmapX, d._bitmapY, m, n, k, l, a, h)
						}
					} else e.drawRepeatImage(b, c, a, h, c.fillMode)
				}
			};
			e.drawRepeatImage = function(b, a, h, c, e) {
				var g = a._texture_to_render;
				if (g) {
					var f = g._textureWidth,
						k = g._textureHeight,
						l = g._bitmapX,
						m = g._bitmapY,
						f = g._bitmapWidth || f,
						k = g._bitmapHeight || k,
						n = g._offsetX,
						g = g._offsetY;
					d.RenderFilter.getInstance().drawImage(b, a, l, m, f, k, n, g, h, c, e)
				}
			};
			e.drawScale9GridImage = function(b, a, h, c, e) {
				var g = d.MainContext.instance.rendererContext._texture_scale_factor,
					f = a._texture_to_render;
				if (f && h) {
					var k = f._textureWidth,
						l = f._textureHeight,
						m = f._bitmapX,
						n = f._bitmapY,
						p = f._bitmapWidth || k,
						q = f._bitmapHeight || l;
					c -= k - p;
					e -= l - q;
					if (!b.drawImageScale9(f, m, n, p, q, f._offsetX, f._offsetY, c, e, h)) {
						k = f._offsetX / g;
						l = f._offsetY / g;
						f = d.RenderFilter.getInstance();
						h = d.Rectangle.identity.initialize(h.x - Math.round(k), h.y - Math.round(k), h.width, h.height);
						k = Math.round(k);
						l = Math.round(l);
						h.y == h.bottom && (h.bottom < q ? h.bottom++ : h.y--);
						h.x == h.right && (h.right < p ? h.right++ : h.x--);
						var x = m + h.x / g,
							z = m + h.right / g,
							t = p - h.right,
							y = n + h.y / g,
							g = n + h.bottom / g,
							w = q - h.bottom,
							A = k + h.x,
							v = l + h.y,
							q = e - (q - h.bottom),
							p = c - (p - h.right);
						f.drawImage(b, a, m, n, h.x, h.y, k, l, h.x, h.y);
						f.drawImage(b, a, x, n, h.width, h.y, A, l, p - h.x, h.y);
						f.drawImage(b, a, z, n, t, h.y, k + p, l, c - p, h.y);
						f.drawImage(b, a, m, y, h.x, h.height, k, v, h.x, q - h.y);
						f.drawImage(b, a, x, y, h.width, h.height, A, v, p - h.x, q - h.y);
						f.drawImage(b, a, z, y, t, h.height, k + p, v, c - p, q - h.y);
						f.drawImage(b, a, m, g, h.x, w, k, l + q, h.x, e - q);
						f.drawImage(b, a, x, g, h.width, w, A, l + q, p - h.x, e - q);
						f.drawImage(b, a, z, g, t, w, k + p, l + q, c - p, e - q)
					}
				}
			};
			c._measureBounds = function() {
				var b = this._texture;
				return b ? d.Rectangle.identity.initialize(0, 0, b._textureWidth, b._textureHeight) : g.prototype._measureBounds.call(this)
			};
			e.renderFilter = d.RenderFilter.getInstance();
			return e
		}(d.DisplayObject);
	d.Bitmap = f;
	f.prototype.__class__ = "egret.Bitmap"
})(egret || (egret = {}));
(function(d) {
	var f = function(g) {
			function e() {
				g.call(this);
				this._text = "";
				this._textChanged = !1;
				this._font = null;
				this._fontChanged = !1;
				this._textOffsetY = this._textOffsetX = this._textHeight = this._textWidth = 0;
				this.textLinesChange = !0;
				this._lineHeights = [];
				this.needDraw = this.cacheAsBitmap = !0
			}
			__extends(e, g);
			var c = e.prototype;
			Object.defineProperty(c, "text", {
				get: function() {
					return this._text
				},
				set: function(b) {
					this._text != b && (this._textChanged = !0, this._text = b, this._setSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "font", {
				get: function() {
					return this._font
				},
				set: function(b) {
					this._font != b && (this._font = b, this._fontChanged = !0, this._setSizeDirty())
				},
				enumerable: !0,
				configurable: !0
			});
			c._setSizeDirty = function() {
				g.prototype._setSizeDirty.call(this);
				this.textLinesChange = !0
			};
			c._render = function(b) {
				var a = this._getTextLines(),
					h = a.length;
				if (0 != h) {
					for (var c = this._font, g = c._getFirstCharHeight(), g = Math.ceil(g * e.EMPTY_FACTOR), f = 0, r = this._hasHeightSet ? this._explicitHeight : Number.POSITIVE_INFINITY, k = this._lineHeights, l = 0; l < h; l++) {
						var m = k[l];
						if (0 < l && f + m > r) break;
						for (var n = a[l], p = n.length, q = 0, x = 0; x < p; x++) {
							var z = n.charAt(x),
								t = c.getTexture(z);
							if (t) {
								var z = t._bitmapWidth || t._textureWidth,
									y = t._bitmapHeight || t._textureHeight;
								this._texture_to_render = t;
								d.RenderFilter.getInstance().drawImage(b, this, t._bitmapX, t._bitmapY, z, y, q + t._offsetX, f + t._offsetY, z, y);
								q += t._textureWidth
							} else " " == z ? q += g : d.Logger.warningWithErrorId(1011, z)
						}
						f += m
					}
					this._texture_to_render = null
				}
			};
			c._measureBounds = function() {
				return 0 == this._getTextLines().length ? d.Rectangle.identity.initialize(0, 0, 0, 0) : d.Rectangle.identity.initialize(this._textOffsetX, this._textOffsetY, this._textWidth - this._textOffsetX, this._textHeight - this._textOffsetY)
			};
			c._getTextLines = function() {
				if (!this.textLinesChange) return this._textLines;
				var b = [];
				this._textLines = b;
				this.textLinesChange = !1;
				var a = [];
				this._lineHeights = a;
				if (!this._text || !this._font) return b;
				for (var h = 0, c = 0, g = 0, f = 0, r = this._hasWidthSet, k = this._hasWidthSet ? this._explicitWidth : Number.POSITIVE_INFINITY, l = this._font, m = l._getFirstCharHeight(), n = Math.ceil(m * e.EMPTY_FACTOR), p = this._text.split(/(?:\r\n|\r|\n)/), q = p.length, x = !0, z = 0; z < q; z++) {
					for (var t = p[z], y = t.length, w = 0, A = 0, v = !0, F = 0; F < y; F++) {
						var C = t.charAt(F),
							E, B = 0,
							H = 0,
							G = l.getTexture(C);
						if (G) C = G._textureWidth, E = G._textureHeight, B = G._offsetX, H = G._offsetY;
						else if (" " == C) C = n, E = m;
						else {
							d.Logger.warningWithErrorId(1011, C);
							v && (v = !1);
							continue
						}
						v && (v = !1, g = Math.min(B, g));
						x && (f = Math.min(H, f));
						r && 0 < F && A + C > k ? (b.push(t.substring(0, F)), a.push(w), c += w, h = Math.max(A, h), t = t.substring(F), y = t.length, F = 0, A = C, w = E) : (A += C, w = Math.max(E, w))
					}
					x && (x = !1);
					b.push(t);
					a.push(w);
					c += w;
					h = Math.max(A, h)
				}
				this._textWidth = h;
				this._textHeight = c;
				this._textOffsetX = g;
				this._textOffsetY = f;
				return b
			};
			e.EMPTY_FACTOR = 0.33;
			return e
		}(d.DisplayObject);
	d.BitmapText = f;
	f.prototype.__class__ = "egret.BitmapText"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function g() {
				this.fillStyleColor = this.strokeStyleColor = this.renderContext = this.commandQueue = this.canvasContext = null;
				this._dirty = !1;
				this.lineY = this.lineX = 0;
				this._firstCheck = !0;
				this._lastY = this._lastX = this._maxY = this._maxX = this._minY = this._minX = 0;
				this.commandQueue = []
			}
			var e = g.prototype;
			e.beginFill = function(c, b) {};
			e._setStyle = function(c) {};
			e.drawRect = function(c, b, a, h) {
				this.checkRect(c, b, a, h)
			};
			e.drawCircle = function(c, b, a) {
				this.checkRect(c - a, b - a, 2 * a, 2 * a)
			};
			e.drawRoundRect = function(c, b, a, h, e, d) {
				this.checkRect(c, b, a, h)
			};
			e.drawEllipse = function(c, b, a, h) {
				this.checkRect(c - a, b - h, 2 * a, 2 * h)
			};
			e.lineStyle = function(c, b, a, h, e, d, g, f) {};
			e.lineTo = function(c, b) {
				this.checkPoint(c, b)
			};
			e.curveTo = function(c, b, a, h) {
				this.checkPoint(c, b);
				this.checkPoint(a, h)
			};
			e.moveTo = function(c, b) {
				this.checkPoint(c, b)
			};
			e.clear = function() {
				this._maxY = this._maxX = this._minY = this._minX = 0;
				this._firstCheck = !0
			};
			e.endFill = function() {};
			e._draw = function(c) {};
			e.checkRect = function(c, b, a, h) {
				this._firstCheck ? (this._firstCheck = !1, this._minX = c, this._minY = b, this._maxX = c + a, this._maxY = b + h) : (this._minX = Math.min(this._minX, c), this._minY = Math.min(this._minY, b), this._maxX = Math.max(this._maxX, c + a), this._maxY = Math.max(this._maxY, b + h))
			};
			e.checkPoint = function(c, b) {
				this._firstCheck ? (this._firstCheck = !1, this._minX = c, this._minY = b, this._maxX = c, this._maxY = b) : (this._minX = Math.min(this._minX, c), this._minY = Math.min(this._minY, b), this._maxX = Math.max(this._maxX, c), this._maxY = Math.max(this._maxY, b));
				this._lastX = c;
				this._lastY = b
			};
			e._measureBounds = function() {
				return d.Rectangle.identity.initialize(this._minX, this._minY, this._maxX - this._minX, this._maxY - this._minY)
			};
			return g
		}();
	d.Graphics = f;
	f.prototype.__class__ = "egret.Graphics";
	(function() {
		return function(d, e, c) {
			this.method = d;
			this.thisObject = e;
			this.args = c
		}
	})().prototype.__class__ = "egret.Command"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._graphics = null
			}
			__extends(e, f);
			var c = e.prototype;
			Object.defineProperty(c, "graphics", {
				get: function() {
					this._graphics || (this._graphics = new d.Graphics, this.needDraw = !0);
					return this._graphics
				},
				enumerable: !0,
				configurable: !0
			});
			c._render = function(b) {
				this._graphics && this._graphics._draw(b)
			};
			c._measureBounds = function() {
				var b = this._graphics;
				return b ? b._measureBounds() : f.prototype._measureBounds.call(this)
			};
			return e
		}(d.DisplayObject);
	d.Shape = f;
	f.prototype.__class__ = "egret.Shape"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._graphics = null
			}
			__extends(e, f);
			var c = e.prototype;
			Object.defineProperty(c, "graphics", {
				get: function() {
					this._graphics || (this._graphics = new d.Graphics, this.needDraw = !0);
					return this._graphics
				},
				enumerable: !0,
				configurable: !0
			});
			c._render = function(b) {
				this._graphics && this._graphics._draw(b);
				f.prototype._render.call(this, b)
			};
			c._measureBounds = function() {
				for (var b = 0, a = 0, h = 0, c = 0, e = this._children.length, f = 0; f < e; f++) {
					var g = this._children[f];
					if (g._visible) {
						var k = g.getBounds(d.Rectangle.identity, !1),
							l = k.x,
							m = k.y,
							n = k.width,
							k = k.height,
							g = g._getMatrix(),
							g = d.DisplayObject.getTransformBounds(d.Rectangle.identity.initialize(l, m, n, k), g),
							l = g.x,
							m = g.y,
							n = g.width + g.x,
							g = g.height + g.y;
						if (l < b || 0 == f) b = l;
						if (n > a || 0 == f) a = n;
						if (m < h || 0 == f) h = m;
						if (g > c || 0 == f) c = g
					}
				}
				if (this._graphics) {
					e = this._graphics._measureBounds();
					l = e.x;
					m = e.y;
					n = e.width + e.x;
					g = e.height + e.y;
					if (l < b || 0 == f) b = l;
					if (n > a || 0 == f) a = n;
					if (m < h || 0 == f) h = m;
					if (g > c || 0 == f) c = g
				}
				return d.Rectangle.identity.initialize(b, h, a - b, c - h)
			};
			c.hitTest = function(b, a, h) {
				void 0 === h && (h = !1);
				var c = f.prototype.hitTest.call(this, b, a, h);
				return c ? c : this._graphics ? d.DisplayObject.prototype.hitTest.call(this, b, a, h) : null
			};
			return e
		}(d.DisplayObjectContainer);
	d.Sprite = f;
	f.prototype.__class__ = "egret.Sprite"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f() {}
			f._getStartLine = function(e) {
				var c = f._getTextHeight(e),
					b = 0;
				e._hasHeightSet && (!(c < e._explicitHeight) && c > e._explicitHeight && (b = Math.max(e._properties._scrollV - 1, 0), b = Math.min(e._properties._numLines - 1, b)), e._properties._multiline || (b = Math.max(e._properties._scrollV - 1, 0), b = Math.min(e._properties._numLines - 1, b)));
				return b
			};
			f._getHalign = function(e) {
				var c = e._getLinesArr(),
					b = 0;
				e._properties._textAlign == d.HorizontalAlign.CENTER ? b = 0.5 : e._properties._textAlign == d.HorizontalAlign.RIGHT && (b = 1);
				e._properties._type == d.TextFieldType.INPUT && !e._properties._multiline && 1 < c.length && (b = 0);
				return b
			};
			f._getTextHeight = function(e) {
				return d.TextFieldType.INPUT != e._properties._type || e._properties._multiline ? e._properties._textMaxHeight + (e._properties._numLines - 1) * e._properties._lineSpacing : e._properties._size
			};
			f._getValign = function(e) {
				var c = f._getTextHeight(e);
				return e._properties._type == d.TextFieldType.INPUT ? e._properties._multiline ? 0 : 0.5 : e._hasHeightSet && c < e._explicitHeight ? (c = 0, e._properties._verticalAlign == d.VerticalAlign.MIDDLE ? c = 0.5 : e._properties._verticalAlign == d.VerticalAlign.BOTTOM && (c = 1), c) : 0
			};
			f._getTextElement = function(e, c, b) {
				c = f._getHit(e, c, b);
				e = e._getLinesArr();
				return c && e[c.lineIndex] && e[c.lineIndex].elements[c.textElementIndex] ? e[c.lineIndex].elements[c.textElementIndex] : null
			};
			f._getHit = function(e, c, b) {
				var a = e._getLinesArr();
				if (0 == e._properties._textMaxWidth) return null;
				for (var h = 0, d = 0, f = 0; f < a.length; f++) {
					var g = a[f];
					if (d + g.height >= b) {
						h = f + 1;
						break
					} else d += g.height;
					if (d + e._properties._lineSpacing > b) return null;
					d += e._properties._lineSpacing
				}
				if (0 === h) return null;
				e = a[h - 1];
				for (f = b = 0; f < e.elements.length; f++) if (a = e.elements[f], b + a.width < c) b += a.width;
				else return {
					lineIndex: h - 1,
					textElementIndex: f
				};
				return null
			};
			f._getScrollNum = function(e) {
				var c = 1;
				if (e._properties._multiline) {
					var b = e.height,
						a = e.size;
					e = e.lineSpacing;
					c = Math.floor(b / (a + e));
					b - (a + e) * c > a / 2 && c++
				}
				return c
			};
			return f
		}();
	d.TextFieldUtils = f;
	f.prototype.__class__ = "egret.TextFieldUtils"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			return function() {
				this._text = this._type = "";
				this._displayAsPassword = !1;
				this._fontFamily = d.TextField.default_fontFamily;
				this._size = 30;
				this._bold = this._italic = !1;
				this._textColorString = "#FFFFFF";
				this._textColor = 16777215;
				this._strokeColorString = "#000000";
				this._stroke = this._strokeColor = 0;
				this._border = !1;
				this._borderColor = 0;
				this._background = !1;
				this._backgroundColor = 16777215;
				this._textAlign = "left";
				this._verticalAlign = "top";
				this._maxChars = this._textMaxHeight = this._textMaxWidth = 0;
				this._scrollV = -1;
				this._numLines = this._lineSpacing = 0;
				this._multiline = !1
			}
		}();
	d.TextFieldProperties = f;
	f.prototype.__class__ = "egret.TextFieldProperties"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._inputEnabled = !1;
				this._bgGraphics = this._inputUtils = null;
				this._isFlow = !1;
				this._textArr = [];
				this._isArrayChanged = !1;
				this._linesArr = [];
				this._isTyping = !1;
				this.needDraw = !0;
				this._properties = new d.TextFieldProperties
			}
			__extends(e, f);
			var c = e.prototype;
			c.isInput = function() {
				return this._properties._type == d.TextFieldType.INPUT
			};
			c._setTouchEnabled = function(b) {
				f.prototype._setTouchEnabled.call(this, b);
				this.isInput() && (this._inputEnabled = !0)
			};
			Object.defineProperty(c, "type", {
				get: function() {
					return this._properties._type
				},
				set: function(b) {
					this._setType(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setType = function(b) {
				var a = this._properties;
				a._type != b && (a._type = b, a._type == d.TextFieldType.INPUT ? (this._hasWidthSet || this._setWidth(100), this._hasHeightSet || this._setHeight(30), null == this._inputUtils && (this._inputUtils = new d.InputController), this._inputUtils.init(this), this._setDirty(), this._stage && this._inputUtils._addStageText()) : this._inputUtils && (this._inputUtils._removeStageText(), this._inputUtils = null))
			};
			Object.defineProperty(c, "text", {
				get: function() {
					return this._getText()
				},
				set: function(b) {
					this._setText(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._getText = function() {
				return this._properties._type == d.TextFieldType.INPUT ? this._inputUtils._getText() : this._properties._text
			};
			c._setSizeDirty = function() {
				f.prototype._setSizeDirty.call(this);
				this._isArrayChanged = !0
			};
			c._setTextDirty = function() {
				this._setSizeDirty()
			};
			c._setBaseText = function(b) {
				null == b && (b = "");
				var a = this._properties;
				this._isFlow = !1;
				a._text != b && (this._setTextDirty(), a._text = b, b = "", b = a._displayAsPassword ? this.changeToPassText(a._text) : a._text, this.setMiddleStyle([{
					text: b
				}]))
			};
			c._setText = function(b) {
				null == b && (b = "");
				this._setBaseText(b);
				this._inputUtils && this._inputUtils._setText(this._properties._text)
			};
			Object.defineProperty(c, "displayAsPassword", {
				get: function() {
					return this._properties._displayAsPassword
				},
				set: function(b) {
					this._setDisplayAsPassword(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setDisplayAsPassword = function(b) {
				var a = this._properties;
				a._displayAsPassword != b && (a._displayAsPassword = b, this._setTextDirty(), b = "", b = a._displayAsPassword ? this.changeToPassText(a._text) : a._text, this.setMiddleStyle([{
					text: b
				}]))
			};
			Object.defineProperty(c, "fontFamily", {
				get: function() {
					return this._properties._fontFamily
				},
				set: function(b) {
					this._setFontFamily(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setFontFamily = function(b) {
				this._properties._fontFamily != b && (this._setTextDirty(), this._properties._fontFamily = b)
			};
			Object.defineProperty(c, "size", {
				get: function() {
					return this._properties._size
				},
				set: function(b) {
					this._setSize(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setSize = function(b) {
				this._properties._size != b && (this._setTextDirty(), this._properties._size = b)
			};
			Object.defineProperty(c, "italic", {
				get: function() {
					return this._properties._italic
				},
				set: function(b) {
					this._setItalic(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setItalic = function(b) {
				this._properties._italic != b && (this._setTextDirty(), this._properties._italic = b)
			};
			Object.defineProperty(c, "bold", {
				get: function() {
					return this._properties._bold
				},
				set: function(b) {
					this._setBold(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setBold = function(b) {
				this._properties._bold != b && (this._setTextDirty(), this._properties._bold = b)
			};
			Object.defineProperty(c, "textColor", {
				get: function() {
					return this._properties._textColor
				},
				set: function(b) {
					this._setTextColor(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setTextColor = function(b) {
				this._properties._textColor != b && (this._setTextDirty(), this._properties._textColor = b, this._properties._textColorString = d.toColorString(b))
			};
			Object.defineProperty(c, "strokeColor", {
				get: function() {
					return this._properties._strokeColor
				},
				set: function(b) {
					this._setStrokeColor(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setStrokeColor = function(b) {
				this._properties._strokeColor != b && (this._setTextDirty(), this._properties._strokeColor = b, this._properties._strokeColorString = d.toColorString(b))
			};
			Object.defineProperty(c, "stroke", {
				get: function() {
					return this._properties._stroke
				},
				set: function(b) {
					this._setStroke(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setStroke = function(b) {
				this._properties._stroke != b && (this._setTextDirty(), this._properties._stroke = b)
			};
			Object.defineProperty(c, "textAlign", {
				get: function() {
					return this._properties._textAlign
				},
				set: function(b) {
					this._setTextAlign(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setTextAlign = function(b) {
				this._properties._textAlign != b && (this._setTextDirty(), this._properties._textAlign = b)
			};
			Object.defineProperty(c, "verticalAlign", {
				get: function() {
					return this._properties._verticalAlign
				},
				set: function(b) {
					this._setVerticalAlign(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setVerticalAlign = function(b) {
				this._properties._verticalAlign != b && (this._setTextDirty(), this._properties._verticalAlign = b)
			};
			Object.defineProperty(c, "maxChars", {
				get: function() {
					return this._properties._maxChars
				},
				set: function(b) {
					this._setMaxChars(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setMaxChars = function(b) {
				this._properties._maxChars != b && (this._properties._maxChars = b)
			};
			Object.defineProperty(c, "scrollV", {
				get: function() {
					return Math.min(Math.max(this._properties._scrollV, 1), this.maxScrollV)
				},
				set: function(b) {
					this._properties._scrollV = Math.max(b, 1);
					this._setDirty()
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "maxScrollV", {
				get: function() {
					this._getLinesArr();
					return Math.max(this._properties._numLines - d.TextFieldUtils._getScrollNum(this) + 1, 1)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "selectionBeginIndex", {
				get: function() {
					return 0
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "selectionEndIndex", {
				get: function() {
					return 0
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "caretIndex", {
				get: function() {
					return 0
				},
				enumerable: !0,
				configurable: !0
			});
			c._setSelection = function(b, a) {};
			Object.defineProperty(c, "lineSpacing", {
				get: function() {
					return this._properties._lineSpacing
				},
				set: function(b) {
					this._setLineSpacing(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setLineSpacing = function(b) {
				this._properties._lineSpacing != b && (this._setTextDirty(), this._properties._lineSpacing = b)
			};
			c._getLineHeight = function() {
				return this._properties._lineSpacing + this._properties._size
			};
			Object.defineProperty(c, "numLines", {
				get: function() {
					return this._properties._numLines
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "multiline", {
				get: function() {
					return this._properties._multiline
				},
				set: function(b) {
					this._setMultiline(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setMultiline = function(b) {
				this._properties._multiline = b;
				this._setDirty()
			};
			c._setWidth = function(b) {
				f.prototype._setWidth.call(this, b);
				this.fillBackground()
			};
			c._setHeight = function(b) {
				f.prototype._setHeight.call(this, b);
				this.fillBackground()
			};
			Object.defineProperty(c, "border", {
				get: function() {
					return this._properties._border
				},
				set: function(b) {
					this._properties._border = b;
					this.fillBackground()
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "borderColor", {
				get: function() {
					return this._properties._borderColor
				},
				set: function(b) {
					this._properties._borderColor = b;
					this.fillBackground()
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "background", {
				get: function() {
					return this._properties._background
				},
				set: function(b) {
					this._properties._background = b;
					this.fillBackground()
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "backgroundColor", {
				get: function() {
					return this._properties._backgroundColor
				},
				set: function(b) {
					this._properties._backgroundColor = b;
					this.fillBackground()
				},
				enumerable: !0,
				configurable: !0
			});
			c.fillBackground = function() {
				var b = this._bgGraphics,
					a = this._properties;
				b && b.clear();
				if (a._background || a._border) null == b && (b = this._bgGraphics = new d.Graphics), a._background && b.beginFill(a._backgroundColor, 1), a._border && b.lineStyle(1, a._borderColor), b.drawRect(0, 0, this._getWidth(), this._getHeight()), b.endFill()
			};
			c.setFocus = function() {
				d.Logger.warningWithErrorId(1013)
			};
			c._onRemoveFromStage = function() {
				f.prototype._onRemoveFromStage.call(this);
				this._removeEvent();
				this._properties._type == d.TextFieldType.INPUT && this._inputUtils._removeStageText()
			};
			c._onAddToStage = function() {
				f.prototype._onAddToStage.call(this);
				this._addEvent();
				this._properties._type == d.TextFieldType.INPUT && this._inputUtils._addStageText()
			};
			c._updateBaseTransform = function() {
				this._getLinesArr();
				0 == this._properties._textMaxWidth && this._properties._type != d.TextFieldType.INPUT || f.prototype._updateTransform.call(this)
			};
			c._updateTransform = function() {
				this._properties._type == d.TextFieldType.INPUT ? this._normalDirty ? this._inputUtils._updateProperties() : this._inputUtils._updateTransform() : this._updateBaseTransform()
			};
			c._draw = function(b) {
				var a = this._properties;
				if (a._type == d.TextFieldType.INPUT) {
					if (this._isTyping) return
				} else if (0 == a._textMaxWidth) return;
				f.prototype._draw.call(this, b)
			};
			c._render = function(b) {
				this._bgGraphics && this._bgGraphics._draw(b);
				this.drawText(b);
				this._clearDirty()
			};
			c._measureBounds = function() {
				var b = this._properties;
				this._getLinesArr();
				return 0 == b._textMaxWidth ? d.Rectangle.identity.initialize(0, 0, 0, 0) : d.Rectangle.identity.initialize(0, 0, b._textMaxWidth, d.TextFieldUtils._getTextHeight(this))
			};
			Object.defineProperty(c, "textFlow", {
				get: function() {
					return this._textArr
				},
				set: function(b) {
					var a = this._properties;
					this._isFlow = !0;
					var h = "";
					null == b && (b = []);
					for (var c = 0; c < b.length; c++) h += b[c].text;
					a._displayAsPassword ? this._setBaseText(h) : (a._text = h, this.setMiddleStyle(b))
				},
				enumerable: !0,
				configurable: !0
			});
			c.changeToPassText = function(b) {
				if (this._properties._displayAsPassword) {
					for (var a = "", h = 0, c = b.length; h < c; h++) switch (b.charAt(h)) {
					case "\n":
						a += "\n";
						break;
					case "\r":
						break;
					default:
						a += "*"
					}
					return a
				}
				return b
			};
			c.setMiddleStyle = function(b) {
				this._isArrayChanged = !0;
				this._textArr = b;
				this._setSizeDirty()
			};
			Object.defineProperty(c, "textWidth", {
				get: function() {
					return this._properties._textMaxWidth
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "textHeight", {
				get: function() {
					return d.TextFieldUtils._getTextHeight(this)
				},
				enumerable: !0,
				configurable: !0
			});
			c.appendText = function(b) {
				this.appendElement({
					text: b
				})
			};
			c.appendElement = function(b) {
				this._textArr.push(b);
				this.setMiddleStyle(this._textArr)
			};
			c._getLinesArr = function() {
				var b = this._properties;
				if (!this._isArrayChanged) return this._linesArr;
				this._isArrayChanged = !1;
				var a = this._textArr,
					h = d.MainContext.instance.rendererContext;
				this._linesArr.length = 0;
				b._textMaxHeight = 0;
				b._textMaxWidth = 0;
				if (this._hasWidthSet && 0 == this._explicitWidth) return b._numLines = 0, [{
					width: 0,
					height: 0,
					charNum: 0,
					elements: [],
					hasNextLine: !1
				}];
				this._isFlow || h.setupFont(this);
				for (var c = this._linesArr, e = 0, f = 0, g = 0, k = 0, l, m = 0, n = a.length; m < n; m++) {
					var p = a[m];
					p.style = p.style || {};
					for (var q = p.text.toString().split(/(?:\r\n|\r|\n)/), x = 0, z = q.length; x < z; x++) {
						null == c[k] && (l = {
							width: 0,
							height: 0,
							elements: [],
							charNum: 0,
							hasNextLine: !1
						}, c[k] = l, f = g = e = 0);
						var g = b._type == d.TextFieldType.INPUT ? b._size : Math.max(g, p.style.size || b._size),
							t = !0;
						if ("" == q[x]) x == z - 1 && (t = !1);
						else {
							this._isFlow && h.setupFont(this, p.style);
							var y = h.measureText(q[x]);
							if (this._hasWidthSet) if (e + y <= this._explicitWidth) l.elements.push({
								width: y,
								text: q[x],
								style: p.style
							}), e += y, f += q[x].length, x == z - 1 && (t = !1);
							else {
								for (var w = t = 0, A = q[x], v = A.length; t < v; t++) {
									y = h.measureText(A.charAt(t));
									if (e + y > this._explicitWidth && 0 != e + t) break;
									w += y;
									e += y;
									f += 1
								}
								0 < t && (l.elements.push({
									width: w,
									text: A.substring(0, t),
									style: p.style
								}), q[x] = A.substring(t));
								x--;
								t = !1
							} else e += y, f += q[x].length, l.elements.push({
								width: y,
								text: q[x],
								style: p.style
							}), x == z - 1 && (t = !1)
						}
						t && (f++, l.hasNextLine = !0);
						x < q.length - 1 && (l.width = e, l.height = g, l.charNum = f, b._textMaxWidth = Math.max(b._textMaxWidth, e), b._textMaxHeight += g, k++)
					}
					m == a.length - 1 && l && (l.width = e, l.height = g, l.charNum = f, b._textMaxWidth = Math.max(b._textMaxWidth, e), b._textMaxHeight += g)
				}
				b._numLines = c.length;
				return c
			};
			c.drawText = function(b) {
				var a = this._properties,
					h = this._getLinesArr();
				if (0 != a._textMaxWidth) {
					var c = this._hasWidthSet ? this._explicitWidth : a._textMaxWidth,
						e = d.TextFieldUtils._getTextHeight(this),
						f = 0,
						g = d.TextFieldUtils._getStartLine(this);
					if (this._hasHeightSet && this._explicitHeight > e) var k = d.TextFieldUtils._getValign(this),
						f = f + k * (this._explicitHeight - e);
					for (var f = Math.round(f), e = d.TextFieldUtils._getHalign(this), k = 0, l = g, m = a._numLines; l < m; l++) {
						var n = h[l],
							p = n.height,
							f = f + p / 2;
						if (l != g) {
							if (a._type == d.TextFieldType.INPUT && !a._multiline) break;
							if (this._hasHeightSet && f > this._explicitHeight) break
						}
						for (var k = Math.round((c - n.width) * e), q = 0, x = n.elements.length; q < x; q++) {
							var z = n.elements[q];
							b.drawText(this, z.text, k, f + (p - (z.style.size || a._size)) / 2, z.width, z.style);
							k += z.width
						}
						f += p / 2 + a._lineSpacing
					}
				}
			};
			c._addEvent = function() {
				this.addEventListener(d.TouchEvent.TOUCH_TAP, this.onTapHandler, this)
			};
			c._removeEvent = function() {
				this.removeEventListener(d.TouchEvent.TOUCH_TAP, this.onTapHandler, this)
			};
			c.onTapHandler = function(b) {
				if (this._properties._type != d.TextFieldType.INPUT && (b = d.TextFieldUtils._getTextElement(this, b.localX, b.localY), null != b && (b = b.style) && b.href && b.href.match(/^event:/))) {
					var a = b.href.match(/^event:/)[0];
					d.TextEvent.dispatchTextEvent(this, d.TextEvent.LINK, b.href.substring(a.length))
				}
			};
			e.default_fontFamily = "Arial";
			return e
		}(d.DisplayObject);
	d.TextField = f;
	f.prototype.__class__ = "egret.TextField"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {
				this.resutlArr = []
			}
			var e = d.prototype;
			e.parser = function(c) {
				this.stackArray = [];
				this.resutlArr = [];
				for (var b = 0, a = c.length; b < a;) {
					var h = c.indexOf("<", b);
					0 > h ? (this.addToResultArr(c.substring(b)), b = a) : (this.addToResultArr(c.substring(b, h)), b = c.indexOf(">", h), "/" == c.charAt(h + 1) ? this.stackArray.pop() : this.addToArray(c.substring(h + 1, b)), b += 1)
				}
				return this.resutlArr
			};
			e.addToResultArr = function(c) {
				if ("" != c) {
					var b = [];
					b.push(["&lt;", "<"]);
					b.push(["&gt;", ">"]);
					b.push(["&amp;", "&"]);
					b.push(["&quot;", '"']);
					b.push(["&apos;;", "'"]);
					for (var a = 0; a < b.length; a++) c.replace(new RegExp(b[a][0], "g"), b[a][1]);
					0 < this.stackArray.length ? this.resutlArr.push({
						text: c,
						style: this.stackArray[this.stackArray.length - 1]
					}) : this.resutlArr.push({
						text: c
					})
				}
			};
			e.changeStringToObject = function(c) {
				var b = {};
				c = c.replace(/( )+/g, " ").split(" ");
				for (var a = 0; a < c.length; a++) this.addProperty(b, c[a]);
				return b
			};
			e.addProperty = function(c, b) {
				var a = b.replace(/( )*=( )*/g, "=").split("=");
				a[1] && (a[1] = a[1].replace(/(\"|\')/g, ""));
				switch (a[0].toLowerCase()) {
				case "color":
					a[1] = a[1].replace(/#/, "0x");
					c.textColor = parseInt(a[1]);
					break;
				case "strokecolor":
					a[1] = a[1].replace(/#/, "0x");
					c.strokeColor = parseInt(a[1]);
					break;
				case "stroke":
					c.stroke = parseInt(a[1]);
					break;
				case "b":
					c.bold = "true" == (a[1] || "true");
					break;
				case "i":
					c.italic = "true" == (a[1] || "true");
					break;
				case "size":
					c.size = parseInt(a[1]);
					break;
				case "fontfamily":
					c.fontFamily = a[1];
					break;
				case "href":
					c.href = a[1]
				}
			};
			e.addToArray = function(c) {
				c = this.changeStringToObject(c);
				if (0 != this.stackArray.length) {
					var b = this.stackArray[this.stackArray.length - 1],
						a;
					for (a in b) null == c[a] && (c[a] = b[a])
				}
				this.stackArray.push(c)
			};
			return d
		}();
	d.HtmlTextParser = f;
	f.prototype.__class__ = "egret.HtmlTextParser"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.DYNAMIC = "dynamic";
			d.INPUT = "input";
			return d
		}();
	d.TextFieldType = f;
	f.prototype.__class__ = "egret.TextFieldType"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(b) {
				f.call(this);
				this._bitmapY = this._bitmapX = this._sourceHeight = this._sourceWidth = 0;
				this._textureMap = {};
				this.texture = b;
				this._sourceWidth = b._sourceWidth;
				this._sourceHeight = b._sourceHeight;
				this._bitmapX = b._bitmapX - b._offsetX;
				this._bitmapY = b._bitmapY - b._offsetY
			}
			__extends(e, f);
			var c = e.prototype;
			c.getTexture = function(b) {
				return this._textureMap[b]
			};
			c.createTexture = function(b, a, h, c, e, f, g, k, l) {
				void 0 === f && (f = 0);
				void 0 === g && (g = 0);
				"undefined" === typeof k && (k = f + c);
				"undefined" === typeof l && (l = g + e);
				var m = this.texture._clone(),
					n = d.MainContext.instance.rendererContext._texture_scale_factor;
				m._bitmapX = this._bitmapX + a;
				m._bitmapY = this._bitmapY + h;
				m._bitmapWidth = c * n;
				m._bitmapHeight = e * n;
				m._offsetX = f;
				m._offsetY = g;
				m._textureWidth = k * n;
				m._textureHeight = l * n;
				m._sourceWidth = this._sourceWidth;
				m._sourceHeight = this._sourceHeight;
				return this._textureMap[b] = m
			};
			return e
		}(d.HashObject);
	d.SpriteSheet = f;
	f.prototype.__class__ = "egret.SpriteSheet"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._text = null;
				this._isFocus = !1
			}
			__extends(e, f);
			var c = e.prototype;
			c.init = function(b) {
				this._text = b;
				this.stageText = d.StageText.create();
				this.stageText._setTextField(this._text)
			};
			c._addStageText = function() {
				this._text._inputEnabled || (this._text._touchEnabled = !0);
				this.stageText._add();
				this.stageText._addListeners();
				this.stageText.addEventListener("updateText", this.updateTextHandler, this);
				this._text.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.onMouseDownHandler, this);
				d.MainContext.instance.stage.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.onStageDownHandler, this);
				this.stageText.addEventListener("blur", this.blurHandler, this);
				this.stageText.addEventListener("focus", this.focusHandler, this)
			};
			c._removeStageText = function() {
				this._text._inputEnabled || (this._text._touchEnabled = !1);
				this.stageText._remove();
				this.stageText._removeListeners();
				this.stageText._removeInput();
				this.stageText.removeEventListener("updateText", this.updateTextHandler, this);
				this._text.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.onMouseDownHandler, this);
				d.MainContext.instance.stage.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.onStageDownHandler, this);
				this.stageText.removeEventListener("blur", this.blurHandler, this);
				this.stageText.removeEventListener("focus", this.focusHandler, this)
			};
			c._getText = function() {
				return this.stageText._getText()
			};
			c._setText = function(b) {
				this.stageText._setText(b)
			};
			c.focusHandler = function(b) {
				this._isFocus = !0;
				this._text._isTyping = !0
			};
			c.blurHandler = function(b) {
				this._isFocus = !1;
				this._text._isTyping = !1
			};
			c.onMouseDownHandler = function(b) {
				b.stopPropagation();
				this._text._visible && !this._isFocus && (this._isFocus = !0, this.stageText._show(this._text._properties._multiline, this._text.size, this._text.width, this._text.height), b = this._text.localToGlobal(), this.stageText._initElement(b.x, b.y, this._text._worldTransform.a, this._text._worldTransform.d))
			};
			c.onStageDownHandler = function(b) {
				this.stageText._hide()
			};
			c.updateTextHandler = function(b) {
				this.resetText();
				this._text.dispatchEvent(new d.Event(d.Event.CHANGE))
			};
			c.resetText = function() {
				this._text._setBaseText(this.stageText._getText())
			};
			c._hideInput = function() {
				this.stageText._removeInput()
			};
			c._updateTransform = function() {
				this._text._updateBaseTransform();
				!this._text._visible && this.stageText && this._hideInput()
			};
			c._updateProperties = function() {
				if (!this._isFocus) {
					var b = this._text._stage;
					if (null == b) this.stageText._setVisible(!1);
					else {
						for (var a = this._text, h = a._visible; h;) {
							a = a.parent;
							if (a == b) break;
							h = a._visible
						}
						this.stageText._setVisible(h)
					}
					this.stageText._setMultiline(this._text._properties._multiline);
					this.stageText._setTextType(this._text._properties._displayAsPassword ? "password" : "text");
					this.stageText._setText(this._text._properties._text);
					this.stageText._resetStageText()
				}
				this._updateTransform()
			};
			return e
		}(d.HashObject);
	d.InputController = f;
	f.prototype.__class__ = "egret.InputController"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b, a) {
				d.call(this, b);
				this.firstCharHeight = 0;
				"string" == typeof a ? this.charList = this.parseConfig(a) : a && a.hasOwnProperty("frames") ? this.charList = a.frames : this.charList = {}
			}
			__extends(e, d);
			var c = e.prototype;
			c.getTexture = function(b) {
				var a = this._textureMap[b];
				if (!a) {
					a = this.charList[b];
					if (!a) return null;
					a = this.createTexture(b, a.x, a.y, a.w, a.h, a.offX, a.offY, a.sourceW, a.sourceH);
					this._textureMap[b] = a
				}
				return a
			};
			c._getFirstCharHeight = function() {
				if (0 == this.firstCharHeight) for (var b in this.charList) {
					var a = this.charList[b];
					if (a) {
						var h = a.sourceH;
						void 0 === h && (h = a.h, void 0 === h && (h = 0), a = a.offY, void 0 === a && (a = 0), h += a);
						if (!(0 >= h)) {
							this.firstCharHeight = h;
							break
						}
					}
				}
				return this.firstCharHeight
			};
			c.parseConfig = function(b) {
				b = b.split("\r\n").join("\n");
				b = b.split("\n");
				for (var a = this.getConfigByKey(b[3], "count"), h = {}, c = 4; c < 4 + a; c++) {
					var e = b[c],
						d = String.fromCharCode(this.getConfigByKey(e, "id")),
						f = {};
					h[d] = f;
					f.x = this.getConfigByKey(e, "x");
					f.y = this.getConfigByKey(e, "y");
					f.w = this.getConfigByKey(e, "width");
					f.h = this.getConfigByKey(e, "height");
					f.offX = this.getConfigByKey(e, "xoffset");
					f.offY = this.getConfigByKey(e, "yoffset")
				}
				return h
			};
			c.getConfigByKey = function(b, a) {
				for (var h = b.split(" "), c = 0, e = h.length; c < e; c++) {
					var d = h[c];
					if (a == d.substring(0, a.length)) return h = d.substring(a.length + 1), parseInt(h)
				}
				return 0
			};
			return e
		}(d.SpriteSheet);
	d.BitmapFont = f;
	f.prototype.__class__ = "egret.BitmapFont"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(b) {
				f.call(this);
				this._isAddedToStage = !1;
				this._frames = this._movieClipData = this._textureToRender = null;
				this._totalFrames = 0;
				this._frameLabels = null;
				this._frameIntervalTime = 0;
				this._eventPool = null;
				this._isPlaying = !1;
				this._isStopped = !0;
				this._passedTime = this._displayedKeyFrameNum = this._nextFrameNum = this._currentFrameNum = this._playTimes = 0;
				this._setMovieClipData(b);
				this.needDraw = !0
			}
			__extends(e, f);
			var c = e.prototype;
			c._init = function() {
				this._reset();
				var b = this._movieClipData;
				b && b._isDataValid() && (this._frames = b.frames, this._totalFrames = b.numFrames, this._frameLabels = b.labels, this._frameIntervalTime = 1E3 / b.frameRate, this._initFrame())
			};
			c._reset = function() {
				this._frames = null;
				this._playTimes = 0;
				this._isPlaying = !1;
				this.setIsStopped(!0);
				this._currentFrameNum = 0;
				this._nextFrameNum = 1;
				this._passedTime = this._displayedKeyFrameNum = 0;
				this._eventPool = []
			};
			c._initFrame = function() {
				this._movieClipData._isTextureValid() && (this._advanceFrame(), this._constructFrame())
			};
			c._render = function(b) {
				var a = this._textureToRender;
				if (this._texture_to_render = a) {
					var h = Math.round(a._offsetX),
						c = Math.round(a._offsetY),
						d = a._bitmapWidth || a._textureWidth,
						f = a._bitmapHeight || a._textureHeight,
						g = Math.round(d),
						k = Math.round(f);
					e.renderFilter.drawImage(b, this, a._bitmapX, a._bitmapY, d, f, h, c, g, k)
				}
			};
			c._measureBounds = function() {
				var b = this._textureToRender;
				return b ? d.Rectangle.identity.initialize(b._offsetX, b._offsetY, b._textureWidth, b._textureHeight) : f.prototype._measureBounds.call(this)
			};
			c._onAddToStage = function() {
				f.prototype._onAddToStage.call(this);
				this._isAddedToStage = !0;
				this._isPlaying && 1 < this._totalFrames && this.setIsStopped(!1)
			};
			c._onRemoveFromStage = function() {
				f.prototype._onRemoveFromStage.call(this);
				this._isAddedToStage = !1;
				this.setIsStopped(!0)
			};
			c._getFrameLabelByName = function(b, a) {
				void 0 === a && (a = !1);
				a && (b = b.toLowerCase());
				var h = this._frameLabels;
				if (h) for (var c = null, e = 0; e < h.length; e++) if (c = h[e], a ? c.name.toLowerCase() === b : c.name === b) return c;
				return null
			};
			c._getFrameLabelByFrame = function(b) {
				var a = this._frameLabels;
				if (a) for (var h = null, c = 0; c < a.length; c++) if (h = a[c], h.frame === b) return h;
				return null
			};
			c._getFrameLabelForFrame = function(b) {
				var a = null,
					h = null,
					c = this._frameLabels;
				if (c) for (var e = 0; e < c.length; e++) {
					h = c[e];
					if (h.frame > b) break;
					a = h
				}
				return a
			};
			c.play = function(b) {
				void 0 === b && (b = 0);
				this._isPlaying = !0;
				this.setPlayTimes(b);
				1 < this._totalFrames && this._isAddedToStage && this.setIsStopped(!1)
			};
			c.stop = function() {
				this._isPlaying = !1;
				this.setIsStopped(!0)
			};
			c.prevFrame = function() {
				this.gotoAndStop(this._currentFrameNum - 1)
			};
			c.nextFrame = function() {
				this.gotoAndStop(this._currentFrameNum + 1)
			};
			c.gotoAndPlay = function(b, a) {
				void 0 === a && (a = 0);
				if (0 === arguments.length || 2 < arguments.length) throw Error(d.getString(1022, "MovieClip.gotoAndPlay()"));
				this.play(a);
				this._gotoFrame(b)
			};
			c.gotoAndStop = function(b) {
				if (1 != arguments.length) throw Error(d.getString(1022, "MovieClip.gotoAndStop()"));
				this.stop();
				this._gotoFrame(b)
			};
			c._gotoFrame = function(b) {
				var a;
				if ("string" === typeof b) a = this._getFrameLabelByName(b).frame;
				else if (a = parseInt(b + "", 10), a != b) throw Error(d.getString(1022, "Frame Label Not Found"));
				1 > a ? a = 1 : a > this._totalFrames && (a = this._totalFrames);
				a !== this._nextFrameNum && (this._nextFrameNum = a, this._advanceFrame(), this._constructFrame(), this._handlePendingEvent())
			};
			c._advanceTime = function(b) {
				var a = this._frameIntervalTime;
				b = this._passedTime + b;
				this._passedTime = b % a;
				a = b / a;
				if (!(1 > a)) {
					for (; 1 <= a;) {
						a--;
						this._nextFrameNum++;
						if (this._nextFrameNum > this._totalFrames) if (-1 == this._playTimes) this._eventPool.push(d.Event.LOOP_COMPLETE), this._nextFrameNum = 1;
						else if (this._playTimes--, 0 < this._playTimes) this._eventPool.push(d.Event.LOOP_COMPLETE), this._nextFrameNum = 1;
						else {
							this._nextFrameNum = this._totalFrames;
							this._eventPool.push(d.Event.COMPLETE);
							this.stop();
							break
						}
						this._advanceFrame()
					}
					this._constructFrame();
					this._handlePendingEvent()
				}
			};
			c._advanceFrame = function() {
				this._currentFrameNum = this._nextFrameNum
			};
			c._constructFrame = function() {
				var b = this._currentFrameNum;
				this._displayedKeyFrameNum != b && (this._textureToRender = this._movieClipData.getTextureByFrame(b), this._displayedKeyFrameNum = b)
			};
			c._handlePendingEvent = function() {
				if (0 != this._eventPool.length) {
					this._eventPool.reverse();
					for (var b = this._eventPool, a = b.length, h = !1, c = !1, e = 0; e < a; e++) {
						var f = b.pop();
						f == d.Event.LOOP_COMPLETE ? c = !0 : f == d.Event.COMPLETE ? h = !0 : this.dispatchEventWith(f)
					}
					c && this.dispatchEventWith(d.Event.LOOP_COMPLETE);
					h && this.dispatchEventWith(d.Event.COMPLETE)
				}
			};
			Object.defineProperty(c, "totalFrames", {
				get: function() {
					return this._totalFrames
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "currentFrame", {
				get: function() {
					return this._currentFrameNum
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "currentFrameLabel", {
				get: function() {
					var b = this._getFrameLabelByFrame(this._currentFrameNum);
					return b && b.name
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "currentLabel", {
				get: function() {
					var b = this._getFrameLabelForFrame(this._currentFrameNum);
					return b ? b.name : null
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "frameRate", {
				get: function() {
					return this.movieClipData.frameRate
				},
				set: function(b) {
					b != this._movieClipData.frameRate && (this._movieClipData.frameRate = b, this._frameIntervalTime = 1E3 / this._movieClipData.frameRate)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "isPlaying", {
				get: function() {
					return this._isPlaying
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "movieClipData", {
				get: function() {
					return this._movieClipData
				},
				set: function(b) {
					this._setMovieClipData(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setMovieClipData = function(b) {
				this._movieClipData != b && (this._movieClipData = b, this._init())
			};
			c.setPlayTimes = function(b) {
				if (0 > b || 1 <= b) this._playTimes = 0 > b ? -1 : Math.floor(b)
			};
			c.setIsStopped = function(b) {
				this._isStopped != b && ((this._isStopped = b) ? (this._playTimes = 0, d.Ticker.getInstance().unregister(this._advanceTime, this)) : (this._playTimes = 0 == this._playTimes ? 1 : this._playTimes, d.Ticker.getInstance().register(this._advanceTime, this)))
			};
			e.renderFilter = d.RenderFilter.getInstance();
			return e
		}(d.DisplayObject);
	d.MovieClip = f;
	f.prototype.__class__ = "egret.MovieClip"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b, a) {
				d.call(this);
				this._name = b;
				this._frame = a | 0
			}
			__extends(e, d);
			var c = e.prototype;
			Object.defineProperty(c, "name", {
				get: function() {
					return this._name
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "frame", {
				get: function() {
					return this._frame
				},
				enumerable: !0,
				configurable: !0
			});
			c.clone = function() {
				return new e(this._name, this._frame)
			};
			return e
		}(d.EventDispatcher);
	d.FrameLabel = f;
	f.prototype.__class__ = "egret.FrameLabel"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._mcData = null;
				this.numFrames = 1;
				this.frames = [];
				this.labels = null;
				this.frameRate = 0;
				this.spriteSheet = this.textureData = null
			}
			__extends(e, f);
			var c = e.prototype;
			c._init = function(b, a, h) {
				this.textureData = a;
				this.spriteSheet = h;
				this._setMCData(b)
			};
			c.getKeyFrameData = function(b) {
				b = this.frames[b - 1];
				b.frame && (b = this.frames[b.frame - 1]);
				return b
			};
			c.getTextureByFrame = function(b) {
				b = this.getKeyFrameData(b);
				if (b.res) {
					var a = this.getTextureByResName(b.res);
					a._offsetX = b.x | 0;
					a._offsetY = b.y | 0;
					return a
				}
				return null
			};
			c.getTextureByResName = function(b) {
				var a = this.spriteSheet.getTexture(b);
				a || (a = this.textureData[b], a = this.spriteSheet.createTexture(b, a.x, a.y, a.w, a.h));
				return a
			};
			c._isDataValid = function() {
				return 0 < this.frames.length
			};
			c._isTextureValid = function() {
				return null != this.textureData && null != this.spriteSheet
			};
			c._fillMCData = function(b) {
				this.frameRate = b.frameRate || 24;
				this._fillFramesData(b.frames);
				this._fillFrameLabelsData(b.labels)
			};
			c._fillFramesData = function(b) {
				for (var a = this.frames, h = b ? b.length : 0, c, e = 0; e < h; e++) if (c = b[e], a.push(c), c.duration) {
					var d = parseInt(c.duration);
					if (1 < d) {
						c = a.length;
						for (var f = 1; f < d; f++) a.push({
							frame: c
						})
					}
				}
				this.numFrames = a.length
			};
			c._fillFrameLabelsData = function(b) {
				if (b) {
					var a = b.length;
					if (0 < a) {
						this.labels = [];
						for (var h = 0; h < a; h++) {
							var c = b[h];
							this.labels.push(new d.FrameLabel(c.name, c.frame))
						}
					}
				}
			};
			Object.defineProperty(c, "mcData", {
				get: function() {
					return this._mcData
				},
				set: function(b) {
					this._setMCData(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setMCData = function(b) {
				this._mcData != b && (this._mcData = b) && this._fillMCData(b)
			};
			return e
		}(d.HashObject);
	d.MovieClipData = f;
	f.prototype.__class__ = "egret.MovieClipData"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(b, a) {
				f.call(this);
				this.enableCache = !0;
				this._mcDataCache = {};
				this._mcDataSet = b;
				this.setTexture(a)
			}
			__extends(e, f);
			var c = e.prototype;
			c.clearCache = function() {
				this._mcDataCache = {}
			};
			c.generateMovieClipData = function(b) {
				void 0 === b && (b = "");
				if ("" == b && this._mcDataSet) for (b in this._mcDataSet.mc) break;
				if ("" == b) return null;
				var a = this._findFromCache(b, this._mcDataCache);
				a || (a = new d.MovieClipData, this._fillData(b, a, this._mcDataCache));
				return a
			};
			c._findFromCache = function(b, a) {
				return this.enableCache && a[b] ? a[b] : null
			};
			c._fillData = function(b, a, h) {
				if (this._mcDataSet) {
					var c = this._mcDataSet.mc[b];
					c && (a._init(c, this._mcDataSet.res, this._spriteSheet), this.enableCache && (h[b] = a))
				}
			};
			Object.defineProperty(c, "mcDataSet", {
				get: function() {
					return this._mcDataSet
				},
				set: function(b) {
					this._mcDataSet = b
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "texture", {
				set: function(b) {
					this.setTexture(b)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "spriteSheet", {
				get: function() {
					return this._spriteSheet
				},
				enumerable: !0,
				configurable: !0
			});
			c.setTexture = function(b) {
				this._spriteSheet = b ? new d.SpriteSheet(b) : null
			};
			return e
		}(d.EventDispatcher);
	d.MovieClipDataFactory = f;
	f.prototype.__class__ = "egret.MovieClipDataFactory"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._scaleY = this._scaleX = 1;
				this._size = 30;
				this._color = "#FFFFFF";
				this._fontFamily = "Arial";
				this._italic = this._bold = !1;
				this._textAlign = "left";
				this._verticalAlign = "top";
				this._visible = !1;
				this._height = this._width = 0;
				this._multiline = !1;
				this._maxChars = 0
			}
			__extends(e, d);
			var c = e.prototype;
			c._setTextField = function(b) {
				this._textfield = b
			};
			c._getText = function() {
				return null
			};
			c._setText = function(b) {};
			c._setTextType = function(b) {};
			c._getTextType = function() {
				return null
			};
			c._show = function(b, a, h, c) {};
			c._add = function() {};
			c._remove = function() {};
			c._hide = function() {};
			c._addListeners = function() {};
			c._removeListeners = function() {};
			c._setScale = function(b, a) {
				this._scaleX = b;
				this._scaleY = a
			};
			c.changePosition = function(b, a) {};
			c._setSize = function(b) {
				this._size = b
			};
			c._setTextColor = function(b) {
				this._color = b
			};
			c._setTextFontFamily = function(b) {
				this._fontFamily = b
			};
			c._setBold = function(b) {
				this._bold = b
			};
			c._setItalic = function(b) {
				this._italic = b
			};
			c._setTextAlign = function(b) {
				this._textAlign = b
			};
			c._setVerticalAlign = function(b) {
				this._verticalAlign = b
			};
			c._setVisible = function(b) {
				this._visible = b
			};
			c._setWidth = function(b) {
				this._width = b
			};
			c._setHeight = function(b) {
				this._height = b
			};
			c._setMultiline = function(b) {
				this._multiline = b
			};
			c._setMaxChars = function(b) {
				this._maxChars = b
			};
			c._resetStageText = function() {};
			c._initElement = function(b, a, h, c) {};
			c._removeInput = function() {};
			e.create = function() {
				return null
			};
			return e
		}(d.EventDispatcher);
	d.StageText = f;
	f.prototype.__class__ = "egret.StageText"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.GET = "get";
			d.POST = "post";
			return d
		}();
	d.URLRequestMethod = f;
	f.prototype.__class__ = "egret.URLRequestMethod"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.BINARY = "binary";
			d.TEXT = "text";
			d.VARIABLES = "variables";
			d.TEXTURE = "texture";
			d.SOUND = "sound";
			return d
		}();
	d.URLLoaderDataFormat = f;
	f.prototype.__class__ = "egret.URLLoaderDataFormat"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(b) {
				void 0 === b && (b = null);
				d.call(this);
				this.variables = null;
				null !== b && this.decode(b)
			}
			__extends(e, d);
			var c = e.prototype;
			c.decode = function(b) {
				this.variables || (this.variables = {});
				b = b.split("+").join(" ");

				for (var a, h = /[?&]?([^=]+)=([^&]*)/g; a = h.exec(b);) {
					var c = decodeURIComponent(a[1]);
					a = decodeURIComponent(a[2]);
					if (!1 == c in this.variables) this.variables[c] = a;
					else {
						var e = this.variables[c];
						e instanceof Array ? e.push(a) : this.variables[c] = [e, a]
					}
				}
			};
			c.toString = function() {
				if (!this.variables) return "";
				var b = this.variables,
					a = [],
					h;
				for (h in b) a.push(this.encodeValue(h, b[h]));
				return a.join("&")
			};
			c.encodeValue = function(b, a) {
				return a instanceof Array ? this.encodeArray(b, a) : encodeURIComponent(b) + "=" + encodeURIComponent(a)
			};
			c.encodeArray = function(b, a) {
				return b ? 0 == a.length ? encodeURIComponent(b) + "=" : a.map(function(a) {
					return encodeURIComponent(b) + "=" + encodeURIComponent(a)
				}).join("&") : ""
			};
			return e
		}(d.HashObject);
	d.URLVariables = f;
	f.prototype.__class__ = "egret.URLVariables"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			return function(d, e) {
				this.value = this.name = "";
				this.name = d;
				this.value = e
			}
		}();
	d.URLRequestHeader = f;
	f.prototype.__class__ = "egret.URLRequestHeader"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(c) {
				void 0 === c && (c = null);
				f.call(this);
				this.data = null;
				this.method = d.URLRequestMethod.GET;
				this.url = "";
				this.url = c
			}
			__extends(e, f);
			return e
		}(d.HashObject);
	d.URLRequest = f;
	f.prototype.__class__ = "egret.URLRequest"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(b) {
				void 0 === b && (b = null);
				f.call(this);
				this.dataFormat = d.URLLoaderDataFormat.TEXT;
				this._request = this.data = null;
				this._status = -1;
				b && this.load(b)
			}
			__extends(e, f);
			var c = e.prototype;
			c.load = function(b) {
				this._request = b;
				this.data = null;
				d.MainContext.instance.netContext.proceed(this)
			};
			c.__recycle = function() {
				this.data = this._request = null
			};
			return e
		}(d.EventDispatcher);
	d.URLLoader = f;
	f.prototype.__class__ = "egret.URLLoader"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._sourceHeight = this._sourceWidth = this._textureHeight = this._textureWidth = this._offsetY = this._offsetX = this._bitmapHeight = this._bitmapWidth = this._bitmapY = this._bitmapX = 0;
				this._bitmapData = null
			}
			__extends(e, f);
			var c = e.prototype;
			Object.defineProperty(c, "textureWidth", {
				get: function() {
					return this._textureWidth
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "textureHeight", {
				get: function() {
					return this._textureHeight
				},
				enumerable: !0,
				configurable: !0
			});
			c._setBitmapData = function(b) {
				var a = d.MainContext.instance.rendererContext._texture_scale_factor;
				this._bitmapData = b;
				this._sourceWidth = b.width;
				this._sourceHeight = b.height;
				this._textureWidth = this._sourceWidth * a;
				this._textureHeight = this._sourceHeight * a;
				this._bitmapWidth = this._textureWidth;
				this._bitmapHeight = this._textureHeight;
				this._offsetX = this._offsetY = this._bitmapX = this._bitmapY = 0
			};
			c.getPixel32 = function(b, a) {
				return this._bitmapData.getContext("2d").getImageData(b, a, 1, 1).data
			};
			c.dispose = function() {
				var b = this._bitmapData;
				b.dispose && b.dispose()
			};
			c._clone = function() {
				var b = new e;
				b._bitmapData = this._bitmapData;
				return b
			};
			return e
		}(d.HashObject);
	d.Texture = f;
	f.prototype.__class__ = "egret.Texture"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this)
			}
			__extends(e, f);
			var c = e.prototype;
			c.init = function() {
				this._bitmapData = document.createElement("canvas");
				this.renderContext = d.RendererContext.createRendererContext(this._bitmapData)
			};
			c.drawToTexture = function(b, a, h) {
				var c = a || b.getBounds(d.Rectangle.identity);
				if (0 == c.width || 0 == c.height) return !1;
				this._bitmapData || this.init();
				var f = c.x,
					g = c.y,
					r = c.width,
					c = c.height,
					k, l, m = d.MainContext.instance.rendererContext._texture_scale_factor;
				k = r / m;
				l = c / m;
				k = Math.round(k);
				l = Math.round(l);
				this.setSize(k, l);
				this.begin();
				b._worldTransform.identity();
				b._worldTransform.a = 1 / m;
				b._worldTransform.d = 1 / m;
				h && (b._worldTransform.a *= h, b._worldTransform.d *= h);
				h = b._anchorOffsetX;
				m = b._anchorOffsetY;
				if (0 != b._anchorX || 0 != b._anchorY) h = b._anchorX * k, m = b._anchorY * l;
				this._offsetX = f + h;
				this._offsetY = g + m;
				b._worldTransform.append(1, 0, 0, 1, -this._offsetX, -this._offsetY);
				a && (this._offsetX -= f, this._offsetY -= g);
				b.worldAlpha = 1;
				if (b instanceof d.DisplayObjectContainer) for (a = b._children, f = 0, g = a.length; f < g; f++) a[f]._updateTransform();
				this.renderContext.setTransform(b._worldTransform);
				a = d.RenderFilter.getInstance();
				f = a._drawAreaList.concat();
				a._drawAreaList.length = 0;
				this.renderContext.clearScreen();
				this.renderContext.onRenderStart();
				d.RendererContext.deleteTexture(this);
				b._filter && this.renderContext.setGlobalFilter(b._filter);
				b._colorTransform && this.renderContext.setGlobalColorTransform(b._colorTransform.matrix);
				(g = b.mask || b._scrollRect) && this.renderContext.pushMask(g);
				h = d.MainContext.__use_new_draw;
				d.MainContext.__use_new_draw = !1;
				b._render(this.renderContext);
				d.MainContext.__use_new_draw = h;
				g && this.renderContext.popMask();
				b._colorTransform && this.renderContext.setGlobalColorTransform(null);
				b._filter && this.renderContext.setGlobalFilter(null);
				e.identityRectangle.width = k;
				e.identityRectangle.height = l;
				a.addDrawArea(e.identityRectangle);
				this.renderContext.onRenderFinish();
				a._drawAreaList = f;
				this._sourceWidth = k;
				this._sourceHeight = l;
				this._textureWidth = r;
				this._textureHeight = c;
				this.end();
				return !0
			};
			c.setSize = function(b, a) {
				var h = this._bitmapData;
				h.width = b;
				h.height = a;
				h.style.width = b + "px";
				h.style.height = a + "px";
				this.renderContext._cacheCanvas && (this.renderContext._cacheCanvas.width = b, this.renderContext._cacheCanvas.height = a)
			};
			c.begin = function() {};
			c.end = function() {};
			c.dispose = function() {
				this._bitmapData && (this.renderContext = this._bitmapData = null)
			};
			e.identityRectangle = new d.Rectangle;
			return e
		}(d.Texture);
	d.RenderTexture = f;
	f.prototype.__class__ = "egret.RenderTexture"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this.renderCost = 0;
				this._texture_scale_factor = 1;
				this.profiler = d.Profiler.getInstance();
				e.blendModesForGL || e.initBlendMode()
			}
			__extends(e, f);
			var c = e.prototype;
			Object.defineProperty(c, "texture_scale_factor", {
				get: function() {
					return this._texture_scale_factor
				},
				set: function(b) {
					this._setTextureScaleFactor(b)
				},
				enumerable: !0,
				configurable: !0
			});
			c._setTextureScaleFactor = function(b) {
				this._texture_scale_factor = b
			};
			c.clearScreen = function() {};
			c.clearRect = function(b, a, h, c) {};
			c.drawImage = function(b, a, h, c, e, d, f, g, l, m) {
				this.profiler.onDrawImage()
			};
			c.drawImageScale9 = function(b, a, h, c, e, d, f, g, l, m) {
				return !1
			};
			c._addOneDraw = function() {
				this.profiler.onDrawImage()
			};
			c.setTransform = function(b) {};
			c.setAlpha = function(b, a) {};
			c.setupFont = function(b, a) {};
			c.measureText = function(b) {
				return 0
			};
			c.drawText = function(b, a, h, c, e, d) {
				this.profiler.onDrawImage()
			};
			c.strokeRect = function(b, a, h, c, e) {};
			c.pushMask = function(b) {};
			c.popMask = function() {};
			c.onRenderStart = function() {};
			c.onRenderFinish = function() {};
			c.setGlobalColorTransform = function(b) {};
			c.setGlobalFilter = function(b) {};
			c.drawCursor = function(b, a, h, c) {};
			e.createRendererContext = function(b) {
				return null
			};
			e.deleteTexture = function(b) {
				var a = d.MainContext.instance.rendererContext.gl;
				if (b = b._bitmapData) {
					var h = b.webGLTexture;
					if (h && a) for (var c in h) a.deleteTexture(h[c]);
					b.webGLTexture = null
				}
			};
			e.initBlendMode = function() {
				e.blendModesForGL = {};
				e.blendModesForGL[d.BlendMode.NORMAL] = [1, 771];
				e.blendModesForGL[d.BlendMode.ADD] = [770, 1];
				e.blendModesForGL[d.BlendMode.ERASE] = [0, 771];
				e.blendModesForGL[d.BlendMode.ERASE_REVERSE] = [0, 770]
			};
			e.registerBlendModeForGL = function(b, a, h, c) {
				e.blendModesForGL[b] && !c ? d.Logger.warningWithErrorId(1005, b) : e.blendModesForGL[b] = [a, h]
			};
			e.imageSmoothingEnabled = !0;
			e.blendModesForGL = null;
			return e
		}(d.HashObject);
	d.RendererContext = f;
	f.prototype.__class__ = "egret.RendererContext"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.MOUSE = "mouse";
			d.TOUCH = "touch";
			d.mode = "touch";
			return d
		}();
	d.InteractionMode = f;
	f.prototype.__class__ = "egret.InteractionMode"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._currentTouchTarget = {};
				this.maxTouches = 2;
				this.touchDownTarget = {};
				this.touchingIdentifiers = [];
				this.lastTouchY = this.lastTouchX = -1
			}
			__extends(e, f);
			var c = e.prototype;
			c.run = function() {};
			c.getTouchData = function(b, a, h) {
				var c = this._currentTouchTarget[b];
				null == c && (c = {}, this._currentTouchTarget[b] = c);
				c.stageX = a;
				c.stageY = h;
				c.identifier = b;
				return c
			};
			c.dispatchEvent = function(b, a) {
				d.TouchEvent.dispatchTouchEvent(a.target, b, a.identifier, a.stageX, a.stageY, !1, !1, !1, !0 == this.touchDownTarget[a.identifier])
			};
			c.onTouchBegan = function(b, a, h) {
				if (this.touchingIdentifiers.length != this.maxTouches) {
					var c = d.MainContext.instance.stage.hitTest(b, a);
					c && (b = this.getTouchData(h, b, a), this.touchDownTarget[h] = !0, b.target = c, b.beginTarget = c, this.dispatchEvent(d.TouchEvent.TOUCH_BEGIN, b));
					this.touchingIdentifiers.push(h)
				}
			};
			c.onTouchMove = function(b, a, h) {
				if (-1 != this.touchingIdentifiers.indexOf(h) && (b != this.lastTouchX || a != this.lastTouchY)) {
					this.lastTouchX = b;
					this.lastTouchY = a;
					var c = d.MainContext.instance.stage.hitTest(b, a);
					c && (b = this.getTouchData(h, b, a), b.target = c, this.dispatchEvent(d.TouchEvent.TOUCH_MOVE, b))
				}
			};
			c.onTouchEnd = function(b, a, h) {
				var c = this.touchingIdentifiers.indexOf(h); - 1 != c && (this.touchingIdentifiers.splice(c, 1), c = d.MainContext.instance.stage.hitTest(b, a)) && (b = this.getTouchData(h, b, a), delete this.touchDownTarget[h], h = b.beginTarget, b.target = c, this.dispatchEvent(d.TouchEvent.TOUCH_END, b), h == c ? this.dispatchEvent(d.TouchEvent.TOUCH_TAP, b) : b.beginTarget && (b.target = b.beginTarget, this.dispatchEvent(d.TouchEvent.TOUCH_RELEASE_OUTSIDE, b)), delete this._currentTouchTarget[b.identifier])
			};
			return e
		}(d.HashObject);
	d.TouchContext = f;
	f.prototype.__class__ = "egret.TouchContext"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this)
			}
			__extends(e, f);
			var c = e.prototype;
			c.proceed = function(b) {};
			e._getUrl = function(b) {
				var a = b.url; - 1 == a.indexOf("?") && b.method == d.URLRequestMethod.GET && b.data && b.data instanceof d.URLVariables && (a = a + "?" + b.data.toString());
				return a
			};
			c.getChangeList = function() {
				return []
			};
			return e
		}(d.HashObject);
	d.NetContext = f;
	f.prototype.__class__ = "egret.NetContext"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this.frameRate = 60
			}
			__extends(e, d);
			e.prototype.executeMainLoop = function(c, b) {};
			return e
		}(d.HashObject);
	d.DeviceContext = f;
	f.prototype.__class__ = "egret.DeviceContext"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.call = function(e, c) {};
			d.addCallback = function(e, c) {};
			return d
		}();
	d.ExternalInterface = f;
	f.prototype.__class__ = "egret.ExternalInterface"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this.trans = null;
				this.header = "";
				this.ua = navigator.userAgent.toLowerCase();
				this.trans = this.getTrans("transform")
			}
			__extends(e, f);
			var c = e.prototype;
			e.getInstance = function() {
				null == e.instance && (e.instance = new e);
				return e.instance
			};
			Object.defineProperty(c, "isMobile", {
				get: function() {
					d.Logger.warningWithErrorId(1E3);
					return d.MainContext.deviceType == d.MainContext.DEVICE_MOBILE
				},
				enumerable: !0,
				configurable: !0
			});
			c.getUserAgent = function() {
				return this.ua
			};
			c.getTrans = function(b) {
				"" == this.header && (this.header = this.getHeader());
				return this.header + b.substring(1, b.length)
			};
			c.getHeader = function() {
				for (var b = document.createElement("div").style, a = ["t", "webkitT", "msT", "MozT", "OT"], h = 0; h < a.length; h++) if (a[h] + "ransform" in b) return a[h];
				return a[0]
			};
			c.$new = function(b) {
				return this.$(document.createElement(b))
			};
			c.$ = function(b) {
				var a = document;
				if (b = b instanceof HTMLElement ? b : a.querySelector(b)) b.find = b.find || this.$, b.hasClass = b.hasClass ||
				function(a) {
					return this.className.match(new RegExp("(\\s|^)" + a + "(\\s|$)"))
				}, b.addClass = b.addClass ||
				function(a) {
					this.hasClass(a) || (this.className && (this.className += " "), this.className += a);
					return this
				}, b.removeClass = b.removeClass ||
				function(a) {
					this.hasClass(a) && (this.className = this.className.replace(a, ""));
					return this
				}, b.remove = b.remove ||
				function() {}, b.appendTo = b.appendTo ||
				function(a) {
					a.appendChild(this);
					return this
				}, b.prependTo = b.prependTo ||
				function(a) {
					a.childNodes[0] ? a.insertBefore(this, a.childNodes[0]) : a.appendChild(this);
					return this
				}, b.transforms = b.transforms ||
				function() {
					this.style[e.getInstance().trans] = e.getInstance().translate(this.position) + e.getInstance().rotate(this.rotation) + e.getInstance().scale(this.scale) + e.getInstance().skew(this.skew);
					return this
				}, b.position = b.position || {
					x: 0,
					y: 0
				}, b.rotation = b.rotation || 0, b.scale = b.scale || {
					x: 1,
					y: 1
				}, b.skew = b.skew || {
					x: 0,
					y: 0
				}, b.translates = function(a, b) {
					this.position.x = a;
					this.position.y = b - d.MainContext.instance.stage.stageHeight;
					this.transforms();
					return this
				}, b.rotate = function(a) {
					this.rotation = a;
					this.transforms();
					return this
				}, b.resize = function(a, b) {
					this.scale.x = a;
					this.scale.y = b;
					this.transforms();
					return this
				}, b.setSkew = function(a, b) {
					this.skew.x = a;
					this.skew.y = b;
					this.transforms();
					return this
				};
				return b
			};
			c.translate = function(b) {
				return "translate(" + b.x + "px, " + b.y + "px) "
			};
			c.rotate = function(b) {
				return "rotate(" + b + "deg) "
			};
			c.scale = function(b) {
				return "scale(" + b.x + ", " + b.y + ") "
			};
			c.skew = function(b) {
				return "skewX(" + -b.x + "deg) skewY(" + b.y + "deg)"
			};
			return e
		}(d.HashObject);
	d.Browser = f;
	f.prototype.__class__ = "egret.Browser"
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		d.getItem = function(d) {
			return null
		};
		d.setItem = function(d, e) {
			return !1
		};
		d.removeItem = function(d) {};
		d.clear = function() {}
	})(d.localStorage || (d.localStorage = {}))
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f() {}
			f.parse = function(e) {
				e = d.SAXParser.getInstance().parserXML(e);
				if (!e || !e.childNodes) return null;
				for (var c = e.childNodes.length, b = !1, a = 0; a < c; a++) {
					var h = e.childNodes[a];
					if (1 == h.nodeType) {
						b = !0;
						break
					}
				}
				return b ? f.parseNode(h) : null
			};
			f.parseNode = function(e) {
				if (!e || 1 != e.nodeType) return null;
				var c = {};
				c.localName = e.localName;
				c.name = e.nodeName;
				e.namespaceURI && (c.namespace = e.namespaceURI);
				e.prefix && (c.prefix = e.prefix);
				for (var b = e.attributes, a = b.length, h = 0; h < a; h++) {
					var d = b[h],
						D = d.name;
					0 != D.indexOf("xmlns:") && (c["$" + D] = d.value)
				}
				b = e.childNodes;
				a = b.length;
				for (h = 0; h < a; h++) if (d = f.parseNode(b[h])) c.children || (c.children = []), d.parent = c, c.children.push(d);
				!c.children && (e = e.textContent.trim()) && (c.text = e);
				return c
			};
			f.findChildren = function(e, c, b) {
				b ? b.length = 0 : b = [];
				f.findByPath(e, c, b);
				return b
			};
			f.findByPath = function(e, c, b) {
				var a = c.indexOf("."),
					h; - 1 == a ? (h = c, a = !0) : (h = c.substring(0, a), c = c.substring(a + 1), a = !1);
				if (e = e.children) for (var d = e.length, D = 0; D < d; D++) {
					var s = e[D];
					s.localName == h && (a ? b.push(s) : f.findByPath(s, c, b))
				}
			};
			f.getAttributes = function(e, c) {
				c ? c.length = 0 : c = [];
				for (var b in e)"$" == b.charAt(0) && c.push(b.substring(1));
				return c
			};
			return f
		}();
	d.XML = f;
	f.prototype.__class__ = "egret.XML"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function e() {}
			e.LITTLE_ENDIAN = "littleEndian";
			e.BIG_ENDIAN = "bigEndian";
			return e
		}();
	d.Endian = f;
	f.prototype.__class__ = "egret.Endian";
	var g = function() {
			function e(b) {
				this.BUFFER_EXT_SIZE = 0;
				this.EOF_code_point = this.EOF_byte = -1;
				this._setArrayBuffer(b || new ArrayBuffer(this.BUFFER_EXT_SIZE));
				this.endian = f.BIG_ENDIAN
			}
			var c = e.prototype;
			c._setArrayBuffer = function(b) {
				this.write_position = b.byteLength;
				this.data = new DataView(b);
				this._position = 0
			};
			c.setArrayBuffer = function(b) {};
			Object.defineProperty(c, "buffer", {
				get: function() {
					return this.data.buffer
				},
				set: function(b) {
					this.data = new DataView(b)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "dataView", {
				get: function() {
					return this.data
				},
				set: function(b) {
					this.data = b;
					this.write_position = b.byteLength
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "bufferOffset", {
				get: function() {
					return this.data.byteOffset
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "position", {
				get: function() {
					return this._position
				},
				set: function(b) {
					this._position < b && !this.validate(b - this._position) || (this._position = b, this.write_position = b > this.write_position ? b : this.write_position)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "length", {
				get: function() {
					return this.write_position
				},
				set: function(b) {
					this.validateBuffer(b, !0)
				},
				enumerable: !0,
				configurable: !0
			});
			Object.defineProperty(c, "bytesAvailable", {
				get: function() {
					return this.data.byteLength - this._position
				},
				enumerable: !0,
				configurable: !0
			});
			c.clear = function() {
				this._setArrayBuffer(new ArrayBuffer(this.BUFFER_EXT_SIZE))
			};
			c.readBoolean = function() {
				return this.validate(e.SIZE_OF_BOOLEAN) ? 0 != this.data.getUint8(this.position++) : null
			};
			c.readByte = function() {
				return this.validate(e.SIZE_OF_INT8) ? this.data.getInt8(this.position++) : null
			};
			c.readBytes = function(b, a, h) {
				void 0 === a && (a = 0);
				void 0 === h && (h = 0);
				if (0 == h) h = this.bytesAvailable;
				else if (!this.validate(h)) return null;
				b ? b.validateBuffer(h) : b = new e(new ArrayBuffer(h));
				for (var c = 0; c < h; c++) b.data.setUint8(c + a, this.data.getUint8(this.position++))
			};
			c.readDouble = function() {
				if (!this.validate(e.SIZE_OF_FLOAT64)) return null;
				var b = this.data.getFloat64(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_FLOAT64;
				return b
			};
			c.readFloat = function() {
				if (!this.validate(e.SIZE_OF_FLOAT32)) return null;
				var b = this.data.getFloat32(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_FLOAT32;
				return b
			};
			c.readInt = function() {
				if (!this.validate(e.SIZE_OF_INT32)) return null;
				var b = this.data.getInt32(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_INT32;
				return b
			};
			c.readShort = function() {
				if (!this.validate(e.SIZE_OF_INT16)) return null;
				var b = this.data.getInt16(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_INT16;
				return b
			};
			c.readUnsignedByte = function() {
				return this.validate(e.SIZE_OF_UINT8) ? this.data.getUint8(this.position++) : null
			};
			c.readUnsignedInt = function() {
				if (!this.validate(e.SIZE_OF_UINT32)) return null;
				var b = this.data.getUint32(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_UINT32;
				return b
			};
			c.readUnsignedShort = function() {
				if (!this.validate(e.SIZE_OF_UINT16)) return null;
				var b = this.data.getUint16(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_UINT16;
				return b
			};
			c.readUTF = function() {
				if (!this.validate(e.SIZE_OF_UINT16)) return null;
				var b = this.data.getUint16(this.position, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_UINT16;
				return 0 < b ? this.readUTFBytes(b) : ""
			};
			c.readUTFBytes = function(b) {
				if (!this.validate(b)) return null;
				var a = new Uint8Array(this.buffer, this.bufferOffset + this.position, b);
				this.position += b;
				return this.decodeUTF8(a)
			};
			c.writeBoolean = function(b) {
				this.validateBuffer(e.SIZE_OF_BOOLEAN);
				this.data.setUint8(this.position++, b ? 1 : 0)
			};
			c.writeByte = function(b) {
				this.validateBuffer(e.SIZE_OF_INT8);
				this.data.setInt8(this.position++, b)
			};
			c.writeBytes = function(b, a, h) {
				void 0 === a && (a = 0);
				void 0 === h && (h = 0);
				if (!(0 > a || 0 > h) && (h = 0 == h ? b.length - a : Math.min(b.length - a, h), 0 < h)) {
					this.validateBuffer(h);
					b = new DataView(b.buffer);
					for (var c = a; c < h + a; c++) this.data.setUint8(this.position++, b.getUint8(c))
				}
			};
			c.writeDouble = function(b) {
				this.validateBuffer(e.SIZE_OF_FLOAT64);
				this.data.setFloat64(this.position, b, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_FLOAT64
			};
			c.writeFloat = function(b) {
				this.validateBuffer(e.SIZE_OF_FLOAT32);
				this.data.setFloat32(this.position, b, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_FLOAT32
			};
			c.writeInt = function(b) {
				this.validateBuffer(e.SIZE_OF_INT32);
				this.data.setInt32(this.position, b, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_INT32
			};
			c.writeShort = function(b) {
				this.validateBuffer(e.SIZE_OF_INT16);
				this.data.setInt16(this.position, b, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_INT16
			};
			c.writeUnsignedInt = function(b) {
				this.validateBuffer(e.SIZE_OF_UINT32);
				this.data.setUint32(this.position, b, this.endian == f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_UINT32
			};
			c.writeUTF = function(b) {
				b = this.encodeUTF8(b);
				var a = b.length;
				this.validateBuffer(e.SIZE_OF_UINT16 + a);
				this.data.setUint16(this.position, a, this.endian === f.LITTLE_ENDIAN);
				this.position += e.SIZE_OF_UINT16;
				this._writeUint8Array(b, !1)
			};
			c.writeUTFBytes = function(b) {
				this._writeUint8Array(this.encodeUTF8(b))
			};
			c.toString = function() {
				return "[ByteArray] length:" + this.length + ", bytesAvailable:" + this.bytesAvailable
			};
			c._writeUint8Array = function(b, a) {
				void 0 === a && (a = !0);
				a && this.validateBuffer(this.position + b.length);
				for (var h = 0; h < b.length; h++) this.data.setUint8(this.position++, b[h])
			};
			c.validate = function(b) {
				if (0 < this.data.byteLength && this._position + b <= this.data.byteLength) return !0;
				throw d.getString(1025);
			};
			c.validateBuffer = function(b, a) {
				void 0 === a && (a = !1);
				this.write_position = b > this.write_position ? b : this.write_position;
				b += this._position;
				if (this.data.byteLength < b || a) {
					var h = new Uint8Array(new ArrayBuffer(b + this.BUFFER_EXT_SIZE)),
						c = Math.min(this.data.buffer.byteLength, b + this.BUFFER_EXT_SIZE);
					h.set(new Uint8Array(this.data.buffer, 0, c));
					this.buffer = h.buffer
				}
			};
			c.encodeUTF8 = function(b) {
				var a = 0;
				b = this.stringToCodePoints(b);
				for (var h = []; b.length > a;) {
					var c = b[a++];
					if (this.inRange(c, 55296, 57343)) this.encoderError(c);
					else if (this.inRange(c, 0, 127)) h.push(c);
					else {
						var e, d;
						this.inRange(c, 128, 2047) ? (e = 1, d = 192) : this.inRange(c, 2048, 65535) ? (e = 2, d = 224) : this.inRange(c, 65536, 1114111) && (e = 3, d = 240);
						for (h.push(this.div(c, Math.pow(64, e)) + d); 0 < e;) {
							var f = this.div(c, Math.pow(64, e - 1));
							h.push(128 + f % 64);
							e -= 1
						}
					}
				}
				return new Uint8Array(h)
			};
			c.decodeUTF8 = function(b) {
				for (var a = 0, h = "", c, e = 0, d = 0, f = 0, g = 0; b.length > a;) {
					c = b[a++];
					if (c === this.EOF_byte) c = 0 !== d ? this.decoderError(!1) : this.EOF_code_point;
					else if (0 === d) this.inRange(c, 0, 127) || (this.inRange(c, 194, 223) ? (d = 1, g = 128, e = c - 192) : this.inRange(c, 224, 239) ? (d = 2, g = 2048, e = c - 224) : this.inRange(c, 240, 244) ? (d = 3, g = 65536, e = c - 240) : this.decoderError(!1), e *= Math.pow(64, d), c = null);
					else if (this.inRange(c, 128, 191)) if (f += 1, e += (c - 128) * Math.pow(64, d - f), f !== d) c = null;
					else {
						var l = e,
							m = g,
							g = f = d = e = 0;
						c = this.inRange(l, m, 1114111) && !this.inRange(l, 55296, 57343) ? l : this.decoderError(!1, c)
					} else g = f = d = e = 0, a--, c = this.decoderError(!1, c);
					null !== c && c !== this.EOF_code_point && (65535 >= c ? 0 < c && (h += String.fromCharCode(c)) : (c -= 65536, h += String.fromCharCode(55296 + (c >> 10 & 1023)), h += String.fromCharCode(56320 + (c & 1023))))
				}
				return h
			};
			c.encoderError = function(b) {
				throw d.getString(1026, b);
			};
			c.decoderError = function(b, a) {
				if (b) throw d.getString(1027);
				return a || 65533
			};
			c.inRange = function(b, a, h) {
				return a <= b && b <= h
			};
			c.div = function(b, a) {
				return Math.floor(b / a)
			};
			c.stringToCodePoints = function(b) {
				for (var a = [], h = 0, c = b.length; h < b.length;) {
					var e = b.charCodeAt(h);
					if (this.inRange(e, 55296, 57343)) if (this.inRange(e, 56320, 57343)) a.push(65533);
					else if (h === c - 1) a.push(65533);
					else {
						var d = b.charCodeAt(h + 1);
						this.inRange(d, 56320, 57343) ? (e &= 1023, d &= 1023, h += 1, a.push(65536 + (e << 10) + d)) : a.push(65533)
					} else a.push(e);
					h += 1
				}
				return a
			};
			e.SIZE_OF_BOOLEAN = 1;
			e.SIZE_OF_INT8 = 1;
			e.SIZE_OF_INT16 = 2;
			e.SIZE_OF_INT32 = 4;
			e.SIZE_OF_UINT8 = 1;
			e.SIZE_OF_UINT16 = 2;
			e.SIZE_OF_UINT32 = 4;
			e.SIZE_OF_FLOAT32 = 4;
			e.SIZE_OF_FLOAT64 = 8;
			return e
		}();
	d.ByteArray = g;
	g.prototype.__class__ = "egret.ByteArray"
})(egret || (egret = {}));
(function(d) {
	d.getOption = function(d) {
		if (window.hasOwnProperty("location")) {
			var g = location.search;
			if ("" == g) return "";
			for (var g = g.slice(1), g = g.split("&"), e = g.length, c = 0; c < e; c++) {
				var b = g[c].split("=");
				if (b[0] == d) return b[1]
			}
		}
		return ""
	}
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e(b, a, h) {
				f.call(this);
				this._target = null;
				this.loop = this.ignoreGlobalPause = this._useTicks = !1;
				this._actions = this._steps = this.pluginData = null;
				this.paused = !1;
				this.duration = 0;
				this._prevPos = -1;
				this.position = null;
				this._stepPosition = this._prevPosition = 0;
				this.passive = !1;
				this.initialize(b, a, h)
			}
			__extends(e, f);
			var c = e.prototype;
			e.get = function(b, a, h, c) {
				void 0 === a && (a = null);
				void 0 === h && (h = null);
				void 0 === c && (c = !1);
				c && e.removeTweens(b);
				return new e(b, a, h)
			};
			e.removeTweens = function(b) {
				if (b.tween_count) {
					for (var a = e._tweens, h = a.length - 1; 0 <= h; h--) a[h]._target == b && (a[h].paused = !0, a.splice(h, 1));
					b.tween_count = 0
				}
			};
			e.pauseTweens = function(b) {
				if (b.tween_count) for (var a = d.Tween._tweens, h = a.length - 1; 0 <= h; h--) a[h]._target == b && (a[h].paused = !0)
			};
			e.resumeTweens = function(b) {
				if (b.tween_count) for (var a = d.Tween._tweens, h = a.length - 1; 0 <= h; h--) a[h]._target == b && (a[h].paused = !1)
			};
			e.tick = function(b, a) {
				void 0 === a && (a = !1);
				for (var h = e._tweens.concat(), c = h.length - 1; 0 <= c; c--) {
					var d = h[c];
					a && !d.ignoreGlobalPause || d.paused || d.tick(d._useTicks ? 1 : b)
				}
			};
			e._register = function(b, a) {
				var h = b._target,
					c = e._tweens;
				if (a) h && (h.tween_count = 0 < h.tween_count ? h.tween_count + 1 : 1), c.push(b), e._inited || (d.Ticker.getInstance().register(e.tick, null), e._inited = !0);
				else for (h && h.tween_count--, h = c.length; h--;) if (c[h] == b) {
					c.splice(h, 1);
					break
				}
			};
			e.removeAllTweens = function() {
				for (var b = e._tweens, a = 0, h = b.length; a < h; a++) {
					var c = b[a];
					c.paused = !0;
					c._target.tweenjs_count = 0
				}
				b.length = 0
			};
			c.initialize = function(b, a, h) {
				this._target = b;
				a && (this._useTicks = a.useTicks, this.ignoreGlobalPause = a.ignoreGlobalPause, this.loop = a.loop, a.onChange && this.addEventListener("change", a.onChange, a.onChangeObj), a.override && e.removeTweens(b));
				this.pluginData = h || {};
				this._curQueueProps = {};
				this._initQueueProps = {};
				this._steps = [];
				this._actions = [];
				a && a.paused ? this.paused = !0 : e._register(this, !0);
				a && null != a.position && this.setPosition(a.position, e.NONE)
			};
			c.setPosition = function(b, a) {
				void 0 === a && (a = 1);
				0 > b && (b = 0);
				var h = b,
					c = !1;
				h >= this.duration && (this.loop ? h %= this.duration : (h = this.duration, c = !0));
				if (h == this._prevPos) return c;
				var e = this._prevPos;
				this.position = this._prevPos = h;
				this._prevPosition = b;
				if (this._target) if (c) this._updateTargetProps(null, 1);
				else if (0 < this._steps.length) {
					for (var d = 0, f = this._steps.length; d < f && !(this._steps[d].t > h); d++);
					d = this._steps[d - 1];
					this._updateTargetProps(d, (this._stepPosition = h - d.t) / d.d)
				}
				0 != a && 0 < this._actions.length && (this._useTicks ? this._runActions(h, h) : 1 == a && h < e ? (e != this.duration && this._runActions(e, this.duration), this._runActions(0, h, !0)) : this._runActions(e, h));
				c && this.setPaused(!0);
				this.dispatchEventWith("change");
				return c
			};
			c._runActions = function(b, a, h) {
				void 0 === h && (h = !1);
				var c = b,
					e = a,
					d = -1,
					f = this._actions.length,
					g = 1;
				b > a && (c = a, e = b, d = f, f = g = -1);
				for (;
				(d += g) != f;) {
					a = this._actions[d];
					var l = a.t;
					(l == e || l > c && l < e || h && l == b) && a.f.apply(a.o, a.p)
				}
			};
			c._updateTargetProps = function(b, a) {
				var h, c, d, f;
				if (b || 1 != a) {
					if (this.passive = !! b.v) return;
					b.e && (a = b.e(a, 0, 1, 1));
					h = b.p0;
					c = b.p1
				} else this.passive = !1, h = c = this._curQueueProps;
				for (var g in this._initQueueProps) {
					null == (d = h[g]) && (h[g] = d = this._initQueueProps[g]);
					null == (f = c[g]) && (c[g] = f = d);
					d = d == f || 0 == a || 1 == a || "number" != typeof d ? 1 == a ? f : d : d + (f - d) * a;
					var k = !1;
					if (f = e._plugins[g]) for (var l = 0, m = f.length; l < m; l++) {
						var n = f[l].tween(this, g, d, h, c, a, !! b && h == c, !b);
						n == e.IGNORE ? k = !0 : d = n
					}
					k || (this._target[g] = d)
				}
			};
			c.setPaused = function(b) {
				this.paused = b;
				e._register(this, !b);
				return this
			};
			c._cloneProps = function(b) {
				var a = {},
					h;
				for (h in b) a[h] = b[h];
				return a
			};
			c._addStep = function(b) {
				0 < b.d && (this._steps.push(b), b.t = this.duration, this.duration += b.d);
				return this
			};
			c._appendQueueProps = function(b) {
				var a, h, c, d, f, g;
				for (g in b) if (void 0 === this._initQueueProps[g]) {
					h = this._target[g];
					if (a = e._plugins[g]) for (c = 0, d = a.length; c < d; c++) h = a[c].init(this, g, h);
					this._initQueueProps[g] = this._curQueueProps[g] = void 0 === h ? null : h
				}
				for (g in b) {
					h = this._curQueueProps[g];
					if (a = e._plugins[g]) for (f = f || {}, c = 0, d = a.length; c < d; c++) a[c].step && a[c].step(this, g, h, b[g], f);
					this._curQueueProps[g] = b[g]
				}
				f && this._appendQueueProps(f);
				return this._curQueueProps
			};
			c._addAction = function(b) {
				b.t = this.duration;
				this._actions.push(b);
				return this
			};
			c._set = function(b, a) {
				for (var h in b) a[h] = b[h]
			};
			c.wait = function(b, a) {
				if (null == b || 0 >= b) return this;
				var h = this._cloneProps(this._curQueueProps);
				return this._addStep({
					d: b,
					p0: h,
					p1: h,
					v: a
				})
			};
			c.to = function(b, a, h) {
				void 0 === h && (h = void 0);
				if (isNaN(a) || 0 > a) a = 0;
				return this._addStep({
					d: a || 0,
					p0: this._cloneProps(this._curQueueProps),
					e: h,
					p1: this._cloneProps(this._appendQueueProps(b))
				})
			};
			c.call = function(b, a, h) {
				void 0 === a && (a = void 0);
				void 0 === h && (h = void 0);
				return this._addAction({
					f: b,
					p: h ? h : [],
					o: a ? a : this._target
				})
			};
			c.set = function(b, a) {
				void 0 === a && (a = null);
				return this._addAction({
					f: this._set,
					o: this,
					p: [b, a ? a : this._target]
				})
			};
			c.play = function(b) {
				b || (b = this);
				return this.call(b.setPaused, b, [!1])
			};
			c.pause = function(b) {
				b || (b = this);
				return this.call(b.setPaused, b, [!0])
			};
			c.tick = function(b) {
				this.paused || this.setPosition(this._prevPosition + b)
			};
			e.NONE = 0;
			e.LOOP = 1;
			e.REVERSE = 2;
			e._tweens = [];
			e.IGNORE = {};
			e._plugins = {};
			e._inited = !1;
			return e
		}(d.EventDispatcher);
	d.Tween = f;
	f.prototype.__class__ = "egret.Tween"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f() {
				d.Logger.fatalWithErrorId(1014)
			}
			f.get = function(e) {
				-1 > e && (e = -1);
				1 < e && (e = 1);
				return function(c) {
					return 0 == e ? c : 0 > e ? c * (c * -e + 1 + e) : c * ((2 - c) * e + (1 - e))
				}
			};
			f.getPowIn = function(e) {
				return function(c) {
					return Math.pow(c, e)
				}
			};
			f.getPowOut = function(e) {
				return function(c) {
					return 1 - Math.pow(1 - c, e)
				}
			};
			f.getPowInOut = function(e) {
				return function(c) {
					return 1 > (c *= 2) ? 0.5 * Math.pow(c, e) : 1 - 0.5 * Math.abs(Math.pow(2 - c, e))
				}
			};
			f.sineIn = function(e) {
				return 1 - Math.cos(e * Math.PI / 2)
			};
			f.sineOut = function(e) {
				return Math.sin(e * Math.PI / 2)
			};
			f.sineInOut = function(e) {
				return -0.5 * (Math.cos(Math.PI * e) - 1)
			};
			f.getBackIn = function(e) {
				return function(c) {
					return c * c * ((e + 1) * c - e)
				}
			};
			f.getBackOut = function(e) {
				return function(c) {
					return --c * c * ((e + 1) * c + e) + 1
				}
			};
			f.getBackInOut = function(e) {
				e *= 1.525;
				return function(c) {
					return 1 > (c *= 2) ? 0.5 * c * c * ((e + 1) * c - e) : 0.5 * ((c -= 2) * c * ((e + 1) * c + e) + 2)
				}
			};
			f.circIn = function(e) {
				return -(Math.sqrt(1 - e * e) - 1)
			};
			f.circOut = function(e) {
				return Math.sqrt(1 - --e * e)
			};
			f.circInOut = function(e) {
				return 1 > (e *= 2) ? -0.5 * (Math.sqrt(1 - e * e) - 1) : 0.5 * (Math.sqrt(1 - (e -= 2) * e) + 1)
			};
			f.bounceIn = function(e) {
				return 1 - f.bounceOut(1 - e)
			};
			f.bounceOut = function(e) {
				return e < 1 / 2.75 ? 7.5625 * e * e : e < 2 / 2.75 ? 7.5625 * (e -= 1.5 / 2.75) * e + 0.75 : e < 2.5 / 2.75 ? 7.5625 * (e -= 2.25 / 2.75) * e + 0.9375 : 7.5625 * (e -= 2.625 / 2.75) * e + 0.984375
			};
			f.bounceInOut = function(e) {
				return 0.5 > e ? 0.5 * f.bounceIn(2 * e) : 0.5 * f.bounceOut(2 * e - 1) + 0.5
			};
			f.getElasticIn = function(e, c) {
				var b = 2 * Math.PI;
				return function(a) {
					if (0 == a || 1 == a) return a;
					var h = c / b * Math.asin(1 / e);
					return -(e * Math.pow(2, 10 * (a -= 1)) * Math.sin((a - h) * b / c))
				}
			};
			f.getElasticOut = function(e, c) {
				var b = 2 * Math.PI;
				return function(a) {
					if (0 == a || 1 == a) return a;
					var h = c / b * Math.asin(1 / e);
					return e * Math.pow(2, -10 * a) * Math.sin((a - h) * b / c) + 1
				}
			};
			f.getElasticInOut = function(e, c) {
				var b = 2 * Math.PI;
				return function(a) {
					var h = c / b * Math.asin(1 / e);
					return 1 > (a *= 2) ? -0.5 * e * Math.pow(2, 10 * (a -= 1)) * Math.sin((a - h) * b / c) : e * Math.pow(2, -10 * (a -= 1)) * Math.sin((a - h) * b / c) * 0.5 + 1
				}
			};
			f.quadIn = f.getPowIn(2);
			f.quadOut = f.getPowOut(2);
			f.quadInOut = f.getPowInOut(2);
			f.cubicIn = f.getPowIn(3);
			f.cubicOut = f.getPowOut(3);
			f.cubicInOut = f.getPowInOut(3);
			f.quartIn = f.getPowIn(4);
			f.quartOut = f.getPowOut(4);
			f.quartInOut = f.getPowInOut(4);
			f.quintIn = f.getPowIn(5);
			f.quintOut = f.getPowOut(5);
			f.quintInOut = f.getPowInOut(5);
			f.backIn = f.getBackIn(1.7);
			f.backOut = f.getBackOut(1.7);
			f.backInOut = f.getBackInOut(1.7);
			f.elasticIn = f.getElasticIn(1, 0.3);
			f.elasticOut = f.getElasticOut(1, 0.3);
			f.elasticInOut = f.getElasticInOut(1, 0.3 * 1.5);
			return f
		}();
	d.Ease = f;
	f.prototype.__class__ = "egret.Ease"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {
				this.path = "";
				this.audio = null;
				this.type = d.EFFECT
			}
			var e = d.prototype;
			e.play = function(c) {
				void 0 === c && (c = !1);
				var b = this.audio;
				b && (isNaN(b.duration) || (b.currentTime = 0), b.loop = c, b.play())
			};
			e.pause = function() {
				var c = this.audio;
				c && c.pause()
			};
			e.load = function() {
				var c = this.audio;
				c && c.load()
			};
			e.addEventListener = function(c, b) {
				this.audio && this.audio.addEventListener(c, b, !1)
			};
			e.removeEventListener = function(c, b) {
				this.audio && this.audio.removeEventListener(c, b, !1)
			};
			e.setVolume = function(c) {
				var b = this.audio;
				b && (b.volume = c)
			};
			e.getVolume = function() {
				return this.audio ? this.audio.volume : 0
			};
			e.preload = function(c) {
				this.type = c
			};
			e._setAudio = function(c) {
				this.audio = c
			};
			d.MUSIC = "music";
			d.EFFECT = "effect";
			return d
		}();
	d.Sound = f;
	f.prototype.__class__ = "egret.Sound"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function d() {}
			d.isNumber = function(e) {
				return "number" === typeof e && !isNaN(e)
			};
			d.sin = function(e) {
				e = Math.round(e);
				e %= 360;
				0 > e && (e += 360);
				return 90 > e ? egret_sin_map[e] : 180 > e ? egret_cos_map[e - 90] : 270 > e ? -egret_sin_map[e - 180] : -egret_cos_map[e - 270]
			};
			d.cos = function(e) {
				e = Math.round(e);
				e %= 360;
				0 > e && (e += 360);
				return 90 > e ? egret_cos_map[e] : 180 > e ? -egret_sin_map[e - 90] : 270 > e ? -egret_cos_map[e - 180] : egret_sin_map[e - 270]
			};
			return d
		}();
	d.NumberUtils = f;
	f.prototype.__class__ = "egret.NumberUtils"
})(egret || (egret = {}));
for (var egret_sin_map = {}, egret_cos_map = {}, NumberUtils_i = 0; 90 >= NumberUtils_i; NumberUtils_i++) egret_sin_map[NumberUtils_i] = Math.sin(NumberUtils_i * egret.Matrix.DEG_TO_RAD), egret_cos_map[NumberUtils_i] = Math.cos(NumberUtils_i * egret.Matrix.DEG_TO_RAD);
Function.prototype.bind || (Function.prototype.bind = function(d) {
	if ("function" !== typeof this) throw new TypeError(egret.getString(1029));
	var f = Array.prototype.slice.call(arguments, 1),
		g = this,
		e = function() {},
		c = function() {
			return g.apply(this instanceof e && d ? this : d, f.concat(Array.prototype.slice.call(arguments)))
		};
	e.prototype = this.prototype;
	c.prototype = new e;
	return c
});
(function(d) {
	var f = function(f) {
			function e(b) {
				void 0 === b && (b = 60);
				f.call(this);
				this.frameRate = b;
				this._time = 0;
				this._requestAnimationId = NaN;
				this._isActivate = !0;
				60 == b && (e.requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame, e.cancelAnimationFrame = window.cancelAnimationFrame || window.msCancelAnimationFrame || window.mozCancelAnimationFrame || window.webkitCancelAnimationFrame || window.oCancelAnimationFrame || window.cancelRequestAnimationFrame || window.msCancelRequestAnimationFrame || window.mozCancelRequestAnimationFrame || window.oCancelRequestAnimationFrame || window.webkitCancelRequestAnimationFrame);
				e.requestAnimationFrame || (e.requestAnimationFrame = function(a) {
					return window.setTimeout(a, 1E3 / b)
				});
				e.cancelAnimationFrame || (e.cancelAnimationFrame = function(a) {
					return window.clearTimeout(a)
				});
				e.instance = this;
				this.registerListener()
			}
			__extends(e, f);
			var c = e.prototype;
			c.enterFrame = function() {
				var b = e.instance,
					a = e._thisObject,
					h = e._callback,
					c = d.getTimer(),
					f = c - b._time;
				b._requestAnimationId = e.requestAnimationFrame.call(window, e.prototype.enterFrame);
				h.call(a, f);
				b._time = c
			};
			c.executeMainLoop = function(b, a) {
				e._callback = b;
				e._thisObject = a;
				this.enterFrame()
			};
			c.reset = function() {
				var b = e.instance;
				b._requestAnimationId && (b._time = d.getTimer(), e.cancelAnimationFrame.call(window, b._requestAnimationId), b.enterFrame())
			};
			c.registerListener = function() {
				var b = this,
					a = function() {
						b._isActivate && (b._isActivate = !1, d.MainContext.instance.stage.dispatchEvent(new d.Event(d.Event.DEACTIVATE)))
					},
					h = function() {
						b._isActivate || (b._isActivate = !0, e.instance.reset(), d.MainContext.instance.stage.dispatchEvent(new d.Event(d.Event.ACTIVATE)))
					},
					c = function() {
						document[f] ? a() : h()
					};
				window.addEventListener("focus", h, !1);
				window.addEventListener("blur", a, !1);
				var f, g;
				"undefined" !== typeof document.hidden ? (f = "hidden", g = "visibilitychange") : "undefined" !== typeof document.mozHidden ? (f = "mozHidden", g = "mozvisibilitychange") : "undefined" !== typeof document.msHidden ? (f = "msHidden", g = "msvisibilitychange") : "undefined" !== typeof document.webkitHidden ? (f = "webkitHidden", g = "webkitvisibilitychange") : "undefined" !== typeof document.oHidden && (f = "oHidden", g = "ovisibilitychange");
				"onpageshow" in window && "onpagehide" in window && (window.addEventListener("pageshow", h, !1), window.addEventListener("pagehide", a, !1));
				f && g && document.addEventListener(g, c, !1)
			};
			e.instance = null;
			e.requestAnimationFrame = null;
			e.cancelAnimationFrame = null;
			e._thisObject = null;
			e._callback = null;
			return e
		}(d.DeviceContext);
	d.HTML5DeviceContext = f;
	f.prototype.__class__ = "egret.HTML5DeviceContext"
})(egret || (egret = {}));
var egret_html5_localStorage;
(function(d) {
	d.getItem = function(d) {
		return window.localStorage.getItem(d)
	};
	d.setItem = function(d, g) {
		try {
			return window.localStorage.setItem(d, g), !0
		} catch (e) {
			return egret.Logger.infoWithErrorId(1018, d, g), !1
		}
	};
	d.removeItem = function(d) {
		window.localStorage.removeItem(d)
	};
	d.clear = function() {
		window.localStorage.clear()
	};
	d.init = function() {
		for (var f in d) egret.localStorage[f] = d[f]
	}
})(egret_html5_localStorage || (egret_html5_localStorage = {}));
egret_html5_localStorage.init();
(function(d) {
	var f = function(f) {
			function e(b, a) {
				void 0 === a && (a = !0);
				f.call(this);
				this.useCacheCanvas = a;
				this.canvas = b || this.createCanvas();
				this.canvasContext = this.canvas.getContext("2d");
				a ? (this._cacheCanvas = document.createElement("canvas"), this._cacheCanvas.width = this.canvas.width, this._cacheCanvas.height = this.canvas.height, this.drawCanvasContext = this._cacheCanvasContext = this._cacheCanvas.getContext("2d")) : this.drawCanvasContext = this.canvasContext;
				this.onResize();
				var h = this.drawCanvasContext.setTransform,
					c = this;
				this.drawCanvasContext.setTransform = function(a, b, e, d, f, g) {
					c._matrixA = a;
					c._matrixB = b;
					c._matrixC = e;
					c._matrixD = d;
					c._matrixTx = f;
					c._matrixTy = g;
					h.call(c.drawCanvasContext, a, b, e, d, f, g)
				};
				this._matrixA = 1;
				this._matrixC = this._matrixB = 0;
				this._matrixD = 1;
				this._transformTy = this._transformTx = this._matrixTy = this._matrixTx = 0;
				this.initBlendMode()
			}
			__extends(e, f);
			var c = e.prototype;
			c.createCanvas = function() {
				var b = d.Browser.getInstance().$("#egretCanvas");
				if (!b) {
					var a = document.getElementById(d.StageDelegate.canvas_div_name),
						b = d.Browser.getInstance().$new("canvas");
					b.id = "egretCanvas";
					a.appendChild(b)
				}
				d.MainContext.instance.stage.addEventListener(d.Event.RESIZE, this.onResize, this);
				return b
			};
			c.onResize = function() {
				if (this.canvas) {
					var b = document.getElementById(d.StageDelegate.canvas_div_name);
					this.canvas.width = d.MainContext.instance.stage.stageWidth;
					this.canvas.height = d.MainContext.instance.stage.stageHeight;
					this.canvas.style.width = b.style.width;
					this.canvas.style.height = b.style.height;
					this.useCacheCanvas && (this._cacheCanvas.width = this.canvas.width, this._cacheCanvas.height = this.canvas.height);
					this.drawCanvasContext.imageSmoothingEnabled = d.RendererContext.imageSmoothingEnabled;
					this.drawCanvasContext.webkitImageSmoothingEnabled = d.RendererContext.imageSmoothingEnabled;
					this.drawCanvasContext.mozImageSmoothingEnabled = d.RendererContext.imageSmoothingEnabled;
					this.drawCanvasContext.msImageSmoothingEnabled = d.RendererContext.imageSmoothingEnabled
				}
			};
			c.clearScreen = function() {
				for (var b = d.RenderFilter.getInstance().getDrawAreaList(), a = 0, h = b.length; a < h; a++) {
					var c = b[a];
					this.clearRect(c.x, c.y, c.width, c.height)
				}
				b = d.MainContext.instance.stage;
				this.useCacheCanvas && this._cacheCanvasContext.clearRect(0, 0, b.stageWidth, b.stageHeight);
				this.renderCost = 0
			};
			c.clearRect = function(b, a, h, c) {
				this.canvasContext.clearRect(b, a, h, c)
			};
			c.drawImage = function(b, a, h, c, e, s, r, k, l, m) {
				void 0 === m && (m = void 0);
				var n = b._bitmapData;
				s += this._transformTx;
				r += this._transformTy;
				var p = d.getTimer();
				void 0 === m ? this.drawCanvasContext.drawImage(n, a, h, c, e, s, r, k, l) : this.drawRepeatImage(b, a, h, c, e, s, r, k, l, m);
				f.prototype.drawImage.call(this, b, a, h, c, e, s, r, k, l, m);
				this.renderCost += d.getTimer() - p
			};
			c.drawRepeatImage = function(b, a, h, c, e, f, g, k, l, m) {
				if (void 0 === b.pattern) {
					var n = d.MainContext.instance.rendererContext._texture_scale_factor,
						p = b._bitmapData,
						q = p;
					if (p.width != c || p.height != e || 1 != n) q = document.createElement("canvas"), q.width = c * n, q.height = e * n, q.getContext("2d").drawImage(p, a, h, c, e, 0, 0, c * n, e * n);
					a = this.drawCanvasContext.createPattern(q, m);
					b.pattern = a
				}
				this.drawCanvasContext.fillStyle = b.pattern;
				this.drawCanvasContext.translate(f, g);
				this.drawCanvasContext.fillRect(0, 0, k, l);
				this.drawCanvasContext.translate(-f, -g)
			};
			c.setTransform = function(b) {
				1 == b.a && 0 == b.b && 0 == b.c && 1 == b.d && 1 == this._matrixA && 0 == this._matrixB && 0 == this._matrixC && 1 == this._matrixD ? (this._transformTx = b.tx - this._matrixTx, this._transformTy = b.ty - this._matrixTy) : (this._transformTx = this._transformTy = 0, this._matrixA == b.a && this._matrixB == b.b && this._matrixC == b.c && this._matrixD == b.d && this._matrixTx == b.tx && this._matrixTy == b.ty || this.drawCanvasContext.setTransform(b.a, b.b, b.c, b.d, b.tx, b.ty))
			};
			c.setAlpha = function(b, a) {
				this.drawCanvasContext.globalAlpha = b;
				a ? (this.blendValue = this.blendModes[a], this.drawCanvasContext.globalCompositeOperation = this.blendValue) : this.blendValue != d.BlendMode.NORMAL && (this.blendValue = this.blendModes[d.BlendMode.NORMAL], this.drawCanvasContext.globalCompositeOperation = this.blendValue)
			};
			c.initBlendMode = function() {
				this.blendModes = {};
				this.blendModes[d.BlendMode.NORMAL] = "source-over";
				this.blendModes[d.BlendMode.ADD] = "lighter";
				this.blendModes[d.BlendMode.ERASE] = "destination-out";
				this.blendModes[d.BlendMode.ERASE_REVERSE] = "destination-in"
			};
			c.setupFont = function(b, a) {
				void 0 === a && (a = null);
				a = a || {};
				var h = b._properties,
					c = null == a.size ? h._size : a.size,
					e = null == a.fontFamily ? h._fontFamily : a.fontFamily,
					d = this.drawCanvasContext,
					f = (null == a.italic ? h._italic : a.italic) ? "italic " : "normal ",
					f = f + ((null == a.bold ? h._bold : a.bold) ? "bold " : "normal ");
				d.font = f + (c + "px " + e);
				d.textAlign = "left";
				d.textBaseline = "middle"
			};
			c.measureText = function(b) {
				return this.drawCanvasContext.measureText(b).width
			};
			c.drawText = function(b, a, h, c, e, s) {
				void 0 === s && (s = null);
				this.setupFont(b, s);
				s = s || {};
				var r = b._properties,
					k;
				k = null != s.textColor ? d.toColorString(s.textColor) : r._textColorString;
				var l;
				l = null != s.strokeColor ? d.toColorString(s.strokeColor) : r._strokeColorString;
				var r = null != s.stroke ? s.stroke : r._stroke,
					m = this.drawCanvasContext;
				m.fillStyle = k;
				m.strokeStyle = l;
				r && (m.lineWidth = 2 * r, m.strokeText(a, h + this._transformTx, c + this._transformTy, e || 65535));
				m.fillText(a, h + this._transformTx, c + this._transformTy, e || 65535);
				f.prototype.drawText.call(this, b, a, h, c, e, s)
			};
			c.strokeRect = function(b, a, h, c, e) {
				this.drawCanvasContext.strokeStyle = e;
				this.drawCanvasContext.strokeRect(b, a, h, c)
			};
			c.pushMask = function(b) {
				this.drawCanvasContext.save();
				this.drawCanvasContext.beginPath();
				this.drawCanvasContext.rect(b.x + this._transformTx, b.y + this._transformTy, b.width, b.height);
				this.drawCanvasContext.clip();
				this.drawCanvasContext.closePath()
			};
			c.popMask = function() {
				this.drawCanvasContext.restore();
				this.drawCanvasContext.setTransform(1, 0, 0, 1, 0, 0)
			};
			c.onRenderStart = function() {
				this.drawCanvasContext.save()
			};
			c.onRenderFinish = function() {
				this.drawCanvasContext.restore();
				this.drawCanvasContext.setTransform(1, 0, 0, 1, 0, 0);
				if (this.useCacheCanvas) for (var b = this._cacheCanvas.width, a = this._cacheCanvas.height, h = d.RenderFilter.getInstance().getDrawAreaList(), c = 0, e = h.length; c < e; c++) {
					var f = h[c],
						g = f.x,
						k = f.y,
						l = f.width,
						f = f.height;
					g + l > b && (l = b - g);
					k + f > a && (f = a - k);
					0 < l && 0 < f && this.canvasContext.drawImage(this._cacheCanvas, g, k, l, f, g, k, l, f)
				}
			};
			c.drawCursor = function(b, a, h, c) {
				this.drawCanvasContext.strokeStyle = "#40a5ff";
				this.drawCanvasContext.lineWidth = 2;
				this.drawCanvasContext.beginPath();
				this.drawCanvasContext.moveTo(Math.round(b + this._transformTx), Math.round(a + this._transformTy));
				this.drawCanvasContext.lineTo(Math.round(h + this._transformTx), Math.round(c + this._transformTy));
				this.drawCanvasContext.closePath();
				this.drawCanvasContext.stroke()
			};
			return e
		}(d.RendererContext);
	d.HTML5CanvasRenderer = f;
	f.prototype.__class__ = "egret.HTML5CanvasRenderer"
})(egret || (egret = {}));
var egret_h5_graphics;
(function(d) {
	d.beginFill = function(d, e) {
		void 0 === e && (e = 1);
		var c = "rgba(" + (d >> 16) + "," + ((d & 65280) >> 8) + "," + (d & 255) + "," + e + ")";
		this.fillStyleColor = c;
		this._pushCommand(new f(this._setStyle, this, [c]))
	};
	d.drawRect = function(d, e, c, b) {
		this._pushCommand(new f(function(a, b, c, e) {
			var d = this.renderContext;
			this.canvasContext.beginPath();
			this.canvasContext.rect(d._transformTx + a, d._transformTy + b, c, e);
			this.canvasContext.closePath()
		}, this, [d, e, c, b]));
		this._fill();
		this.checkRect(d, e, c, b)
	};
	d.drawCircle = function(d, e, c) {
		this._pushCommand(new f(function(b, a, h) {
			var c = this.renderContext;
			this.canvasContext.beginPath();
			this.canvasContext.arc(c._transformTx + b, c._transformTy + a, h, 0, 2 * Math.PI);
			this.canvasContext.closePath()
		}, this, [d, e, c]));
		this._fill();
		this.checkRect(d - c, e - c, 2 * c, 2 * c)
	};
	d.drawRoundRect = function(d, e, c, b, a, h) {
		this._pushCommand(new f(function(a, b, h, c, e, d) {
			var f = this.renderContext;
			a = f._transformTx + a;
			b = f._transformTy + b;
			e /= 2;
			d = d ? d / 2 : e;
			h = a + h;
			c = b + c;
			f = c - d;
			this.canvasContext.beginPath();
			this.canvasContext.moveTo(h, f);
			this.canvasContext.quadraticCurveTo(h, c, h - e, c);
			this.canvasContext.lineTo(a + e, c);
			this.canvasContext.quadraticCurveTo(a, c, a, c - d);
			this.canvasContext.lineTo(a, b + d);
			this.canvasContext.quadraticCurveTo(a, b, a + e, b);
			this.canvasContext.lineTo(h - e, b);
			this.canvasContext.quadraticCurveTo(h, b, h, b + d);
			this.canvasContext.lineTo(h, f);
			this.canvasContext.closePath()
		}, this, [d, e, c, b, a, h]));
		this._fill();
		this.checkRect(d, e, c, b)
	};
	d.drawEllipse = function(d, e, c, b) {
		this._pushCommand(new f(function(a, b, c, e) {
			var d = this.renderContext;
			this.canvasContext.save();
			a = d._transformTx + a + c / 2;
			b = d._transformTy + b + e / 2;
			d = c > e ? c : e;
			c /= d;
			e /= d;
			d /= 2;
			this.canvasContext.scale(c, e);
			this.canvasContext.beginPath();
			this.canvasContext.arc(a / c, b / e, d, 0, 2 * Math.PI);
			this.canvasContext.closePath();
			this.canvasContext.restore()
		}, this, [d, e, c, b]));
		this._fill();
		this.checkRect(d, e, c, b)
	};
	d.lineStyle = function(d, e, c, b, a, h, u, D) {
		void 0 === d && (d = NaN);
		void 0 === e && (e = 0);
		void 0 === c && (c = 1);
		void 0 === b && (b = !1);
		void 0 === a && (a = "normal");
		void 0 === h && (h = null);
		void 0 === u && (u = null);
		void 0 === D && (D = 3);
		this.strokeStyleColor && (this.createEndLineCommand(), this._pushCommand(this.endLineCommand));
		this.strokeStyleColor = e = "rgba(" + (e >> 16) + "," + ((e & 65280) >> 8) + "," + (e & 255) + "," + c + ")";
		this._pushCommand(new f(function(a, b) {
			this.canvasContext.lineWidth = a;
			this.canvasContext.strokeStyle = b;
			this.canvasContext.beginPath()
		}, this, [d, e]));
		this.moveTo(this.lineX, this.lineY)
	};
	d.lineTo = function(d, e) {
		this._pushCommand(new f(function(c, b) {
			var a = this.renderContext;
			this.canvasContext.lineTo(a._transformTx + c, a._transformTy + b)
		}, this, [d, e]));
		this.checkPoint(this.lineX, this.lineY);
		this.lineX = d;
		this.lineY = e;
		this.checkPoint(d, e)
	};
	d.curveTo = function(d, e, c, b) {
		this._pushCommand(new f(function(a, b, c, e) {
			var d = this.renderContext;
			this.canvasContext.quadraticCurveTo(d._transformTx + a, d._transformTy + b, d._transformTx + c, d._transformTy + e)
		}, this, [d, e, c, b]));
		this.checkPoint(this.lineX, this.lineY);
		this.lineX = c;
		this.lineY = b;
		this.checkPoint(d, e);
		this.checkPoint(c, b)
	};
	d.moveTo = function(d, e) {
		this._pushCommand(new f(function(c, b) {
			var a = this.renderContext;
			this.canvasContext.moveTo(a._transformTx + c, a._transformTy + b)
		}, this, [d, e]))
	};
	d.clear = function() {
		this.lineY = this.lineX = this.commandQueue.length = 0;
		this.fillStyleColor = this.strokeStyleColor = null;
		this._dirty = !1;
		this._maxY = this._maxX = this._minY = this._minX = 0;
		this._firstCheck = !0
	};
	d.createEndFillCommand = function() {
		this.endFillCommand || (this.endFillCommand = new f(function() {
			this.canvasContext.fill();
			this.canvasContext.closePath()
		}, this, null))
	};
	d.endFill = function() {
		null != this.fillStyleColor && this._fill()
	};
	d._fill = function() {
		this.fillStyleColor && (this.createEndFillCommand(), this._pushCommand(this.endFillCommand), this.fillStyleColor = null);
		this.strokeStyleColor && (this.createEndLineCommand(), this._pushCommand(this.endLineCommand))
	};
	d.createEndLineCommand = function() {
		this.endLineCommand || (this.endLineCommand = new f(function() {
			this.canvasContext.stroke();
			this.canvasContext.closePath()
		}, this, null))
	};
	d._pushCommand = function(d) {
		this.commandQueue.push(d);
		this._dirty = !0
	};
	d._draw = function(d) {
		var e = this.commandQueue.length;
		if (0 != e) {
			this.renderContext = d;
			d = this.canvasContext = this.renderContext.drawCanvasContext;
			d.save();
			this.strokeStyleColor && 0 < e && this.commandQueue[e - 1] != this.endLineCommand && (this.createEndLineCommand(), this._pushCommand(this.endLineCommand), e = this.commandQueue.length);
			for (var c = 0; c < e; c++) {
				var b = this.commandQueue[c];
				b.method.apply(b.thisObject, b.args)
			}
			d.restore();
			this._dirty = !1
		}
	};
	var f = function() {
			return function(d, e, c) {
				this.method = d;
				this.thisObject = e;
				this.args = c
			}
		}();
	f.prototype.__class__ = "egret_h5_graphics.Command";
	d._setStyle = function(d) {
		this.canvasContext.fillStyle = d;
		this.canvasContext.beginPath()
	};
	d.init = function() {
		for (var f in d) egret.Graphics.prototype[f] = d[f];
		egret.RendererContext.createRendererContext = function(e) {
			return new egret.HTML5CanvasRenderer(e, !1)
		}
	}
})(egret_h5_graphics || (egret_h5_graphics = {}));
egret_h5_graphics.init();
(function(d) {
	var f = function(f) {
			function e(b) {
				f.call(this);
				this.glID = this.gl = this.canvas = null;
				this.size = 2E3;
				this.vertices = null;
				this.vertSize = 5;
				this.indices = null;
				this.projectionY = this.projectionX = NaN;
				this.shaderManager = null;
				this.contextLost = !1;
				this.glContextId = 0;
				this.currentBlendMode = "";
				this.currentBaseTexture = null;
				this.currentBatchSize = 0;
				this.worldTransform = null;
				this.worldAlpha = 1;
				this.maskList = [];
				this.maskDataFreeList = [];
				this.graphicsIndexBuffer = this.graphicsBuffer = this.graphicsIndices = this.graphicsPoints = this.filterType = this.colorTransformMatrix = null;
				this.graphicsStyle = {};
				this.canvas = b || this.createCanvas();
				this.canvas.addEventListener("webglcontextlost", this.handleContextLost.bind(this), !1);
				this.canvas.addEventListener("webglcontextrestored", this.handleContextRestored.bind(this), !1);
				this.html5Canvas = document.createElement("canvas");
				this.canvasContext = new d.HTML5CanvasRenderer(this.html5Canvas);
				this.onResize();
				this.projectionX = this.canvas.width / 2;
				this.projectionY = -this.canvas.height / 2;
				b = 6 * this.size;
				this.vertices = new Float32Array(4 * this.size * this.vertSize);
				this.indices = new Uint16Array(b);
				for (var a = 0, h = 0; a < b; a += 6, h += 4) this.indices[a + 0] = h + 0, this.indices[a + 1] = h + 1, this.indices[a + 2] = h + 2, this.indices[a + 3] = h + 0, this.indices[a + 4] = h + 2, this.indices[a + 5] = h + 3;
				this.initWebGL();
				this.shaderManager = new d.WebGLShaderManager(this.gl);
				this.worldTransform = new d.Matrix;
				this.initAll()
			}
			__extends(e, f);
			var c = e.prototype;
			c.onRenderFinish = function() {
				this._drawWebGL()
			};
			c.initAll = function() {
				e.isInit || (e.isInit = !0, egret_webgl_graphics.init(), d.TextField.prototype._makeBitmapCache = function() {
					this.renderTexture || (this.renderTexture = new d.RenderTexture);
					var b = this.getBounds(d.Rectangle.identity);
					if (0 == b.width || 0 == b.height) return this._texture_to_render = null, !1;
					this._bitmapData || (this._bitmapData = document.createElement("canvas"), this.renderContext = d.RendererContext.createRendererContext(this._bitmapData));
					var a = b.width,
						b = b.height,
						h, c, e = d.MainContext.instance.rendererContext._texture_scale_factor;
					h = a / e;
					c = b / e;
					h = Math.round(h);
					c = Math.round(c);
					var f = this._bitmapData;
					f.width = h;
					f.height = c;
					f.style.width = h + "px";
					f.style.height = c + "px";
					this.renderContext._cacheCanvas && (this.renderContext._cacheCanvas.width = h, this.renderContext._cacheCanvas.height = c);
					this._worldTransform.identity();
					this._worldTransform.a = 1 / e;
					this._worldTransform.d = 1 / e;
					this.renderContext.setTransform(this._worldTransform);
					this.worldAlpha = 1;
					e = d.RenderFilter.getInstance();
					f = e._drawAreaList.concat();
					e._drawAreaList.length = 0;
					this.renderContext.clearScreen();
					this.renderContext.onRenderStart();
					d.RendererContext.deleteTexture(this.renderTexture);
					this._colorTransform && this.renderContext.setGlobalColorTransform(this._colorTransform.matrix);
					var g = this.mask || this._scrollRect;
					g && this.renderContext.pushMask(g);
					this._render(this.renderContext);
					g && this.renderContext.popMask();
					this._colorTransform && this.renderContext.setGlobalColorTransform(null);
					d.RenderTexture.identityRectangle.width = h;
					d.RenderTexture.identityRectangle.height = c;
					e.addDrawArea(d.RenderTexture.identityRectangle);
					this.renderContext.onRenderFinish();
					e._drawAreaList = f;
					this.renderTexture._bitmapData = this._bitmapData;
					this.renderTexture._sourceWidth = h;
					this.renderTexture._sourceHeight = c;
					this.renderTexture._textureWidth = a;
					this.renderTexture._textureHeight = b;
					this._texture_to_render = this.renderTexture;
					return !0
				}, d.TextField.prototype._draw = function(b) {
					this._properties._type == d.TextFieldType.INPUT && this._isTyping || (this.getDirty() && (this._texture_to_render = this.renderTexture, this._cacheAsBitmap = !0), d.DisplayObject.prototype._draw.call(this, b))
				}, d.RenderTexture.prototype.init = function() {
					this._bitmapData = document.createElement("canvas");
					this.canvasContext = this._bitmapData.getContext("2d");
					this._webglBitmapData = document.createElement("canvas");
					this.renderContext = new d.WebGLRenderer(this._webglBitmapData)
				}, d.RenderTexture.prototype.setSize = function(b, a) {
					if (this._webglBitmapData) {
						var h = this._webglBitmapData;
						h.width = b;
						h.height = a;
						h.style.width = b + "px";
						h.style.height = a + "px";
						this.renderContext.projectionX = b / 2;
						this.renderContext.projectionY = -a / 2;
						this.renderContext.viewportScale = d.MainContext.instance.rendererContext._texture_scale_factor
					}
				}, d.RenderTexture.prototype.end = function() {}, d.RenderTexture.prototype.drawToTexture = function(b, a, h) {
					var c = a || b.getBounds(d.Rectangle.identity);
					if (0 == c.width || 0 == c.height) return !1;
					"undefined" == typeof h && (h = 1);
					this._bitmapData || (this._bitmapData = document.createElement("canvas"), this.canvasContext = this._bitmapData.getContext("2d"), d.RenderTexture.WebGLCanvas || (d.RenderTexture.WebGLCanvas = document.createElement("canvas"), d.RenderTexture.WebGLRenderer = new d.WebGLRenderer(d.RenderTexture.WebGLCanvas)), this._webglBitmapData = d.RenderTexture.WebGLCanvas, this.renderContext = d.RenderTexture.WebGLRenderer);
					var e = c.x,
						f = c.y,
						g = c.width,
						c = c.height,
						c = c / h,
						k = d.MainContext.instance.rendererContext._texture_scale_factor,
						g = Math.round(g / h),
						c = Math.round(c);
					this.setSize(g, c);
					var l = this._bitmapData,
						m = g / k * h,
						n = c / k * h;
					l.width = m;
					l.height = n;
					l.style.width = m + "px";
					l.style.height = n + "px";
					this.begin();
					b._worldTransform.identity();
					l = b._anchorOffsetX;
					m = b._anchorOffsetY;
					if (0 != b._anchorX || 0 != b._anchorY) l = b._anchorX * g, m = b._anchorY * c;
					this._offsetX = e + l;
					this._offsetY = f + m;
					b._worldTransform.append(1, 0, 0, 1, -this._offsetX, -this._offsetY);
					a && (this._offsetX -= e, this._offsetY -= f);
					b.worldAlpha = 1;
					a = d.MainContext.__use_new_draw;
					d.MainContext.__use_new_draw = !1;
					if (b instanceof d.DisplayObjectContainer) for (e = b._children, f = 0, l = e.length; f < l; f++) e[f]._updateTransform();
					this.renderContext.setTransform(b._worldTransform);
					e = d.RenderFilter.getInstance();
					f = e._drawAreaList.concat();
					e._drawAreaList.length = 0;
					l = this.renderContext.gl;
					l.viewport(0, 0, g, c);
					l.bindFramebuffer(l.FRAMEBUFFER, null);
					l.clearColor(0, 0, 0, 0);
					l.clear(l.COLOR_BUFFER_BIT);
					this.renderContext.onRenderStart();
					d.RendererContext.deleteTexture(this);
					b._filter && this.renderContext.setGlobalFilter(b._filter);
					b._colorTransform && this.renderContext.setGlobalColorTransform(b._colorTransform.matrix);
					(l = b.mask || b._scrollRect) && this.renderContext.pushMask(l);
					b._render(this.renderContext);
					this.renderContext._drawWebGL();
					d.MainContext.__use_new_draw = a;
					l && this.renderContext.popMask();
					b._colorTransform && this.renderContext.setGlobalColorTransform(null);
					b._filter && this.renderContext.setGlobalFilter(null);
					d.RenderTexture.identityRectangle.width = g;
					d.RenderTexture.identityRectangle.height = c;
					e.addDrawArea(d.RenderTexture.identityRectangle);
					this.renderContext.onRenderFinish();
					e._drawAreaList = f;
					this._sourceWidth = g / k * h;
					this._sourceHeight = c / k * h;
					this._textureWidth = g * h;
					this._textureHeight = c * h;
					this.canvasContext.drawImage(this._webglBitmapData, 0, 0, g, c, 0, 0, this._sourceWidth, this._sourceHeight);
					return !0
				})
			};
			c.createCanvas = function() {
				var b = d.Browser.getInstance().$("#egretCanvas");
				if (!b) {
					var a = document.getElementById(d.StageDelegate.canvas_div_name),
						b = d.Browser.getInstance().$new("canvas");
					b.id = "egretCanvas";
					a.appendChild(b)
				}
				d.MainContext.instance.stage.addEventListener(d.Event.RESIZE, this.onResize, this);
				return b
			};
			c.onResize = function() {
				var b = document.getElementById(d.StageDelegate.canvas_div_name);
				this.canvas && (this.canvas.width = d.MainContext.instance.stage.stageWidth, this.canvas.height = d.MainContext.instance.stage.stageHeight, this.canvas.style.width = b.style.width, this.canvas.style.height = b.style.height, this.projectionX = this.canvas.width / 2, this.projectionY = -this.canvas.height / 2);
				this.html5Canvas && (this.html5Canvas.width = d.MainContext.instance.stage.stageWidth, this.html5Canvas.height = d.MainContext.instance.stage.stageHeight, this.html5Canvas.style.width = b.style.width, this.html5Canvas.style.height = b.style.height)
			};
			c.handleContextLost = function() {
				this.contextLost = !0
			};
			c.handleContextRestored = function() {
				this.initWebGL();
				this.shaderManager.setContext(this.gl);
				this.contextLost = !1
			};
			c.initWebGL = function() {
				for (var b = {}, a, h = ["experimental-webgl", "webgl"], c = 0; c < h.length; c++) {
					try {
						a = this.canvas.getContext(h[c], b)
					} catch (f) {}
					if (a) break
				}
				if (!a) throw Error(d.getString(1021));
				e.glID++;
				this.glID = e.glID;
				this.setContext(a)
			};
			c.setContext = function(b) {
				this.gl = b;
				b.id = this.glContextId++;
				this.vertexBuffer = b.createBuffer();
				this.indexBuffer = b.createBuffer();
				b.bindBuffer(b.ELEMENT_ARRAY_BUFFER, this.indexBuffer);
				b.bufferData(b.ELEMENT_ARRAY_BUFFER, this.indices, b.STATIC_DRAW);
				b.bindBuffer(b.ARRAY_BUFFER, this.vertexBuffer);
				b.bufferData(b.ARRAY_BUFFER, this.vertices, b.DYNAMIC_DRAW);
				b.disable(b.DEPTH_TEST);
				b.disable(b.CULL_FACE);
				b.enable(b.BLEND);
				b.colorMask(!0, !0, !0, !0)
			};
			c.start = function() {
				if (!this.contextLost) {
					var b = this.gl;
					b.activeTexture(b.TEXTURE0);
					b.bindBuffer(b.ARRAY_BUFFER, this.vertexBuffer);
					b.bindBuffer(b.ELEMENT_ARRAY_BUFFER, this.indexBuffer);
					var a;
					a = this.colorTransformMatrix ? this.shaderManager.colorTransformShader : "blur" == this.filterType ? this.shaderManager.blurShader : this.shaderManager.defaultShader;
					this.shaderManager.activateShader(a);
					a.syncUniforms();
					b.uniform2f(a.projectionVector, this.projectionX, this.projectionY);
					var h = 4 * this.vertSize;
					b.vertexAttribPointer(a.aVertexPosition, 2, b.FLOAT, !1, h, 0);
					b.vertexAttribPointer(a.aTextureCoord, 2, b.FLOAT, !1, h, 8);
					b.vertexAttribPointer(a.colorAttribute, 2, b.FLOAT, !1, h, 16)
				}
			};
			c.clearScreen = function() {
				var b = this.gl;
				b.colorMask(!0, !0, !0, !0);
				for (var a = d.RenderFilter.getInstance().getDrawAreaList(), h = 0, c = a.length; h < c; h++) {
					var e = a[h];
					b.viewport(e.x, e.y, e.width, e.height);
					b.bindFramebuffer(b.FRAMEBUFFER, null);
					b.clearColor(0, 0, 0, 0);
					b.clear(b.COLOR_BUFFER_BIT)
				}
				a = d.MainContext.instance.stage;
				b.viewport(0, 0, a.stageWidth, a.stageHeight);
				this.renderCost = 0
			};
			c.setBlendMode = function(b) {
				b || (b = d.BlendMode.NORMAL);
				if (this.currentBlendMode != b) {
					var a = d.RendererContext.blendModesForGL[b];
					a && (this._drawWebGL(), this.gl.blendFunc(a[0], a[1]), this.currentBlendMode = b)
				}
			};
			c.drawRepeatImage = function(b, a, h, c, e, f, g, k, l, m) {
				m = d.MainContext.instance.rendererContext._texture_scale_factor;
				c *= m;
				for (e *= m; f < k; f += c) for (var n = g; n < l; n += e) {
					var p = Math.min(c, k - f),
						q = Math.min(e, l - n);
					this.drawImage(b, a, h, p / m, q / m, f, n, p, q)
				}
			};
			c.drawImage = function(b, a, h, c, e, d, f, g, l, m) {
				void 0 === m && (m = void 0);
				if (!this.contextLost) if (void 0 !== m) this.drawRepeatImage(b, a, h, c, e, d, f, g, l, m);
				else {
					this.createWebGLTexture(b);
					m = b._bitmapData.webGLTexture[this.glID];
					if (m !== this.currentBaseTexture || this.currentBatchSize >= this.size - 1) this._drawWebGL(), this.currentBaseTexture = m;
					var n = this.worldTransform,
						p = n.a,
						q = n.b,
						x = n.c,
						z = n.d,
						t = n.tx,
						y = n.ty;
					0 == d && 0 == f || n.append(1, 0, 0, 1, d, f);
					1 == c / g && 1 == e / l || n.append(g / c, 0, 0, l / e, 0, 0);
					d = n.a;
					f = n.b;
					g = n.c;
					l = n.d;
					m = n.tx;
					var w = n.ty;
					n.a = p;
					n.b = q;
					n.c = x;
					n.d = z;
					n.tx = t;
					n.ty = y;
					p = b._sourceWidth;
					q = b._sourceHeight;
					b = c;
					n = e;
					a /= p;
					h /= q;
					c /= p;
					e /= q;
					p = this.vertices;
					q = 4 * this.currentBatchSize * this.vertSize;
					x = this.worldAlpha;
					p[q++] = m;
					p[q++] = w;
					p[q++] = a;
					p[q++] = h;
					p[q++] = x;
					p[q++] = d * b + m;
					p[q++] = f * b + w;
					p[q++] = c + a;
					p[q++] = h;
					p[q++] = x;
					p[q++] = d * b + g * n + m;
					p[q++] = l * n + f * b + w;
					p[q++] = c + a;
					p[q++] = e + h;
					p[q++] = x;
					p[q++] = g * n + m;
					p[q++] = l * n + w;
					p[q++] = a;
					p[q++] = e + h;
					p[q++] = x;
					this.currentBatchSize++
				}
			};
			c._drawWebGL = function() {
				if (0 != this.currentBatchSize && !this.contextLost) {
					var b = d.getTimer();
					this.start();
					var a = this.gl;
					a.bindTexture(a.TEXTURE_2D, this.currentBaseTexture);
					var h = this.vertices.subarray(0, 4 * this.currentBatchSize * this.vertSize);
					a.bufferSubData(a.ARRAY_BUFFER, 0, h);
					a.drawElements(a.TRIANGLES, 6 * this.currentBatchSize, a.UNSIGNED_SHORT, 0);
					this.currentBatchSize = 0;
					this.renderCost += d.getTimer() - b;
					d.Profiler.getInstance().onDrawImage()
				}
			};
			c.setTransform = function(b) {
				var a = this.worldTransform;
				a.a = b.a;
				a.b = b.b;
				a.c = b.c;
				a.d = b.d;
				a.tx = b.tx;
				a.ty = b.ty
			};
			c.setAlpha = function(b, a) {
				this.worldAlpha = b;
				this.setBlendMode(a)
			};
			c.createWebGLTexture = function(b) {
				b = b._bitmapData;
				b.webGLTexture || (b.webGLTexture = {});
				if (!b.webGLTexture[this.glID]) {
					var a = this.gl;
					b.webGLTexture[this.glID] = a.createTexture();
					a.bindTexture(a.TEXTURE_2D, b.webGLTexture[this.glID]);
					a.pixelStorei(a.UNPACK_PREMULTIPLY_ALPHA_WEBGL, !0);
					a.texImage2D(a.TEXTURE_2D, 0, a.RGBA, a.RGBA, a.UNSIGNED_BYTE, b);
					a.texParameteri(a.TEXTURE_2D, a.TEXTURE_MAG_FILTER, a.LINEAR);
					a.texParameteri(a.TEXTURE_2D, a.TEXTURE_MIN_FILTER, a.LINEAR);
					a.texParameteri(a.TEXTURE_2D, a.TEXTURE_WRAP_S, a.CLAMP_TO_EDGE);
					a.texParameteri(a.TEXTURE_2D, a.TEXTURE_WRAP_T, a.CLAMP_TO_EDGE);
					a.bindTexture(a.TEXTURE_2D, null)
				}
			};
			c.pushMask = function(b) {
				this._drawWebGL();
				var a = this.gl;
				0 == this.maskList.length && a.enable(a.SCISSOR_TEST);
				b = this.getScissorRect(b);
				this.maskList.push(b);
				this.scissor(b.x, b.y, b.width, b.height)
			};
			c.getScissorRect = function(b) {
				var a = this.maskList[this.maskList.length - 1],
					h, c, e;
				a ? a.intersects(a) ? (h = Math.max(b.x + this.worldTransform.tx, a.x), c = Math.max(b.y + this.worldTransform.ty, a.y), e = Math.min(b.x + this.worldTransform.tx + b.width, a.x + a.width) - h, b = Math.min(b.y + this.worldTransform.ty + b.height, a.y + a.height) - c) : b = e = c = h = 0 : (h = b.x + this.worldTransform.tx, c = b.y + this.worldTransform.ty, e = b.width, b = b.height);
				(a = this.maskDataFreeList.pop()) ? (a.x = h, a.y = c, a.width = e, a.height = b) : a = new d.Rectangle(h, c, e, b);
				return a
			};
			c.popMask = function() {
				this._drawWebGL();
				var b = this.gl,
					a = this.maskList.pop();
				this.maskDataFreeList.push(a);
				a = this.maskList.length;
				0 != a ? (a = this.maskList[a - 1], (0 < a.width || 0 < a.height) && this.scissor(a.x, a.y, a.width, a.height)) : b.disable(b.SCISSOR_TEST)
			};
			c.scissor = function(b, a, h, c) {
				var e = this.gl;
				0 > h && (h = 0);
				0 > c && (c = 0);
				e.scissor(b, -a + d.MainContext.instance.stage.stageHeight - c, h, c)
			};
			c.setGlobalColorTransform = function(b) {
				if (this.colorTransformMatrix != b && (this._drawWebGL(), this.colorTransformMatrix = b)) {
					b = b.concat();
					var a = this.shaderManager.colorTransformShader;
					a.uniforms.colorAdd.value.w = b.splice(19, 1)[0] / 255;
					a.uniforms.colorAdd.value.z = b.splice(14, 1)[0] / 255;
					a.uniforms.colorAdd.value.y = b.splice(9, 1)[0] / 255;
					a.uniforms.colorAdd.value.x = b.splice(4, 1)[0] / 255;
					a.uniforms.matrix.value = b
				}
			};
			c.setGlobalFilter = function(b) {
				this._drawWebGL();
				this.setFilterProperties(b)
			};
			c.setFilterProperties = function(b) {
				if (b) switch (this.filterType = b.type, b.type) {
				case "blur":
					var a = this.shaderManager.blurShader;
					a.uniforms.blur.value.x = b.blurX;
					a.uniforms.blur.value.y = b.blurY
				} else this.filterType = null
			};
			c.setupFont = function(b, a) {
				void 0 === a && (a = null);
				this.canvasContext.setupFont(b, a)
			};
			c.measureText = function(b) {
				return this.canvasContext.measureText(b)
			};
			c.renderGraphics = function(b) {
				this._drawWebGL();
				var a = this.gl,
					h = this.shaderManager.primitiveShader;
				this.graphicsPoints ? (this.graphicsPoints.length = 0, this.graphicsIndices.length = 0) : (this.graphicsPoints = [], this.graphicsIndices = [], this.graphicsBuffer = a.createBuffer(), this.graphicsIndexBuffer = a.createBuffer());
				this.updateGraphics(b);
				this.shaderManager.activateShader(h);
				a.blendFunc(a.ONE, a.ONE_MINUS_SRC_ALPHA);
				a.uniformMatrix3fv(h.translationMatrix, !1, this.worldTransform.toArray(!0));
				a.uniform2f(h.projectionVector, this.projectionX, -this.projectionY);
				a.uniform2f(h.offsetVector, 0, 0);
				a.uniform3fv(h.tintColor, [1, 1, 1]);
				a.uniform1f(h.alpha, this.worldAlpha);
				a.bindBuffer(a.ARRAY_BUFFER, this.graphicsBuffer);
				a.vertexAttribPointer(h.aVertexPosition, 2, a.FLOAT, !1, 24, 0);
				a.vertexAttribPointer(h.colorAttribute, 4, a.FLOAT, !1, 24, 8);
				a.bindBuffer(a.ELEMENT_ARRAY_BUFFER, this.graphicsIndexBuffer);
				a.drawElements(a.TRIANGLE_STRIP, this.graphicsIndices.length, a.UNSIGNED_SHORT, 0);
				this.shaderManager.activateShader(this.shaderManager.defaultShader)
			};
			c.updateGraphics = function(b) {
				var a = this.gl;
				this.buildRectangle(b);
				a.bindBuffer(a.ARRAY_BUFFER, this.graphicsBuffer);
				a.bufferData(a.ARRAY_BUFFER, new Float32Array(this.graphicsPoints), a.STATIC_DRAW);
				a.bindBuffer(a.ELEMENT_ARRAY_BUFFER, this.graphicsIndexBuffer);
				a.bufferData(a.ELEMENT_ARRAY_BUFFER, new Uint16Array(this.graphicsIndices), a.STATIC_DRAW)
			};
			c.buildRectangle = function(b) {
				var a = b.x,
					h = b.y,
					c = b.w;
				b = b.h;
				var e = this.graphicsStyle.a,
					d = this.graphicsStyle.r * e,
					f = this.graphicsStyle.g * e,
					g = this.graphicsStyle.b * e,
					l = this.graphicsPoints,
					m = this.graphicsIndices,
					n = l.length / 6;
				l.push(a, h);
				l.push(d, f, g, e);
				l.push(a + c, h);
				l.push(d, f, g, e);
				l.push(a, h + b);
				l.push(d, f, g, e);
				l.push(a + c, h + b);
				l.push(d, f, g, e);
				m.push(n, n, n + 1, n + 2, n + 3, n + 3)
			};
			c.setGraphicsStyle = function(b, a, h, c) {
				this.graphicsStyle.r = b;
				this.graphicsStyle.g = a;
				this.graphicsStyle.b = h;
				this.graphicsStyle.a = c
			};
			e.glID = 0;
			e.isInit = !1;
			return e
		}(d.RendererContext);
	d.WebGLRenderer = f;
	f.prototype.__class__ = "egret.WebGLRenderer"
})(egret || (egret = {}));
var egret_webgl_graphics;
(function(d) {
	d.beginFill = function(d, e) {
		void 0 === e && (e = 1);
		this._pushCommand(new f(this._setStyle, this, [(d >> 16) / 255, ((d & 65280) >> 8) / 255, (d & 255) / 255, e]))
	};
	d.drawRect = function(d, e, c, b) {
		this._pushCommand(new f(function(a) {
			this.renderContext.renderGraphics(a)
		}, this, [{
			x: d,
			y: e,
			w: c,
			h: b
		}]));
		this.checkRect(d, e, c, b)
	};
	d.drawCircle = function(d, e, c) {};
	d.drawRoundRect = function(d, e, c, b, a, h) {};
	d.drawEllipse = function(d, e, c, b) {};
	d.lineStyle = function(d, e, c, b, a, h, f, D) {};
	d.lineTo = function(d, e) {};
	d.curveTo = function(d, e, c, b) {};
	d.moveTo = function(d, e) {};
	d.clear = function() {
		this._maxY = this._maxX = this._minY = this._minX = this.commandQueue.length = 0
	};
	d.endFill = function() {};
	d._pushCommand = function(d) {
		this.commandQueue.push(d)
	};
	d._draw = function(d) {
		var e = this.commandQueue.length;
		if (0 != e) for (this.renderContext = d, d = 0; d < e; d++) {
			var c = this.commandQueue[d];
			c.method.apply(c.thisObject, c.args)
		}
	};
	var f = function() {
			return function(d, e, c) {
				this.method = d;
				this.thisObject = e;
				this.args = c
			}
		}();
	f.prototype.__class__ = "egret_webgl_graphics.Command";
	d._setStyle = function(d, e, c, b) {
		this.renderContext.setGraphicsStyle(d, e, c, b)
	};
	d.init = function() {
		for (var f in d) egret.Graphics.prototype[f] = d[f]
	}
})(egret_webgl_graphics || (egret_webgl_graphics = {}));
(function(d) {
	var f = function() {
			function f() {}
			f.compileProgram = function(e, c, b) {
				b = f.compileFragmentShader(e, b);
				c = f.compileVertexShader(e, c);
				var a = e.createProgram();
				e.attachShader(a, c);
				e.attachShader(a, b);
				e.linkProgram(a);
				e.getProgramParameter(a, e.LINK_STATUS) || d.Logger.infoWithErrorId(1020);
				return a
			};
			f.compileFragmentShader = function(e, c) {
				return f._compileShader(e, c, e.FRAGMENT_SHADER)
			};
			f.compileVertexShader = function(e, c) {
				return f._compileShader(e, c, e.VERTEX_SHADER)
			};
			f._compileShader = function(e, c, b) {
				b = e.createShader(b);
				e.shaderSource(b, c);
				e.compileShader(b);
				return e.getShaderParameter(b, e.COMPILE_STATUS) ? b : (d.Logger.info(e.getShaderInfoLog(b)), null)
			};
			f.checkCanUseWebGL = function() {
				if (void 0 == f.canUseWebGL) try {
					var e = document.createElement("canvas");
					f.canUseWebGL = !! window.WebGLRenderingContext && !(!e.getContext("webgl") && !e.getContext("experimental-webgl"))
				} catch (c) {
					f.canUseWebGL = !1
				}
				return f.canUseWebGL
			};
			return f
		}();
	d.WebGLUtils = f;
	f.prototype.__class__ = "egret.WebGLUtils"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f(c) {
				this.defaultVertexSrc = "attribute vec2 aVertexPosition;\nattribute vec2 aTextureCoord;\nattribute vec2 aColor;\nuniform vec2 projectionVector;\nuniform vec2 offsetVector;\nvarying vec2 vTextureCoord;\nvarying vec4 vColor;\nconst vec2 center = vec2(-1.0, 1.0);\nvoid main(void) {\n   gl_Position = vec4( ((aVertexPosition + offsetVector) / projectionVector) + center , 0.0, 1.0);\n   vTextureCoord = aTextureCoord;\n   vColor = vec4(aColor.x, aColor.x, aColor.x, aColor.x);\n}";
				this.program = this.gl = null;
				this.fragmentSrc = "precision lowp float;\nvarying vec2 vTextureCoord;\nvarying vec4 vColor;\nuniform sampler2D uSampler;\nvoid main(void) {\ngl_FragColor = texture2D(uSampler, vTextureCoord) * vColor ;\n}";
				this.uniforms = null;
				this.gl = c;
				this.init()
			}
			var e = f.prototype;
			e.init = function() {
				var c = this.gl,
					b = d.WebGLUtils.compileProgram(c, this.defaultVertexSrc, this.fragmentSrc);
				c.useProgram(b);
				this.uSampler = c.getUniformLocation(b, "uSampler");
				this.projectionVector = c.getUniformLocation(b, "projectionVector");
				this.offsetVector = c.getUniformLocation(b, "offsetVector");
				this.dimensions = c.getUniformLocation(b, "dimensions");
				this.aVertexPosition = c.getAttribLocation(b, "aVertexPosition");
				this.aTextureCoord = c.getAttribLocation(b, "aTextureCoord");
				this.colorAttribute = c.getAttribLocation(b, "aColor"); - 1 === this.colorAttribute && (this.colorAttribute = 2);
				this.attributes = [this.aVertexPosition, this.aTextureCoord, this.colorAttribute];
				for (var a in this.uniforms) this.uniforms[a].uniformLocation = c.getUniformLocation(b, a);
				this.initUniforms();
				this.program = b
			};
			e.initUniforms = function() {
				if (this.uniforms) {
					var c = this.gl,
						b, a;
					for (a in this.uniforms) {
						b = this.uniforms[a];
						var h = b.type;
						"mat2" === h || "mat3" === h || "mat4" === h ? (b.glMatrix = !0, b.glValueLength = 1, "mat2" === h ? b.glFunc = c.uniformMatrix2fv : "mat3" === h ? b.glFunc = c.uniformMatrix3fv : "mat4" === h && (b.glFunc = c.uniformMatrix4fv)) : (b.glFunc = c["uniform" + h], b.glValueLength = "2f" === h || "2i" === h ? 2 : "3f" === h || "3i" === h ? 3 : "4f" === h || "4i" === h ? 4 : 1)
					}
				}
			};
			e.syncUniforms = function() {
				if (this.uniforms) {
					var c, b = this.gl,
						a;
					for (a in this.uniforms) c = this.uniforms[a], 1 === c.glValueLength ? !0 === c.glMatrix ? c.glFunc.call(b, c.uniformLocation, c.transpose, c.value) : c.glFunc.call(b, c.uniformLocation, c.value) : 2 === c.glValueLength ? c.glFunc.call(b, c.uniformLocation, c.value.x, c.value.y) : 3 === c.glValueLength ? c.glFunc.call(b, c.uniformLocation, c.value.x, c.value.y, c.value.z) : 4 === c.glValueLength && c.glFunc.call(b, c.uniformLocation, c.value.x, c.value.y, c.value.z, c.value.w)
				}
			};
			return f
		}();
	d.EgretShader = f;
	f.prototype.__class__ = "egret.EgretShader"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(c) {
				d.call(this, c);
				this.fragmentSrc = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec4 vColor;\nuniform float invert;\nuniform mat4 matrix;\nuniform vec4 colorAdd;\nuniform sampler2D uSampler;\nvoid main(void) {\nvec4 locColor = texture2D(uSampler, vTextureCoord) * matrix;\nif(locColor.a != 0.0){\nlocColor += colorAdd;\n}\ngl_FragColor = locColor;\n}";
				this.uniforms = {
					matrix: {
						type: "mat4",
						value: [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1]
					},
					colorAdd: {
						type: "4f",
						value: {
							x: 0,
							y: 0,
							z: 0,
							w: 0
						}
					}
				};
				this.init()
			}
			__extends(e, d);
			return e
		}(d.EgretShader);
	d.ColorTransformShader = f;
	f.prototype.__class__ = "egret.ColorTransformShader"
})(egret || (egret = {}));
(function(d) {
	var f = function(d) {
			function e(c) {
				d.call(this, c);
				this.fragmentSrc = "precision mediump float;uniform vec2 blur;uniform sampler2D uSampler;varying vec2 vTextureCoord;void main(){gl_FragColor = vec4(0.0);gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.028 * blur.x, -0.028 * blur.y))) * 0.0044299121055113265;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.024 * blur.x, -0.024 * blur.y))) * 0.00895781211794;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.020 * blur.x, -0.020 * blur.y))) * 0.0215963866053;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.016 * blur.x, -0.016 * blur.y))) * 0.0443683338718;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.012 * blur.x, -0.012 * blur.y))) * 0.0776744219933;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.008 * blur.x, -0.008 * blur.y))) * 0.115876621105;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2(-0.004 * blur.x, -0.004 * blur.y))) * 0.147308056121;gl_FragColor += texture2D(uSampler, vTextureCoord) * 0.159576912161;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.004 * blur.x,  0.004 * blur.y))) * 0.147308056121;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.008 * blur.x,  0.008 * blur.y))) * 0.115876621105;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.012 * blur.x,  0.012 * blur.y))) * 0.0776744219933;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.016 * blur.x,  0.016 * blur.y))) * 0.0443683338718;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.020 * blur.x,  0.020 * blur.y))) * 0.0215963866053;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.024 * blur.x,  0.024 * blur.y))) * 0.00895781211794;gl_FragColor += texture2D(uSampler, (vTextureCoord + vec2( 0.028 * blur.x,  0.028 * blur.y))) * 0.0044299121055113265;}";
				this.uniforms = {
					blur: {
						type: "2f",
						value: {
							x: 2,
							y: 2
						}
					}
				};
				this.init()
			}
			__extends(e, d);
			return e
		}(d.EgretShader);
	d.BlurShader = f;
	f.prototype.__class__ = "egret.BlurShader"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f(e) {
				this.alpha = this.translationMatrix = this.attributes = this.colorAttribute = this.aVertexPosition = this.tintColor = this.offsetVector = this.projectionVector = this.program = this.gl = null;
				this.fragmentSrc = "precision mediump float;\nvarying vec4 vColor;\nvoid main(void) {\n   gl_FragColor = vColor;\n}";
				this.vertexSrc = "attribute vec2 aVertexPosition;\nattribute vec4 aColor;\nuniform mat3 translationMatrix;\nuniform vec2 projectionVector;\nuniform vec2 offsetVector;\nuniform float alpha;\nuniform vec3 tint;\nvarying vec4 vColor;\nvoid main(void) {\n   vec3 v = translationMatrix * vec3(aVertexPosition , 1.0);\n   v -= offsetVector.xyx;\n   gl_Position = vec4( v.x / projectionVector.x -1.0, v.y / -projectionVector.y + 1.0 , 0.0, 1.0);\n   vColor = aColor * vec4(tint * alpha, alpha);\n}";
				this.gl = e;
				this.init()
			}
			f.prototype.init = function() {
				var e = this.gl,
					c = d.WebGLUtils.compileProgram(e, this.vertexSrc, this.fragmentSrc);
				e.useProgram(c);
				this.projectionVector = e.getUniformLocation(c, "projectionVector");
				this.offsetVector = e.getUniformLocation(c, "offsetVector");
				this.tintColor = e.getUniformLocation(c, "tint");
				this.aVertexPosition = e.getAttribLocation(c, "aVertexPosition");
				this.colorAttribute = e.getAttribLocation(c, "aColor");
				this.attributes = [this.aVertexPosition, this.colorAttribute];
				this.translationMatrix = e.getUniformLocation(c, "translationMatrix");
				this.alpha = e.getUniformLocation(c, "alpha");
				this.program = c
			};
			return f
		}();
	d.PrimitiveShader = f;
	f.prototype.__class__ = "egret.PrimitiveShader"
})(egret || (egret = {}));
(function(d) {
	var f = function() {
			function f(c) {
				this.gl = null;
				this.maxAttibs = 10;
				this.attribState = [];
				this.tempAttribState = [];
				this.blurShader = this.colorTransformShader = this.primitiveShader = this.defaultShader = this.currentShader = null;
				for (var b = 0; b < this.maxAttibs; b++) this.attribState[b] = !1;
				this.setContext(c)
			}
			var e = f.prototype;
			e.setContext = function(c) {
				this.gl = c;
				this.primitiveShader = new d.PrimitiveShader(c);
				this.defaultShader = new d.EgretShader(c);
				this.colorTransformShader = new d.ColorTransformShader(c);
				this.blurShader = new d.BlurShader(c);
				this.activateShader(this.defaultShader)
			};
			e.activateShader = function(c) {
				this.currentShader != c && (this.gl.useProgram(c.program), this.setAttribs(c.attributes), this.currentShader = c)
			};
			e.setAttribs = function(c) {
				var b, a;
				a = this.tempAttribState.length;
				for (b = 0; b < a; b++) this.tempAttribState[b] = !1;
				a = c.length;
				for (b = 0; b < a; b++) this.tempAttribState[c[b]] = !0;
				c = this.gl;
				a = this.attribState.length;
				for (b = 0; b < a; b++) this.attribState[b] !== this.tempAttribState[b] && (this.attribState[b] = this.tempAttribState[b], this.tempAttribState[b] ? c.enableVertexAttribArray(b) : c.disableVertexAttribArray(b))
			};
			return f
		}();
	d.WebGLShaderManager = f;
	f.prototype.__class__ = "egret.WebGLShaderManager"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this)
			}
			__extends(e, f);
			var c = e.prototype;
			c.proceed = function(b) {
				function a() {
					if (4 == c.readyState) if (c.status != b._status && (b._status = c.status, d.HTTPStatusEvent.dispatchHTTPStatusEvent(b, c.status)), 400 <= c.status || 0 == c.status) d.IOErrorEvent.dispatchIOErrorEvent(b);
					else {
						switch (b.dataFormat) {
						case d.URLLoaderDataFormat.TEXT:
							b.data = c.responseText;
							break;
						case d.URLLoaderDataFormat.VARIABLES:
							b.data = new d.URLVariables(c.responseText);
							break;
						case d.URLLoaderDataFormat.BINARY:
							b.data = c.response;
							break;
						default:
							b.data = c.responseText
						}
						d.__callAsync(d.Event.dispatchEvent, d.Event, b, d.Event.COMPLETE)
					}
				}
				if (b.dataFormat == d.URLLoaderDataFormat.TEXTURE) this.loadTexture(b);
				else if (b.dataFormat == d.URLLoaderDataFormat.SOUND) this.loadSound(b);
				else {
					var h = b._request,
						c = this.getXHR();
					c.onreadystatechange = a;
					var e = d.NetContext._getUrl(h);
					c.open(h.method, e, !0);
					this.setResponseType(c, b.dataFormat);
					h.method != d.URLRequestMethod.GET && h.data ? h.data instanceof d.URLVariables ? (c.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), c.send(h.data.toString())) : (c.setRequestHeader("Content-Type", "multipart/form-data"), c.send(h.data)) : c.send()
				}
			};
			c.loadSound = function(b) {
				function a(e) {
					d.clearTimeout(c.__timeoutId);
					c.removeEventListener("canplaythrough", a, !1);
					c.removeEventListener("error", h, !1);
					e = new d.Sound;
					e._setAudio(c);
					b.data = e;
					d.__callAsync(d.Event.dispatchEvent, d.Event, b, d.Event.COMPLETE)
				}

				function h(e) {
					d.clearTimeout(c.__timeoutId);
					c.removeEventListener("canplaythrough", a, !1);
					c.removeEventListener("error", h, !1);
					d.IOErrorEvent.dispatchIOErrorEvent(b)
				}
				var c = new Audio(b._request.url);
				c.__timeoutId = d.setTimeout(a, this, 100);
				c.addEventListener("canplaythrough", a, !1);
				c.addEventListener("error", h, !1);
				c.load()
			};
			c.getXHR = function() {
				return window.XMLHttpRequest ? new window.XMLHttpRequest : new ActiveXObject("MSXML2.XMLHTTP")
			};
			c.setResponseType = function(b, a) {
				switch (a) {
				case d.URLLoaderDataFormat.TEXT:
				case d.URLLoaderDataFormat.VARIABLES:
					b.responseType = d.URLLoaderDataFormat.TEXT;
					break;
				case d.URLLoaderDataFormat.BINARY:
					b.responseType = "arraybuffer";
					break;
				default:
					b.responseType = a
				}
			};
			c.loadTexture = function(b) {
				var a = b._request,
					h = new Image;
				h.onload = function(a) {
					h.onerror = null;
					h.onload = null;
					a = new d.Texture;
					a._setBitmapData(h);
					b.data = a;
					d.__callAsync(d.Event.dispatchEvent, d.Event, b, d.Event.COMPLETE)
				};
				h.onerror = function(a) {
					h.onerror = null;
					h.onload = null;
					d.IOErrorEvent.dispatchIOErrorEvent(b)
				};
				h.src = a.url
			};
			return e
		}(d.NetContext);
	d.HTML5NetContext = f;
	f.prototype.__class__ = "egret.HTML5NetContext"
})(egret || (egret = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this._isTouchDown = !1;
				this.rootDiv = null;
				this.rootDiv = document.getElementById(d.StageDelegate.canvas_div_name);
				if (!this.rootDiv) {
					var b = document.getElementById(d.StageDelegate.egret_root_div);
					this.rootDiv = d.Browser.getInstance().$new("div");
					this.rootDiv.id = d.StageDelegate.canvas_div_name;
					b.appendChild(this.rootDiv)
				}
			}
			__extends(e, f);
			var c = e.prototype;
			c.prevent = function(b) {
				b.stopPropagation();
				!0 == b.isScroll || d.HTMLInput.getInstance().isInputOn() || b.preventDefault()
			};
			c.run = function() {
				var b = this;
				window.navigator.msPointerEnabled ? (this.rootDiv.addEventListener("MSPointerDown", function(a) {
					b._onTouchBegin(a);
					b.prevent(a)
				}, !1), this.rootDiv.addEventListener("MSPointerMove", function(a) {
					b._onTouchMove(a);
					b.prevent(a)
				}, !1), this.rootDiv.addEventListener("MSPointerUp", function(a) {
					b._onTouchEnd(a);
					b.prevent(a)
				}, !1)) : d.MainContext.deviceType == d.MainContext.DEVICE_MOBILE ? this.addTouchListener() : d.MainContext.deviceType == d.MainContext.DEVICE_PC && (this.addTouchListener(), this.addMouseListener());
				window.addEventListener("mousedown", function(a) {
					b.inOutOfCanvas(a) ? b.dispatchLeaveStageEvent() : b._isTouchDown = !0
				});
				window.addEventListener("mouseup", function(a) {
					b._isTouchDown && (b.inOutOfCanvas(a) ? b.dispatchLeaveStageEvent() : b._onTouchEnd(a));
					b._isTouchDown = !1
				})
			};
			c.addMouseListener = function() {
				var b = this;
				this.rootDiv.addEventListener("mousedown", function(a) {
					b._onTouchBegin(a)
				});
				this.rootDiv.addEventListener("mousemove", function(a) {
					b._onTouchMove(a)
				});
				this.rootDiv.addEventListener("mouseup", function(a) {
					b._onTouchEnd(a)
				})
			};
			c.addTouchListener = function() {
				var b = this;
				this.rootDiv.addEventListener("touchstart", function(a) {
					for (var h = a.changedTouches.length, c = 0; c < h; c++) b._onTouchBegin(a.changedTouches[c]);
					b.prevent(a)
				}, !1);
				this.rootDiv.addEventListener("touchmove", function(a) {
					for (var h = a.changedTouches.length, c = 0; c < h; c++) b._onTouchMove(a.changedTouches[c]);
					b.prevent(a)
				}, !1);
				this.rootDiv.addEventListener("touchend", function(a) {
					for (var h = a.changedTouches.length, c = 0; c < h; c++) b._onTouchEnd(a.changedTouches[c]);
					b.prevent(a)
				}, !1);
				this.rootDiv.addEventListener("touchcancel", function(a) {
					for (var h = a.changedTouches.length, c = 0; c < h; c++) b._onTouchEnd(a.changedTouches[c]);
					b.prevent(a)
				}, !1)
			};
			c.inOutOfCanvas = function(b) {
				var a = this.getLocation(this.rootDiv, b);
				b = a.x;
				var a = a.y,
					h = d.MainContext.instance.stage;
				return 0 > b || 0 > a || b > h.stageWidth || a > h.stageHeight ? !0 : !1
			};
			c.dispatchLeaveStageEvent = function() {
				this.touchingIdentifiers.length = 0;
				d.MainContext.instance.stage.dispatchEventWith(d.Event.LEAVE_STAGE)
			};
			c._onTouchBegin = function(b) {
				var a = this.getLocation(this.rootDiv, b),
					h = -1;
				b.hasOwnProperty("identifier") && (h = b.identifier);
				this.onTouchBegan(a.x, a.y, h)
			};
			c._onTouchMove = function(b) {
				var a = this.getLocation(this.rootDiv, b),
					h = -1;
				b.hasOwnProperty("identifier") && (h = b.identifier);
				this.onTouchMove(a.x, a.y, h)
			};
			c._onTouchEnd = function(b) {
				var a = this.getLocation(this.rootDiv, b),
					h = -1;
				b.hasOwnProperty("identifier") && (h = b.identifier);
				this.onTouchEnd(a.x, a.y, h)
			};
			c.getLocation = function(b, a) {
				var h = document.documentElement,
					c = window,
					e, f;
				"function" === typeof b.getBoundingClientRect ? (f = b.getBoundingClientRect(), e = f.left, f = f.top) : f = e = 0;
				e += c.pageXOffset - h.clientLeft;
				f += c.pageYOffset - h.clientTop;
				null != a.pageX ? (h = a.pageX, c = a.pageY) : (e -= document.body.scrollLeft, f -= document.body.scrollTop, h = a.clientX, c = a.clientY);
				var g = d.Point.identity;
				g.x = (h - e) / d.StageDelegate.getInstance().getScaleX();
				g.y = (c - f) / d.StageDelegate.getInstance().getScaleY();
				return g
			};
			return e
		}(d.TouchContext);
	d.HTML5TouchContext = f;
	f.prototype.__class__ = "egret.HTML5TouchContext"
})(egret || (egret = {}));
(function(d) {
	var f = function(e) {
			function c() {
				e.call(this);
				this._isNeedShow = !1;
				this.inputDiv = this.inputElement = null;
				this._gscaleY = this._gscaleX = 0;
				this._isNeesHide = !1;
				this.textValue = "";
				this._styleInfoes = {};
				g.getInstance()
			}
			__extends(c, e);
			var b = c.prototype;
			b._initElement = function(a, b, c, e) {
				var f = d.StageDelegate.getInstance().getScaleX(),
					g = d.StageDelegate.getInstance().getScaleY();
				this.inputDiv.style.left = a * f + "px";
				this.inputDiv.style.top = b * g + "px";
				this._gscaleX = f * c;
				this._gscaleY = g * e
			};
			b._show = function(a, b, c, e) {
				this._multiline = a;
				g.getInstance().isCurrentStageText(this) ? this.inputElement.onblur = null : (this.inputElement = g.getInstance().getInputElement(this), this.inputDiv = g.getInstance()._inputDIV);
				this._isNeedShow = g.getInstance()._needShow = !0
			};
			b.onBlurHandler = function() {
				g.getInstance().clearInputElement();
				window.scrollTo(0, 0)
			};
			b.executeShow = function() {
				this.inputElement.value = this._getText();
				null == this.inputElement.onblur && (this.inputElement.onblur = this.onBlurHandler);
				this._resetStageText();
				0 < this._textfield._properties._maxChars ? this.inputElement.setAttribute("maxlength", this._textfield._properties._maxChars) : this.inputElement.removeAttribute("maxlength");
				this.inputElement.selectionStart = this.inputElement.value.length;
				this.inputElement.selectionEnd = this.inputElement.value.length;
				this.inputElement.focus()
			};
			b._hide = function() {
				this._isNeesHide = !0;
				0 <= d.Browser.getInstance().getUserAgent().indexOf("ios") && g.getInstance().disconnectStageText(this)
			};
			b._getText = function() {
				this.textValue || (this.textValue = "");
				return this.textValue
			};
			b._setText = function(a) {
				this.textValue = a;
				this.resetText()
			};
			b.resetText = function() {
				this.inputElement && (this.inputElement.value = this.textValue)
			};
			b._onInput = function() {
				this.textValue = this.inputElement.value;
				d.Event.dispatchEvent(this, "updateText", !1)
			};
			b._onClickHandler = function(a) {
				this._isNeedShow && (a.stopImmediatePropagation(), this._isNeedShow = !1, this.executeShow(), this.dispatchEvent(new d.Event("focus")))
			};
			b._onDisconnect = function() {
				this.inputElement = null;
				this.dispatchEvent(new d.Event("blur"))
			};
			b.setElementStyle = function(a, b) {
				this.inputElement && this._styleInfoes[a] != b && (this.inputElement.style[a] = b)
			};
			b._removeInput = function() {
				this.inputElement && g.getInstance().disconnectStageText(this)
			};
			b._resetStageText = function() {
				if (this.inputElement) {
					var a = this._textfield,
						b = a._properties;
					this.setElementStyle("fontFamily", b._fontFamily);
					this.setElementStyle("fontStyle", b._italic ? "italic" : "normal");
					this.setElementStyle("fontWeight", b._bold ? "bold" : "normal");
					this.setElementStyle("textAlign", b._textAlign);
					this.setElementStyle("fontSize", b._size * this._gscaleY + "px");
					this.setElementStyle("lineHeight", b._size * this._gscaleY + "px");
					this.setElementStyle("color", b._textColorString);
					this.setElementStyle("width", a._getSize(d.Rectangle.identity).width * this._gscaleX + "px");
					this.setElementStyle("height", a._getSize(d.Rectangle.identity).height * this._gscaleY + "px");
					this.setElementStyle("verticalAlign", b._verticalAlign)
				}
			};
			return c
		}(d.StageText);
	d.HTML5StageText = f;
	f.prototype.__class__ = "egret.HTML5StageText";
	var g = function() {
			function e() {
				this._needShow = !1
			}
			var c = e.prototype;
			c.isInputOn = function() {
				return null != this._stageText
			};
			c.isCurrentStageText = function(b) {
				return this._stageText == b
			};
			c.initValue = function(b) {
				b.style.position = "absolute";
				b.style.left = "0px";
				b.style.top = "0px";
				b.style.border = "none";
				b.style.padding = "0"
			};
			c.initStageDelegateDiv = function() {
				var b = this,
					a = d.Browser.getInstance().$("#StageDelegateDiv");
				a || (a = d.Browser.getInstance().$new("div"), a.id = "StageDelegateDiv", document.getElementById(d.StageDelegate.egret_root_div).appendChild(a), b.initValue(a), a.style.width = "0px", a.style.height = "0px", b._inputDIV = d.Browser.getInstance().$new("div"), b.initValue(b._inputDIV), b._inputDIV.style.width = "0px", b._inputDIV.style.height = "0px", b._inputDIV.style.left = "0px", b._inputDIV.style.top = "-100px", b._inputDIV.style[d.Browser.getInstance().getTrans("transformOrigin")] = "0% 0% 0px", a.appendChild(b._inputDIV), document.getElementById(d.StageDelegate.canvas_div_name).addEventListener("click", function(a) {
					b._needShow ? (b._needShow = !1, d.MainContext.instance.stage._changeSizeDispatchFlag = !1, b._stageText._onClickHandler(a), e.getInstance().show()) : b._inputElement && (b.clearInputElement(), b._inputElement.blur(), b._inputElement = null)
				}), b.initInputElement(!0), b.initInputElement(!1))
			};
			c.initInputElement = function(b) {
				var a = this;
				b ? (b = document.createElement("textarea"), b.style.resize = "none", a._multiElement = b, b.id = "egretTextarea") : (b = document.createElement("input"), a._simpleElement = b, b.id = "egretInput");
				b.type = "text";
				a._inputDIV.appendChild(b);
				b.setAttribute("tabindex", "-1");
				b.style.width = "1px";
				b.style.height = "12px";
				a.initValue(b);
				b.style.outline = "thin";
				b.style.background = "none";
				b.style.overflow = "hidden";
				b.style.wordBreak = "break-all";
				b.style.opacity = 0;
				b.oninput = function() {
					a._stageText && a._stageText._onInput()
				}
			};
			c.show = function() {
				var b = this._inputElement;
				d.__callAsync(function() {
					b.style.opacity = 1
				}, this)
			};
			c.disconnectStageText = function(b) {
				if (null == this._stageText || this._stageText == b) this.clearInputElement(), this._inputElement && this._inputElement.blur()
			};
			c.clearInputElement = function() {
				this._inputElement && (this._inputElement.value = "", this._inputElement.onblur = null, this._inputElement.style.width = "1px", this._inputElement.style.height = "12px", this._inputElement.style.left = "0px", this._inputElement.style.top = "0px", this._inputElement.style.opacity = 0, (this._simpleElement == this._inputElement ? this._multiElement : this._simpleElement).style.display = "block", this._inputDIV.style.left = "0px", this._inputDIV.style.top = "-100px");
				this._stageText && (this._stageText._onDisconnect(), this._stageText = null);
				d.MainContext.instance.stage._changeSizeDispatchFlag = !0
			};
			c.getInputElement = function(b) {
				this.clearInputElement();
				this._stageText = b;
				this._inputElement = this._stageText._multiline ? this._multiElement : this._simpleElement;
				(this._simpleElement == this._inputElement ? this._multiElement : this._simpleElement).style.display = "none";
				return this._inputElement
			};
			e.getInstance = function() {
				null == e._instance && (e._instance = new d.HTMLInput, e._instance.initStageDelegateDiv());
				return e._instance
			};
			return e
		}();
	d.HTMLInput = g;
	g.prototype.__class__ = "egret.HTMLInput"
})(egret || (egret = {}));
egret.StageText.create = function() {
	return new egret.HTML5StageText
};
var RES;
(function(d) {
	var f = function(d) {
			function e(c, b, a) {
				void 0 === b && (b = !1);
				void 0 === a && (a = !1);
				d.call(this, c, b, a);
				this.itemsTotal = this.itemsLoaded = 0;
				this.groupName = "";
				this.resItem = null
			}
			__extends(e, d);
			e.dispatchResourceEvent = function(c, b, a, h, d, f) {
				void 0 === a && (a = "");
				void 0 === h && (h = null);
				void 0 === d && (d = 0);
				void 0 === f && (f = 0);
				var g = egret.Event._getPropertyData(e);
				g.groupName = a;
				g.resItem = h;
				g.itemsLoaded = d;
				g.itemsTotal = f;
				egret.Event._dispatchByTarget(e, c, b, g)
			};
			e.ITEM_LOAD_ERROR = "itemLoadError";
			e.CONFIG_COMPLETE = "configComplete";
			e.CONFIG_LOAD_ERROR = "configLoadError";
			e.GROUP_PROGRESS = "groupProgress";
			e.GROUP_COMPLETE = "groupComplete";
			e.GROUP_LOAD_ERROR = "groupLoadError";
			return e
		}(egret.Event);
	d.ResourceEvent = f;
	f.prototype.__class__ = "RES.ResourceEvent"
})(RES || (RES = {}));
(function(d) {
	var f = function() {
			function d(c, b, a) {
				this.groupName = "";
				this.data = null;
				this._loaded = !1;
				this.name = c;
				this.url = b;
				this.type = a
			}
			var e = d.prototype;
			Object.defineProperty(e, "loaded", {
				get: function() {
					return this.data ? this.data.loaded : this._loaded
				},
				set: function(c) {
					this.data && (this.data.loaded = c);
					this._loaded = c
				},
				enumerable: !0,
				configurable: !0
			});
			e.toString = function() {
				return '[ResourceItem name="' + this.name + '" url="' + this.url + '" type="' + this.type + '"]'
			};
			d.TYPE_XML = "xml";
			d.TYPE_IMAGE = "image";
			d.TYPE_BIN = "bin";
			d.TYPE_TEXT = "text";
			d.TYPE_JSON = "json";
			d.TYPE_SHEET = "sheet";
			d.TYPE_FONT = "font";
			d.TYPE_SOUND = "sound";
			return d
		}();
	d.ResourceItem = f;
	f.prototype.__class__ = "RES.ResourceItem"
})(RES || (RES = {}));
(function(d) {
	var f = function() {
			function f() {
				this.keyMap = {};
				this.groupDic = {};
				d.configInstance = this
			}
			var e = f.prototype;
			e.getGroupByName = function(c) {
				var b = [];
				if (!this.groupDic[c]) return b;
				c = this.groupDic[c];
				for (var a = c.length, h = 0; h < a; h++) b.push(this.parseResourceItem(c[h]));
				return b
			};
			e.getRawGroupByName = function(c) {
				return this.groupDic[c] ? this.groupDic[c] : []
			};
			e.createGroup = function(c, b, a) {
				void 0 === a && (a = !1);
				if (!a && this.groupDic[c] || !b || 0 == b.length) return !1;
				a = this.groupDic;
				for (var h = [], e = b.length, d = 0; d < e; d++) {
					var f = b[d],
						g = a[f];
					if (g) for (var f = g.length, k = 0; k < f; k++) {
						var l = g[k]; - 1 == h.indexOf(l) && h.push(l)
					} else(l = this.keyMap[f]) ? -1 == h.indexOf(l) && h.push(l) : egret.Logger.warningWithErrorId(2E3, f)
				}
				if (0 == h.length) return !1;
				this.groupDic[c] = h;
				return !0
			};
			e.parseConfig = function(c, b) {
				if (c) {
					var a = c.resources;
					if (a) for (var h = a.length, e = 0; e < h; e++) {
						var d = a[e],
							f = d.url;
						f && -1 == f.indexOf("://") && (d.url = b + f);
						this.addItemToKeyMap(d)
					}
					if (a = c.groups) for (h = a.length, e = 0; e < h; e++) {
						for (var f = a[e], g = [], k = f.keys.split(","), l = k.length, m = 0; m < l; m++) d = k[m].trim(), (d = this.keyMap[d]) && -1 == g.indexOf(d) && g.push(d);
						this.groupDic[f.name] = g
					}
				}
			};
			e.addSubkey = function(c, b) {
				var a = this.keyMap[b];
				a && !this.keyMap[c] && (this.keyMap[c] = a)
			};
			e.addItemToKeyMap = function(c) {
				this.keyMap[c.name] || (this.keyMap[c.name] = c);
				if (c.hasOwnProperty("subkeys")) {
					var b = c.subkeys.split(",");
					c.subkeys = b;
					for (var a = b.length, h = 0; h < a; h++) {
						var e = b[h];
						null == this.keyMap[e] && (this.keyMap[e] = c)
					}
				}
			};
			e.getName = function(c) {
				return (c = this.keyMap[c]) ? c.name : ""
			};
			e.getType = function(c) {
				return (c = this.keyMap[c]) ? c.type : ""
			};
			e.getRawResourceItem = function(c) {
				return this.keyMap[c]
			};
			e.getResourceItem = function(c) {
				return (c = this.keyMap[c]) ? this.parseResourceItem(c) : null
			};
			e.parseResourceItem = function(c) {
				var b = new d.ResourceItem(c.name, c.url, c.type);
				b.data = c;
				return b
			};
			return f
		}();
	d.ResourceConfig = f;
	f.prototype.__class__ = "RES.ResourceConfig"
})(RES || (RES = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this.thread = 2;
				this.loadingCount = 0;
				this.resInstance = this.callBack = null;
				this.groupTotalDic = {};
				this.numLoadedDic = {};
				this.itemListDic = {};
				this.groupErrorDic = {};
				this.retryTimesDic = {};
				this.maxRetryTimes = 3;
				this.failedList = [];
				this.priorityQueue = {};
				this.lazyLoadList = [];
				this.analyzerDic = {};
				this.queueIndex = 0
			}
			__extends(e, f);
			var c = e.prototype;
			c.isGroupInLoading = function(b) {
				return void 0 !== this.itemListDic[b]
			};
			c.loadGroup = function(b, a, h) {
				void 0 === h && (h = 0);
				if (!this.itemListDic[a] && a) if (b && 0 != b.length) {
					this.priorityQueue[h] ? this.priorityQueue[h].push(a) : this.priorityQueue[h] = [a];
					this.itemListDic[a] = b;
					h = b.length;
					for (var c = 0; c < h; c++) b[c].groupName = a;
					this.groupTotalDic[a] = b.length;
					this.numLoadedDic[a] = 0;
					this.next()
				} else egret.Logger.warningWithErrorId(2001, a), b = new d.ResourceEvent(d.ResourceEvent.GROUP_LOAD_ERROR), b.groupName = a, this.dispatchEvent(b)
			};
			c.loadItem = function(b) {
				this.lazyLoadList.push(b);
				b.groupName = "";
				this.next()
			};
			c.next = function() {
				for (; this.loadingCount < this.thread;) {
					var b = this.getOneResourceItem();
					if (!b) break;
					this.loadingCount++;
					if (b.loaded) this.onItemComplete(b);
					else {
						var a = this.analyzerDic[b.type];
						a || (a = this.analyzerDic[b.type] = egret.Injector.getInstance(d.AnalyzerBase, b.type));
						a.loadFile(b, this.onItemComplete, this)
					}
				}
			};
			c.getOneResourceItem = function() {
				if (0 < this.failedList.length) return this.failedList.shift();
				var b = Number.NEGATIVE_INFINITY,
					a;
				for (a in this.priorityQueue) b = Math.max(b, a);
				b = this.priorityQueue[b];
				if (!b || 0 == b.length) return 0 == this.lazyLoadList.length ? null : this.lazyLoadList.pop();
				a = b.length;
				for (var h, c = 0; c < a; c++) {
					this.queueIndex >= a && (this.queueIndex = 0);
					h = this.itemListDic[b[this.queueIndex]];
					if (0 < h.length) break;
					this.queueIndex++
				}
				return 0 == h.length ? null : h.shift()
			};
			c.onItemComplete = function(b) {
				this.loadingCount--;
				var a = b.groupName;
				if (!b.loaded) {
					var h = this.retryTimesDic[b.name] || 1;
					if (h > this.maxRetryTimes) delete this.retryTimesDic[b.name], d.ResourceEvent.dispatchResourceEvent(this.resInstance, d.ResourceEvent.ITEM_LOAD_ERROR, a, b);
					else {
						this.retryTimesDic[b.name] = h + 1;
						this.failedList.push(b);
						this.next();
						return
					}
				}
				if (a) {
					this.numLoadedDic[a]++;
					var h = this.numLoadedDic[a],
						c = this.groupTotalDic[a];
					b.loaded || (this.groupErrorDic[a] = !0);
					d.ResourceEvent.dispatchResourceEvent(this.resInstance, d.ResourceEvent.GROUP_PROGRESS, a, b, h, c);
					h == c && (b = this.groupErrorDic[a], this.removeGroupName(a), delete this.groupTotalDic[a], delete this.numLoadedDic[a], delete this.itemListDic[a], delete this.groupErrorDic[a], b ? d.ResourceEvent.dispatchResourceEvent(this, d.ResourceEvent.GROUP_LOAD_ERROR, a) : d.ResourceEvent.dispatchResourceEvent(this, d.ResourceEvent.GROUP_COMPLETE, a))
				} else this.callBack.call(this.resInstance, b);
				this.next()
			};
			c.removeGroupName = function(b) {
				for (var a in this.priorityQueue) {
					for (var h = this.priorityQueue[a], c = h.length, e = 0, d = !1, c = h.length, f = 0; f < c; f++) {
						if (h[f] == b) {
							h.splice(e, 1);
							d = !0;
							break
						}
						e++
					}
					if (d) {
						0 == h.length && delete this.priorityQueue[a];
						break
					}
				}
			};
			return e
		}(egret.EventDispatcher);
	d.ResourceLoader = f;
	f.prototype.__class__ = "RES.ResourceLoader"
})(RES || (RES = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this.resourceConfig = null;
				this.resourceConfig = d.configInstance
			}
			__extends(e, f);
			var c = e.prototype;
			c.addSubkey = function(b, a) {
				this.resourceConfig.addSubkey(b, a)
			};
			c.loadFile = function(b, a, h) {};
			c.getRes = function(b) {};
			c.destroyRes = function(b) {
				return !1
			};
			e.getStringPrefix = function(b) {
				if (!b) return "";
				var a = b.indexOf(".");
				return -1 != a ? b.substring(0, a) : ""
			};
			e.getStringTail = function(b) {
				if (!b) return "";
				var a = b.indexOf(".");
				return -1 != a ? b.substring(a + 1) : ""
			};
			return e
		}(egret.HashObject);
	d.AnalyzerBase = f;
	f.prototype.__class__ = "RES.AnalyzerBase"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this.fileDic = {};
				this.resItemDic = [];
				this._dataFormat = egret.URLLoaderDataFormat.BINARY;
				this.recycler = new egret.Recycler
			}
			__extends(e, d);
			var c = e.prototype;
			c.loadFile = function(b, a, h) {
				if (this.fileDic[b.name]) a.call(h, b);
				else {
					var c = this.getLoader();
					this.resItemDic[c.hashCode] = {
						item: b,
						func: a,
						thisObject: h
					};
					c.load(new egret.URLRequest(b.url))
				}
			};
			c.getLoader = function() {
				var b = this.recycler.pop();
				b || (b = new egret.URLLoader, b.addEventListener(egret.Event.COMPLETE, this.onLoadFinish, this), b.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onLoadFinish, this));
				b.dataFormat = this._dataFormat;
				return b
			};
			c.onLoadFinish = function(b) {
				var a = b.target,
					h = this.resItemDic[a.hashCode];
				delete this.resItemDic[a.hashCode];
				var c = h.item,
					e = h.func;
				c.loaded = b.type == egret.Event.COMPLETE;
				c.loaded && this.analyzeData(c, a.data);
				this.recycler.push(a);
				e.call(h.thisObject, c)
			};
			c.analyzeData = function(b, a) {
				var h = b.name;
				!this.fileDic[h] && a && (this.fileDic[h] = a)
			};
			c.getRes = function(b) {
				return this.fileDic[b]
			};
			c.hasRes = function(b) {
				return null != this.getRes(b)
			};
			c.destroyRes = function(b) {
				return this.fileDic[b] ? (this.onResourceDestroy(this.fileDic[b]), delete this.fileDic[b], !0) : !1
			};
			c.onResourceDestroy = function(b) {};
			return e
		}(d.AnalyzerBase);
	d.BinAnalyzer = f;
	f.prototype.__class__ = "RES.BinAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._dataFormat = egret.URLLoaderDataFormat.TEXTURE
			}
			__extends(e, d);
			var c = e.prototype;
			c.analyzeData = function(b, a) {
				var h = b.name;
				!this.fileDic[h] && a && (this.fileDic[h] = a, (h = b.data) && h.scale9grid && (h = h.scale9grid.split(","), a.scale9Grid = new egret.Rectangle(parseInt(h[0]), parseInt(h[1]), parseInt(h[2]), parseInt(h[3]))))
			};
			c.onResourceDestroy = function(b) {};
			return e
		}(d.BinAnalyzer);
	d.ImageAnalyzer = f;
	f.prototype.__class__ = "RES.ImageAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._dataFormat = egret.URLLoaderDataFormat.TEXT
			}
			__extends(e, d);
			e.prototype.analyzeData = function(c, b) {
				var a = c.name;
				if (!this.fileDic[a] && b) try {
					this.fileDic[a] = JSON.parse(b)
				} catch (h) {
					egret.Logger.warningWithErrorId(1017, c.url, b)
				}
			};
			return e
		}(d.BinAnalyzer);
	d.JsonAnalyzer = f;
	f.prototype.__class__ = "RES.JsonAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._dataFormat = egret.URLLoaderDataFormat.TEXT
			}
			__extends(e, d);
			return e
		}(d.BinAnalyzer);
	d.TextAnalyzer = f;
	f.prototype.__class__ = "RES.TextAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(f) {
			function e() {
				f.call(this);
				this.sheetMap = {};
				this.textureMap = {};
				this._dataFormat = egret.URLLoaderDataFormat.TEXT
			}
			__extends(e, f);
			var c = e.prototype;
			c.getRes = function(b) {
				var a = this.fileDic[b];
				a || (a = this.textureMap[b]);
				!a && (a = d.AnalyzerBase.getStringPrefix(b), a = this.fileDic[a]) && (b = d.AnalyzerBase.getStringTail(b), a = a.getTexture(b));
				return a
			};
			c.onLoadFinish = function(b) {
				var a = b.target,
					h = this.resItemDic[a.hashCode];
				delete this.resItemDic[a.hashCode];
				var c = h.item,
					e = h.func;
				c.loaded = b.type == egret.Event.COMPLETE;
				if (c.loaded) if ("string" == typeof a.data) {
					if (c.loaded = !1, b = this.analyzeConfig(c, a.data)) {
						a = c.url;
						c.url = b;
						this._dataFormat = egret.URLLoaderDataFormat.TEXTURE;
						this.loadFile(c, e, h.thisObject);
						this._dataFormat = egret.URLLoaderDataFormat.TEXT;
						c.url = a;
						return
					}
				} else this.analyzeBitmap(c, a.data);
				this.recycler.push(a);
				e.call(h.thisObject, c)
			};
			c.analyzeConfig = function(b, a) {
				var h = b.name,
					c, e = "";
				try {
					c = JSON.parse(a)
				} catch (d) {
					egret.Logger.warningWithErrorId(1017, b.url, a)
				}
				c && (this.sheetMap[h] = c, e = this.getRelativePath(b.url, c.file));
				return e
			};
			c.analyzeBitmap = function(b, a) {
				var c = b.name;
				if (!this.fileDic[c] && a) {
					var e = this.sheetMap[c];
					delete this.sheetMap[c];
					e = this.parseSpriteSheet(a, e, b.data && b.data.subkeys ? "" : c);
					this.fileDic[c] = e
				}
			};
			c.getRelativePath = function(b, a) {
				b = b.split("\\").join("/");
				var c = b.lastIndexOf("/");
				return b = -1 != c ? b.substring(0, c + 1) + a : a
			};
			c.parseSpriteSheet = function(b, a, c) {
				a = a.frames;
				if (!a) return null;
				var e = new egret.SpriteSheet(b),
					d = this.textureMap,
					f;
				for (f in a) {
					var g = a[f];
					b = e.createTexture(f, g.x, g.y, g.w, g.h, g.offX, g.offY, g.sourceW, g.sourceH);
					g.scale9grid && (g = g.scale9grid.split(","), b.scale9Grid = new egret.Rectangle(parseInt(g[0]), parseInt(g[1]), parseInt(g[2]), parseInt(g[3])));
					null == d[f] && (d[f] = b, c && this.addSubkey(f, c))
				}
				return e
			};
			c.destroyRes = function(b) {
				var a = this.fileDic[b];
				if (a) {
					delete this.fileDic[b];
					for (var c in a._textureMap) this.textureMap[c] && delete this.textureMap[c];
					return !0
				}
				return !1
			};
			return e
		}(d.BinAnalyzer);
	d.SheetAnalyzer = f;
	f.prototype.__class__ = "RES.SheetAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this)
			}
			__extends(e, d);
			var c = e.prototype;
			c.analyzeConfig = function(b, a) {
				var c = b.name,
					e, d = "";
				try {
					e = JSON.parse(a)
				} catch (f) {}
				e ? d = this.getRelativePath(b.url, e.file) : (e = a, d = this.getTexturePath(b.url, e));
				this.sheetMap[c] = e;
				return d
			};
			c.analyzeBitmap = function(b, a) {
				var c = b.name;
				if (!this.fileDic[c] && a) {
					var e = this.sheetMap[c];
					delete this.sheetMap[c];
					e = new egret.BitmapFont(a, e);
					this.fileDic[c] = e
				}
			};
			c.getTexturePath = function(b, a) {
				var c = "",
					e = a.split("\n")[2],
					d = e.indexOf('file="'); - 1 != d && (e = e.substring(d + 6), d = e.indexOf('"'), c = e.substring(0, d));
				b = b.split("\\").join("/");
				d = b.lastIndexOf("/");
				return b = -1 != d ? b.substring(0, d + 1) + c : c
			};
			c.destroyRes = function(b) {
				return this.fileDic[b] ? (delete this.fileDic[b], !0) : !1
			};
			return e
		}(d.SheetAnalyzer);
	d.FontAnalyzer = f;
	f.prototype.__class__ = "RES.FontAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._dataFormat = egret.URLLoaderDataFormat.SOUND
			}
			__extends(e, d);
			e.prototype.analyzeData = function(c, b) {
				var a = c.name;
				!this.fileDic[a] && b && (this.fileDic[a] = b, (a = c.data) && a.soundType ? b.preload(a.soundType) : b.preload(egret.Sound.EFFECT))
			};
			return e
		}(d.BinAnalyzer);
	d.SoundAnalyzer = f;
	f.prototype.__class__ = "RES.SoundAnalyzer"
})(RES || (RES = {}));
(function(d) {
	var f = function(d) {
			function e() {
				d.call(this);
				this._dataFormat = egret.URLLoaderDataFormat.TEXT
			}
			__extends(e, d);
			e.prototype.analyzeData = function(c, b) {
				var a = c.name;
				if (!this.fileDic[a] && b) try {
					var h = egret.XML.parse(b);
					this.fileDic[a] = h
				} catch (e) {}
			};
			return e
		}(d.BinAnalyzer);
	d.XMLAnalyzer = f;
	f.prototype.__class__ = "RES.XMLAnalyzer"
})(RES || (RES = {}));
(function(d) {
	d.loadConfig = function(e, c, b) {
		void 0 === c && (c = "");
		void 0 === b && (b = "json");
		g.loadConfig(e, c, b)
	};
	d.loadGroup = function(e, c) {
		void 0 === c && (c = 0);
		g.loadGroup(e, c)
	};
	d.isGroupLoaded = function(e) {
		return g.isGroupLoaded(e)
	};
	d.getGroupByName = function(e) {
		return g.getGroupByName(e)
	};
	d.createGroup = function(e, c, b) {
		void 0 === b && (b = !1);
		return g.createGroup(e, c, b)
	};
	d.hasRes = function(e) {
		return g.hasRes(e)
	};
	d.parseConfig = function(e, c) {
		void 0 === c && (c = "");
		g.parseConfig(e, c)
	};
	d.getRes = function(e) {
		return g.getRes(e)
	};
	d.getResAsync = function(e, c, b) {
		g.getResAsync(e, c, b)
	};
	d.getResByUrl = function(e, c, b, a) {
		void 0 === a && (a = "");
		g.getResByUrl(e, c, b, a)
	};
	d.destroyRes = function(e) {
		return g.destroyRes(e)
	};
	d.setMaxLoadingThread = function(e) {
		g.setMaxLoadingThread(e)
	};
	d.setMaxRetryTimes = function(e) {
		g.setMaxRetryTimes(e)
	};
	d.addEventListener = function(e, c, b, a, h) {
		void 0 === a && (a = !1);
		void 0 === h && (h = 0);
		g.addEventListener(e, c, b, a, h)
	};
	d.removeEventListener = function(e, c, b, a) {
		void 0 === a && (a = !1);
		g.removeEventListener(e, c, b, a)
	};
	var f = function(e) {
			function c() {
				e.call(this);
				this.analyzerDic = {};
				this.configItemList = [];
				this.configComplete = this.callLaterFlag = !1;
				this.loadedGroups = [];
				this.groupNameList = [];
				this.asyncDic = {};
				this.init()
			}
			__extends(c, e);
			var b = c.prototype;
			b.getAnalyzerByType = function(a) {
				var b = this.analyzerDic[a];
				b || (b = this.analyzerDic[a] = egret.Injector.getInstance(d.AnalyzerBase, a));
				return b
			};
			b.init = function() {
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_BIN) || egret.Injector.mapClass(d.AnalyzerBase, d.BinAnalyzer, d.ResourceItem.TYPE_BIN);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_IMAGE) || egret.Injector.mapClass(d.AnalyzerBase, d.ImageAnalyzer, d.ResourceItem.TYPE_IMAGE);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_TEXT) || egret.Injector.mapClass(d.AnalyzerBase, d.TextAnalyzer, d.ResourceItem.TYPE_TEXT);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_JSON) || egret.Injector.mapClass(d.AnalyzerBase, d.JsonAnalyzer, d.ResourceItem.TYPE_JSON);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_SHEET) || egret.Injector.mapClass(d.AnalyzerBase, d.SheetAnalyzer, d.ResourceItem.TYPE_SHEET);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_FONT) || egret.Injector.mapClass(d.AnalyzerBase, d.FontAnalyzer, d.ResourceItem.TYPE_FONT);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_SOUND) || egret.Injector.mapClass(d.AnalyzerBase, d.SoundAnalyzer, d.ResourceItem.TYPE_SOUND);
				egret.Injector.hasMapRule(d.AnalyzerBase, d.ResourceItem.TYPE_XML) || egret.Injector.mapClass(d.AnalyzerBase, d.XMLAnalyzer, d.ResourceItem.TYPE_XML);
				this.resConfig = new d.ResourceConfig;
				this.resLoader = new d.ResourceLoader;
				this.resLoader.callBack = this.onResourceItemComp;
				this.resLoader.resInstance = this;
				this.resLoader.addEventListener(d.ResourceEvent.GROUP_COMPLETE, this.onGroupComp, this);
				this.resLoader.addEventListener(d.ResourceEvent.GROUP_LOAD_ERROR, this.onGroupError, this)
			};
			b.loadConfig = function(a, b, c) {
				void 0 === c && (c = "json");
				this.configItemList.push({
					url: a,
					resourceRoot: b,
					type: c
				});
				this.callLaterFlag || (egret.callLater(this.startLoadConfig, this), this.callLaterFlag = !0)
			};
			b.startLoadConfig = function() {
				this.callLaterFlag = !1;
				var a = this.configItemList;
				this.configItemList = [];
				this.loadingConfigList = a;
				for (var b = a.length, e = [], f = 0; f < b; f++) {
					var g = a[f],
						g = new d.ResourceItem(g.url, g.url, g.type);
					e.push(g)
				}
				this.resLoader.loadGroup(e, c.GROUP_CONFIG, Number.MAX_VALUE)
			};
			b.isGroupLoaded = function(a) {
				return -1 != this.loadedGroups.indexOf(a)
			};
			b.getGroupByName = function(a) {
				return this.resConfig.getGroupByName(a)
			};
			b.loadGroup = function(a, b) {
				void 0 === b && (b = 0);
				if (-1 != this.loadedGroups.indexOf(a)) d.ResourceEvent.dispatchResourceEvent(this, d.ResourceEvent.GROUP_COMPLETE, a);
				else if (!this.resLoader.isGroupInLoading(a)) if (this.configComplete) {
					var c = this.resConfig.getGroupByName(a);
					this.resLoader.loadGroup(c, a, b)
				} else this.groupNameList.push({
					name: a,
					priority: b
				})
			};
			b.createGroup = function(a, b, c) {
				void 0 === c && (c = !1);
				if (c) {
					var e = this.loadedGroups.indexOf(a); - 1 != e && this.loadedGroups.splice(e, 1)
				}
				return this.resConfig.createGroup(a, b, c)
			};
			b.onGroupComp = function(a) {
				if (a.groupName == c.GROUP_CONFIG) {
					a = this.loadingConfigList.length;
					for (var b = 0; b < a; b++) {
						var e = this.loadingConfigList[b],
							f = this.getAnalyzerByType(e.type),
							g = f.getRes(e.url);
						f.destroyRes(e.url);
						this.resConfig.parseConfig(g, e.resourceRoot)
					}
					this.configComplete = !0;
					this.loadingConfigList = null;
					d.ResourceEvent.dispatchResourceEvent(this, d.ResourceEvent.CONFIG_COMPLETE);
					this.loadDelayGroups()
				} else this.loadedGroups.push(a.groupName), this.dispatchEvent(a)
			};
			b.loadDelayGroups = function() {
				var a = this.groupNameList;
				this.groupNameList = [];
				for (var b = a.length, c = 0; c < b; c++) {
					var e = a[c];
					this.loadGroup(e.name, e.priority)
				}
			};
			b.onGroupError = function(a) {
				a.groupName == c.GROUP_CONFIG ? (this.loadingConfigList = null, d.ResourceEvent.dispatchResourceEvent(this, d.ResourceEvent.CONFIG_LOAD_ERROR)) : this.dispatchEvent(a)
			};
			b.hasRes = function(a) {
				var b = this.resConfig.getType(a);
				return "" == b && (a = d.AnalyzerBase.getStringPrefix(a), b = this.resConfig.getType(a), "" == b) ? !1 : !0
			};
			b.parseConfig = function(a, b) {
				this.resConfig.parseConfig(a, b);
				this.configComplete || this.loadingConfigList || (this.configComplete = !0, this.loadDelayGroups())
			};
			b.getRes = function(a) {
				var b = this.resConfig.getType(a);
				return "" == b && (b = d.AnalyzerBase.getStringPrefix(a), b = this.resConfig.getType(b), "" == b) ? null : this.getAnalyzerByType(b).getRes(a)
			};
			b.getResAsync = function(a, b, c) {
				var e = this.resConfig.getType(a),
					f = this.resConfig.getName(a);
				if ("" == e && (f = d.AnalyzerBase.getStringPrefix(a), e = this.resConfig.getType(f), "" == e)) {
					b.call(c, null);
					return
				}(e = this.getAnalyzerByType(e).getRes(a)) ? b.call(c, e) : (a = {
					key: a,
					compFunc: b,
					thisObject: c
				}, this.asyncDic[f] ? this.asyncDic[f].push(a) : (this.asyncDic[f] = [a], f = this.resConfig.getResourceItem(f), this.resLoader.loadItem(f)))
			};
			b.getResByUrl = function(a, b, c, e) {
				void 0 === e && (e = "");
				if (a) {
					e || (e = this.getTypeByUrl(a));
					var f = this.getAnalyzerByType(e).getRes(a);
					f ? b.call(c, f) : (b = {
						key: a,
						compFunc: b,
						thisObject: c
					}, this.asyncDic[a] ? this.asyncDic[a].push(b) : (this.asyncDic[a] = [b], a = new d.ResourceItem(a, a, e), this.resLoader.loadItem(a)))
				} else b.call(c, null)
			};
			b.getTypeByUrl = function(a) {
				(a = a.substr(a.lastIndexOf(".") + 1)) && (a = a.toLowerCase());
				switch (a) {
				case d.ResourceItem.TYPE_XML:
				case d.ResourceItem.TYPE_JSON:
				case d.ResourceItem.TYPE_SHEET:
					break;
				case "png":
				case "jpg":
				case "gif":
				case "jpeg":
				case "bmp":
					a = d.ResourceItem.TYPE_IMAGE;
					break;
				case "fnt":
					a = d.ResourceItem.TYPE_FONT;
					break;
				case "txt":
					a = d.ResourceItem.TYPE_TEXT;
					break;
				case "mp3":
				case "ogg":
				case "mpeg":
				case "wav":
				case "m4a":
				case "mp4":
				case "aiff":
				case "wma":
				case "mid":
					a = d.ResourceItem.TYPE_SOUND;
					break;
				default:
					a = d.ResourceItem.TYPE_BIN
				}
				return a
			};
			b.onResourceItemComp = function(a) {
				var b = this.asyncDic[a.name];
				delete this.asyncDic[a.name];
				a = this.getAnalyzerByType(a.type);
				for (var c = b.length, e = 0; e < c; e++) {
					var d = b[e],
						f = a.getRes(d.key);
					d.compFunc.call(d.thisObject, f, d.key)
				}
			};
			b.destroyRes = function(a) {
				var b = this.resConfig.getRawGroupByName(a);
				if (b) {
					var c = this.loadedGroups.indexOf(a); - 1 != c && this.loadedGroups.splice(c, 1);
					a = b.length;
					for (var e = 0; e < a; e++) {
						c = b[e];
						c.loaded = !1;
						var d = this.getAnalyzerByType(c.type);
						d.destroyRes(c.name);
						this.removeLoadedGroupsByItemName(c.name)
					}
					return !0
				}
				b = this.resConfig.getType(a);
				if ("" == b) return !1;
				c = this.resConfig.getRawResourceItem(a);
				c.loaded = !1;
				d = this.getAnalyzerByType(b);
				b = d.destroyRes(a);
				this.removeLoadedGroupsByItemName(c.name);
				return b
			};
			b.removeLoadedGroupsByItemName = function(a) {
				for (var b = this.loadedGroups, c = b.length, e = 0; e < c; e++) for (var d = this.resConfig.getRawGroupByName(b[e]), f = d.length, g = 0; g < f; g++) if (d[g].name == a) {
					b.splice(e, 1);
					e--;
					c = b.length;
					break
				}
			};
			b.setMaxLoadingThread = function(a) {
				1 > a && (a = 1);
				this.resLoader.thread = a
			};
			b.setMaxRetryTimes = function(a) {
				a = Math.max(a, 0);
				this.resLoader.maxRetryTimes = a
			};
			c.GROUP_CONFIG = "RES__CONFIG";
			return c
		}(egret.EventDispatcher);
	f.prototype.__class__ = "RES.Resource";
	var g = new f
})(RES || (RES = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this);
					this._source = a ? a : []
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "source", {
					get: function() {
						return this._source
					},
					set: function(a) {
						a || (a = []);
						this._source = a;
						this.dispatchCoEvent(f.CollectionEventKind.RESET)
					},
					enumerable: !0,
					configurable: !0
				});
				b.refresh = function() {
					this.dispatchCoEvent(f.CollectionEventKind.REFRESH)
				};
				b.contains = function(a) {
					return -1 != this.getItemIndex(a)
				};
				b.checkIndex = function(a) {
					if (0 > a || a >= this._source.length) throw new RangeError(d.getString(3002, a));
				};
				Object.defineProperty(b, "length", {
					get: function() {
						return this._source.length
					},
					enumerable: !0,
					configurable: !0
				});
				b.addItem = function(a) {
					this._source.push(a);
					this.dispatchCoEvent(f.CollectionEventKind.ADD, this._source.length - 1, -1, [a])
				};
				b.addItemAt = function(a, b) {
					if (0 > b || b > this._source.length) throw new RangeError(d.getString(3002, b));
					this._source.splice(b, 0, a);
					this.dispatchCoEvent(f.CollectionEventKind.ADD, b, -1, [a])
				};
				b.getItemAt = function(a) {
					return this._source[a]
				};
				b.getItemIndex = function(a) {
					for (var b = this._source.length, c = 0; c < b; c++) if (this._source[c] === a) return c;
					return -1
				};
				b.itemUpdated = function(a) {
					var b = this.getItemIndex(a); - 1 != b && this.dispatchCoEvent(f.CollectionEventKind.UPDATE, b, -1, [a])
				};
				b.removeAll = function() {
					var a = this._source.concat();
					this._source.length = 0;
					this.dispatchCoEvent(f.CollectionEventKind.REMOVE, 0, -1, a)
				};
				b.removeItemAt = function(a) {
					this.checkIndex(a);
					var b = this._source.splice(a, 1)[0];
					this.dispatchCoEvent(f.CollectionEventKind.REMOVE, a, -1, [b]);
					return b
				};
				b.replaceItemAt = function(a, b) {
					this.checkIndex(b);
					var c = this._source.splice(b, 1, a)[0];
					this.dispatchCoEvent(f.CollectionEventKind.REPLACE, b, -1, [a], [c]);
					return c
				};
				b.replaceAll = function(a) {
					a || (a = []);
					for (var b = a.length, c = this._source.length, e = b; e < c; e++) this.removeItemAt(b);
					for (e = 0; e < b; e++) e >= c ? this.addItemAt(a[e], e) : this.replaceItemAt(a[e], e);
					this._source = a
				};
				b.moveItemAt = function(a, b) {
					this.checkIndex(a);
					this.checkIndex(b);
					var c = this._source.splice(a, 1)[0];
					this._source.splice(b, 0, c);
					this.dispatchCoEvent(f.CollectionEventKind.MOVE, b, a, [c]);
					return c
				};
				b.dispatchCoEvent = function(a, b, c, e, d) {
					void 0 === a && (a = null);
					void 0 === b && (b = -1);
					void 0 === c && (c = -1);
					void 0 === e && (e = null);
					void 0 === d && (d = null);
					f.CollectionEvent.dispatchCollectionEvent(this, f.CollectionEvent.COLLECTION_CHANGE, a, b, c, e, d)
				};
				return c
			}(d.EventDispatcher);
		f.ArrayCollection = g;
		g.prototype.__class__ = "egret.gui.ArrayCollection"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a, b) {
					void 0 === a && (a = "children");
					void 0 === b && (b = "parent");
					e.call(this);
					this.childrenKey = "children";
					this.parentKey = "parent";
					this._source = null;
					this.nodeList = [];
					this._openNodes = [];
					this._showRoot = !1;
					this.childrenKey = a;
					this.parentKey = b
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "source", {
					get: function() {
						return this._source
					},
					set: function(a) {
						this._source = a;
						this._openNodes = [];
						this.nodeList = [];
						this._source && (this._showRoot ? this.nodeList.push(this._source) : (this._openNodes = [this._source], this.addChildren(this._source, this.nodeList)));
						this.dispatchCoEvent(f.CollectionEventKind.RESET)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "openNodes", {
					get: function() {
						return this._openNodes.concat()
					},
					set: function(a) {
						this._openNodes = a ? a.concat() : [];
						this.refresh()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "length", {
					get: function() {
						return this.nodeList.length
					},
					enumerable: !0,
					configurable: !0
				});
				b.getItemAt = function(a) {
					return this.nodeList[a]
				};
				b.getItemIndex = function(a) {
					for (var b = this.nodeList.length, c = 0; c < b; c++) if (this.nodeList[c] === a) return c;
					return -1
				};
				b.itemUpdated = function(a) {
					var b = this.getItemIndex(a); - 1 != b && this.dispatchCoEvent(f.CollectionEventKind.UPDATE, b, -1, [a])
				};
				b.removeItem = function(a) {
					this.isItemOpen(a) && this.closeNode(a);
					if (a) {
						var b = a[this.parentKey];
						if (b && (b = b[this.childrenKey])) {
							var c = b.indexOf(a); - 1 != c && b.splice(c, 1);
							a[this.parentKey] = null;
							c = this.nodeList.indexOf(a); - 1 != c && (this.nodeList.splice(c, 1), this.dispatchCoEvent(f.CollectionEventKind.REMOVE, c, -1, [a]))
						}
					}
				};
				Object.defineProperty(b, "showRoot", {
					get: function() {
						return this._showRoot
					},
					set: function(a) {
						this._showRoot != a && (this._showRoot = a, this._source && (this._showRoot ? this.nodeList.splice(0, 0, this._source) : (this.nodeList.shift(), -1 == this.openNodes.indexOf(this._source) && this.openNodes.push(this._source)), this.refresh()))
					},
					enumerable: !0,
					configurable: !0
				});
				b.addChildren = function(a, b) {
					if (a.hasOwnProperty(this.childrenKey) && -1 != this._openNodes.indexOf(a)) for (var c = a[this.childrenKey], e = c.length, d = 0; d < e; d++) {
						var f = c[d];
						b.push(f);
						this.addChildren(f, b)
					}
				};
				b.hasChildren = function(a) {
					return a.hasOwnProperty(this.childrenKey) ? 0 < a[this.childrenKey].length : !1
				};
				b.isItemOpen = function(a) {
					return -1 != this._openNodes.indexOf(a)
				};
				b.expandItem = function(a, b) {
					void 0 === b && (b = !0);
					b ? this.openNode(a) : this.closeNode(a)
				};
				b.openNode = function(a) {
					if (-1 == this._openNodes.indexOf(a)) {
						this._openNodes.push(a);
						var b = this.nodeList.indexOf(a);
						if (-1 != b) {
							var c = [];
							this.addChildren(a, c);
							for (var e = b; c.length;) {
								e++;
								var d = c.shift();
								this.nodeList.splice(e, 0, d);
								this.dispatchCoEvent(f.CollectionEventKind.ADD, e, -1, [d])
							}
							this.dispatchCoEvent("open", b, b, [a])
						}
					}
				};
				b.closeNode = function(a) {
					var b = this._openNodes.indexOf(a);
					if (-1 != b) {
						var c = [];
						this.addChildren(a, c);
						this._openNodes.splice(b, 1);
						b = this.nodeList.indexOf(a);
						if (-1 != b) {
							for (b++; c.length;) {
								var e = this.nodeList.splice(b, 1)[0];
								this.dispatchCoEvent(f.CollectionEventKind.REMOVE, b, -1, [e]);
								c.shift()
							}
							b--;
							this.dispatchCoEvent(f.CollectionEventKind.CLOSE, b, b, [a])
						}
					}
				};
				b.getDepth = function(a) {
					var b = 0;
					for (a = a[this.parentKey]; a;) b++, a = a[this.parentKey];
					0 < b && !this._showRoot && b--;
					return b
				};
				b.refresh = function() {
					this.nodeList = [];
					this._source && (this._showRoot && this.nodeList.push(this._source), this.addChildren(this._source, this.nodeList));
					this.dispatchCoEvent(f.CollectionEventKind.REFRESH)
				};
				b.dispatchCoEvent = function(a, b, c, e, d) {
					void 0 === a && (a = null);
					void 0 === b && (b = -1);
					void 0 === c && (c = -1);
					void 0 === e && (e = null);
					void 0 === d && (d = null);
					f.CollectionEvent.dispatchCollectionEvent(this, f.CollectionEvent.COLLECTION_CHANGE, a, b, c, e, d)
				};
				c.assignParent = function(a, b, e) {
					void 0 === b && (b = "children");
					void 0 === e && (e = "parent");
					if (a.hasOwnProperty(b)) for (var d = a[b], f = d.length, g = 0; g < f; g++) {
						var k = d[g];
						try {
							k[e] = a
						} catch (l) {}
						c.assignParent(k, b, e)
					}
				};
				return c
			}(d.EventDispatcher);
		f.ObjectCollection = g;
		g.prototype.__class__ = "egret.gui.ObjectCollection"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.targetLevel = Number.MAX_VALUE;
					this.updateCompleteQueue = new f.DepthQueue;
					this.invalidateClientPropertiesFlag = this.invalidatePropertiesFlag = !1;
					this.invalidatePropertiesQueue = new f.DepthQueue;
					this.invalidateClientSizeFlag = this.invalidateSizeFlag = !1;
					this.invalidateSizeQueue = new f.DepthQueue;
					this.invalidateDisplayListFlag = !1;
					this.invalidateDisplayListQueue = new f.DepthQueue;
					this.listenersAttached = !1
				}
				__extends(c, e);
				var b = c.prototype;
				b.invalidateProperties = function(a) {
					this.invalidatePropertiesFlag || (this.invalidatePropertiesFlag = !0, this.listenersAttached || this.attachListeners());
					this.targetLevel <= a.nestLevel && (this.invalidateClientPropertiesFlag = !0);
					this.invalidatePropertiesQueue.insert(a)
				};
				b.validateProperties = function() {
					for (var a = this.invalidatePropertiesQueue.shift(); a;) a.parent && (a.validateProperties(), a.updateCompletePendingFlag || (this.updateCompleteQueue.insert(a), a.updateCompletePendingFlag = !0)), a = this.invalidatePropertiesQueue.shift();
					this.invalidatePropertiesQueue.isEmpty() && (this.invalidatePropertiesFlag = !1)
				};
				b.invalidateSize = function(a) {
					this.invalidateSizeFlag || (this.invalidateSizeFlag = !0, this.listenersAttached || this.attachListeners());
					this.targetLevel <= a.nestLevel && (this.invalidateClientSizeFlag = !0);
					this.invalidateSizeQueue.insert(a)
				};
				b.validateSize = function() {
					for (var a = this.invalidateSizeQueue.pop(); a;) a.parent && (a.validateSize(), a.updateCompletePendingFlag || (this.updateCompleteQueue.insert(a), a.updateCompletePendingFlag = !0)), a = this.invalidateSizeQueue.pop();
					this.invalidateSizeQueue.isEmpty() && (this.invalidateSizeFlag = !1)
				};
				b.invalidateDisplayList = function(a) {
					this.invalidateDisplayListFlag || (this.invalidateDisplayListFlag = !0, this.listenersAttached || this.attachListeners());
					this.invalidateDisplayListQueue.insert(a)
				};
				b.validateDisplayList = function() {
					for (var a = this.invalidateDisplayListQueue.shift(); a;) a.parent && (a.validateDisplayList(), a.updateCompletePendingFlag || (this.updateCompleteQueue.insert(a), a.updateCompletePendingFlag = !0)), a = this.invalidateDisplayListQueue.shift();
					this.invalidateDisplayListQueue.isEmpty() && (this.invalidateDisplayListFlag = !1)
				};
				b.attachListeners = function() {
					f.UIGlobals.stage.addEventListener(d.Event.ENTER_FRAME, this.doPhasedInstantiationCallBack, this);
					f.UIGlobals.stage.addEventListener(d.Event.RENDER, this.doPhasedInstantiationCallBack, this);
					f.UIGlobals.stage.invalidate();
					this.listenersAttached = !0
				};
				b.doPhasedInstantiationCallBack = function(a) {
					f.UIGlobals.stage.removeEventListener(d.Event.ENTER_FRAME, this.doPhasedInstantiationCallBack, this);
					f.UIGlobals.stage.removeEventListener(d.Event.RENDER, this.doPhasedInstantiationCallBack, this);
					this.doPhasedInstantiation()
				};
				b.doPhasedInstantiation = function() {
					this.invalidatePropertiesFlag && this.validateProperties();
					this.invalidateSizeFlag && this.validateSize();
					this.invalidateDisplayListFlag && this.validateDisplayList();
					if (this.invalidatePropertiesFlag || this.invalidateSizeFlag || this.invalidateDisplayListFlag) this.attachListeners();
					else {
						this.listenersAttached = !1;
						for (var a = this.updateCompleteQueue.pop(); a;) a.initialized || (a.initialized = !0), a.hasEventListener(f.UIEvent.UPDATE_COMPLETE) && f.UIEvent.dispatchUIEvent(a, f.UIEvent.UPDATE_COMPLETE), a.updateCompletePendingFlag = !1, a = this.updateCompleteQueue.pop();
						f.UIEvent.dispatchUIEvent(this, f.UIEvent.UPDATE_COMPLETE)
					}
				};
				b.validateNow = function() {
					for (var a = 0; this.listenersAttached && 100 > a++;) this.doPhasedInstantiationCallBack()
				};
				b.validateClient = function(a, b) {
					void 0 === b && (b = !1);
					var c, e = !1,
						d = this.targetLevel;
					this.targetLevel == Number.MAX_VALUE && (this.targetLevel = a.nestLevel);
					for (; !e;) {
						e = !0;
						for (c = this.invalidatePropertiesQueue.removeSmallestChild(a); c;) c.parent && (c.validateProperties(), c.updateCompletePendingFlag || (this.updateCompleteQueue.insert(c), c.updateCompletePendingFlag = !0)), c = this.invalidatePropertiesQueue.removeSmallestChild(a);
						this.invalidatePropertiesQueue.isEmpty() && (this.invalidatePropertiesFlag = !1);
						this.invalidateClientPropertiesFlag = !1;
						for (c = this.invalidateSizeQueue.removeLargestChild(a); c;) {
							c.parent && (c.validateSize(), c.updateCompletePendingFlag || (this.updateCompleteQueue.insert(c), c.updateCompletePendingFlag = !0));
							if (this.invalidateClientPropertiesFlag && (c = this.invalidatePropertiesQueue.removeSmallestChild(a))) {
								this.invalidatePropertiesQueue.insert(c);
								e = !1;
								break
							}
							c = this.invalidateSizeQueue.removeLargestChild(a)
						}
						this.invalidateSizeQueue.isEmpty() && (this.invalidateSizeFlag = !1);
						this.invalidateClientSizeFlag = this.invalidateClientPropertiesFlag = !1;
						if (!b) {
							for (c = this.invalidateDisplayListQueue.removeSmallestChild(a); c;) {
								c.parent && (c.validateDisplayList(), c.updateCompletePendingFlag || (this.updateCompleteQueue.insert(c), c.updateCompletePendingFlag = !0));
								if (this.invalidateClientPropertiesFlag && (c = this.invalidatePropertiesQueue.removeSmallestChild(a))) {
									this.invalidatePropertiesQueue.insert(c);
									e = !1;
									break
								}
								if (this.invalidateClientSizeFlag && (c = this.invalidateSizeQueue.removeLargestChild(a))) {
									this.invalidateSizeQueue.insert(c);
									e = !1;
									break
								}
								c = this.invalidateDisplayListQueue.removeSmallestChild(a)
							}
							this.invalidateDisplayListQueue.isEmpty() && (this.invalidateDisplayListFlag = !1)
						}
					}
					if (d == Number.MAX_VALUE && (this.targetLevel = Number.MAX_VALUE, !b)) for (c = this.updateCompleteQueue.removeLargestChild(a); c;) c.initialized || (c.initialized = !0), c.hasEventListener(f.UIEvent.UPDATE_COMPLETE) && f.UIEvent.dispatchUIEvent(c, f.UIEvent.UPDATE_COMPLETE), c.updateCompletePendingFlag = !1, c = this.updateCompleteQueue.removeLargestChild(a)
				};
				return c
			}(d.EventDispatcher);
		f.LayoutManager = g;
		g.prototype.__class__ = "egret.gui.LayoutManager"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function c() {
					this.depthBins = [];
					this.minDepth = 0;
					this.maxDepth = -1
				}
				var b = c.prototype;
				b.insert = function(a) {
					var b = a.nestLevel,
						c = a.hashCode;
					this.maxDepth < this.minDepth ? this.minDepth = this.maxDepth = b : (b < this.minDepth && (this.minDepth = b), b > this.maxDepth && (this.maxDepth = b));
					var d = this.depthBins[b];
					d ? null == d.items[c] && (d.items[c] = a, d.length++) : (d = new e, this.depthBins[b] = d, d.items[c] = a, d.length++)
				};
				b.pop = function() {
					var a = null;
					if (this.minDepth <= this.maxDepth) {
						for (var b = this.depthBins[this.maxDepth]; !b || 0 == b.length;) {
							this.maxDepth--;
							if (this.maxDepth < this.minDepth) return null;
							b = this.depthBins[this.maxDepth]
						}
						var c = b.items,
							e;
						for (e in c) {
							a = c[e];
							this.remove(a, this.maxDepth);
							break
						}
						for (; !b || 0 == b.length;) {
							this.maxDepth--;
							if (this.maxDepth < this.minDepth) break;
							b = this.depthBins[this.maxDepth]
						}
					}
					return a
				};
				b.shift = function() {
					var a = null;
					if (this.minDepth <= this.maxDepth) {
						for (var b = this.depthBins[this.minDepth]; !b || 0 == b.length;) {
							this.minDepth++;
							if (this.minDepth > this.maxDepth) return null;
							b = this.depthBins[this.minDepth]
						}
						var c = b.items,
							e;
						for (e in c) {
							a = c[e];
							this.remove(a, this.minDepth);
							break
						}
						for (; !b || 0 == b.length;) {
							this.minDepth++;
							if (this.minDepth > this.maxDepth) break;
							b = this.depthBins[this.minDepth]
						}
					}
					return a
				};
				b.removeLargestChild = function(a) {
					for (var b = this.maxDepth, c = a.nestLevel, e = a.hashCode; c <= b;) {
						var f = this.depthBins[b];
						if (f && 0 < f.length) {
							if (b == a.nestLevel) {
								if (f.items[e]) return this.remove(a, b), a
							} else {
								var f = f.items,
									g;
								for (g in f) {
									var k = f[g];
									if (k instanceof d.DisplayObject && a instanceof d.DisplayObjectContainer && a.contains(k)) return this.remove(k, b), k
								}
							}
							b--
						} else if (b == this.maxDepth && this.maxDepth--, b--, b < c) break
					}
					return null
				};
				b.removeSmallestChild = function(a) {
					for (var b = a.nestLevel, c = a.hashCode; b <= this.maxDepth;) {
						var e = this.depthBins[b];
						if (e && 0 < e.length) {
							if (b == a.nestLevel) {
								if (e.items[c]) return this.remove(a, b), a
							} else {
								var e = e.items,
									f;
								for (f in e) {
									var g = e[f];
									if (g instanceof d.DisplayObject && a instanceof d.DisplayObjectContainer && a.contains(g)) return this.remove(g, b), g
								}
							}
							b++
						} else if (b == this.minDepth && this.minDepth++, b++, b > this.maxDepth) break
					}
					return null
				};
				b.remove = function(a, b) {
					void 0 === b && (b = -1);
					var c = a.hashCode,
						e = this.depthBins[0 <= b ? b : a.nestLevel];
					return e && null != e.items[c] ? (delete e.items[c], e.length--, a) : null
				};
				b.removeAll = function() {
					this.minDepth = this.depthBins.length = 0;
					this.maxDepth = -1
				};
				b.isEmpty = function() {
					return this.minDepth > this.maxDepth
				};
				return c
			}();
		f.DepthQueue = g;
		g.prototype.__class__ = "egret.gui.DepthQueue";
		var e = function() {
				return function() {
					this.length = 0;
					this.items = []
				}
			}();
		f.DepthBin = e;
		e.prototype.__class__ = "egret.gui.DepthBin"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				Object.defineProperty(e, "stage", {
					get: function() {
						return e._stage
					},
					enumerable: !0,
					configurable: !0
				});
				e._initlize = function(c) {
					e.initlized || (e._stage = c, e._layoutManager = new d.LayoutManager, e.initlized = !0)
				};
				Object.defineProperty(e, "uiStage", {
					get: function() {
						return e._uiStage
					},
					enumerable: !0,
					configurable: !0
				});
				e.initlized = !1;
				return e
			}();
		d.UIGlobals = g;
		g.prototype.__class__ = "egret.gui.UIGlobals"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._id = null;
					this._isPopUp = !1;
					this._owner = null;
					this.initializeCalled = this._initialized = this._updateCompletePendingFlag = !1;
					this._nestLevel = 0;
					this._hasOwnStyleChain = !1;
					this._styleProtoChain = null;
					this._hasNoStyleChild = !1;
					this._enabled = !0;
					this.oldWidth = NaN;
					this._width = 0;
					this.oldHeight = NaN;
					this._minWidth = this._height = 0;
					this._maxWidth = 1E4;
					this._minHeight = 0;
					this._maxHeight = 1E4;
					this._measuredHeight = this._measuredWidth = 0;
					this.oldY = this.oldX = NaN;
					this._invalidateSizeFlag = this._invalidatePropertiesFlag = !1;
					this._oldPreferHeight = this._oldPreferWidth = NaN;
					this._validateNowFlag = this._invalidateDisplayListFlag = !1;
					this._includeInLayout = !0;
					this._percentHeight = this._percentWidth = this._verticalCenter = this._horizontalCenter = this._bottom = this._top = this._right = this._left = NaN;
					this._layoutHeightExplicitlySet = this._layoutWidthExplicitlySet = !1;
					this.touchEnabled = !0;
					this.addEventListener(d.Event.ADDED_TO_STAGE, this.onAddedToStage, this);
					this.addEventListener(d.Event.ADDED_TO_STAGE, this.checkInvalidateFlag, this);
					void 0 === c.prototypeCanSet && (c.prototypeCanSet = void 0 !== {}.__proto__)
				}
				__extends(c, e);
				var b = c.prototype;
				b.onAddedToStage = function(a) {
					this.removeEventListener(d.Event.ADDED_TO_STAGE, this.onAddedToStage, this);
					this._initialize();
					f.UIGlobals._initlize(this.stage);
					0 < this._nestLevel && this.checkInvalidateFlag()
				};
				Object.defineProperty(b, "id", {
					get: function() {
						return this._id
					},
					set: function(a) {
						this._id = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "isPopUp", {
					get: function() {
						return this._isPopUp
					},
					set: function(a) {
						this._isPopUp = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "owner", {
					get: function() {
						return this._owner ? this._owner : this.parent
					},
					enumerable: !0,
					configurable: !0
				});
				b.ownerChanged = function(a) {
					this._owner = a
				};
				Object.defineProperty(b, "updateCompletePendingFlag", {
					get: function() {
						return this._updateCompletePendingFlag
					},
					set: function(a) {
						this._updateCompletePendingFlag = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "initialized", {
					get: function() {
						return this._initialized
					},
					set: function(a) {
						this._initialized != a && (this._initialized = a) && (this.childrenCreated(), f.UIEvent.dispatchUIEvent(this, f.UIEvent.CREATION_COMPLETE))
					},
					enumerable: !0,
					configurable: !0
				});
				b._initialize = function() {
					this.initializeCalled || (f.UIGlobals.stage && this.removeEventListener(d.Event.ADDED_TO_STAGE, this.onAddedToStage, this), this.initializeCalled = !0, f.UIEvent.dispatchUIEvent(this, f.UIEvent.INITIALIZE), this.createChildren(), this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
				};
				b.createChildren = function() {};
				b.childrenCreated = function() {};
				Object.defineProperty(b, "nestLevel", {
					get: function() {
						return this._nestLevel
					},
					set: function(a) {
						this._nestLevel != a && (this._nestLevel = a, 0 == this._nestLevel ? this.addEventListener(d.Event.ADDED_TO_STAGE, this.checkInvalidateFlag, this) : this.removeEventListener(d.Event.ADDED_TO_STAGE, this.checkInvalidateFlag, this), this._updateChildrenNestLevel())
					},
					enumerable: !0,
					configurable: !0
				});
				b._updateChildrenNestLevel = function() {
					for (var a = this.numChildren - 1; 0 <= a; a--) {
						var b = this.getChildAt(a);
						b && "nestLevel" in b && (b.nestLevel = this._nestLevel + 1)
					}
				};
				b.getStyle = function(a) {
					var b = this._styleProtoChain;
					return b ? b[a] : void 0
				};
				b.setStyle = function(a, b) {
					var c = this._styleProtoChain;
					this._hasOwnStyleChain || (c = this._createOwnStyleProtoChain(c));
					c[a] = b;
					this.styleChanged(a);
					this.notifyStyleChangeInChildren(a)
				};
				b.styleChanged = function(a) {};
				b.notifyStyleChangeInChildren = function(a) {
					if (!this._hasNoStyleChild) for (var b = this.numChildren - 1; 0 <= b; b--) {
						var c = this.getChildAt(b);
						c && "styleChanged" in c && (c.styleChanged(a), c.notifyStyleChangeInChildren(a))
					}
				};
				b._createOwnStyleProtoChain = function(a) {
					this._hasOwnStyleChain = !0;
					c.prototypeCanSet ? (this._styleProtoChain = {}, this._styleProtoChain.__proto__ = a ? a : c.emptyStyleChain) : this._styleProtoChain = this.createProtoChain(a);
					a = this._styleProtoChain;
					if (!this._hasNoStyleChild) for (var b = this.numChildren - 1; 0 <= b; b--) {
						var e = this.getChildAt(b);
						e && "regenerateStyleCache" in e && e.regenerateStyleCache(a)
					}
					return a
				};
				b.createProtoChain = function(a) {
					function b() {}
					b.prototype = a;
					a = new b;
					b.prototype = null;
					return a
				};
				b.clearStyle = function(a) {
					this._hasOwnStyleChain && (delete this._styleProtoChain[a], this.styleChanged(a), this.notifyStyleChangeInChildren(a))
				};
				b.regenerateStyleCache = function(a) {
					if (!c.prototypeCanSet) this.regenerateStyleCacheForIE(a);
					else if (this._hasOwnStyleChain) this._styleProtoChain.__proto__ = a ? a : c.emptyStyleChain;
					else if (this._styleProtoChain != a) {
						this._styleProtoChain = a;
						for (var b = this.numChildren - 1; 0 <= b; b--) {
							var e = this.getChildAt(b);
							e && "regenerateStyleCache" in e && e.regenerateStyleCache(a)
						}
					}
				};
				b.regenerateStyleCacheForIE = function(a) {
					if (this._hasOwnStyleChain) {
						var b = this._styleProtoChain;
						a = this.createProtoChain(a);
						for (var c in b) b.hasOwnProperty(c) && (a[c] = b[c])
					}
					this._styleProtoChain = a;
					if (!this._hasNoStyleChild) for (b = this.numChildren - 1; 0 <= b; b--)(c = this.getChildAt(b)) && "regenerateStyleCacheForIE" in c && c.regenerateStyleCacheForIE(a)
				};
				b._addToDisplayList = function(a, b) {
					void 0 === b && (b = !0);
					var c = this.numChildren;
					a.parent == this && c--;
					this._addingChild(a);
					this._doAddChild(a, c, b);
					this._childAdded(a);
					return a
				};
				b._addToDisplayListAt = function(a, b, c) {
					void 0 === c && (c = !0);
					this._addingChild(a);
					this._doAddChild(a, b, c);
					this._childAdded(a);
					return a
				};
				b._removeFromDisplayList = function(a, b) {
					void 0 === b && (b = !0);
					var c = this._children.indexOf(a);
					if (0 <= c) return this._doRemoveChild(c, b), this._childRemoved(a), a;
					d.Logger.fatalWithErrorId(1008);
					return null
				};
				b._removeFromDisplayListAt = function(a, b) {
					void 0 === b && (b = !0);
					if (0 <= a && a < this._children.length) {
						var c = this._doRemoveChild(a, b);
						this._childRemoved(c);
						return c
					}
					d.Logger.fatalWithErrorId(1007);
					return null
				};
				b.addChild = function(a) {
					this._addingChild(a);
					e.prototype.addChild.call(this, a);
					this._childAdded(a);
					return a
				};
				b.addChildAt = function(a, b) {
					this._addingChild(a);
					e.prototype.addChildAt.call(this, a, b);
					this._childAdded(a);
					return a
				};
				b._addingChild = function(a) {
					if (a && ("nestLevel" in a && (a.nestLevel = this._nestLevel + 1), "styleChanged" in a)) {
						var b = this._styleProtoChain;
						if (b || a._styleProtoChain) a.regenerateStyleCache(b), a.styleChanged(null), a.notifyStyleChangeInChildren(null)
					}
				};
				b._childAdded = function(a) {
					a instanceof c && (a._initialize(), a.checkInvalidateFlag())
				};
				b.removeChild = function(a) {
					e.prototype.removeChild.call(this, a);
					this._childRemoved(a);
					return a
				};
				b.removeChildAt = function(a) {
					a = e.prototype.removeChildAt.call(this, a);
					this._childRemoved(a);
					return a
				};
				b._childRemoved = function(a) {
					a && "nestLevel" in a && (a.nestLevel = 0)
				};
				b.checkInvalidateFlag = function(a) {
					f.UIGlobals._layoutManager && (this._invalidatePropertiesFlag && f.UIGlobals._layoutManager.invalidateProperties(this), this._invalidateSizeFlag && f.UIGlobals._layoutManager.invalidateSize(this), this._invalidateDisplayListFlag && f.UIGlobals._layoutManager.invalidateDisplayList(this), this._validateNowFlag && (f.UIGlobals._layoutManager.validateClient(this), this._validateNowFlag = !1))
				};
				Object.defineProperty(b, "enabled", {
					get: function() {
						return this._enabled
					},
					set: function(a) {
						this._enabled = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "width", {
					get: function() {
						return this._width
					},
					set: function(a) {
						this._setWidth(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setWidth = function(a) {
					if (this._width != a || this._explicitWidth != a) e.prototype._setWidth.call(this, a), isNaN(a) ? this.invalidateSize() : this._width = a, this.invalidateProperties(), this.invalidateDisplayList(), this.invalidateParentSizeAndDisplayList()
				};
				Object.defineProperty(b, "height", {
					get: function() {
						return this._height
					},
					set: function(a) {
						this._setHeight(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setHeight = function(a) {
					if (this._height != a || this._explicitHeight != a) e.prototype._setHeight.call(this, a), isNaN(a) ? this.invalidateSize() : this._height = a, this.invalidateProperties(), this.invalidateDisplayList(), this.invalidateParentSizeAndDisplayList()
				};
				Object.defineProperty(b, "scaleX", {
					get: function() {
						return this._scaleX
					},
					set: function(a) {
						this._setScaleX(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setScaleX = function(a) {
					this._scaleX != a && (this._scaleX = a, this.invalidateParentSizeAndDisplayList())
				};
				Object.defineProperty(b, "scaleY", {
					get: function() {
						return this._scaleY
					},
					set: function(a) {
						this._setScaleY(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setScaleY = function(a) {
					this._scaleY != a && (this._scaleY = a, this.invalidateParentSizeAndDisplayList())
				};
				Object.defineProperty(b, "minWidth", {
					get: function() {
						return this._minWidth
					},
					set: function(a) {
						this._minWidth != a && (this._minWidth = a, this.invalidateSize())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maxWidth", {
					get: function() {
						return this._maxWidth
					},
					set: function(a) {
						this._maxWidth != a && (this._maxWidth = a, this.invalidateSize())
					},
					enumerable: !0,
					configurable: !0
				});
				b._getMaxWidth = function() {
					return this._maxWidth
				};
				Object.defineProperty(b, "minHeight", {
					get: function() {
						return this._minHeight
					},
					set: function(a) {
						this._minHeight != a && (this._minHeight = a, this.invalidateSize())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maxHeight", {
					get: function() {
						return this._maxHeight
					},
					set: function(a) {
						this._maxHeight != a && (this._maxHeight = a, this.invalidateSize())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "measuredWidth", {
					get: function() {
						return this._measuredWidth
					},
					set: function(a) {
						this._measuredWidth = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "measuredHeight", {
					get: function() {
						return this._measuredHeight
					},
					set: function(a) {
						this._measuredHeight = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.setActualSize = function(a, b) {
					var c = !1;
					this._width != a && (this._width = a, c = !0);
					this._height != b && (this._height = b, c = !0);
					c && (this.invalidateDisplayList(), this.dispatchResizeEvent())
				};
				Object.defineProperty(b, "x", {
					get: function() {
						return this._x
					},
					set: function(a) {
						this._x != a && (this._setX(a), this.invalidateProperties(), this._includeInLayout && this.parent && this.parent instanceof c && this.parent._childXYChanged())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "y", {
					get: function() {
						return this._y
					},
					set: function(a) {
						this._y != a && (this._setY(a), this.invalidateProperties(), this._includeInLayout && this.parent && this.parent instanceof c && this.parent._childXYChanged())
					},
					enumerable: !0,
					configurable: !0
				});
				b.invalidateProperties = function() {
					this._invalidatePropertiesFlag || (this._invalidatePropertiesFlag = !0, this.parent && f.UIGlobals._layoutManager && f.UIGlobals._layoutManager.invalidateProperties(this))
				};
				b.validateProperties = function() {
					this._invalidatePropertiesFlag && (this.commitProperties(), this._invalidatePropertiesFlag = !1)
				};
				b.invalidateSize = function() {
					this._invalidateSizeFlag || (this._invalidateSizeFlag = !0, this.parent && f.UIGlobals._layoutManager && f.UIGlobals._layoutManager.invalidateSize(this))
				};
				b.validateSize = function(a) {
					void 0 === a && (a = !1);
					if (a) for (a = 0; a < this.numChildren; a++) {
						var b = this.getChildAt(a);
						"validateSize" in b && b.validateSize(!0)
					}
					this._invalidateSizeFlag && (this.measureSizes() && (this.invalidateDisplayList(), this.invalidateParentSizeAndDisplayList()), this._invalidateSizeFlag = !1)
				};
				b.measureSizes = function() {
					var a = !1;
					if (!this._invalidateSizeFlag) return a;
					this.canSkipMeasurement() || (this.measure(), this.measuredWidth < this.minWidth && (this.measuredWidth = this.minWidth), this.measuredWidth > this.maxWidth && (this.measuredWidth = this.maxWidth), this.measuredHeight < this.minHeight && (this.measuredHeight = this.minHeight), this.measuredHeight > this.maxHeight && (this.measuredHeight = this.maxHeight));
					if (isNaN(this._oldPreferWidth)) this._oldPreferWidth = this.preferredWidth, this._oldPreferHeight = this.preferredHeight, a = !0;
					else {
						if (this.preferredWidth != this._oldPreferWidth || this.preferredHeight != this._oldPreferHeight) a = !0;
						this._oldPreferWidth = this.preferredWidth;
						this._oldPreferHeight = this.preferredHeight
					}
					return a
				};
				b.invalidateDisplayList = function() {
					this._invalidateDisplayListFlag || (this._invalidateDisplayListFlag = !0, this.parent && f.UIGlobals._layoutManager && f.UIGlobals._layoutManager.invalidateDisplayList(this), this._setSizeDirty())
				};
				b.validateDisplayList = function() {
					if (this._invalidateDisplayListFlag) {
						var a = 0,
							b = 0,
							a = this._layoutWidthExplicitlySet ? this._width : isNaN(this.explicitWidth) ? this.measuredWidth : this._explicitWidth,
							b = this._layoutHeightExplicitlySet ? this._height : isNaN(this.explicitHeight) ? this.measuredHeight : this._explicitHeight;
						isNaN(a) && (a = 0);
						isNaN(b) && (b = 0);
						this.setActualSize(a, b);
						this.updateDisplayList(a, b);
						this._invalidateDisplayListFlag = !1
					}
				};
				b.validateNow = function(a) {
					void 0 === a && (a = !1);
					this._validateNowFlag || null == f.UIGlobals._layoutManager ? this._validateNowFlag = !0 : f.UIGlobals._layoutManager.validateClient(this, a)
				};
				b.invalidateParentSizeAndDisplayList = function() {
					if (this.parent && this._includeInLayout && "invalidateSize" in this.parent) {
						var a = this.parent;
						a.invalidateSize();
						a.invalidateDisplayList()
					}
				};
				b.updateDisplayList = function(a, b) {};
				b.canSkipMeasurement = function() {
					return !isNaN(this._explicitWidth) && !isNaN(this._explicitHeight)
				};
				b.commitProperties = function() {
					this.oldWidth == this._width && this.oldHeight == this._height || this.dispatchResizeEvent();
					this.oldX == this.x && this.oldY == this.y || this.dispatchMoveEvent()
				};
				b.measure = function() {
					this._measuredWidth = this._measuredHeight = 0
				};
				b.dispatchMoveEvent = function() {
					this.hasEventListener(f.MoveEvent.MOVE) && f.MoveEvent.dispatchMoveEvent(this, this.oldX, this.oldY);
					this.oldX = this.x;
					this.oldY = this.y
				};
				b._childXYChanged = function() {};
				b.dispatchResizeEvent = function() {
					this.hasEventListener(f.ResizeEvent.RESIZE) && f.ResizeEvent.dispatchResizeEvent(this, this.oldWidth, this.oldHeight);
					this.oldWidth = this._width;
					this.oldHeight = this._height
				};
				Object.defineProperty(b, "includeInLayout", {
					get: function() {
						return this._includeInLayout
					},
					set: function(a) {
						this._includeInLayout != a && (this._includeInLayout = !0, this.invalidateParentSizeAndDisplayList(), this._includeInLayout = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "left", {
					get: function() {
						return this._left
					},
					set: function(a) {
						this._left != a && (this._left = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "right", {
					get: function() {
						return this._right
					},
					set: function(a) {
						this._right != a && (this._right = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "top", {
					get: function() {
						return this._top
					},
					set: function(a) {
						this._top != a && (this._top = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "bottom", {
					get: function() {
						return this._bottom
					},
					set: function(a) {
						this._bottom != a && (this._bottom = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "horizontalCenter", {
					get: function() {
						return this._horizontalCenter
					},
					set: function(a) {
						this._horizontalCenter != a && (this._horizontalCenter = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalCenter", {
					get: function() {
						return this._verticalCenter
					},
					set: function(a) {
						this._verticalCenter != a && (this._verticalCenter = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "percentWidth", {
					get: function() {
						return this._percentWidth
					},
					set: function(a) {
						this._percentWidth != a && (this._percentWidth = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "percentHeight", {
					get: function() {
						return this._percentHeight
					},
					set: function(a) {
						this._percentHeight != a && (this._percentHeight = a, this.invalidateParentSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.setLayoutBoundsSize = function(a, b) {
					isNaN(a) ? (this._layoutWidthExplicitlySet = !1, a = this.preferredWidth) : this._layoutWidthExplicitlySet = !0;
					isNaN(b) ? (this._layoutHeightExplicitlySet = !1, b = this.preferredHeight) : this._layoutHeightExplicitlySet = !0;
					this.setActualSize(a / this._scaleX, b / this._scaleY)
				};
				b.setLayoutBoundsPosition = function(a, b) {
					0 > this._scaleX && (a += this.layoutBoundsWidth);
					0 > this._scaleY && (b += this.layoutBoundsHeight);
					var c = !1;
					this._x != a && (this._setX(a), c = !0);
					this._y != b && (this._setY(b), c = !0);
					c && this.dispatchMoveEvent()
				};
				Object.defineProperty(b, "preferredWidth", {
					get: function() {
						var a = this._hasWidthSet ? this._explicitWidth : this._measuredWidth,
							b = this._scaleX;
						0 > b && (b = -b);
						return a * b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "preferredHeight", {
					get: function() {
						var a = this._hasHeightSet ? this._explicitHeight : this._measuredHeight,
							b = this._scaleY;
						0 > b && (b = -b);
						return a * b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "preferredX", {
					get: function() {
						return 0 <= this._scaleX ? this._x : this._x - this.preferredWidth
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "preferredY", {
					get: function() {
						return 0 <= this._scaleY ? this._y : this._y - this.preferredHeight
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "layoutBoundsX", {
					get: function() {
						return 0 <= this._scaleX ? this._x : this._x - this.layoutBoundsWidth
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "layoutBoundsY", {
					get: function() {
						return 0 <= this._scaleY ? this._y : this._y - this.layoutBoundsHeight
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "layoutBoundsWidth", {
					get: function() {
						var a = 0,
							a = this._layoutWidthExplicitlySet ? this._width : this._hasWidthSet ? this._explicitWidth : this._measuredWidth,
							b = this._scaleX;
						0 > b && (b = -b);
						return a * b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "layoutBoundsHeight", {
					get: function() {
						var a = 0,
							a = this._layoutHeightExplicitlySet ? this._height : this._hasHeightSet ? this._explicitHeight : this._measuredHeight,
							b = this.scaleY;
						0 > b && (b = -b);
						return a * b
					},
					enumerable: !0,
					configurable: !0
				});
				c.prototypeCanSet = void 0;
				c.emptyStyleChain = {};
				return c
			}(d.DisplayObjectContainer);
		f.UIComponent = g;
		g.prototype.__class__ = "egret.gui.UIComponent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.ABOVE = "above";
				e.BELOW = "below";
				e.CENTER = "center";
				e.TOP_LEFT = "topLeft";
				e.LEFT = "left";
				e.RIGHT = "right";
				e.SCREEN_CENTER = "screenCenter";
				return e
			}();
		d.PopUpPosition = g;
		g.prototype.__class__ = "egret.gui.PopUpPosition"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.AUTO = "auto";
				e.OFF = "off";
				e.ON = "on";
				return e
			}();
		d.ScrollPolicy = g;
		g.prototype.__class__ = "egret.gui.ScrollPolicy"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b) {
					void 0 === b && (b = null);
					e.call(this);
					this.generator = null;
					this.generator = b
				}
				__extends(c, e);
				c.prototype.newInstance = function() {
					return new this.generator
				};
				return c
			}(d.HashObject);
		f.ClassFactory = g;
		g.prototype.__class__ = "egret.gui.ClassFactory"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.DOWN = 40;
				e.END = 35;
				e.HOME = 36;
				e.LEFT = 37;
				e.PAGE_DOWN = 34;
				e.PAGE_LEFT = 9111;
				e.PAGE_RIGHT = 9112;
				e.PAGE_UP = 33;
				e.RIGHT = 39;
				e.UP = 38;
				return e
			}();
		d.NavigationUnit = g;
		g.prototype.__class__ = "egret.gui.NavigationUnit"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.initialize = function(a) {};
				b.apply = function(a) {};
				b.remove = function(a) {};
				b.initializeFromObject = function(a) {
					for (var b in a) this[b] = a[b];
					return this
				};
				return c
			}(d.HashObject);
		f.OverrideBase = g;
		g.prototype.__class__ = "egret.gui.OverrideBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a, b, d, f) {
					e.call(this);
					this.propertyName = "";
					this.position = c.LAST;
					this.target = this.relativeTo = null;
					this.target = a;
					this.propertyName = b;
					this.position = d;
					this.relativeTo = f
				}
				__extends(c, e);
				var b = c.prototype;
				b.initialize = function(a) {
					if ((a = a[this.target]) && !(a instanceof d.SkinnableComponent) && "_initialize" in a) try {
						a._initialize()
					} catch (b) {}
				};
				b.apply = function(a) {
					var b, e;
					try {
						e = a[this.relativeTo]
					} catch (d) {}
					var f = a[this.target];
					a = this.propertyName ? a[this.propertyName] : a;
					if (f && a) {
						switch (this.position) {
						case c.FIRST:
							b = 0;
							break;
						case c.LAST:
							b = -1;
							break;
						case c.BEFORE:
							b = a.getElementIndex(e);
							break;
						case c.AFTER:
							b = a.getElementIndex(e) + 1
						} - 1 == b && (b = a.numElements);
						a.addElementAt(f, b)
					}
				};
				b.remove = function(a) {
					var b = null == this.propertyName || "" == this.propertyName ? a : a[this.propertyName];
					(a = a[this.target]) && b && -1 != b.getElementIndex(a) && b.removeElement(a)
				};
				c.FIRST = "first";
				c.LAST = "last";
				c.BEFORE = "before";
				c.AFTER = "after";
				return c
			}(d.OverrideBase);
		d.AddItems = g;
		g.prototype.__class__ = "egret.gui.AddItems"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a, b, c) {
					e.call(this);
					this.oldValue = this.value = this.target = this.name = null;
					this.target = a;
					this.name = b;
					this.value = c
				}
				__extends(c, e);
				var b = c.prototype;
				b.apply = function(a) {
					a = null == this.target || "" == this.target ? a : a[this.target];
					null != a && (this.oldValue = a[this.name], this.setPropertyValue(a, this.name, this.value, this.oldValue))
				};
				b.remove = function(a) {
					a = null == this.target || "" == this.target ? a : a[this.target];
					null != a && (this.setPropertyValue(a, this.name, this.oldValue, this.oldValue), this.oldValue = null)
				};
				b.setPropertyValue = function(a, b, c, e) {
					a[b] = void 0 === c || null === c ? c : "number" == typeof e ? parseFloat(c) : "boolean" == typeof e ? this.toBoolean(c) : c
				};
				b.toBoolean = function(a) {
					return "string" == typeof a ? "true" == a.toLowerCase() : !1 != a
				};
				return c
			}(d.OverrideBase);
		d.SetProperty = g;
		g.prototype.__class__ = "egret.gui.SetProperty"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a, b, c) {
					e.call(this);
					this.target = a;
					this.name = b;
					this.value = c
				}
				__extends(c, e);
				var b = c.prototype;
				b.apply = function(a) {
					a = null == this.target || "" == this.target ? a : a[this.target];
					null != a && (this.oldValue = a.getStyle(this.name), this.setStyleValue(a, this.name, this.value, this.oldValue))
				};
				b.remove = function(a) {
					a = null == this.target || "" == this.target ? a : a[this.target];
					null != a && (this.setStyleValue(a, this.name, this.oldValue, this.oldValue), this.oldValue = null)
				};
				b.setStyleValue = function(a, b, c, e) {
					void 0 === c ? a.clearStyle(b) : null === c ? a.setStyle(b, c) : "number" == typeof e ? a.setStyle(b, parseFloat(c)) : "boolean" == typeof e ? a.setStyle(b, this.toBoolean(c)) : a.setStyle(b, c)
				};
				b.toBoolean = function(a) {
					return "string" == typeof a ? "true" == a.toLowerCase() : !1 != a
				};
				return c
			}(d.OverrideBase);
		d.SetStyle = g;
		g.prototype.__class__ = "egret.gui.SetStyle"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a) {
					e.call(this);
					this.initialized = !1;
					this.name = null;
					this.name = b;
					this.overrides = a
				}
				__extends(c, e);
				c.prototype.initialize = function(b) {
					if (!this.initialized) {
						this.initialized = !0;
						for (var a = 0; a < this.overrides.length; a++) this.overrides[a].initialize(b)
					}
				};
				return c
			}(d.HashObject);
		f.State = g;
		g.prototype.__class__ = "egret.gui.State"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.adjustRelativeByXY = function(c, b) {
					void 0 === b && (b = null);
					if (c && (b || (b = c.parent), b)) {
						var a = c.x,
							e = c.y,
							d = c.layoutBoundsHeight,
							f = c.layoutBoundsWidth,
							g = b.width,
							r = b.height;
						isNaN(c.left) || (c.left = a);
						isNaN(c.right) || (c.right = g - a - f);
						isNaN(c.horizontalCenter) || (c.horizontalCenter = a + 0.5 * f - 0.5 * g);
						isNaN(c.top) || (c.top = e);
						isNaN(c.bottom) || (c.bottom = r - e - d);
						isNaN(c.verticalCenter) || (c.verticalCenter = 0.5 * d - 0.5 * r + e)
					}
				};
				return e
			}();
		d.LayoutUtil = g;
		g.prototype.__class__ = "egret.gui.LayoutUtil"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = {};
		f.getScale9Grid = function(e) {
			if (g[e]) return g[e];
			if (!e) return null;
			var c = e.split(","),
				c = new d.Rectangle(parseInt(c[0]), parseInt(c[1]), parseInt(c[2]), parseInt(c[3]));
			return g[e] = c
		}
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		d.setProperties = function(d, e, c) {
			for (var b = e.length, a = 0; a < b; a++) d[e[a]] = c[a];
			return d
		}
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e(b) {
					void 0 === b && (b = 0.5);
					this._easeInFraction = 0.5;
					this.easeInFraction = b
				}
				var c = e.prototype;
				Object.defineProperty(c, "easeInFraction", {
					get: function() {
						return this._easeInFraction
					},
					set: function(b) {
						this._easeInFraction = b
					},
					enumerable: !0,
					configurable: !0
				});
				c.ease = function(b) {
					var a = 1 - this._easeInFraction;
					return b <= this._easeInFraction && 0 < this._easeInFraction ? this._easeInFraction * this._easeIn(b / this._easeInFraction) : this._easeInFraction + a * this._easeOut((b - this._easeInFraction) / a)
				};
				c._easeIn = function(b) {
					return b
				};
				c._easeOut = function(b) {
					return b
				};
				return e
			}();
		d.EaseInOutBase = g;
		g.prototype.__class__ = "egret.gui.EaseInOutBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				var c = e.prototype;
				c.ease = function(b) {
					return this.easeOut(b, 0, 1, 1)
				};
				c.easeOut = function(b, a, c, e) {
					return (b /= e) < 1 / 2.75 ? 7.5625 * c * b * b + a : b < 2 / 2.75 ? c * (7.5625 * (b -= 1.5 / 2.75) * b + 0.75) + a : b < 2.5 / 2.75 ? c * (7.5625 * (b -= 2.25 / 2.75) * b + 0.9375) + a : c * (7.5625 * (b -= 2.625 / 2.75) * b + 0.984375) + a
				};
				return e
			}();
		d.Bounce = g;
		g.prototype.__class__ = "egret.gui.Bounce"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				var c = e.prototype;
				c.ease = function(b) {
					return this.easeOut(b, 0, 1, 1)
				};
				c.easeOut = function(b, a, c, e, d, f) {
					void 0 === d && (d = 0);
					void 0 === f && (f = 0);
					if (0 == b) return a;
					if (1 == (b /= e)) return a + c;
					f || (f = 0.3 * e);
					var g;
					!d || d < Math.abs(c) ? (d = c, g = f / 4) : g = f / (2 * Math.PI) * Math.asin(c / d);
					return d * Math.pow(2, -10 * b) * Math.sin(2 * (b * e - g) * Math.PI / f) + c + a
				};
				return e
			}();
		d.Elastic = g;
		g.prototype.__class__ = "egret.gui.Elastic"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e(b, a) {
					void 0 === b && (b = 0);
					void 0 === a && (a = 0);
					this._easeOutFraction = this._easeInFraction = 0;
					this.easeInFraction = b;
					this.easeOutFraction = a
				}
				var c = e.prototype;
				Object.defineProperty(c, "easeInFraction", {
					get: function() {
						return this._easeInFraction
					},
					set: function(b) {
						this._easeInFraction = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "easeOutFraction", {
					get: function() {
						return this._easeOutFraction
					},
					set: function(b) {
						this._easeOutFraction = b
					},
					enumerable: !0,
					configurable: !0
				});
				c.ease = function(b) {
					if (0 == this.easeInFraction && 0 == this.easeOutFraction) return b;
					var a = 1 / (1 - this.easeInFraction / 2 - this.easeOutFraction / 2);
					return b < this.easeInFraction ? b / this.easeInFraction * a * b / 2 : b > 1 - this.easeOutFraction ? (b -= 1 - this.easeOutFraction, a * (1 - this.easeInFraction / 2 - this.easeOutFraction + b * (2 - b / this.easeOutFraction) / 2)) : a * (b - this.easeInFraction / 2)
				};
				return e
			}();
		d.Linear = g;
		g.prototype.__class__ = "egret.gui.Linear"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a, b) {
					void 0 === a && (a = 0.5);
					void 0 === b && (b = 2);
					e.call(this, a);
					this.exponent = b
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "exponent", {
					get: function() {
						return this._exponent
					},
					set: function(a) {
						this._exponent = a
					},
					enumerable: !0,
					configurable: !0
				});
				b._easeIn = function(a) {
					return Math.pow(a, this._exponent)
				};
				b._easeOut = function(a) {
					return 1 - Math.pow(1 - a, this._exponent)
				};
				return c
			}(d.EaseInOutBase);
		d.Power = g;
		g.prototype.__class__ = "egret.gui.Power"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = 0.5);
					e.call(this, a)
				}
				__extends(c, e);
				var b = c.prototype;
				b._easeIn = function(a) {
					return 1 - Math.cos(a * Math.PI / 2)
				};
				b._easeOut = function(a) {
					return Math.sin(a * Math.PI / 2)
				};
				return c
			}(d.EaseInOutBase);
		d.Sine = g;
		g.prototype.__class__ = "egret.gui.Sine"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				var c = e.prototype;
				e.getInstance = function() {
					e.theInstance || (e.theInstance = new e);
					return e.theInstance
				};
				c.interpolate = function(b, a, c) {
					return 0 == b ? a : 1 == b ? c : a + b * (c - a)
				};
				c.increment = function(b, a) {
					return b + a
				};
				c.decrement = function(b, a) {
					return b - a
				};
				return e
			}();
		d.NumberInterpolator = g;
		g.prototype.__class__ = "egret.gui.NumberInterpolator"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.LOOP = "loop";
				e.REVERSE = "reverse";
				return e
			}();
		d.RepeatBehavior = g;
		g.prototype.__class__ = "egret.gui.RepeatBehavior"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e(c, b, a) {
					void 0 === c && (c = NaN);
					void 0 === b && (b = null);
					void 0 === a && (a = null);
					this.value = b;
					this.time = c;
					this.valueBy = a
				}
				e.prototype.clone = function() {
					var c = new e(this.time, this.value, this.valueBy);
					c.easer = this.easer;
					c._timeFraction = this._timeFraction;
					return c
				};
				return e
			}();
		d.Keyframe = g;
		g.prototype.__class__ = "egret.gui.Keyframe"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e(b) {
					void 0 === b && (b = null);
					this.interpolator = d.NumberInterpolator.getInstance();
					this.property = b
				}
				var c = e.prototype;
				c.clone = function() {
					var b = new e(this.property);
					b.interpolator = this.interpolator;
					if (null !== this.keyframes) {
						b.keyframes = [];
						for (var a = 0; a < this.keyframes.length; ++a) b.keyframes[a] = this.keyframes[a].clone()
					}
					return b
				};
				c._scaleKeyframes = function(b) {
					for (var a = this.keyframes.length, c = 0; c < a; ++c) {
						var e = this.keyframes[c];
						e._timeFraction = e.time / b
					}
				};
				c.getValue = function(b) {
					if (!this.keyframes) return null;
					var a = this.keyframes.length;
					if (2 == a && 1 == this.keyframes[1]._timeFraction) {
						var c = null != this.keyframes[1].easer ? this.keyframes[1].easer.ease(b) : b;
						return this.interpolator.interpolate(c, this.keyframes[0].value, this.keyframes[1].value)
					}
					isNaN(this.keyframes[0]._timeFraction) && this._scaleKeyframes(this.keyframes[this.keyframes.length - 1].time);
					for (var e = 0, c = this.keyframes[0].value, d = 1; d < a; ++d) {
						var f = this.keyframes[d];
						if (b >= e && b < f._timeFraction) return b = (b - e) / (f._timeFraction - e), b = null != f.easer ? f.easer.ease(b) : b, this.interpolator.interpolate(b, c, f.value);
						e = f._timeFraction;
						c = f.value
					}
					return this.keyframes[a - 1].value
				};
				return e
			}();
		d.MotionPath = g;
		g.prototype.__class__ = "egret.gui.MotionPath"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a, b, c, g) {
					void 0 === a && (a = null);
					void 0 === b && (b = null);
					void 0 === c && (c = null);
					void 0 === g && (g = null);
					e.call(this);
					this.property = a;
					this.keyframes = [new d.Keyframe(0, b), new d.Keyframe(NaN, c, g)]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "valueFrom", {
					get: function() {
						return this.keyframes[0].value
					},
					set: function(a) {
						this.keyframes[0].value = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "valueTo", {
					get: function() {
						return this.keyframes[this.keyframes.length - 1].value
					},
					set: function(a) {
						this.keyframes[this.keyframes.length - 1].value = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "valueBy", {
					get: function() {
						return this.keyframes[this.keyframes.length - 1].valueBy
					},
					set: function(a) {
						this.keyframes[this.keyframes.length - 1].valueBy = a
					},
					enumerable: !0,
					configurable: !0
				});
				return c
			}(d.MotionPath);
		d.SimpleMotionPath = g;
		g.prototype.__class__ = "egret.gui.SimpleMotionPath"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e(b, a) {
					this._easer = e.defaultEaser;
					this.repeatFunction = this.stopFunction = this.updateFunction = this.endFunction = this.startFunction = this.thisObject = null;
					this.id = -1;
					this.started = this._invertValues = this._doReverse = this._isPlaying = this._doSeek = !1;
					this.delayedStartTime = this.delayTime = -1;
					this._playheadTime = 0;
					this.duration = 500;
					this._repeatBehavior = f.RepeatBehavior.LOOP;
					this._repeatCount = 1;
					this._startDelay = this._repeatDelay = 0;
					this.interpolator = null;
					this._cycleTime = 0;
					this.updateFunction = b;
					this.thisObject = a
				}
				var c = e.prototype;
				Object.defineProperty(c, "easer", {
					get: function() {
						return this._easer
					},
					set: function(b) {
						b || (b = e.defaultEaser);
						this._easer = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "playheadTime", {
					get: function() {
						return this._playheadTime + this.startDelay
					},
					set: function(b) {
						this._invertValues = !1;
						this.seek(b, !0)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "isPlaying", {
					get: function() {
						return this._isPlaying
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "repeatBehavior", {
					get: function() {
						return this._repeatBehavior
					},
					set: function(b) {
						this._repeatBehavior = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "repeatCount", {
					get: function() {
						return this._repeatCount
					},
					set: function(b) {
						this._repeatCount = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "repeatDelay", {
					get: function() {
						return this._repeatDelay
					},
					set: function(b) {
						this._repeatDelay = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "startDelay", {
					get: function() {
						return this._startDelay
					},
					set: function(b) {
						this._startDelay = b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "cycleTime", {
					get: function() {
						return this._cycleTime
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "cycleFraction", {
					get: function() {
						return this._cycleFraction
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "playReversed", {
					get: function() {
						return this._playReversed
					},
					set: function(b) {
						this._isPlaying && this._invertValues != b && (this._invertValues = b, this.seek(this.duration - this._cycleTime, !0));
						this._playReversed = this._doReverse = b
					},
					enumerable: !0,
					configurable: !0
				});
				e.addAnimation = function(b) {
					if (b.motionPaths && 0 < b.motionPaths.length && b.motionPaths[0] && ("width" == b.motionPaths[0].property || "height" == b.motionPaths[0].property)) {
						e.activeAnimations.splice(0, 0, b);
						b.id = 0;
						for (var a = 1; a < e.activeAnimations.length; ++a) e.activeAnimations[a].id = a
					} else b.id = e.activeAnimations.length, e.activeAnimations.push(b);
					e.timer || (e.pulse(), e.timer = new d.Timer(e.TIMER_RESOLUTION), e.timer.addEventListener(d.TimerEvent.TIMER, e.timerHandler, e), e.timer.start());
					e.intervalTime = e.currentTime;
					b.cycleStartTime = e.intervalTime
				};
				e.removeAnimationAt = function(b) {
					void 0 === b && (b = 0);
					if (0 <= b && b < e.activeAnimations.length) {
						e.activeAnimations.splice(b, 1);
						for (var a = e.activeAnimations.length; b < a; b++) e.activeAnimations[b].id--
					}
					e.stopTimerIfDone()
				};
				e.removeAnimation = function(b) {
					e.removeAnimationAt(b.id)
				};
				e.timerHandler = function(b) {
					e.intervalTime = e.pulse();
					for (b = 0; b < e.activeAnimations.length;) {
						var a = !0,
							c = e.activeAnimations[b];
						c && (a = !c.doInterval());
						a && ++b
					}
					for (; 0 < e.delayedStartAnims.length;) if (b = e.delayedStartAnims[0], b.delayedStartTime < e.currentTime) b.playReversed ? b.end() : b.start();
					else break
				};
				c.doInterval = function() {
					var b = !1,
						a = !1;
					if (this._isPlaying || this._doSeek) {
						var c = e.intervalTime - this.cycleStartTime;
						this._playheadTime = e.intervalTime - this.startTime;
						if (c >= this.duration) {
							var g = 2;
							0 < this.duration + this.repeatDelay && (g += Math.floor((this._playheadTime - this.duration) / (this.duration + this.repeatDelay)));
							if (0 == this.repeatCount || g <= this.repeatCount) if (0 == this.repeatDelay) this._cycleTime = c % this.duration, this.cycleStartTime = e.intervalTime - this._cycleTime, c = this._cycleTime, this.repeatBehavior == f.RepeatBehavior.REVERSE && (this._invertValues = 1 < this.repeatCount ? !(g % 2) : !this._invertValues), a = !0;
							else return this._doSeek ? (this._cycleTime = c % (this.duration + this.repeatDelay), this._cycleTime > this.duration && (this._cycleTime = this.duration), this.calculateValue(this._cycleTime), this.sendUpdateEvent()) : (this._cycleTime = this.duration, this.calculateValue(this._cycleTime), this.sendUpdateEvent(), e.removeAnimation(this), b = new d.Timer(this.repeatDelay, 1), b.addEventListener(d.TimerEvent.TIMER, this.repeat, this), b.start()), !1;
							else c > this.duration && (this._playheadTime = c = this.duration)
						}
						this._cycleTime = c;
						this.calculateValue(c);
						c >= this.duration && !this._doSeek ? this.playReversed && 0 != this.startDelay ? (this.stopAnimation(), this.addToDelayedAnimations(this.startDelay)) : (this.end(), b = !0) : (a && this.sendAnimationEvent("repeatFunction"), this.sendUpdateEvent())
					}
					return b
				};
				c.sendUpdateEvent = function() {
					this.sendAnimationEvent("updateFunction")
				};
				c.sendAnimationEvent = function(b) {
					null != this[b] && this[b].call(this.thisObject, this)
				};
				c.calculateValue = function(b) {
					var a = 0;
					this.currentValue = {};
					if (0 == this.duration) for (a = 0; a < this.motionPaths.length; ++a) this.currentValue[this.motionPaths[a].property] = this._invertValues ? this.motionPaths[a].keyframes[0].value : this.motionPaths[a].keyframes[this.motionPaths[a].keyframes.length - 1].value;
					else if (this._invertValues && (b = this.duration - b), this._cycleFraction = this.easer.ease(b / this.duration), this.motionPaths) for (a = 0; a < this.motionPaths.length; ++a) this.currentValue[this.motionPaths[a].property] = this.motionPaths[a].getValue(this._cycleFraction)
				};
				c.removeFromDelayedAnimations = function() {
					if (0 <= this.delayedStartTime) {
						for (var b = 0; b < e.delayedStartAnims.length; ++b) if (e.delayedStartAnims[b] == this) {
							e.delayedStartAnims.splice(b, 1);
							break
						}
						this.delayedStartTime = -1
					}
				};
				c.end = function() {
					0 < this.startDelay && 0 < e.delayedStartAnims.length && this.removeFromDelayedAnimations();
					this.started || this.sendAnimationEvent("startFunction");
					1 < this.repeatCount && "reverse" == this.repeatBehavior && 0 == this.repeatCount % 2 && (this._invertValues = !0);
					this._doReverse && 0 < this.startDelay || (this.calculateValue(this.duration), this.sendUpdateEvent());
					this.sendAnimationEvent("endFunction");
					this.isPlaying ? this.stopAnimation() : e.stopTimerIfDone()
				};
				e.stopTimerIfDone = function() {
					e.timer && 0 == e.activeAnimations.length && 0 == e.delayedStartAnims.length && (e.intervalTime = NaN, e.timer.reset(), e.timer = null)
				};
				c.addToDelayedAnimations = function(b) {
					e.timer || (e.pulse(), e.timer = new d.Timer(e.TIMER_RESOLUTION), e.timer.addEventListener(d.TimerEvent.TIMER, e.timerHandler, e), e.timer.start());
					b = e.currentTime + b;
					for (var a = -1, c = 0; c < e.delayedStartAnims.length; ++c) if (b < e.delayedStartAnims[c].delayedStartTime) {
						a = c;
						break
					}
					0 <= a ? e.delayedStartAnims.splice(a, 0, this) : e.delayedStartAnims.push(this);
					this.delayedStartTime = b
				};
				c.play = function() {
					this.stopAnimation();
					for (var b = 0, a = 0, b = 0; b < this.motionPaths.length; ++b) {
						var c = this.motionPaths[b].keyframes;
						isNaN(c[0].time) ? c[0].time = 0 : 0 < c[0].time && (a = c[0].time, c.splice(0, 0, new f.Keyframe(0, null)), c.splice(1, 0, new f.Keyframe(a - 1, null)), this.playReversed && (c[0].value = c[2].value, c[1].value = c[2].value));
						for (a = 1; a < c.length; ++a) isNaN(c[a].time) && (c[a].time = this.duration)
					}
					for (b = 0; b < this.motionPaths.length; ++b) this.motionPaths[b]._scaleKeyframes(this.duration);
					this._doReverse && (this._invertValues = !0);
					0 < this.startDelay && !this.playReversed ? this.addToDelayedAnimations(this.startDelay) : this.start()
				};
				c.seek = function(b, a) {
					void 0 === a && (a = !1);
					this.startTime = this.cycleStartTime = e.intervalTime - b;
					this._doSeek = !0;
					if (!this._isPlaying || this.playReversed) {
						var c = this._isPlaying;
						e.intervalTime = e.currentTime;
						if (a && 0 < this.startDelay && 0 <= this.delayedStartTime) {
							this.removeFromDelayedAnimations();
							c = b - this.startDelay;
							this.playReversed && (c -= this.duration);
							0 > c ? this.addToDelayedAnimations(this.startDelay - b) : (b -= this.startDelay, this.isPlaying || this.start(), this.startTime = this.cycleStartTime = e.intervalTime - b, this.doInterval(), this._doSeek = !1);
							return
						}
						c || (this.sendAnimationEvent("startFunction"), this.setupInterpolation());
						this.startTime = this.cycleStartTime = e.intervalTime - b
					}
					this.doInterval();
					this._doSeek = !1
				};
				c.setupInterpolation = function() {
					if (this.interpolator && this.motionPaths) for (var b = 0; b < this.motionPaths.length; ++b) this.motionPaths[b].interpolator = this.interpolator
				};
				c.reverse = function() {
					this._isPlaying ? (this._doReverse = !1, this.seek(this.duration - this._cycleTime), this._invertValues = !this._invertValues) : this._doReverse = !this._doReverse
				};
				c.pause = function() {
					0 <= this.delayedStartTime && (this.delayTime = this.delayedStartTime - e.currentTime, this.removeFromDelayedAnimations());
					this._isPlaying = !1
				};
				c.stopAnimation = function() {
					this.removeFromDelayedAnimations();
					0 <= this.id && (e.removeAnimationAt(this.id), this.id = -1, this._isPlaying = this._invertValues = !1)
				};
				c.stop = function() {
					this.stopAnimation();
					this.sendAnimationEvent("stopFunction")
				};
				c.resume = function() {
					this._isPlaying = !0;
					0 <= this.delayTime ? this.addToDelayedAnimations(this.delayTime) : (this.cycleStartTime = e.intervalTime - this._cycleTime, this.startTime = e.intervalTime - this._playheadTime, this._doReverse && (this.reverse(), this._doReverse = !1))
				};
				c.repeat = function(b) {
					this.repeatBehavior == f.RepeatBehavior.REVERSE && (this._invertValues = !this._invertValues);
					this.calculateValue(0);
					this.sendAnimationEvent("repeatFunction");
					this.sendUpdateEvent();
					e.addAnimation(this)
				};
				c.start = function(b) {
					b = 0;
					if (!this.playReversed && 0 <= this.delayedStartTime) {
						var a = e.currentTime - this.delayedStartTime;
						0 < a && (b = Math.min(a, this.duration));
						this.removeFromDelayedAnimations()
					}
					this.sendAnimationEvent("startFunction");
					this.setupInterpolation();
					this.calculateValue(0);
					this.sendUpdateEvent();
					e.addAnimation(this);
					this.startTime = this.cycleStartTime;
					this._isPlaying = !0;
					0 < b && this.seek(b);
					this.started = !0
				};
				e.pulse = function() {
					if (0 > e.startTime) return e.startTime = d.getTimer(), e._currentTime = 0, e._currentTime;
					e._currentTime = d.getTimer() - e.startTime;
					return e._currentTime
				};
				Object.defineProperty(e, "currentTime", {
					get: function() {
						return 0 > e._currentTime ? e.pulse() : e._currentTime
					},
					enumerable: !0,
					configurable: !0
				});
				e.TIMER_RESOLUTION = 1E3 / 60;
				e.defaultEaser = new f.Sine(0.5);
				e.intervalTime = NaN;
				e.activeAnimations = [];
				e.timer = null;
				e.delayedStartAnims = [];
				e.startTime = -1;
				e._currentTime = -1;
				return e
			}();
		f.Animation = g;
		g.prototype.__class__ = "egret.gui.Animation"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					e.call(this);
					this.delayElapsedTime = this.delayStartTime = 0;
					this.durationExplicitlySet = !1;
					this._playCount = 0;
					this._stopRepeat = !1;
					this._duration = 500;
					this._startDelay = this._repeatDelay = this._repeatCount = 0;
					this.target = a
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "_actualDuration", {
					get: function() {
						var a = NaN;
						0 < this.repeatCount && (a = this.duration * this.repeatCount + this.repeatDelay * (this.repeatCount - 1) + this.startDelay);
						return a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "duration", {
					get: function() {
						return !this.durationExplicitlySet && this.parentCompositeEffectInstance ? this.parentCompositeEffectInstance.duration : this._duration
					},
					set: function(a) {
						this.durationExplicitlySet = !0;
						this._duration = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "effect", {
					get: function() {
						return this._effect
					},
					set: function(a) {
						this._effect = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "playheadTime", {
					get: function() {
						return Math.max(this._playCount - 1, 0) * (this.duration + this.repeatDelay) + (this.playReversed ? 0 : this.startDelay)
					},
					set: function(a) {
						this._setPlayheadTime(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayheadTime = function(a) {
					this._delayTimer && this._delayTimer.running && (this._delayTimer.reset(), a < this.startDelay ? (this._delayTimer = new d.Timer(this.startDelay - a, 1), this.delayStartTime = d.getTimer(), this._delayTimer.addEventListener(d.TimerEvent.TIMER, this.delayTimerHandler, this), this._delayTimer.start()) : (this._playCount = 0, this.play()))
				};
				Object.defineProperty(b, "playReversed", {
					get: function() {
						return this._playReversed
					},
					set: function(a) {
						this._setPlayReversed(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayReversed = function(a) {
					this._playReversed = a
				};
				Object.defineProperty(b, "repeatCount", {
					get: function() {
						return this._repeatCount
					},
					set: function(a) {
						this._repeatCount = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "repeatDelay", {
					get: function() {
						return this._repeatDelay
					},
					set: function(a) {
						this._repeatDelay = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "startDelay", {
					get: function() {
						return this._startDelay
					},
					set: function(a) {
						this._startDelay = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "target", {
					get: function() {
						return this._target
					},
					set: function(a) {
						this._target = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.startEffect = function() {
					0 < this.startDelay && !this.playReversed ? (this._delayTimer = new d.Timer(this.startDelay, 1), this.delayStartTime = d.getTimer(), this._delayTimer.addEventListener(d.TimerEvent.TIMER, this.delayTimerHandler, this), this._delayTimer.start()) : this.play()
				};
				b.play = function() {
					this._playCount++;
					this.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_START, !1, !1, this));
					this.target && "dispatchEvent" in this.target && this.target.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_START, !1, !1, this))
				};
				b.pause = function() {
					this._delayTimer && this._delayTimer.running && !isNaN(this.delayStartTime) && (this._delayTimer.stop(), this.delayElapsedTime = d.getTimer() - this.delayStartTime)
				};
				b.stop = function() {
					this._delayTimer && this._delayTimer.reset();
					this._stopRepeat = !0;
					this.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_STOP, !1, !1, this));
					this.target && "dispatchEvent" in this.target && this.target.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_STOP, !1, !1, this));
					this.finishEffect()
				};
				b.resume = function() {
					!this._delayTimer || this._delayTimer.running || isNaN(this.delayElapsedTime) || (this._delayTimer.delay = this.playReversed ? this.delayElapsedTime : this._delayTimer.delay - this.delayElapsedTime, this.delayStartTime = d.getTimer(), this._delayTimer.start())
				};
				b.reverse = function() {
					0 < this.repeatCount && (this._playCount = this.repeatCount - this._playCount + 1)
				};
				b.end = function() {
					this._delayTimer && this._delayTimer.reset();
					this._stopRepeat = !0;
					this.finishEffect()
				};
				b.finishEffect = function() {
					this._playCount = 0;
					this.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_END, !1, !1, this));
					this.target && "dispatchEvent" in this.target && this.target.dispatchEvent(new f.EffectEvent(f.EffectEvent.EFFECT_END, !1, !1, this))
				};
				b.finishRepeat = function() {
					!this._stopRepeat && 0 != this._playCount && (this._playCount < this.repeatCount || 0 == this.repeatCount) ? 0 < this.repeatDelay ? (this._delayTimer = new d.Timer(this.repeatDelay, 1), this.delayStartTime = d.getTimer(), this._delayTimer.addEventListener(d.TimerEvent.TIMER, this.delayTimerHandler, this), this._delayTimer.start()) : this.play() : this.finishEffect()
				};
				b._playWithNoDuration = function() {
					this.duration = 0;
					this.repeatCount = 1;
					this.startDelay = this.repeatDelay = 0;
					this.startEffect()
				};
				b.delayTimerHandler = function(a) {
					this._delayTimer.reset();
					this.delayElapsedTime = this.delayStartTime = NaN;
					this.play()
				};
				return c
			}(d.EventDispatcher);
		f.EffectInstance = g;
		g.prototype.__class__ = "egret.gui.EffectInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e() {}
				e.transformAround = function(c, b, a, h, f, g) {
					void 0 === a && (a = null);
					void 0 === h && (h = NaN);
					void 0 === f && (f = NaN);
					void 0 === g && (g = NaN);
					if (null == a && null != b) {
						d.Point.identity.x = b.x;
						d.Point.identity.y = b.y;
						var s = e.transformPointToParent(c, d.Point.identity)
					}
					isNaN(g) || (c.rotation = g);
					isNaN(h) || (c.scaleX = h);
					isNaN(f) || (c.scaleY = f);
					null == b ? null != a && (c.x = a.x, c.y = a.y) : (d.Point.identity.x = b.x, d.Point.identity.y = b.y, b = e.transformPointToParent(c, d.Point.identity), null != a ? (c.x += a.x - b.x, c.y += a.y - b.y) : (c.x += s.x - b.x, c.y += s.y - b.y))
				};
				e.transformPointToParent = function(c, b) {
					void 0 === b && (b = null);
					var a = new d.Point;
					b && (a.x = b.x, a.y = b.y);
					c.parent && (c.localToGlobal(a.x, a.y, a), c.parent.globalToLocal(a.x, a.y, a));
					return a
				};
				return e
			}();
		f.TransformUtil = g;
		g.prototype.__class__ = "egret.gui.TransformUtil"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					e.call(this, a);
					this._activeEffectQueue = [];
					this._playheadTime = 0;
					this._childSets = []
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "_actualDuration", {
					get: function() {
						var a = NaN;
						0 < this.repeatCount && (a = this._durationWithoutRepeat * this.repeatCount + this.repeatDelay * (this.repeatCount - 1) + this.startDelay);
						return a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "playheadTime", {
					get: function() {
						return this._playheadTime
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayheadTime = function(a) {
					this._timerAnimation ? this._timerAnimation.playheadTime = a : this._playheadTime = a;
					e.prototype._setPlayheadTime.call(this, a)
				};
				Object.defineProperty(b, "_durationWithoutRepeat", {
					get: function() {
						return 0
					},
					enumerable: !0,
					configurable: !0
				});
				b.play = function() {
					this._timerAnimation = new d.Animation(this.animationUpdate, this);
					this._timerAnimation.duration = this._durationWithoutRepeat;
					this._timerAnimation.motionPaths = [new d.SimpleMotionPath("timer", 0, 0)];
					this._timerAnimation.endFunction = this.animationEnd;
					this._timerAnimation.play();
					e.prototype.play.call(this)
				};
				b.pause = function() {
					e.prototype.pause.call(this);
					this._timerAnimation && this._timerAnimation.pause()
				};
				b.stop = function() {
					e.prototype.stop.call(this);
					this._timerAnimation && this._timerAnimation.stop()
				};
				b.end = function() {
					e.prototype.end.call(this);
					this._timerAnimation && this._timerAnimation.end()
				};
				b.resume = function() {
					e.prototype.resume.call(this);
					this._timerAnimation && this._timerAnimation.resume()
				};
				b.reverse = function() {
					e.prototype.reverse.call(this);
					this._setPlayReversed(!this.playReversed);
					this._timerAnimation && this._timerAnimation.reverse()
				};
				b.finishEffect = function() {
					this._activeEffectQueue = null;
					e.prototype.finishEffect.call(this)
				};
				b.addChildSet = function(a) {
					if (a) {
						var b = a.length;
						if (0 < b) {
							this._childSets ? this._childSets.push(a) : this._childSets = [a];
							for (var c = 0; c < b; c++) a[c].addEventListener(d.EffectEvent.EFFECT_END, this._effectEndHandler, this), a[c].parentCompositeEffectInstance = this
						}
					}
				};
				b._playWithNoDuration = function() {
					e.prototype._playWithNoDuration.call(this);
					this.end()
				};
				b.animationUpdate = function(a) {
					this._playheadTime = this._timerAnimation ? this._timerAnimation.playheadTime : this._playheadTime
				};
				b.animationEnd = function(a) {
					this._playheadTime = this._timerAnimation ? this._timerAnimation.playheadTime : this._playheadTime
				};
				b._onEffectEnd = function(a) {};
				b._effectEndHandler = function(a) {
					this._onEffectEnd(a.effectInstance)
				};
				return c
			}(d.EffectInstance);
		d.CompositeEffectInstance = g;
		g.prototype.__class__ = "egret.gui.CompositeEffectInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					e.call(this, a);
					this.isReversed = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "_durationWithoutRepeat", {
					get: function() {
						for (var a = 0, b = this._childSets.length, c = 0; c < b; c++) a = Math.max(this._childSets[c][0]._actualDuration, a);
						return a
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayheadTime = function(a) {
					this._setPlayheadTime(a);
					var b = this.effect.compositeDuration,
						c = b + this.startDelay + this.repeatDelay,
						e = b + this.repeatDelay,
						d = c + e * (this.repeatCount - 1);
					a <= c ? (a = Math.min(a - this.startDelay, b), this._playCount = 1) : a >= d && 0 != this.repeatCount ? (a = b, this._playCount = this.repeatCount) : (b = a - c, a = b % e, this._playCount = 1 + b / e);
					for (e = 0; e < this._childSets.length; e++) for (b = this._childSets[e], c = b.length, d = 0; d < c; d++) b[d].playheadTime = this.playReversed ? Math.max(0, a - (this._durationWithoutRepeat - b[d]._actualDuration)) : a;
					if (this.playReversed && null != this.replayEffectQueue && 0 < this.replayEffectQueue.length) for (a = this._durationWithoutRepeat - this.playheadTime, e = this.replayEffectQueue.length - 1; 0 <= e; e--) b = this.replayEffectQueue[e], a <= b._actualDuration && (null == this._activeEffectQueue && (this._activeEffectQueue = []), this._activeEffectQueue.push(b), this.replayEffectQueue.splice(e, 1), b.playReversed = this.playReversed, b.startEffect())
				};
				b.play = function() {
					this.doneEffectQueue = [];
					this._activeEffectQueue = [];
					this.replayEffectQueue = [];
					e.prototype.play.call(this);
					for (var a = 0, b = 0, a = this._childSets.length, b = 0; b < a; b++) for (var c = this._childSets[b], d = c.length, f = 0; f < d && null != this._activeEffectQueue; f++) {
						var g = c[f];
						this.playReversed && g._actualDuration < this._durationWithoutRepeat ? (this.replayEffectQueue.push(g), this.startTimer()) : (g.playReversed = this.playReversed, this._activeEffectQueue.push(g))
					}
					if (0 < this._activeEffectQueue.length) for (a = this._activeEffectQueue.slice(0), b = 0; b < a.length; b++) a[b].startEffect()
				};
				b.pause = function() {
					e.prototype.pause.call(this);
					if (this._activeEffectQueue) for (var a = this._activeEffectQueue.length, b = 0; b < a; b++) this._activeEffectQueue[b].pause()
				};
				b.stop = function() {
					this.stopTimer();
					if (this._activeEffectQueue) {
						var a = this._activeEffectQueue.concat();
						this._activeEffectQueue = null;
						for (var b = a.length, c = 0; c < b; c++) a[c] && a[c].stop()
					}
					e.prototype.stop.call(this)
				};
				b.resume = function() {
					e.prototype.resume.call(this);
					if (this._activeEffectQueue) for (var a = this._activeEffectQueue.length, b = 0; b < a; b++) this._activeEffectQueue[b].resume()
				};
				b.reverse = function() {
					e.prototype.reverse.call(this);
					var a = 0,
						b = 0;
					if (this.isReversed) {
						a = this._activeEffectQueue.length;
						for (b = 0; b < a; b++) this._activeEffectQueue[b].reverse();
						this.stopTimer()
					} else {
						this.replayEffectQueue = this.doneEffectQueue.splice(0);
						a = this._activeEffectQueue.length;
						for (b = 0; b < a; b++) this._activeEffectQueue[b].reverse();
						this.startTimer()
					}
					this.isReversed = !this.isReversed
				};
				b.end = function() {
					this._endEffectCalled = !0;
					this.stopTimer();
					if (this._activeEffectQueue) {
						var a = this._activeEffectQueue.concat();
						this._activeEffectQueue = null;
						for (var b = a.length, c = 0; c < b; c++) a[c] && a[c].end()
					}
					e.prototype.end.call(this)
				};
				b._onEffectEnd = function(a) {
					if (!this._endEffectCalled && null != this._activeEffectQueue) {
						for (var b = this._activeEffectQueue.length, c = 0; c < b; c++) if (a == this._activeEffectQueue[c]) {
							this.doneEffectQueue.push(a);
							this._activeEffectQueue.splice(c, 1);
							break
						}
						1 == b && this.finishRepeat()
					}
				};
				b.startTimer = function() {
					this.timer || (this.timer = new d.Timer(10), this.timer.addEventListener(d.TimerEvent.TIMER, this.timerHandler, this));
					this.timer.start()
				};
				b.stopTimer = function() {
					this.timer && this.timer.reset()
				};
				b.timerHandler = function(a) {
					a = this._durationWithoutRepeat - this.playheadTime;
					var b = this.replayEffectQueue.length;
					if (0 == b) this.stopTimer();
					else for (b -= 1; 0 <= b; b--) {
						var c = this.replayEffectQueue[b];
						a <= c._actualDuration && (null == this._activeEffectQueue && (this._activeEffectQueue = []), this._activeEffectQueue.push(c), this.replayEffectQueue.splice(b, 1), c.playReversed = this.playReversed, c.startEffect())
					}
				};
				return c
			}(f.CompositeEffectInstance);
		f.ParallelInstance = g;
		g.prototype.__class__ = "egret.gui.ParallelInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					e.call(this, a);
					this.currentInstanceDuration = 0;
					this.currentSetIndex = -1;
					this.isPaused = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "_durationWithoutRepeat", {
					get: function() {
						for (var a = 0, b = this._childSets.length, c = 0; c < b; c++) a += this._childSets[c][0]._actualDuration;
						return a
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayheadTime = function(a) {
					this._setPlayheadTime(a);
					var b, c;
					b = 0;
					var e = this.effect.compositeDuration;
					b = e + this.startDelay + this.repeatDelay;
					var d = e + this.repeatDelay;
					c = b + d * (this.repeatCount - 1);
					a <= b ? (a = Math.min(a - this.startDelay, e), this._playCount = 1) : a >= c && 0 != this.repeatCount ? (a = e, this._playCount = this.repeatCount) : (b = a - b, a = Math.min(b % d, e), this._playCount = 1 + b / d);
					if (this._activeEffectQueue && 0 < this._activeEffectQueue.length) {
						c = 0;
						var f = this._activeEffectQueue.length;
						for (b = 0; b < f; ++b) {
							var d = this.playReversed ? f - 1 - b : b,
								e = c,
								g = c + this._childSets[d][0]._actualDuration;
							c = g;
							if (e <= a && a <= g) {
								this._endEffectCalled = !0;
								if (this.currentSetIndex == d) for (b = 0; b < this.currentSet.length; b++) this.currentSet[b].playheadTime = a - e;
								else {
									if (d < this.currentSetIndex) if (this.playReversed) {
										for (b = 0; b < this.currentSet.length; b++) this.currentSet[b].end();
										for (b = this.currentSetIndex - 1; b > d; --b) for (f = this._activeEffectQueue[b], c = 0; c < f.length; c++) this.playReversed && (f[c].playReversed = !0), f[c].play(), f[c].end()
									} else {
										for (b = 0; b < this.currentSet.length; b++) this.currentSet[b].playheadTime = 0, this.currentSet[b].stop();
										for (b = this.currentSetIndex - 1; b > d; --b) for (f = this._activeEffectQueue[b], c = 0; c < f.length; c++) f[c].play(), f[c].stop()
									} else if (this.playReversed) {
										for (b = 0; b < this.currentSet.length; b++) this.currentSet[b].playheadTime = 0, this.currentSet[b].stop();
										for (c = this.currentSetIndex + 1; c < d; c++) for (f = this._activeEffectQueue[c], b = 0; b < f.length; b++) f[b].playheadTime = 0, f[b].stop()
									} else {
										c = this.currentSet.concat();
										for (b = 0; b < c.length; b++) c[b].end();
										for (c = this.currentSetIndex + 1; c < d; c++) for (f = this._activeEffectQueue[c], b = 0; b < f.length; b++) f[b].play(), f[b].end()
									}
									this.currentSetIndex = d;
									this.playCurrentChildSet();
									for (c = 0; c < this.currentSet.length; c++) this.currentSet[c].playheadTime = a - e, this.isPaused && this.currentSet[c].pause()
								}
								this._endEffectCalled = !1;
								break
							}
						}
					}
				};
				b.play = function() {
					this.isPaused = !1;
					this._activeEffectQueue = [];
					this.currentSetIndex = this.playReversed ? this._childSets.length : -1;
					for (var a = 0, b = 0, a = this._childSets.length, b = 0; b < a; b++) this._activeEffectQueue.push(this._childSets[b]);
					e.prototype.play.call(this);
					0 == this._activeEffectQueue.length ? this.finishRepeat() : this.playNextChildSet()
				};
				b.pause = function() {
					e.prototype.pause.call(this);
					this.isPaused = !0;
					if (this.currentSet && 0 < this.currentSet.length) for (var a = this.currentSet.length, b = 0; b < a; b++) this.currentSet[b].pause()
				};
				b.stop = function() {
					this.isPaused = !1;
					if (this._activeEffectQueue && 0 < this._activeEffectQueue.length) {
						var a = this._activeEffectQueue.concat();
						this._activeEffectQueue = null;
						var b = a[this.currentSetIndex];
						if (b) for (var c = b.length, d = 0; d < c; d++) b[d].stop();
						b = a.length;
						for (c = this.currentSetIndex + 1; c < b; c++) for (var d = a[c], f = d.length, g = 0; g < f; g++) {
							var k = d[g];
							k.effect.deleteInstance(k)
						}
					}
					e.prototype.stop.call(this)
				};
				b.resume = function() {
					e.prototype.resume.call(this);
					this.isPaused = !1;
					if (this.currentSet && 0 < this.currentSet.length) for (var a = this.currentSet.length, b = 0; b < a; b++) this.currentSet[b].resume()
				};
				b.reverse = function() {
					e.prototype.reverse.call(this);
					if (this.currentSet && 0 < this.currentSet.length) for (var a = this.currentSet.length, b = 0; b < a; b++) this.currentSet[b].reverse()
				};
				b.end = function() {
					this._endEffectCalled = !0;
					if (this._activeEffectQueue && 0 < this._activeEffectQueue.length) {
						var a = this._activeEffectQueue.concat();
						this._activeEffectQueue = null;
						var b = a[this.currentSetIndex];
						if (b) for (var c = b.length, d = 0; d < c; d++) b[d].end();
						b = a.length;
						for (c = this.currentSetIndex + 1; c < b; c++) for (var d = a[c], f = d.length, g = 0; g < f; g++) d[g]._playWithNoDuration()
					}
					this.isPaused = !1;
					e.prototype.end.call(this)
				};
				b._onEffectEnd = function(a) {
					for (var b = 0; b < this.currentSet.length; b++) if (a == this.currentSet[b]) {
						this.currentSet.splice(b, 1);
						break
					}
					this._endEffectCalled || 0 == this.currentSet.length && !1 == this.playNextChildSet() && this.finishRepeat()
				};
				b.playCurrentChildSet = function() {
					var a, b = this._activeEffectQueue[this.currentSetIndex];
					this.currentSet = [];
					for (var c = 0; c < b.length; c++) a = b[c], this.currentSet.push(a), a.playReversed = this.playReversed, a.startEffect();
					this.currentInstanceDuration += a._actualDuration
				};
				b.playNextChildSet = function(a) {
					if (!this.playReversed) {
						if (!this._activeEffectQueue || this.currentSetIndex++ >= this._activeEffectQueue.length - 1) return !1
					} else if (0 >= this.currentSetIndex--) return !1;
					this.playCurrentChildSet();
					return !0
				};
				return c
			}(d.CompositeEffectInstance);
		d.SequenceInstance = g;
		g.prototype.__class__ = "egret.gui.SequenceInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					e.call(this, a);
					this.isStyleMap = {};
					this.numUpdateListeners = this._seekTime = 0
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "motionPaths", {
					get: function() {
						return this._motionPaths
					},
					set: function(a) {
						this._motionPaths || (this._motionPaths = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "easer", {
					get: function() {
						return this._easer
					},
					set: function(a) {
						this._easer = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "interpolator", {
					get: function() {
						return this._interpolator
					},
					set: function(a) {
						this._interpolator = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "repeatBehavior", {
					get: function() {
						return this._repeatBehavior
					},
					set: function(a) {
						this._repeatBehavior = a
					},
					enumerable: !0,
					configurable: !0
				});
				b._setPlayReversed = function(a) {
					e.prototype._setPlayReversed.call(this, a);
					a && this.animation && this.animation.reverse();
					this.reverseAnimation = a
				};
				Object.defineProperty(b, "playheadTime", {
					get: function() {
						return this.animation ? this.animation.playheadTime : this._seekTime
					},
					set: function(a) {
						this.animation && (this.animation.playheadTime = a);
						this._seekTime = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.pause = function() {
					e.prototype.pause.call(this);
					this.animation && this.animation.pause()
				};
				b.stop = function() {
					e.prototype.stop.call(this);
					this.animation && this.animation.stop()
				};
				b.resume = function() {
					e.prototype.resume.call(this);
					this.animation && this.animation.resume()
				};
				b.reverse = function() {
					e.prototype.reverse.call(this);
					this.animation && this.animation.reverse();
					this.reverseAnimation = !this.reverseAnimation
				};
				b.end = function() {
					this.animation && (this.animation.end(), this.animation = null);
					e.prototype.end.call(this)
				};
				b.startEffect = function() {
					this.play()
				};
				b.play = function() {
					e.prototype.play.call(this);
					if (this.motionPaths && 0 != this.motionPaths.length) {
						this.isStyleMap = Array(this.motionPaths.length);
						for (var a = 0, b = 0, a = 0; a < this.motionPaths.length; ++a) {
							var b = this.motionPaths[a],
								c = b.keyframes;
							if (c && (this.interpolator && (b.interpolator = this.interpolator), 0 < this.duration)) for (b = 0; b < c.length; ++b) isNaN(c[b].time) || (this.duration = Math.max(this.duration, c[b].time))
						}
						this.animation = new f.Animation(this.animationUpdate, this);
						this.animation.duration = this.duration;
						this.animation.startFunction = this.animationStart;
						this.animation.endFunction = this.animationEnd;
						this.animation.stopFunction = this.animationStop;
						this.animation.repeatFunction = this.animationRepeat;
						this.animation.motionPaths = this.motionPaths;
						this.reverseAnimation && (this.animation.playReversed = !0);
						this.animation.interpolator = this.interpolator;
						this.animation.repeatCount = this.repeatCount;
						this.animation.repeatDelay = this.repeatDelay;
						this.animation.repeatBehavior = this.repeatBehavior;
						this.animation.easer = this.easer;
						this.animation.startDelay = this.startDelay;
						this.animation.play();
						0 < this._seekTime && (this.animation.playheadTime = this._seekTime)
					} else a = new d.Timer(this.duration, 1), a.addEventListener(d.TimerEvent.TIMER, this.noopAnimationHandler, this), a.start()
				};
				b.applyValues = function(a) {
					for (var b = 0; b < this.motionPaths.length; ++b) {
						var c = this.motionPaths[b].property;
						this.setValue(c, a.currentValue[c])
					}
				};
				b._isValidValue = function(a) {
					return "number" == typeof a && !isNaN(a) || "number" != typeof a && null !== a
				};
				b.finalizeValues = function() {
					for (var a = 0, b, c = 0; c < this.motionPaths.length; ++c) {
						var e = this.motionPaths[c],
							d = e.keyframes;
						if (d && 0 != d.length) for (this._isValidValue(d[0].value) || (0 < d.length && this._isValidValue(d[1].valueBy) && this._isValidValue(d[1].value) ? d[0].value = e.interpolator.decrement(d[1].value, d[1].valueBy) : d[0].value = this.getCurrentValue(e.property)), b = d[0].value, a = 1; a < d.length; ++a) {
							var f = d[a];
							this._isValidValue(f.value) || (this._isValidValue(f.valueBy) ? f.value = e.interpolator.increment(b, f.valueBy) : a <= d.length - 2 && this._isValidValue(d[a + 1].value) && this._isValidValue(d[a + 1].valueBy) ? f.value = e.interpolator.decrement(d[a + 1].value, d[a + 1].valueBy) : f.value = b);
							b = f.value
						}
					}
				};
				b.animationStart = function(a) {
					if (this.disableLayout) this.cacheConstraints();
					else if (this.disabledConstraintsMap) {
						for (var b in this.disabledConstraintsMap) this.cacheConstraint(b);
						this.disabledConstraintsMap = null
					}
					this.finalizeValues()
				};
				b.animationUpdate = function(a) {
					this.applyValues(a);
					0 < this.numUpdateListeners && (a = new f.EffectEvent(f.EffectEvent.EFFECT_UPDATE), a.effectInstance = this, this.dispatchEvent(a))
				};
				b.animationRepeat = function(a) {
					a = new f.EffectEvent(f.EffectEvent.EFFECT_REPEAT);
					a.effectInstance = this;
					this.dispatchEvent(a)
				};
				b.animationCleanup = function() {
					this.disableLayout && this.reenableConstraints()
				};
				b.animationEnd = function(a) {
					this.animationCleanup();
					this.finishEffect()
				};
				b.animationStop = function(a) {
					this.animationCleanup()
				};
				b.noopAnimationHandler = function(a) {
					this.finishEffect()
				};
				b.addEventListener = function(a, b, c, d, g) {
					void 0 === d && (d = !1);
					void 0 === g && (g = 0);
					e.prototype.addEventListener.call(this, a, b, c, d, g);
					a == f.EffectEvent.EFFECT_UPDATE && ++this.numUpdateListeners
				};
				b.removeEventListener = function(a, b, c) {
					void 0 === c && (c = !1);
					e.prototype.removeEventListener.call(this, a, b, this, c);
					a == f.EffectEvent.EFFECT_UPDATE && --this.numUpdateListeners
				};
				b.reenableConstraint = function(a) {
					var b = this.constraintsHolder[a];
					void 0 !== b && (a in this.target ? this.target[a] = b : this.target.setStyle(a, b), delete this.constraintsHolder[a]);
					return b
				};
				b.reenableConstraints = function() {
					if (this.constraintsHolder) {
						var a = this.reenableConstraint("left"),
							b = this.reenableConstraint("right"),
							c = this.reenableConstraint("top"),
							e = this.reenableConstraint("bottom");
						this.reenableConstraint("horizontalCenter");
						this.reenableConstraint("verticalCenter");
						this.constraintsHolder = null;
						void 0 != a && void 0 != b && "explicitWidth" in this.target && (this.target.width = this.oldWidth);
						void 0 != c && void 0 != e && "explicitHeight" in this.target && (this.target.height = this.oldHeight)
					}
				};
				b.cacheConstraint = function(a) {
					var b = a in this.target,
						c;
					c = b ? this.target[a] : this.target.getStyle(a);
					isNaN(c) || null == c || (this.constraintsHolder || (this.constraintsHolder = {}), this.constraintsHolder[a] = c, b ? this.target[a] = NaN : "setStyle" in this.target && this.target.setStyle(a, void 0));
					return c
				};
				b.cacheConstraints = function() {
					var a = this.cacheConstraint("left"),
						b = this.cacheConstraint("right"),
						c = this.cacheConstraint("top"),
						e = this.cacheConstraint("bottom");
					this.cacheConstraint("verticalCenter");
					this.cacheConstraint("horizontalCenter");
					void 0 != a && void 0 != b && "explicitWidth" in this.target && (a = this.target.width, this.oldWidth = this.target.explicitWidth, this.target.width = a);
					void 0 != c && void 0 != e && "explicitHeight" in this.target && (c = this.target.height, this.oldHeight = this.target.explicitHeight, this.target.height = c)
				};
				b._setupStyleMapEntry = function(a) {
					if (void 0 == this.isStyleMap[a]) if (a in this.target) this.isStyleMap[a] = !1;
					else try {
						this.target.getStyle(a), this.isStyleMap[a] = !0
					} catch (b) {
						throw Error("propNotPropOrStyle");
					}
				};
				b.setValue = function(a, b) {
					this._setupStyleMapEntry(a);
					this.isStyleMap[a] ? this.target.setStyle(a, b) : this.target[a] = b
				};
				b.getCurrentValue = function(a) {
					this._setupStyleMapEntry(a);
					return this.isStyleMap[a] ? this.target.getStyle(a) : this.target[a]
				};
				return c
			}(f.EffectInstance);
		f.AnimateInstance = g;
		g.prototype.__class__ = "egret.gui.AnimateInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					e.call(this, a);
					this.started = !1;
					this.instanceStartTime = 0;
					this.currentValues = {
						rotation: NaN,
						scaleX: NaN,
						scaleY: NaN,
						translationX: NaN,
						translationY: NaN
					};
					this.initialized = !1
				}
				__extends(c, e);
				var b = c.prototype;
				b.startEffect = function() {
					this.started || (this.started = !0, e.prototype.startEffect.call(this))
				};
				b.insertKeyframe = function(a, b, c, e) {
					void 0 === c && (c = 0);
					void 0 === e && (e = !1);
					b.time += c;
					for (c = 0; c < a.length; c++) if (a[c].time >= b.time) {
						a[c].time == b.time ? e ? (b.time += 0.01, a.splice(c + 1, 0, b)) : (b.time -= 0.01, a.splice(c, 0, b)) : a.splice(c, 0, b);
						return
					}
					a.push(b)
				};
				b.addMotionPath = function(a, b) {
					void 0 === b && (b = 0);
					var c = !1;
					if (this.motionPaths) {
						var e = 0,
							d = 0,
							f, g = this.motionPaths.length;
						if (b < this.instanceStartTime) {
							for (var l = this.instanceStartTime - b, e = 0; e < g; e++) for (f = this.motionPaths[e], d = 0; d < f.keyframes.length; d++) f.keyframes[d].time += l;
							this.instanceStartTime = b
						}
						for (e = 0; e < g; e++) if (f = this.motionPaths[e], f.property == a.property) {
							for (d = 0; d < a.keyframes.length; d++) this.insertKeyframe(f.keyframes, a.keyframes[d], b - this.instanceStartTime, 0 == d);
							c = !0;
							break
						}
					} else this.motionPaths = [], this.instanceStartTime = b;
					if (!c) {
						if (b > this.instanceStartTime) for (d = 0; d < a.keyframes.length; d++) a.keyframes[d].time += b - this.instanceStartTime;
						this.motionPaths.push(a)
					}
					g = this.motionPaths.length;
					for (e = 0; e < g; e++) f = this.motionPaths[e], c = f.keyframes[f.keyframes.length - 1], isNaN(c.time) || (this.duration = Math.max(this.duration, c.time))
				};
				b.play = function() {
					if (this.motionPaths) {
						var a = 0,
							b = 0;
						this.updateTransformCenter();
						for (var c = 0 != this.transformCenter.x || 0 != this.transformCenter.y, a = 0; a < this.motionPaths.length; ++a) {
							var d = this.motionPaths[a];
							if (c && ("translationX" == d.property || "translationY" == d.property)) for (b = 0; b < d.keyframes.length; ++b) {
								var f = d.keyframes[b];
								this._isValidValue(f.value) && (f.value = "translationX" == d.property ? f.value + this.transformCenter.x : f.value + this.transformCenter.y)
							}
						}
					}
					e.prototype.play.call(this)
				};
				b.animationEnd = function(a) {
					this.started = !1;
					e.prototype.animationEnd.call(this, a)
				};
				b.updateTransformCenter = function() {
					this.transformCenter || (this.transformCenter = new d.Point(0, 0));
					this.autoCenterTransform && (this.transformCenter.x = this.target.width / 2, this.transformCenter.y = this.target.height / 2)
				};
				b.getCurrentValue = function(a) {
					switch (a) {
					case "translationX":
					case "translationY":
						this.updateTransformCenter();
						var b = f.TransformUtil.transformPointToParent(this.target, this.transformCenter);
						if ("translationX" == a) return b.x;
						if ("translationY" == a) return b.y;
						break;
					default:
						return e.prototype.getCurrentValue.call(this, a)
					}
				};
				b.applyValues = function(a) {
					var b, e;
					for (b = 0; b < this.motionPaths.length; ++b) void 0 !== this.currentValues[this.motionPaths[b].property] ? this.currentValues[this.motionPaths[b].property] = a.currentValue[this.motionPaths[b].property] : this.setValue(this.motionPaths[b].property, a.currentValue[this.motionPaths[b].property]);
					e = isNaN(this.currentValues.rotation) ? this.getCurrentValue("rotation") : this.currentValues.rotation;
					a = isNaN(this.currentValues.scaleX) ? this.getCurrentValue("scaleX") : this.currentValues.scaleX;
					b = isNaN(this.currentValues.scaleY) ? this.getCurrentValue("scaleY") : this.currentValues.scaleY;
					c.position.x = isNaN(this.currentValues.translationX) ? this.getCurrentValue("translationX") : this.currentValues.translationX;
					c.position.y = isNaN(this.currentValues.translationY) ? this.getCurrentValue("translationY") : this.currentValues.translationY;
					this.lastTranslationPoint || (this.lastTranslationPoint = c.position.clone());
					isNaN(this.currentValues.translationX) && 0.1 > Math.abs(c.position.x - this.lastTranslationPoint.x) && (c.position.x = this.lastTranslationPoint.x);
					isNaN(this.currentValues.translationY) && 0.1 > Math.abs(c.position.y - this.lastTranslationPoint.y) && (c.position.y = this.lastTranslationPoint.y);
					this.lastTranslationPoint.x = c.position.x;
					this.lastTranslationPoint.y = c.position.y;
					f.TransformUtil.transformAround(this.target, this.transformCenter, c.position, a, b, e)
				};
				c.position = new d.Point;
				return c
			}(f.AnimateInstance);
		f.AnimateTransformInstance = g;
		g.prototype.__class__ = "egret.gui.AnimateTransformInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(b) {
					e.call(this, b)
				}
				__extends(c, e);
				c.prototype.play = function() {
					var b = this.alphaFrom,
						a = this.alphaTo;
					"visible" in this.target && !this.target.visible && (isNaN(b) && (b = this.target.alpha), isNaN(a) && (a = this.target.alpha), 0 == b && 0 != a && (this.target.alpha = 0, this.target.visible = !0));
					this.motionPaths = [new d.MotionPath("alpha")];
					this.motionPaths[0].keyframes = [new d.Keyframe(0, this.alphaFrom), new d.Keyframe(this.duration, this.alphaTo)];
					e.prototype.play.call(this)
				};
				return c
			}(d.AnimateInstance);
		d.FadeInstance = g;
		g.prototype.__class__ = "egret.gui.FadeInstance"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this);
					this._instances = [];
					this._isPaused = !1;
					this._duration = 500;
					this.durationExplicitlySet = !1;
					this._perElementOffset = 0;
					this.repeatCount = 1;
					this.startDelay = this.repeatDelay = 0;
					this._targets = [];
					this._playheadTime = 0;
					this.target = a
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "duration", {
					get: function() {
						return !this.durationExplicitlySet && this._parentCompositeEffect ? this._parentCompositeEffect.duration : this._duration
					},
					set: function(a) {
						this.durationExplicitlySet = !0;
						this._duration = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "isPlaying", {
					get: function() {
						return this._instances && 0 < this._instances.length
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "isPaused", {
					get: function() {
						return this.isPlaying ? this._isPaused : !1
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "perElementOffset", {
					get: function() {
						return this._perElementOffset
					},
					set: function(a) {
						this._perElementOffset = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "target", {
					get: function() {
						return 0 < this._targets.length ? this._targets[0] : null
					},
					set: function(a) {
						this._targets.splice(0);
						a && (this._targets[0] = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "targets", {
					get: function() {
						return this._targets
					},
					set: function(a) {
						for (var b = a.length - 1; 0 <= b; b--) null == a[b] && a.splice(b, 1);
						this._targets = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "playheadTime", {
					get: function() {
						for (var a = 0; a < this._instances.length; a++) if (this._instances[a]) return this._instances[a].playheadTime;
						return this._playheadTime
					},
					set: function(a) {
						var b = !1;
						0 == this._instances.length && (this.play(), b = !0);
						for (var c = 0; c < this._instances.length; c++) this._instances[c] && (this._instances[c].playheadTime = a);
						b && this.pause();
						this._playheadTime = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.createInstances = function(a) {
					void 0 === a && (a = null);
					a || (a = this.targets);
					for (var b = [], c = 0, e = a.length, d = 0; d < e; d++) {
						var f = this.createInstance(a[d]);
						f && (f.startDelay += c, c += this.perElementOffset, b.push(f))
					}
					return b
				};
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					a || (a = this.target);
					a = new this.instanceClass(a);
					this._initInstance(a);
					a.addEventListener(f.EffectEvent.EFFECT_START, this._effectStartHandler, this);
					a.addEventListener(f.EffectEvent.EFFECT_STOP, this._effectStopHandler, this);
					a.addEventListener(f.EffectEvent.EFFECT_END, this._effectEndHandler, this);
					this._instances.push(a);
					return a
				};
				b._initInstance = function(a) {
					a.duration = this.duration;
					a.durationExplicitlySet = this.durationExplicitlySet;
					a.effect = this;
					a.repeatCount = this.repeatCount;
					a.repeatDelay = this.repeatDelay;
					a.startDelay = this.startDelay
				};
				b.deleteInstance = function(a) {
					a.removeEventListener(f.EffectEvent.EFFECT_START, this._effectStartHandler, this);
					a.removeEventListener(f.EffectEvent.EFFECT_STOP, this._effectStopHandler, this);
					a.removeEventListener(f.EffectEvent.EFFECT_END, this._effectEndHandler, this);
					for (var b = this._instances.length, c = 0; c < b; c++) this._instances[c] === a && this._instances.splice(c, 1)
				};
				b.play = function(a, b) {
					void 0 === a && (a = null);
					void 0 === b && (b = !1);
					this._isPaused = this.effectStopped = !1;
					this.playReversed = b;
					for (var c = this.createInstances(a), e = c.length, d = 0; d < e; d++) {
						var f = c[d];
						f.playReversed = b;
						f.startEffect()
					}
					return c
				};
				b.pause = function() {
					if (this.isPlaying && !this._isPaused) {
						this._isPaused = !0;
						for (var a = this._instances.length, b = 0; b < a; b++) this._instances[b].pause()
					}
				};
				b.stop = function() {
					for (var a = this._instances.length - 1; 0 <= a; a--) {
						var b = this._instances[a];
						b && b.stop()
					}
				};
				b.resume = function() {
					if (this.isPlaying && this._isPaused) {
						this._isPaused = !1;
						for (var a = this._instances.length, b = 0; b < a; b++) this._instances[b].resume()
					}
				};
				b.reverse = function() {
					if (this.isPlaying) for (var a = this._instances.length, b = 0; b < a; b++) this._instances[b].reverse()
				};
				b.end = function(a) {
					void 0 === a && (a = null);
					if (a) a.end();
					else for (a = this._instances.length - 1; 0 <= a; a--) {
						var b = this._instances[a];
						b && b.end()
					}
				};
				b._effectStartHandler = function(a) {
					this.dispatchEvent(a)
				};
				b._effectStopHandler = function(a) {
					this.dispatchEvent(a);
					this.effectStopped = !0
				};
				b._effectEndHandler = function(a) {
					this.deleteInstance(a.effectInstance);
					this.dispatchEvent(a)
				};
				return c
			}(d.EventDispatcher);
		f.Effect = g;
		g.prototype.__class__ = "egret.gui.Effect"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this._children = [];
					this.instanceClass = d.CompositeEffectInstance
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "children", {
					get: function() {
						return this._children
					},
					set: function(a) {
						var b = 0;
						if (this._children) for (b = 0; b < this._children.length; ++b) this._children[b] && (this._children[b]._parentCompositeEffect = null);
						if (this._children = a) for (b = 0; b < this._children.length; ++b) this._children[b] && (this._children[b]._parentCompositeEffect = this)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "compositeDuration", {
					get: function() {
						return this.duration
					},
					enumerable: !0,
					configurable: !0
				});
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					this.childTargets || (this.childTargets = [a]);
					a = e.prototype.createInstance.call(this, a);
					this.childTargets = null;
					return a
				};
				b.createInstances = function(a) {
					void 0 === a && (a = null);
					a || (a = this.targets);
					this.childTargets = a;
					a = this.createInstance();
					this.childTargets = null;
					return a ? [a] : []
				};
				b._initInstance = function(a) {
					e.prototype._initInstance.call(this, a);
					var b = this.childTargets;
					b instanceof Array || (b = [b]);
					if (this.children) for (var c = this.children.length, d = 0; d < c; d++) {
						var f = this.children[d];
						0 == f.targets.length ? a.addChildSet(this.children[d].createInstances(b)) : a.addChildSet(this.children[d].createInstances(f.targets))
					}
				};
				b.addChild = function(a) {
					this.children.push(a);
					a._parentCompositeEffect = this
				};
				return c
			}(d.Effect);
		d.CompositeEffect = g;
		g.prototype.__class__ = "egret.gui.CompositeEffect"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(b) {
					void 0 === b && (b = null);
					e.call(this, b);
					this.instanceClass = d.ParallelInstance
				}
				__extends(c, e);
				Object.defineProperty(c.prototype, "compositeDuration", {
					get: function() {
						for (var b = 0, a = 0; a < this.children.length; ++a) {
							var c, e = this.children[a];
							c = e instanceof d.CompositeEffect ? e.compositeDuration : e.duration;
							c = c * e.repeatCount + e.repeatDelay * (e.repeatCount - 1) + e.startDelay;
							b = Math.max(b, c)
						}
						return b
					},
					enumerable: !0,
					configurable: !0
				});
				return c
			}(d.CompositeEffect);
		d.Parallel = g;
		g.prototype.__class__ = "egret.gui.Parallel"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(b) {
					void 0 === b && (b = null);
					e.call(this, b);
					this.instanceClass = d.SequenceInstance
				}
				__extends(c, e);
				Object.defineProperty(c.prototype, "compositeDuration", {
					get: function() {
						for (var b = 0, a = 0; a < this.children.length; ++a) {
							var c, e = this.children[a];
							c = e instanceof d.CompositeEffect ? e.compositeDuration : e.duration;
							c = c * e.repeatCount + e.repeatDelay * (e.repeatCount - 1) + e.startDelay;
							b += c
						}
						return b
					},
					enumerable: !0,
					configurable: !0
				});
				return c
			}(d.CompositeEffect);
		d.Sequence = g;
		g.prototype.__class__ = "egret.gui.Sequence"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this.numUpdateListeners = 0;
					this._interpolator = null;
					this._repeatBehavior = d.RepeatBehavior.LOOP;
					this._disableLayout = !1;
					this.instanceClass = d.AnimateInstance
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "motionPaths", {
					get: function() {
						return this._motionPaths
					},
					set: function(a) {
						this._motionPaths = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "easer", {
					get: function() {
						return this._easer
					},
					set: function(a) {
						this._easer = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "interpolator", {
					get: function() {
						return this._interpolator
					},
					set: function(a) {
						this._interpolator = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "repeatBehavior", {
					get: function() {
						return this._repeatBehavior
					},
					set: function(a) {
						this._repeatBehavior = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "disableLayout", {
					get: function() {
						return this._disableLayout
					},
					set: function(a) {
						this._disableLayout = a
					},
					enumerable: !0,
					configurable: !0
				});
				b._initInstance = function(a) {
					e.prototype._initInstance.call(this, a);
					a.addEventListener(d.EffectEvent.EFFECT_REPEAT, this.animationEventHandler, this);
					0 < this.numUpdateListeners && a.addEventListener(d.EffectEvent.EFFECT_UPDATE, this.animationEventHandler, this);
					a.easer = this.easer;
					this.interpolator && (a.interpolator = this.interpolator);
					isNaN(this.repeatCount) && (a.repeatCount = this.repeatCount);
					a.repeatBehavior = this.repeatBehavior;
					a.disableLayout = this.disableLayout;
					if (this.motionPaths) {
						a.motionPaths = [];
						for (var b = 0; b < this.motionPaths.length; ++b) a.motionPaths[b] = this.motionPaths[b].clone()
					}
				};
				b.addEventListener = function(a, b, c, g, s) {
					void 0 === g && (g = !1);
					void 0 === s && (s = 0);
					e.prototype.addEventListener.call(this, a, b, c, g, s);
					a == d.EffectEvent.EFFECT_UPDATE && ++this.numUpdateListeners
				};
				b.removeEventListener = function(a, b, c) {
					void 0 === c && (c = !1);
					e.prototype.removeEventListener.call(this, a, b, this, c);
					a == d.EffectEvent.EFFECT_UPDATE && --this.numUpdateListeners
				};
				b.animationEventHandler = function(a) {
					this.dispatchEvent(a)
				};
				return c
			}(d.Effect);
		d.Animate = g;
		g.prototype.__class__ = "egret.gui.Animate"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this.autoCenterTransform = !1;
					this.instanceClass = f.AnimateTransformInstance
				}
				__extends(c, e);
				var b = c.prototype;
				b.getOwningParallelEffect = function() {
					for (var a = null, b = this._parentCompositeEffect; b && !(b instanceof f.Sequence);) a = b, b = b._parentCompositeEffect;
					return a
				};
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					a || (a = this.target);
					var b = null,
						d = this.getOwningParallelEffect();
					null != d && (b = c.getSharedInstance(d, a));
					if (b) return this._initInstance(b), null;
					b = e.prototype.createInstance.call(this, a);
					d && c.storeSharedInstance(d, a, b);
					return b
				};
				b._effectStartHandler = function(a) {
					e.prototype._effectStartHandler.call(this, a);
					var b = this.getOwningParallelEffect();
					null != b && c.removeSharedInstance(b, a.effectInstance.target)
				};
				b.computeTransformCenterForTarget = function(a, b) {
					void 0 === b && (b = null);
					var c;
					this.autoCenterTransform ? c = new d.Point((null != b && void 0 !== b.width ? b.width : a.width) / 2, (null != b && void 0 !== b.height ? b.height : a.height) / 2) : (c = new d.Point(0, 0), isNaN(this.transformX) || (c.x = this.transformX), isNaN(this.transformY) || (c.y = this.transformY));
					return c
				};
				b.insertKeyframe = function(a, b) {
					for (var c = 0; c < a.length; c++) if (a[c].time > b.time) {
						a.splice(c, 0, b);
						return
					}
					a.push(b)
				};
				b._addMotionPath = function(a, b, c, e) {
					void 0 === b && (b = NaN);
					void 0 === c && (c = NaN);
					void 0 === e && (e = NaN);
					isNaN(b) && (isNaN(c) || isNaN(e) || (b = c - e));
					a = new f.MotionPath(a);
					a.keyframes = [new f.Keyframe(0, b), new f.Keyframe(this.duration, c, e)];
					a.keyframes[1].easer = this.easer;
					if (this.motionPaths) for (c = this.motionPaths.length, e = 0; e < c; e++) {
						if (b = this.motionPaths[e], b.property == a.property) {
							for (c = 0; c < a.keyframes.length; c++) this.insertKeyframe(b.keyframes, a.keyframes[c]);
							return
						}
					} else this.motionPaths = [];
					this.motionPaths.push(a)
				};
				b._initInstance = function(a) {
					var b = 0,
						f = this.duration;
					if (this.motionPaths) {
						for (var g = [], b = 0; b < this.motionPaths.length; ++b) {
							g[b] = this.motionPaths[b].clone();
							var s = g[b];
							if (s.keyframes) {
								for (var r = 0; r < s.keyframes.length; ++r) {
									var k = s.keyframes[r];
									isNaN(k.time) && (k.time = this.duration);
									0 != this.startDelay && (k.time += this.startDelay)
								}
								f = Math.max(f, s.keyframes[s.keyframes.length - 1].time)
							}
						}
						s = this.getGlobalStartTime();
						for (b = 0; b < g.length; ++b) a.addMotionPath(g[b], s)
					}
					a.initialized || (a.initialized = !0, this.autoCenterTransform || (a.transformCenter = this.computeTransformCenterForTarget(a.target)), a.autoCenterTransform = this.autoCenterTransform, b = this.startDelay, this.startDelay = 0, g = this.motionPaths, this.motionPaths = null, e.prototype._initInstance.call(this, a), this.startDelay = b, this.motionPaths = g, a.duration = Math.max(this.duration, f), d.getQualifiedClassName(this) != d.getQualifiedClassName(c) && (a.easer = c.linearEaser))
				};
				b.getGlobalStartTime = function() {
					for (var a = 0, b = this._parentCompositeEffect; b;) {
						a += b.startDelay;
						if (b instanceof f.Sequence) for (var c = b, e = 0; e < c.children.length; ++e) {
							var d = c.children[e];
							if (d == this) break;
							a = d instanceof f.CompositeEffect ? a + d.compositeDuration : a + (d.startDelay + d.duration * d.repeatCount + (d.repeatDelay + (d.repeatCount - 1)))
						}
						b = b._parentCompositeEffect
					}
					return a
				};
				c.getSharedInstance = function(a, b) {
					if (null != a) {
						var e = c.sharedObjectMaps[a.hashCode];
						if (null != e) return e[b.hashCode]
					}
					return null
				};
				c.removeSharedInstance = function(a, b) {
					if (null != a) {
						var e = c.sharedObjectMaps[a.hashCode];
						e && e[b.hashCode] && (delete e[b.hashCode], c.sharedObjectRefcounts[a.hashCode] -= 1, 0 >= c.sharedObjectRefcounts[a.hashCode] && (delete c.sharedObjectMaps[a.hashCode], delete c.sharedObjectRefcounts[a.hashCode]))
					}
				};
				c.storeSharedInstance = function(a, b, e) {
					if (null != a) {
						var d = c.sharedObjectMaps[a.hashCode];
						d || (d = {}, c.sharedObjectMaps[a.hashCode] = d);
						d[b.hashCode] || (c.sharedObjectRefcounts[a.hashCode] = c.sharedObjectRefcounts[a.hashCode] ? c.sharedObjectRefcounts[a.hashCode] + 1 : 1);
						d[b.hashCode] = e
					}
				};
				c.linearEaser = new f.Linear;
				c.sharedObjectMaps = {};
				c.sharedObjectRefcounts = {};
				return c
			}(f.Animate);
		f.AnimateTransform = g;
		g.prototype.__class__ = "egret.gui.AnimateTransform"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this.instanceClass = d.AnimateTransformInstance
				}
				__extends(c, e);
				var b = c.prototype;
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					this.motionPaths = [];
					return e.prototype.createInstance.call(this, a)
				};
				b._initInstance = function(a) {
					this._addMotionPath("translationX", this.xFrom, this.xTo, this.xBy);
					this._addMotionPath("translationY", this.yFrom, this.yTo, this.yBy);
					e.prototype._initInstance.call(this, a)
				};
				return c
			}(d.AnimateTransform);
		d.Move = g;
		g.prototype.__class__ = "egret.gui.Move"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this.instanceClass = d.AnimateTransformInstance
				}
				__extends(c, e);
				var b = c.prototype;
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					this.motionPaths = [];
					return e.prototype.createInstance.call(this, a)
				};
				b._initInstance = function(a) {
					this._addMotionPath("rotation", this.angleFrom, this.angleTo, this.angleBy);
					e.prototype._initInstance.call(this, a)
				};
				return c
			}(d.AnimateTransform);
		d.Rotate = g;
		g.prototype.__class__ = "egret.gui.Rotate"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(a) {
					void 0 === a && (a = null);
					e.call(this, a);
					this.instanceClass = d.AnimateTransformInstance
				}
				__extends(c, e);
				var b = c.prototype;
				b.createInstance = function(a) {
					void 0 === a && (a = null);
					this.motionPaths = [];
					return e.prototype.createInstance.call(this, a)
				};
				b._initInstance = function(a) {
					this._addMotionPath("scaleX", this.scaleXFrom, this.scaleXTo, this.scaleXBy);
					this._addMotionPath("scaleY", this.scaleYFrom, this.scaleYTo, this.scaleYBy);
					e.prototype._initInstance.call(this, a)
				};
				return c
			}(d.AnimateTransform);
		d.Scale = g;
		g.prototype.__class__ = "egret.gui.Scale"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c(b) {
					void 0 === b && (b = null);
					e.call(this, b);
					this.instanceClass = d.FadeInstance
				}
				__extends(c, e);
				c.prototype._initInstance = function(b) {
					e.prototype._initInstance.call(this, b);
					b.alphaFrom = this.alphaFrom;
					b.alphaTo = this.alphaTo
				};
				return c
			}(d.Animate);
		d.Fade = g;
		g.prototype.__class__ = "egret.gui.Fade"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.END = "end";
				e.STOP = "stop";
				return e
			}();
		d.InterruptionBehavior = g;
		g.prototype.__class__ = "egret.gui.InterruptionBehavior"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				return function() {
					this.toState = this.fromState = "*";
					this.autoReverse = !1;
					this.interruptionBehavior = d.InterruptionBehavior.END
				}
			}();
		d.Transition = g;
		g.prototype.__class__ = "egret.gui.Transition"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a, b) {
					void 0 === b && (b = !0);
					e.call(this);
					this.scale9Grid = null;
					this.fillMode = "scale";
					this.sourceChanged = !1;
					this._content = this._source = null;
					this.contentReused = this.createChildrenCalled = this._contentIsTexture = !1;
					this.autoScale = !0;
					this.touchChildren = !1;
					a && (this.source = a);
					this.autoScale = b
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "source", {
					get: function() {
						return this._source
					},
					set: function(a) {
						this._source != a && (this._source = a, this.createChildrenCalled ? this.parseSource() : this.sourceChanged = !0, this._setSizeDirty())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "content", {
					get: function() {
						return this._content
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this.sourceChanged && this.parseSource();
					this.createChildrenCalled = !0
				};
				b.parseSource = function() {
					this.sourceChanged = !1;
					var a = c.assetAdapter;
					a || (a = this.getAdapter());
					if (this._source) {
						var b = this.contentReused ? null : this._content;
						this.contentReused = !0;
						a.getAsset(this._source, this.contentChanged, this, b)
					} else this.contentChanged(null, null)
				};
				b.getAdapter = function() {
					var a;
					try {
						a = d.Injector.getInstance("egret.gui.IAssetAdapter")
					} catch (b) {
						a = new f.DefaultAssetAdapter
					}
					return c.assetAdapter = a
				};
				b.contentChanged = function(a, b) {
					if (b === this._source) {
						var c = this._content;
						this._content = a;
						this._content instanceof d.Texture ? (this._texture_to_render = a, this._contentIsTexture = !0) : (this._texture_to_render = null, this._contentIsTexture = !1);
						c !== a && (c instanceof d.DisplayObject && c.parent == this && (c._sizeChangeCallBack = null, c._sizeChangeCallTarget = null, this._removeFromDisplayList(c)), a instanceof d.DisplayObject && (a._sizeChangeCallBack = this.invalidateSize, a._sizeChangeCallTarget = this, this._addToDisplayListAt(a, 0)));
						this.invalidateSize();
						this.invalidateDisplayList();
						this.contentReused = !1;
						this.hasEventListener(f.UIEvent.CONTENT_CHANGED) && f.UIEvent.dispatchUIEvent(this, f.UIEvent.CONTENT_CHANGED)
					}
				};
				b.measure = function() {
					e.prototype.measure.call(this);
					var a = this._content;
					if (a instanceof d.DisplayObject) if ("preferredWidth" in a) this.measuredWidth = a.preferredWidth, this.measuredHeight = a.preferredHeight;
					else {
						var b = a.explicitWidth,
							c = a.explicitHeight;
						a.width = NaN;
						a.height = NaN;
						this.measuredWidth = a.measuredWidth * a.scaleX;
						this.measuredHeight = a.measuredHeight * a.scaleY;
						a.width = b;
						a.height = c
					} else this._contentIsTexture && (this.measuredWidth = a._textureWidth, this.measuredHeight = a._textureHeight)
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					var c = this._content;
					this.autoScale && c instanceof d.DisplayObject && ("setLayoutBoundsSize" in c ? c.setLayoutBoundsSize(a, b) : (c.width = a / c.scaleX, c.height = b / c.scaleY));
					this._setSizeDirty()
				};
				b._render = function(a) {
					if (this._contentIsTexture) {
						var b = this._content,
							c, f;
						this.autoScale ? (c = this._width, f = this._height) : (c = b._textureWidth, f = b._textureHeight);
						this._texture_to_render = b;
						d.Bitmap._drawBitmap(a, c, f, this)
					}
					e.prototype._render.call(this, a)
				};
				b._measureBounds = function() {
					if (this._contentIsTexture) {
						var a = this._content,
							b = this.width,
							c = this.height;
						return d.Rectangle.identity.initialize(Math.floor(a._offsetX * b / a._textureWidth), Math.floor(a._offsetY * c / a._textureHeight), b, c)
					}
					return e.prototype._measureBounds.call(this)
				};
				b.addChild = function(a) {
					throw Error(d.getString(3004, d.getString(3003)));
				};
				b.addChildAt = function(a, b) {
					throw Error(d.getString(3005, d.getString(3003)));
				};
				b.removeChild = function(a) {
					throw Error(d.getString(3006, d.getString(3003)));
				};
				b.removeChildAt = function(a) {
					throw Error(d.getString(3007, d.getString(3003)));
				};
				b.setChildIndex = function(a, b) {
					throw Error(d.getString(3008, d.getString(3003)));
				};
				b.swapChildren = function(a, b) {
					throw Error(d.getString(3009, d.getString(3003)));
				};
				b.swapChildrenAt = function(a, b) {
					throw Error(d.getString(3010, d.getString(3003)));
				};
				c.assetAdapter = null;
				return c
			}(f.UIComponent);
		f.UIAsset = g;
		g.prototype.__class__ = "egret.gui.UIAsset"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.hostComponentKey = null;
					this._skinNameExplicitlySet = !1;
					this._skinName = null;
					this._createChildrenCalled = !1;
					this._skin = null;
					this.stateIsDirty = this.skinLayoutEnabled = !1;
					this.explicitMouseEnabled = this.explicitMouseChildren = this._autoMouseEnabled = !0
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinName", {
					get: function() {
						return this._skinName
					},
					set: function(a) {
						this._skinName != a && (this._skinName = a, this._skinNameExplicitlySet = !0, this._createChildrenCalled && this.parseSkinName())
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this.parseSkinName();
					this._createChildrenCalled = !0
				};
				b.parseSkinName = function() {
					var a = c.skinAdapter;
					a || (a = this.getSkinAdapter());
					var b = this.hostComponentKey || d.getQualifiedClassName(this),
						a = a.getSkin(this._skinName, b);
					a || (b = c._defaultTheme) && (a = b.getDefaultSkin(this));
					this._setSkin(a)
				};
				b.getSkinAdapter = function() {
					var a;
					try {
						a = d.Injector.getInstance("egret.gui.ISkinAdapter")
					} catch (b) {
						a = new f.DefaultSkinAdapter
					}
					return c.skinAdapter = a
				};
				Object.defineProperty(b, "skin", {
					get: function() {
						return this._skin
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSkin = function(a) {
					var b = this._skin;
					this.detachSkin(b);
					b instanceof d.DisplayObject && this._removeFromDisplayList(b);
					this._skin = a;
					a instanceof d.DisplayObject && this._addToDisplayListAt(this._skin, 0);
					this.attachSkin(a);
					this.invalidateSkinState();
					this.invalidateSize();
					this.invalidateDisplayList();
					this.hasEventListener(f.UIEvent.SKIN_CHANGED) && f.UIEvent.dispatchUIEvent(this, f.UIEvent.SKIN_CHANGED)
				};
				b.attachSkin = function(a) {
					this.skinLayoutEnabled = !a || a instanceof d.DisplayObject ? !1 : !0;
					a && "hostComponent" in a && (a.hostComponent = this, this.findSkinParts())
				};
				b.findSkinParts = function() {
					var a = this._skin;
					if (a && "skinParts" in a) for (var b = a.skinParts, c = b.length, e = 0; e < c; e++) {
						var d = b[e];
						if (d in a) try {
							this[d] = a[d], this.partAdded(d, a[d])
						} catch (f) {}
					}
				};
				b.detachSkin = function(a) {
					if (a) {
						if ("skinParts" in a) for (var b = a.skinParts, c = b.length, e = 0; e < c; e++) {
							var d = b[e];
							d in this && (null != this[d] && this.partRemoved(d, this[d]), this[d] = null)
						}
						a.hostComponent = null
					}
				};
				b.partAdded = function(a, b) {
					f.SkinPartEvent.dispatchSkinPartEvent(this, f.SkinPartEvent.PART_ADDED, a, b)
				};
				b.partRemoved = function(a, b) {
					f.SkinPartEvent.dispatchSkinPartEvent(this, f.SkinPartEvent.PART_REMOVED, a, b)
				};
				b.invalidateSkinState = function() {
					this.stateIsDirty || (this.stateIsDirty = !0, this.invalidateProperties())
				};
				b.validateSkinState = function() {
					var a = this.getCurrentSkinState(),
						b = this._skin;
					b && "currentState" in b && (b.currentState = a);
					this.hasEventListener("stateChanged") && this.dispatchEventWith("stateChanged")
				};
				Object.defineProperty(b, "autoTouchEnabled", {
					get: function() {
						return this._autoMouseEnabled
					},
					set: function(a) {
						this._autoMouseEnabled != a && ((this._autoMouseEnabled = a) ? (this._touchChildren = this.enabled ? this.explicitMouseChildren : !1, this._touchEnabled = this.enabled ? this.explicitMouseEnabled : !1) : (this._touchChildren = this.explicitMouseChildren, this._touchEnabled = this.explicitMouseEnabled))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "touchChildren", {
					get: function() {
						return this._touchChildren
					},
					set: function(a) {
						this.enabled && (this._touchChildren = a);
						this.explicitMouseChildren = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "touchEnabled", {
					get: function() {
						return this._touchEnabled
					},
					set: function(a) {
						this.enabled && (this._touchEnabled = a);
						this.explicitMouseEnabled = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "enabled", {
					get: function() {
						return this._enabled
					},
					set: function(a) {
						this._setEnabled(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setEnabled = function(a) {
					this._enabled != a && (this._enabled = a, this._autoMouseEnabled && (this._touchChildren = a ? this.explicitMouseChildren : !1, this._touchEnabled = a ? this.explicitMouseEnabled : !1), this.invalidateSkinState())
				};
				b.getCurrentSkinState = function() {
					return this.enabled ? "normal" : "disabled"
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.stateIsDirty && (this.stateIsDirty = !1, this.validateSkinState())
				};
				b._childXYChanged = function() {
					this.skinLayoutEnabled && (this.invalidateSize(), this.invalidateDisplayList())
				};
				b.measure = function() {
					e.prototype.measure.call(this);
					var a = this._skin;
					a && (this.skinLayoutEnabled ? (a.measure(), this.measuredWidth = a.preferredWidth, this.measuredHeight = a.preferredHeight) : "preferredWidth" in a ? (this.measuredWidth = a.preferredWidth, this.measuredHeight = a.preferredHeight) : (this.measuredWidth = a.width, this.measuredHeight = a.height))
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					var c = this._skin;
					c && (this.skinLayoutEnabled ? c.updateDisplayList(a, b) : "setLayoutBoundsSize" in c ? c.setLayoutBoundsSize(a, b) : c instanceof d.DisplayObject && (c.scaleX = 0 == c.width ? 1 : a / c.width, c.scaleY = 0 == c.height ? 1 : b / c.height))
				};
				b.addChild = function(a) {
					throw Error(d.getString(3004, d.getString(3003)));
				};
				b.addChildAt = function(a, b) {
					throw Error(d.getString(3005, d.getString(3003)));
				};
				b.removeChild = function(a) {
					throw Error(d.getString(3006, d.getString(3003)));
				};
				b.removeChildAt = function(a) {
					throw Error(d.getString(3007, d.getString(3003)));
				};
				b.setChildIndex = function(a, b) {
					throw Error(d.getString(3008, d.getString(3003)));
				};
				b.swapChildren = function(a, b) {
					throw Error(d.getString(3009, d.getString(3003)));
				};
				b.swapChildrenAt = function(a, b) {
					throw Error(d.getString(3010, d.getString(3003)));
				};
				c.skinAdapter = null;
				c._defaultTheme = null;
				return c
			}(f.UIComponent);
		f.SkinnableComponent = g;
		g.prototype.__class__ = "egret.gui.SkinnableComponent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e() {}
				e.prototype.getSkin = function(c, b) {
					if (!c) return null;
					if (c.prototype) return new c;
					if ("string" == typeof c) {
						var a = d.getDefinitionByName(c);
						return a ? new a : null
					}
					return c
				};
				return e
			}();
		f.DefaultSkinAdapter = g;
		g.prototype.__class__ = "egret.gui.DefaultSkinAdapter"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e() {}
				e.prototype.getAsset = function(c, b, a, e) {
					var f = c;
					c.prototype && (f = new c);
					if (f instanceof d.DisplayObject || f instanceof d.Texture) b.call(a, f, c);
					else if ("string" == typeof c) {
						var g = new d.URLLoader;
						g.dataFormat = d.URLLoaderDataFormat.TEXTURE;
						g.addEventListener(d.Event.COMPLETE, function(e) {
							f = g.data;
							b.call(a, f, c)
						}, this);
						g.load(new d.URLRequest(c))
					} else b.call(a, f, c)
				};
				return e
			}();
		f.DefaultAssetAdapter = g;
		g.prototype.__class__ = "egret.gui.DefaultAssetAdapter"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e(b) {
					this.skinMap = {};
					this.delyList = [];
					this.loadConfig(b)
				}
				var c = e.prototype;
				e.load = function(b) {
					this.initialized || (this.initialized = !0, f.SkinnableComponent._defaultTheme = new e(b))
				};
				c.loadConfig = function(b) {
					var a = new d.URLLoader;
					a.addEventListener(d.Event.COMPLETE, this.onLoadComplete, this);
					a.addEventListener(d.IOErrorEvent.IO_ERROR, this.onLoadError, this);
					a.dataFormat = d.URLLoaderDataFormat.TEXT;
					a.load(new d.URLRequest(b))
				};
				c.onLoadComplete = function(b) {
					b = b.target;
					try {
						this.skinMap = JSON.parse(b.data).skins
					} catch (a) {
						d.Logger.warningWithErrorId(1017, b._request.url, b.data)
					}
					this.handleDelyList()
				};
				c.onLoadError = function(b) {
					d.Logger.warningWithErrorId(3E3, b.target._request.url);
					this.handleDelyList()
				};
				c.handleDelyList = function() {
					if (this.skinMap) {
						var b = this.delyList;
						this.delyList = [];
						for (var a = b.length, c = 0; c < a; c++) {
							var e = b[c];
							if (!e._skin) {
								var d = this.getDefaultSkin(e);
								e._setSkin(d)
							}
						}
					} else this.skinMap = {}, this.delyList = []
				};
				c.getDefaultSkin = function(b) {
					var a = this.skinMap;
					if (!a) return -1 == this.delyList.indexOf(b) && this.delyList.push(b), null;
					var c, e = b.hostComponentKey;
					if (e) c = a[e];
					else for (; b;) {
						e = d.getQualifiedClassName(b);
						if (c = a[e]) break;
						b = d.getDefinitionByName(d.getQualifiedSuperclassName(b))
					}
					if (!c) return null;
					a = d.getDefinitionByName(c);
					return a ? new a : (d.Logger.warningWithErrorId(3001, c), null)
				};
				e.initialized = !1;
				return e
			}();
		f.Theme = g;
		g.prototype.__class__ = "egret.gui.Theme"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._target = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "target", {
					get: function() {
						return this._target
					},
					set: function(a) {
						this._target = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.measure = function() {
					if (null != this.target) {
						for (var a = 0, b = 0, c = this._target, e = c.numElements, d = 0; d < e; d++) {
							var f = c.getElementAt(d);
							if (f && f.includeInLayout) {
								var g = f.horizontalCenter,
									l = f.verticalCenter,
									m = f.left,
									n = f.right,
									p = f.top,
									q = f.bottom;
								isNaN(m) || isNaN(n) ? isNaN(g) ? isNaN(m) && isNaN(n) ? g = f.preferredX : (g = isNaN(m) ? 0 : m, g += isNaN(n) ? 0 : n) : g = 2 * Math.abs(g) : g = m + n;
								isNaN(p) || isNaN(q) ? isNaN(l) ? isNaN(p) && isNaN(q) ? l = f.preferredY : (l = isNaN(p) ? 0 : p, l += isNaN(q) ? 0 : q) : l = 2 * Math.abs(l) : l = p + q;
								q = f.preferredHeight;
								a = Math.ceil(Math.max(a, g + f.preferredWidth));
								b = Math.ceil(Math.max(b, l + q))
							}
						}
						this.target.measuredWidth = a;
						this.target.measuredHeight = b
					}
				};
				b.updateDisplayList = function(a, b) {
					if (null != this.target) for (var c = this.target.numElements, e = 0; e < c; e++) {
						var d = this.target.getElementAt(e);
						if (null != d && d.includeInLayout) {
							var f = d.horizontalCenter,
								g = d.verticalCenter,
								l = d.left,
								m = d.right,
								n = d.top,
								p = d.bottom,
								q = d.percentWidth,
								x = d.percentHeight,
								z = NaN,
								t = NaN;
							isNaN(l) || isNaN(m) ? isNaN(q) || (z = Math.round(a * Math.min(0.01 * q, 1))) : z = a - m - l;
							isNaN(n) || isNaN(p) ? isNaN(x) || (t = Math.round(b * Math.min(0.01 * x, 1))) : t = b - p - n;
							d.setLayoutBoundsSize(z, t);
							q = d.layoutBoundsWidth;
							x = d.layoutBoundsHeight;
							t = z = NaN;
							z = isNaN(f) ? isNaN(l) ? isNaN(m) ? d.layoutBoundsX : a - q - m : l : Math.round((a - q) / 2 + f);
							t = isNaN(g) ? isNaN(n) ? isNaN(p) ? d.layoutBoundsY : b - x - p : n : Math.round((b - x) / 2 + g);
							d.setLayoutBoundsPosition(z, t)
						}
					}
				};
				return c
			}(d.HashObject);
		f.SkinBasicLayout = g;
		g.prototype.__class__ = "egret.gui.SkinBasicLayout"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._downEventFired = !1;
					this.labelDisplay = this.autoRepeatTimer = null;
					this._autoRepeat = !1;
					this._repeatInterval = this._repeatDelay = 35;
					this._keepDown = this._hovered = !1;
					this._label = "";
					this.touchChildren = this._stickyHighlighting = this._mouseCaptured = !1;
					this.addHandlers()
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "autoRepeat", {
					get: function() {
						return this._autoRepeat
					},
					set: function(a) {
						a != this._autoRepeat && (this._autoRepeat = a, this.checkAutoRepeatTimerConditions(this.isDown()))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "repeatDelay", {
					get: function() {
						return this._repeatDelay
					},
					set: function(a) {
						this._repeatDelay = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "repeatInterval", {
					get: function() {
						return this._repeatInterval
					},
					set: function(a) {
						this._repeatInterval = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "hovered", {
					get: function() {
						return this._hovered
					},
					set: function(a) {
						a != this._hovered && (this._hovered = a, this.invalidateSkinState(), this.checkButtonDownConditions())
					},
					enumerable: !0,
					configurable: !0
				});
				b._setKeepDown = function(a) {
					this._keepDown != a && (this._keepDown = a, this.invalidateSkinState())
				};
				Object.defineProperty(b, "label", {
					get: function() {
						return this._getLabel()
					},
					set: function(a) {
						this._setLabel(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getLabel = function() {
					return this.labelDisplay ? this.labelDisplay.text : this._label
				};
				b._setLabel = function(a) {
					this._label = a;
					this.labelDisplay && (this.labelDisplay.text = a)
				};
				Object.defineProperty(b, "mouseCaptured", {
					get: function() {
						return this._mouseCaptured
					},
					set: function(a) {
						a != this._mouseCaptured && (this._mouseCaptured = a, this.invalidateSkinState(), a || this.removeStageMouseHandlers(), this.checkButtonDownConditions())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "stickyHighlighting", {
					get: function() {
						return this._stickyHighlighting
					},
					set: function(a) {
						a != this._stickyHighlighting && (this._stickyHighlighting = a, this.invalidateSkinState(), this.checkButtonDownConditions())
					},
					enumerable: !0,
					configurable: !0
				});
				b.checkButtonDownConditions = function() {
					var a = this.isDown();
					this._downEventFired != a && (a && f.UIEvent.dispatchUIEvent(this, f.UIEvent.BUTTON_DOWN), this._downEventFired = a, this.checkAutoRepeatTimerConditions(a))
				};
				b.addHandlers = function() {
					this.addEventListener(d.TouchEvent.TOUCH_ROLL_OVER, this.mouseEventHandler, this);
					this.addEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.mouseEventHandler, this);
					this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.mouseEventHandler, this);
					this.addEventListener(d.TouchEvent.TOUCH_END, this.mouseEventHandler, this);
					this.addEventListener(d.TouchEvent.TOUCH_TAP, this.mouseEventHandler, this)
				};
				b.addStageMouseHandlers = function() {
					f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this);
					f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this)
				};
				b.removeStageMouseHandlers = function() {
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this);
					f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this)
				};
				b.isDown = function() {
					return this.enabled ? this.mouseCaptured && (this.hovered || this.stickyHighlighting) ? !0 : !1 : !1
				};
				b.checkAutoRepeatTimerConditions = function(a) {
					a = this.autoRepeat && a;
					a != (null != this.autoRepeatTimer) && (a ? this.startTimer() : this.stopTimer())
				};
				b.startTimer = function() {
					this.autoRepeatTimer = new d.Timer(1);
					this.autoRepeatTimer.delay = this._repeatDelay;
					this.autoRepeatTimer.addEventListener(d.TimerEvent.TIMER, this.autoRepeat_timerDelayHandler, this);
					this.autoRepeatTimer.start()
				};
				b.stopTimer = function() {
					this.autoRepeatTimer.stop();
					this.autoRepeatTimer = null
				};
				b.mouseEventHandler = function(a) {
					switch (a.type) {
					case d.TouchEvent.TOUCH_ROLL_OVER:
						if (a.touchDown && !this.mouseCaptured) break;
						this.hovered = !0;
						break;
					case d.TouchEvent.TOUCH_ROLL_OUT:
						this.hovered = !1;
						break;
					case d.TouchEvent.TOUCH_BEGIN:
						this.addStageMouseHandlers();
						d.InteractionMode.mode == d.InteractionMode.TOUCH && (this.hovered = !0);
						this.mouseCaptured = !0;
						break;
					case d.TouchEvent.TOUCH_END:
						a.target == this && (this.hovered = !0, this.mouseCaptured && (this.buttonReleased(), this.mouseCaptured = !1));
						break;
					case d.TouchEvent.TOUCH_TAP:
						this.enabled ? this.clickHandler(a) : a.stopImmediatePropagation()
					}
				};
				b.buttonReleased = function() {};
				b.clickHandler = function(a) {};
				b.stage_mouseUpHandler = function(a) {
					a.target != this && (this.mouseCaptured = !1)
				};
				b.autoRepeat_timerDelayHandler = function(a) {
					this.autoRepeatTimer.reset();
					this.autoRepeatTimer.removeEventListener(d.TimerEvent.TIMER, this.autoRepeat_timerDelayHandler, this);
					this.autoRepeatTimer.delay = this._repeatInterval;
					this.autoRepeatTimer.addEventListener(d.TimerEvent.TIMER, this.autoRepeat_timerHandler, this);
					this.autoRepeatTimer.start()
				};
				b.autoRepeat_timerHandler = function(a) {
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.BUTTON_DOWN)
				};
				b.getCurrentSkinState = function() {
					return this.enabled ? this.isDown() || this._keepDown ? "down" : d.InteractionMode.mode == d.InteractionMode.MOUSE && (this.hovered || this.mouseCaptured) ? "over" : "up" : e.prototype.getCurrentSkinState.call(this)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.labelDisplay && (this.labelDisplay.text = this._label)
				};
				return c
			}(f.SkinnableComponent);
		f.ButtonBase = g;
		g.prototype.__class__ = "egret.gui.ButtonBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._selected = !1;
					this._autoSelected = !0
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "selected", {
					get: function() {
						return this._selected
					},
					set: function(a) {
						this._setSelected(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSelected = function(a) {
					a != this._selected && (this._selected = a, f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT), this.invalidateSkinState())
				};
				b.getCurrentSkinState = function() {
					var a = e.prototype.getCurrentSkinState.call(this);
					if (this.selected) {
						var b = a + "AndSelected",
							c = this.skin;
						return c && c.hasState(b) ? b : "disabled" == a ? "disabled" : "down"
					}
					return a
				};
				b.buttonReleased = function() {
					e.prototype.buttonReleased.call(this);
					this._autoSelected && this.enabled && (this.selected = !this.selected, this.dispatchEventWith(d.Event.CHANGE))
				};
				return c
			}(f.ButtonBase);
		f.ToggleButtonBase = g;
		g.prototype.__class__ = "egret.gui.ToggleButtonBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._textField = null;
					this.fontFamilyChanged = this.allStyleChanged = !1;
					this._fontFamily = "SimSun";
					this._sizeChanged = !1;
					this._size = 30;
					this._focusEnabled = !0;
					this.textAlignChanged = this._italic = this.italicChanged = this._bold = this.boldChanged = !1;
					this._textAlign = d.HorizontalAlign.LEFT;
					this.verticalAlignChanged = !1;
					this._verticalAlign = d.VerticalAlign.TOP;
					this.lineSpacingChanged = !1;
					this._lineSpacing = 0;
					this.textColorChanged = !1;
					this._textColor = 16777215;
					this._textChanged = !1;
					this._text = "";
					this._textFlow = null;
					this._textFlowChanged = !1;
					this._hasNoStyleChild = !0
				}
				__extends(c, e);
				var b = c.prototype;
				b.styleChanged = function(a) {
					if (!this.allStyleChanged) {
						if (a) switch (a) {
						case "textColor":
							this.textColorChanged = !0;
							break;
						case "fontFamily":
							this.fontFamilyChanged = !0;
							break;
						case "size":
							this._sizeChanged = !0;
							break;
						case "bold":
							this.boldChanged = !0;
							break;
						case "italic":
							this.italicChanged = !0;
							break;
						case "textAlign":
							this.textAlignChanged = !0;
							break;
						case "verticalAlign":
							this.verticalAlignChanged = !0
						} else this.allStyleChanged = !0;
						this.invalidateProperties();
						this.invalidateSize();
						this.invalidateDisplayList()
					}
				};
				Object.defineProperty(b, "fontFamily", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.fontFamily ? a.fontFamily : this._fontFamily
					},
					set: function(a) {
						this.setStyle("fontFamily", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "size", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.size ? a.size : this._size
					},
					set: function(a) {
						void 0 === a && (a = 0);
						this.setStyle("size", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "focusEnabled", {
					get: function() {
						return this._focusEnabled
					},
					set: function(a) {
						this._focusEnabled = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.setFocus = function() {
					!1 != this._focusEnabled && this._textField && this._textField.setFocus()
				};
				Object.defineProperty(b, "bold", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.bold ? a.bold : this._bold
					},
					set: function(a) {
						this.setStyle("bold", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "italic", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.italic ? a.italic : this._italic
					},
					set: function(a) {
						this.setStyle("italic", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "textAlign", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.textAlign ? a.textAlign : this._textAlign
					},
					set: function(a) {
						this.setStyle("textAlign", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalAlign", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.verticalAlign ? a.verticalAlign : this._verticalAlign
					},
					set: function(a) {
						this.setStyle("verticalAlign", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "lineSpacing", {
					get: function() {
						return this._getLineSpacing()
					},
					set: function(a) {
						this._setLineSpacing(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getLineSpacing = function() {
					return this._lineSpacing
				};
				b._setLineSpacing = function(a) {
					this._lineSpacing != a && (this._lineSpacing = a, this.lineSpacingChanged = !0, this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
				};
				Object.defineProperty(b, "textColor", {
					get: function() {
						var a = this._styleProtoChain;
						return a && void 0 !== a.textColor ? a.textColor : this._textColor
					},
					set: function(a) {
						this.setStyle("textColor", a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "text", {
					get: function() {
						return this._text
					},
					set: function(a) {
						a != this._text && (this._text = a || "", this._textChanged = !0, this._textFlowChanged = !1, this._textFlow = [], this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "textFlow", {
					get: function() {
						return this._textFlow
					},
					set: function(a) {
						this._textFlow = a || [];
						this._textFlowChanged = !0;
						this._textChanged = !1;
						this._text = "";
						this.invalidateProperties();
						this.invalidateSize();
						this.invalidateDisplayList()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "textHeight", {
					get: function() {
						return null == this._textField ? 0 : this._textField.textHeight
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "textWidth", {
					get: function() {
						return null == this._textField ? 0 : this._textField.textWidth
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this._textField || this.checkTextField()
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this._textField || this.checkTextField();
					this.allStyleChanged && (this.allStyleChanged = !1, this.verticalAlignChanged = this.textAlignChanged = this.italicChanged = this.boldChanged = this._sizeChanged = this.fontFamilyChanged = this.textColorChanged = !0);
					this.fontFamilyChanged && (this._textField.fontFamily = this.fontFamily, this.fontFamilyChanged = !1);
					this._sizeChanged && (this._textField.size = this.size, this._sizeChanged = !1);
					this.boldChanged && (this._textField.bold = this.bold, this.boldChanged = !1);
					this.italic && (this._textField.italic = this.italic, this.italicChanged = !1);
					this.textAlignChanged && (this._textField.textAlign = this.textAlign, this.textAlignChanged = !1);
					this.verticalAlignChanged && (this._textField.verticalAlign = this.verticalAlign, this.verticalAlignChanged = !1);
					this.lineSpacingChanged && (this._textField.lineSpacing = this._lineSpacing, this.lineSpacingChanged = !1);
					this.textColorChanged && (this._textField.textColor = this.textColor, this.textColorChanged = !1);
					this._textChanged && (this._textField.text = this._text);
					this._textFlowChanged && (this._textField.textFlow = this._textFlow);
					if (this._textChanged || this._textFlowChanged) this._text = this._textField.text, this._textFlow = this._textField.textFlow, this._textFlowChanged = this._textChanged = !1
				};
				b.checkTextField = function() {
					this._textField || (this._createTextField(), this._textChanged && (this._textField.text = this._text), this._textFlowChanged && (this._textField.textFlow = this._textFlow), this.invalidateProperties())
				};
				b._createTextField = function() {
					this._textField = new d.TextField;
					this._textField.fontFamily = this.fontFamily;
					this._textField.size = this.size;
					this._textField.textAlign = this.textAlign;
					this._textField.verticalAlign = this.verticalAlign;
					this._textField.lineSpacing = this._lineSpacing;
					this._textField.textColor = this.textColor;
					this._textField.multiline = !0;
					this._addToDisplayList(this._textField)
				};
				b._textFieldChanged = function() {
					this._text = this._textField.text;
					this._textFlow = this._textField.textFlow
				};
				b.measure = function() {
					e.prototype.measure.call(this);
					this.measuredWidth = c.DEFAULT_MEASURED_WIDTH;
					this.measuredHeight = c.DEFAULT_MEASURED_HEIGHT
				};
				b.$updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b)
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this._textField.width = a;
					this._textField.height = b
				};
				b.dispatchPropertyChangeEvent = function(a, b, c) {
					this.hasEventListener("propertyChange") && f.PropertyChangeEvent.dispatchPropertyChangeEvent(this, f.PropertyChangeEventKind.UPDATE, a, b, c, this)
				};
				c.DEFAULT_MEASURED_WIDTH = 160;
				c.DEFAULT_MEASURED_HEIGHT = 22;
				return c
			}(f.UIComponent);
		f.TextBase = g;
		g.prototype.__class__ = "egret.gui.TextBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._contentHeight = this._contentWidth = 0;
					this._layout = null;
					this._clipAndEnableScrolling = !1;
					this._verticalScrollPosition = this._horizontalScrollPosition = 0;
					this.touchEnabled = this._layoutInvalidateSizeFlag = this._layoutInvalidateDisplayListFlag = !1
				}
				__extends(c, e);
				var b = c.prototype;
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this._layout || (this.layout = new f.BasicLayout)
				};
				Object.defineProperty(b, "contentWidth", {
					get: function() {
						return this._contentWidth
					},
					enumerable: !0,
					configurable: !0
				});
				b.setContentWidth = function(a) {
					if (a != this._contentWidth) {
						var b = this._contentWidth;
						this._contentWidth = a;
						this.hasEventListener("propertyChange") && f.PropertyChangeEvent.dispatchPropertyChangeEvent(this, f.PropertyChangeEventKind.UPDATE, "contentWidth", b, a, this)
					}
				};
				Object.defineProperty(b, "contentHeight", {
					get: function() {
						return this._contentHeight
					},
					enumerable: !0,
					configurable: !0
				});
				b.setContentHeight = function(a) {
					if (a != this._contentHeight) {
						var b = this._contentHeight;
						this._contentHeight = a;
						this.hasEventListener("propertyChange") && f.PropertyChangeEvent.dispatchPropertyChangeEvent(this, f.PropertyChangeEventKind.UPDATE, "contentHeight", b, a, this)
					}
				};
				b.setContentSize = function(a, b) {
					if (a != this._contentWidth || b != this._contentHeight) this.setContentWidth(a), this.setContentHeight(b)
				};
				Object.defineProperty(b, "layout", {
					get: function() {
						return this._layout
					},
					set: function(a) {
						this._setLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setLayout = function(a) {
					if (this._layout != a) {
						this._layout && (this._layout.target = null);
						if (this._layout = a) this._layout.target = this;
						this.invalidateSize();
						this.invalidateDisplayList();
						this.dispatchEventWith("layoutChanged")
					}
				};
				Object.defineProperty(b, "clipAndEnableScrolling", {
					get: function() {
						return this._clipAndEnableScrolling
					},
					set: function(a) {
						a != this._clipAndEnableScrolling && (this.scrollRect = (this._clipAndEnableScrolling = a) ? new d.Rectangle(this._horizontalScrollPosition, this._verticalScrollPosition, this.width, this.height) : null)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "horizontalScrollPosition", {
					get: function() {
						return this._horizontalScrollPosition
					},
					set: function(a) {
						if (a != this._horizontalScrollPosition) {
							var b = this._horizontalScrollPosition;
							this._horizontalScrollPosition = a;
							this.scrollPositionChanged();
							f.PropertyChangeEvent.dispatchPropertyChangeEvent(this, f.PropertyChangeEventKind.UPDATE, "horizontalScrollPosition", b, a, this)
						}
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalScrollPosition", {
					get: function() {
						return this._verticalScrollPosition
					},
					set: function(a) {
						if (a != this._verticalScrollPosition) {
							var b = this._verticalScrollPosition;
							this._verticalScrollPosition = a;
							this.scrollPositionChanged();
							f.PropertyChangeEvent.dispatchPropertyChangeEvent(this, f.PropertyChangeEventKind.UPDATE, "verticalScrollPosition", b, a, this)
						}
					},
					enumerable: !0,
					configurable: !0
				});
				b.scrollPositionChanged = function() {
					this._clipAndEnableScrolling && (this.updateScrollRect(this.width, this.height), this._invalidateDisplayListExceptLayout(), this._layout && this._layout.scrollPositionChanged())
				};
				b.updateScrollRect = function(a, b) {
					var c = this._scrollRect;
					this._clipAndEnableScrolling ? c ? (c.x = this._horizontalScrollPosition, c.y = this._verticalScrollPosition, c.width = a, c.height = b) : this._scrollRect = new d.Rectangle(this._horizontalScrollPosition, this._verticalScrollPosition, a, b) : c && (this._scrollRect = null)
				};
				b.measure = function() {
					this._layout && this._layoutInvalidateSizeFlag && (e.prototype.measure.call(this), this._layout.measure())
				};
				b._invalidateDisplayListExceptLayout = function() {
					e.prototype.invalidateDisplayList.call(this)
				};
				b.invalidateDisplayList = function() {
					e.prototype.invalidateDisplayList.call(this);
					this._layoutInvalidateDisplayListFlag = !0
				};
				b._childXYChanged = function() {
					this.invalidateSize();
					this.invalidateDisplayList()
				};
				b._invalidateSizeExceptLayout = function() {
					e.prototype.invalidateSize.call(this)
				};
				b.invalidateSize = function() {
					e.prototype.invalidateSize.call(this);
					this._layoutInvalidateSizeFlag = !0
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this._layoutInvalidateDisplayListFlag && this._layout && (this._layoutInvalidateDisplayListFlag = !1, this._layout.updateDisplayList(a, b), this.updateScrollRect(a, b))
				};
				Object.defineProperty(b, "numElements", {
					get: function() {
						return -1
					},
					enumerable: !0,
					configurable: !0
				});
				b.getElementAt = function(a) {
					return null
				};
				b.getElementIndex = function(a) {
					return -1
				};
				b.getElementIndicesInView = function() {
					var a = [],
						b;
					if (this.scrollRect) for (b = 0; b < this.numChildren; b++) {
						var c = this.getChildAt(b);
						if (c) {
							var e = new d.Rectangle;
							e.x = c.layoutBoundsX;
							e.y = c.layoutBoundsY;
							e.width = c.layoutBoundsWidth;
							e.height = c.layoutBoundsHeight;
							this.scrollRect.intersects(e) && a.push(b)
						}
					} else for (b = 0; b < this.numChildren; b++) a.push(b);
					return a
				};
				b.setVirtualElementIndicesInView = function(a, b) {};
				b.getVirtualElementAt = function(a) {
					return this.getElementAt(a)
				};
				return c
			}(f.UIComponent);
		f.GroupBase = g;
		g.prototype.__class__ = "egret.gui.GroupBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.dataChangedFlag = !1;
					this._data = null;
					this._selected = !1;
					this._itemIndex = -1;
					this.touchChildren = !0
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "data", {
					get: function() {
						return this._data
					},
					set: function(a) {
						this._data = a;
						this.initialized || this.parent ? (this.dataChangedFlag = !1, this.dataChanged()) : (this.dataChangedFlag = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.dataChanged = function() {};
				Object.defineProperty(b, "selected", {
					get: function() {
						return this._selected
					},
					set: function(a) {
						this._selected != a && (this._selected = a, this.invalidateSkinState())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemIndex", {
					get: function() {
						return this._itemIndex
					},
					set: function(a) {
						this._itemIndex = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.dataChangedFlag && (this.dataChangedFlag = !1, this.dataChanged())
				};
				b.getCurrentSkinState = function() {
					return this._selected ? "down" : e.prototype.getCurrentSkinState.call(this)
				};
				return c
			}(d.ButtonBase);
		d.ItemRenderer = g;
		g.prototype.__class__ = "egret.gui.ItemRenderer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.contentGroup = this.disclosureButton = this.iconDisplay = null;
					this._indentation = 17;
					this._iconSkinName = null;
					this._depth = 0;
					this._isOpen = this._hasChildren = !1;
					this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.onItemMouseDown, this, !1, 1E3)
				}
				__extends(c, e);
				var b = c.prototype;
				b.onItemMouseDown = function(a) {
					a.target == this.disclosureButton && a.stopImmediatePropagation()
				};
				Object.defineProperty(b, "indentation", {
					get: function() {
						return this._indentation
					},
					set: function(a) {
						this._indentation = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "iconSkinName", {
					get: function() {
						return this._iconSkinName
					},
					set: function(a) {
						this._iconSkinName != a && (this._iconSkinName = a, this.iconDisplay && (this.iconDisplay.source = this._iconSkinName))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "depth", {
					get: function() {
						return this._depth
					},
					set: function(a) {
						a != this._depth && (this._depth = a, this.contentGroup && (this.contentGroup.x = this._depth * this._indentation))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "hasChildren", {
					get: function() {
						return this._hasChildren
					},
					set: function(a) {
						this._hasChildren != a && (this._hasChildren = a, this.disclosureButton && (this.disclosureButton.visible = this._hasChildren))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "opened", {
					get: function() {
						return this._isOpen
					},
					set: function(a) {
						this._isOpen != a && (this._isOpen = a, this.disclosureButton && (this.disclosureButton.selected = this._isOpen))
					},
					enumerable: !0,
					configurable: !0
				});
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.iconDisplay ? this.iconDisplay.source = this._iconSkinName : b == this.disclosureButton ? (this.disclosureButton.visible = this._hasChildren, this.disclosureButton.selected = this._isOpen, this.disclosureButton._autoSelected = !1, this.disclosureButton.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.disclosureButton_mouseDownHandler, this)) : b == this.contentGroup && (this.contentGroup.x = this._depth * this._indentation)
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.iconDisplay ? this.iconDisplay.source = null : b == this.disclosureButton && (this.disclosureButton.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.disclosureButton_mouseDownHandler, this), this.disclosureButton._autoSelected = !0, this.disclosureButton.visible = !0)
				};
				b.disclosureButton_mouseDownHandler = function(a) {
					f.TreeEvent.dispatchTreeEvent(this, f.TreeEvent.ITEM_OPENING, this.itemIndex, this.data, this, !this._isOpen)
				};
				return c
			}(f.ItemRenderer);
		f.TreeItemRenderer = g;
		g.prototype.__class__ = "egret.gui.TreeItemRenderer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._maximum = 100;
					this.maxChanged = !1;
					this._minimum = 0;
					this.minChanged = !1;
					this._stepSize = 1;
					this.stepSizeChanged = !1;
					this._changedValue = this._value = 0;
					this.valueChanged = !1;
					this._snapInterval = 1;
					this._explicitSnapInterval = this.snapIntervalChanged = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "maximum", {
					get: function() {
						return this._maximum
					},
					set: function(a) {
						this._setMaximun(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setMaximun = function(a) {
					a != this._maximum && (this._maximum = a, this.maxChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "minimum", {
					get: function() {
						return this._minimum
					},
					set: function(a) {
						this._setMinimun(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setMinimun = function(a) {
					a != this._minimum && (this._minimum = a, this.minChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "stepSize", {
					get: function() {
						return this._stepSize
					},
					set: function(a) {
						a != this._stepSize && (this._stepSize = a, this.stepSizeChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "value", {
					get: function() {
						return this._getValue()
					},
					set: function(a) {
						this._setValue(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setValue = function(a) {
					a != this.value && (this._changedValue = a, this.valueChanged = !0, this.invalidateProperties())
				};
				b._getValue = function() {
					return this.valueChanged ? this._changedValue : this._value
				};
				Object.defineProperty(b, "snapInterval", {
					get: function() {
						return this._snapInterval
					},
					set: function(a) {
						this._explicitSnapInterval = !0;
						a != this._snapInterval && (isNaN(a) ? (this._snapInterval = 1, this._explicitSnapInterval = !1) : this._snapInterval = a, this.stepSizeChanged = this.snapIntervalChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.minimum > this.maximum && (this.maxChanged ? this._maximum = this._minimum : this._minimum = this._maximum);
					if (this.valueChanged || this.maxChanged || this.minChanged || this.snapIntervalChanged) {
						var a = this.valueChanged ? this._changedValue : this._value;
						this.snapIntervalChanged = this.minChanged = this.maxChanged = this.valueChanged = !1;
						this.setValue(this.nearestValidValue(a, this.snapInterval))
					}
					this.stepSizeChanged && (this._explicitSnapInterval ? this._stepSize = this.nearestValidSize(this._stepSize) : (this._snapInterval = this._stepSize, this.setValue(this.nearestValidValue(this._value, this.snapInterval))), this.stepSizeChanged = !1)
				};
				b.nearestValidSize = function(a) {
					var b = this.snapInterval;
					if (0 == b) return a;
					a = Math.round(a / b) * b;
					return Math.abs(a) < b ? b : a
				};
				b.nearestValidValue = function(a, b) {
					if (0 == b) return Math.max(this.minimum, Math.min(this.maximum, a));
					var c = this.maximum - this.minimum,
						e = 1;
					a -= this.minimum;
					b != Math.round(b) && (e = (1 + b).toString().split("."), e = Math.pow(10, e[1].length), c *= e, a = Math.round(a * e), b = Math.round(b * e));
					var d = Math.max(0, Math.floor(a / b) * b),
						c = Math.min(c, Math.floor((a + b) / b) * b);
					return (a - d >= (c - d) / 2 ? c : d) / e + this.minimum
				};
				b.setValue = function(a) {
					this._value != a && (isNaN(a) && (a = 0), !isNaN(this.maximum) && !isNaN(this.minimum) && this.maximum > this.minimum ? this._value = Math.min(this.maximum, Math.max(this.minimum, a)) : this._value = a, this.valueChanged = !1, d.UIEvent.dispatchUIEvent(this, d.UIEvent.VALUE_COMMIT))
				};
				b.changeValueByStep = function(a) {
					void 0 === a && (a = !0);
					0 != this.stepSize && this.setValue(this.nearestValidValue(a ? this.value + this.stepSize : this.value - this.stepSize, this.snapInterval))
				};
				return c
			}(d.SkinnableComponent);
		d.Range = g;
		g.prototype.__class__ = "egret.gui.Range"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._slideDuration = 300;
					this.track = this.thumb = null;
					this._clickOffsetY = this._clickOffsetX = NaN;
					this.needUpdateValue = !1;
					this._moveStageY = this._moveStageX = NaN;
					this.mouseDownTarget = null;
					this.addEventListener(d.Event.ADDED_TO_STAGE, this.addedToStageHandler, this);
					this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.mouseDownHandler, this)
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "slideDuration", {
					get: function() {
						return this._slideDuration
					},
					set: function(a) {
						this._slideDuration = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maximum", {
					get: function() {
						return this._maximum
					},
					set: function(a) {
						a != this._maximum && (this._setMaximun(a), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "minimum", {
					get: function() {
						return this._minimum
					},
					set: function(a) {
						a != this._minimum && (this._setMinimun(a), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "value", {
					get: function() {
						return this._getValue()
					},
					set: function(a) {
						a != this._getValue() && (this._setValue(a), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.setValue = function(a) {
					e.prototype.setValue.call(this, a);
					this.invalidateDisplayList()
				};
				b.pointToValue = function(a, b) {
					return this.minimum
				};
				b.changeValueByStep = function(a) {
					void 0 === a && (a = !0);
					var b = this.value;
					e.prototype.changeValueByStep.call(this, a);
					this.value != b && this.dispatchEventWith(d.Event.CHANGE)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.thumb ? (this.thumb.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.thumb_mouseDownHandler, this), this.thumb.addEventListener(f.ResizeEvent.RESIZE, this.thumb_resizeHandler, this), this.thumb.addEventListener(f.UIEvent.UPDATE_COMPLETE, this.thumb_updateCompleteHandler, this), this.thumb.stickyHighlighting = !0) : b == this.track && (this.track.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.track_mouseDownHandler, this), this.track.addEventListener(f.ResizeEvent.RESIZE, this.track_resizeHandler, this))
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.thumb ? (this.thumb.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.thumb_mouseDownHandler, this), this.thumb.removeEventListener(f.ResizeEvent.RESIZE, this.thumb_resizeHandler, this), this.thumb.removeEventListener(f.UIEvent.UPDATE_COMPLETE, this.thumb_updateCompleteHandler, this)) : b == this.track && (this.track.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.track_mouseDownHandler, this), this.track.removeEventListener(f.ResizeEvent.RESIZE, this.track_resizeHandler, this))
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this.updateSkinDisplayList()
				};
				b.updateSkinDisplayList = function() {};
				b.addedToStageHandler = function(a) {
					this.updateSkinDisplayList()
				};
				b.track_resizeHandler = function(a) {
					this.updateSkinDisplayList()
				};
				b.thumb_resizeHandler = function(a) {
					this.updateSkinDisplayList()
				};
				b.thumb_updateCompleteHandler = function(a) {
					this.updateSkinDisplayList();
					this.thumb.removeEventListener(f.UIEvent.UPDATE_COMPLETE, this.thumb_updateCompleteHandler, this)
				};
				b.thumb_mouseDownHandler = function(a) {
					f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_MOVE, this.stage_mouseMoveHandler, this);
					f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this);
					f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this);
					this.addEventListener(d.Event.ENTER_FRAME, this.onEnterFrame, this);
					a = this.thumb.globalToLocal(a.stageX, a.stageY, d.Point.identity);
					this._clickOffsetX = a.x;
					this._clickOffsetY = a.y;
					f.TrackBaseEvent.dispatchTrackBaseEvent(this, f.TrackBaseEvent.THUMB_PRESS);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_START)
				};
				b.onEnterFrame = function(a) {
					this.needUpdateValue && this.track && (this.updateWhenMouseMove(), this.needUpdateValue = !1)
				};
				b.updateWhenMouseMove = function() {
					if (this.track) {
						var a = this.track.globalToLocal(this._moveStageX, this._moveStageY, d.Point.identity),
							a = this.pointToValue(a.x - this._clickOffsetX, a.y - this._clickOffsetY),
							a = this.nearestValidValue(a, this.snapInterval);
						a != this.value && (this.setValue(a), this.validateDisplayList(), f.TrackBaseEvent.dispatchTrackBaseEvent(this, f.TrackBaseEvent.THUMB_DRAG), this.dispatchEventWith(d.Event.CHANGE))
					}
				};
				b.stage_mouseMoveHandler = function(a) {
					this._moveStageX = a.stageX;
					this._moveStageY = a.stageY;
					this.needUpdateValue || (this.needUpdateValue = !0)
				};
				b.stage_mouseUpHandler = function(a) {
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_MOVE, this.stage_mouseMoveHandler, this);
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this);
					f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this);
					this.removeEventListener(d.Event.ENTER_FRAME, this.updateWhenMouseMove, this);
					this.needUpdateValue && (this.updateWhenMouseMove(), this.needUpdateValue = !1);
					f.TrackBaseEvent.dispatchTrackBaseEvent(this, f.TrackBaseEvent.THUMB_RELEASE);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_END)
				};
				b.track_mouseDownHandler = function(a) {};
				b.mouseDownHandler = function(a) {
					f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpSomewhereHandler, this);
					f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpSomewhereHandler, this);
					this.mouseDownTarget = a.target
				};
				b.stage_mouseUpSomewhereHandler = function(a) {
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpSomewhereHandler, this);
					f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpSomewhereHandler, this);
					if (this.mouseDownTarget != a.target && a instanceof d.TouchEvent && this.contains(a.target)) {
						var b = a.target.localToGlobal(a.localX, a.localY);
						d.TouchEvent.dispatchTouchEvent(this, d.TouchEvent.TOUCH_TAP, a.touchPointID, b.x, b.y, a.ctrlKey, a.altKey, a.shiftKey, a.touchDown)
					}
					this.mouseDownTarget = null
				};
				return c
			}(f.Range);
		f.TrackBase = g;
		g.prototype.__class__ = "egret.gui.TrackBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.trackHighlight = null;
					this._showTrackHighlight = !0;
					this.animator = null;
					this._pendingValue = 0;
					this.slideToValue = NaN;
					this._liveDragging = !0;
					this.maximum = 10
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "showTrackHighlight", {
					get: function() {
						return this._showTrackHighlight
					},
					set: function(a) {
						this._showTrackHighlight != a && (this._showTrackHighlight = a, this.trackHighlight && (this.trackHighlight.visible = a), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "pendingValue", {
					get: function() {
						return this._pendingValue
					},
					set: function(a) {
						a != this._pendingValue && (this._pendingValue = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.setValue = function(a) {
					this._pendingValue = a;
					e.prototype.setValue.call(this, a)
				};
				b._animationUpdateHandler = function(a) {
					this.pendingValue = a.currentValue.value
				};
				b.animationEndHandler = function(a) {
					this.setValue(this.slideToValue);
					this.dispatchEventWith(d.Event.CHANGE);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_END)
				};
				b.stopAnimation = function() {
					this.animator.stop();
					this.setValue(this.nearestValidValue(this.pendingValue, this.snapInterval));
					this.dispatchEventWith(d.Event.CHANGE);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_END)
				};
				b.thumb_mouseDownHandler = function(a) {
					this.animator && this.animator.isPlaying && this.stopAnimation();
					e.prototype.thumb_mouseDownHandler.call(this, a)
				};
				Object.defineProperty(b, "liveDragging", {
					get: function() {
						return this._liveDragging
					},
					set: function(a) {
						this._liveDragging = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.updateWhenMouseMove = function() {
					if (this.track) {
						var a = this.track.globalToLocal(this._moveStageX, this._moveStageY, d.Point.identity),
							a = this.pointToValue(a.x - this._clickOffsetX, a.y - this._clickOffsetY),
							a = this.nearestValidValue(a, this.snapInterval);
						a != this.pendingValue && (f.TrackBaseEvent.dispatchTrackBaseEvent(this, f.TrackBaseEvent.THUMB_DRAG), !0 == this.liveDragging ? (this.setValue(a), this.dispatchEventWith(d.Event.CHANGE)) : this.pendingValue = a)
					}
				};
				b.stage_mouseUpHandler = function(a) {
					e.prototype.stage_mouseUpHandler.call(this, a);
					!1 == this.liveDragging && this.value != this.pendingValue && (this.setValue(this.pendingValue), this.dispatchEventWith(d.Event.CHANGE))
				};
				b.track_mouseDownHandler = function(a) {
					this.enabled && (a = this.track.globalToLocal(a.stageX - (this.thumb ? this.thumb.width : 0) / 2, a.stageY - (this.thumb ? this.thumb.height : 0) / 2, d.Point.identity), a = this.pointToValue(a.x, a.y), a = this.nearestValidValue(a, this.snapInterval), a != this.pendingValue && (0 != this.slideDuration ? (this.animator || (this.animator = new f.Animation(this._animationUpdateHandler, this), this.animator.endFunction = this.animationEndHandler), this.animator.isPlaying && this.stopAnimation(), this.slideToValue = a, this.animator.duration = this.slideDuration * (Math.abs(this.pendingValue - this.slideToValue) / (this.maximum - this.minimum)), this.animator.motionPaths = [new f.SimpleMotionPath("value", this.pendingValue, this.slideToValue)], f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_START), this.animator.play()) : (this.setValue(a), this.dispatchEventWith(d.Event.CHANGE))))
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.trackHighlight && (this.trackHighlight.touchEnabled = !1, this.trackHighlight instanceof d.DisplayObjectContainer && (this.trackHighlight.touchChildren = !1), this.trackHighlight.visible = this._showTrackHighlight)
				};
				return c
			}(f.TrackBase);
		f.SliderBase = g;
		g.prototype.__class__ = "egret.gui.SliderBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._focusEnabled = !0;
					this.textDisplay = null;
					this.textDisplayProperties = {};
					this._prompt = this.promptDisplay = null;
					this.focusEnabled = !0;
					this.addEventListener("focus", this.focusInHandler, this);
					this.addEventListener("blur", this.focusOutHandler, this)
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "focusEnabled", {
					get: function() {
						return this._focusEnabled
					},
					set: function(a) {
						this._focusEnabled = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.focusInHandler = function(a) {
					a.target == this ? this.setFocus() : this.invalidateSkinState()
				};
				b.focusOutHandler = function(a) {
					a.target != this && this.invalidateSkinState()
				};
				Object.defineProperty(b, "prompt", {
					get: function() {
						return this._prompt
					},
					set: function(a) {
						this._prompt != a && (this._prompt = a, this.promptDisplay && (this.promptDisplay.text = a), this.invalidateProperties(), this.invalidateSkinState())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maxWidth", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.maxWidth;
						var a = this.textDisplayProperties.maxWidth;
						return void 0 === a ? e.prototype._getMaxWidth.call(this) : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.maxWidth = a, this.textDisplayProperties.maxWidth = !0) : this.textDisplayProperties.maxWidth = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "textColor", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.textColor;
						var a = this.textDisplayProperties.textColor;
						return void 0 === a ? 0 : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.textColor = a, this.textDisplayProperties.textColor = !0) : this.textDisplayProperties.textColor = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "displayAsPassword", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.displayAsPassword;
						var a = this.textDisplayProperties.displayAsPassword;
						return void 0 === a ? !1 : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.displayAsPassword = a, this.textDisplayProperties.displayAsPassword = !0) : this.textDisplayProperties.displayAsPassword = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "editable", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.editable;
						var a = this.textDisplayProperties.editable;
						return void 0 === a ? !0 : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.editable = a, this.textDisplayProperties.editable = !0) : this.textDisplayProperties.editable = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maxChars", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.maxChars;
						var a = this.textDisplayProperties.maxChars;
						return void 0 === a ? 0 : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.maxChars = a, this.textDisplayProperties.maxChars = !0) : this.textDisplayProperties.maxChars = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "restrict", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.restrict;
						var a = this.textDisplayProperties.restrict;
						return void 0 === a ? null : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.restrict = a, this.textDisplayProperties.restrict = !0) : this.textDisplayProperties.restrict = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectable", {
					get: function() {
						if (this.textDisplay) return this.textDisplay.selectable;
						var a = this.textDisplayProperties.selectable;
						return void 0 === a ? !0 : a
					},
					set: function(a) {
						this.textDisplay ? (this.textDisplay.selectable = a, this.textDisplayProperties.selectable = !0) : this.textDisplayProperties.selectable = a;
						this.invalidateProperties()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectionBeginIndex", {
					get: function() {
						return this.textDisplay ? this.textDisplay.selectionBeginIndex : void 0 === this.textDisplayProperties.selectionBeginIndex ? -1 : this.textDisplayProperties.selectionBeginIndex
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectionEndIndex", {
					get: function() {
						return this.textDisplay ? this.textDisplay.selectionEndIndex : void 0 === this.textDisplayProperties.selectionEndIndex ? -1 : this.textDisplayProperties.selectionEndIndex
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "caretIndex", {
					get: function() {
						return this.textDisplay ? this.textDisplay.caretIndex : 0
					},
					enumerable: !0,
					configurable: !0
				});
				b.setSelection = function(a, b) {
					void 0 === b && (b = 0);
					this.textDisplay ? this.textDisplay.setSelection(a, b) : (this.textDisplayProperties.selectionBeginIndex = a, this.textDisplayProperties.selectionEndIndex = b)
				};
				b.selectAll = function() {
					this.textDisplay ? this.textDisplay.selectAll() : void 0 !== this.textDisplayProperties.text && this.setSelection(0, this.textDisplayProperties.text.length - 1)
				};
				Object.defineProperty(b, "text", {
					get: function() {
						return this._getText()
					},
					set: function(a) {
						this._setText(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getText = function() {
					if (this.textDisplay) return this.textDisplay.text;
					var a = this.textDisplayProperties.text;
					return void 0 === a ? "" : a
				};
				b._setText = function(a) {
					this.textDisplay ? (this.textDisplay.text = a, this.textDisplayProperties.text = !0) : (this.textDisplayProperties.text = a, this.textDisplayProperties.selectionBeginIndex = 0, this.textDisplayProperties.selectionEndIndex = 0);
					this.invalidateProperties();
					this.invalidateSkinState()
				};
				b._getWidthInChars = function() {
					var a = this.textDisplay;
					if (a) return a.widthInChars;
					a = this.textDisplay ? void 0 : this.textDisplayProperties.widthInChars;
					return void 0 === a ? NaN : a
				};
				b._setWidthInChars = function(a) {
					if (this.textDisplay) {
						var b = this.textDisplay;
						b && (b.widthInChars = a);
						this.textDisplayProperties.widthInChars = !0
					} else this.textDisplayProperties.widthInChars = a;
					this.invalidateProperties()
				};
				b._getHeightInLines = function() {
					var a = this.textDisplay;
					if (a) return a.heightInLines;
					a = this.textDisplay ? void 0 : this.textDisplayProperties.heightInLines;
					return void 0 === a ? NaN : a
				};
				b._setHeightInLines = function(a) {
					if (this.textDisplay) {
						var b = this.textDisplay;
						b && (b.heightInLines = a);
						this.textDisplayProperties.heightInLines = !0
					} else this.textDisplayProperties.heightInLines = a;
					this.invalidateProperties()
				};
				b.getCurrentSkinState = function() {
					var a = f.UIGlobals.stage.focus,
						b = this.skin;
					if (this._prompt && !(a && this.contains(a) || "" != this.text)) {
						if (this.enabled && b.hasState("normalWithPrompt")) return "normalWithPrompt";
						if (!this.enabled && b.hasState("disabledWithPrompt")) return "disabledWithPrompt"
					}
					return e.prototype.getCurrentSkinState.call(this)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.textDisplay ? (this.textDisplayAdded(), this.textDisplay.addEventListener("input", this.textDisplay_changingHandler, this), this.textDisplay.addEventListener(d.Event.CHANGE, this.textDisplay_changeHandler, this)) : b == this.promptDisplay && (this.promptDisplay.text = this._prompt)
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.textDisplay && (this.textDisplayRemoved(), this.textDisplay.removeEventListener("input", this.textDisplay_changingHandler, this), this.textDisplay.removeEventListener(d.Event.CHANGE, this.textDisplay_changeHandler, this))
				};
				b.setFocus = function() {
					!1 != this._focusEnabled && this.textDisplay && this.textDisplay.setFocus()
				};
				b._createTextDisplay = function() {};
				b._removeSkinParts = function() {
					this.textDisplay && (this.partRemoved("textDisplay", this.textDisplay), this._removeFromDisplayList(this.textDisplay), this.textDisplay = null)
				};
				b.textDisplayAdded = function() {
					var a = {},
						b = this.textDisplay;
					void 0 !== this.textDisplayProperties.displayAsPassword && (this.textDisplay.displayAsPassword = this.textDisplayProperties.displayAsPassword, a.displayAsPassword = !0);
					void 0 !== this.textDisplayProperties.textColor && (this.textDisplay.textColor = this.textDisplayProperties.textColor, a.textColor = !0);
					void 0 !== this.textDisplayProperties.editable && (this.textDisplay.editable = this.textDisplayProperties.editable, a.editable = !0);
					void 0 !== this.textDisplayProperties.maxChars && (this.textDisplay.maxChars = this.textDisplayProperties.maxChars, a.maxChars = !0);
					void 0 !== this.textDisplayProperties.maxHeight && (this.textDisplay.maxHeight = this.textDisplayProperties.maxHeight, a.maxHeight = !0);
					void 0 !== this.textDisplayProperties.maxWidth && (this.textDisplay.maxWidth = this.textDisplayProperties.maxWidth, a.maxWidth = !0);
					void 0 !== this.textDisplayProperties.restrict && (this.textDisplay.restrict = this.textDisplayProperties.restrict, a.restrict = !0);
					void 0 !== this.textDisplayProperties.selectable && (this.textDisplay.selectable = this.textDisplayProperties.selectable, a.selectable = !0);
					void 0 !== this.textDisplayProperties.text && (this.textDisplay.text = this.textDisplayProperties.text, a.text = !0);
					void 0 !== this.textDisplayProperties.selectionBeginIndex && this.textDisplay.setSelection(this.textDisplayProperties.selectionBeginIndex, this.textDisplayProperties.selectionEndIndex);
					void 0 !== this.textDisplayProperties.widthInChars && b && (b.widthInChars = this.textDisplayProperties.widthInChars, a.widthInChars = !0);
					void 0 !== this.textDisplayProperties.heightInLines && b && (b.heightInLines = this.textDisplayProperties.heightInLines, a.heightInLines = !0);
					this.textDisplayProperties = a
				};
				b.textDisplayRemoved = function() {
					var a = {},
						b = this.textDisplay;
					this.textDisplayProperties.displayAsPassword && (a.displayAsPassword = this.textDisplay.displayAsPassword);
					this.textDisplayProperties.textColor && (a.textColor = this.textDisplay.textColor);
					this.textDisplayProperties.editable && (a.editable = this.textDisplay.editable);
					this.textDisplayProperties.maxChars && (a.maxChars = this.textDisplay.maxChars);
					this.textDisplayProperties.maxHeight && (a.maxHeight = this.textDisplay.maxHeight);
					this.textDisplayProperties.maxWidth && (a.maxWidth = this.textDisplay.maxWidth);
					this.textDisplayProperties.restrict && (a.restrict = this.textDisplay.restrict);
					this.textDisplayProperties.selectable && (a.selectable = this.textDisplay.selectable);
					this.textDisplayProperties.text && (a.text = this.textDisplay.text);
					this.textDisplayProperties.heightInLines && b && (a.heightInLines = b.heightInLines);
					this.textDisplayProperties.widthInChars && b && (a.widthInChars = b.widthInChars);
					this.textDisplayProperties = a
				};
				b.textDisplay_changeHandler = function(a) {
					this.invalidateDisplayList();
					this.dispatchEvent(a)
				};
				b.textDisplay_changingHandler = function(a) {
					var b = new d.Event(a.type, !1, !0);
					b.data = a.data;
					this.dispatchEvent(b);
					b.isDefaultPrevented() && a.preventDefault()
				};
				return c
			}(f.SkinnableComponent);
		f.SkinnableTextBase = g;
		g.prototype.__class__ = "egret.gui.SkinnableTextBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				return c
			}(d.UIComponent);
		d.Spacer = g;
		g.prototype.__class__ = "egret.gui.Spacer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._maxDisplayedLines = 0;
					this.lastUnscaledWidth = NaN;
					this.strokeColorChanged = !1;
					this._stroke = this._strokeColor = 0;
					this.strokeChanged = !1;
					this._padding = 0;
					this._paddingBottom = this._paddingTop = this._paddingRight = this._paddingLeft = NaN;
					this.addEventListener(d.UIEvent.UPDATE_COMPLETE, this.updateCompleteHandler, this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.updateCompleteHandler = function(a) {
					this.lastUnscaledWidth = NaN
				};
				Object.defineProperty(b, "maxDisplayedLines", {
					get: function() {
						return this._maxDisplayedLines
					},
					set: function(a) {
						this._maxDisplayedLines != a && (this._maxDisplayedLines = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "strokeColor", {
					get: function() {
						return this._strokeColor
					},
					set: function(a) {
						this._setStrokeColor(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setStrokeColor = function(a) {
					this._strokeColor != a && (this._strokeColor = a, this.strokeColorChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "stroke", {
					get: function() {
						return this._stroke
					},
					set: function(a) {
						this._stroke != a && (this._stroke = a, this.strokeChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "padding", {
					get: function() {
						return this._padding
					},
					set: function(a) {
						this._padding != a && (this._padding = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingLeft", {
					get: function() {
						return this._paddingLeft
					},
					set: function(a) {
						this._paddingLeft != a && (this._paddingLeft = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingRight", {
					get: function() {
						return this._paddingRight
					},
					set: function(a) {
						this._paddingRight != a && (this._paddingRight = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingTop", {
					get: function() {
						return this._paddingTop
					},
					set: function(a) {
						this._paddingTop != a && (this._paddingTop = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingBottom", {
					get: function() {
						return this._paddingBottom
					},
					set: function(a) {
						this._paddingBottom != a && (this._paddingBottom = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.strokeColorChanged && (this._textField.strokeColor = this._strokeColor, this.strokeColorChanged = !1);
					this.strokeChanged && (this._textField.stroke = this._stroke, this.strokeChanged = !1)
				};
				b.measure = function() {
					this._invalidatePropertiesFlag && this.validateProperties();
					if (this.isSpecialCase()) if (isNaN(this.lastUnscaledWidth)) this._oldPreferHeight = this._oldPreferWidth = NaN;
					else {
						this.measureUsingWidth(this.lastUnscaledWidth);
						return
					}
					var a;
					isNaN(this.explicitWidth) ? 1E4 != this.maxWidth && (a = this.maxWidth) : a = this.explicitWidth;
					this.measureUsingWidth(a)
				};
				b.isSpecialCase = function() {
					return 1 != this._maxDisplayedLines && (!isNaN(this.percentWidth) || !isNaN(this.left) && !isNaN(this.right)) && isNaN(this.explicitHeight) && isNaN(this.percentHeight)
				};
				b.measureUsingWidth = function(a) {
					this._textChanged && (this._textField.text = this._text);
					this._textFlowChanged && (this._textField.textFlow = this._textFlow);
					var b = isNaN(this._padding) ? 0 : this._padding,
						c = isNaN(this._paddingLeft) ? b : this._paddingLeft,
						e = isNaN(this._paddingRight) ? b : this._paddingRight,
						d = isNaN(this._paddingTop) ? b : this._paddingTop,
						b = isNaN(this._paddingBottom) ? b : this._paddingBottom;
					this._textField.width = NaN;
					this._textField.height = NaN;
					isNaN(a) || (this._textField.width = a - c - e);
					this.measuredWidth = Math.ceil(this._textField.measuredWidth);
					this.measuredHeight = Math.ceil(this._textField.measuredHeight);
					0 < this._maxDisplayedLines && this._textField.numLines > this._maxDisplayedLines && (a = this._textField.lineSpacing, this.measuredHeight = (this._textField.size + a) * this._maxDisplayedLines - a);
					this.measuredWidth += c + e;
					this.measuredHeight += d + b
				};
				b.updateDisplayList = function(a, b) {
					this.$updateDisplayList(a, b);
					var c = isNaN(this._padding) ? 0 : this._padding,
						e = isNaN(this._paddingLeft) ? c : this._paddingLeft,
						d = isNaN(this._paddingRight) ? c : this._paddingRight,
						f = isNaN(this._paddingTop) ? c : this._paddingTop,
						c = isNaN(this._paddingBottom) ? c : this._paddingBottom;
					this._textField.x = e;
					this._textField.y = f;
					if (this.isSpecialCase()) {
						var g = isNaN(this.lastUnscaledWidth) || this.lastUnscaledWidth != a;
						this.lastUnscaledWidth = a;
						if (g) {
							this._oldPreferHeight = this._oldPreferWidth = NaN;
							this.invalidateSize();
							return
						}
					}
					this._invalidateSizeFlag && this.validateSize();
					this._textField.visible || (this._textField.visible = !0);
					this._textField.width = a - e - d;
					e = b - f - c;
					this._textField.height = e;
					0 < this._maxDisplayedLines && this._textField.numLines > this._maxDisplayedLines && (d = this._textField.lineSpacing, this._textField.height = Math.min(e, (this._textField.size + d) * this._maxDisplayedLines - d))
				};
				return c
			}(d.TextBase);
		d.Label = g;
		g.prototype.__class__ = "egret.gui.Label"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._bitmapText = null;
					this._textChanged = !1;
					this._text = "";
					this.createChildrenCalled = this.fontChanged = !1;
					this.lastUnscaledWidth = NaN;
					this._padding = 0;
					this._paddingBottom = this._paddingTop = this._paddingRight = this._paddingLeft = NaN;
					this.addEventListener(f.UIEvent.UPDATE_COMPLETE, this.updateCompleteHandler, this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.updateCompleteHandler = function(a) {
					this.lastUnscaledWidth = NaN
				};
				Object.defineProperty(b, "text", {
					get: function() {
						return this._text
					},
					set: function(a) {
						this._text != a && (this._text = a, this._textChanged = !0, this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "font", {
					get: function() {
						return this._font
					},
					set: function(a) {
						this._font != a && (this._font = a, this.createChildrenCalled ? this.parseFont() : this.fontChanged = !0, this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this._bitmapText || this.checkBitmapText();
					this.fontChanged && this.parseFont();
					this.createChildrenCalled = !0
				};
				b.parseFont = function() {
					this.fontChanged = !1;
					var a = c.assetAdapter;
					a || (a = this.getAdapter());
					if (this._font) a.getAsset(this._font, this.onFontChanged, this, null);
					else this.onFontChanged(null, null)
				};
				b.getAdapter = function() {
					var a;
					try {
						a = d.Injector.getInstance("egret.gui.IAssetAdapter")
					} catch (b) {
						a = new f.DefaultAssetAdapter
					}
					return c.assetAdapter = a
				};
				b.onFontChanged = function(a, b) {
					b === this._font && (this._bitmapText.font = a, this.invalidateSize(), this.invalidateDisplayList())
				};
				Object.defineProperty(b, "padding", {
					get: function() {
						return this._padding
					},
					set: function(a) {
						this._padding != a && (this._padding = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingLeft", {
					get: function() {
						return this._paddingLeft
					},
					set: function(a) {
						this._paddingLeft != a && (this._paddingLeft = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingRight", {
					get: function() {
						return this._paddingRight
					},
					set: function(a) {
						this._paddingRight != a && (this._paddingRight = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingTop", {
					get: function() {
						return this._paddingTop
					},
					set: function(a) {
						this._paddingTop != a && (this._paddingTop = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingBottom", {
					get: function() {
						return this._paddingBottom
					},
					set: function(a) {
						this._paddingBottom != a && (this._paddingBottom = a, this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.measure = function() {
					this._invalidatePropertiesFlag && this.validateProperties();
					if (this.isSpecialCase()) if (isNaN(this.lastUnscaledWidth)) this._oldPreferHeight = this._oldPreferWidth = NaN;
					else {
						this.measureUsingWidth(this.lastUnscaledWidth);
						return
					}
					var a;
					isNaN(this.explicitWidth) ? 1E4 != this.maxWidth && (a = this.maxWidth) : a = this.explicitWidth;
					this.measureUsingWidth(a)
				};
				b.isSpecialCase = function() {
					return (!isNaN(this.percentWidth) || !isNaN(this.left) && !isNaN(this.right)) && isNaN(this.explicitHeight) && isNaN(this.percentHeight)
				};
				b.measureUsingWidth = function(a) {
					this._textChanged && (this._bitmapText.text = this._text);
					var b = isNaN(this._padding) ? 0 : this._padding,
						c = isNaN(this._paddingLeft) ? b : this._paddingLeft,
						e = isNaN(this._paddingRight) ? b : this._paddingRight,
						d = isNaN(this._paddingTop) ? b : this._paddingTop,
						b = isNaN(this._paddingBottom) ? b : this._paddingBottom;
					this._bitmapText.width = NaN;
					this._bitmapText.height = NaN;
					isNaN(a) || (this._bitmapText.width = a - c - e);
					this.measuredWidth = Math.ceil(this._bitmapText.measuredWidth);
					this.measuredHeight = Math.ceil(this._bitmapText.measuredHeight);
					this.measuredWidth += c + e;
					this.measuredHeight += d + b
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					if (this._bitmapText) {
						var c = isNaN(this._padding) ? 0 : this._padding,
							d = isNaN(this._paddingLeft) ? c : this._paddingLeft,
							f = isNaN(this._paddingRight) ? c : this._paddingRight,
							g = isNaN(this._paddingTop) ? c : this._paddingTop,
							c = isNaN(this._paddingBottom) ? c : this._paddingBottom;
						this._bitmapText.x = d;
						this._bitmapText.y = g;
						if (this.isSpecialCase()) {
							var k = isNaN(this.lastUnscaledWidth) || this.lastUnscaledWidth != a;
							this.lastUnscaledWidth = a;
							if (k) {
								this._oldPreferHeight = this._oldPreferWidth = NaN;
								this.invalidateSize();
								return
							}
						}
						this._invalidateSizeFlag && this.validateSize();
						this._bitmapText.visible || (this._bitmapText.visible = !0);
						this._bitmapText.width = a - d - f;
						this._bitmapText.height = b - g - c
					}
				};
				b.checkBitmapText = function() {
					this._bitmapText || (this._bitmapText = new d.BitmapText, this._bitmapText.text = this._text, this._textChanged = !1, this._addToDisplayList(this._bitmapText))
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this._bitmapText || this.checkBitmapText();
					this._textChanged && (this._bitmapText.text = this._text, this._textChanged = !1)
				};
				return c
			}(f.UIComponent);
		f.BitmapLabel = g;
		g.prototype.__class__ = "egret.gui.BitmapLabel"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._graphics = null;
					this._fillColor = 16777215;
					this._fillAlpha = 1;
					this._strokeColor = 4473924;
					this._strokeAlpha = 0;
					this._strokeWeight = 1;
					this.touchChildren = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "graphics", {
					get: function() {
						this._graphics || (this._graphics = new d.Graphics, this.needDraw = !0);
						return this._graphics
					},
					enumerable: !0,
					configurable: !0
				});
				b._render = function(a) {
					this._graphics && this._graphics._draw(a);
					e.prototype._render.call(this, a)
				};
				Object.defineProperty(b, "fillColor", {
					get: function() {
						return this._fillColor
					},
					set: function(a) {
						this._fillColor != a && (this._fillColor = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "fillAlpha", {
					get: function() {
						return this._fillAlpha
					},
					set: function(a) {
						this._fillAlpha != a && (this._fillAlpha = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "strokeColor", {
					get: function() {
						return this._strokeColor
					},
					set: function(a) {
						this._strokeColor != a && (this._strokeColor = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "strokeAlpha", {
					get: function() {
						return this._strokeAlpha
					},
					set: function(a) {
						this._strokeAlpha != a && (this._strokeAlpha = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "strokeWeight", {
					get: function() {
						return this._strokeWeight
					},
					set: function(a) {
						this._strokeWeight != a && (this._strokeWeight = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b._measureBounds = function() {
					var a = e.prototype._measureBounds.call(this),
						b = this.width,
						c = this.height;
					0 < a.x && (a.x = 0);
					0 < a.y && (a.y = 0);
					0 + b > a.right && (a.right = 0 + b);
					0 + c > a.bottom && (a.bottom = 0 + c);
					return a
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, a);
					var c = this.graphics;
					c.clear();
					c.beginFill(this._fillColor, this._fillAlpha);
					0 < this._strokeAlpha && c.lineStyle(this._strokeWeight, this._strokeColor, this._strokeAlpha, !0, "normal", "square", "miter");
					c.drawRect(0, 0, a, b);
					c.endFill()
				};
				b.hitTest = function(a, b, c) {
					void 0 === c && (c = !1);
					var f = e.prototype.hitTest.call(this, a, b, c);
					return f ? f : this._graphics ? d.DisplayObject.prototype.hitTest.call(this, a, b, c) : null
				};
				return c
			}(f.UIComponent);
		f.Rect = g;
		g.prototype.__class__ = "egret.gui.Rect"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._icon = this.iconDisplay = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "icon", {
					get: function() {
						return this._getIcon()
					},
					set: function(a) {
						this._setIcon(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getIcon = function() {
					return this.iconDisplay ? this.iconDisplay.source : this._icon
				};
				b._setIcon = function(a) {
					this._icon = a;
					this.iconDisplay && (this.iconDisplay.source = a)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.iconDisplay && (this.iconDisplay.source = this._icon)
				};
				return c
			}(d.ButtonBase);
		d.Button = g;
		g.prototype.__class__ = "egret.gui.Button"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				return c
			}(d.ToggleButtonBase);
		d.ToggleSwitch = g;
		g.prototype.__class__ = "egret.gui.ToggleSwitch"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._icon = this.iconDisplay = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "icon", {
					get: function() {
						return this._getIcon()
					},
					set: function(a) {
						this._setIcon(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getIcon = function() {
					return this.iconDisplay ? this.iconDisplay.source : this._icon
				};
				b._setIcon = function(a) {
					this._icon = a;
					this.iconDisplay && (this.iconDisplay.source = a)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.iconDisplay && (this.iconDisplay.source = this._icon)
				};
				return c
			}(d.ToggleButtonBase);
		d.ToggleButton = g;
		g.prototype.__class__ = "egret.gui.ToggleButton"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				return c
			}(d.ToggleButtonBase);
		d.CheckBox = g;
		g.prototype.__class__ = "egret.gui.CheckBox"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._name = null;
					this.radioButtons = [];
					this._enabled = !0;
					this._selection = this._selectedValue = null;
					this._name = "_radioButtonGroup" + c.groupCount;
					c.groupCount++
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "enabled", {
					get: function() {
						return this._enabled
					},
					set: function(a) {
						if (this._enabled != a) for (this._enabled = a, a = 0; a < this.numRadioButtons; a++) this.getRadioButtonAt(a).invalidateSkinState()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "numRadioButtons", {
					get: function() {
						return this.radioButtons.length
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedValue", {
					get: function() {
						return this.selection ? null != this.selection.value ? this.selection.value : this.selection.label : null
					},
					set: function(a) {
						this._selectedValue = a;
						if (null == a) this._setSelection(null, !1);
						else for (var b = this.numRadioButtons, c = 0; c < b; c++) {
							var e = this.getRadioButtonAt(c);
							if (e.value == a || e.label == a) {
								this.changeSelection(c, !1);
								this._selectedValue = null;
								f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT);
								break
							}
						}
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selection", {
					get: function() {
						return this._selection
					},
					set: function(a) {
						this._selection != a && this._setSelection(a, !1)
					},
					enumerable: !0,
					configurable: !0
				});
				b.getRadioButtonAt = function(a) {
					return 0 <= a && a < this.numRadioButtons ? this.radioButtons[a] : null
				};
				b._addInstance = function(a) {
					function b(a, c) {
						var e = a.parent,
							d = c.parent;
						if (!e || !d) return 0;
						var g = a instanceof f.UIComponent ? a.nestLevel : -1,
							u = c instanceof f.UIComponent ? c.nestLevel : -1,
							n = 0,
							p = 0;
						e == d && (n = "getElementIndex" in e && "ownerChanged" in a ? e.getElementIndex(a) : e.getChildIndex(a), p = "getElementIndex" in d && "ownerChanged" in c ? d.getElementIndex(c) : d.getChildIndex(c));
						return g > u || n > p ? 1 : g < u || p > n ? -1 : a == c ? 0 : b(e, d)
					}
					a.addEventListener(d.Event.REMOVED, this.radioButton_removedHandler, this);
					this.radioButtons.push(a);
					this.radioButtons.sort(b);
					for (var c = 0; c < this.radioButtons.length; c++) this.radioButtons[c]._indexNumber = c;
					this._selectedValue && (this.selectedValue = this._selectedValue);
					!0 == a.selected && (this.selection = a);
					a._radioButtonGroup = this;
					a.invalidateSkinState();
					this.dispatchEventWith("numRadioButtonsChanged")
				};
				b._removeInstance = function(a) {
					this.doRemoveInstance(a, !1)
				};
				b.doRemoveInstance = function(a, b) {
					void 0 === b && (b = !0);
					if (a) {
						for (var c = !1, e = 0; e < this.numRadioButtons; e++) {
							var f = this.getRadioButtonAt(e);
							c ? f._indexNumber -= 1 : f == a && (b && a.addEventListener(d.Event.ADDED, this.radioButton_addedHandler, this), a == this._selection && (this._selection = null), a._radioButtonGroup = null, a.invalidateSkinState(), this.radioButtons.splice(e, 1), c = !0, e--)
						}
						c && this.dispatchEventWith("numRadioButtonsChanged")
					}
				};
				b._setSelection = function(a, b) {
					void 0 === b && (b = !0);
					if (this._selection != a) {
						if (a) for (var c = this.numRadioButtons, e = 0; e < c; e++) {
							if (a == this.getRadioButtonAt(e)) {
								this.changeSelection(e, b);
								break
							}
						} else this.selection && (this._selection.selected = !1, this._selection = null, b && this.dispatchEventWith(d.Event.CHANGE));
						f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT)
					}
				};
				b.changeSelection = function(a, b) {
					void 0 === b && (b = !0);
					var c = this.getRadioButtonAt(a);
					c && c != this._selection && (this._selection && (this._selection.selected = !1), this._selection = c, this._selection.selected = !0, b && this.dispatchEventWith(d.Event.CHANGE))
				};
				b.radioButton_addedHandler = function(a) {
					if (a = a.target) a.removeEventListener(d.Event.ADDED, this.radioButton_addedHandler, this), this._addInstance(a)
				};
				b.radioButton_removedHandler = function(a) {
					if (a = a.target) a.removeEventListener(d.Event.REMOVED, this.radioButton_removedHandler, this), this.doRemoveInstance(a)
				};
				c.groupCount = 0;
				return c
			}(d.EventDispatcher);
		f.RadioButtonGroup = g;
		g.prototype.__class__ = "egret.gui.RadioButtonGroup"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._indexNumber = 0;
					this._group = this._radioButtonGroup = null;
					this.groupChanged = !1;
					this._groupName = "radioGroup";
					this._value = null;
					this.groupName = "radioGroup"
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "enabled", {
					get: function() {
						return this._enabled ? !this._radioButtonGroup || this._radioButtonGroup.enabled : !1
					},
					set: function(a) {
						this._setEnabled(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "group", {
					get: function() {
						if (!this._group && this._groupName) {
							c.automaticRadioButtonGroups || (c.automaticRadioButtonGroups = {});
							var a = c.automaticRadioButtonGroups[this._groupName];
							a || (a = new d.RadioButtonGroup, a._name = this._groupName, c.automaticRadioButtonGroups[this._groupName] = a);
							this._group = a
						}
						return this._group
					},
					set: function(a) {
						this._group != a && (this._radioButtonGroup && this._radioButtonGroup._removeInstance(this), this._groupName = (this._group = a) ? this.group._name : "radioGroup", this.groupChanged = !0, this.invalidateProperties(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "groupName", {
					get: function() {
						return this._groupName
					},
					set: function(a) {
						a && "" != a && (this._groupName = a, this._radioButtonGroup && this._radioButtonGroup._removeInstance(this), this._group = null, this.groupChanged = !0, this.invalidateProperties(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSelected = function(a) {
					e.prototype._setSelected.call(this, a);
					this.invalidateDisplayList()
				};
				Object.defineProperty(b, "value", {
					get: function() {
						return this._value
					},
					set: function(a) {
						this._value != a && (this._value = a, this.selected && this.group && d.UIEvent.dispatchUIEvent(this.group, d.UIEvent.VALUE_COMMIT))
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					this.groupChanged && (this.addToGroup(), this.groupChanged = !1);
					e.prototype.commitProperties.call(this)
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this.group && (this.selected ? this._group.selection = this : this.group.selection == this && (this._group.selection = null))
				};
				b.buttonReleased = function() {
					this.enabled && !this.selected && (this._radioButtonGroup || this.addToGroup(), e.prototype.buttonReleased.call(this), this.group._setSelection(this))
				};
				b.addToGroup = function() {
					var a = this.group;
					a && a._addInstance(this);
					return a
				};
				c.automaticRadioButtonGroups = null;
				return c
			}(d.ToggleButtonBase);
		d.RadioButton = g;
		g.prototype.__class__ = "egret.gui.RadioButton"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.elementsContentChanged = this.createChildrenCalled = !1;
					this._elementsContent = []
				}
				__extends(c, e);
				var b = c.prototype;
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					this.createChildrenCalled = !0;
					this.elementsContentChanged && (this.elementsContentChanged = !1, this.setElementsContent(this._elementsContent))
				};
				b._getElementsContent = function() {
					return this._elementsContent
				};
				Object.defineProperty(b, "elementsContent", {
					set: function(a) {
						null == a && (a = []);
						if (a != this._elementsContent) if (this.createChildrenCalled) this.setElementsContent(a);
						else {
							this.elementsContentChanged = !0;
							for (var b = this._elementsContent.length - 1; 0 <= b; b--) this._elementRemoved(this._elementsContent[b], b);
							this._elementsContent = a
						}
					},
					enumerable: !0,
					configurable: !0
				});
				b.setElementsContent = function(a) {
					var b;
					for (b = this._elementsContent.length - 1; 0 <= b; b--) this._elementRemoved(this._elementsContent[b], b);
					this._elementsContent = a.concat();
					a = this._elementsContent.length;
					for (b = 0; b < a; b++) {
						var c = this._elementsContent[b];
						c.parent && "removeElement" in c.parent ? c.parent.removeElement(c) : c.owner && "removeElement" in c.owner && c.owner.removeElement(c);
						this._elementAdded(c, b)
					}
				};
				Object.defineProperty(b, "numElements", {
					get: function() {
						return this._elementsContent.length
					},
					enumerable: !0,
					configurable: !0
				});
				b.getElementAt = function(a) {
					this.checkForRangeError(a);
					return this._elementsContent[a]
				};
				b.checkForRangeError = function(a, b) {
					void 0 === b && (b = !1);
					var c = this._elementsContent.length - 1;
					b && c++;
					if (0 > a || a > c) throw new RangeError(d.getString(3011, a));
				};
				b.addElement = function(a) {
					var b = this.numElements;
					a.parent == this && (b = this.numElements - 1);
					return this.addElementAt(a, b)
				};
				b.addElementAt = function(a, b) {
					if (a == this) return a;
					this.checkForRangeError(b, !0);
					var c = a.owner;
					if (c == this || a.parent == this) return this.setElementIndex(a, b), a;
					c && "removeElement" in c && a.owner.removeElement(a);
					this._elementsContent.splice(b, 0, a);
					this.elementsContentChanged || this._elementAdded(a, b);
					return a
				};
				b.removeElement = function(a) {
					return this.removeElementAt(this.getElementIndex(a))
				};
				b.removeElementAt = function(a) {
					this.checkForRangeError(a);
					var b = this._elementsContent[a];
					this.elementsContentChanged || this._elementRemoved(b, a);
					this._elementsContent.splice(a, 1);
					return b
				};
				b.removeAllElements = function() {
					for (var a = this.numElements - 1; 0 <= a; a--) this.removeElementAt(a)
				};
				b.getElementIndex = function(a) {
					return this._elementsContent.indexOf(a)
				};
				b.setElementIndex = function(a, b) {
					this.checkForRangeError(b);
					var c = this.getElementIndex(a); - 1 != c && c != b && (this.elementsContentChanged || this._elementRemoved(a, c, !1), this._elementsContent.splice(c, 1), this._elementsContent.splice(b, 0, a), this.elementsContentChanged || this._elementAdded(a, b, !1))
				};
				b.swapElements = function(a, b) {
					this.swapElementsAt(this.getElementIndex(a), this.getElementIndex(b))
				};
				b.swapElementsAt = function(a, b) {
					this.checkForRangeError(a);
					this.checkForRangeError(b);
					if (a > b) {
						var c = b;
						b = a;
						a = c
					} else if (a == b) return;
					var c = this._elementsContent,
						e = c[a],
						d = c[b];
					this.elementsContentChanged || (this._elementRemoved(e, a, !1), this._elementRemoved(d, b, !1));
					c[a] = d;
					c[b] = e;
					this.elementsContentChanged || (this._elementAdded(d, a, !1), this._elementAdded(e, b, !1))
				};
				b._elementAdded = function(a, b, c) {
					void 0 === c && (c = !0);
					a instanceof d.DisplayObject && this._addToDisplayListAt(a, b, c);
					c && this.hasEventListener(f.ElementExistenceEvent.ELEMENT_ADD) && f.ElementExistenceEvent.dispatchElementExistenceEvent(this, f.ElementExistenceEvent.ELEMENT_ADD, a, b);
					this.invalidateSize();
					this.invalidateDisplayList()
				};
				b._elementRemoved = function(a, b, c) {
					void 0 === c && (c = !0);
					c && this.hasEventListener(f.ElementExistenceEvent.ELEMENT_REMOVE) && f.ElementExistenceEvent.dispatchElementExistenceEvent(this, f.ElementExistenceEvent.ELEMENT_REMOVE, a, b);
					a instanceof d.DisplayObject && a.parent == this && this._removeFromDisplayList(a, c);
					this.invalidateSize();
					this.invalidateDisplayList()
				};
				b.addChild = function(a) {
					throw Error(d.getString(3004, d.getString(3003)));
				};
				b.addChildAt = function(a, b) {
					throw Error(d.getString(3005, d.getString(3003)));
				};
				b.removeChild = function(a) {
					throw Error(d.getString(3006, d.getString(3003)));
				};
				b.removeChildAt = function(a) {
					throw Error(d.getString(3007, d.getString(3003)));
				};
				b.setChildIndex = function(a, b) {
					throw Error(d.getString(3008, d.getString(3003)));
				};
				b.swapChildren = function(a, b) {
					throw Error(d.getString(3009, d.getString(3003)));
				};
				b.swapChildrenAt = function(a, b) {
					throw Error(d.getString(3010, d.getString(3003)));
				};
				return c
			}(f.GroupBase);
		f.Group = g;
		g.prototype.__class__ = "egret.gui.Group"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._createAllChildren = !1;
					this._selectedChild = null;
					this.proposedSelectedIndex = c.NO_PROPOSED_SELECTION;
					this._selectedIndex = -1;
					this.childOrderingChanged = this.notifyTabBar = !1;
					this._setLayout(new f.BasicLayout)
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "layout", {
					get: function() {
						return this._layout
					},
					set: function(a) {},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "createAllChildren", {
					get: function() {
						return this._createAllChildren
					},
					set: function(a) {
						if (this._createAllChildren != a && (this._createAllChildren = a)) {
							a = this._getElementsContent();
							for (var b = a.length, c = 0; c < b; c++) {
								var e = a[c];
								e instanceof d.DisplayObject && e.parent != this && (this.childOrderingChanged = !0, this._addToDisplayList(e))
							}
							this.childOrderingChanged && this.invalidateProperties()
						}
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedChild", {
					get: function() {
						var a = this.selectedIndex;
						return 0 <= a && a < this.numElements ? this.getElementAt(a) : null
					},
					set: function(a) {
						a = this.getElementIndex(a);
						0 <= a && a < this.numElements && this._setSelectedIndex(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedIndex", {
					get: function() {
						return this.proposedSelectedIndex != c.NO_PROPOSED_SELECTION ? this.proposedSelectedIndex : this._selectedIndex
					},
					set: function(a) {
						this._setSelectedIndex(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSelectedIndex = function(a, b) {
					void 0 === b && (b = !0);
					a != this.selectedIndex && (this.proposedSelectedIndex = a, this.invalidateProperties(), f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT), this.notifyTabBar = this.notifyTabBar || b)
				};
				b._elementAdded = function(a, b, c) {
					void 0 === c && (c = !0);
					this._createAllChildren && a instanceof d.DisplayObject && this._addToDisplayListAt(a, b, c);
					c && this.hasEventListener(f.ElementExistenceEvent.ELEMENT_ADD) && f.ElementExistenceEvent.dispatchElementExistenceEvent(this, f.ElementExistenceEvent.ELEMENT_ADD, a, b);
					a.visible = !1;
					a.includeInLayout = !1; - 1 == this.selectedIndex ? this._setSelectedIndex(b, !1) : b <= this.selectedIndex && this.initialized && this._setSelectedIndex(this.selectedIndex + 1);
					this.dispatchCoEvent(f.CollectionEventKind.ADD, b, -1, [a.name])
				};
				b._elementRemoved = function(a, b, c) {
					void 0 === c && (c = !0);
					e.prototype._elementRemoved.call(this, a, b, c);
					a.visible = !0;
					a.includeInLayout = !0;
					b == this.selectedIndex ? 0 < this.numElements ? 0 == b ? (this.proposedSelectedIndex = 0, this.invalidateProperties()) : this._setSelectedIndex(0, !1) : this._setSelectedIndex(-1) : b < this.selectedIndex && this._setSelectedIndex(this.selectedIndex - 1);
					this.dispatchCoEvent(f.CollectionEventKind.REMOVE, b, -1, [a.name])
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.proposedSelectedIndex != c.NO_PROPOSED_SELECTION && (this.commitSelection(this.proposedSelectedIndex), this.proposedSelectedIndex = c.NO_PROPOSED_SELECTION);
					if (this.childOrderingChanged) {
						this.childOrderingChanged = !1;
						for (var a = this._getElementsContent(), b = a.length, f = 0; f < b; f++) {
							var g = a[f];
							g instanceof d.DisplayObject && g.parent == this && this._addToDisplayList(g)
						}
					}
					this.notifyTabBar && (this.notifyTabBar = !0, this.dispatchEventWith("IndexChanged"))
				};
				b.commitSelection = function(a) {
					0 <= a && a < this.numElements ? (this._selectedIndex = a, this._selectedChild && this._selectedChild.parent == this && (this._selectedChild.visible = !1, this._selectedChild.includeInLayout = !1), this._selectedChild = this.getElementAt(this._selectedIndex), this._selectedChild.visible = !0, this._selectedChild.includeInLayout = !0, this._selectedChild.parent != this && this._selectedChild instanceof d.DisplayObject && (this._addToDisplayList(this._selectedChild), this.childOrderingChanged || (this.childOrderingChanged = !0))) : (this._selectedChild = null, this._selectedIndex = -1);
					this.invalidateSize();
					this.invalidateDisplayList()
				};
				Object.defineProperty(b, "length", {
					get: function() {
						return this.numElements
					},
					enumerable: !0,
					configurable: !0
				});
				b.getItemAt = function(a) {
					return (a = this.getElementAt(a)) ? a.name : ""
				};
				b.getItemIndex = function(a) {
					for (var b = this._getElementsContent(), c = b.length, e = 0; e < c; e++) if (b[e].name === a) return e;
					return -1
				};
				b.dispatchCoEvent = function(a, b, c, e, d) {
					void 0 === a && (a = null);
					void 0 === b && (b = -1);
					void 0 === c && (c = -1);
					void 0 === e && (e = null);
					void 0 === d && (d = null);
					f.CollectionEvent.dispatchCollectionEvent(this, f.CollectionEvent.COLLECTION_CHANGE, a, b, c, e, d)
				};
				c.NO_PROPOSED_SELECTION = -2;
				return c
			}(f.Group);
		f.ViewStack = g;
		g.prototype.__class__ = "egret.gui.ViewStack"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.maxWidth = 1E4;
					this.minWidth = 0;
					this.maxHeight = 1E4;
					this.minHeight = 0;
					this._hasWidthSet = !1;
					this._width = NaN;
					this._hasHeightSet = !1;
					this._height = NaN;
					this.measuredHeight = this.measuredWidth = 0;
					this._initialized = !1;
					this._hostComponent = null;
					this._elementsContent = [];
					this.skinLayout = null;
					this._states = [];
					this.playStateTransition = !0;
					this.currentStateChanged = !1;
					this.requestedCurrentState = this._currentState = null;
					this.initialized = !1;
					this.skinLayout = new f.SkinBasicLayout;
					this.skinLayout.target = this
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "width", {
					get: function() {
						return this._width
					},
					set: function(a) {
						this._width != a && (this._width = a, this._hasWidthSet = d.NumberUtils.isNumber(a))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "height", {
					get: function() {
						return this._height
					},
					set: function(a) {
						this._height != a && (this._height = a, this._hasHeightSet = d.NumberUtils.isNumber(a))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "preferredWidth", {
					get: function() {
						return this._hasWidthSet ? this._width : this.measuredWidth
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "preferredHeight", {
					get: function() {
						return this._hasHeightSet ? this._height : this.measuredHeight
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {};
				Object.defineProperty(b, "hostComponent", {
					get: function() {
						return this._hostComponent
					},
					set: function(a) {
						this._setHostComponent(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setHostComponent = function(a) {
					if (this._hostComponent != a) {
						var b;
						if (this._hostComponent) for (b = this._elementsContent.length - 1; 0 <= b; b--) this._elementRemoved(this._elementsContent[b], b);
						this._hostComponent = a;
						this._initialized || (this._initialized = !0, this.createChildren());
						if (this._hostComponent) {
							a = this._elementsContent.length;
							for (b = 0; b < a; b++) this._elementAdded(this._elementsContent[b], b);
							this.initializeStates();
							this.currentStateChanged && this.commitCurrentState()
						}
					}
				};
				b._getElementsContent = function() {
					return this._elementsContent
				};
				Object.defineProperty(b, "elementsContent", {
					set: function(a) {
						null == a && (a = []);
						if (a != this._elementsContent) if (this._hostComponent) {
							var b;
							for (b = this._elementsContent.length - 1; 0 <= b; b--) this._elementRemoved(this._elementsContent[b], b);
							this._elementsContent = a.concat();
							a = this._elementsContent.length;
							for (b = 0; b < a; b++) {
								var c = this._elementsContent[b];
								c.parent && "removeElement" in c.parent ? c.parent.removeElement(c) : c.owner && "removeElement" in c.owner && c.owner.removeElement(c);
								this._elementAdded(c, b)
							}
						} else this._elementsContent = a.concat()
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "numElements", {
					get: function() {
						return this._elementsContent.length
					},
					enumerable: !0,
					configurable: !0
				});
				b.getElementAt = function(a) {
					this.checkForRangeError(a);
					return this._elementsContent[a]
				};
				b.checkForRangeError = function(a, b) {
					void 0 === b && (b = !1);
					var c = this._elementsContent.length - 1;
					b && c++;
					if (0 > a || a > c) throw new RangeError(d.getString(3011, a));
				};
				b.addElement = function(a) {
					var b = this.numElements;
					a.owner == this && (b = this.numElements - 1);
					return this.addElementAt(a, b)
				};
				b.addElementAt = function(a, b) {
					this.checkForRangeError(b, !0);
					var c = a.owner;
					if (c == this) return this.setElementIndex(a, b), a;
					c && "removeElement" in c && c.removeElement(a);
					this._elementsContent.splice(b, 0, a);
					this._hostComponent ? this._elementAdded(a, b) : a.ownerChanged(this);
					return a
				};
				b.removeElement = function(a) {
					return this.removeElementAt(this.getElementIndex(a))
				};
				b.removeElementAt = function(a) {
					this.checkForRangeError(a);
					var b = this._elementsContent[a];
					this._hostComponent ? this._elementRemoved(b, a) : b.ownerChanged(null);
					this._elementsContent.splice(a, 1);
					return b
				};
				b.getElementIndex = function(a) {
					return this._elementsContent.indexOf(a)
				};
				b.setElementIndex = function(a, b) {
					this.checkForRangeError(b);
					var c = this.getElementIndex(a); - 1 != c && c != b && (this._hostComponent && this._elementRemoved(a, c, !1), this._elementsContent.splice(c, 1), this._elementsContent.splice(b, 0, a), this._hostComponent && this._elementAdded(a, b, !1))
				};
				b._elementAdded = function(a, b, c) {
					void 0 === c && (c = !0);
					a.ownerChanged(this);
					a instanceof d.DisplayObject && this._hostComponent._addToDisplayListAt(a, b, c);
					c && this.hasEventListener(f.ElementExistenceEvent.ELEMENT_ADD) && f.ElementExistenceEvent.dispatchElementExistenceEvent(this, f.ElementExistenceEvent.ELEMENT_ADD, a, b);
					this._hostComponent.invalidateSize();
					this._hostComponent.invalidateDisplayList()
				};
				b._elementRemoved = function(a, b, c) {
					void 0 === c && (c = !0);
					c && this.hasEventListener(f.ElementExistenceEvent.ELEMENT_REMOVE) && f.ElementExistenceEvent.dispatchElementExistenceEvent(this, f.ElementExistenceEvent.ELEMENT_REMOVE, a, b);
					a instanceof d.DisplayObject && a.parent == this._hostComponent && this._hostComponent._removeFromDisplayList(a, c);
					a.ownerChanged(null);
					this._hostComponent.invalidateSize();
					this._hostComponent.invalidateDisplayList()
				};
				b.measure = function() {
					this.skinLayout.measure();
					this.measuredWidth < this.minWidth && (this.measuredWidth = this.minWidth);
					this.measuredWidth > this.maxWidth && (this.measuredWidth = this.maxWidth);
					this.measuredHeight < this.minHeight && (this.measuredHeight = this.minHeight);
					this.measuredHeight > this.maxHeight && (this.measuredHeight = this.maxHeight)
				};
				b.updateDisplayList = function(a, b) {
					this.skinLayout.updateDisplayList(a, b)
				};
				Object.defineProperty(b, "states", {
					get: function() {
						return this._states
					},
					set: function(a) {
						this._setStates(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setStates = function(a) {
					a || (a = []);
					if ("string" == typeof a[0]) for (var b = a.length, c = 0; c < b; c++) {
						var e = new f.State(a[c], []);
						a[c] = e
					}
					this._states = a;
					this.currentStateChanged = !0;
					this.requestedCurrentState = this._currentState;
					this.hasState(this.requestedCurrentState) || (this.requestedCurrentState = this.getDefaultState())
				};
				Object.defineProperty(b, "transitions", {
					get: function() {
						return this._transitions
					},
					set: function(a) {
						this._transitions = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "currentState", {
					get: function() {
						return this.currentStateChanged ? this.requestedCurrentState : this._currentState ? this._currentState : this.getDefaultState()
					},
					set: function(a) {
						a || (a = this.getDefaultState());
						a != this.currentState && a && this.currentState && (this.requestedCurrentState = a, this.currentStateChanged = !0, this._hostComponent && this.commitCurrentState())
					},
					enumerable: !0,
					configurable: !0
				});
				b.hasState = function(a) {
					return null != this.getState(a)
				};
				b.getDefaultState = function() {
					return 0 < this._states.length ? this._states[0].name : null
				};
				b.commitCurrentState = function() {
					if (this.currentStateChanged) {
						this.currentStateChanged = !1;
						this.getState(this.requestedCurrentState) || (this.requestedCurrentState = this.getDefaultState());
						var a;
						this.playStateTransition && (a = this.getTransition(this._currentState, this.requestedCurrentState));
						var b, c;
						this._currentTransition && (this._currentTransition.effect.removeEventListener(f.EffectEvent.EFFECT_END, this.transition_effectEndHandler, this), a && this._currentTransition.interruptionBehavior == f.InterruptionBehavior.STOP ? (c = this._currentTransition.effect, c.stop()) : (this._currentTransition.autoReverse && this.transitionFromState == this.requestedCurrentState && this.transitionToState == this._currentState && (b = 0 == this._currentTransition.effect.duration ? 0 : this._currentTransition.effect.playheadTime / this.getTotalDuration(this._currentTransition.effect)), this._currentTransition.effect.end()), this._currentTransition = null);
						c = this._currentState ? this._currentState : "";
						this.hasEventListener(f.StateChangeEvent.CURRENT_STATE_CHANGING) && f.StateChangeEvent.dispatchStateChangeEvent(this, f.StateChangeEvent.CURRENT_STATE_CHANGING, c, this.requestedCurrentState ? this.requestedCurrentState : "");
						this.removeState(this._currentState);
						(this._currentState = this.requestedCurrentState) && this.applyState(this._currentState);
						this.hasEventListener(f.StateChangeEvent.CURRENT_STATE_CHANGE) && f.StateChangeEvent.dispatchStateChangeEvent(this, f.StateChangeEvent.CURRENT_STATE_CHANGE, c, this._currentState ? this._currentState : "");
						if (a) {
							var e = a && a.autoReverse && (a.toState == c || a.fromState == this._currentState);
							f.UIGlobals._layoutManager.validateNow();
							this._currentTransition = a;
							this.transitionFromState = c;
							this.transitionToState = this._currentState;
							a.effect.addEventListener(f.EffectEvent.EFFECT_END, this.transition_effectEndHandler, this);
							a.effect.play(null, e);
							isNaN(b) || 0 == a.effect.duration || (a.effect.playheadTime = (1 - b) * this.getTotalDuration(a.effect))
						} else this.hasEventListener(f.StateChangeEvent.STATE_CHANGE_COMPLETE) && f.StateChangeEvent.dispatchStateChangeEvent(this, f.StateChangeEvent.CURRENT_STATE_CHANGE)
					}
				};
				b.transition_effectEndHandler = function(a) {
					this._currentTransition = null;
					this.hasEventListener(f.StateChangeEvent.STATE_CHANGE_COMPLETE) && f.StateChangeEvent.dispatchStateChangeEvent(this, f.StateChangeEvent.CURRENT_STATE_CHANGE)
				};
				b.getState = function(a) {
					if (!a) return null;
					for (var b = this._states, c = b.length, e = 0; e < c; e++) {
						var d = b[e];
						if (d.name == a) return d
					}
					return null
				};
				b.removeState = function(a) {
					if (a = this.getState(a)) {
						a = a.overrides;
						for (var b = a.length - 1; 0 <= b; b--) a[b].remove(this)
					}
				};
				b.applyState = function(a) {
					if (a = this.getState(a)) {
						a = a.overrides;
						for (var b = a.length, c = 0; c < b; c++) a[c].apply(this)
					}
				};
				b.initializeStates = function() {
					if (!this.initialized) {
						this.initialized = !0;
						for (var a = this._states, b = a.length, c = 0; c < b; c++) a[c].initialize(this)
					}
				};
				b.getTransition = function(a, b) {
					var c = null,
						e = 0;
					if (!this.transitions) return null;
					a || (a = "");
					b || (b = "");
					for (var d = 0; d < this.transitions.length; d++) {
						var f = this.transitions[d];
						if ("*" == f.fromState && "*" == f.toState && 1 > e) c = f, e = 1;
						else if (f.toState == a && "*" == f.fromState && f.autoReverse && 2 > e) c = f, e = 2;
						else if ("*" == f.toState && f.fromState == b && f.autoReverse && 3 > e) c = f, e = 3;
						else if (f.toState == a && f.fromState == b && f.autoReverse && 4 > e) c = f, e = 4;
						else if (f.fromState == a && "*" == f.toState && 5 > e) c = f, e = 5;
						else if ("*" == f.fromState && f.toState == b && 6 > e) c = f, e = 6;
						else if (f.fromState == a && f.toState == b && 7 > e) {
							c = f;
							break
						}
					}
					c && !c.effect && (c = null);
					return c
				};
				b.getTotalDuration = function(a) {
					var b = 0,
						b = a instanceof f.CompositeEffect ? a.compositeDuration : a.duration,
						c = "repeatCount" in a ? a.repeatCount : 0;
					return b = b * c + ("repeatDelay" in a ? a.repeatDelay : 0) * (c - 1) + ("startDelay" in a ? a.startDelay : 0)
				};
				return c
			}(d.EventDispatcher);
		f.Skin = g;
		g.prototype.__class__ = "egret.gui.Skin"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(a, b, c) {
					void 0 === a && (a = null);
					void 0 === b && (b = null);
					void 0 === c && (c = null);
					e.call(this);
					this.labelDisplay = new d.gui.Label;
					this.iconDisplay = new d.gui.UIAsset;
					var f = {};
					f.up = a;
					f.down = b;
					f.disabled = c;
					this.stateMap = f;
					this._setStates(["up", "down", "disabled"])
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.createChildren = function() {
					e.prototype.createChildren.call(this);
					var a = new f.UIAsset;
					a.left = a.top = a.bottom = a.right = 0;
					this.addElement(a);
					this.backgroundAsset = a;
					this.iconDisplay.includeInLayout = !1;
					this.addElement(this.iconDisplay);
					this.labelDisplay.includeInLayout = !1;
					this.labelDisplay.paddingLeft = 5;
					this.labelDisplay.paddingRight = 5;
					this.addElement(this.labelDisplay)
				};
				b.commitCurrentState = function() {
					e.prototype.commitCurrentState.call(this);
					var a = this.currentState;
					this.stateMap[a] && (this.backgroundAsset.source = this.stateMap[a]);
					var b = this.backgroundAsset;
					0 == b.anchorX && 0 < b.width && (b.anchorX = b.anchorY = 0.5, b.x += b.width / 2, b.y += b.height / 2, b.left = b.top = b.bottom = b.right = NaN);
					b.scaleX = "down" == a ? b.scaleY = 0.9 : b.scaleY = 1
				};
				b.measure = function() {
					e.prototype.measure.call(this);
					var a = this.iconDisplay.preferredWidth + this.labelDisplay.preferredWidth + 20,
						b = Math.max(this.iconDisplay.preferredHeight, this.labelDisplay.preferredHeight) + 20;
					a > this.measuredWidth && (a < this.minWidth && (a = this.minWidth), a > this.maxWidth && (a = this.maxWidth), this.measuredWidth = a);
					b > this.measuredHeight && (b < this.minHeight && (b = this.minHeight), b > this.maxHeight && (b = this.maxHeight), this.measuredHeight = b)
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					var c = this.iconDisplay.layoutBoundsWidth,
						d = this.labelDisplay.layoutBoundsHeight,
						f = 0.5 * (a - c - this.labelDisplay.layoutBoundsWidth);
					this.iconDisplay.setLayoutBoundsPosition(f, 0.5 * (b - this.iconDisplay.layoutBoundsHeight));
					this.labelDisplay.setLayoutBoundsPosition(f + c, 0.5 * (b - d))
				};
				c._skinParts = ["labelDisplay", "iconDisplay"];
				return c
			}(f.Skin);
		f.ButtonSkin = g;
		g.prototype.__class__ = "egret.gui.ButtonSkin"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._rendererOwner = null;
					this.useVirtualLayoutChanged = !1;
					this.rendererToClassMap = [];
					this.freeRenderers = [];
					this.createNewRendererFlag = !1;
					this.cleanTimer = null;
					this.dataProviderChanged = !1;
					this._dataProvider = null;
					this.recyclerDic = [];
					this.itemRendererChanged = !1;
					this._itemRenderer = null;
					this.itemRendererSkinNameChange = !1;
					this._itemRendererFunction = this._itemRendererSkinName = null;
					this.typicalItemChanged = this.virtualLayoutUnderway = !1;
					this.typicalLayoutRect = null;
					this.indexToRenderer = [];
					this.renderersBeingUpdated = this.cleanFreeRenderer = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "layout", {
					get: function() {
						return this._layout
					},
					set: function(a) {
						a != this.layout && (this.layout && (this.layout.typicalLayoutRect = null, this.layout.removeEventListener("useVirtualLayoutChanged", this.layout_useVirtualLayoutChangedHandler, this)), this.layout && a && this.layout.useVirtualLayout != a.useVirtualLayout && this.changeUseVirtualLayout(), this._setLayout(a), a && (a.typicalLayoutRect = this.typicalLayoutRect, a.addEventListener("useVirtualLayoutChanged", this.layout_useVirtualLayoutChangedHandler, this)))
					},
					enumerable: !0,
					configurable: !0
				});
				b.layout_useVirtualLayoutChangedHandler = function(a) {
					this.changeUseVirtualLayout()
				};
				b.setVirtualElementIndicesInView = function(a, b) {
					if (this.layout && this.layout.useVirtualLayout) {
						this.virtualRendererIndices = [];
						for (var c = a; c <= b; c++) this.virtualRendererIndices.push(c);
						for (var e in this.indexToRenderer) e = parseInt(e), -1 == this.virtualRendererIndices.indexOf(e) && this.freeRendererByIndex(e)
					}
				};
				b.getVirtualElementAt = function(a) {
					if (0 > a || a >= this.dataProvider.length) return null;
					var b = this.indexToRenderer[a];
					if (!b) {
						var b = this.dataProvider.getItemAt(a),
							c = this.createVirtualRenderer(a);
						this.indexToRenderer[a] = c;
						this.updateRenderer(c, a, b);
						this.createNewRendererFlag && ("validateNow" in c && c.validateNow(), this.createNewRendererFlag = !1, f.RendererExistenceEvent.dispatchRendererExistenceEvent(this, f.RendererExistenceEvent.RENDERER_ADD, c, a, b));
						b = c
					}
					return b
				};
				b.freeRendererByIndex = function(a) {
					if (this.indexToRenderer[a]) {
						var b = this.indexToRenderer[a];
						delete this.indexToRenderer[a];
						b && b instanceof d.DisplayObject && this.doFreeRenderer(b)
					}
				};
				b.doFreeRenderer = function(a) {
					var b = this.rendererToClassMap[a.hashCode].hashCode;
					this.freeRenderers[b] || (this.freeRenderers[b] = []);
					this.freeRenderers[b].push(a);
					a.visible = !1
				};
				b.invalidateSize = function() {
					this.createNewRendererFlag || e.prototype.invalidateSize.call(this)
				};
				b.createVirtualRenderer = function(a) {
					a = this.dataProvider.getItemAt(a);
					a = this.itemToRendererClass(a);
					var b = a.hashCode,
						c = this.freeRenderers;
					if (c[b] && 0 < c[b].length) return a = c[b].pop(), a.visible = !0, a;
					this.createNewRendererFlag = !0;
					return this.createOneRenderer(a)
				};
				b.createOneRenderer = function(a) {
					var b, c = a.hashCode,
						e = this.recyclerDic[c];
					e && (b = e.pop(), 0 == e.length && delete this.recyclerDic[c]);
					b || (b = a.newInstance(), this.rendererToClassMap[b.hashCode] = a);
					if (!(b && b instanceof d.DisplayObject)) return null;
					this._itemRendererSkinName && this.setItemRenderSkinName(b);
					this._addToDisplayList(b);
					b.setLayoutBoundsSize(NaN, NaN);
					return b
				};
				b.setItemRenderSkinName = function(a) {
					a && (a ? a._skinNameExplicitlySet || (a.skinName = this._itemRendererSkinName) : a && !a.skinName && (a.skinName = this._itemRendererSkinName))
				};
				b.finishVirtualLayout = function() {
					if (this.virtualLayoutUnderway) {
						var a = this.virtualLayoutUnderway = !1,
							b;
						for (b in this.freeRenderers) if (0 < this.freeRenderers[b].length) {
							a = !0;
							break
						}
						a && (this.cleanTimer || (this.cleanTimer = new d.Timer(3E3, 1), this.cleanTimer.addEventListener(d.TimerEvent.TIMER, this.cleanAllFreeRenderer, this)), this.cleanTimer.reset(), this.cleanTimer.start())
					}
				};
				b.cleanAllFreeRenderer = function(a) {
					var b = this.freeRenderers,
						c;
					for (c in b) for (var e = b[c], d = e.length, f = 0; f < d; f++) a = e[f], a.visible = !0, this.recycle(a);
					this.freeRenderers = [];
					this.cleanFreeRenderer = !1
				};
				b.getElementIndicesInView = function() {
					return this.layout && this.layout.useVirtualLayout ? this.virtualRendererIndices ? this.virtualRendererIndices : [] : e.prototype.getElementIndicesInView.call(this)
				};
				b.changeUseVirtualLayout = function() {
					this.cleanFreeRenderer = this.useVirtualLayoutChanged = !0;
					this.removeDataProviderListener();
					this.invalidateProperties()
				};
				Object.defineProperty(b, "dataProvider", {
					get: function() {
						return this._dataProvider
					},
					set: function(a) {
						this._dataProvider != a && (this.removeDataProviderListener(), this._dataProvider = a, this.cleanFreeRenderer = this.dataProviderChanged = !0, this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.removeDataProviderListener = function() {
					this._dataProvider && this._dataProvider.removeEventListener(f.CollectionEvent.COLLECTION_CHANGE, this.onCollectionChange, this)
				};
				b.onCollectionChange = function(a) {
					switch (a.kind) {
					case f.CollectionEventKind.ADD:
						this.itemAddedHandler(a.items, a.location);
						break;
					case f.CollectionEventKind.MOVE:
						this.itemMovedHandler(a.items[0], a.location, a.oldLocation);
						break;
					case f.CollectionEventKind.REMOVE:
						this.itemRemovedHandler(a.items, a.location);
						break;
					case f.CollectionEventKind.UPDATE:
						this.itemUpdatedHandler(a.items[0], a.location);
						break;
					case f.CollectionEventKind.REPLACE:
						this.itemRemoved(a.oldItems[0], a.location);
						this.itemAdded(a.items[0], a.location);
						break;
					case f.CollectionEventKind.RESET:
					case f.CollectionEventKind.REFRESH:
						if (this.layout && this.layout.useVirtualLayout) for (var b in this.indexToRenderer) b = parseInt(b), this.freeRendererByIndex(b);
						this.dataProviderChanged = !0;
						this.invalidateProperties()
					}
					this.invalidateSize();
					this.invalidateDisplayList()
				};
				b.itemAddedHandler = function(a, b) {
					for (var c = a.length, e = 0; e < c; e++) this.itemAdded(a[e], b + e);
					this.resetRenderersIndices()
				};
				b.itemMovedHandler = function(a, b, c) {
					this.itemRemoved(a, c);
					this.itemAdded(a, b);
					this.resetRenderersIndices()
				};
				b.itemRemovedHandler = function(a, b) {
					for (var c = a.length - 1; 0 <= c; c--) this.itemRemoved(a[c], b + c);
					this.resetRenderersIndices()
				};
				b.itemAdded = function(a, b) {
					this.layout && this.layout.elementAdded(b);
					if (this.layout && this.layout.useVirtualLayout) {
						var c = this.virtualRendererIndices;
						if (c) {
							for (var e = c.length, d = 0; d < e; d++) {
								var g = c[d];
								g >= b && (c[d] = g + 1)
							}
							this.indexToRenderer.splice(b, 0, null)
						}
					} else c = this.itemToRendererClass(a), c = this.createOneRenderer(c), this.indexToRenderer.splice(b, 0, c), c && (this.updateRenderer(c, b, a), f.RendererExistenceEvent.dispatchRendererExistenceEvent(this, f.RendererExistenceEvent.RENDERER_ADD, c, b, a))
				};
				b.itemRemoved = function(a, b) {
					this.layout && this.layout.elementRemoved(b);
					var c = this.virtualRendererIndices;
					if (c && 0 < c.length) {
						for (var e = -1, g = c.length, r = 0; r < g; r++) {
							var k = c[r];
							k == b ? e = r : k > b && (c[r] = k - 1)
						} - 1 != e && c.splice(e, 1)
					}
					c = this.indexToRenderer[b];
					this.indexToRenderer.length > b && this.indexToRenderer.splice(b, 1);
					f.RendererExistenceEvent.dispatchRendererExistenceEvent(this, f.RendererExistenceEvent.RENDERER_REMOVE, c, b, a);
					c && c instanceof d.DisplayObject && this.recycle(c)
				};
				b.recycle = function(a) {
					this._removeFromDisplayList(a);
					"ownerChanged" in a && a.ownerChanged(null);
					var b = this.rendererToClassMap[a.hashCode].hashCode;
					this.recyclerDic[b] || (this.recyclerDic[b] = new d.Recycler);
					this.recyclerDic[b].push(a)
				};
				b.resetRenderersIndices = function() {
					if (0 != this.indexToRenderer.length) if (this.layout && this.layout.useVirtualLayout) for (var a = this.virtualRendererIndices, b = a.length, c = 0; c < b; c++) {
						var e = a[c];
						this.resetRendererItemIndex(e)
					} else for (a = this.indexToRenderer.length, e = 0; e < a; e++) this.resetRendererItemIndex(e)
				};
				b.itemUpdatedHandler = function(a, b) {
					if (!this.renderersBeingUpdated) {
						var c = this.indexToRenderer[b];
						c && this.updateRenderer(c, b, a)
					}
				};
				b.resetRendererItemIndex = function(a) {
					var b = this.indexToRenderer[a];
					b && (b.itemIndex = a)
				};
				Object.defineProperty(b, "itemRenderer", {
					get: function() {
						return this._itemRenderer
					},
					set: function(a) {
						this._itemRenderer !== a && (this._itemRenderer = a, this.cleanFreeRenderer = this.typicalItemChanged = this.itemRendererChanged = !0, this.removeDataProviderListener(), this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemRendererSkinName", {
					get: function() {
						return this._itemRendererSkinName
					},
					set: function(a) {
						this._itemRendererSkinName != a && (this._itemRendererSkinName = a) && this.initialized && (this.itemRendererSkinNameChange = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemRendererFunction", {
					get: function() {
						return this._itemRendererFunction
					},
					set: function(a) {
						this._itemRendererFunction != a && (this._itemRendererFunction = a, this.typicalItemChanged = this.itemRendererChanged = !0, this.removeDataProviderListener(), this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.itemToRendererClass = function(a) {
					null != this._itemRendererFunction ? (a = this._itemRendererFunction(a), a || (a = this._itemRenderer)) : a = this._itemRenderer;
					return a ? a : c.defaultRendererFactory
				};
				b.createChildren = function() {
					if (!this.layout) {
						var a = new f.VerticalLayout;
						a.gap = 0;
						a.horizontalAlign = d.HorizontalAlign.CONTENT_JUSTIFY;
						this.layout = a
					}
					e.prototype.createChildren.call(this)
				};
				b.commitProperties = function() {
					if (this.itemRendererChanged || this.dataProviderChanged || this.useVirtualLayoutChanged) this.removeAllRenderers(), this.layout && this.layout.clearVirtualLayoutCache(), this.setTypicalLayoutRect(null), this.itemRendererChanged = this.useVirtualLayoutChanged = !1, this._dataProvider && this._dataProvider.addEventListener(f.CollectionEvent.COLLECTION_CHANGE, this.onCollectionChange, this), this.layout && this.layout.useVirtualLayout ? (this.invalidateSize(), this.invalidateDisplayList()) : this.createRenderers(), this.dataProviderChanged && (this.dataProviderChanged = !1, this.verticalScrollPosition = this.horizontalScrollPosition = 0);
					e.prototype.commitProperties.call(this);
					this.typicalItemChanged && (this.typicalItemChanged = !1, this._dataProvider && 0 < this._dataProvider.length && (this.typicalItem = this._dataProvider.getItemAt(0), this.measureRendererSize()));
					if (this.itemRendererSkinNameChange) {
						this.itemRendererSkinNameChange = !1;
						for (var a = this.indexToRenderer.length, b = 0; b < a; b++) this.setItemRenderSkinName(this.indexToRenderer[b]);
						var c = this.freeRenderers,
							d;
						for (d in c) {
							var g = c[d];
							if (g) for (a = g.length, b = 0; b < a; b++) this.setItemRenderSkinName(g[b])
						}
					}
				};
				b.measure = function() {
					this.layout && this.layout.useVirtualLayout && this.ensureTypicalLayoutElement();
					e.prototype.measure.call(this)
				};
				b.updateDisplayList = function(a, b) {
					this._layoutInvalidateDisplayListFlag && this.layout && this.layout.useVirtualLayout && (this.virtualLayoutUnderway = !0, this.ensureTypicalLayoutElement());
					e.prototype.updateDisplayList.call(this, a, b);
					this.virtualLayoutUnderway && this.finishVirtualLayout()
				};
				b.ensureTypicalLayoutElement = function() {
					!this.layout.typicalLayoutRect && this._dataProvider && 0 < this._dataProvider.length && (this.typicalItem = this._dataProvider.getItemAt(0), this.measureRendererSize())
				};
				b.measureRendererSize = function() {
					if (this.typicalItem) {
						var a = this.itemToRendererClass(this.typicalItem);
						if (a = this.createOneRenderer(a)) {
							this.createNewRendererFlag = !0;
							this.updateRenderer(a, 0, this.typicalItem);
							"validateNow" in a && a.validateNow();
							var b = new d.Rectangle(0, 0, a.preferredWidth, a.preferredHeight);
							this.recycle(a);
							this.setTypicalLayoutRect(b);
							this.createNewRendererFlag = !1
						} else this.setTypicalLayoutRect(null)
					} else this.setTypicalLayoutRect(null)
				};
				b.setTypicalLayoutRect = function(a) {
					this.typicalLayoutRect = a;
					this.layout && (this.layout.typicalLayoutRect = a)
				};
				b.removeAllRenderers = function() {
					for (var a = this.indexToRenderer.length, b, c = 0; c < a; c++) if (b = this.indexToRenderer[c]) this.recycle(b), f.RendererExistenceEvent.dispatchRendererExistenceEvent(this, f.RendererExistenceEvent.RENDERER_REMOVE, b, b.itemIndex, b.data);
					this.indexToRenderer = [];
					this.virtualRendererIndices = null;
					this.cleanFreeRenderer && this.cleanAllFreeRenderer()
				};
				b.createRenderers = function() {
					if (this._dataProvider) for (var a = 0, b = this._dataProvider.length, c = 0; c < b; c++) {
						var e = this._dataProvider.getItemAt(c),
							d = this.itemToRendererClass(e);
						if (d = this.createOneRenderer(d)) this.indexToRenderer[a] = d, this.updateRenderer(d, a, e), f.RendererExistenceEvent.dispatchRendererExistenceEvent(this, f.RendererExistenceEvent.RENDERER_ADD, d, a, e), a++
					}
				};
				b.updateRenderer = function(a, b, c) {
					this.renderersBeingUpdated = !0;
					this._rendererOwner ? a = this._rendererOwner.updateRenderer(a, b, c) : ("ownerChanged" in a && a.ownerChanged(this), a.itemIndex = b, a.label = this.itemToLabel(c), a.data = c);
					this.renderersBeingUpdated = !1;
					return a
				};
				b.itemToLabel = function(a) {
					return a ? a.toString() : " "
				};
				b.getElementAt = function(a) {
					return this.indexToRenderer[a]
				};
				b.getElementIndex = function(a) {
					return a ? this.indexToRenderer.indexOf(a) : -1
				};
				Object.defineProperty(b, "numElements", {
					get: function() {
						return this._dataProvider ? this._dataProvider.length : 0
					},
					enumerable: !0,
					configurable: !0
				});
				b.addChild = function(a) {
					throw Error(d.getString(3004, d.getString(3003)));
				};
				b.addChildAt = function(a, b) {
					throw Error(d.getString(3005, d.getString(3003)));
				};
				b.removeChild = function(a) {
					throw Error(d.getString(3006, d.getString(3003)));
				};
				b.removeChildAt = function(a) {
					throw Error(d.getString(3007, d.getString(3003)));
				};
				b.setChildIndex = function(a, b) {
					throw Error(d.getString(3008, d.getString(3003)));
				};
				b.swapChildren = function(a, b) {
					throw Error(d.getString(3009, d.getString(3003)));
				};
				b.swapChildrenAt = function(a, b) {
					throw Error(d.getString(3010, d.getString(3003)));
				};
				c.defaultRendererFactory = new f.ClassFactory(f.ItemRenderer);
				return c
			}(f.GroupBase);
		f.DataGroup = g;
		g.prototype.__class__ = "egret.gui.DataGroup"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._placeHolderGroup = this.contentGroup = null;
					this.contentGroupProperties = {}
				}
				__extends(c, e);
				var b = c.prototype;
				b._getCurrentContentGroup = function() {
					return null == this.contentGroup ? (null == this._placeHolderGroup && (this._placeHolderGroup = new d.Group, this._placeHolderGroup.visible = !1, this._addToDisplayList(this._placeHolderGroup)), this._placeHolderGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_ADD, this._contentGroup_elementAddedHandler, this), this._placeHolderGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_REMOVE, this._contentGroup_elementRemovedHandler, this), this._placeHolderGroup) : this.contentGroup
				};
				Object.defineProperty(b, "elementsContent", {
					set: function(a) {
						this._getCurrentContentGroup().elementsContent = a
					},
					enumerable: !0,
					configurable: !0

				});
				Object.defineProperty(b, "numElements", {
					get: function() {
						return this._getCurrentContentGroup().numElements
					},
					enumerable: !0,
					configurable: !0
				});
				b.getElementAt = function(a) {
					return this._getCurrentContentGroup().getElementAt(a)
				};
				b.addElement = function(a) {
					return this._getCurrentContentGroup().addElement(a)
				};
				b.addElementAt = function(a, b) {
					return this._getCurrentContentGroup().addElementAt(a, b)
				};
				b.removeElement = function(a) {
					return this._getCurrentContentGroup().removeElement(a)
				};
				b.removeElementAt = function(a) {
					return this._getCurrentContentGroup().removeElementAt(a)
				};
				b.removeAllElements = function() {
					this._getCurrentContentGroup().removeAllElements()
				};
				b.getElementIndex = function(a) {
					return this._getCurrentContentGroup().getElementIndex(a)
				};
				b.setElementIndex = function(a, b) {
					this._getCurrentContentGroup().setElementIndex(a, b)
				};
				b.swapElements = function(a, b) {
					this._getCurrentContentGroup().swapElements(a, b)
				};
				b.swapElementsAt = function(a, b) {
					this._getCurrentContentGroup().swapElementsAt(a, b)
				};
				Object.defineProperty(b, "layout", {
					get: function() {
						return null != this.contentGroup ? this.contentGroup.layout : this.contentGroupProperties.layout
					},
					set: function(a) {
						null != this.contentGroup ? this.contentGroup.layout = a : this.contentGroupProperties.layout = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					if (b == this.contentGroup) {
						void 0 !== this.contentGroupProperties.layout && (this.contentGroup.layout = this.contentGroupProperties.layout, this.contentGroupProperties = {});
						if (this._placeHolderGroup) {
							this._placeHolderGroup.removeEventListener(d.ElementExistenceEvent.ELEMENT_ADD, this._contentGroup_elementAddedHandler, this);
							this._placeHolderGroup.removeEventListener(d.ElementExistenceEvent.ELEMENT_REMOVE, this._contentGroup_elementRemovedHandler, this);
							for (var c = this._placeHolderGroup._getElementsContent().concat(), g = this._placeHolderGroup.numElements; 0 < g; g--) {
								var s = this._placeHolderGroup.removeElementAt(0);
								s.ownerChanged(null)
							}
							this._removeFromDisplayList(this._placeHolderGroup);
							this.contentGroup.elementsContent = c;
							for (g = c.length - 1; 0 <= g; g--) s = c[g], s.ownerChanged(this);
							this._placeHolderGroup = null
						}
						this.contentGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_ADD, this._contentGroup_elementAddedHandler, this);
						this.contentGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_REMOVE, this._contentGroup_elementRemovedHandler, this)
					}
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					if (b == this.contentGroup && (this.contentGroup.removeEventListener(d.ElementExistenceEvent.ELEMENT_ADD, this._contentGroup_elementAddedHandler, this), this.contentGroup.removeEventListener(d.ElementExistenceEvent.ELEMENT_REMOVE, this._contentGroup_elementRemovedHandler, this), this.contentGroupProperties.layout = this.contentGroup.layout, this.contentGroup.layout = null, 0 < this.contentGroup.numElements)) {
						for (this._placeHolderGroup = new d.Group; 0 < this.contentGroup.numElements;) this._placeHolderGroup.addElement(this.contentGroup.getElementAt(0));
						this._placeHolderGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_ADD, this._contentGroup_elementAddedHandler, this);
						this._placeHolderGroup.addEventListener(d.ElementExistenceEvent.ELEMENT_REMOVE, this._contentGroup_elementRemovedHandler, this)
					}
				};
				b._contentGroup_elementAddedHandler = function(a) {
					a.element.ownerChanged(this);
					this.dispatchEvent(a)
				};
				b._contentGroup_elementRemovedHandler = function(a) {
					a.element.ownerChanged(null);
					this.dispatchEvent(a)
				};
				return c
			}(d.SkinnableComponent);
		d.SkinnableContainer = g;
		g.prototype.__class__ = "egret.gui.SkinnableContainer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.dataGroup = null;
					this._dataGroupProperties = {}
				}
				__extends(c, e);
				var b = c.prototype;
				b.updateRenderer = function(a, b, c) {
					"ownerChanged" in a && a.ownerChanged(this);
					a.itemIndex = b;
					a.label = this.itemToLabel(c);
					a.data = c;
					return a
				};
				b.itemToLabel = function(a) {
					return null !== a ? a.toString() : " "
				};
				Object.defineProperty(b, "dataProvider", {
					get: function() {
						return this._getDataProvider()
					},
					set: function(a) {
						this._setDataProvider(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getDataProvider = function() {
					return null != this.dataGroup ? this.dataGroup.dataProvider : this._dataGroupProperties.dataProvider
				};
				b._setDataProvider = function(a) {
					null == this.dataGroup ? this._dataGroupProperties.dataProvider = a : (this.dataGroup.dataProvider = a, this._dataGroupProperties.dataProvider = !0)
				};
				Object.defineProperty(b, "itemRenderer", {
					get: function() {
						return this.dataGroup ? this.dataGroup.itemRenderer : this._dataGroupProperties.itemRenderer
					},
					set: function(a) {
						null == this.dataGroup ? this._dataGroupProperties.itemRenderer = a : (this.dataGroup.itemRenderer = a, this._dataGroupProperties.itemRenderer = !0)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemRendererSkinName", {
					get: function() {
						return this.dataGroup ? this.dataGroup.itemRendererSkinName : this._dataGroupProperties.itemRendererSkinName
					},
					set: function(a) {
						null == this.dataGroup ? this._dataGroupProperties.itemRendererSkinName = a : (this.dataGroup.itemRendererSkinName = a, this._dataGroupProperties.itemRendererSkinName = !0)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemRendererFunction", {
					get: function() {
						return this.dataGroup ? this.dataGroup.itemRendererFunction : this._dataGroupProperties.itemRendererFunction
					},
					set: function(a) {
						null == this.dataGroup ? this._dataGroupProperties.itemRendererFunction = a : (this.dataGroup.itemRendererFunction = a, this._dataGroupProperties.itemRendererFunction = !0)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "layout", {
					get: function() {
						return this.dataGroup ? this.dataGroup.layout : this._dataGroupProperties.layout
					},
					set: function(a) {
						this._setLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setLayout = function(a) {
					null == this.dataGroup ? this._dataGroupProperties.layout = a : (this.dataGroup.layout = a, this._dataGroupProperties.layout = !0)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					if (b == this.dataGroup) {
						var c = {};
						void 0 !== this._dataGroupProperties.layout && (this.dataGroup.layout = this._dataGroupProperties.layout, c.layout = !0);
						void 0 !== this._dataGroupProperties.dataProvider && (this.dataGroup.dataProvider = this._dataGroupProperties.dataProvider, c.dataProvider = !0);
						void 0 !== this._dataGroupProperties.itemRenderer && (this.dataGroup.itemRenderer = this._dataGroupProperties.itemRenderer, c.itemRenderer = !0);
						void 0 !== this._dataGroupProperties.itemRendererSkinName && (this.dataGroup.itemRendererSkinName = this._dataGroupProperties.itemRendererSkinName, c.itemRendererSkinName = !0);
						void 0 !== this._dataGroupProperties.itemRendererFunction && (this.dataGroup.itemRendererFunction = this._dataGroupProperties.itemRendererFunction, c.itemRendererFunction = !0);
						this.dataGroup._rendererOwner = this;
						this._dataGroupProperties = c;
						this.hasEventListener(d.RendererExistenceEvent.RENDERER_ADD) && this.dataGroup.addEventListener(d.RendererExistenceEvent.RENDERER_ADD, this.dispatchEvent, this);
						this.hasEventListener(d.RendererExistenceEvent.RENDERER_REMOVE) && this.dataGroup.addEventListener(d.RendererExistenceEvent.RENDERER_REMOVE, this.dispatchEvent, this)
					}
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					if (b == this.dataGroup) {
						this.dataGroup.removeEventListener(d.RendererExistenceEvent.RENDERER_ADD, this.dispatchEvent, this);
						this.dataGroup.removeEventListener(d.RendererExistenceEvent.RENDERER_REMOVE, this.dispatchEvent, this);
						var c = {};
						this._dataGroupProperties.layout && (c.layout = this.dataGroup.layout);
						this._dataGroupProperties.dataProvider && (c.dataProvider = this.dataGroup.dataProvider);
						this._dataGroupProperties.itemRenderer && (c.itemRenderer = this.dataGroup.itemRenderer);
						this._dataGroupProperties.itemRendererSkinName && (c.itemRendererSkinName = this.dataGroup.itemRendererSkinName);
						this._dataGroupProperties.itemRendererFunction && (c.itemRendererFunction = this.dataGroup.itemRendererFunction);
						this._dataGroupProperties = c;
						this.dataGroup._rendererOwner = null;
						this.dataGroup.dataProvider = null;
						this.dataGroup.layout = null
					}
				};
				b.addEventListener = function(a, b, c, g, s) {
					void 0 === g && (g = !1);
					void 0 === s && (s = 0);
					e.prototype.addEventListener.call(this, a, b, c, g, s);
					a == d.RendererExistenceEvent.RENDERER_ADD && this.dataGroup && this.dataGroup.addEventListener(d.RendererExistenceEvent.RENDERER_ADD, this.dispatchEvent, this);
					a == d.RendererExistenceEvent.RENDERER_REMOVE && this.dataGroup && this.dataGroup.addEventListener(d.RendererExistenceEvent.RENDERER_REMOVE, this.dispatchEvent, this)
				};
				b.removeEventListener = function(a, b, c, g) {
					void 0 === g && (g = !1);
					e.prototype.removeEventListener.call(this, a, b, c, g);
					a == d.RendererExistenceEvent.RENDERER_ADD && this.dataGroup && (this.hasEventListener(d.RendererExistenceEvent.RENDERER_ADD) || this.dataGroup.removeEventListener(d.RendererExistenceEvent.RENDERER_ADD, this.dispatchEvent, this));
					a == d.RendererExistenceEvent.RENDERER_REMOVE && this.dataGroup && (this.hasEventListener(d.RendererExistenceEvent.RENDERER_REMOVE) || this.dataGroup.removeEventListener(d.RendererExistenceEvent.RENDERER_REMOVE, this.dispatchEvent, this))
				};
				return c
			}(d.SkinnableComponent);
		d.SkinnableDataContainer = g;
		g.prototype.__class__ = "egret.gui.SkinnableDataContainer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.dataProviderChanged = this._doingWholesaleChanges = !1;
					this._labelField = "label";
					this.labelFieldOrFunctionChanged = !1;
					this._labelFunction = null;
					this.requireSelectionChanged = this._requireSelection = !1;
					this._proposedSelectedIndex = c.NO_PROPOSED_SELECTION;
					this._selectedIndex = c.NO_SELECTION;
					this._dispatchChangeAfterSelection = this._allowCustomSelectedItem = !1;
					this._pendingSelectedItem = void 0;
					this._selectedItem = null;
					this.selectedIndexAdjusted = this._useVirtualLayout = !1
				}
				__extends(c, e);
				var b = c.prototype;
				b._setDataProvider = function(a) {
					this.dataProvider && this.dataProvider.removeEventListener(f.CollectionEvent.COLLECTION_CHANGE, this.dataProvider_collectionChangeHandler, this);
					this._doingWholesaleChanges = this.dataProviderChanged = !0;
					a && a.addEventListener(f.CollectionEvent.COLLECTION_CHANGE, this.dataProvider_collectionChangeHandler, this);
					e.prototype._setDataProvider.call(this, a);
					this.invalidateProperties()
				};
				Object.defineProperty(b, "layout", {

					get: function() {
						return this.dataGroup ? this.dataGroup.layout : this._dataGroupProperties.layout
					},
					set: function(a) {
						a && this.useVirtualLayout && (a.useVirtualLayout = !0);
						this._setLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "labelField", {
					get: function() {
						return this._labelField
					},
					set: function(a) {
						this._setLabelField(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setLabelField = function(a) {
					a != this._labelField && (this._labelField = a, this.labelFieldOrFunctionChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "labelFunction", {
					get: function() {
						return this._labelFunction
					},
					set: function(a) {
						this._setLabelFunction(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setLabelFunction = function(a) {
					a != this._labelFunction && (this._labelFunction = a, this.labelFieldOrFunctionChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "requireSelection", {
					get: function() {
						return this._requireSelection
					},
					set: function(a) {
						this._setRequireSelection(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setRequireSelection = function(a) {
					a != this._requireSelection && (this._requireSelection = a) && (this.requireSelectionChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "selectedIndex", {
					get: function() {
						return this._getSelectedIndex()
					},
					set: function(a) {
						this._setSelectedIndex(a, !1)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getSelectedIndex = function() {
					return this._proposedSelectedIndex != c.NO_PROPOSED_SELECTION ? this._proposedSelectedIndex : this._selectedIndex
				};
				b._setSelectedIndex = function(a, b) {
					void 0 === b && (b = !1);
					a != this.selectedIndex && (b && (this._dispatchChangeAfterSelection = this._dispatchChangeAfterSelection || b), this._proposedSelectedIndex = a, this.invalidateProperties())
				};
				Object.defineProperty(b, "selectedItem", {
					get: function() {
						return void 0 !== this._pendingSelectedItem ? this._pendingSelectedItem : this._allowCustomSelectedItem && this.selectedIndex == c.CUSTOM_SELECTED_ITEM ? this._selectedItem : this.selectedIndex == c.NO_SELECTION || null == this.dataProvider ? void 0 : this.dataProvider.length > this.selectedIndex ? this.dataProvider.getItemAt(this.selectedIndex) : void 0
					},
					set: function(a) {
						this._setSelectedItem(a, !1)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSelectedItem = function(a, b) {
					void 0 === b && (b = !1);
					this.selectedItem !== a && (b && (this._dispatchChangeAfterSelection = this._dispatchChangeAfterSelection || b), this._pendingSelectedItem = a, this.invalidateProperties())
				};
				Object.defineProperty(b, "useVirtualLayout", {
					get: function() {
						return this._getUseVirtualLayout()
					},
					set: function(a) {
						this._setUseVirtualLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._getUseVirtualLayout = function() {
					return this.layout ? this.layout.useVirtualLayout : this._useVirtualLayout
				};
				b._setUseVirtualLayout = function(a) {
					a != this.useVirtualLayout && (this._useVirtualLayout = a, this.layout && (this.layout.useVirtualLayout = a))
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.dataProviderChanged && (this._doingWholesaleChanges = this.dataProviderChanged = !1, 0 <= this.selectedIndex && this.dataProvider && this.selectedIndex < this.dataProvider.length ? this.itemSelected(this.selectedIndex, !0) : this.requireSelection ? this._proposedSelectedIndex = 0 : this._setSelectedIndex(-1, !1));
					this.requireSelectionChanged && (this.requireSelectionChanged = !1, this.requireSelection && this.selectedIndex == c.NO_SELECTION && this.dataProvider && 0 < this.dataProvider.length && (this._proposedSelectedIndex = 0));
					void 0 !== this._pendingSelectedItem && (this._proposedSelectedIndex = this.dataProvider ? this.dataProvider.getItemIndex(this._pendingSelectedItem) : c.NO_SELECTION, this._allowCustomSelectedItem && -1 == this._proposedSelectedIndex && (this._proposedSelectedIndex = c.CUSTOM_SELECTED_ITEM, this._selectedItem = this._pendingSelectedItem), this._pendingSelectedItem = void 0);
					var a = !1;
					this._proposedSelectedIndex != c.NO_PROPOSED_SELECTION && (a = this.commitSelection());
					this.selectedIndexAdjusted && (this.selectedIndexAdjusted = !1, a || f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT));
					if (this.labelFieldOrFunctionChanged) {
						if (null != this.dataGroup) if (this.layout && this.layout.useVirtualLayout) for (var b = this.dataGroup.getElementIndicesInView(), d = b.length, g = 0; g < d; g++) a = b[g], this.updateRendererLabelProperty(a);
						else for (b = this.dataGroup.numElements, a = 0; a < b; a++) this.updateRendererLabelProperty(a);
						this.labelFieldOrFunctionChanged = !1
					}
				};
				b.updateRendererLabelProperty = function(a) {
					if (a = this.dataGroup.getElementAt(a)) a.label = this.itemToLabel(a.data)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.dataGroup && (this._useVirtualLayout && this.dataGroup.layout && (this.dataGroup.layout.useVirtualLayout = !0), this.dataGroup.addEventListener(f.RendererExistenceEvent.RENDERER_ADD, this.dataGroup_rendererAddHandler, this), this.dataGroup.addEventListener(f.RendererExistenceEvent.RENDERER_REMOVE, this.dataGroup_rendererRemoveHandler, this))
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.dataGroup && (this.dataGroup.removeEventListener(f.RendererExistenceEvent.RENDERER_ADD, this.dataGroup_rendererAddHandler, this), this.dataGroup.removeEventListener(f.RendererExistenceEvent.RENDERER_REMOVE, this.dataGroup_rendererRemoveHandler, this))
				};
				b.updateRenderer = function(a, b, c) {
					this.itemSelected(b, this._isItemIndexSelected(b));
					return e.prototype.updateRenderer.call(this, a, b, c)
				};
				b.itemToLabel = function(a) {
					if (null != this._labelFunction) return this._labelFunction(a);
					if ("string" == typeof a) return a;
					if (a instanceof d.XML) try {
						0 != a[this.labelField].length() && (a = a[this.labelField])
					} catch (b) {} else if (a instanceof Object) try {
						null != a[this.labelField] && (a = a[this.labelField])
					} catch (c) {}
					if ("string" == typeof a) return a;
					try {
						if (null !== a) return a.toString()
					} catch (e) {}
					return " "
				};
				b.itemSelected = function(a, b) {
					if (this.dataGroup) {
						var c = this.dataGroup.getElementAt(a);
						null != c && (c.selected = b)
					}
				};
				b._isItemIndexSelected = function(a) {
					return a == this.selectedIndex
				};
				b.commitSelection = function(a) {
					void 0 === a && (a = !0);
					var b = this.dataProvider ? this.dataProvider.length - 1 : -1,
						e = this._selectedIndex;
					if (!this._allowCustomSelectedItem || this._proposedSelectedIndex != c.CUSTOM_SELECTED_ITEM) if (this._proposedSelectedIndex < c.NO_SELECTION && (this._proposedSelectedIndex = c.NO_SELECTION), this._proposedSelectedIndex > b && (this._proposedSelectedIndex = b), this.requireSelection && this._proposedSelectedIndex == c.NO_SELECTION && this.dataProvider && 0 < this.dataProvider.length) return this._proposedSelectedIndex = c.NO_PROPOSED_SELECTION, this._dispatchChangeAfterSelection = !1;
					b = this._proposedSelectedIndex;
					if (this._dispatchChangeAfterSelection && !f.IndexChangeEvent.dispatchIndexChangeEvent(this, f.IndexChangeEvent.CHANGING, this._selectedIndex, this._proposedSelectedIndex, !0)) return this.itemSelected(this._proposedSelectedIndex, !1), this._proposedSelectedIndex = c.NO_PROPOSED_SELECTION, this._dispatchChangeAfterSelection = !1;
					this._selectedIndex = b;
					this._proposedSelectedIndex = c.NO_PROPOSED_SELECTION;
					e != c.NO_SELECTION && this.itemSelected(e, !1);
					this._selectedIndex != c.NO_SELECTION && this.itemSelected(this._selectedIndex, !0);
					a && (this._dispatchChangeAfterSelection && (f.IndexChangeEvent.dispatchIndexChangeEvent(this, f.IndexChangeEvent.CHANGE, e, this._selectedIndex), this._dispatchChangeAfterSelection = !1), f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT));
					return !0
				};
				b.adjustSelection = function(a, b) {
					this._proposedSelectedIndex != c.NO_PROPOSED_SELECTION ? this._proposedSelectedIndex = a : this._selectedIndex = a;
					this.selectedIndexAdjusted = !0;
					this.invalidateProperties()
				};
				b.itemAdded = function(a) {
					this._doingWholesaleChanges || (this.selectedIndex == c.NO_SELECTION ? this.requireSelection && this.adjustSelection(a, !0) : a <= this.selectedIndex && this.adjustSelection(this.selectedIndex + 1, !0))
				};
				b.itemRemoved = function(a) {
					this.selectedIndex == c.NO_SELECTION || this._doingWholesaleChanges || (a == this.selectedIndex ? this.requireSelection && this.dataProvider && 0 < this.dataProvider.length ? 0 == a ? (this._proposedSelectedIndex = 0, this.invalidateProperties()) : this._setSelectedIndex(0, !1) : this.adjustSelection(-1, !1) : a < this.selectedIndex && this.adjustSelection(this.selectedIndex - 1, !1))
				};
				b.dataGroup_rendererAddHandler = function(a) {
					a = a.renderer;
					null != a && (a.addEventListener(d.TouchEvent.TOUCH_ROLL_OVER, this.item_mouseEventHandler, this), a.addEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.item_mouseEventHandler, this))
				};
				b.dataGroup_rendererRemoveHandler = function(a) {
					a = a.renderer;
					null != a && (a.removeEventListener(d.TouchEvent.TOUCH_ROLL_OVER, this.item_mouseEventHandler, this), a.removeEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.item_mouseEventHandler, this))
				};
				b.item_mouseEventHandler = function(a) {
					var b = a.type,
						b = c.TYPE_MAP[b];
					this.hasEventListener(b) && this._dispatchListEvent(a, b, a.currentTarget)
				};
				b._dispatchListEvent = function(a, b, c) {
					var e = -1,
						e = c ? c.itemIndex : this.dataGroup.getElementIndex(a.currentTarget),
						d = this.dataProvider.getItemAt(e);
					f.ListEvent.dispatchListEvent(this, b, a, e, d, c)
				};
				b.dataProvider_collectionChangeHandler = function(a) {
					var b = a.items;
					if (a.kind == f.CollectionEventKind.ADD) for (var b = b.length, e = 0; e < b; e++) this.itemAdded(a.location + e);
					else if (a.kind == f.CollectionEventKind.REMOVE) for (b = b.length, e = b - 1; 0 <= e; e--) this.itemRemoved(a.location + e);
					else a.kind == f.CollectionEventKind.MOVE ? (this.itemRemoved(a.oldLocation), this.itemAdded(a.location)) : a.kind == f.CollectionEventKind.RESET ? 0 == this.dataProvider.length ? this._setSelectedIndex(c.NO_SELECTION, !1) : (this.dataProviderChanged = !0, this.invalidateProperties()) : a.kind == f.CollectionEventKind.REFRESH && this.dataProviderRefreshed()
				};
				b.dataProviderRefreshed = function() {
					this._setSelectedIndex(c.NO_SELECTION, !1)
				};
				c.NO_SELECTION = -1;
				c.NO_PROPOSED_SELECTION = -2;
				c.CUSTOM_SELECTED_ITEM = -3;
				c.TYPE_MAP = {
					rollOver: "itemRollOver",
					rollOut: "itemRollOut"
				};
				return c
			}(f.SkinnableDataContainer);
		f.ListBase = g;
		g.prototype.__class__ = "egret.gui.ListBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.titleDisplay = null;
					this._title = "";
					this.touchEnabled = this.titleChanged = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "title", {
					get: function() {
						return this._title
					},
					set: function(a) {
						this._title = a;
						this.titleDisplay && (this.titleDisplay.text = this.title)
					},
					enumerable: !0,
					configurable: !0
				});
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.titleDisplay && (this.titleDisplay.text = this.title)
				};
				return c
			}(d.SkinnableContainer);
		d.Panel = g;
		g.prototype.__class__ = "egret.gui.Panel"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.moveArea = this.closeButton = null;
					this._autoBackToStage = this._showCloseButton = !0;
					this._offsetPointY = this._offsetPointX = NaN;
					this.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.onWindowMouseDown, this, !0, 100)
				}
				__extends(c, e);
				var b = c.prototype;
				b.onWindowMouseDown = function(a) {
					this.enabled && this.isPopUp && a.target != this.closeButton && f.PopUpManager.bringToFront(this)
				};
				Object.defineProperty(b, "showCloseButton", {
					get: function() {
						return this._showCloseButton
					},
					set: function(a) {
						this._showCloseButton != a && (this._showCloseButton = a, this.closeButton && (this.closeButton.visible = this._showCloseButton))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "autoBackToStage", {
					get: function() {
						return this._autoBackToStage
					},
					set: function(a) {
						this._autoBackToStage = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.moveArea ? this.moveArea.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.moveArea_mouseDownHandler, this) : b == this.closeButton && (this.closeButton.addEventListener(d.TouchEvent.TOUCH_TAP, this.closeButton_clickHandler, this), this.closeButton.visible = this._showCloseButton)
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.moveArea ? this.moveArea.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.moveArea_mouseDownHandler, this) : b == this.closeButton && this.closeButton.removeEventListener(d.TouchEvent.TOUCH_TAP, this.closeButton_clickHandler, this)
				};
				b.closeButton_clickHandler = function(a) {
					f.CloseEvent.dispatchCloseEvent(this, f.CloseEvent.CLOSE)
				};
				b.moveArea_mouseDownHandler = function(a) {
					this.enabled && this.isPopUp && (a = this.globalToLocal(a.stageX, a.stageY, d.Point.identity), this._offsetPointX = a.x, this._offsetPointY = a.y, this._includeInLayout = !1, f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_MOVE, this.moveArea_mouseMoveHandler, this), f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.moveArea_mouseUpHandler, this), f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.moveArea_mouseUpHandler, this))
				};
				b.moveArea_mouseMoveHandler = function(a) {
					a = this.globalToLocal(a.stageX, a.stageY, d.Point.identity);
					this.x += a.x - this._offsetPointX;
					this.y += a.y - this._offsetPointY
				};
				b.moveArea_mouseUpHandler = function(a) {
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_MOVE, this.moveArea_mouseMoveHandler, this);
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.moveArea_mouseUpHandler, this);
					f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.moveArea_mouseUpHandler, this);
					this._autoBackToStage && this.adjustPosForStage();
					f.LayoutUtil.adjustRelativeByXY(this);
					this.includeInLayout = !0
				};
				b.adjustPosForStage = function() {
					if (this.moveArea && this.stage) {
						var a = this.moveArea.localToGlobal(0, 0),
							b = a.x,
							c = a.y;
						35 > a.x + this.moveArea.width && (b = 35 - this.moveArea.width);
						a.x > this.stage.stageWidth - 20 && (b = this.stage.stageWidth - 20);
						20 > a.y + this.moveArea.height && (c = 20 - this.moveArea.height);
						a.y > this.stage.stageHeight - 20 && (c = this.stage.stageHeight - 20);
						this.x += b - a.x;
						this.y += c - a.y
					}
				};
				return c
			}(f.Panel);
		f.TitleWindow = g;
		g.prototype.__class__ = "egret.gui.TitleWindow"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._contentText = this._secondButtonLabel = this._firstButtonLabel = "";
					this.secondButton = this.firstButton = this.contentDisplay = this.closeHandler = null
				}
				__extends(c, e);
				var b = c.prototype;
				c.show = function(a, b, e, d, g, r, k, l) {
					void 0 === a && (a = "");
					void 0 === b && (b = "");
					void 0 === e && (e = null);
					void 0 === d && (d = "OK");
					void 0 === g && (g = "");
					void 0 === r && (r = !0);
					void 0 === k && (k = !0);
					var m = new c;
					m.contentText = a;
					m.title = b;
					m._firstButtonLabel = d;
					m._secondButtonLabel = g;
					m.closeHandler = e;
					m.thisObject = l;
					f.PopUpManager.addPopUp(m, r, k);
					return m
				};
				Object.defineProperty(b, "firstButtonLabel", {
					get: function() {
						return this._firstButtonLabel
					},
					set: function(a) {
						this._firstButtonLabel != a && (this._firstButtonLabel = a, this.firstButton && (this.firstButton.label = a))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "secondButtonLabel", {
					get: function() {
						return this._secondButtonLabel
					},
					set: function(a) {
						this._secondButtonLabel != a && (this._secondButtonLabel = a, !this.secondButton || null != a && "" != a || (this.secondButton.includeInLayout = this.secondButton.visible = "" != this._secondButtonLabel && null != this._secondButtonLabel))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "contentText", {
					get: function() {
						return this._contentText
					},
					set: function(a) {
						this._contentText != a && (this._contentText = a, this.contentDisplay && (this.contentDisplay.text = a))
					},
					enumerable: !0,
					configurable: !0
				});
				b.onClose = function(a) {
					f.PopUpManager.removePopUp(this);
					if (null != this.closeHandler) {
						var b = new f.CloseEvent(f.CloseEvent.CLOSE);
						switch (a.currentTarget) {
						case this.firstButton:
							b.detail = c.FIRST_BUTTON;
							break;
						case this.secondButton:
							b.detail = c.SECOND_BUTTON
						}
						this.callCloseHandler(b)
					}
				};
				b.closeButton_clickHandler = function(a) {
					e.prototype.closeButton_clickHandler.call(this, a);
					f.PopUpManager.removePopUp(this);
					a = new f.CloseEvent(f.CloseEvent.CLOSE, !1, !1, c.CLOSE_BUTTON);
					this.callCloseHandler(a)
				};
				b.callCloseHandler = function(a) {
					null != this.closeHandler && this.closeHandler.call(this.thisObject || this, a)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.contentDisplay ? this.contentDisplay.text = this._contentText : b == this.firstButton ? (this.firstButton.label = this._firstButtonLabel, this.firstButton.addEventListener(d.TouchEvent.TOUCH_TAP, this.onClose, this)) : b == this.secondButton && (this.secondButton.label = this._secondButtonLabel, this.secondButton.includeInLayout = this.secondButton.visible = "" != this._secondButtonLabel && null != this._secondButtonLabel, this.secondButton.addEventListener(d.TouchEvent.TOUCH_TAP, this.onClose, this))
				};
				b.partRemoved = function(a, b) {
					e.prototype.partRemoved.call(this, a, b);
					b == this.firstButton ? this.firstButton.removeEventListener(d.TouchEvent.TOUCH_TAP, this.onClose, this) : b == this.secondButton && this.secondButton.removeEventListener(d.TouchEvent.TOUCH_TAP, this.onClose, this)
				};
				c.FIRST_BUTTON = "firstButton";
				c.SECOND_BUTTON = "secondButton";
				c.CLOSE_BUTTON = "closeButton";
				return c
			}(f.TitleWindow);
		f.Alert = g;
		g.prototype.__class__ = "egret.gui.Alert"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._labelFunction = this.labelDisplay = this.track = this.thumb = null;
					this._slideDuration = 500;
					this._direction = f.ProgressBarDirection.LEFT_TO_RIGHT;
					this.animator = null;
					this.slideToValue = NaN;
					this.animationValue = 0;
					this.trackResizedOrMoved = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "labelFunction", {
					get: function() {
						return this._labelFunction
					},
					set: function(a) {
						this._labelFunction != a && (this._labelFunction = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.valueToLabel = function(a, b) {
					return null != this.labelFunction ? this._labelFunction(a, b) : a + " / " + b
				};
				Object.defineProperty(b, "slideDuration", {
					get: function() {
						return this._slideDuration
					},
					set: function(a) {
						this._slideDuration != a && (this._slideDuration = a, this.animator && this.animator.isPlaying && (this.animator.stop(), this._setValue(this.slideToValue)))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "direction", {
					get: function() {
						return this._direction
					},
					set: function(a) {
						this._direction != a && (this._direction = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "value", {
					get: function() {
						return this._getValue()
					},
					set: function(a) {
						this._getValue() != a && (this._setValue(a), 0 < this._slideDuration && this.stage ? (this.validateProperties(), this.animator || (this.animator = new f.Animation(this.animationUpdateHandler, this)), this.animator.isPlaying && (this.animationValue = this.slideToValue, this.invalidateDisplayList(), this.animator.stop()), this.slideToValue = this.nearestValidValue(a, this.snapInterval), this.slideToValue != this.animationValue && (a = this._slideDuration * (Math.abs(this.animationValue - this.slideToValue) / (this.maximum - this.minimum)), this.animator.duration = Infinity === a ? 0 : a, this.animator.motionPaths = [new f.SimpleMotionPath("value", this.animationValue, this.slideToValue)], this.animator.play())) : this.animationValue = this._getValue())
					},
					enumerable: !0,
					configurable: !0
				});
				b.animationUpdateHandler = function(a) {
					a = this.nearestValidValue(a.currentValue.value, this.snapInterval);
					this.animationValue = Math.min(this.maximum, Math.max(this.minimum, a));
					this.invalidateDisplayList()
				};
				b.setValue = function(a) {
					e.prototype.setValue.call(this, a);
					this.invalidateDisplayList()
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this.updateSkinDisplayList()
				};
				b.partAdded = function(a, b) {
					b == this.track && this.track instanceof f.UIComponent && (this.track.addEventListener(f.ResizeEvent.RESIZE, this.onTrackResizeOrMove, this), this.track.addEventListener(f.MoveEvent.MOVE, this.onTrackResizeOrMove, this))
				};
				b.partRemoved = function(a, b) {
					b == this.track && this.track instanceof f.UIComponent && (this.track.removeEventListener(f.ResizeEvent.RESIZE, this.onTrackResizeOrMove, this), this.track.removeEventListener(f.MoveEvent.MOVE, this.onTrackResizeOrMove, this))
				};
				b.onTrackResizeOrMove = function(a) {
					this.trackResizedOrMoved = !0;
					this.invalidateProperties()
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.trackResizedOrMoved && (this.trackResizedOrMoved = !1, this.updateSkinDisplayList())
				};
				b.updateSkinDisplayList = function() {
					this.trackResizedOrMoved = !1;
					var a = this.value;
					this.animator && this.animator.isPlaying ? a = this.animationValue : (a = this.value, isNaN(a) && (a = 0));
					var b = isNaN(this.maximum) ? 0 : this.maximum;
					if (this.thumb && this.track) {
						var c = isNaN(this.track.width) ? 0 : this.track.width,
							c = c * this.track.scaleX,
							e = isNaN(this.track.height) ? 0 : this.track.height,
							e = e * this.track.scaleY,
							g = Math.round(a / b * c);
						if (isNaN(g) || 0 > g || Infinity === g) g = 0;
						var r = Math.round(a / b * e);
						if (isNaN(r) || 0 > r || Infinity === r) r = 0;
						var k = this.track.localToGlobal(0, 0),
							l = this.globalToLocal(k.x, k.y, d.Point.identity),
							k = l.x,
							l = l.y;
						switch (this._direction) {
						case f.ProgressBarDirection.LEFT_TO_RIGHT:
							this.thumb.width = g;
							this.thumb.height = e;
							this.thumb.x = k;
							break;
						case f.ProgressBarDirection.RIGHT_TO_LEFT:
							this.thumb.width = g;
							this.thumb.height = e;
							this.thumb.x = k + c - g;
							break;
						case f.ProgressBarDirection.TOP_TO_BOTTOM:
							this.thumb.width = c;
							this.thumb.height = r;
							this.thumb.y = l;
							break;
						case f.ProgressBarDirection.BOTTOM_TO_TOP:
							this.thumb.width = c, this.thumb.height = r, this.thumb.y = l + e - r
						}
					}
					this.labelDisplay && (this.labelDisplay.text = this.valueToLabel(a, b))
				};
				return c
			}(f.Range);
		f.ProgressBar = g;
		g.prototype.__class__ = "egret.gui.ProgressBar"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.LEFT_TO_RIGHT = "leftToRight";
				e.RIGHT_TO_LEFT = "rightToLeft";
				e.TOP_TO_BOTTOM = "topToBottom";
				e.BOTTOM_TO_TOP = "bottomToTop";
				return e
			}();
		d.ProgressBarDirection = g;
		g.prototype.__class__ = "egret.gui.ProgressBarDirection"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.pointToValue = function(a, b) {
					if (!this.thumb || !this.track) return 0;
					var c = this.maximum - this.minimum,
						e = this.track.layoutBoundsWidth - this.thumb.layoutBoundsWidth;
					return this.minimum + (0 != e ? a / e * c : 0)
				};
				b.updateSkinDisplayList = function() {
					if (this.thumb && this.track) {
						var a = this.track.layoutBoundsWidth - this.thumb.layoutBoundsWidth,
							b = this.maximum - this.minimum,
							a = 0 < b ? (this.pendingValue - this.minimum) / b * a : 0,
							c = this.track.localToGlobal(a, 0),
							b = c.x,
							c = c.y,
							e = this.thumb.parent.globalToLocal(b, c, d.Point.identity).x;
						this.thumb.setLayoutBoundsPosition(Math.round(e), this.thumb.layoutBoundsY);
						this.showTrackHighlight && this.trackHighlight && this.trackHighlight.parent && (b = this.trackHighlight.parent.globalToLocal(b, c, d.Point.identity).x - a, this.trackHighlight.x = Math.round(b), this.trackHighlight.width = Math.round(a))
					}
				};
				return c
			}(f.SliderBase);
		f.HSlider = g;
		g.prototype.__class__ = "egret.gui.HSlider"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.apply(this, arguments);
					this._thumbLengthRatio = 1
				}
				__extends(c, e);
				var b = c.prototype;
				b._setViewportMetric = function(a, b) {
					var c = Math.max(0, b - a);
					this._setMaximun(c);
					this._setMinimun(0);
					this._thumbLengthRatio = b > a ? a / b : 1
				};
				Object.defineProperty(b, "trackAlpha", {
					get: function() {
						return 1
					},
					set: function(a) {
						d.Logger.warningWithErrorId(1016, "HScrollBar.trackAlpha")
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "thumbAlpha", {
					get: function() {
						return 1
					},
					set: function(a) {
						d.Logger.warningWithErrorId(1016, "HScrollBar.thumbAlpha")
					},
					enumerable: !0,
					configurable: !0
				});
				b.setPosition = function(a) {
					this._setValue(a)
				};
				b.getPosition = function() {
					return this._getValue()
				};
				b._setValue = function(a) {
					a = Math.max(0, a);
					e.prototype._setValue.call(this, a)
				};
				b.setValue = function(a) {
					e.prototype.setValue.call(this, a)
				};
				b._animationUpdateHandler = function(a) {
					this.value = this.pendingValue = a.currentValue.value;
					this.dispatchEventWith(d.Event.CHANGE)
				};
				b.updateSkinDisplayList = function() {
					if (this.thumb && this.track) {
						var a = this.track.layoutBoundsWidth * this._thumbLengthRatio,
							b = this.thumb.layoutBoundsWidth,
							c = this.track.layoutBoundsWidth - this.thumb.layoutBoundsWidth,
							e = this.maximum - this.minimum,
							c = this.track.localToGlobal(0 < e ? (this.pendingValue - this.minimum) / e * c : 0, 0),
							c = this.thumb.parent.globalToLocal(c.x, c.y, d.Point.identity).x;
						this.thumb.setLayoutBoundsPosition(Math.round(c), this.thumb.layoutBoundsY);
						a != b && this.thumb.setLayoutBoundsSize(a, this.thumb.layoutBoundsHeight)
					}
				};
				return c
			}(f.HSlider);
		f.HScrollBar = g;
		g.prototype.__class__ = "egret.gui.HScrollBar"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.pointToValue = function(a, b) {
					if (!this.thumb || !this.track) return 0;
					var c = this.maximum - this.minimum,
						e = this.track.layoutBoundsHeight - this.thumb.layoutBoundsHeight;
					return this.minimum + (0 != e ? (e - b) / e * c : 0)
				};
				b.updateSkinDisplayList = function() {
					if (this.thumb && this.track) {
						var a = this.thumb.layoutBoundsHeight,
							b = this.track.layoutBoundsHeight - a,
							c = this.maximum - this.minimum,
							e = this.track.localToGlobal(0, 0 < c ? b - (this.pendingValue - this.minimum) / c * b : 0),
							c = e.x,
							e = e.y,
							f = this.thumb.parent.globalToLocal(c, e, d.Point.identity).y;
						this.thumb.setLayoutBoundsPosition(this.thumb.layoutBoundsX, Math.round(f));
						this.showTrackHighlight && this.trackHighlight && this.trackHighlight._parent && (c = this.trackHighlight._parent.globalToLocal(c, e, d.Point.identity).y, this.trackHighlight.y = Math.round(c + a), this.trackHighlight.height = Math.round(b - c))
					}
				};
				return c
			}(f.SliderBase);
		f.VSlider = g;
		g.prototype.__class__ = "egret.gui.VSlider"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._thumbLengthRatio = 1
				}
				__extends(c, e);
				var b = c.prototype;
				b._setViewportMetric = function(a, b) {
					var c = Math.max(0, b - a);
					this._thumbLengthRatio = b <= a ? 1 : a / b;
					this._setMaximun(c);
					this._setMinimun(0)
				};
				Object.defineProperty(b, "trackAlpha", {
					get: function() {
						return 1
					},
					set: function(a) {
						d.Logger.warningWithErrorId(1016, "VScrollBar.trackAlpha")
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "thumbAlpha", {
					get: function() {
						return 1
					},
					set: function(a) {
						d.Logger.warningWithErrorId(1016, "VScrollBar.thumbAlpha")
					},
					enumerable: !0,
					configurable: !0
				});
				b.setPosition = function(a) {
					this._setValue(a)
				};
				b.getPosition = function() {
					return this._getValue()
				};
				b._setValue = function(a) {
					a = Math.max(0, a);
					e.prototype._setValue.call(this, a)
				};
				b.setValue = function(a) {
					e.prototype.setValue.call(this, a)
				};
				b._animationUpdateHandler = function(a) {
					this.value = this.pendingValue = a.currentValue.value;
					this.dispatchEventWith(d.Event.CHANGE)
				};
				b.pointToValue = function(a, b) {
					if (!this.thumb || !this.track) return 0;
					var c = this.maximum - this.minimum,
						e = this.track.layoutBoundsHeight - this.thumb.layoutBoundsHeight;
					return this.minimum + (0 != e ? b / e * c : 0)
				};
				b.updateSkinDisplayList = function() {
					if (this.thumb && this.track) {
						var a = this.track.layoutBoundsHeight * this._thumbLengthRatio,
							b = this.thumb.layoutBoundsHeight,
							c = this.track.layoutBoundsHeight - a,
							e = this.maximum - this.minimum,
							c = this.track.localToGlobal(0, 0 < e ? (this.pendingValue - this.minimum) / e * c : 0),
							c = this.thumb.parent.globalToLocal(c.x, c.y, d.Point.identity).y;
						this.thumb.setLayoutBoundsPosition(this.thumb.layoutBoundsX, Math.round(c));
						a != b && this.thumb.setLayoutBoundsSize(this.thumb.layoutBoundsWidth, a)
					}
				};
				return c
			}(f.VSlider);
		f.VScrollBar = g;
		g.prototype.__class__ = "egret.gui.VScrollBar"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					var a = this;
					e.call(this);
					this._allowMultipleSelection = !1;
					this._selectedIndices = [];
					this.isValidIndex = function(b, c, e) {
						return a.dataProvider && 0 <= b && b < a.dataProvider.length
					};
					this._captureItemRenderer = !0;
					this._mouseDownItemRenderer = null;
					this.useVirtualLayout = !0
				}
				__extends(c, e);
				var b = c.prototype;
				b.createChildren = function() {
					this.itemRenderer || (this.itemRenderer = f.DataGroup.defaultRendererFactory);
					e.prototype.createChildren.call(this)
				};
				Object.defineProperty(b, "useVirtualLayout", {
					get: function() {
						return this._getUseVirtualLayout()
					},
					set: function(a) {
						this._setUseVirtualLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "allowMultipleSelection", {
					get: function() {
						return this._allowMultipleSelection
					},
					set: function(a) {
						this._allowMultipleSelection = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedIndices", {
					get: function() {
						return this._proposedSelectedIndices ? this._proposedSelectedIndices : this._selectedIndices
					},
					set: function(a) {
						this._setSelectedIndices(a, !1)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedIndex", {
					get: function() {
						return this._proposedSelectedIndices ? 0 < this._proposedSelectedIndices.length ? this._proposedSelectedIndices[0] : -1 : this._getSelectedIndex()
					},
					set: function(a) {
						this._setSelectedIndex(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectedItems", {
					get: function() {
						var a = [],
							b = this.selectedIndices;
						if (b) for (var c = b.length, e = 0; e < c; e++) a[e] = this.dataProvider.getItemAt(b[e]);
						return a
					},
					set: function(a) {
						var b = [];
						if (a) for (var c = a.length, e = 0; e < c; e++) {
							var d = this.dataProvider.getItemIndex(a[e]); - 1 != d && b.splice(0, 0, d);
							if (-1 == d) {
								b = [];
								break
							}
						}
						this._setSelectedIndices(b, !1)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setSelectedIndices = function(a, b) {
					void 0 === b && (b = !1);
					b && (this._dispatchChangeAfterSelection = this._dispatchChangeAfterSelection || b);
					this._proposedSelectedIndices = a ? a : [];
					this.invalidateProperties()
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this._proposedSelectedIndices && this.commitSelection()
				};
				b.commitSelection = function(a) {
					void 0 === a && (a = !0);
					var b = this._selectedIndex;
					if (this._proposedSelectedIndices) {
						this._proposedSelectedIndices = this._proposedSelectedIndices.filter(this.isValidIndex);
						if (!this.allowMultipleSelection && 0 < this._proposedSelectedIndices.length) {
							var c = [];
							c.push(this._proposedSelectedIndices[0]);
							this._proposedSelectedIndices = c
						}
						this._proposedSelectedIndex = 0 < this._proposedSelectedIndices.length ? this._proposedSelectedIndices[0] : -1
					}
					c = e.prototype.commitSelection.call(this, !1);
					if (!c) return this._proposedSelectedIndices = null, !1;
					this.selectedIndex > f.ListBase.NO_SELECTION && (this._proposedSelectedIndices ? -1 == this._proposedSelectedIndices.indexOf(this.selectedIndex) && this._proposedSelectedIndices.push(this.selectedIndex) : this._proposedSelectedIndices = [this.selectedIndex]);
					this._proposedSelectedIndices && (-1 != this._proposedSelectedIndices.indexOf(b) && this.itemSelected(b, !0), this.commitMultipleSelection());
					a && c && (this._dispatchChangeAfterSelection && (f.IndexChangeEvent.dispatchIndexChangeEvent(this, f.IndexChangeEvent.CHANGE, b, this._selectedIndex), this._dispatchChangeAfterSelection = !1), f.UIEvent.dispatchUIEvent(this, f.UIEvent.VALUE_COMMIT));
					return c
				};
				b.commitMultipleSelection = function() {
					var a = [],
						b = [],
						c, e;
					if (0 < this._selectedIndices.length && 0 < this._proposedSelectedIndices.length) {
						e = this._proposedSelectedIndices.length;
						for (c = 0; c < e; c++) - 1 == this._selectedIndices.indexOf(this._proposedSelectedIndices[c]) && b.push(this._proposedSelectedIndices[c]);
						e = this._selectedIndices.length;
						for (c = 0; c < e; c++) - 1 == this._proposedSelectedIndices.indexOf(this._selectedIndices[c]) && a.push(this._selectedIndices[c])
					} else 0 < this._selectedIndices.length ? a = this._selectedIndices : 0 < this._proposedSelectedIndices.length && (b = this._proposedSelectedIndices);
					this._selectedIndices = this._proposedSelectedIndices;
					if (0 < a.length) for (e = a.length, c = 0; c < e; c++) this.itemSelected(a[c], !1);
					if (0 < b.length) for (e = b.length, c = 0; c < e; c++) this.itemSelected(b[c], !0);
					this._proposedSelectedIndices = null
				};
				b._isItemIndexSelected = function(a) {
					return this._allowMultipleSelection ? -1 != this._selectedIndices.indexOf(a) : e.prototype._isItemIndexSelected.call(this, a)
				};
				b.dataGroup_rendererAddHandler = function(a) {
					e.prototype.dataGroup_rendererAddHandler.call(this, a);
					a = a.renderer;
					null != a && (a.addEventListener(d.TouchEvent.TOUCH_BEGIN, this._item_touchBeginHandler, this), a.addEventListener(d.TouchEvent.TOUCH_END, this._item_touchEndHandler, this))
				};
				b.dataProviderRefreshed = function() {
					this._allowMultipleSelection || e.prototype.dataProviderRefreshed.call(this)
				};
				b.dataGroup_rendererRemoveHandler = function(a) {
					e.prototype.dataGroup_rendererRemoveHandler.call(this, a);
					a = a.renderer;
					null != a && (a.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this._item_touchBeginHandler, this), a.removeEventListener(d.TouchEvent.TOUCH_END, this._item_touchEndHandler, this))
				};
				b._item_touchBeginHandler = function(a) {
					a._isDefaultPrevented || (this._mouseDownItemRenderer = a.currentTarget, f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_touchEndHandler, this), f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.stage_touchEndHandler, this))
				};
				b.calculateSelectedIndices = function(a, b, c) {
					var e = [];
					if (b) if (b = 0 < this._selectedIndices.length ? this._selectedIndices[this._selectedIndices.length - 1] : 0, b < a) for (; b <= a; b++) e.splice(0, 0, b);
					else for (; b >= a; b--) e.splice(0, 0, b);
					else if (c) if (0 < this._selectedIndices.length) if (1 == this._selectedIndices.length && this._selectedIndices[0] == a) {
						if (!this.requireSelection) return e;
						e.splice(0, 0, this._selectedIndices[0])
					} else {
						c = !1;
						for (b = 0; b < this._selectedIndices.length; b++) this._selectedIndices[b] == a ? c = !0 : this._selectedIndices[b] != a && e.splice(0, 0, this._selectedIndices[b]);
						c || e.splice(0, 0, a)
					} else e.splice(0, 0, a);
					else e.splice(0, 0, a);
					return e
				};
				b._item_touchEndHandler = function(a) {
					var b = a.currentTarget;
					if (b == this._mouseDownItemRenderer) {
						var c;
						c = b ? b.itemIndex : this.dataGroup.getElementIndex(a.currentTarget);
						this._allowMultipleSelection ? this._setSelectedIndices(this.calculateSelectedIndices(c, a.shiftKey, a.ctrlKey), !0) : this._setSelectedIndex(c, !0);
						this._captureItemRenderer && this._dispatchListEvent(a, f.ListEvent.ITEM_CLICK, b)
					}
				};
				b.stage_touchEndHandler = function(a) {
					f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_touchEndHandler, this);
					f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_touchEndHandler, this);
					this._mouseDownItemRenderer = null
				};
				return c
			}(f.ListBase);
		f.List = g;
		g.prototype.__class__ = "egret.gui.List"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._displayPopUp = this._popUpWidthMatchesAnchorWidth = this._popUpHeightMatchesAnchorHeight = this.addedToStage = this.popUpIsDisplayed = !1;
					this._popUp = null;
					this._relativeToStage = !1;
					this._popUpPosition = f.PopUpPosition.TOP_LEFT;
					this.inAnimation = !1;
					this.animator = null;
					this._openDuration = 250;
					this._closeDuration = 150;
					this.valueRange = 1;
					this.addEventListener(d.Event.ADDED_TO_STAGE, this.addedToStageHandler, this);
					this.addEventListener(d.Event.REMOVED_FROM_STAGE, this.removedFromStageHandler, this)
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "popUpHeightMatchesAnchorHeight", {
					get: function() {
						return this._popUpHeightMatchesAnchorHeight
					},
					set: function(a) {
						this._popUpHeightMatchesAnchorHeight != a && (this._popUpHeightMatchesAnchorHeight = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "popUpWidthMatchesAnchorWidth", {
					get: function() {
						return this._popUpWidthMatchesAnchorWidth
					},
					set: function(a) {
						this._popUpWidthMatchesAnchorWidth != a && (this._popUpWidthMatchesAnchorWidth = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "displayPopUp", {
					get: function() {
						return this._displayPopUp
					},
					set: function(a) {
						this._displayPopUp != a && (this._displayPopUp = a, this.addOrRemovePopUp())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "popUp", {
					get: function() {
						return this._popUp
					},
					set: function(a) {
						this._popUp != a && (this._popUp = a, this.dispatchEventWith("popUpChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "popUpPosition", {
					get: function() {
						return this._popUpPosition
					},
					set: function(a) {
						this._popUpPosition != a && (this._relativeToStage = a == f.PopUpPosition.SCREEN_CENTER, this._popUpPosition = a, this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					this.applyPopUpTransform(a, b)
				};
				b.updatePopUpTransform = function() {
					this.applyPopUpTransform(this.width, this.height)
				};
				b.calculatePopUpPosition = function() {
					var a = d.Point.identity;
					switch (this._popUpPosition) {
					case f.PopUpPosition.BELOW:
						a.x = 0;
						a.y = this.height;
						break;
					case f.PopUpPosition.ABOVE:
						a.x = 0;
						a.y = -this.popUp.layoutBoundsHeight;
						break;
					case f.PopUpPosition.LEFT:
						a.x = -this.popUp.layoutBoundsWidth;
						a.y = 0;
						break;
					case f.PopUpPosition.RIGHT:
						a.x = this.width;
						a.y = 0;
						break;
					case f.PopUpPosition.CENTER:
						a.x = 0.5 * (this.width - this.popUp.layoutBoundsWidth), a.y = 0.5 * (this.height - this.popUp.layoutBoundsHeight)
					}
					a = this.localToGlobal(a.x, a.y, a);
					return a = this.popUp.parent.globalToLocal(a.x, a.y, a)
				};
				Object.defineProperty(b, "openDuration", {
					get: function() {
						return this._openDuration
					},
					set: function(a) {
						this._openDuration = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "closeDuration", {
					get: function() {
						return this._closeDuration
					},
					set: function(a) {
						this._closeDuration = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.animationStartHandler = function(a) {
					this.inAnimation = !0;
					this.popUp && "enabled" in this.popUp && (this.popUp.enabled = !1)
				};
				b.animationUpdateHandler = function(a) {
					var b = this.popUp._scrollRect,
						c = Math.round(a.currentValue.x);
					a = Math.round(a.currentValue.y);
					b ? (b.x = c, b.y = a, b.width = this.popUp.width, b.height = this.popUp.height, this.popUp._setScrollRect(b)) : this.popUp._scrollRect = new d.Rectangle(c, a, this.popUp.width, this.popUp.height)
				};
				b.animationEndHandler = function(a) {
					this.inAnimation = !1;
					this.popUp && "enabled" in this.popUp && (this.popUp.enabled = !0);
					this.popUp.scrollRect = null;
					this.popUpIsDisplayed || (f.PopUpManager.removePopUp(this.popUp), this.popUp.ownerChanged(null))
				};
				b.addOrRemovePopUp = function() {
					this.addedToStage && this.popUp && (null == this.popUp.parent && this.displayPopUp ? (f.PopUpManager.addPopUp(this.popUp, this._relativeToStage, this._relativeToStage), this.popUp.ownerChanged(this), this.popUpIsDisplayed = !0, this.inAnimation && this.animator.end(), this.initialized ? (this.applyPopUpTransform(this.width, this.height), 0 < this._openDuration && this.startAnimation()) : d.callLater(function() {
						0 < this.openDuration && this.startAnimation()
					}, this)) : null == this.popUp.parent || this.displayPopUp || this.removeAndResetPopUp())
				};
				b.removeAndResetPopUp = function() {
					this.inAnimation && this.animator.end();
					this.popUpIsDisplayed = !1;
					0 < this._closeDuration ? this.startAnimation() : (f.PopUpManager.removePopUp(this.popUp), this.popUp.ownerChanged(null))
				};
				b.applyPopUpTransform = function(a, b) {
					if (this.popUpIsDisplayed) {
						this.popUpWidthMatchesAnchorWidth && (this.popUp.width = a);
						this.popUpHeightMatchesAnchorHeight && (this.popUp.height = b);
						"validateNow" in this.popUp && this.popUp.validateNow();
						var c = this.calculatePopUpPosition();
						this.popUp.x = c.x;
						this.popUp.y = c.y
					}
				};
				b.startAnimation = function() {
					this.animator || (this.animator = new f.Animation(this.animationUpdateHandler, this), this.animator.endFunction = this.animationEndHandler, this.animator.startFunction = this.animationStartHandler);
					this.animator.motionPaths = this.createMotionPath();
					this.animator.duration = this.popUpIsDisplayed ? this._openDuration : this._closeDuration;
					this.animator.play()
				};
				b.createMotionPath = function() {
					var a = new f.SimpleMotionPath("x"),
						b = new f.SimpleMotionPath("y"),
						c = [a, b];
					switch (this._popUpPosition) {
					case f.PopUpPosition.TOP_LEFT:
					case f.PopUpPosition.CENTER:
					case f.PopUpPosition.BELOW:
						a.valueFrom = a.valueTo = 0;
						b.valueFrom = this.popUp.height;
						b.valueTo = 0;
						this.valueRange = this.popUp.height;
						break;
					case f.PopUpPosition.ABOVE:
						a.valueFrom = a.valueTo = 0;
						b.valueFrom = -this.popUp.height;
						b.valueTo = 0;
						this.valueRange = this.popUp.height;
						break;
					case f.PopUpPosition.LEFT:
						b.valueFrom = b.valueTo = 0;
						a.valueFrom = -this.popUp.width;
						a.valueTo = 0;
						this.valueRange = this.popUp.width;
						break;
					case f.PopUpPosition.RIGHT:
						b.valueFrom = b.valueTo = 0;
						a.valueFrom = this.popUp.width;
						a.valueTo = 0;
						this.valueRange = this.popUp.width;
						break;
					default:
						this.valueRange = 1
					}
					this.valueRange = Math.abs(this.valueRange);
					if (!this.popUpIsDisplayed) {
						var e = a.valueFrom;
						a.valueFrom = a.valueTo;
						a.valueTo = e;
						e = b.valueFrom;
						b.valueFrom = b.valueTo;
						b.valueTo = e
					}
					return c
				};
				b.addedToStageHandler = function(a) {
					this.addedToStage = !0;
					d.callLater(this.checkPopUpState, this)
				};
				b.checkPopUpState = function() {
					this.addedToStage ? this.addOrRemovePopUp() : null != this.popUp && null != this.popUp.parent && this.removeAndResetPopUp()
				};
				b.removedFromStageHandler = function(a) {
					this.addedToStage = !1;
					d.callLater(this.checkPopUpState, this)
				};
				return c
			}(f.UIComponent);
		f.PopUpAnchor = g;
		g.prototype.__class__ = "egret.gui.PopUpAnchor"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.mouseIsDown = !1;
					this._dropDown = this._openButton = null;
					this._isOpen = !1;
					this._closeOnResize = !0;
					this._rollOverOpenDelay = NaN;
					this.rollOverOpenDelayTimer = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "openButton", {
					get: function() {
						return this._openButton
					},
					set: function(a) {
						this._openButton !== a && (this.removeOpenTriggers(), this._openButton = a, this.addOpenTriggers())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "dropDown", {
					get: function() {
						return this._dropDown
					},
					set: function(a) {
						this._dropDown !== a && (this._dropDown = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "isOpen", {
					get: function() {
						return this._isOpen
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "closeOnResize", {
					get: function() {
						return this._closeOnResize
					},
					set: function(a) {
						this._closeOnResize != a && (this.isOpen && this.removeCloseOnResizeTrigger(), this._closeOnResize = a, this.addCloseOnResizeTrigger())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "rollOverOpenDelay", {
					get: function() {
						return this._rollOverOpenDelay
					},
					set: function(a) {
						this._rollOverOpenDelay != a && (this.removeOpenTriggers(), this._rollOverOpenDelay = a, this.addOpenTriggers())
					},
					enumerable: !0,
					configurable: !0
				});
				b.addOpenTriggers = function() {
					this.openButton && (isNaN(this.rollOverOpenDelay) ? this.openButton.addEventListener(f.UIEvent.BUTTON_DOWN, this._openButton_buttonDownHandler, this) : this.openButton.addEventListener(d.TouchEvent.TOUCH_ROLL_OVER, this._openButton_rollOverHandler, this))
				};
				b.removeOpenTriggers = function() {
					this.openButton && (isNaN(this.rollOverOpenDelay) ? this.openButton.removeEventListener(f.UIEvent.BUTTON_DOWN, this._openButton_buttonDownHandler, this) : this.openButton.removeEventListener(d.TouchEvent.TOUCH_ROLL_OVER, this._openButton_rollOverHandler, this))
				};
				b.addCloseTriggers = function() {
					f.UIGlobals.stage && (isNaN(this.rollOverOpenDelay) ? (f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_BEGIN, this.stage_mouseDownHandler, this), f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler_noRollOverOpenDelay, this)) : f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_MOVE, this.stage_mouseMoveHandler, this), this.addCloseOnResizeTrigger())
				};
				b.removeCloseTriggers = function() {
					f.UIGlobals.stage && (isNaN(this.rollOverOpenDelay) ? (f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_BEGIN, this.stage_mouseDownHandler, this), f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler_noRollOverOpenDelay, this)) : (f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_MOVE, this.stage_mouseMoveHandler, this), f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this), f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this)), this.removeCloseOnResizeTrigger())
				};
				b.addCloseOnResizeTrigger = function() {
					this.closeOnResize && f.UIGlobals.stage.addEventListener(d.Event.RESIZE, this.stage_resizeHandler, this)
				};
				b.removeCloseOnResizeTrigger = function() {
					this.closeOnResize && f.UIGlobals.stage.removeEventListener(d.Event.RESIZE, this.stage_resizeHandler, this)
				};
				b.isTargetOverDropDownOrOpenButton = function(a) {
					if (a) {
						if (this.openButton && this.openButton.contains(a)) return !0;
						if (null != this.hitAreaAdditions) for (var b = 0; b < this.hitAreaAdditions.length; b++) if (this.hitAreaAdditions[b] == a || this.hitAreaAdditions[b] instanceof d.DisplayObjectContainer && this.hitAreaAdditions[b].contains(a)) return !0;
						if (this.dropDown instanceof d.DisplayObjectContainer) {
							if (this.dropDown.contains(a)) return !0
						} else if (a == this.dropDown) return !0
					}
					return !1
				};
				b.openDropDown = function() {
					this.openDropDownHelper()
				};
				b.openDropDownHelper = function() {
					this.isOpen || (this.addCloseTriggers(), this._isOpen = !0, this.openButton && this.openButton._setKeepDown(!0), f.UIEvent.dispatchUIEvent(this, f.UIEvent.OPEN))
				};
				b.closeDropDown = function(a) {
					if (this.isOpen) {
						this._isOpen = !1;
						this.openButton && this.openButton._setKeepDown(!1);
						var b = new f.UIEvent(f.UIEvent.CLOSE, !1, !0);
						a || b.preventDefault();
						this.dispatchEvent(b);
						this.removeCloseTriggers()
					}
				};
				b._openButton_buttonDownHandler = function(a) {
					this.isOpen ? this.closeDropDown(!0) : (this.mouseIsDown = !0, this.openDropDownHelper())
				};
				b._openButton_rollOverHandler = function(a) {
					0 == this.rollOverOpenDelay ? this.openDropDownHelper() : (this.openButton.addEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.openButton_rollOutHandler, this), this.rollOverOpenDelayTimer = new d.Timer(this.rollOverOpenDelay, 1), this.rollOverOpenDelayTimer.addEventListener(d.TimerEvent.TIMER_COMPLETE, this.rollOverDelay_timerCompleteHandler, this), this.rollOverOpenDelayTimer.start())
				};
				b.openButton_rollOutHandler = function(a) {
					this.rollOverOpenDelayTimer && this.rollOverOpenDelayTimer.running && (this.rollOverOpenDelayTimer.stop(), this.rollOverOpenDelayTimer = null);
					this.openButton.removeEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.openButton_rollOutHandler, this)
				};
				b.rollOverDelay_timerCompleteHandler = function(a) {
					this.openButton.removeEventListener(d.TouchEvent.TOUCH_ROLL_OUT, this.openButton_rollOutHandler, this);
					this.rollOverOpenDelayTimer = null;
					this.openDropDownHelper()
				};
				b.stage_mouseDownHandler = function(a) {
					if (this.mouseIsDown) this.mouseIsDown = !1;
					else if (!this.dropDown || this.dropDown && (a.target == this.dropDown || this.dropDown instanceof d.DisplayObjectContainer && !this.dropDown.contains(a.target))) {
						var b = a.target;
						if (!(this.openButton && b && this.openButton.contains(b))) {
							if (null != this.hitAreaAdditions) for (b = 0; b < this.hitAreaAdditions.length; b++) if (this.hitAreaAdditions[b] == a.target || this.hitAreaAdditions[b] instanceof d.DisplayObjectContainer && this.hitAreaAdditions[b].contains(a.target)) return;
							this.closeDropDown(!0)
						}
					}
				};
				b.stage_mouseMoveHandler = function(a) {
					this.isTargetOverDropDownOrOpenButton(a.target) || (a instanceof d.TouchEvent && a.touchDown ? (f.UIGlobals.stage.addEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this), f.UIGlobals.stage.addEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this)) : this.closeDropDown(!0))
				};
				b.stage_mouseUpHandler_noRollOverOpenDelay = function(a) {
					this.mouseIsDown && (this.mouseIsDown = !1)
				};
				b.stage_mouseUpHandler = function(a) {
					this.isTargetOverDropDownOrOpenButton(a.target) ? (f.UIGlobals.stage.removeEventListener(d.TouchEvent.TOUCH_END, this.stage_mouseUpHandler, this), f.UIGlobals.stage.removeEventListener(d.Event.LEAVE_STAGE, this.stage_mouseUpHandler, this)) : this.closeDropDown(!0)
				};
				b.stage_resizeHandler = function(a) {
					this.closeDropDown(!0)
				};
				b.stage_mouseWheelHandler = function(a) {
					!this.dropDown || this.dropDown.contains(a.target) && a.isDefaultPrevented() || this.closeDropDown(!1)
				};
				return c
			}(d.EventDispatcher);
		f.DropDownController = g;
		g.prototype.__class__ = "egret.gui.DropDownController"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.openButton = this.dropDown = null;
					this._labelChanged = !1;
					this._dropDownController = null;
					this._userProposedSelectedIndex = d.ListBase.NO_SELECTION;
					this._captureItemRenderer = !1;
					this.dropDownController = new d.DropDownController
				}
				__extends(c, e);
				var b = c.prototype;
				b._setDataProvider = function(a) {
					this.dataProvider !== a && (e.prototype._setDataProvider.call(this, a), this._labelChanged = !0, this.invalidateProperties())
				};
				b._setLabelField = function(a) {
					this.labelField != a && (e.prototype._setLabelField.call(this, a), this._labelChanged = !0, this.invalidateProperties())
				};
				b._setLabelFunction = function(a) {
					this.labelFunction != a && (e.prototype._setLabelFunction.call(this, a), this._labelChanged = !0, this.invalidateProperties())
				};
				Object.defineProperty(b, "dropDownController", {
					get: function() {
						return this._dropDownController
					},
					set: function(a) {
						this._dropDownController != a && (this._dropDownController = a, this._dropDownController.addEventListener(d.UIEvent.OPEN, this._dropDownController_openHandler, this), this._dropDownController.addEventListener(d.UIEvent.CLOSE, this.dropDownController_closeHandler, this), this.openButton && (this._dropDownController.openButton = this.openButton), this.dropDown && (this._dropDownController.dropDown = this.dropDown))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "isDropDownOpen", {
					get: function() {
						return this.dropDownController ? this.dropDownController.isOpen : !1
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this._labelChanged && (this._labelChanged = !1, this.updateLabelDisplay())
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.openButton ? this.dropDownController && (this.dropDownController.openButton = this.openButton) : b == this.dropDown && this.dropDownController && (this.dropDownController.dropDown = this.dropDown)
				};
				b.partRemoved = function(a, b) {
					this.dropDownController && (b == this.openButton && (this.dropDownController.openButton = null), b == this.dropDown && (this.dropDownController.dropDown = null));
					e.prototype.partRemoved.call(this, a, b)
				};
				b.getCurrentSkinState = function() {
					return this.enabled ? this.isDropDownOpen ? "open" : "normal" : "disabled"
				};
				b.commitSelection = function(a) {
					void 0 === a && (a = !0);
					a = e.prototype.commitSelection.call(this, a);
					this.updateLabelDisplay();
					return a
				};
				b._isItemIndexSelected = function(a) {
					return this._userProposedSelectedIndex == a
				};
				b.openDropDown = function() {
					this.dropDownController.openDropDown()
				};
				b.closeDropDown = function(a) {
					this.dropDownController.closeDropDown(a)
				};
				b.updateLabelDisplay = function(a) {};
				b._changeHighlightedSelection = function(a, b) {
					this.itemSelected(this._userProposedSelectedIndex, !1);
					this._userProposedSelectedIndex = a;
					this.itemSelected(this._userProposedSelectedIndex, !0)
				};
				b.dataProvider_collectionChangeHandler = function(a) {
					e.prototype.dataProvider_collectionChangeHandler.call(this, a);
					this._labelChanged = !0;
					this.invalidateProperties()
				};
				b._item_touchEndHandler = function(a) {
					e.prototype._item_touchEndHandler.call(this, a);
					var b = a.currentTarget;
					b == this._mouseDownItemRenderer && (this._dispatchListEvent(a, d.ListEvent.ITEM_CLICK, b), this._userProposedSelectedIndex = this.selectedIndex, this.closeDropDown(!0))
				};
				b._dropDownController_openHandler = function(a) {
					this.addEventListener(d.UIEvent.UPDATE_COMPLETE, this._open_updateCompleteHandler, this);
					this._userProposedSelectedIndex = this.selectedIndex;
					this.invalidateSkinState()
				};
				b._open_updateCompleteHandler = function(a) {
					this.removeEventListener(d.UIEvent.UPDATE_COMPLETE, this._open_updateCompleteHandler, this);
					d.UIEvent.dispatchUIEvent(this, d.UIEvent.OPEN)
				};
				b.dropDownController_closeHandler = function(a) {
					this.addEventListener(d.UIEvent.UPDATE_COMPLETE, this.close_updateCompleteHandler, this);
					this.invalidateSkinState();
					a.isDefaultPrevented() ? this._changeHighlightedSelection(this.selectedIndex) : this._setSelectedIndex(this._userProposedSelectedIndex, !0)
				};
				b.close_updateCompleteHandler = function(a) {
					this.removeEventListener(d.UIEvent.UPDATE_COMPLETE, this.close_updateCompleteHandler, this);
					d.UIEvent.dispatchUIEvent(this, d.UIEvent.CLOSE)
				};
				c.PAGE_SIZE = 5;
				return c
			}(d.List);
		d.DropDownListBase = g;
		g.prototype.__class__ = "egret.gui.DropDownListBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.iconFieldOrFunctionChanged = !1;
					this._iconFunction = this._iconField = null
				}
				__extends(c, e);
				var b = c.prototype;
				b.createChildren = function() {
					this.itemRenderer || (this.itemRenderer = c.defaultTreeRendererFactory);
					e.prototype.createChildren.call(this)
				};
				b.updateRenderer = function(a, b, c) {
					if ("hasChildren" in a && "hasChildren" in this.dataProvider) {
						var d = this.dataProvider;
						a.hasChildren = d.hasChildren(c);
						a.opened = d.isItemOpen(c);
						a.depth = d.getDepth(c);
						a.iconSkinName = this.itemToIcon(c)
					}
					return e.prototype.updateRenderer.call(this, a, b, c)
				};
				b.itemToIcon = function(a) {
					if (!a) return null;
					if (null != this._iconFunction) return this._iconFunction(a);
					var b;
					if (a instanceof Object) try {
						a[this.iconField] && (b = a[this.iconField])
					} catch (c) {}
					return b
				};
				b.dataGroup_rendererAddHandler = function(a) {
					e.prototype.dataGroup_rendererAddHandler.call(this, a);
					a.renderer && "hasChildren" in a.renderer && a.renderer.addEventListener(d.TreeEvent.ITEM_OPENING, this.onItemOpening, this)
				};
				b.onItemOpening = function(a) {
					var b = a.itemRenderer,
						c = a.item,
						e = this._getDataProvider();
					b && e && "hasChildren" in e && this.dispatchEvent(a) && (a = !b.opened, e.expandItem(c, a), d.TreeEvent.dispatchTreeEvent(this, a ? d.TreeEvent.ITEM_OPEN : d.TreeEvent.ITEM_CLOSE, b.itemIndex, c, b))
				};
				b.dataGroup_rendererRemoveHandler = function(a) {
					e.prototype.dataGroup_rendererRemoveHandler.call(this, a);
					a.renderer && "hasChildren" in a.renderer && a.renderer.removeEventListener(d.TreeEvent.ITEM_OPENING, this.onItemOpening, this)
				};
				Object.defineProperty(b, "iconField", {
					get: function() {
						return this._iconField
					},
					set: function(a) {
						this._iconField != a && (this._iconField = a, this.iconFieldOrFunctionChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "iconFunction", {
					get: function() {
						return this._iconFunction
					},
					set: function(a) {
						this._iconFunction != a && (this._iconFunction = a, this.iconFieldOrFunctionChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.expandItem = function(a, b) {
					void 0 === b && (b = !0);
					var c = this._getDataProvider();
					c && "hasChildren" in c && c.expandItem(a, b)
				};
				b.isItemOpen = function(a) {
					var b = this._getDataProvider();
					return b && "hasChildren" in b ? b.isItemOpen(a) : !1
				};
				b.dataProvider_collectionChangeHandler = function(a) {
					e.prototype.dataProvider_collectionChangeHandler.call(this, a);
					if (a.kind == d.CollectionEventKind.OPEN || a.kind == d.CollectionEventKind.CLOSE) {
						var b = this.dataGroup ? this.dataGroup.getElementAt(a.location) : null;
						b && (this.updateRenderer(b, a.location, a.items[0]), a.kind == d.CollectionEventKind.CLOSE && this.layout && this.layout.useVirtualLayout && (this.layout.clearVirtualLayoutCache(), this.invalidateSize()))
					}
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					if (this.iconFieldOrFunctionChanged) {
						if (null != this.dataGroup) {
							var a;
							if (this.layout && this.layout.useVirtualLayout) for (var b = this.dataGroup.getElementIndicesInView(), c = b.length, d = 0; d < c; d++) a = b[d], this.updateRendererIconProperty(a);
							else for (b = this.dataGroup.numElements, a = 0; a < b; a++) this.updateRendererIconProperty(a)
						}
						this.iconFieldOrFunctionChanged = !1
					}
				};
				b.updateRendererIconProperty = function(a) {
					if (a = this.dataGroup.getElementAt(a)) a.iconSkinName = this.itemToIcon(a.data)
				};
				c.defaultTreeRendererFactory = new d.ClassFactory(d.TreeItemRenderer);
				return c
			}(d.List);
		d.Tree = g;
		g.prototype.__class__ = "egret.gui.Tree"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.labelDisplay = null;
					this._prompt = ""
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "prompt", {
					get: function() {
						return this._prompt
					},
					set: function(a) {
						this._prompt != a && (this._prompt = a, this._labelChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.labelDisplay && (this._labelChanged = !0, this.invalidateProperties())
				};
				b.updateLabelDisplay = function(a) {
					void 0 === a && (a = void 0);
					this.labelDisplay && (void 0 == a && (a = this.selectedItem), this.labelDisplay.text = null != a && void 0 != a ? this.itemToLabel(a) : this._prompt)
				};
				return c
			}(d.DropDownListBase);
		d.DropDownList = g;
		g.prototype.__class__ = "egret.gui.DropDownList"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._allowDeselection = !0;
					this._data = null;
					this._itemIndex = NaN
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "allowDeselection", {
					get: function() {
						return this._allowDeselection
					},
					set: function(a) {
						this._allowDeselection = a
					},
					enumerable: !0,
					configurable: !0
				});

				Object.defineProperty(b, "data", {
					get: function() {
						return this._data
					},
					set: function(a) {
						this._data = a;
						this.dispatchEventWith("dataChange")
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "itemIndex", {
					get: function() {
						return this._itemIndex
					},
					set: function(a) {
						this._itemIndex = a
					},
					enumerable: !0,
					configurable: !0
				});
				b._setLabel = function(a) {
					a != this._getLabel() && (e.prototype._setLabel.call(this, a), this.labelDisplay && (this.labelDisplay.text = this._getLabel()))
				};
				b.buttonReleased = function() {
					this.selected && !this.allowDeselection || e.prototype.buttonReleased.call(this)
				};
				return c
			}(d.ToggleButtonBase);
		d.TabBarButton = g;
		g.prototype.__class__ = "egret.gui.TabBarButton"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.requireSelectionChanged_tabBar = !1;
					this.requireSelection = !0
				}
				__extends(c, e);
				var b = c.prototype;
				b.createChildren = function() {
					d.ListBase.prototype.createChildren.call(this)
				};
				Object.defineProperty(b, "requireSelection", {
					get: function() {
						return this._requireSelection
					},
					set: function(a) {
						a != this._requireSelection && (e.prototype._setRequireSelection.call(this, a), this.requireSelectionChanged_tabBar = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b._setDataProvider = function(a) {
					this.dataProvider instanceof d.ViewStack && (this.dataProvider.removeEventListener("IndexChanged", this.onViewStackIndexChange, this), this.removeEventListener(d.IndexChangeEvent.CHANGE, this.onIndexChanged, this));
					a instanceof d.ViewStack && (a.addEventListener("IndexChanged", this.onViewStackIndexChange, this), this.addEventListener(d.IndexChangeEvent.CHANGE, this.onIndexChanged, this));
					e.prototype._setDataProvider.call(this, a)
				};
				b.onIndexChanged = function(a) {
					this.dataProvider._setSelectedIndex(a.newIndex, !1)
				};
				b.onViewStackIndexChange = function(a) {
					this._setSelectedIndex(this.dataProvider.selectedIndex, !1)
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					if (this.requireSelectionChanged_tabBar && this.dataGroup) {
						this.requireSelectionChanged_tabBar = !1;
						for (var a = this.dataGroup.numElements, b = 0; b < a; b++) {
							var c = this.dataGroup.getElementAt(b);
							c && (c.allowDeselection = !this.requireSelection)
						}
					}
				};
				b.dataGroup_rendererAddHandler = function(a) {
					e.prototype.dataGroup_rendererAddHandler.call(this, a);
					null != a.renderer && a.renderer instanceof d.TabBarButton && (a.renderer.allowDeselection = !this.requireSelection)
				};
				b._item_touchEndHandler = function(a) {
					var b = a.currentTarget;
					if (b == this._mouseDownItemRenderer) {
						var c;
						c = b ? b.itemIndex : this.dataGroup.getElementIndex(a.currentTarget);
						c == this.selectedIndex ? this.requireSelection || this._setSelectedIndex(d.ListBase.NO_SELECTION, !0) : this._setSelectedIndex(c, !0);
						this._captureItemRenderer && this._dispatchListEvent(a, d.ListEvent.ITEM_CLICK, b)
					}
				};
				return c
			}(d.List);
		d.TabBar = g;
		g.prototype.__class__ = "egret.gui.TabBar"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(b) {
				function a() {
					b.call(this);
					this._scrollTop = this._scrollLeft = 0;
					this._content = null;
					this.scrollBeginThreshold = 10;
					this.scrollSpeed = 1;
					this.verticalScrollBar = this.horizontalScrollBar = null;
					this._scroller = this;
					this._horizontalScrollPolicy = this._verticalScrollPolicy = "auto";
					this._viewport = null;
					this._autoHideScrollBars = !0;
					this._autoHideTimer = NaN;
					this._autoHideDelay = 300;
					this._autoHideShowAnimat = null;
					this._animatTargetIsShow = !1;
					d.ScrollView.call(this)
				}
				__extends(a, b);
				var c = a.prototype;
				c.setContent = function(a) {
					this._content = a;
					this._scroller._removeEvents();
					this._scroller._addEvents();
					this._scrollLeft = a.horizontalScrollPosition;
					this._scrollTop = a.verticalScrollPosition
				};
				c._updateContentPosition = function() {
					var a = this._content;
					a.horizontalScrollPosition = this._scrollLeft;
					a.verticalScrollPosition = this._scrollTop;
					a.setLayoutBoundsSize(this._width, this._height);
					this.dispatchEvent(new d.Event(d.Event.CHANGE))
				};
				c.getMaxScrollLeft = function() {
					var a = this._content;
					return Math.max(a.contentWidth - a.width, a.initialized ? 0 : a.horizontalScrollPosition || 0)
				};
				c.getMaxScrollTop = function() {
					var a = this._content;
					return Math.max(a.contentHeight - a.height, a.initialized ? 0 : a.verticalScrollPosition || 0)
				};
				c._getContentWidth = function() {
					return this._content.contentWidth
				};
				c._getContentHeight = function() {
					return this._content.contentHeight
				};
				c._onScrollStarted = function() {
					d.ScrollView.prototype._onScrollStarted.call(this);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_START)
				};
				c._onScrollFinished = function() {
					d.ScrollView.prototype._onScrollFinished.call(this);
					f.UIEvent.dispatchUIEvent(this, f.UIEvent.CHANGE_END)
				};
				c.measure = function() {
					this._viewport && (this.measuredWidth = this._viewport.preferredWidth, this.measuredHeight = this._viewport.preferredHeight)
				};
				c.updateDisplayList = function(a, b) {
					this.viewport && this.viewport.setLayoutBoundsSize(a, b);
					this._scroller._checkScrollPolicy();
					if ("off" != this._horizontalScrollPolicy) {
						var c = this.viewport.horizontalScrollPosition,
							e = this._scroller.getMaxScrollLeft(),
							c = Math.min(c, e);
						this.setViewportHScrollPosition(c);
						if (c = this.horizontalScrollBar) c._setViewportMetric(a, this._viewport.contentWidth), c._setWidth(a - (c.left || 0) - (c.right || 0)), c.x = c.left || 0, c.y = b - this.horizontalScrollBar.layoutBoundsHeight, c.visible = this._horizontalScrollPolicy == f.ScrollPolicy.ON || this._scroller._hCanScroll, this._autoHideScrollBars && (c.alpha = 0)
					}
					"off" != this._verticalScrollPolicy && (c = this.viewport.verticalScrollPosition, e = this._scroller.getMaxScrollTop(), c = Math.min(c, e), this.setViewportVScrollPosition(c), c = this.verticalScrollBar) && (c._setViewportMetric(b, this._viewport.contentHeight), c._setHeight(b - (c.top || 0) - (c.bottom || 0)), c.y = c.top || 0, c.x = a - this.verticalScrollBar.layoutBoundsWidth, c.visible = this._verticalScrollPolicy == f.ScrollPolicy.ON || this._scroller._vCanScroll, this._autoHideScrollBars && (c.alpha = 0))
				};
				Object.defineProperty(c, "verticalScrollPolicy", {
					get: function() {
						return this._verticalScrollPolicy
					},
					set: function(a) {
						a != this._verticalScrollPolicy && (this._verticalScrollPolicy = a, this._checkVbar(), this._scroller.verticalScrollPolicy = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "horizontalScrollPolicy", {
					get: function() {
						return this._horizontalScrollPolicy
					},
					set: function(a) {
						a != this._horizontalScrollPolicy && (this._horizontalScrollPolicy = a, this._checkHbar(), this._scroller.horizontalScrollPolicy = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "viewport", {
					get: function() {
						return this._viewport
					},
					set: function(a) {
						a != this._viewport && (this.uninstallViewport(), this._viewport = a, this.installViewport(), this.dispatchEventWith("viewportChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				c.installViewport = function() {
					var a = this.viewport;
					this.addEventListener(d.Event.CHANGE, this._scrollerChangedHandler, this);
					this._createChildrenCalled && a && (a.clipAndEnableScrolling = !0, this.setContent(a), this._addToDisplayListAt(a, 0), a.addEventListener(d.gui.PropertyChangeEvent.PROPERTY_CHANGE, this._viewportChangedHandler, this))
				};
				c.uninstallViewport = function() {
					this.viewport && (this.viewport.clipAndEnableScrolling = !1, this.viewport.removeEventListener(d.gui.PropertyChangeEvent.PROPERTY_CHANGE, this._viewportChangedHandler, this), this._removeFromDisplayList(this.viewport))
				};
				c._viewportChangedHandler = function(a) {
					"horizontalScrollPosition" == a.property && this.setViewportHScrollPosition(this.viewport.horizontalScrollPosition);
					"verticalScrollPosition" == a.property && this.setViewportVScrollPosition(this.viewport.verticalScrollPosition);
					if ("contentWidth" == a.property || "contentHeight" == a.property) this.invalidateDisplayList(), this.invalidateSize()
				};
				c._scrollerChangedHandler = function(a) {
					this.setViewportHScrollPosition(this._scroller.scrollLeft);
					this.setViewportVScrollPosition(this._scroller.scrollTop)
				};
				c.setViewportVScrollPosition = function(a) {
					this._scroller.scrollTop != a && (this._scroller.scrollTop = a);
					this.verticalScrollBar && this.verticalScrollBar.value != a && (this.verticalScrollBar.setPosition(a), this.hideOrShow(!0), this.setAutoHideTimer())
				};
				c.setViewportHScrollPosition = function(a) {
					this._scroller.scrollLeft != a && (this._scroller.scrollLeft = a);
					this.horizontalScrollBar && this.horizontalScrollBar.value != a && (this.horizontalScrollBar._setValue(a), this.hideOrShow(!0), this.setAutoHideTimer())
				};
				c.throwHorizontally = function(a, b) {
					void 0 === b && (b = 500);
					this._scroller.setScrollLeft(a, b)
				};
				c.throwVertically = function(a, b) {
					void 0 === b && (b = 500);
					this._scroller.setScrollTop(a, b)
				};
				Object.defineProperty(c, "autoHideScrollBars", {
					get: function() {
						return this._autoHideScrollBars
					},
					set: function(a) {
						this._autoHideScrollBars != a && ((this._autoHideScrollBars = a) ? this.setAutoHideTimer() : this.hideOrShow(!0))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(c, "autoHideDelay", {
					get: function() {
						return this._autoHideDelay
					},
					set: function(a) {
						this._autoHideDelay != a && (this._autoHideDelay = a)
					},
					enumerable: !0,
					configurable: !0
				});
				c.setAutoHideTimer = function() {
					this._autoHideScrollBars && this.initialized && (this.horizontalScrollBar || this.verticalScrollBar) && (NaN != this._autoHideTimer && d.clearTimeout(this._autoHideTimer), this._autoHideTimer = d.setTimeout(this.hideOrShow.bind(this, !1), this, this._autoHideDelay))
				};
				c.hideOrShow = function(a) {
					var b = this;
					if (this.initialized && (this.horizontalScrollBar || this.verticalScrollBar)) {
						if (null == this._autoHideShowAnimat) this._autoHideShowAnimat = new f.Animation(function(a) {
							a = a.currentValue.alpha;
							b.horizontalScrollBar && (b.horizontalScrollBar.alpha = a);
							b.verticalScrollBar && (b.verticalScrollBar.alpha = a)
						}, this);
						else {
							if (this._animatTargetIsShow == a) return;
							this._autoHideShowAnimat.isPlaying && this._autoHideShowAnimat.stop()
						}
						this._animatTargetIsShow = a;
						var c = this._autoHideShowAnimat;
						c.motionPaths = [new f.SimpleMotionPath("alpha", a ? 0 : 1, a ? 1 : 0)];
						c.duration = a ? 100 : 300;
						c.play()
					}
				};
				Object.defineProperty(c, "numElements", {
					get: function() {
						return this.viewport ? 1 : 0
					},
					enumerable: !0,
					configurable: !0
				});
				c.throwRangeError = function(a) {
					throw new RangeError(d.getString(3011, a));
				};
				c.getElementAt = function(a) {
					if (this.viewport && 0 == a) return this.viewport;
					this.throwRangeError(a);
					return null
				};
				c.getElementIndex = function(a) {
					return null != a && a == this.viewport ? 0 : -1
				};
				c.containsElement = function(a) {
					return null != a && a == this.viewport ? !0 : !1
				};
				c.throwNotSupportedError = function() {
					throw Error(d.getString(3012));
				};
				c.addElement = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.addElementAt = function(a, b) {
					this.throwNotSupportedError();
					return null
				};
				c.removeElement = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.removeElementAt = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.removeAllElements = function() {
					this.throwNotSupportedError()
				};
				c.setElementIndex = function(a, b) {
					this.throwNotSupportedError()
				};
				c.swapElements = function(a, b) {
					this.throwNotSupportedError()
				};
				c.swapElementsAt = function(a, b) {
					this.throwNotSupportedError()
				};
				c.addChild = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.addChildAt = function(a, b) {
					this.throwNotSupportedError();
					return null
				};
				c.removeChild = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.removeChildAt = function(a) {
					this.throwNotSupportedError();
					return null
				};
				c.setChildIndex = function(a, b) {
					this.throwNotSupportedError()
				};
				c.swapChildren = function(a, b) {
					this.throwNotSupportedError()
				};
				c.swapChildrenAt = function(a, b) {
					this.throwNotSupportedError()
				};
				c._checkHbar = function() {
					if ("off" == this._horizontalScrollPolicy) this._uninstallHorizontalScrollBar();
					else if (this.horizontalScrollBar) {
						var a = this.horizontalScrollBar;
						a.addEventListener(d.Event.CHANGE, this.hBarChanged, this, !1);
						a._setViewportMetric(this._viewport.width, this._viewport.contentWidth);
						a.owner && "removeElement" in a.owner && a.owner.removeElement(a);
						this._addToDisplayList(this.horizontalScrollBar)
					}
				};
				c._checkVbar = function() {
					if ("off" == this._verticalScrollPolicy) this._uninstallVerticalScrollBar();
					else if (this.verticalScrollBar && this.verticalScrollBar.owner != this) {
						var a = this.verticalScrollBar;
						a.addEventListener(d.Event.CHANGE, this.vBarChanged, this, !1);
						a._setViewportMetric(this._viewport.height, this._viewport.contentHeight);
						a.owner && "removeElement" in a.owner && a.owner.removeElement(a);
						this._addToDisplayList(this.verticalScrollBar)
					}
				};
				c.createChildren = function() {
					b.prototype.createChildren.call(this);
					this.installViewport()
				};
				c.partAdded = function(a, c) {
					b.prototype.partAdded.call(this, a, c);
					c == this.horizontalScrollBar && this._checkHbar();
					c == this.verticalScrollBar && this._checkVbar()
				};
				c.partRemoved = function(a, c) {
					b.prototype.partRemoved.call(this, a, c);
					this.horizontalScrollBar == c && (this.horizontalScrollBar.parent == this && this._uninstallHorizontalScrollBar(), this.horizontalScrollBar = null);
					this.verticalScrollBar == c && (this.verticalScrollBar.parent == this && this._uninstallVerticalScrollBar(), this.verticalScrollBar = null)
				};
				c._uninstallHorizontalScrollBar = function() {
					null != this.horizontalScrollBar && (this._removeFromDisplayList(this.horizontalScrollBar), this.horizontalScrollBar.removeEventListener(d.Event.CHANGE, this.hBarChanged, this, !1))
				};
				c._uninstallVerticalScrollBar = function() {
					null != this.verticalScrollBar && (this._removeFromDisplayList(this.verticalScrollBar), this.verticalScrollBar.removeEventListener(d.Event.CHANGE, this.vBarChanged, this, !1))
				};
				c.hBarChanged = function(a) {
					this.setViewportHScrollPosition(this.horizontalScrollBar._getValue())
				};
				c.vBarChanged = function(a) {
					this.setViewportVScrollPosition(this.verticalScrollBar.getPosition())
				};
				c.hitTest = function(a, c, e) {
					void 0 === e && (e = !1);
					var d = b.prototype.hitTest.call(this, a, c, e);
					return d ? d : this._visible && (e || this._touchEnabled) ? 0 <= a && a < this.width && 0 <= c && c < this.height ? this : null : null
				};
				return a
			}(f.SkinnableComponent);
		f.Scroller = g;
		g.prototype.__class__ = "egret.gui.Scroller";
		for (var e in d.ScrollView.prototype) if (d.ScrollView.prototype.hasOwnProperty(e) && !g.prototype.hasOwnProperty(e) && !f.SkinnableComponent.prototype.hasOwnProperty(e) && !f.UIComponent.prototype.hasOwnProperty(e)) {
			var c = Object.getOwnPropertyDescriptor(d.ScrollView.prototype, e);
			c && (c.get || c.set) ? Object.defineProperty(g.prototype, e, c) : g.prototype[e] = d.ScrollView.prototype[e]
		}
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._selectable = !0;
					this._displayAsPassword = !1;
					this._editable = this.pendingEditable = this.displayAsPasswordChanged = !0;
					this.editableChanged = !1;
					this._maxChars = 0;
					this.maxCharsChanged = !1;
					this._multiline = !0;
					this.multilineChanged = !1;
					this._restrict = null;
					this.restrictChanged = !1;
					this._heightInLines = NaN;
					this.heightInLinesChanged = !1;
					this._widthInChars = NaN;
					this.widthInCharsChanged = !1;
					this._verticalScrollPosition = this._horizontalScrollPosition = this._contentHeight = this._contentWidth = 0;
					this._clipAndEnableScrolling = !1;
					this.defaultWidth = this.defaultHeight = NaN;
					this.isValidating = !1;
					this.selectable = !0
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "selectable", {
					get: function() {
						return this._selectable
					},
					set: function(a) {
						this._selectable = a
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "displayAsPassword", {
					get: function() {
						return this._displayAsPassword
					},
					set: function(a) {
						a != this._displayAsPassword && (this._displayAsPassword = a, this.displayAsPasswordChanged = !0, this.invalidateProperties(), this.invalidateSize(), this.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "editable", {
					get: function() {
						return this._enabled ? this._editable : this.pendingEditable
					},
					set: function(a) {
						this._editable != a && (this._enabled ? (this._editable = a, this.editableChanged = !0, this.invalidateProperties()) : this.pendingEditable = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "enabled", {
					get: function() {
						return this._editable
					},
					set: function(a) {
						a != this._enabled && ((this._enabled = a) ? (this._editable != this.pendingEditable && (this.editableChanged = !0), this._editable = this.pendingEditable) : (this.editable && (this.editableChanged = !0), this.pendingEditable = this._editable, this._editable = !1), this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "maxChars", {
					get: function() {
						return this._maxChars
					},
					set: function(a) {
						void 0 === a && (a = 0);
						a != this._maxChars && (this._maxChars = a, this.maxCharsChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "multiline", {
					get: function() {
						return this._multiline
					},
					set: function(a) {
						a != this.multiline && (this._multiline = a, this.multilineChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "restrict", {
					get: function() {
						return this._restrict
					},
					set: function(a) {
						a != this._restrict && (this._restrict = a, this.restrictChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b.styleChanged = function(a) {
					e.prototype.styleChanged.call(this, a);
					a && "size" != a || (this.widthInCharsChanged = this.heightInLinesChanged = !0)
				};
				b._setLineSpacing = function(a) {
					this._lineSpacing != a && (e.prototype._setLineSpacing.call(this, a), this.heightInLinesChanged = !0)
				};
				Object.defineProperty(b, "heightInLines", {
					get: function() {
						return this._heightInLines
					},
					set: function(a) {
						this._heightInLines != a && (this._heightInLines = a, this.heightInLinesChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "widthInChars", {
					get: function() {
						return this._widthInChars
					},
					set: function(a) {
						this._widthInChars != a && (this._widthInChars = a, this.widthInCharsChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "contentWidth", {
					get: function() {
						return this._contentWidth
					},
					enumerable: !0,
					configurable: !0
				});
				b.setContentWidth = function(a) {
					if (a != this._contentWidth) {
						var b = this._contentWidth;
						this._contentWidth = a;
						this.dispatchPropertyChangeEvent("contentWidth", b, a)
					}
				};
				Object.defineProperty(b, "contentHeight", {
					get: function() {
						return this._contentHeight
					},
					enumerable: !0,
					configurable: !0
				});
				b.setContentHeight = function(a) {
					if (a != this._contentHeight) {
						var b = this._contentHeight;
						this._contentHeight = a;
						this.dispatchPropertyChangeEvent("contentHeight", b, a)
					}
				};
				Object.defineProperty(b, "horizontalScrollPosition", {
					get: function() {
						return this._horizontalScrollPosition
					},
					set: function(a) {
						this._horizontalScrollPosition != a && (this._horizontalScrollPosition = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalScrollPosition", {
					get: function() {
						return this._verticalScrollPosition
					},
					set: function(a) {
						this._verticalScrollPosition != a && (this._verticalScrollPosition = a = Math.round(a))
					},
					enumerable: !0,
					configurable: !0
				});
				b.getScrollVByVertitcalPos = function(a) {
					if (0 == this._textField.numLines) return 1;
					var b = this._textField._getLineHeight();
					return this._textField.height + (this.height - 4) % b - this.height == a ? this._textField.maxScrollV : parseInt((a - 2) / b) + 1
				};
				b.getVerticalPosByScrollV = function(a) {
					void 0 === a && (a = 0);
					if (1 == a || 0 == this._textField.numLines) return 0;
					var b = this._textField._getLineHeight();
					return a == this._textField.maxScrollV ? this._textField.height + (this.height - 4) % b - this.height : b * (a - 1) + 2
				};
				b.getHorizontalScrollPositionDelta = function(a) {
					void 0 === a && (a = 0);
					var b = 0,
						c = this._contentWidth - this._horizontalScrollPosition - this.width,
						e = -this._horizontalScrollPosition;
					switch (a) {
					case f.NavigationUnit.LEFT:
						b = 0 >= this._horizontalScrollPosition ? 0 : Math.max(e, -this.size);
						break;
					case f.NavigationUnit.RIGHT:
						b = this._horizontalScrollPosition + this.width >= this.contentWidth ? 0 : Math.min(c, this.size);
						break;
					case f.NavigationUnit.PAGE_LEFT:
						b = Math.max(e, -this.width);
						break;
					case f.NavigationUnit.PAGE_RIGHT:
						b = Math.min(c, this.width);
						break;
					case f.NavigationUnit.HOME:
						b = e;
						break;
					case f.NavigationUnit.END:
						b = c
					}
					return b
				};
				b.getVerticalScrollPositionDelta = function(a) {
					void 0 === a && (a = 0);
					var b = 0,
						c = this._contentHeight - this._verticalScrollPosition - this.height,
						e = -this._verticalScrollPosition;
					switch (a) {
					case f.NavigationUnit.UP:
						b = this.getVScrollDelta(-1);
						break;
					case f.NavigationUnit.DOWN:
						b = this.getVScrollDelta(1);
						break;
					case f.NavigationUnit.PAGE_UP:
						b = Math.max(e, -this.width);
						break;
					case f.NavigationUnit.PAGE_DOWN:
						b = Math.min(c, this.width);
						break;
					case f.NavigationUnit.HOME:
						b = e;
						break;
					case f.NavigationUnit.END:
						b = c
					}
					return b
				};
				b.getVScrollDelta = function(a) {
					void 0 === a && (a = 0);
					if (!this._textField) return 0;
					a = this.getScrollVByVertitcalPos(this._verticalScrollPosition) + a;
					a = Math.max(1, Math.min(this._textField.maxScrollV, a));
					return this.getVerticalPosByScrollV(a) - this._verticalScrollPosition
				};
				Object.defineProperty(b, "clipAndEnableScrolling", {
					get: function() {
						return this._clipAndEnableScrolling
					},
					set: function(a) {
						this._clipAndEnableScrolling != a && (this._clipAndEnableScrolling = a)
					},
					enumerable: !0,
					configurable: !0
				});
				b.commitProperties = function() {
					this._textField || (this.restrictChanged = this.multilineChanged = this.maxCharsChanged = this.displayAsPasswordChanged = this.editableChanged = !0);
					e.prototype.commitProperties.call(this);
					this.editableChanged && (this._textField.type = this._editable ? d.TextFieldType.INPUT : d.TextFieldType.DYNAMIC, this.editableChanged = !1);
					this.displayAsPasswordChanged && (this._textField.displayAsPassword = this._displayAsPassword, this.displayAsPasswordChanged = !1);
					this.maxCharsChanged && (this._textField.maxChars = this._maxChars, this.maxCharsChanged = !1);
					this.multilineChanged && (this._textField.multiline = this._multiline, this.multilineChanged = !1);
					this.restrictChanged && (this.restrictChanged = !1);
					if (this.heightInLinesChanged) if (this.heightInLinesChanged = !1, isNaN(this._heightInLines)) this.defaultHeight = NaN;
					else {
						var a = parseInt(this.heightInLines),
							b = 22,
							c = this._textField._properties;
						0 < c._text.length ? b = this._textField._getLineHeight() : (c._text = "M", b = this._textField._getLineHeight(), c._text = "");
						this.defaultHeight = a * b + 4
					}
					this.widthInCharsChanged && (this.widthInCharsChanged = !1, isNaN(this._widthInChars) ? this.defaultWidth = NaN : (a = parseInt(this._widthInChars), this.defaultWidth = this.size * a + 5))
				};
				b.updateDisplayList = function(a, b) {
					this.isValidating = !0;
					e.prototype.updateDisplayList.call(this, a, b);
					this.updateContentSize();
					this.isValidating = !1
				};
				b.updateContentSize = function() {
					if (this.clipAndEnableScrolling) {
						this.setContentWidth(this._textField.width);
						var a = 0;
						0 == this._textField.numLines ? a = 4 : (a = this._textField._getLineHeight(), a = this._textField.height + (this.height - 4) % a);
						this.setContentHeight(a)
					}
				};
				Object.defineProperty(b, "selectionBeginIndex", {
					get: function() {
						this.validateProperties();
						return this._textField ? this._textField.selectionBeginIndex : 0
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "selectionEndIndex", {
					get: function() {
						this.validateProperties();
						return this._textField ? this._textField.selectionEndIndex : 0
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "caretIndex", {
					get: function() {
						this.validateProperties();
						return this._textField ? this._textField.caretIndex : 0
					},
					enumerable: !0,
					configurable: !0
				});
				b.setSelection = function(a, b) {
					void 0 === b && (b = 0);
					this.validateProperties();
					this._textField && this._textField._setSelection(a, b)
				};
				b.selectAll = function() {
					this.validateProperties();
					this._textField && this._textField._setSelection(0, this._textField.text.length)
				};
				b.measure = function() {
					this.measuredWidth = isNaN(this.defaultWidth) ? f.TextBase.DEFAULT_MEASURED_WIDTH : this.defaultWidth;
					0 != this._maxChars && (this.measuredWidth = Math.min(this.measuredWidth, this._textField.width));
					this.measuredHeight = this._multiline ? isNaN(this.defaultHeight) ? 2 * f.TextBase.DEFAULT_MEASURED_HEIGHT : this.defaultHeight : this._textField.height
				};
				b._createTextField = function() {
					e.prototype._createTextField.call(this);
					this._textField.type = this._editable ? d.TextFieldType.INPUT : d.TextFieldType.DYNAMIC;
					this._textField.multiline = this._multiline;
					this._textField.addEventListener(d.Event.CHANGE, this.textField_changeHandler, this);
					this._textField.addEventListener("scroll", this.textField_scrollHandler, this);
					this._textField.addEventListener("input", this.textField_textInputHandler, this)
				};
				b.textField_changeHandler = function(a) {
					this._textFieldChanged();
					a.stopImmediatePropagation();
					this.dispatchEvent(new d.Event(d.Event.CHANGE));
					this.invalidateSize();
					this.invalidateDisplayList();
					this.updateContentSize()
				};
				b.textField_scrollHandler = function(a) {};
				b.textField_textInputHandler = function(a) {
					a.stopImmediatePropagation();
					var b = new d.Event(a.type, !1, !0);
					b.data = a.data;
					this.dispatchEvent(b);
					b.isDefaultPrevented() && a.preventDefault()
				};
				return c
			}(f.TextBase);
		f.EditableText = g;
		g.prototype.__class__ = "egret.gui.EditableText"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.horizontalScrollPolicyChanged = !1;
					this._horizontalScrollPolicy = null;
					this.verticalScrollPolicyChanged = !1;
					this.scroller = this._verticalScrollPolicy = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "widthInChars", {
					get: function() {
						return this._getWidthInChars()
					},
					set: function(a) {
						this._setWidthInChars(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "heightInLines", {
					get: function() {
						return this._getHeightInLines()
					},
					set: function(a) {
						this._setHeightInLines(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "horizontalScrollPolicy", {
					get: function() {
						return this._horizontalScrollPolicy
					},
					set: function(a) {
						this._horizontalScrollPolicy != a && (this._horizontalScrollPolicy = a, this.horizontalScrollPolicyChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalScrollPolicy", {
					get: function() {
						return this._verticalScrollPolicy
					},
					set: function(a) {
						this._verticalScrollPolicy != a && (this._verticalScrollPolicy = a, this.verticalScrollPolicyChanged = !0, this.invalidateProperties())
					},
					enumerable: !0,
					configurable: !0
				});
				b._setText = function(a) {
					e.prototype._setText.call(this, a);
					this.dispatchEvent(new d.Event(d.Event.CHANGE))
				};
				b.commitProperties = function() {
					e.prototype.commitProperties.call(this);
					this.horizontalScrollPolicyChanged && (this.scroller && (this.scroller.horizontalScrollPolicy = this.horizontalScrollPolicy), this.horizontalScrollPolicyChanged = !1);
					this.verticalScrollPolicyChanged && (this.scroller && (this.scroller.verticalScrollPolicy = this.verticalScrollPolicy), this.verticalScrollPolicyChanged = !1)
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.textDisplay && (this.textDisplay.multiline = !0)
				};
				b.createSkinParts = function() {
					this.textDisplay = new f.EditableText;
					this.textDisplay.widthInChars = 15;
					this.textDisplay.heightInLines = 10;
					this._addToDisplayList(this.textDisplay);
					this.partAdded("textDisplay", this.textDisplay)
				};
				return c
			}(f.SkinnableTextBase);
		f.TextArea = g;
		g.prototype.__class__ = "egret.gui.TextArea"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this)
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "widthInChars", {
					get: function() {
						return e.prototype._getWidthInChars.call(this)
					},
					set: function(a) {
						e.prototype._setWidthInChars.call(this, a)
					},
					enumerable: !0,
					configurable: !0
				});
				b._setText = function(a) {
					e.prototype._setText.call(this, a);
					this.dispatchEvent(new d.Event(d.Event.CHANGE))
				};
				b.partAdded = function(a, b) {
					e.prototype.partAdded.call(this, a, b);
					b == this.textDisplay && (this.textDisplay.multiline = !1)
				};
				b.createSkinParts = function() {
					this.textDisplay = new f.EditableText;
					this.textDisplay.widthInChars = 10;
					this.textDisplay.multiline = !1;
					this.textDisplay.left = 1;
					this.textDisplay.right = 1;
					this.textDisplay.top = 1;
					this.textDisplay.bottom = 1;
					this._addToDisplayList(this.textDisplay);
					this.partAdded("textDisplay", this.textDisplay)
				};
				return c
			}(f.SkinnableTextBase);
		f.TextInput = g;
		g.prototype.__class__ = "egret.gui.TextInput"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					e.call(this, b, a, c)
				}
				__extends(c, e);
				c.dispatchUIEvent = function(b, a) {
					d.Event._dispatchByTarget(c, b, a)
				};
				c.INITIALIZE = "initialize";
				c.CREATION_COMPLETE = "creationComplete";
				c.UPDATE_COMPLETE = "updateComplete";
				c.BUTTON_DOWN = "buttonDown";
				c.CHANGE_END = "changeEnd";
				c.CHANGE_START = "changeStart";
				c.CHANGING = "changing";
				c.VALUE_COMMIT = "valueCommit";
				c.SKIN_CHANGED = "skinChanged";
				c.CONTENT_CHANGED = "contentChanged";
				c.OPEN = "open";
				c.CLOSE = "close";
				c.PLAY_COMPLETE = "playComplete";
				return c
			}(d.Event);
		f.UIEvent = g;
		g.prototype.__class__ = "egret.gui.UIEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f, g, r, k) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = null);
					void 0 === g && (g = null);
					void 0 === r && (r = null);
					void 0 === k && (k = null);
					e.call(this, b, a, c);
					this.source = this.property = this.oldValue = this.newValue = this.kind = null;
					this.kind = d;
					this.property = f;
					this.oldValue = g;
					this.newValue = r;
					this.source = k
				}
				__extends(c, e);
				c.dispatchPropertyChangeEvent = function(b, a, e, f, g, s) {
					void 0 === a && (a = null);
					void 0 === e && (e = null);
					void 0 === f && (f = null);
					void 0 === g && (g = null);
					void 0 === s && (s = null);
					var r = d.Event._getPropertyData(c);
					r.kind = a;
					r.property = e;
					r.oldValue = f;
					r.newValue = g;
					r.source = s;
					d.Event._dispatchByTarget(c, b, c.PROPERTY_CHANGE, r)
				};
				c.PROPERTY_CHANGE = "propertyChange";
				return c
			}(d.Event);
		f.PropertyChangeEvent = g;
		g.prototype.__class__ = "egret.gui.PropertyChangeEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.UPDATE = "update";
				e.DELETE = "delete";
				return e
			}();
		d.PropertyChangeEventKind = g;
		g.prototype.__class__ = "egret.gui.PropertyChangeEventKind"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = NaN);
					void 0 === c && (c = NaN);
					void 0 === d && (d = !1);
					void 0 === f && (f = !1);
					e.call(this, b, d, f);
					this.oldY = this.oldX = NaN;
					this.oldX = a;
					this.oldY = c
				}
				__extends(c, e);
				c.dispatchMoveEvent = function(b, a, e) {
					void 0 === a && (a = NaN);
					void 0 === e && (e = NaN);
					var f = d.Event._getPropertyData(c);
					f.oldX = a;
					f.oldY = e;
					d.Event._dispatchByTarget(c, b, c.MOVE, f)
				};
				c.MOVE = "move";
				return c
			}(d.Event);
		f.MoveEvent = g;
		g.prototype.__class__ = "egret.gui.MoveEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = NaN);
					void 0 === c && (c = NaN);
					void 0 === d && (d = !1);
					void 0 === f && (f = !1);
					e.call(this, b, d, f);
					this.oldWidth = this.oldHeight = NaN;
					this.oldWidth = a;
					this.oldHeight = c
				}
				__extends(c, e);
				c.dispatchResizeEvent = function(b, a, e) {
					void 0 === a && (a = NaN);
					void 0 === e && (e = NaN);
					var f = d.Event._getPropertyData(c);
					f.oldWidth = a;
					f.oldHeight = e;
					d.Event._dispatchByTarget(c, b, c.RESIZE, f)
				};
				c.RESIZE = "resize";
				return c
			}(d.Event);
		f.ResizeEvent = g;
		g.prototype.__class__ = "egret.gui.ResizeEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = null);
					e.call(this, b, a, c);
					this.partName = this.instance = null;
					this.partName = d;
					this.instance = f
				}
				__extends(c, e);
				c.dispatchSkinPartEvent = function(b, a, e, f) {
					void 0 === e && (e = null);
					void 0 === f && (f = null);
					var g = d.Event._getPropertyData(c);
					g.partName = e;
					g.instance = f;
					d.Event._dispatchByTarget(c, b, a, g)
				};
				c.PART_ADDED = "partAdded";
				c.PART_REMOVED = "partRemoved";
				return c
			}(d.Event);
		f.SkinPartEvent = g;
		g.prototype.__class__ = "egret.gui.SkinPartEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = -1);
					e.call(this, b, a, c);
					this.detail = null;
					this.detail = d
				}
				__extends(c, e);
				c.dispatchCloseEvent = function(b, a, e) {
					void 0 === e && (e = -1);
					var f = d.Event._getPropertyData(c);
					f.detail = e;
					d.Event._dispatchByTarget(c, b, a, f)
				};
				c.CLOSE = "close";
				return c
			}(d.Event);
		f.CloseEvent = g;
		g.prototype.__class__ = "egret.gui.CloseEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f, g, r, k) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = -1);
					void 0 === g && (g = -1);
					void 0 === r && (r = null);
					void 0 === k && (k = null);
					e.call(this, b, a, c);
					this.oldItems = this.items = this.kind = null;
					this.kind = d;
					this.location = f;
					this.oldLocation = g;
					this.items = r ? r : [];
					this.oldItems = k ? k : []
				}
				__extends(c, e);
				c.dispatchCollectionEvent = function(b, a, e, f, g, s, r) {
					void 0 === e && (e = null);
					void 0 === f && (f = -1);
					void 0 === g && (g = -1);
					void 0 === s && (s = null);
					void 0 === r && (r = null);
					var k = d.Event._getPropertyData(c);
					k.kind = e;
					k.location = f;
					k.oldLocation = g;
					k.items = s;
					k.oldItems = r;
					d.Event._dispatchByTarget(c, b, a, k)
				};
				c.COLLECTION_CHANGE = "collectionChange";
				return c
			}(d.Event);
		f.CollectionEvent = g;
		g.prototype.__class__ = "egret.gui.CollectionEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.ADD = "add";
				e.MOVE = "move";
				e.REFRESH = "refresh";
				e.REMOVE = "remove";
				e.REPLACE = "replace";
				e.RESET = "reset";
				e.UPDATE = "update";
				e.OPEN = "open";
				e.CLOSE = "close";
				return e
			}();
		d.CollectionEventKind = g;
		g.prototype.__class__ = "egret.gui.CollectionEventKind"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = -1);
					e.call(this, b, a, c);
					this.index = NaN;
					this.element = null;
					this.element = d;
					this.index = f
				}
				__extends(c, e);
				c.dispatchElementExistenceEvent = function(b, a, e, f) {
					void 0 === e && (e = null);
					void 0 === f && (f = -1);
					var g = d.Event._getPropertyData(c);
					g.element = e;
					g.index = f;
					d.Event._dispatchByTarget(c, b, a, g)
				};
				c.ELEMENT_ADD = "elementAdd";
				c.ELEMENT_REMOVE = "elementRemove";
				return c
			}(d.Event);
		f.ElementExistenceEvent = g;
		g.prototype.__class__ = "egret.gui.ElementExistenceEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = -1);
					void 0 === f && (f = -1);
					e.call(this, b, a, c);
					this.oldIndex = this.newIndex = NaN;
					this.oldIndex = d;
					this.newIndex = f
				}
				__extends(c, e);
				c.dispatchIndexChangeEvent = function(b, a, e, f, g) {
					void 0 === e && (e = -1);
					void 0 === f && (f = -1);
					void 0 === g && (g = !1);
					var s = d.Event._getPropertyData(c);
					s.oldIndex = e;
					s.newIndex = f;
					return d.Event._dispatchByTarget(c, b, a, s, !1, g)
				};
				c.CHANGE = "change";
				c.CHANGING = "changing";
				return c
			}(d.Event);
		f.IndexChangeEvent = g;
		g.prototype.__class__ = "egret.gui.IndexChangeEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f, g, r, k, l, m, n, p, q) {
					void 0 === a && (a = !0);
					void 0 === c && (c = !0);
					void 0 === d && (d = 0);
					void 0 === f && (f = 0);
					void 0 === g && (g = 0);
					void 0 === r && (r = !1);
					void 0 === k && (k = !1);
					void 0 === l && (l = !1);
					void 0 === m && (m = !1);
					void 0 === n && (n = -1);
					void 0 === p && (p = null);
					void 0 === q && (q = null);
					e.call(this, b, a, c, d, f, g, r, k, l, m);
					this.itemRenderer = this.item = null;
					this.itemIndex = NaN;
					this.itemIndex = n;
					this.item = p;
					this.itemRenderer = q
				}
				__extends(c, e);
				c.dispatchListEvent = function(b, a, e, f, g, s) {
					void 0 === e && (e = null);
					void 0 === f && (f = -1);
					void 0 === g && (g = null);
					void 0 === s && (s = null);
					var r = d.Event._getPropertyData(c);
					r.touchPointID = e.touchPointID;
					r._stageX = e.stageX;
					r._stageY = e.stageY;
					r.ctrlKey = e.ctrlKey;
					r.altKey = e.altKey;
					r.shiftKey = e.shiftKey;
					r.touchDown = e.touchDown;
					r.itemIndex = f;
					r.item = g;
					r.itemRenderer = s;
					d.Event._dispatchByTarget(c, b, a, r)
				};
				c.ITEM_ROLL_OUT = "itemRollOut";
				c.ITEM_ROLL_OVER = "itemRollOver";
				c.ITEM_CLICK = "itemClick";
				return c
			}(d.TouchEvent);
		f.ListEvent = g;
		g.prototype.__class__ = "egret.gui.ListEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = !1);
					e.call(this, b, a, c);
					this.popUp = null;
					this.modal = !1;
					this.popUp = d;
					this.modal = f
				}
				__extends(c, e);
				c.dispatchPopUpEvent = function(b, a, e, f) {
					void 0 === e && (e = null);
					void 0 === f && (f = !1);
					var g = d.Event._getPropertyData(c);
					g.popUp = e;
					g.modal = f;
					d.Event._dispatchByTarget(c, b, a, g)
				};
				c.ADD_POPUP = "addPopUp";
				c.REMOVE_POPUP = "removePopUp";
				c.BRING_TO_FRONT = "bringToFront";
				return c
			}(d.Event);
		f.PopUpEvent = g;
		g.prototype.__class__ = "egret.gui.PopUpEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f, g) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = -1);
					void 0 === g && (g = null);
					e.call(this, b, a, c);
					this.data = null;
					this.index = NaN;
					this.renderer = null;
					this.renderer = d;
					this.index = f;
					this.data = g
				}
				__extends(c, e);
				c.dispatchRendererExistenceEvent = function(b, a, e, f, g) {
					void 0 === e && (e = null);
					void 0 === f && (f = -1);
					void 0 === g && (g = null);
					var s = d.Event._getPropertyData(c);
					s.renderer = e;
					s.index = f;
					s.data = g;
					d.Event._dispatchByTarget(c, b, a, s)
				};
				c.RENDERER_ADD = "rendererAdd";
				c.RENDERER_REMOVE = "rendererRemove";
				return c
			}(d.Event);
		f.RendererExistenceEvent = g;
		g.prototype.__class__ = "egret.gui.RendererExistenceEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					void 0 === f && (f = null);
					e.call(this, b, a, c);
					this.oldState = this.newState = null;
					this.oldState = d;
					this.newState = f
				}
				__extends(c, e);
				c.dispatchStateChangeEvent = function(b, a, e, f) {
					void 0 === e && (e = null);
					void 0 === f && (f = null);
					var g = d.Event._getPropertyData(c);
					g.oldState = e;
					g.newState = f;
					d.Event._dispatchByTarget(c, b, a, g)
				};
				c.CURRENT_STATE_CHANGE = "currentStateChange";
				c.CURRENT_STATE_CHANGING = "currentStateChanging";
				c.STATE_CHANGE_COMPLETE = "stateChangeComplete";
				return c
			}(d.Event);
		f.StateChangeEvent = g;
		g.prototype.__class__ = "egret.gui.StateChangeEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					e.call(this, b, a, c)
				}
				__extends(c, e);
				c.dispatchTrackBaseEvent = function(b, a) {
					d.Event._dispatchByTarget(c, b, a)
				};
				c.THUMB_DRAG = "thumbDrag";
				c.THUMB_PRESS = "thumbPress";
				c.THUMB_RELEASE = "thumbRelease";
				return c
			}(d.Event);
		f.TrackBaseEvent = g;
		g.prototype.__class__ = "egret.gui.TrackBaseEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d, f, g) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !0);
					void 0 === d && (d = -1);
					void 0 === f && (f = null);
					void 0 === g && (g = null);
					e.call(this, b, a, c);
					this.itemRenderer = this.item = null;
					this.itemIndex = NaN;
					this.opening = !1;
					this.item = f;
					this.itemRenderer = g;
					this.itemIndex = d
				}
				__extends(c, e);
				c.dispatchTreeEvent = function(b, a, e, f, g, s) {
					void 0 === e && (e = -1);
					void 0 === f && (f = null);
					void 0 === g && (g = null);
					void 0 === s && (s = !1);
					var r = d.Event._getPropertyData(c);
					r.itemIndex = e;
					r.item = f;
					r.itemRenderer = g;
					r.opening = s;
					d.Event._dispatchByTarget(c, b, a, r)
				};
				c.ITEM_CLOSE = "itemClose";
				c.ITEM_OPEN = "itemOpen";
				c.ITEM_OPENING = "itemOpening";
				return c
			}(d.Event);
		f.TreeEvent = g;
		g.prototype.__class__ = "egret.gui.TreeEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c(b, a, c, d) {
					void 0 === a && (a = !1);
					void 0 === c && (c = !1);
					void 0 === d && (d = null);
					e.call(this, b, a, c);
					this.effectInstance = d
				}
				__extends(c, e);
				c.EFFECT_END = "effectEnd";
				c.EFFECT_STOP = "effectStop";
				c.EFFECT_START = "effectStart";
				c.EFFECT_REPEAT = "effectRepeat";
				c.EFFECT_UPDATE = "effectUpdate";
				return c
			}(d.Event);
		f.EffectEvent = g;
		g.prototype.__class__ = "egret.gui.EffectEvent"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._target = null;
					this._useVirtualLayout = !1;
					this._typicalLayoutRect = null
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "target", {
					get: function() {
						return this._target
					},
					set: function(a) {
						this._target != a && (this._target = a, this.clearVirtualLayoutCache())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "useVirtualLayout", {
					get: function() {
						return this._useVirtualLayout
					},
					set: function(a) {
						this._useVirtualLayout != a && (this._useVirtualLayout = a, this.dispatchEventWith("useVirtualLayoutChanged"), this._useVirtualLayout && !a && this.clearVirtualLayoutCache(), this.target && this.target.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "typicalLayoutRect", {
					get: function() {
						return this._typicalLayoutRect
					},
					set: function(a) {
						this._typicalLayoutRect != a && (this._typicalLayoutRect = a, this.target && this.target.invalidateSize())
					},
					enumerable: !0,
					configurable: !0
				});
				b.scrollPositionChanged = function() {};
				b.clearVirtualLayoutCache = function() {};
				b.elementAdded = function(a) {};
				b.elementRemoved = function(a) {};
				b.measure = function() {};
				b.updateDisplayList = function(a, b) {};
				return c
			}(d.EventDispatcher);
		f.LayoutBase = g;
		g.prototype.__class__ = "egret.gui.LayoutBase"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._mouseWheelSpeed = 20
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "useVirtualLayout", {
					set: function(a) {},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "mouseWheelSpeed", {
					get: function() {
						return this._mouseWheelSpeed
					},
					set: function(a) {
						0 == a && (a = 1);
						this._mouseWheelSpeed = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.getElementBoundsLeftOfScrollRect = function(a) {
					var b = new d.Rectangle;
					b.x = a.x - this._mouseWheelSpeed;
					b.right = a.x;
					return b
				};
				b.getElementBoundsRightOfScrollRect = function(a) {
					var b = new d.Rectangle;
					b.x = a.right;
					b.right = a.right + this._mouseWheelSpeed;
					return b
				};
				b.getElementBoundsAboveScrollRect = function(a) {
					var b = new d.Rectangle;
					b.y = a.y - this._mouseWheelSpeed;
					b.bottom = a.y;
					return b
				};
				b.getElementBoundsBelowScrollRect = function(a) {
					var b = new d.Rectangle;
					b.y = a.bottom;
					b.bottom = a.bottom + this._mouseWheelSpeed;
					return b
				};
				b.measure = function() {
					e.prototype.measure.call(this);
					if (null != this.target) {
						for (var a = 0, b = 0, c = this.target.numElements, d = 0; d < c; d++) {
							var f = this.target.getElementAt(d);
							if (f && f.includeInLayout) {
								var g = f.horizontalCenter,
									k = f.verticalCenter,
									l = f.left,
									m = f.right,
									n = f.top,
									p = f.bottom;
								isNaN(l) || isNaN(m) ? isNaN(g) ? isNaN(l) && isNaN(m) ? g = f.preferredX : (g = isNaN(l) ? 0 : l, g += isNaN(m) ? 0 : m) : g = 2 * Math.abs(g) : g = l + m;
								isNaN(n) || isNaN(p) ? isNaN(k) ? isNaN(n) && isNaN(p) ? k = f.preferredY : (k = isNaN(n) ? 0 : n, k += isNaN(p) ? 0 : p) : k = 2 * Math.abs(k) : k = n + p;
								p = f.preferredHeight;
								a = Math.ceil(Math.max(a, g + f.preferredWidth));
								b = Math.ceil(Math.max(b, k + p))
							}
						}
						this.target.measuredWidth = a;
						this.target.measuredHeight = b
					}
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					if (null != this.target) {
						for (var c = this.target.numElements, d = 0, f = 0, g = 0; g < c; g++) {
							var k = this.target.getElementAt(g);
							if (null != k && k.includeInLayout) {
								var l = k.horizontalCenter,
									m = k.verticalCenter,
									n = k.left,
									p = k.right,
									q = k.top,
									x = k.bottom,
									z = k.percentWidth,
									t = k.percentHeight,
									y = NaN,
									w = NaN;
								isNaN(n) || isNaN(p) ? isNaN(z) || (y = Math.round(a * Math.min(0.01 * z, 1))) : y = a - p - n;
								isNaN(q) || isNaN(x) ? isNaN(t) || (w = Math.round(b * Math.min(0.01 * t, 1))) : w = b - x - q;
								k.setLayoutBoundsSize(y, w);
								z = k.layoutBoundsWidth;
								t = k.layoutBoundsHeight;
								w = y = NaN;
								y = isNaN(l) ? isNaN(n) ? isNaN(p) ? k.layoutBoundsX : a - z - p : n : Math.round((a - z) / 2 + l);
								w = isNaN(m) ? isNaN(q) ? isNaN(x) ? k.layoutBoundsY : b - t - x : q : Math.round((b - t) / 2 + m);
								k.setLayoutBoundsPosition(y, w);
								d = Math.max(d, y + z);
								f = Math.max(f, w + t)
							}
						}
						this.target.setContentSize(d, f)
					}
				};
				return c
			}(f.LayoutBase);
		f.BasicLayout = g;
		g.prototype.__class__ = "egret.gui.BasicLayout"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.LEFT = "left";
				e.JUSTIFY_USING_GAP = "justifyUsingGap";
				e.JUSTIFY_USING_WIDTH = "justifyUsingWidth";
				return e
			}();
		d.ColumnAlign = g;
		g.prototype.__class__ = "egret.gui.ColumnAlign"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.TOP = "top";
				e.JUSTIFY_USING_GAP = "justifyUsingGap";
				e.JUSTIFY_USING_HEIGHT = "justifyUsingHeight";
				return e
			}();
		d.RowAlign = g;
		g.prototype.__class__ = "egret.gui.RowAlign"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e() {}
				e.ROWS = "rows";
				e.COLUMNS = "columns";
				return e
			}();
		d.TileOrientation = g;
		g.prototype.__class__ = "egret.gui.TileOrientation"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(c) {
				function b() {
					c.call(this);
					this._horizontalAlign = d.HorizontalAlign.LEFT;
					this._verticalAlign = d.VerticalAlign.TOP;
					this._gap = 6;
					this._padding = 0;
					this._paddingBottom = this._paddingTop = this._paddingRight = this._paddingLeft = NaN;
					this.elementSizeTable = [];
					this.endIndex = this.startIndex = -1;
					this.indexInViewCalculated = !1;
					this.maxElementWidth = 0
				}
				__extends(b, c);
				var a = b.prototype;
				Object.defineProperty(a, "horizontalAlign", {
					get: function() {
						return this._horizontalAlign
					},
					set: function(a) {
						this._horizontalAlign != a && (this._horizontalAlign = a, this.target && this.target.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "verticalAlign", {
					get: function() {
						return this._verticalAlign
					},
					set: function(a) {
						this._verticalAlign != a && (this._verticalAlign = a, this.target && this.target.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "gap", {
					get: function() {
						return this._gap
					},
					set: function(a) {
						this._gap != a && (this._gap = a, this.invalidateTargetSizeAndDisplayList(), this.hasEventListener("gapChanged") && this.dispatchEventWith("gapChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "padding", {
					get: function() {
						return this._padding
					},
					set: function(a) {
						this._padding != a && (this._padding = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingLeft", {
					get: function() {
						return this._paddingLeft
					},
					set: function(a) {
						this._paddingLeft != a && (this._paddingLeft = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingRight", {
					get: function() {
						return this._paddingRight
					},
					set: function(a) {
						this._paddingRight != a && (this._paddingRight = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingTop", {
					get: function() {
						return this._paddingTop
					},
					set: function(a) {
						this._paddingTop != a && (this._paddingTop = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingBottom", {
					get: function() {
						return this._paddingBottom
					},
					set: function(a) {
						this._paddingBottom != a && (this._paddingBottom = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				a.invalidateTargetSizeAndDisplayList = function() {
					this.target && (this.target.invalidateSize(), this.target.invalidateDisplayList())
				};
				a.measure = function() {
					c.prototype.measure.call(this);
					this.target && (this.useVirtualLayout ? this.measureVirtual() : this.measureReal())
				};
				a.measureVirtual = function() {
					for (var a = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22, b = Math.max(this.maxElementWidth, this.typicalLayoutRect ? this.typicalLayoutRect.width : 71), c = this.getElementTotalSize(), e = this.target.getElementIndicesInView(), d = e.length, f = 0; f < d; f++) {
						var g = e[f],
							m = this.target.getElementAt(g);
						if (null != m && m.includeInLayout) var n = m.preferredWidth,
							c = c + m.preferredHeight,
							c = c - (isNaN(this.elementSizeTable[g]) ? a : this.elementSizeTable[g]),
							b = Math.max(b, n)
					}
					f = isNaN(this._padding) ? 0 : this._padding;
					a = isNaN(this._paddingLeft) ? f : this._paddingLeft;
					e = isNaN(this._paddingRight) ? f : this._paddingRight;
					d = isNaN(this._paddingTop) ? f : this._paddingTop;
					f = isNaN(this._paddingBottom) ? f : this._paddingBottom;
					d += f;
					this.target.measuredWidth = Math.ceil(b + (a + e));
					this.target.measuredHeight = Math.ceil(c + d)
				};
				a.measureReal = function() {
					for (var a = this.target.numElements, b = a, c = 0, e = 0, d = 0; d < a; d++) {
						var f = this.target.getElementAt(d);
						if (f && f.includeInLayout) var g = f.preferredWidth,
							e = e + f.preferredHeight,
							c = Math.max(c, g);
						else b--
					}
					a = isNaN(this._gap) ? 0 : this._gap;
					e += (b - 1) * a;
					f = isNaN(this._padding) ? 0 : this._padding;
					b = isNaN(this._paddingLeft) ? f : this._paddingLeft;
					a = isNaN(this._paddingRight) ? f : this._paddingRight;
					d = isNaN(this._paddingTop) ? f : this._paddingTop;
					f = isNaN(this._paddingBottom) ? f : this._paddingBottom;
					d += f;
					this.target.measuredWidth = Math.ceil(c + (b + a));
					this.target.measuredHeight = Math.ceil(e + d)
				};
				a.updateDisplayList = function(a, b) {
					c.prototype.updateDisplayList.call(this, a, b);
					if (this.target) if (0 == this.target.numElements) {
						var e = isNaN(this._padding) ? 0 : this._padding,
							d = isNaN(this._paddingLeft) ? e : this._paddingLeft,
							f = isNaN(this._paddingRight) ? e : this._paddingRight,
							g = isNaN(this._paddingTop) ? e : this._paddingTop,
							e = isNaN(this._paddingBottom) ? e : this._paddingBottom;
						this.target.setContentSize(Math.ceil(d + f), Math.ceil(g + e))
					} else this.useVirtualLayout ? this.updateDisplayListVirtual(a, b) : this.updateDisplayListReal(a, b)
				};
				a.getStartPosition = function(a) {
					var b = isNaN(this._padding) ? 0 : this._padding,
						c = isNaN(this._paddingTop) ? b : this._paddingTop,
						b = isNaN(this._gap) ? 0 : this._gap;
					if (!this.useVirtualLayout) {
						var e;
						this.target && (e = this.target.getElementAt(a));
						return e ? e.y : c
					}
					e = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22;
					for (var d = 0; d < a; d++) {
						var f = this.elementSizeTable[d];
						isNaN(f) && (f = e);
						c += f + b
					}
					return c
				};
				a.getElementSize = function(a) {
					return this.useVirtualLayout ? (a = this.elementSizeTable[a], isNaN(a) && (a = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22), a) : this.target ? this.target.getElementAt(a).height : 0
				};
				a.getElementTotalSize = function() {
					for (var a = isNaN(this._gap) ? 0 : this._gap, b = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22, c = 0, e = this.target.numElements, d = 0; d < e; d++) {
						var f = this.elementSizeTable[d];
						isNaN(f) && (f = b);
						c += f + a
					}
					return c - a
				};
				a.elementAdded = function(a) {
					c.prototype.elementAdded.call(this, a);
					this.elementSizeTable.splice(a, 0, this.typicalLayoutRect ? this.typicalLayoutRect.height : 22)
				};
				a.elementRemoved = function(a) {
					c.prototype.elementRemoved.call(this, a);
					this.elementSizeTable.splice(a, 1)
				};
				a.clearVirtualLayoutCache = function() {
					c.prototype.clearVirtualLayoutCache.call(this);
					this.elementSizeTable = [];
					this.maxElementWidth = 0
				};
				a.findIndexAt = function(a, b, c) {
					var e = Math.floor(0.5 * (b + c)),
						d = this.getStartPosition(e),
						f = this.getElementSize(e),
						g = isNaN(this._gap) ? 0 : this._gap;
					return a >= d && a < d + f + g ? e : b == c ? -1 : a < d ? this.findIndexAt(a, b, Math.max(b, e - 1)) : this.findIndexAt(a, Math.min(e + 1, c), c)
				};
				a.scrollPositionChanged = function() {
					c.prototype.scrollPositionChanged.call(this);
					this.useVirtualLayout && this.getIndexInView() && (this.indexInViewCalculated = !0, this.target.invalidateDisplayList())
				};
				a.getIndexInView = function() {
					if (!this.target || 0 == this.target.numElements || isNaN(this.target.width) || 0 == this.target.width || isNaN(this.target.height) || 0 == this.target.height) return this.startIndex = this.endIndex = -1, !1;
					var a = isNaN(this._padding) ? 0 : this._padding,
						b = isNaN(this._paddingTop) ? a : this._paddingTop,
						c = isNaN(this._paddingBottom) ? a : this._paddingBottom,
						a = this.target.numElements,
						e = this.getStartPosition(a - 1) + this.elementSizeTable[a - 1] + c,
						d = this.target.verticalScrollPosition;
					if (d > e - c) return this.endIndex = this.startIndex = -1, !1;
					c = this.target.verticalScrollPosition + this.target.height;
					if (c < b) return this.endIndex = this.startIndex = -1, !1;
					b = this.startIndex;
					e = this.endIndex;
					this.startIndex = this.findIndexAt(d, 0, a - 1); - 1 == this.startIndex && (this.startIndex = 0);
					this.endIndex = this.findIndexAt(c, 0, a - 1); - 1 == this.endIndex && (this.endIndex = a - 1);
					return b != this.startIndex || e != this.endIndex
				};
				a.updateDisplayListVirtual = function(a, b) {
					this.indexInViewCalculated ? this.indexInViewCalculated = !1 : this.getIndexInView();
					var c = isNaN(this._padding) ? 0 : this._padding,
						e = isNaN(this._paddingLeft) ? c : this._paddingLeft,
						f = isNaN(this._paddingRight) ? c : this._paddingRight,
						g = isNaN(this._paddingBottom) ? c : this._paddingBottom,
						l = isNaN(this._gap) ? 0 : this._gap,
						m = this.target.numElements;
					if (-1 == this.startIndex || -1 == this.endIndex) e = this.getStartPosition(m) - l + g, this.target.setContentSize(this.target.contentWidth, Math.ceil(e));
					else {
						this.target.setVirtualElementIndicesInView(this.startIndex, this.endIndex);
						var n = this._horizontalAlign == d.HorizontalAlign.JUSTIFY || this._horizontalAlign == d.HorizontalAlign.CONTENT_JUSTIFY,
							p = this._horizontalAlign == d.HorizontalAlign.CONTENT_JUSTIFY,
							q = 0;
						n || (this._horizontalAlign == d.HorizontalAlign.CENTER ? q = 0.5 : this._horizontalAlign == d.HorizontalAlign.RIGHT && (q = 1));
						var x = Math.max(0, a - e - f),
							z = Math.ceil(x),
							t, y = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22,
							c = Math.max(this.typicalLayoutRect ? this.typicalLayoutRect.width : 71, this.maxElementWidth);
						if (p) {
							for (var w = this.startIndex; w <= this.endIndex; w++)(t = this.target.getVirtualElementAt(w)) && t.includeInLayout && (this.maxElementWidth = Math.max(this.maxElementWidth, t.preferredWidth));
							z = Math.ceil(Math.max(x, this.maxElementWidth))
						}
						for (var A = 0, v = 0, w = 0, F = !1, C = this.startIndex; C <= this.endIndex; C++) if (A = 0, t = this.target.getVirtualElementAt(C)) t.includeInLayout ? (n ? (A = e, t.setLayoutBoundsSize(z, NaN)) : (A = (x - t.layoutBoundsWidth) * q, A = 0 < A ? A : 0, A = e + A), p || (this.maxElementWidth = Math.max(this.maxElementWidth, t.preferredWidth)), w = Math.max(w, t.layoutBoundsWidth), F || (v = isNaN(this.elementSizeTable[C]) ? y : this.elementSizeTable[C], v != t.layoutBoundsHeight && (F = !0)), 0 == C && 0 < this.elementSizeTable.length && this.elementSizeTable[C] != t.layoutBoundsHeight && (this.typicalLayoutRect = null), this.elementSizeTable[C] = t.layoutBoundsHeight, v = this.getStartPosition(C), t.setLayoutBoundsPosition(Math.round(A), Math.round(v))) : this.elementSizeTable[C] = 0;
						w += e + f;
						e = this.getStartPosition(m) - l + g;
						this.target.setContentSize(Math.ceil(w), Math.ceil(e));
						(F || c < this.maxElementWidth) && this.target.invalidateSize()
					}
				};
				a.updateDisplayListReal = function(a, c) {
					var f = isNaN(this._padding) ? 0 : this._padding,
						g = isNaN(this._paddingLeft) ? f : this._paddingLeft,
						r = isNaN(this._paddingRight) ? f : this._paddingRight,
						k = isNaN(this._paddingTop) ? f : this._paddingTop,
						f = isNaN(this._paddingBottom) ? f : this._paddingBottom,
						l = isNaN(this._gap) ? 0 : this._gap,
						m = Math.max(0, a - g - r),
						n = Math.max(0, c - k - f),
						p = this._verticalAlign == d.VerticalAlign.JUSTIFY,
						q = this._horizontalAlign == d.HorizontalAlign.JUSTIFY || this._horizontalAlign == d.HorizontalAlign.CONTENT_JUSTIFY,
						x = 0;
					q || (this._horizontalAlign == d.HorizontalAlign.CENTER ? x = 0.5 : this._horizontalAlign == d.HorizontalAlign.RIGHT && (x = 1));
					var z = this.target.numElements,
						t = z,
						y = g,
						w = k,
						A, v, F = 0,
						y = 0,
						C = [],
						E, B = n;
					for (A = 0; A < z; A++)(v = this.target.getElementAt(A)) && v.includeInLayout ? (this.maxElementWidth = Math.max(this.maxElementWidth, v.preferredWidth), p ? F += v.preferredHeight : isNaN(v.percentHeight) ? B -= v.preferredHeight : (y += v.percentHeight, E = new e, E.layoutElement = v, E.percent = v.percentHeight, E.min = v.minHeight, E.max = v.maxHeight, C.push(E))) : t--;
					var B = B - (t - 1) * l,
						B = 0 < B ? B : 0,
						H = n - F - l * (t - 1),
						G, I = t,
						J = [];
					if (p) {
						if (0 > H) {
							G = B / t;
							for (A = 0; A < z; A++)(v = this.target.getElementAt(A)) && v.includeInLayout && (v = v.preferredHeight, v <= G && (B -= v, I--));
							B = 0 < B ? B : 0
						}
					} else if (0 < y) {
						b.flexChildrenProportionally(n, B, y, C);
						n = 0;
						v = C.length;
						for (A = 0; A < v; A++) E = C[A], y = Math.round(E.size + n), n += E.size - y, J[E.layoutElement.hashCode] = y, B -= y;
						B = 0 < B ? B : 0
					}
					this._verticalAlign == d.VerticalAlign.MIDDLE ? w = k + 0.5 * B : this._verticalAlign == d.VerticalAlign.BOTTOM && (w = k + B);
					C = g;
					v = t = 0;
					E = Math.ceil(m);
					this._horizontalAlign == d.HorizontalAlign.CONTENT_JUSTIFY && (E = Math.ceil(Math.max(m, this.maxElementWidth)));
					n = 0;
					t = NaN;
					for (A = 0; A < z; A++) y = 0, (v = this.target.getElementAt(A)) && v.includeInLayout && (t = NaN, p ? (y = NaN, 0 < H ? y = B * v.preferredHeight / F : 0 > H && v.preferredHeight > G && (y = B / I), isNaN(y) || (t = Math.round(y + n), n += y - t)) : t = J[v.hashCode], q ? (y = g, v.setLayoutBoundsSize(E, t)) : (y = NaN, isNaN(v.percentWidth) || (y = Math.min(100, v.percentWidth), y = Math.round(m * y * 0.01)), v.setLayoutBoundsSize(y, t), y = (m - v.layoutBoundsWidth) * x, y = 0 < y ? y : 0, y = g + y), v.setLayoutBoundsPosition(Math.round(y), Math.round(w)), t = Math.ceil(v.layoutBoundsWidth), v = Math.ceil(v.layoutBoundsHeight), C = Math.max(C, y + t), k = Math.max(k, w + v), w += v + l);
					this.target.setContentSize(Math.ceil(C + r), Math.ceil(k + f))
				};
				b.flexChildrenProportionally = function(a, b, c, e) {
					var d = e.length,
						f;
					do {
						f = !0;
						var g = b - a * c / 100;
						0 < g ? b -= g : g = 0;
						for (var m = b / c, n = 0; n < d; n++) {
							var p = e[n],
								q = p.percent * m;
							if (q < p.min) {
								f = p.min;
								p.size = f;
								e[n] = e[--d];
								e[d] = p;
								c -= p.percent;
								g >= f || (b -= f - g);
								f = !1;
								break
							} else if (q > p.max) {
								f = p.max;
								p.size = f;
								e[n] = e[--d];
								e[d] = p;
								c -= p.percent;
								g >= f || (b -= f - g);
								f = !1;
								break
							} else p.size = q
						}
					} while (!f)
				};
				return b
			}(f.LayoutBase);
		f.VerticalLayout = g;
		g.prototype.__class__ = "egret.gui.VerticalLayout";
		var e = function() {
				return function() {
					this.layoutElement = null;
					this.size = 0;
					this.max = this.min = this.percent = NaN
				}
			}();
		e.prototype.__class__ = "egret.gui.ChildInfo"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(c) {
				function b() {
					c.call(this);
					this._horizontalAlign = d.HorizontalAlign.LEFT;
					this._verticalAlign = d.VerticalAlign.TOP;
					this._gap = 6;
					this._padding = 0;
					this._paddingBottom = this._paddingTop = this._paddingRight = this._paddingLeft = NaN;
					this.elementSizeTable = [];
					this.endIndex = this.startIndex = -1;
					this.indexInViewCalculated = !1;
					this.maxElementHeight = 0
				}
				__extends(b, c);
				var a = b.prototype;
				Object.defineProperty(a, "horizontalAlign", {
					get: function() {
						return this._horizontalAlign
					},
					set: function(a) {
						this._horizontalAlign != a && (this._horizontalAlign = a, this.target && this.target.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "verticalAlign", {
					get: function() {
						return this._verticalAlign
					},
					set: function(a) {
						this._verticalAlign != a && (this._verticalAlign = a, this.target && this.target.invalidateDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "gap", {
					get: function() {
						return this._gap
					},
					set: function(a) {
						this._gap != a && (this._gap = a, this.invalidateTargetSizeAndDisplayList(), this.hasEventListener("gapChanged") && this.dispatchEventWith("gapChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "padding", {
					get: function() {
						return this._padding
					},
					set: function(a) {
						this._padding != a && (this._padding = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingLeft", {
					get: function() {
						return this._paddingLeft
					},
					set: function(a) {
						this._paddingLeft != a && (this._paddingLeft = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingRight", {
					get: function() {
						return this._paddingRight
					},
					set: function(a) {
						this._paddingRight != a && (this._paddingRight = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingTop", {
					get: function() {
						return this._paddingTop
					},
					set: function(a) {
						this._paddingTop != a && (this._paddingTop = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "paddingBottom", {
					get: function() {
						return this._paddingBottom
					},
					set: function(a) {
						this._paddingBottom != a && (this._paddingBottom = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				a.invalidateTargetSizeAndDisplayList = function() {
					this.target && (this.target.invalidateSize(), this.target.invalidateDisplayList())
				};
				a.measure = function() {
					c.prototype.measure.call(this);
					this.target && (this.useVirtualLayout ? this.measureVirtual() : this.measureReal())
				};
				a.measureVirtual = function() {
					for (var a = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22, b = this.typicalLayoutRect ? this.typicalLayoutRect.width : 71, c = this.getElementTotalSize(), a = Math.max(this.maxElementHeight, a), e = this.target.getElementIndicesInView(), d = e.length, f = 0; f < d; f++) {
						var g = e[f],
							m = this.target.getElementAt(g);
						if (null != m && m.includeInLayout) var n = m.preferredHeight,
							c = c + m.preferredWidth,
							c = c - (isNaN(this.elementSizeTable[g]) ? b : this.elementSizeTable[g]),
							a = Math.max(a, n)
					}
					f = isNaN(this._padding) ? 0 : this._padding;
					b = isNaN(this._paddingLeft) ? f : this._paddingLeft;
					e = isNaN(this._paddingRight) ? f : this._paddingRight;
					d = isNaN(this._paddingTop) ? f : this._paddingTop;
					f = isNaN(this._paddingBottom) ? f : this._paddingBottom;
					d += f;
					this.target.measuredWidth = Math.ceil(c + (b + e));
					this.target.measuredHeight = Math.ceil(a + d)
				};
				a.measureReal = function() {
					for (var a = this.target.numElements, b = a, c = 0, e = 0, d = 0; d < a; d++) {
						var f = this.target.getElementAt(d);
						if (f && f.includeInLayout) var g = f.preferredHeight,
							c = c + f.preferredWidth,
							e = Math.max(e, g);
						else b--
					}
					a = isNaN(this._gap) ? 0 : this._gap;
					c += (b - 1) * a;
					f = isNaN(this._padding) ? 0 : this._padding;
					b = isNaN(this._paddingLeft) ? f : this._paddingLeft;
					a = isNaN(this._paddingRight) ? f : this._paddingRight;
					d = isNaN(this._paddingTop) ? f : this._paddingTop;
					f = isNaN(this._paddingBottom) ? f : this._paddingBottom;
					d += f;
					this.target.measuredWidth = Math.ceil(c + (b + a));
					this.target.measuredHeight = Math.ceil(e + d)
				};
				a.updateDisplayList = function(a, b) {
					c.prototype.updateDisplayList.call(this, a, b);
					if (this.target) if (0 == this.target.numElements) {
						var e = isNaN(this._padding) ? 0 : this._padding,
							d = isNaN(this._paddingLeft) ? e : this._paddingLeft,
							f = isNaN(this._paddingRight) ? e : this._paddingRight,
							g = isNaN(this._paddingTop) ? e : this._paddingTop,
							e = isNaN(this._paddingBottom) ? e : this._paddingBottom;
						this.target.setContentSize(Math.ceil(d + f), Math.ceil(g + e))
					} else this.useVirtualLayout ? this.updateDisplayListVirtual(a, b) : this.updateDisplayListReal(a, b)
				};
				a.getStartPosition = function(a) {
					var b = isNaN(this._padding) ? 0 : this._padding,
						c = isNaN(this._paddingLeft) ? b : this._paddingLeft,
						b = isNaN(this._gap) ? 0 : this._gap;
					if (!this.useVirtualLayout) {
						var e;
						this.target && (e = this.target.getElementAt(a));
						return e ? e.x : c
					}
					e = this.typicalLayoutRect ? this.typicalLayoutRect.width : 71;
					for (var d = 0; d < a; d++) {
						var f = this.elementSizeTable[d];
						isNaN(f) && (f = e);
						c += f + b
					}
					return c
				};
				a.getElementSize = function(a) {
					return this.useVirtualLayout ? (a = this.elementSizeTable[a], isNaN(a) && (a = this.typicalLayoutRect ? this.typicalLayoutRect.width : 71), a) : this.target ? this.target.getElementAt(a).width : 0
				};
				a.getElementTotalSize = function() {
					for (var a = this.typicalLayoutRect ? this.typicalLayoutRect.width : 71, b = isNaN(this._gap) ? 0 : this._gap, c = 0, e = this.target.numElements, d = 0; d < e; d++) {
						var f = this.elementSizeTable[d];
						isNaN(f) && (f = a);
						c += f + b
					}
					return c - b
				};
				a.elementAdded = function(a) {
					this.useVirtualLayout && (c.prototype.elementAdded.call(this, a), this.elementSizeTable.splice(a, 0, this.typicalLayoutRect ? this.typicalLayoutRect.width : 71))
				};
				a.elementRemoved = function(a) {
					this.useVirtualLayout && (c.prototype.elementRemoved.call(this, a), this.elementSizeTable.splice(a, 1))
				};
				a.clearVirtualLayoutCache = function() {
					this.useVirtualLayout && (c.prototype.clearVirtualLayoutCache.call(this), this.elementSizeTable = [], this.maxElementHeight = 0)
				};
				a.findIndexAt = function(a, b, c) {
					var e = Math.floor(0.5 * (b + c)),
						d = this.getStartPosition(e),
						f = this.getElementSize(e),
						g = isNaN(this._gap) ? 0 : this._gap;
					return a >= d && a < d + f + g ? e : b == c ? -1 : a < d ? this.findIndexAt(a, b, Math.max(b, e - 1)) : this.findIndexAt(a, Math.min(e + 1, c), c)
				};
				a.scrollPositionChanged = function() {
					c.prototype.scrollPositionChanged.call(this);
					this.useVirtualLayout && this.getIndexInView() && (this.indexInViewCalculated = !0, this.target.invalidateDisplayList())
				};
				a.getIndexInView = function() {
					if (!this.target || 0 == this.target.numElements || isNaN(this.target.width) || 0 == this.target.width || isNaN(this.target.height) || 0 == this.target.height) return this.startIndex = this.endIndex = -1, !1;
					var a = isNaN(this._padding) ? 0 : this._padding,
						b = isNaN(this._paddingLeft) ? a : this._paddingLeft,
						c = isNaN(this._paddingRight) ? a : this._paddingRight;
					isNaN(this._paddingTop);
					isNaN(this._paddingBottom);
					var a = this.target.numElements,
						e = this.getStartPosition(a - 1) + this.elementSizeTable[a - 1] + c,
						d = this.target.horizontalScrollPosition;
					if (d > e - c) return this.endIndex = this.startIndex = -1, !1;
					c = this.target.horizontalScrollPosition + this.target.width;
					if (c < b) return this.endIndex = this.startIndex = -1, !1;
					b = this.startIndex;
					e = this.endIndex;
					this.startIndex = this.findIndexAt(d, 0, a - 1); - 1 == this.startIndex && (this.startIndex = 0);
					this.endIndex = this.findIndexAt(c, 0, a - 1); - 1 == this.endIndex && (this.endIndex = a - 1);
					return b != this.startIndex || e != this.endIndex
				};
				a.updateDisplayListVirtual = function(a, b) {
					this.indexInViewCalculated ? this.indexInViewCalculated = !1 : this.getIndexInView();
					var c = isNaN(this._padding) ? 0 : this._padding,
						e = isNaN(this._paddingRight) ? c : this._paddingRight,
						f = isNaN(this._paddingTop) ? c : this._paddingTop,
						g = isNaN(this._paddingBottom) ? c : this._paddingBottom,
						l = isNaN(this._gap) ? 0 : this._gap,
						m = this.target.numElements;
					if (-1 == this.startIndex || -1 == this.endIndex) e = this.getStartPosition(m) - l + e, this.target.setContentSize(Math.ceil(e), this.target.contentHeight);
					else {
						this.target.setVirtualElementIndicesInView(this.startIndex, this.endIndex);
						var n = this._verticalAlign == d.VerticalAlign.JUSTIFY || this._verticalAlign == d.VerticalAlign.CONTENT_JUSTIFY,
							p = this._verticalAlign == d.VerticalAlign.CONTENT_JUSTIFY,
							q = 0;
						n || (this._verticalAlign == d.VerticalAlign.MIDDLE ? q = 0.5 : this._verticalAlign == d.VerticalAlign.BOTTOM && (q = 1));
						var x = Math.max(0, b - f - g),
							z = Math.ceil(x),
							t, y = this.typicalLayoutRect ? this.typicalLayoutRect.width : 71,
							c = Math.max(this.typicalLayoutRect ? this.typicalLayoutRect.height : 22, this.maxElementHeight);
						if (p) {
							for (var w = this.startIndex; w <= this.endIndex; w++)(t = this.target.getVirtualElementAt(w)) && t.includeInLayout && (this.maxElementHeight = Math.max(this.maxElementHeight, t.preferredHeight));
							z = Math.ceil(Math.max(x, this.maxElementHeight))
						}
						for (var A = 0, v = 0, w = 0, F = !1, C = this.startIndex; C <= this.endIndex; C++) if (v = 0, t = this.target.getVirtualElementAt(C)) t.includeInLayout ? (n ? (v = f, t.setLayoutBoundsSize(NaN, z)) : (v = (x - t.layoutBoundsHeight) * q, v = 0 < v ? v : 0, v = f + v), p || (this.maxElementHeight = Math.max(this.maxElementHeight, t.preferredHeight)), w = Math.max(w, t.layoutBoundsHeight), F || (A = isNaN(this.elementSizeTable[C]) ? y : this.elementSizeTable[C], A != t.layoutBoundsWidth && (F = !0)), 0 == C && 0 < this.elementSizeTable.length && this.elementSizeTable[C] != t.layoutBoundsWidth && (this.typicalLayoutRect = null), this.elementSizeTable[C] = t.layoutBoundsWidth, A = this.getStartPosition(C), t.setLayoutBoundsPosition(Math.round(A), Math.round(v))) : this.elementSizeTable[C] = 0;
						w += f + g;
						e = this.getStartPosition(m) - l + e;
						this.target.setContentSize(Math.ceil(e), Math.ceil(w));
						(F || c < this.maxElementHeight) && this.target.invalidateSize()
					}
				};
				a.updateDisplayListReal = function(a, c) {
					var f = isNaN(this._padding) ? 0 : this._padding,
						g = isNaN(this._paddingLeft) ? f : this._paddingLeft,
						r = isNaN(this._paddingRight) ? f : this._paddingRight,
						k = isNaN(this._paddingTop) ? f : this._paddingTop,
						f = isNaN(this._paddingBottom) ? f : this._paddingBottom,
						l = isNaN(this._gap) ? 0 : this._gap,
						m = Math.max(0, a - g - r),
						n = Math.max(0, c - k - f),
						p = this._horizontalAlign == d.HorizontalAlign.JUSTIFY,
						q = this._verticalAlign == d.VerticalAlign.JUSTIFY || this._verticalAlign == d.VerticalAlign.CONTENT_JUSTIFY,
						x = 0;
					q || (this._verticalAlign == d.VerticalAlign.MIDDLE ? x = 0.5 : this._verticalAlign == d.VerticalAlign.BOTTOM && (x = 1));
					var z = this.target.numElements,
						t = z,
						y = g,
						w = k,
						A, v, F = 0,
						w = 0,
						C = [],
						E, B = m;
					for (A = 0; A < z; A++)(v = this.target.getElementAt(A)) && v.includeInLayout ? (this.maxElementHeight = Math.max(this.maxElementHeight, v.preferredHeight), p ? F += v.preferredWidth : isNaN(v.percentWidth) ? B -= v.preferredWidth : (w += v.percentWidth, E = new e, E.layoutElement = v, E.percent = v.percentWidth, E.min = v.minWidth, E.max = v.maxWidth, C.push(E))) : t--;
					var B = B - l * (t - 1),
						B = 0 < B ? B : 0,
						H = m - F - l * (t - 1),
						G, I = t,
						J = [];
					if (p) {
						if (0 > H) {
							G = B / t;
							for (A = 0; A < z; A++)(v = this.target.getElementAt(A)) && v.includeInLayout && (v = v.preferredWidth, v <= G && (B -= v, I--));
							B = 0 < B ? B : 0
						}
					} else if (0 < w) {
						b.flexChildrenProportionally(m, B, w, C);
						m = 0;
						v = C.length;
						for (A = 0; A < v; A++) E = C[A], w = Math.round(E.size + m), m += E.size - w, J[E.layoutElement.hashCode] = w, B -= w;
						B = 0 < B ? B : 0
					}
					this._horizontalAlign == d.HorizontalAlign.CENTER ? y = g + 0.5 * B : this._horizontalAlign == d.HorizontalAlign.RIGHT && (y = g + B);
					C = k;
					v = t = 0;
					E = Math.ceil(n);
					this._verticalAlign == d.VerticalAlign.CONTENT_JUSTIFY && (E = Math.ceil(Math.max(n, this.maxElementHeight)));
					for (A = m = 0; A < z; A++) w = 0, (v = this.target.getElementAt(A)) && v.includeInLayout && (t = NaN, p ? (w = NaN, 0 < H ? w = B * v.preferredWidth / F : 0 > H && v.preferredWidth > G && (w = B / I), isNaN(w) || (t = Math.round(w + m), m += w - t)) : t = J[v.hashCode], q ? (w = k, v.setLayoutBoundsSize(t, E)) : (w = NaN, isNaN(v.percentHeight) || (w = Math.min(100, v.percentHeight), w = Math.round(n * w * 0.01)), v.setLayoutBoundsSize(t, w), w = (n - v.layoutBoundsHeight) * x, w = 0 < w ? w : 0, w = k + w), v.setLayoutBoundsPosition(Math.round(y), Math.round(w)), t = Math.ceil(v.layoutBoundsWidth), v = Math.ceil(v.layoutBoundsHeight), g = Math.max(g, y + t), C = Math.max(C, w + v), y += t + l);
					this.target.setContentSize(Math.ceil(g + r), Math.ceil(C + f))
				};
				b.flexChildrenProportionally = function(a, b, c, e) {
					var d = e.length,
						f;
					do {
						f = !0;
						var g = b - a * c / 100;
						0 < g ? b -= g : g = 0;
						for (var m = b / c, n = 0; n < d; n++) {
							var p = e[n],
								q = p.percent * m;
							if (q < p.min) {
								f = p.min;
								p.size = f;
								e[n] = e[--d];
								e[d] = p;
								c -= p.percent;
								g >= f || (b -= f - g);
								f = !1;
								break
							} else if (q > p.max) {
								f = p.max;
								p.size = f;
								e[n] = e[--d];
								e[d] = p;
								c -= p.percent;
								g >= f || (b -= f - g);
								f = !1;
								break
							} else p.size = q
						}
					} while (!f)
				};
				return b
			}(f.LayoutBase);
		f.HorizontalLayout = g;
		g.prototype.__class__ = "egret.gui.HorizontalLayout";
		var e = function() {
				return function() {
					this.layoutElement = null;
					this.size = 0;
					this.max = this.min = this.percent = NaN
				}
			}();
		e.prototype.__class__ = "egret.gui.ChildInfo"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.explicitHorizontalGap = NaN;
					this._horizontalGap = 6;
					this.explicitVerticalGap = NaN;
					this._verticalGap = 6;
					this._columnCount = -1;
					this._requestedColumnCount = 0;
					this._rowCount = -1;
					this._requestedRowCount = 0;
					this._rowHeight = this.explicitRowHeight = this._columnWidth = this.explicitColumnWidth = NaN;
					this._padding = 0;
					this._paddingBottom = this._paddingTop = this._paddingRight = this._paddingLeft = NaN;
					this._horizontalAlign = d.HorizontalAlign.JUSTIFY;
					this._verticalAlign = d.VerticalAlign.JUSTIFY;
					this._columnAlign = f.ColumnAlign.LEFT;
					this._rowAlign = f.RowAlign.TOP;
					this._orientation = f.TileOrientation.ROWS;
					this.maxElementHeight = this.maxElementWidth = 0;
					this.endIndex = this.startIndex = -1;
					this.indexInViewCalculated = !1
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "horizontalGap", {
					get: function() {
						return this._horizontalGap
					},
					set: function(a) {
						a != this._horizontalGap && (this._horizontalGap = this.explicitHorizontalGap = a, this.invalidateTargetSizeAndDisplayList(), this.hasEventListener("gapChanged") && this.dispatchEventWith("gapChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalGap", {
					get: function() {
						return this._verticalGap
					},
					set: function(a) {
						a != this._verticalGap && (this._verticalGap = this.explicitVerticalGap = a, this.invalidateTargetSizeAndDisplayList(), this.hasEventListener("gapChanged") && this.dispatchEventWith("gapChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "columnCount", {
					get: function() {
						return this._columnCount
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "requestedColumnCount", {
					get: function() {
						return this._requestedColumnCount
					},
					set: function(a) {
						this._requestedColumnCount != a && (this._columnCount = this._requestedColumnCount = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "rowCount", {
					get: function() {
						return this._rowCount
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "requestedRowCount", {
					get: function() {
						return this._requestedRowCount
					},
					set: function(a) {
						this._requestedRowCount != a && (this._rowCount = this._requestedRowCount = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "columnWidth", {
					get: function() {
						return this._columnWidth
					},
					set: function(a) {
						a != this._columnWidth && (this._columnWidth = this.explicitColumnWidth = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "rowHeight", {
					get: function() {
						return this._rowHeight
					},
					set: function(a) {
						a != this._rowHeight && (this._rowHeight = this.explicitRowHeight = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "padding", {
					get: function() {
						return this._padding
					},
					set: function(a) {
						this._padding != a && (this._padding = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingLeft", {
					get: function() {
						return this._paddingLeft
					},
					set: function(a) {
						this._paddingLeft != a && (this._paddingLeft = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingRight", {
					get: function() {
						return this._paddingRight
					},
					set: function(a) {
						this._paddingRight != a && (this._paddingRight = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingTop", {
					get: function() {
						return this._paddingTop
					},
					set: function(a) {
						this._paddingTop != a && (this._paddingTop = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "paddingBottom", {
					get: function() {
						return this._paddingBottom
					},
					set: function(a) {
						this._paddingBottom != a && (this._paddingBottom = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "horizontalAlign", {

					get: function() {
						return this._horizontalAlign
					},
					set: function(a) {
						this._horizontalAlign != a && (this._horizontalAlign = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "verticalAlign", {
					get: function() {
						return this._verticalAlign
					},
					set: function(a) {
						this._verticalAlign != a && (this._verticalAlign = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "columnAlign", {
					get: function() {
						return this._columnAlign
					},
					set: function(a) {
						this._columnAlign != a && (this._columnAlign = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "rowAlign", {
					get: function() {
						return this._rowAlign
					},
					set: function(a) {
						this._rowAlign != a && (this._rowAlign = a, this.invalidateTargetSizeAndDisplayList())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "orientation", {
					get: function() {
						return this._orientation
					},
					set: function(a) {
						this._orientation != a && (this._orientation = a, this.invalidateTargetSizeAndDisplayList(), this.hasEventListener("orientationChanged") && this.dispatchEventWith("orientationChanged"))
					},
					enumerable: !0,
					configurable: !0
				});
				b.invalidateTargetSizeAndDisplayList = function() {
					this.target && (this.target.invalidateSize(), this.target.invalidateDisplayList())
				};
				b.measure = function() {
					if (this.target) {
						var a = this._columnCount,
							b = this._rowCount,
							c = this._columnWidth,
							e = this._rowHeight,
							d = 0,
							f = 0;
						this.calculateRowAndColumn(this.target.explicitWidth, this.target.explicitHeight);
						var g = 0 < this._requestedColumnCount ? this._requestedColumnCount : this._columnCount,
							l = 0 < this._requestedRowCount ? this._requestedRowCount : this._rowCount,
							m = isNaN(this._horizontalGap) ? 0 : this._horizontalGap,
							n = isNaN(this._verticalGap) ? 0 : this._verticalGap;
						0 < g && (d = g * (this._columnWidth + m) - m);
						0 < l && (f = l * (this._rowHeight + n) - n);
						n = isNaN(this._padding) ? 0 : this._padding;
						g = isNaN(this._paddingLeft) ? n : this._paddingLeft;
						l = isNaN(this._paddingRight) ? n : this._paddingRight;
						m = isNaN(this._paddingTop) ? n : this._paddingTop;
						n = isNaN(this._paddingBottom) ? n : this._paddingBottom;
						m += n;
						this.target.measuredWidth = Math.ceil(d + (g + l));
						this.target.measuredHeight = Math.ceil(f + m);
						this._columnCount = a;
						this._rowCount = b;
						this._columnWidth = c;
						this._rowHeight = e
					}
				};
				b.calculateRowAndColumn = function(a, b) {
					var c = isNaN(this._horizontalGap) ? 0 : this._horizontalGap,
						e = isNaN(this._verticalGap) ? 0 : this._verticalGap;
					this._rowCount = this._columnCount = -1;
					for (var d = this.target.numElements, g = d, k = 0; k < g; k++) {
						var l = this.target.getElementAt(k);
						l && !l.includeInLayout && d--
					}
					if (0 == d) this._rowCount = this._columnCount = 0;
					else {
						(isNaN(this.explicitColumnWidth) || isNaN(this.explicitRowHeight)) && this.updateMaxElementSize();
						isNaN(this.explicitColumnWidth) ? this._columnWidth = this.maxElementWidth : this._columnWidth = this.explicitColumnWidth;
						isNaN(this.explicitRowHeight) ? this._rowHeight = this.maxElementHeight : this._rowHeight = this.explicitRowHeight;
						g = this._columnWidth + c;
						0 >= g && (g = 1);
						k = this._rowHeight + e;
						0 >= k && (k = 1);
						var l = this.orientation == f.TileOrientation.COLUMNS,
							m = !isNaN(a),
							n = !isNaN(b),
							p = isNaN(this._padding) ? 0 : this._padding,
							q = isNaN(this._paddingLeft) ? p : this._paddingLeft,
							x = isNaN(this._paddingRight) ? p : this._paddingRight,
							z = isNaN(this._paddingTop) ? p : this._paddingTop,
							p = isNaN(this._paddingBottom) ? p : this._paddingBottom;
						0 < this._requestedColumnCount || 0 < this._requestedRowCount ? (0 < this._requestedRowCount && (this._rowCount = Math.min(this._requestedRowCount, d)), 0 < this._requestedColumnCount && (this._columnCount = Math.min(this._requestedColumnCount, d))) : m || n ? !m || n && l ? (c = Math.max(0, b - z - p), this._rowCount = Math.floor((c + e) / k), this._rowCount = Math.max(1, Math.min(this._rowCount, d))) : (e = Math.max(0, a - q - x), this._columnCount = Math.floor((e + c) / g), this._columnCount = Math.max(1, Math.min(this._columnCount, d))) : (c = Math.sqrt(d * g * k), l ? this._rowCount = Math.max(1, Math.round(c / k)) : this._columnCount = Math.max(1, Math.round(c / g))); - 1 == this._rowCount && (this._rowCount = Math.max(1, Math.ceil(d / this._columnCount))); - 1 == this._columnCount && (this._columnCount = Math.max(1, Math.ceil(d / this._rowCount)));
						0 < this._requestedColumnCount && 0 < this._requestedRowCount && (this.orientation == f.TileOrientation.ROWS ? this._rowCount = Math.max(1, Math.ceil(d / this._requestedColumnCount)) : this._columnCount = Math.max(1, Math.ceil(d / this._requestedRowCount)))
					}
				};
				b.updateMaxElementSize = function() {
					this.target && (this.useVirtualLayout ? this.updateMaxElementSizeVirtual() : this.updateMaxElementSizeReal())
				};
				b.updateMaxElementSizeVirtual = function() {
					var a = this.typicalLayoutRect ? this.typicalLayoutRect.height : 22;
					this.maxElementWidth = Math.max(this.maxElementWidth, this.typicalLayoutRect ? this.typicalLayoutRect.width : 22);
					this.maxElementHeight = Math.max(this.maxElementHeight, a);
					if (-1 != this.startIndex && -1 != this.endIndex) for (a = this.startIndex; a <= this.endIndex; a++) {
						var b = this.target.getVirtualElementAt(a);
						b && b.includeInLayout && (this.maxElementWidth = Math.max(this.maxElementWidth, b.preferredWidth), this.maxElementHeight = Math.max(this.maxElementHeight, b.preferredHeight))
					}
				};
				b.updateMaxElementSizeReal = function() {
					for (var a = this.target.numElements, b = 0; b < a; b++) {
						var c = this.target.getElementAt(b);
						c && c.includeInLayout && (this.maxElementWidth = Math.max(this.maxElementWidth, c.preferredWidth), this.maxElementHeight = Math.max(this.maxElementHeight, c.preferredHeight))
					}
				};
				b.clearVirtualLayoutCache = function() {
					e.prototype.clearVirtualLayoutCache.call(this);
					this.maxElementHeight = this.maxElementWidth = 0
				};
				b.scrollPositionChanged = function() {
					e.prototype.scrollPositionChanged.call(this);
					this.useVirtualLayout && this.getIndexInView() && (this.indexInViewCalculated = !0, this.target.invalidateDisplayList())
				};
				b.getIndexInView = function() {
					if (!this.target || 0 == this.target.numElements) return this.startIndex = this.endIndex = -1, !1;
					var a = this.target.numElements;
					if (!this.useVirtualLayout) return this.startIndex = 0, this.endIndex = a - 1, !1;
					if (isNaN(this.target.width) || 0 == this.target.width || isNaN(this.target.height) || 0 == this.target.height) return this.startIndex = this.endIndex = -1, !1;
					var b = this.startIndex,
						c = this.endIndex,
						e = isNaN(this._padding) ? 0 : this._padding,
						d = isNaN(this._paddingLeft) ? e : this._paddingLeft,
						e = isNaN(this._paddingTop) ? e : this._paddingTop,
						g = isNaN(this._horizontalGap) ? 0 : this._horizontalGap,
						k = isNaN(this._verticalGap) ? 0 : this._verticalGap;
					if (this.orientation == f.TileOrientation.COLUMNS) {
						g = this._columnWidth + g;
						if (0 >= g) return this.startIndex = 0, this.endIndex = a - 1, !1;
						k = this.target.horizontalScrollPosition + this.target.width;
						e = Math.floor((this.target.horizontalScrollPosition - d) / g);
						0 > e && (e = 0);
						d = Math.ceil((k - d) / g);
						0 > d && (d = 0);
						this.startIndex = Math.min(a - 1, Math.max(0, e * this._rowCount));
						this.endIndex = Math.min(a - 1, Math.max(0, d * this._rowCount - 1))
					} else {
						g = this._rowHeight + k;
						if (0 >= g) return this.startIndex = 0, this.endIndex = a - 1, !1;
						k = this.target.verticalScrollPosition + this.target.height;
						d = Math.floor((this.target.verticalScrollPosition - e) / g);
						0 > d && (d = 0);
						e = Math.ceil((k - e) / g);
						0 > e && (e = 0);
						this.startIndex = Math.min(a - 1, Math.max(0, d * this._columnCount));
						this.endIndex = Math.min(a - 1, Math.max(0, e * this._columnCount - 1))
					}
					return this.startIndex != b || this.endIndex != c
				};
				b.updateDisplayList = function(a, b) {
					e.prototype.updateDisplayList.call(this, a, b);
					if (this.target) {
						var c = isNaN(this._padding) ? 0 : this._padding,
							d = isNaN(this._paddingLeft) ? c : this._paddingLeft,
							g = isNaN(this._paddingRight) ? c : this._paddingRight,
							r = isNaN(this._paddingTop) ? c : this._paddingTop,
							k = isNaN(this._paddingBottom) ? c : this._paddingBottom;
						if (this.indexInViewCalculated) this.indexInViewCalculated = !1;
						else {
							this.calculateRowAndColumn(a, b);
							if (0 == this._rowCount || 0 == this._columnCount) {
								this.target.setContentSize(d + g, r + k);
								return
							}
							this.adjustForJustify(a, b);
							this.getIndexInView()
						}
						this.useVirtualLayout && (this.calculateRowAndColumn(a, b), this.adjustForJustify(a, b));
						if (-1 == this.startIndex || -1 == this.endIndex) this.target.setContentSize(0, 0);
						else {
							this.target.setVirtualElementIndicesInView(this.startIndex, this.endIndex);
							for (var l, m, n, p = this.orientation == f.TileOrientation.COLUMNS, q = this.startIndex, c = isNaN(this._horizontalGap) ? 0 : this._horizontalGap, x = isNaN(this._verticalGap) ? 0 : this._verticalGap, z = this.startIndex; z <= this.endIndex; z++) l = this.useVirtualLayout ? this.target.getVirtualElementAt(z) : this.target.getElementAt(z), null != l && l.includeInLayout && (p ? (m = Math.ceil((q + 1) / this._rowCount) - 1, n = Math.ceil((q + 1) % this._rowCount) - 1, -1 == n && (n = this._rowCount - 1)) : (m = Math.ceil((q + 1) % this._columnCount) - 1, -1 == m && (m = this._columnCount - 1), n = Math.ceil((q + 1) / this._columnCount) - 1), m = m * (this._columnWidth + c) + d, n = n * (this._rowHeight + x) + r, this.sizeAndPositionElement(l, m, n, this._columnWidth, this.rowHeight), q++);
							r += k;
							x = (this._rowHeight + x) * this._rowCount - x;
							this.target.setContentSize(Math.ceil((this._columnWidth + c) * this._columnCount - c + (d + g)), Math.ceil(x + r))
						}
					}
				};
				b.sizeAndPositionElement = function(a, b, c, e, f) {
					var g = NaN,
						k = NaN;
					this.horizontalAlign == d.HorizontalAlign.JUSTIFY ? g = e : isNaN(a.percentWidth) || (g = e * a.percentWidth * 0.01);
					this.verticalAlign == d.VerticalAlign.JUSTIFY ? k = f : isNaN(a.percentHeight) || (k = f * a.percentHeight * 0.01);
					a.setLayoutBoundsSize(Math.round(g), Math.round(k));
					g = b;
					switch (this.horizontalAlign) {
					case d.HorizontalAlign.RIGHT:
						g += e - a.layoutBoundsWidth;
						break;
					case d.HorizontalAlign.CENTER:
						g = b + (e - a.layoutBoundsWidth) / 2
					}
					b = c;
					switch (this.verticalAlign) {
					case d.VerticalAlign.BOTTOM:
						b += f - a.layoutBoundsHeight;
						break;
					case d.VerticalAlign.MIDDLE:
						b += (f - a.layoutBoundsHeight) / 2
					}
					a.setLayoutBoundsPosition(Math.round(g), Math.round(b))
				};
				b.adjustForJustify = function(a, b) {
					var c = isNaN(this._padding) ? 0 : this._padding,
						e = isNaN(this._paddingLeft) ? c : this._paddingLeft,
						d = isNaN(this._paddingRight) ? c : this._paddingRight,
						g = isNaN(this._paddingTop) ? c : this._paddingTop,
						c = isNaN(this._paddingBottom) ? c : this._paddingBottom,
						e = Math.max(0, a - e - d),
						g = Math.max(0, b - g - c);
					isNaN(this.explicitVerticalGap) || (this._verticalGap = this.explicitVerticalGap);
					isNaN(this.explicitHorizontalGap) || (this._horizontalGap = this.explicitHorizontalGap);
					this._verticalGap = isNaN(this._verticalGap) ? 0 : this._verticalGap;
					this._horizontalGap = isNaN(this._horizontalGap) ? 0 : this._horizontalGap;
					g -= this._rowHeight * this._rowCount;
					e -= this._columnWidth * this._columnCount;
					0 < g && (this.rowAlign == f.RowAlign.JUSTIFY_USING_GAP ? (d = Math.max(1, this._rowCount - 1), this._verticalGap = g / d) : this.rowAlign == f.RowAlign.JUSTIFY_USING_HEIGHT && 0 < this._rowCount && (this._rowHeight += (g - (this._rowCount - 1) * this._verticalGap) / this._rowCount));
					0 < e && (this.columnAlign == f.ColumnAlign.JUSTIFY_USING_GAP ? (d = Math.max(1, this._columnCount - 1), this._horizontalGap = e / d) : this.columnAlign == f.ColumnAlign.JUSTIFY_USING_WIDTH && 0 < this._columnCount && (this._columnWidth += (e - (this._columnCount - 1) * this._horizontalGap) / this._columnCount))
				};
				return c
			}(f.LayoutBase);
		f.TileLayout = g;
		g.prototype.__class__ = "egret.gui.TileLayout"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(d) {
		var g = function() {
				function e(b, a, c) {
					this.upperBoundReference = this.lowerBoundReference = this.owner = null;
					this.raw_getElementAt = "raw_getElementAt";
					this.raw_addElementAt = "raw_addElementAt";
					this.raw_getElementIndex = "raw_getElementIndex";
					this.raw_removeElement = "raw_removeElement";
					this.raw_removeElementAt = "raw_removeElementAt";
					this.raw_setElementIndex = "raw_setElementIndex";
					this.owner = b;
					this.lowerBoundReference = a;
					this.upperBoundReference = c
				}
				var c = e.prototype;
				Object.defineProperty(c, "numElements", {
					get: function() {
						return this.owner[this.upperBoundReference] - this.owner[this.lowerBoundReference]
					},
					enumerable: !0,
					configurable: !0
				});
				c.getElementAt = function(b) {
					return this.owner[this.raw_getElementAt](this.owner[this.lowerBoundReference] + b)
				};
				c.addElement = function(b) {
					var a = this.owner[this.upperBoundReference];
					b.parent === this.owner && a--;
					this.owner[this.upperBoundReference]++;
					this.owner[this.raw_addElementAt](b, a);
					b.ownerChanged(this);
					return b
				};
				c.addElementAt = function(b, a) {
					this.owner[this.upperBoundReference]++;
					this.owner[this.raw_addElementAt](b, this.owner[this.lowerBoundReference] + a);
					b.ownerChanged(this);
					return b
				};
				c.removeElement = function(b) {
					var a = this.owner[this.raw_getElementIndex](b);
					this.owner[this.lowerBoundReference] <= a && a < this.owner[this.upperBoundReference] && (this.owner[this.raw_removeElement](b), this.owner[this.upperBoundReference]--);
					b.ownerChanged(null);
					return b
				};
				c.removeElementAt = function(b) {
					b += this.owner[this.lowerBoundReference];
					var a;
					this.owner[this.lowerBoundReference] <= b && b < this.owner[this.upperBoundReference] && (a = this.owner[this.raw_removeElementAt](b), this.owner[this.upperBoundReference]--);
					a.ownerChanged(null);
					return a
				};
				c.getElementIndex = function(b) {
					b = this.owner[this.raw_getElementIndex](b);
					return b -= this.owner[this.lowerBoundReference]
				};
				c.setElementIndex = function(b, a) {
					this.owner[this.raw_setElementIndex](b, this.owner[this.lowerBoundReference] + a)
				};
				return e
			}();
		d.UILayer = g;
		g.prototype.__class__ = "egret.gui.UILayer"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this._autoResize = !0;
					this._cursorContainer = this._toolTipContainer = this._popUpContainer = null;
					this._cursorIndex = this._toolTipIndex = this._topMostIndex = this._noTopMostIndex = 0;
					this.touchEnabled = !1;
					this.addEventListener(d.Event.ADDED_TO_STAGE, this.onAddToStage, this);
					this.addEventListener(d.Event.REMOVED_FROM_STAGE, this.onRemoveFromStage, this)
				}
				__extends(c, e);
				var b = c.prototype;
				b.onAddToStage = function(a) {
					if (f.UIGlobals._uiStage) throw Error(d.getString(3013));
					f.UIGlobals._uiStage = this;
					this._autoResize && (this.stage.addEventListener(d.Event.RESIZE, this.onResize, this), this.onResize())
				};
				b.onRemoveFromStage = function(a) {
					f.UIGlobals._uiStage = null;
					this._autoResize && this.stage.removeEventListener(d.Event.RESIZE, this.onResize, this)
				};
				b.onResize = function(a) {
					this._setWidth(this.stage.stageWidth);
					this._setHeight(this.stage.stageHeight)
				};
				Object.defineProperty(b, "autoResize", {
					get: function() {
						return this._autoResize
					},
					set: function(a) {
						this._autoResize != a && (this._autoResize = a, this.stage && (this._autoResize ? (this.stage.addEventListener(d.Event.RESIZE, this.onResize, this), this.onResize()) : this.stage.removeEventListener(d.Event.RESIZE, this.onResize, this)))
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "x", {
					get: function() {
						return this._x
					},
					set: function(a) {
						this._autoResize || (this._x = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "y", {
					get: function() {
						return this._y
					},
					set: function(a) {
						this._autoResize || (this._y = a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "width", {
					get: function() {
						return this._width
					},
					set: function(a) {
						this._autoResize || this._setWidth(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "height", {
					get: function() {
						return this._height
					},
					set: function(a) {
						this._autoResize || this._setHeight(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "scaleX", {
					get: function() {
						return this._scaleX
					},
					set: function(a) {
						this._autoResize || this._setScaleX(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "scaleY", {
					get: function() {
						return this._scaleY
					},
					set: function(a) {
						this._autoResize || this._setScaleY(a)
					},
					enumerable: !0,
					configurable: !0
				});
				b.setActualSize = function(a, b) {
					this._autoResize || e.prototype.setActualSize.call(this, a, b)
				};
				b.setLayoutBoundsPosition = function(a, b) {
					this._autoResize || e.prototype.setLayoutBoundsPosition.call(this, a, b)
				};
				b.setLayoutBoundsSize = function(a, b) {
					this._autoResize || e.prototype.setLayoutBoundsSize.call(this, a, b)
				};
				Object.defineProperty(b, "layout", {
					get: function() {
						return this._layout
					},
					set: function(a) {
						a instanceof f.BasicLayout && this._setLayout(a)
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "popUpContainer", {
					get: function() {
						this._popUpContainer || (this._popUpContainer = new f.UILayer(this, "noTopMostIndex", "topMostIndex"));
						return this._popUpContainer
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "toolTipContainer", {
					get: function() {
						this._toolTipContainer || (this._toolTipContainer = new f.UILayer(this, "topMostIndex", "toolTipIndex"));
						return this._toolTipContainer
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "cursorContainer", {
					get: function() {
						this._cursorContainer || (this._cursorContainer = new f.UILayer(this, "toolTipIndex", "cursorIndex"));
						return this._cursorContainer
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "noTopMostIndex", {
					get: function() {
						return this._noTopMostIndex
					},
					set: function(a) {
						var b = a - this._noTopMostIndex;
						this._noTopMostIndex = a;
						this.topMostIndex += b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "topMostIndex", {
					get: function() {
						return this._topMostIndex
					},
					set: function(a) {
						var b = a - this._topMostIndex;
						this._topMostIndex = a;
						this.toolTipIndex += b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "toolTipIndex", {
					get: function() {
						return this._toolTipIndex
					},
					set: function(a) {
						var b = a - this._toolTipIndex;
						this._toolTipIndex = a;
						this.cursorIndex += b
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(b, "cursorIndex", {
					get: function() {
						return this._cursorIndex
					},
					set: function(a) {
						this._cursorIndex = a
					},
					enumerable: !0,
					configurable: !0
				});
				b.addElement = function(a) {
					var b = this._noTopMostIndex;
					a.parent == this && b--;
					return this.addElementAt(a, b)
				};
				b.addElementAt = function(a, b) {
					if (a.parent == this) {
						var c = this.getElementIndex(a);
						c < this._noTopMostIndex ? this.noTopMostIndex-- : c >= this._noTopMostIndex && c < this._topMostIndex ? this.topMostIndex-- : c >= this._topMostIndex && c < this._toolTipIndex ? this.toolTipIndex-- : this.cursorIndex--
					}
					b <= this._noTopMostIndex ? this.noTopMostIndex++ : b > this._noTopMostIndex && b <= this._topMostIndex ? this.topMostIndex++ : b > this._topMostIndex && b <= this._toolTipIndex ? this.toolTipIndex++ : this.cursorIndex++;
					return e.prototype.addElementAt.call(this, a, b)
				};
				b.removeElement = function(a) {
					return this.removeElementAt(e.prototype.getElementIndex.call(this, a))
				};
				b.removeElementAt = function(a) {
					var b = e.prototype.removeElementAt.call(this, a);
					a < this._noTopMostIndex ? this.noTopMostIndex-- : a >= this._noTopMostIndex && a < this._topMostIndex ? this.topMostIndex-- : a >= this._topMostIndex && a < this._toolTipIndex ? this.toolTipIndex-- : this.cursorIndex--;
					return b
				};
				b.removeAllElements = function() {
					for (; 0 < this._noTopMostIndex;) e.prototype.removeElementAt.call(this, 0), this.noTopMostIndex--
				};
				b._elementRemoved = function(a, b, c) {
					void 0 === c && (c = !0);
					c && d.Event.dispatchEvent(a, "removeFromUIStage");
					e.prototype._elementRemoved.call(this, a, b, c)
				};
				b.raw_getElementAt = function(a) {
					return e.prototype.getElementAt.call(this, a)
				};
				b.raw_addElement = function(a) {
					var b = this.numElements;
					a.parent == this && b--;
					return this.raw_addElementAt(a, b)
				};
				b.raw_addElementAt = function(a, b) {
					if (a.parent == this) {
						var c = this.getElementIndex(a);
						c < this._noTopMostIndex ? this.noTopMostIndex-- : c >= this._noTopMostIndex && c < this._topMostIndex ? this.topMostIndex-- : c >= this._topMostIndex && c < this._toolTipIndex ? this.toolTipIndex-- : this.cursorIndex--
					}
					return e.prototype.addElementAt.call(this, a, b)
				};
				b.raw_removeElement = function(a) {
					return e.prototype.removeElementAt.call(this, e.prototype.getElementIndex.call(this, a))
				};
				b.raw_removeElementAt = function(a) {
					return e.prototype.removeElementAt.call(this, a)
				};
				b.raw_removeAllElements = function() {
					for (; 0 < this.numElements;) e.prototype.removeElementAt.call(this, 0)
				};
				b.raw_getElementIndex = function(a) {
					return e.prototype.getElementIndex.call(this, a)
				};
				b.raw_setElementIndex = function(a, b) {
					e.prototype.setElementIndex.call(this, a, b)
				};
				b.raw_swapElements = function(a, b) {
					e.prototype.swapElementsAt.call(this, e.prototype.getElementIndex.call(this, a), e.prototype.getElementIndex.call(this, b))
				};
				b.raw_swapElementsAt = function(a, b) {
					e.prototype.swapElementsAt.call(this, a, b)
				};
				return c
			}(f.Group);
		f.UIStage = g;
		g.prototype.__class__ = "egret.gui.UIStage"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function(c) {
				function b() {
					c.call(this);
					this._popUpList = [];
					this.popUpDataList = [];
					this._modalColor = 0;
					this._modalAlpha = 0.5;
					this.invalidateModalFlag = !1;
					this.modalMask = null
				}
				__extends(b, c);
				var a = b.prototype;
				Object.defineProperty(a, "popUpList", {
					get: function() {
						return this._popUpList.concat()
					},
					enumerable: !0,
					configurable: !0
				});
				a.findPopUpData = function(a) {
					for (var b = this.popUpDataList, c = b.length, e = 0; e < c; e++) {
						var d = b[e];
						if (d.popUp == a) return d
					}
					return null
				};
				a.addPopUp = function(a, c, d) {
					void 0 === c && (c = !1);
					void 0 === d && (d = !0);
					var g = f.UIGlobals.uiStage,
						r = this.findPopUpData(a);
					r ? (r.modal = c, a.removeEventListener(b.REMOVE_FROM_UISTAGE, this.onRemoved, this)) : (r = new e(a, c), this.popUpDataList.push(r), this._popUpList.push(a));
					g.popUpContainer.addElement(a);
					d && this.centerPopUp(a);
					"isPopUp" in a && (a.isPopUp = !0);
					c && this.invalidateModal();
					a.addEventListener(b.REMOVE_FROM_UISTAGE, this.onRemoved, this)
				};
				a.onRemoved = function(a) {
					for (var c = 0, e = this.popUpDataList, d = e.length, f = 0; f < d; f++) {
						var g = e[f];
						if (g.popUp == a.target) {
							"isPopUp" in g.popUp && (g.popUp.isPopUp = !1);
							g.popUp.removeEventListener(b.REMOVE_FROM_UISTAGE, this.onRemoved, this);
							this.popUpDataList.splice(c, 1);
							this._popUpList.splice(c, 1);
							this.invalidateModal();
							break
						}
						c++
					}
				};
				Object.defineProperty(a, "modalColor", {
					get: function() {
						return this._modalColor
					},
					set: function(a) {
						this._modalColor != a && (this._modalColor = a, this.invalidateModal())
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(a, "modalAlpha", {
					get: function() {
						return this._modalAlpha
					},
					set: function(a) {
						this._modalAlpha != a && (this._modalAlpha = a, this.invalidateModal())
					},
					enumerable: !0,
					configurable: !0
				});
				a.invalidateModal = function() {
					this.invalidateModalFlag || (this.invalidateModalFlag = !0, f.UIGlobals.stage.addEventListener(d.Event.ENTER_FRAME, this.validateModal, this), f.UIGlobals.stage.addEventListener(d.Event.RENDER, this.validateModal, this), f.UIGlobals.stage.invalidate())
				};
				a.validateModal = function(a) {
					this.invalidateModalFlag = !1;
					f.UIGlobals.stage.removeEventListener(d.Event.ENTER_FRAME, this.validateModal, this);
					f.UIGlobals.stage.removeEventListener(d.Event.RENDER, this.validateModal, this);
					this.updateModal(f.UIGlobals.uiStage)
				};
				a.updateModal = function(a) {
					for (var b = a.popUpContainer, c = !1, e = b.numElements - 1; 0 <= e; e--) {
						var d = b.getElementAt(e);
						if ((d = this.findPopUpData(d)) && d.modal) {
							c = !0;
							break
						}
					}
					c ? (this.modalMask || (this.modalMask = new f.Rect, this.modalMask.touchEnabled = !0, this.modalMask.top = this.modalMask.left = this.modalMask.right = this.modalMask.bottom = 0), this.modalMask.fillColor = this._modalColor, this.modalMask.alpha = this._modalAlpha, this.modalMask.parent == a ? (b.getElementIndex(this.modalMask) < e && e--, b.setElementIndex(this.modalMask, e)) : b.addElementAt(this.modalMask, e)) : this.modalMask && this.modalMask.parent == a && b.removeElement(this.modalMask)
				};
				a.removePopUp = function(a) {
					a && a.parent && this.findPopUpData(a) && ("removeElement" in a.parent ? a.parent.removeElement(a) : a.parent instanceof f.UIComponent ? a.parent._removeFromDisplayList(a) : a instanceof d.DisplayObject && a.parent.removeChild(a))
				};
				a.centerPopUp = function(a) {
					a.top = a.bottom = a.left = a.right = NaN;
					a.verticalCenter = a.horizontalCenter = 0;
					var b = a.parent;
					b && ("validateNow" in a && a.validateNow(), a.x = 0.5 * (b.width - a.layoutBoundsWidth), a.y = 0.5 * (b.height - a.layoutBoundsHeight))
				};
				a.bringToFront = function(a) {
					if (this.findPopUpData(a) && a.parent && "popUpContainer" in a.parent) {
						var b = a.parent;
						b.popUpContainer.setElementIndex(a, b.popUpContainer.numElements - 1);
						this.invalidateModal()
					}
				};
				b.REMOVE_FROM_UISTAGE = "removeFromUIStage";
				return b
			}(d.EventDispatcher);
		f.PopUpManagerImpl = g;
		g.prototype.__class__ = "egret.gui.PopUpManagerImpl";
		var e = function() {
				return function(c, b) {
					this.popUp = null;
					this.modal = !1;
					this.popUp = c;
					this.modal = b
				}
			}();
		e.prototype.__class__ = "egret.gui.PopUpData"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
(function(d) {
	(function(f) {
		var g = function() {
				function e() {}
				e.getImpl = function() {
					if (!e._impl) try {
						e._impl = d.Injector.getInstance("egret.gui.IPopUpManager")
					} catch (c) {
						e._impl = new f.PopUpManagerImpl
					}
					return e._impl
				};
				Object.defineProperty(e, "modalColor", {
					get: function() {
						return e.getImpl().modalColor
					},
					set: function(c) {
						e.getImpl().modalColor = c
					},
					enumerable: !0,
					configurable: !0
				});
				Object.defineProperty(e, "modalAlpha", {
					get: function() {
						return e.getImpl().modalAlpha
					},
					set: function(c) {
						e.getImpl().modalAlpha = c
					},
					enumerable: !0,
					configurable: !0
				});
				e.addPopUp = function(c, b, a) {
					void 0 === b && (b = !1);
					void 0 === a && (a = !0);
					e.getImpl().addPopUp(c, b, a);
					f.PopUpEvent.dispatchPopUpEvent(e.getImpl(), f.PopUpEvent.ADD_POPUP, c, b)
				};
				e.removePopUp = function(c) {
					e.getImpl().removePopUp(c);
					f.PopUpEvent.dispatchPopUpEvent(e.getImpl(), f.PopUpEvent.REMOVE_POPUP, c)
				};
				e.centerPopUp = function(c) {
					e.getImpl().centerPopUp(c)
				};
				e.bringToFront = function(c) {
					e.getImpl().bringToFront(c);
					f.PopUpEvent.dispatchPopUpEvent(e.getImpl(), f.PopUpEvent.BRING_TO_FRONT, c)
				};
				Object.defineProperty(e, "popUpList", {
					get: function() {
						return e.getImpl().popUpList
					},
					enumerable: !0,
					configurable: !0
				});
				e.addEventListener = function(c, b, a, d, f) {
					void 0 === d && (d = !1);
					void 0 === f && (f = 0);
					e.getImpl().addEventListener(c, b, a, d, f)
				};
				e.removeEventListener = function(c, b, a, d) {
					void 0 === d && (d = !1);
					e.getImpl().removeEventListener(c, b, a, d)
				};
				return e
			}();
		f.PopUpManager = g;
		g.prototype.__class__ = "egret.gui.PopUpManager"
	})(d.gui || (d.gui = {}))
})(egret || (egret = {}));
var particle;
(function(d) {
	var f = function() {
			function d() {
				this.reset()
			}
			d.prototype.reset = function() {
				this.y = this.x = 0;
				this.scale = 1;
				this.rotation = 0;
				this.alpha = 1;
				this.currentTime = 0;
				this.totalTime = 1E3
			};
			return d
		}();
	d.Particle = f;
	f.prototype.__class__ = "particle.Particle"
})(particle || (particle = {}));
(function(d) {
	var f = function(f) {
			function e(b, a) {
				f.call(this);
				this._pool = [];
				this.frameTime = 0;
				this.particles = [];
				this.emissionTime = -1;
				this.emitterY = this.emitterX = 0;
				this.maxParticles = 200;
				this.numParticles = 0;
				this.particleClass = null;
				this.transform = new egret.Matrix;
				this._texture_to_render = b;
				this.emissionRate = a;
				this.texture = b
			}
			__extends(e, f);
			var c = e.prototype;
			c.getParticle = function() {
				return this._pool.length ? this._pool.pop() : this.particleClass ? new this.particleClass : new d.Particle
			};
			c.removeParticle = function(b) {
				var a = this.particles.indexOf(b);
				return -1 != a ? (b.reset(), this.particles.splice(a, 1), this._pool.push(b), this.numParticles--, !0) : !1
			};
			c.initParticle = function(b) {
				b.x = this.emitterX;
				b.y = this.emitterY;
				b.currentTime = 0;
				b.totalTime = 1E3
			};
			c.start = function(b) {
				void 0 === b && (b = -1);
				0 != this.emissionRate && (this.emissionTime = b, egret.Ticker.getInstance().register(this.update, this))
			};
			c.stop = function(b) {
				void 0 === b && (b = !1);
				this.emissionTime = 0;
				egret.Ticker.getInstance().unregister(this.update, this);
				b && this.clear()
			};
			c.update = function(b) {
				if (-1 == this.emissionTime || 0 < this.emissionTime) {
					for (this.frameTime += b; 0 < this.frameTime;) this.numParticles < this.maxParticles && this.addOneParticle(), this.frameTime -= this.emissionRate; - 1 != this.emissionTime && (this.emissionTime -= b, 0 > this.emissionTime && (this.emissionTime = 0))
				}
				for (var a, c = 0; c < this.numParticles;) a = this.particles[c], a.currentTime < a.totalTime ? (this.advanceParticle(a, b), a.currentTime += b, c++) : (this.removeParticle(a), 0 == this.numParticles && 0 == this.emissionTime && this.dispatchEventWith(egret.Event.COMPLETE))
			};
			c.setCurrentParticles = function(b) {
				for (var a = this.numParticles; a < b && this.numParticles < this.maxParticles; a++) this.addOneParticle()
			};
			c.changeTexture = function(b) {
				this.texture != b && (this._texture_to_render = this.texture = b)
			};
			c.clear = function() {
				for (; this.particles.length;) this.removeParticle(this.particles[0]);
				this.numParticles = 0
			};
			c.addOneParticle = function() {
				var b = this.getParticle();
				this.initParticle(b);
				0 < b.totalTime && (this.particles.push(b), this.numParticles++)
			};
			c.advanceParticle = function(b, a) {
				b.y -= a / 6
			};
			c._render = function(b) {
				if (0 < this.numParticles) for (var a = egret.RenderFilter.getInstance(), c = this.texture, e = c._textureWidth, d = c._textureHeight, f = c._offsetX, g = c._offsetY, k = c._bitmapX, l = c._bitmapY, m = c._bitmapWidth, c = c._bitmapHeight, n, p = 0; p < this.numParticles; p++) n = this.particles[p], this.transform.identityMatrix(this._worldTransform), this.transform.appendTransform(n.x, n.y, n.scale, n.scale, n.rotation, 0, 0, e / 2, d / 2), b.setTransform(this.transform), b.setAlpha(n.alpha, egret.BlendMode.NORMAL), a.drawImage(b, this, k, l, m, c, f, g, e, d)
			};
			return e
		}(egret.DisplayObject);
	d.ParticleSystem = f;
	f.prototype.__class__ = "particle.ParticleSystem"
})(particle || (particle = {}));
var TaskVo = function() {
		function d() {}
		var f = d.prototype;
		f.setData = function(d) {
			this.id = d.id;
			this.type = d.type;
			this.maxCount = d.maxCount;
			this.icon = d.icon;
			this.resId = d.resId;
			this.reward = [];
			d = d.reward.split("|");
			for (var e = 0; e < d.length; e++) {
				var c = d[e].split("_"),
					b = new GoodsVo;
				b.id = e + 1;
				b.baseId = parseInt(c[0]);
				b.num = parseInt(c[1]);
				this.reward.push(b)
			}
		};
		Object.defineProperty(f, "isFinish", {
			get: function() {
				return this.count >= this.maxCount
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "count", {
			get: function() {
				return 1 == this.type ? GameManager.instance.winLevelCount : 2 == this.type ? GameManager.instance.starCount : 3 == this.type ? GameManager.instance.score : 0
			},
			enumerable: !0,
			configurable: !0
		});
		return d
	}();
TaskVo.prototype.__class__ = "TaskVo";
var HashMap = function() {
		function d() {
			this.data = {}
		}
		var f = d.prototype;
		f.set = function(d, e) {
			this.data[d] = e
		};
		f.get = function(d) {
			return this.data[d]
		};
		f.has = function(d) {
			return this.data.hasOwnProperty(d)
		};
		f.keys = function() {
			var d = [],
				e;
			for (e in this.data) d.push(e);
			return d
		};
		return d
	}();
HashMap.prototype.__class__ = "HashMap";
var TaskManager = function() {
		function d() {}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		f.init = function() {
			this.taskData = [];
			this.taskMap = new HashMap;
			for (var d = RES.getRes("data_json"), d = d.task, e = 0; e < d.length; e++) {
				var c = new TaskVo;
				c.setData(d[e]);
				this.taskData.push(c);
				this.taskMap.set(c.id, c)
			}
		};
		f.setNetTaskData = function(d) {
			for (var e = 0; e < d.length; e++) this.taskMap.get(d[e]).isGetReward = !0
		};
		f.getNetTaskData = function() {
			for (var d = [], e = 0; e < this.taskData.length; e++) this.taskData[e].isGetReward && d.push(this.taskData[e].id);
			return d
		};
		f.getHasTaskCanGet = function() {
			for (var d = 0; d < this.taskData.length; d++) {
				var e = this.taskData[d];
				if (!e.isGetReward && e.isFinish) return !0
			}
			return !1
		};
		return d
	}();
TaskManager.prototype.__class__ = "TaskManager";
var GameManager = function() {
		function d() {
			this._isEff = this._isSound = !0;
			this.isGuided = this.hasPlayCG = !1
		}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		f.init = function() {
			this.loadCfg();
			this.loadSoundCfg()
		};
		Object.defineProperty(f, "isSound", {
			get: function() {
				return this._isSound
			},
			set: function(d) {
				(this._isSound = d) ? AudioManager.instance.playBgSound() : AudioManager.instance.stopBgSound();
				this.saveSoundCfg()
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "isEff", {
			get: function() {
				return this._isEff
			},
			set: function(d) {
				this._isEff = d;
				this.saveSoundCfg()
			},
			enumerable: !0,
			configurable: !0
		});
		f.loadSoundCfg = function() {
			var d = egret.localStorage.getItem("popodino-soundCfg");
			d ? (d = JSON.parse(d), this.isSound = d.isSound, this.isEff = d.isEff) : this.isEff = this.isSound = !0
		};
		f.saveSoundCfg = function() {
			egret.localStorage.setItem("popodino-soundCfg", JSON.stringify({
				isSound: this.isSound,
				isEff: this.isEff
			}))
		};
		f.loadCfg = function() {
			var d = egret.localStorage.getItem("popodino-game-data");
			if (d) {
				var e = JSON.parse(d),
					c = e.vertify,
					e = e.data,
					d = JSON.stringify(e),
					d = (new md5).hex_md5(d + Const.VERTIFY_KEY);
				c == d ? (this._score = e.score || 0, this.isGuided = e.isGuided || !1, this.winLevelInfo = e.winLevelInfo || [], GoodsManager.instance.setNetGoodsData(e.goodsInfo || {}), TaskManager.instance.setNetTaskData(e.taskInfo || [])) : this.useInitFullData()
			} else this.useInitFullData()
		};
		f.saveCfg = function() {
			this.saveCfgDelayCount++;
			egret.clearTimeout(this.saveCfgDelayId);
			this.saveCfgDelayId = egret.setTimeout(this._saveCfgDelay, this, 1E3);
			10 < this.saveCfgDelayCount && this._saveCfgDelay()
		};
		f._saveCfgDelay = function() {
			this.saveCfgDelayCount = 0;
			var d = {
				score: this.score,
				isGuided: this.isGuided,
				winLevelInfo: this.winLevelInfo,
				goodsInfo: GoodsManager.instance.getNetGoodsData(),
				taskInfo: TaskManager.instance.getNetTaskData()
			},
				e = JSON.stringify(d),
				d = {
					vertify: (new md5).hex_md5(e + Const.VERTIFY_KEY),
					data: d
				};
			egret.localStorage.setItem("popodino-game-data", JSON.stringify(d))
		};
		f.useInitFullData = function() {
			this._score = 0;
			this.isGuided = !1;
			this.winLevelInfo = [];
			GoodsManager.instance.setNetGoodsData({});
			TaskManager.instance.setNetTaskData([])
		};
		Object.defineProperty(f, "state", {
			get: function() {
				return this._state
			},
			set: function(d) {
				this.state != d && (this.lastState = this.state, this._state = d)
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "score", {
			get: function() {
				return this._score
			},
			set: function(d) {
				this._score = d;
				this.saveCfg()
			},
			enumerable: !0,
			configurable: !0
		});
		f.updateWinLevelStar = function(d, e) {
			this.winLevelInfo[d - 1] = e;
			this.saveCfg()
		};
		f.getStar = function(d) {
			return this.winLevelInfo.length < d ? -1 : this.winLevelInfo[d - 1]
		};
		Object.defineProperty(f, "winLevelCount", {
			get: function() {
				return this.winLevelInfo.length
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "starCount", {
			get: function() {
				for (var d = 0, e = 0; e < this.winLevelInfo.length; e++) d += this.winLevelInfo[e];
				return d
			},
			enumerable: !0,
			configurable: !0
		});
		return d
	}();
GameManager.prototype.__class__ = "GameManager";
var GameEvent = function() {
		function d() {}
		d.EVENT_SHOW_INDEX = "event_show_index";
		d.EVENT_SHOW_CHAPTER = "event_show_chapter";
		d.EVENT_SHOW_GAME = "event_show_game";
		d.EVENT_USE_BOMB = "event_use_bomb";
		d.EVENT_USE_RELAYOUT = "event_use_relayout";
		d.EVENT_TASK_CHANGE = "event_task_change";
		d.EVENT_EXCHANGE_BUBBLE = "event_exchange_bubble";
		d.EVENT_ITEM_CHANGE = "event_item_change";
		return d
	}();
GameEvent.prototype.__class__ = "GameEvent";
var GoodsBaseVo = function() {
		function d() {}
		d.prototype.setData = function(d) {
			this.id = d.id;
			this.name = d.name;
			this.resId = d.resId;
			this.icon = d.icon;
			this.desc = d.desc
		};
		return d
	}();
GoodsBaseVo.prototype.__class__ = "GoodsBaseVo";
var GoodsManager = function() {
		function d() {}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		f.init = function() {
			this.goodsBaseMap = new HashMap;
			for (var d = RES.getRes("data_json"), d = d.item, e = 0; e < d.length; e++) {
				var c = new GoodsBaseVo;
				c.setData(d[e]);
				this.goodsBaseMap.set(c.id, c)
			}
		};
		f.getGoodsBaseVo = function(d) {
			return this.goodsBaseMap.get(d) || null
		};
		f.getGoodsCount = function(d) {
			return this.goodsMap.has(d) ? this.goodsMap.get(d).num : 0
		};
		f.addGoodsCount = function(d, e) {
			var c = null;
			this.goodsMap.has(d) ? c = this.goodsMap.get(d) : (c = new GoodsVo, c.baseId = d, this.goodsMap.set(d, c));
			c.num += e;
			Const.stage.dispatchEventWith(GameEvent.EVENT_ITEM_CHANGE);
			GameManager.instance.saveCfg()
		};
		f.subGoodsCount = function(d, e) {
			void 0 === e && (e = 1);
			this.goodsMap.get(d).num -= e;
			Const.stage.dispatchEventWith(GameEvent.EVENT_ITEM_CHANGE);
			GameManager.instance.saveCfg()
		};
		f.setNetGoodsData = function(d) {
			this.goodsMap = new HashMap;
			for (var e in d) {
				var c = null;
				this.goodsMap.has(e) ? c = this.goodsMap.get(e) : (c = new GoodsVo, c.baseId = parseInt(e), this.goodsMap.set(c.id, c));
				c.num = d[e]
			}
		};
		f.getNetGoodsData = function() {
			for (var d = this.goodsMap.keys(), e = {}, c = 0; c < d.length; c++) e[d[c]] = this.goodsMap.get(d[c]).num;
			return e
		};
		return d
	}();
GoodsManager.prototype.__class__ = "GoodsManager";
var GoodsVo = function() {
		function d() {
			this.id = -1;
			this.num = 0
		}
		Object.defineProperty(d.prototype, "baseId", {
			set: function(d) {
				this.id = d;
				this.baseVo = GoodsManager.instance.getGoodsBaseVo(d)
			},
			enumerable: !0,
			configurable: !0
		});
		return d
	}();
GoodsVo.prototype.__class__ = "GoodsVo";
var AudioManager = function() {
		function d() {
			this.isSoundPlaying = !1
		}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		f.playBgSound = function() {
			if (GameManager.instance.isSound && !this.isSoundPlaying) {
				if (!this.bgsound && (this.bgsound = RES.getRes(Const.AUDIO_BGSOUND), !this.bgsound)) return;
				this.bgsound.play(!0);
				this.isSoundPlaying = !0
			}
		};
		f.stopBgSound = function() {
			this.isSoundPlaying = !1;
			this.bgsound && this.bgsound.pause()
		};
		f.playEffect = function(d) {
			//GameManager.instance.isSound && RES.getRes(d).play()
		};
		return d
	}();
AudioManager.prototype.__class__ = "AudioManager";
var Bubble = function(d) {
		function f(e) {
			d.call(this);
			this.col = this.row = -1;
			this.SPEED = 1200;
			this.isStop = !0;
			this.checked = !1;
			this.layer = 0;
			this.bm = new egret.Bitmap;
			this.bm.anchorX = this.bm.anchorY = 0.5;
			this.addChild(this.bm);
			this.changeColor(e)
		}
		__extends(f, d);
		var g = f.prototype;
		g.debug = function() {};
		g.changeColor = function(e) {
			this.color = e;
			this.bm.visible = !1;
			this.mc && (this.mc.visible = !1);
			7 >= e ? (this.bm.texture = RES.getRes("item_" + e + "_png"), this.bm.visible = !0) : (e = new egret.MovieClipDataFactory(RES.getRes("item_" + e + "_json"), RES.getRes("item_" + e + "_png")), Util.layoutMovieClip(e), this.mc || (this.mc = new egret.MovieClip, this.addChild(this.mc)), this.mc.movieClipData = e.generateMovieClipData(), e = Util.getMovieClipOffset(this.mc), this.mc.anchorOffsetX = e.x, this.mc.anchorOffsetY = e.y, this.mc.visible = !0, this.mc.play(-1))
		};
		g.fire = function(e) {
			this.speedX = this.SPEED * Math.cos(e);
			this.speedY = this.SPEED * Math.sin(e);
			this.isStop = !1;
			this.speedR = 5 * (e + Math.PI / 2);
			AudioManager.instance.playEffect(Const.AUDIO_SHOOT)
		};
		g.stopMove = function() {
			this.isStop = !0;
			this.bm.rotation = 0
		};
		g.move = function(e) {
			this.isStop || (this.x += this.speedX * e / 1E3, this.y += this.speedY * e / 1E3, this.bm.rotation += this.speedR, this.x <= Const.CELL_SIZE_W / 2 ? (this.speedX *= -1, this.x = Const.CELL_SIZE_W - this.x) : this.x >= Const.WIN_W - Const.CELL_SIZE_W / 2 && (this.speedX *= -1, this.x = 2 * Const.WIN_W - Const.CELL_SIZE_W - this.x))
		};
		return f
	}(egret.Sprite);
Bubble.prototype.__class__ = "Bubble";
var ShopVo = function() {
		function d() {}
		var f = d.prototype;
		Object.defineProperty(f, "id", {
			get: function() {
				return this.data.id
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "goodsArr", {
			get: function() {
				if (!this._goodsArr) {
					this._goodsArr = [];
					for (var d = this.data.item.split("|"), e = 0; e < d.length; e++) {
						var c = d[e].split("_"),
							b = new GoodsVo;
						b.id = e + 1;
						b.baseId = parseInt(c[0]);
						b.num = parseInt(c[1]);
						this._goodsArr.push(b)
					}
				}
				return this._goodsArr
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "price", {
			get: function() {
				return this.data.price
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "resId", {
			get: function() {
				return (this.data.resId || this.goodsArr[0].baseVo.resId) + "_png"
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "icon", {
			get: function() {
				return (this.data.icon || this.goodsArr[0].baseVo.icon) + "_png"
			},
			enumerable: !0,
			configurable: !0
		});
		return d
	}();
ShopVo.prototype.__class__ = "ShopVo";
var BubblePool = function() {
		function d() {}
		d.getBubble = function(f) {
			var g;
			0 < d.pool.length ? (g = d.pool.pop(), g.changeColor(f), g.scaleX = g.scaleY = 1, g.alpha = 1, g.bm.rotation = 0) : g = new Bubble(f);
			return g
		};
		d.pushBubble = function(f) {
			100 > d.pool.length && (d.pool.push(f), f.row = -1, f.col = -1);
			f.parent && f.parent.removeChild(f)
		};
		d.pool = [];
		return d
	}();
BubblePool.prototype.__class__ = "BubblePool";
var BubbleCfg = function() {
		function d() {}
		d.init = function() {
			d.map = new HashMap;
			for (var f = RES.getRes("data_json"), f = f.bubble, g = 0; g < f.length; g++) {
				var e = f[g];
				d.map.set(e.id, e)
			}
		};
		d.getBubbleScore = function(f, g) {
			var e = d.map.get(f);
			return e ? 5 >= g ? e.score1 : 10 >= g ? e.score2 : e.score3 : 0
		};
		return d
	}();
BubbleCfg.prototype.__class__ = "BubbleCfg";
var ShopManager = function() {
		function d() {}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		f.init = function() {
			this.shopData = [];
			for (var d = RES.getRes("data_json"), d = d.shop, e = 0; e < d.length; e++) {
				var c = new ShopVo;
				c.data = d[e];
				this.shopData.push(c)
			}
		};
		Object.defineProperty(f, "isHelperLineGeted", {
			get: function() {
				return 0 < GoodsManager.instance.getGoodsCount(1)
			},
			enumerable: !0,
			configurable: !0
		});
		return d
	}();
ShopManager.prototype.__class__ = "ShopManager";
var LevelManager = function() {
		function d() {
			this.hit = 0;
			this.isCritical = !1;
			this._level = 1;
			this.init()
		}
		var f = d.prototype;
		Object.defineProperty(d, "instance", {
			get: function() {
				d._instance || (d._instance = new d);
				return d._instance
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "score", {
			get: function() {
				return this._score
			},
			set: function(d) {
				this._score = d
			},
			enumerable: !0,
			configurable: !0
		});
		Object.defineProperty(f, "leaf", {
			get: function() {
				return this._leaf
			},
			set: function(d) {
				this._leaf = d
			},
			enumerable: !0,
			configurable: !0
		});
		f.init = function() {
			this.levelMap = new HashMap;
			var d = RES.getRes("data_json"),
				d = d.level;
			this.MAX_LEVEL = d.length;
			for (var e = 0; e < this.MAX_LEVEL; e++) {
				var c = new LevelVo;
				c.setData(d[e]);
				this.levelMap.set(c.id, c)
			}
		};
		Object.defineProperty(f, "level", {
			get: function() {
				return this._level
			},
			set: function(d) {
				d > this.MAX_LEVEL && (d = this.MAX_LEVEL);
				this._level = d;
				this.currLevelVo = this.levelMap.get(d);
				this.hit = this.score = this.leaf = this.makeIndex = 0;
				this.isCritical = !1;
				this.isOffset = !0;
				this.step = this.currLevelVo.step;
				this.makeSeed()
			},
			enumerable: !0,
			configurable: !0
		});
		f.makeLine = function(d, e) {
			for (var c = [], b = this.currLevelVo.mapData[this.makeIndex % this.currLevelVo.mapData.length], a = 0; a < b.length; a++) {
				var f = BubblePool.getBubble(b[a]);
				f.row = e;
				f.col = a;
				c.push(f);
				f.x = this.isOffset ? (a + 1) * Const.CELL_SIZE_W : (a + 0.5) * Const.CELL_SIZE_W;
				f.y = d;
				Const.gameRoot.addChild(f)
			}
			this.makeIndex++;
			this.isOffset = !this.isOffset;
			return c
		};
		f.makeSeed = function() {
			var d = this.currLevelVo.bubbleArr;
			this.seedArr = [];
			for (var e = this.seedIndex = 0; e < d.length; e++) this.seedArr.push(d[e]), this.seedArr.push(d[e]), this.seedArr.push(d[e]);
			this.seedArr.sort(function(c, b) {
				return 0.5 - Math.random()
			})
		};
		f.randomColor = function() {
			var d = this.seedArr[this.seedIndex];
			this.seedIndex++;
			this.seedIndex >= this.seedArr.length && (this.seedIndex = 0, this.seedArr.sort(function(e, c) {
				return 0.5 - Math.random()
			}));
			return d
		};
		f.getRowIsOffset = function(d) {
			return 1 == d % 2 ? this.isOffset : !this.isOffset
		};
		return d
	}();
LevelManager.prototype.__class__ = "LevelManager";
var Line = function(d) {
		function f() {
			d.call(this);
			this.DIR = 30;
			this.y = Const.UP
		}
		__extends(f, d);
		var g = f.prototype;
		Object.defineProperty(f, "instance", {
			get: function() {
				f._instance || (f._instance = new f);
				return f._instance
			},
			enumerable: !0,
			configurable: !0
		});
		g.removeFromParent = function() {
			this.parent && this.parent.removeChild(this)
		};
		g.draw = function(e) {
			for (var c = this.numChildren, b = 0; b < c; b++) this.getChildAt(b).visible = !1;
			for (b = 0; b < e.length; b++) {
				var a;
				b < c ? (a = this.getChildAt(b), a.visible = !0) : (a = new egret.Bitmap(RES.getRes("pot_png")), this.addChild(a));
				a.x = e[b].x;
				a.y = e[b].y
			}
		};
		return f
	}(egret.Sprite);
Line.prototype.__class__ = "Line";
var GuideLayer = function(d) {
		function f() {
			d.call(this);
			this.skinName = skins.scene.GuideSkin;
			GameManager.instance.state = 5
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.step();
			this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this)
		};
		g.onTouchTap = function(e) {
			Const.gui.removeElement(this);
			GameManager.instance.state = 3;
			GameManager.instance.isGuided = !0;
			GameManager.instance.saveCfg()
		};
		g.step = function() {
			var e = new egret.Rectangle(391, 277, 60, 60);
			this.showMask(e)
		};
		g.showMask = function(e) {
			this.setOneRect(this.bg1, 0, 0, Const.WIN_W, e.y);
			this.setOneRect(this.bg2, 0, e.y, e.x, e.height);
			this.setOneRect(this.bg3, e.x, e.y, e.width, e.height);
			this.setOneRect(this.bg4, e.x + e.width, e.y, Const.WIN_W - e.x - e.width, e.height);
			this.setOneRect(this.bg5, 0, e.y + e.height, Const.WIN_W, Const.WIN_H - e.y - e.height)
		};
		g.setOneRect = function(e, c, b, a, d) {
			e.x = c;
			e.y = b;
			e.width = a;
			e.height = d
		};
		return f
	}(egret.gui.SkinnableComponent);
GuideLayer.prototype.__class__ = "GuideLayer";
var LoseLayer = function(d) {
		function f() {
			d.call(this);
			this.skinName = skins.scene.LoseLayerSkin;
			GameManager.instance.state = 7
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.scoreTF.text = GameManager.instance.score + "";
			this.mainBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.playBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			LevelManager.instance.level >= LevelManager.instance.MAX_LEVEL && (this.playBtn.visible = !1, this.mainBtn.x = (Const.WIN_W - this.mainBtn.width) / 2);
			AudioManager.instance.stopBgSound();
			AudioManager.instance.playEffect(Const.AUDIO_LOSE)
		};
		g.onBtnClick = function(e) {
			for (; 0 < egret.gui.PopUpManager.popUpList.length;) egret.gui.PopUpManager.removePopUp(egret.gui.PopUpManager.popUpList.pop());
			e = e.currentTarget;
			e == this.mainBtn ? Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_CHAPTER) : e == this.playBtn && (LevelManager.instance.level = LevelManager.instance.level, Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_GAME))
		};
		return f
	}(egret.gui.SkinnableComponent);
LoseLayer.prototype.__class__ = "LoseLayer";
var WinLayer = function(d) {
		function f(e) {
			d.call(this);
			this.skinName = skins.scene.WinLayerSkin;
			this.star = e;
			GameManager.instance.state = 6
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.star0.source = this.star1.source = this.star2.source = "win_star_gray_png";
			2 < this.star && egret.setTimeout(this.showStarAnim, this, 1500, 2);
			1 < this.star && egret.setTimeout(this.showStarAnim, this, 1E3, 1);
			0 < this.star && egret.setTimeout(this.showStarAnim, this, 500, 0);
			this.scoreTF.text = GameManager.instance.score + "";
			this.light.anchorX = this.light.anchorY = 0.5;
			this.light.x += this.light.width / 2;
			this.light.y += this.light.height / 2;
			egret.Tween.get(this.light, {
				loop: !0
			}).to({
				rotation: 360
			}, 3600);
			this.mainBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.playBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			LevelManager.instance.level >= LevelManager.instance.MAX_LEVEL && (this.playBtn.visible = !1, this.mainBtn.x = (Const.WIN_W - this.mainBtn.width) / 2);
			AudioManager.instance.stopBgSound();
			AudioManager.instance.playEffect(Const.AUDIO_WIN)
		};
		g.showStarAnim = function(e) {
			e = this["star" + e];
			e.source = "win_star_png";
			e.scaleX = e.scaleY = 2;
			e.y -= 200;
			e.x -= 100;
			egret.Tween.get(e).to({
				x: e.x + 100,
				y: e.y + 200,
				scaleX: 1,
				scaleY: 1
			}, 200, egret.Ease.backOut)
		};
		g.onBtnClick = function(e) {
			for (; 0 < egret.gui.PopUpManager.popUpList.length;) egret.gui.PopUpManager.removePopUp(egret.gui.PopUpManager.popUpList.pop());
			e = e.currentTarget;
			e == this.mainBtn ? Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_CHAPTER) : e == this.playBtn && (LevelManager.instance.level++, Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_GAME))
		};
		return f
	}(egret.gui.SkinnableComponent);
WinLayer.prototype.__class__ = "WinLayer";
var Util = function() {
		function d() {}
		d.rang = function(d, g) {
			return Math.round(Math.random() * (g - d) + d)
		};
		d.limit = function(d, g, e) {
			return Math.max(g, Math.min(e, d))
		};
		d.layoutMovieClip = function(d) {
			d = d.mcDataSet.mc;
			for (var g in d) {
				for (var e = d[g].frames, c = 1E5, b = 1E5, a = 0; a < e.length; a++) e[a].x < c && (c = e[a].x), e[a].y < b && (b = e[a].y);
				for (a = 0; a < e.length; a++) e[a].x -= c, e[a].y -= b
			}
		};
		d.getMovieClipOffset = function(d) {
			var g = d.movieClipData.getKeyFrameData(1);
			return new egret.Point(g.x + d.width / 2, g.y + d.height / 2)
		};
		d.ang2rad = function(d) {
			return d / 180 * Math.PI
		};
		d.rad2ang = function(d) {
			return d / Math.PI * 180
		};
		return d
	}();
Util.prototype.__class__ = "Util";
var GameScene = function(d) {
		function f() {
			d.call(this);
			this.lastBubbleDownTime = 0;
			this.isGameOver = !1;
			this.CREATE_NEW_LINE_TIME = 1E4;
			this._lastSimulatTime = this.throwBubbleCount = 0;
			this.DIR_1 = [
				[-1, -1],
				[0, -1],
				[-1, 0],
				[1, 0],
				[-1, 1],
				[0, 1]
			];
			this.DIR_2 = [
				[0, -1],
				[1, -1],
				[-1, 0],
				[1, 0],
				[0, 1],
				[1, 1]
			];
			this.dropScore = this.eatScore = this.dropNum = this.eatNum = 0;
			Const.gameScene = this;
			this.isGameOver = !1;
			GameManager.instance.state = 3;
			var e = new egret.Bitmap(RES.getRes("gamebg_jpg"));
			this.addChild(e);
			e = new egret.Bitmap(RES.getRes("tree_down_png"));
			e.x = 10;
			e.y = Const.WIN_H - 75;
			this.addChild(e);
			this.gameRoot = new egret.Sprite;
			this.gameRoot.y = Const.UP;
			this.touchEnabled = !0;
			this.touchChildren = !1;
			this.gameRoot.width = Const.WIN_W;
			this.gameRoot.height = Const.WIN_H;
			this.addChild(this.gameRoot);
			Const.gameRoot = this.gameRoot;
			this.gui = new GameUILayer;
			Const.gui.addElement(this.gui);
			this.initBubbles();
			this.initHuHu();
			this.initTail();
			this.makeNext();
			1 != LevelManager.instance.level || GameManager.instance.isGuided || Const.gui.addElement(new GuideLayer);
			this.addEventListener(egret.Event.ADDED_TO_STAGE, this.onAdded, this);
			this.addEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this);
			AudioManager.instance.playBgSound()
		}
		__extends(f, d);
		var g = f.prototype;
		g.initTail = function() {
			this.tail = new particle.GravityParticleSystem(RES.getRes("tail_png"), RES.getRes("tail_json"));
			this.tail.x = 0;
			this.tail.y = 0;
			this.gameRoot.addChild(this.tail)
		};
		g.onAdded = function(e) {
			this.removeEventListener(egret.Event.ADDED_TO_STAGE, this.onAdded, this);
			this.stage.addEventListener(GameEvent.EVENT_USE_BOMB, this.changeBubbleBomb, this);
			this.stage.addEventListener(GameEvent.EVENT_USE_RELAYOUT, this.useRelayoutBubble, this);
			this.stage.addEventListener(GameEvent.EVENT_EXCHANGE_BUBBLE, this.exchangeBubble, this);
			this.addEventListener(egret.TouchEvent.TOUCH_BEGIN, this.onGameRootTouch, this);
			this.addEventListener(egret.TouchEvent.TOUCH_MOVE, this.onGameRootTouch, this);
			this.addEventListener(egret.TouchEvent.TOUCH_END, this.onGameRootTouch, this);
			egret.Ticker.getInstance().register(this.update, this);
			this.timer = new egret.Timer(500);
			this.timer.addEventListener(egret.TimerEvent.TIMER, this.onTimerTick, this);
			this.timer.start()
		};
		g.onRemoved = function(e) {
			this.removeEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this);
			this.stage.removeEventListener(GameEvent.EVENT_USE_BOMB, this.changeBubbleBomb, this);
			this.stage.removeEventListener(GameEvent.EVENT_USE_RELAYOUT, this.useRelayoutBubble, this);
			egret.Ticker.getInstance().unregister(this.update, this);
			this.removeEventListener(egret.TouchEvent.TOUCH_BEGIN, this.onGameRootTouch, this);
			this.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onGameRootTouch, this);
			this.removeEventListener(egret.TouchEvent.TOUCH_END, this.onGameRootTouch, this);
			Const.gameRoot = null;
			Const.gameScene = null;
			this.tail.stop(!0);
			this.gameRoot.removeChild(this.tail);
			this.tail = null;
			this.timer.removeEventListener(egret.TimerEvent.TIMER, this.onTimerTick, this)
		};
		g.onTimerTick = function(e) {
			if (3 == GameManager.instance.state || 4 == GameManager.instance.state) this.lastBubbleDownTime += 500, 3 == GameManager.instance.state && (this.calPushDow() ? this.pushDown() : this.lastBubbleDownTime >= this.CREATE_NEW_LINE_TIME ? (8E3 <= this.CREATE_NEW_LINE_TIME && (this.CREATE_NEW_LINE_TIME -= 100), this.pushDown()) : this.checkMiniLineCount())
		};
		g.calPushDow = function() {
			var e = Math.round(this.endBubbleY / Const.CELL_SIZE_H);
			if (8 > e) {
				for (var c = 0, b = 0; b < e; b++) for (var a = 0; a < Const.COL_MAX; a++) this.bubbles[b][a] && c++;
				if (4.9 > c / 8) return !0
			}
			return !1
		};
		g.initHuHu = function() {
			this.huhu = new HuHu;
			this.huhu.x = Const.WIN_W / 2;
			this.huhu.y = 780;
			this.gameRoot.addChild(this.huhu)
		};
		g.exchangeBubble = function() {
			var e = this.nextBubble;
			this.nextBubble = this.next2Bubble;
			this.next2Bubble = e;
			egret.Tween.get(this).to({
				factor: 1
			}, 300);
			egret.Tween.get(this.next2Bubble).to({
				x: Const.NEXT2_BUBBLE_POS.x,
				y: Const.NEXT2_BUBBLE_POS.y
			}, 300)
		};
		g.hasBombNotUsed = function() {
			return this.nextBubble && 100 == this.nextBubble.color ? !0 : !1
		};
		g.useRelayoutBubble = function() {
			var e = this;
			GameManager.instance.state = 4;
			for (var c = [], b = [], a = 0; a < Const.ROW_MAX; a++) for (var d = 0; d < Const.COL_MAX; d++) {
				var f = this.bubbles[a][d];
				f && 8 != f.color && (c.push(f), b.push([f.row, f.col]))
			}
			b.sort(function(a, b) {
				return 0.5 - Math.random()
			});
			for (a = 0; a < c.length; a++) f = b[a], d = c[a], f = this.bubbles[f[0]][f[1]], egret.Tween.get(d).to({
				x: f.x,
				y: f.y
			}, 500);
			for (a = 0; a < c.length; a++) f = b[a], d = c[a], this.bubbles[f[0]][f[1]] = d, d.row = f[0], d.col = f[1];
			egret.setTimeout(function() {
				e.isGameOver || 5 == GameManager.instance.state || (GameManager.instance.state = 3)
			}, this, 500)
		};
		g.changeBubbleBomb = function() {
			this.nextBubble.changeColor(100)
		};
		g.initBubbles = function() {
			this.bubbles = [];
			for (var e = 0; e < Const.ROW_MAX; e++) if (4 <= e) {
				for (var c = [], b = 0; b < Const.COL_MAX; b++) c.push(null);
				this.bubbles.push(c)
			} else c = LevelManager.instance.makeLine((4 - e - 0.5) * Const.CELL_SIZE_H, 4 - e - 1), this.bubbles[4 - e - 1] = c;
			this.endBubbleY = 4 * Const.CELL_SIZE_H - Const.CELL_SIZE_H / 2
		};
		Object.defineProperty(g, "factor", {
			get: function() {
				return 0
			},
			set: function(e) {
				this.nextBubble.x = (1 - e) * (1 - e) * Const.NEXT2_BUBBLE_POS.x + 2 * e * (1 - e) * (Const.NEXT_BUBBLE_POS.x + Const.NEXT2_BUBBLE_POS.x) / 2 + e * e * Const.NEXT_BUBBLE_POS.x;
				this.nextBubble.y = (1 - e) * (1 - e) * Const.NEXT2_BUBBLE_POS.y + 2 * e * (1 - e) * (Const.NEXT_BUBBLE_POS.y - 300) + e * e * Const.NEXT_BUBBLE_POS.y
			},
			enumerable: !0,
			configurable: !0
		});
		g.makeNext = function() {
			var e = this;
			this.next2Bubble ? (this.nextBubble = this.next2Bubble, egret.Tween.get(this).to({
				factor: 1
			}, 300).call(function() {
				e._makeNext2()
			})) : (this.nextBubble = BubblePool.getBubble(LevelManager.instance.randomColor()), this.gameRoot.addChild(this.nextBubble), this.nextBubble.x = Const.NEXT_BUBBLE_POS.x, this.nextBubble.y = Const.NEXT_BUBBLE_POS.y, this._makeNext2())
		};
		g._makeNext2 = function() {
			this.next2Bubble = BubblePool.getBubble(LevelManager.instance.randomColor());
			this.gameRoot.addChild(this.next2Bubble);
			this.next2Bubble.x = Const.NEXT2_BUBBLE_POS.x;
			this.next2Bubble.y = Const.NEXT2_BUBBLE_POS.y + 60;
			this.next2Bubble.scaleX = this.next2Bubble.scaleY = 0;
			egret.Tween.get(this.next2Bubble).to({
				scaleX: 1,
				scaleY: 1,
				y: Const.NEXT2_BUBBLE_POS.y
			}, 250)
		};
		g.onGameRootTouch = function(e) {
			3 == GameManager.instance.state && (e.type == egret.TouchEvent.TOUCH_BEGIN ? ShopManager.instance.isHelperLineGeted && this.simulate(e) : e.type == egret.TouchEvent.TOUCH_MOVE ? ShopManager.instance.isHelperLineGeted && this.simulate(e) : e.type == egret.TouchEvent.TOUCH_END && (Line.instance.removeFromParent(), GameManager.instance.state = 4, this.runningBubble && this.runningBubble.parent && -1 == this.runningBubble.row && this.runningBubble.isStop && BubblePool.pushBubble(this.runningBubble), this.runningBubble = this.nextBubble, this.makeNext(), e = Math.atan2(e.stageY - Const.NEXT_BUBBLE_POS.y - Const.UP, e.stageX - Const.NEXT_BUBBLE_POS.x), e = Util.limit(e, Util.ang2rad(-165), Util.ang2rad(-15)), this.runningBubble.fire(e), this.tail.start(), this.throwBubbleCount++, this.eatNum = this.dropNum = 0, e > Util.ang2rad(-75) ? this.huhu.throwRight() : e < Util.ang2rad(-105) ? this.huhu.throwLeft() : this.huhu.throwUp(e), LevelManager.instance.step--, this.gui.showStep()))
		};
		g.simulate = function(e) {
			var c = egret.getTimer() - this._lastSimulatTime;
			if (200 > c) egret.setTimeout(this.simulate, this, c);
			else {
				this._lastSimulatTime - egret.getTimer();
				this.addChild(Line.instance);
				e = Math.atan2(e.stageY - Const.NEXT_BUBBLE_POS.y - Const.UP, e.stageX - Const.NEXT_BUBBLE_POS.x);
				e = Util.limit(e, Util.ang2rad(-165), Util.ang2rad(-15));
				for (var c = Const.NEXT_BUBBLE_POS.clone(), b = 10 * Math.cos(e), a = 10 * Math.sin(e), d = [], f = !0, g = 0; f;) {
					c.x += b;
					c.y += a;
					c.x <= Const.LEFT ? (b *= -1, c.x = Const.CELL_SIZE_W - c.x) : c.x >= Const.RIGHT && (b *= -1, c.x = 2 * Const.WIN_W - Const.CELL_SIZE_W - c.x);
					c.y <= Const.CELL_SIZE_H / 2 && (f = !1);
					if (c.y <= this.endBubbleY + Const.CELL_SIZE_H + 10) for (var s = 0; s < this.bubbles.length; s++) for (var r = this.bubbles[s], k = 0; k < r.length; k++) {
						var l = r[k];
						if (l && egret.Point.distance(new egret.Point(c.x, c.y), new egret.Point(l.x, l.y)) <= Const.CELL_SIZE_W) {
							f = !1;
							break
						}
					}
					1 == g % 3 && 2 < g && d.push(c.clone());
					g++;
					100 < g && (f = !1)
				}
				Line.instance.draw(d);
				this.huhu.changeDir(e)
			}
		};
		g.pushDown = function() {
			var e = this;
			if (7 != GameManager.instance.state && 6 != GameManager.instance.state && 5 != GameManager.instance.state) {
				this.throwBubbleCount = this.lastBubbleDownTime = 0;
				GameManager.instance.state = 4;
				Line.instance.removeFromParent();
				for (var c = !1, b = !1, a = Const.ROW_MAX - 1; 0 <= a; a--) for (var d = this.bubbles[a], f = 0; f < d.length; f++) {
					var g = d[f];
					g && (g.row++, g.debug(), egret.Tween.get(g).to({
						y: g.y + Const.CELL_SIZE_H
					}, 300), d[f] = null, g.row < Const.ROW_MAX ? this.bubbles[g.row][f] = g : c = !0, g.row > Const.ROW_MAX - 3 && (b = !0))
				}
				a = LevelManager.instance.makeLine(-0.5 * Const.CELL_SIZE_H, 0);
				this.bubbles[0] = a;
				for (f = 0; f < a.length; f++) if (g = a[f]) g.debug(), egret.Tween.get(g).to({
					y: g.y + Const.CELL_SIZE_H
				}, 300);
				this.endBubbleY += Const.CELL_SIZE_H;
				this.gui.showEndLine(b);
				c ? (this.checkWin(), GameManager.instance.state = 7) : egret.setTimeout(function() {
					e.isGameOver || 5 == GameManager.instance.state || (GameManager.instance.state = 3)
				}, this, 300)
			}
		};
		g.update = function(e) {
			if (this.runningBubble) if (this.runningBubble.isStop) - 1 == this.runningBubble.row && this.runningBubble.parent && (BubblePool.pushBubble(this.runningBubble), this.runningBubble = null);
			else {
				for (var c = 0; 5 > c; c++) if (this.runningBubble.move(e / 5), this.tail.emitterX = this.runningBubble.x, this.tail.emitterY = this.runningBubble.y, this.runningBubble.y <= this.endBubbleY + Const.CELL_SIZE_H + 10) for (var b = 0; b < this.bubbles.length; b++) for (var a = this.bubbles[b], d = 0; d < a.length; d++) {
					var f = a[d];
					if (f && egret.Point.distance(new egret.Point(this.runningBubble.x, this.runningBubble.y), new egret.Point(f.x, f.y)) <= Const.CELL_SIZE_W) {
						this.runningBubbleStop();
						return
					}
				}
				this.runningBubble.y <= Const.CELL_SIZE_H / 2 && this.runningBubbleStop()
			}
		};
		g.runningBubbleStop = function() {
			var e = Math.round((this.runningBubble.y - Const.CELL_SIZE_H / 2) / Const.CELL_SIZE_H),
				c = 0,
				b = LevelManager.instance.getRowIsOffset(e),
				c = b ? Math.round((this.runningBubble.x - Const.CELL_SIZE_W) / Const.CELL_SIZE_W) : Math.round((this.runningBubble.x - Const.CELL_SIZE_W / 2) / Const.CELL_SIZE_W),
				c = Util.limit(c, 0, Const.COL_MAX - 1);
			this.runningBubble.stopMove();
			this.tail.start(0);
			e < Const.ROW_MAX && (this.bubbles[e][c] = this.runningBubble);
			this.runningBubble.row = e;
			this.runningBubble.col = c;
			this.runningBubble.x = b ? (c + 1) * Const.CELL_SIZE_W : (c + 0.5) * Const.CELL_SIZE_W;
			this.runningBubble.y = (e + 0.5) * Const.CELL_SIZE_H;
			this.checkCanEat()
		};
		g.showAddScore = function(e) {
			if (0 != e) {
				var c = LevelManager.instance.hit;
				1 < c && (e *= c);
				10 <= c ? this.gui.showExtTip(4) : 7 <= c ? this.gui.showExtTip(3) : 4 <= c ? this.gui.showExtTip(2) : 2 <= c && this.gui.showExtTip(1);
				LevelManager.instance.isCritical ? this.gui.showCritical(e) : 1 < LevelManager.instance.hit ? this.gui.showHit(LevelManager.instance.hit, e) : this.gui.showAddScore(e);
				GameManager.instance.score += e;
				LevelManager.instance.score += e;
				this.eatScore = this.dropScore = 0
			}
		};
		g.checkCanEat = function() {
			var e = this,
				c;
			if (100 == this.runningBubble.color) c = this.getCellNeighbourLayer(this.runningBubble, 2);
			else if (c = this.getCellSameTypeNeighbour(this.runningBubble), 3 > c.length && this.runningBubble.row >= Const.ROW_MAX) {
				this.checkWin();
				return
			}
			if (100 == this.runningBubble.color || 3 <= c.length) {
				if (100 == this.runningBubble.color) this.eatScore = this.calScore(c), this.playAnim(this.runningBubble.x, this.runningBubble.y, "bomb_anim"), AudioManager.instance.playEffect(Const.AUDIO_BOMB);
				else {
					var b = c.length;
					this.eatScore = b * BubbleCfg.getBubbleScore(c[0].color, b);
					AudioManager.instance.playEffect(Const.AUDIO_EAT)
				}
				this.eatNum = c.length;
				for (b = 0; b < c.length; b++) {
					var a = c[b];
					a.row < Const.ROW_MAX && -1 < a.row && (this.bubbles[a.row][a.col] = null);
					egret.Tween.get(a).to({
						scaleX: 0,
						scaleY: 0
					}, 200).call(function(a, b) {
						BubblePool.pushBubble(a);
						b == c.length - 1 && e.checkFloat()
					}, this, [a, b]);
					100 == this.runningBubble.color ? this.playAnim(a.x, a.y, "remove_anim_bomb") : this.playAnim(a.x, a.y, "remove_anim_normal")
				}
				this.checkHasEatLeaf(c)
			} else this.runningBubbleStopWaveAnim(), this.updateEndBubbleY(), this.checkShowEndLine(), this.calHit(), 0 >= LevelManager.instance.step && this.checkWin()
		};
		g.checkHasEatLeaf = function(e) {
			for (var c = this, b = 0, a = LevelManager.instance.leaf, d = 0; d < e.length; d++) {
				var f = e[d];
				8 == f.color && (this.gui.playGetLeafMoveAnim(f.x + Const.gameRoot.x, f.y + Const.gameRoot.y, a + b), b++)
			}
			LevelManager.instance.leaf += b;
			egret.setTimeout(function() {
				var a = LevelManager.instance;
				a.leaf >= a.currLevelVo.leaf && c.checkWin()
			}, this, 500)
		};
		g.playAnim = function(e, c, b) {
			b = new egret.MovieClipDataFactory(RES.getRes(b + "_json"), RES.getRes(b + "_png"));
			Util.layoutMovieClip(b);
			var a = new egret.MovieClip(b.generateMovieClipData());
			b = Util.getMovieClipOffset(a);
			a.x = e - b.x;
			a.y = c - b.y;
			a.play(1);
			a.addEventListener(egret.Event.COMPLETE, function() {
				a.parent && a.parent.removeChild(a)
			}, this);
			this.gameRoot.addChild(a)
		};
		g.huffman = function(e, c) {
			var b = Math.abs(e.row - c.row),
				a = Math.abs(e.col - c.col);
			return b > a ? 1.4 * (b - a) + a : 1.4 * (a - b) + b
		};
		g.runningBubbleStopWaveAnim = function() {
			var e = this;
			this.clearMapCheckState();
			this.runningBubble.checked = !0;
			this._findBubbleNeighbour(this.runningBubble);
			for (var c = [], b = 0; b < Const.ROW_MAX; b++) for (var a = 0; a < Const.COL_MAX; a++) {
				var d = this.bubbles[b][a];
				d && d.checked && c.push(d)
			}
			for (b = a = 0; b < c.length; b++) if (d = c[b], d != this.runningBubble) {
				var f = Math.atan2(this.runningBubble.y - d.y, this.runningBubble.x - d.x),
					g = 10 * Math.cos(f),
					f = 10 * Math.sin(f),
					s = egret.Point.distance(new egret.Point(d.x, d.y), new egret.Point(this.runningBubble.x, this.runningBubble.y)) / 2;
				s > a && (a = s);
				egret.Tween.get(d).to({
					x: d.x - g,
					y: d.y - f
				}, s).to({
					x: d.x,
					y: d.y
				}, s)
			}
			egret.setTimeout(function() {
				e.isGameOver || 5 == GameManager.instance.state || (GameManager.instance.state = 3)
			}, this, a + 100)
		};
		g.checkFloat = function() {
			var e = this;
			this.clearMapCheckState();
			for (var c = 0; c < Const.COL_MAX; c++) {
				var b = this.bubbles[0][c];
				b && (b.checked = !0, this._findBubbleNeighbour(b))
			}
			for (var a = [], c = 0; c < Const.ROW_MAX; c++) for (var d = 0; d < Const.COL_MAX; d++)(b = this.bubbles[c][d]) && !b.checked && (this.bubbles[c][d] = null, a.push(b));
			this.dropNum = a.length;
			this.calHit();
			if (0 < a.length) {
				for (c = 0; c < a.length; c++) b = a[c], egret.Tween.get(b).to({
					y: b.y + 350,
					alpha: 0
				}, 500, egret.Ease.sineIn).call(function(a) {
					BubblePool.pushBubble(a)
				}, this, [b]);
				egret.setTimeout(function() {
					e.isGameOver || 5 == GameManager.instance.state || (GameManager.instance.state = 3)
				}, this, 500);
				AudioManager.instance.playEffect(Const.AUDIO_DROP);
				this.checkHasEatLeaf(a)
			} else this.isGameOver || 5 == GameManager.instance.state || (GameManager.instance.state = 3);
			this.updateEndBubbleY();
			this.checkShowEndLine();
			this.dropScore = this.calScore(a);
			this.showAddScore(this.dropScore + this.eatScore);
			this.checkMiniLineCount();
			0 >= LevelManager.instance.step && this.checkWin()
		};
		g.checkWin = function() {
			if (7 != GameManager.instance.state && 6 != GameManager.instance.state) {
				this.isGameOver = !0;
				var e = GameManager.instance,
					c = LevelManager.instance;
				if (c.leaf >= c.currLevelVo.leaf) {
					console.log("win");
					GameManager.instance.state = 6;
					var b = LevelManager.instance.score + 100 * LevelManager.instance.step;
					egret.setTimeout(function() {
						var a = b >= c.currLevelVo.star3 ? 3 : b >= c.currLevelVo.star2 ? 2 : b >= c.currLevelVo.star1 ? 1 : 0;
						a > e.getStar(c.level) && e.updateWinLevelStar(c.level, a);
						egret.gui.PopUpManager.addPopUp(new WinLayer(a), !0, !1)
					}, this, 100 * LevelManager.instance.step);
					this.gui.showStepAddScore()
				} else console.log("game over"), egret.gui.PopUpManager.addPopUp(new LoseLayer, !0, !1)
			}
		};
		g.checkMiniLineCount = function() {
			4 <= this.throwBubbleCount ? this.pushDown() : 4 > Math.round(this.endBubbleY / Const.CELL_SIZE_H) && this.pushDown()
		};
		g.checkShowEndLine = function() {
			Math.round(this.endBubbleY / Const.CELL_SIZE_H) > Const.ROW_MAX - 3 ? this.gui.showEndLine(!0) : this.gui.showEndLine(!1)
		};
		g.calHit = function() {
			var e = this.eatNum + this.dropNum;
			5 <= e ? (LevelManager.instance.hit++, LevelManager.instance.isCritical = 10 <= e) : LevelManager.instance.hit = 0
		};
		g.calScore = function(e) {
			for (var c = new HashMap, b = 0; b < e.length; b++) {
				var a = e[b];
				c.set(a.color, (c.get(a.color) || 0) + 1)
			}
			e = c.keys();
			for (b = a = 0; b < e.length; b++) var d = c.get(e[b]),
				a = a + d * BubbleCfg.getBubbleScore(e[b], d);
			return a
		};
		g._findBubbleNeighbourWithLayer = function(d, c) {
			this.clearMapCheckState();
			var b = [];
			for (b.push([d.row, d.col, 0]); 0 < b.length;) {
				var a = b.shift(),
					f;
				f = LevelManager.instance.getRowIsOffset(a[0]) ? this.DIR_2 : this.DIR_1;
				for (var g = 0; g < f.length; g++) {
					var D = a[0] + f[g][1],
						s = a[1] + f[g][0];
					if (!(0 > D || 0 > s || D >= Const.ROW_MAX || s >= Const.COL_MAX)) {
						var r = this.bubbles[D][s];
						r && !r.checked && (r.checked = !0, a[2] < c && b.push([D, s, a[2] + 1]))
					}
				}
			}
		};
		g._findBubbleNeighbour = function(d) {
			var c;
			c = LevelManager.instance.getRowIsOffset(d.row) ? this.DIR_2 : this.DIR_1;
			for (var b = 0; b < c.length; b++) {
				var a = d.row + c[b][1],
					f = d.col + c[b][0];
				0 > a || 0 > f || a >= Const.ROW_MAX || f >= Const.COL_MAX || (a = this.bubbles[a][f]) && !a.checked && (a.checked = !0, this._findBubbleNeighbour(a))
			}
		};
		g.getCellNeighbourLayer = function(d, c) {
			this.clearMapCheckState();
			d.checked = !0;
			this.virtualBubbleArr = [];
			var b = this._findNeighbourLayer(d, [d], c);
			this.clearVirtualBubbleArr();
			return b
		};
		g.clearVirtualBubbleArr = function() {
			for (var d = 0; d < this.virtualBubbleArr.length; d++) BubblePool.pushBubble(this.virtualBubbleArr[d]);
			this.virtualBubbleArr = null
		};
		g.findBubbleInVirtualArr = function(d, c) {
			for (var b = 0; b < this.virtualBubbleArr.length; b++) {
				var a = this.virtualBubbleArr[b];
				if (a.row == d && a.col == c) return a
			}
			return null
		};
		g._findNeighbourLayer = function(d, c, b) {
			var a;
			a = LevelManager.instance.getRowIsOffset(d.row) ? this.DIR_2 : this.DIR_1;
			for (var f = 0; f < a.length; f++) {
				var g = d.row + a[f][1],
					D = d.col + a[f][0];
				if (!(0 > g || 0 > D || g >= Const.ROW_MAX || D >= Const.COL_MAX)) {
					var s = this.bubbles[g][D];
					s || (s = this.findBubbleInVirtualArr(g, D));
					s ? s.checked ? d.layer + 1 < s.layer && (s.layer = d.layer + 1, s.layer < b && this._findNeighbourLayer(s, c, b)) : (s.layer = d.layer + 1, s.checked = !0, c.push(s), s.layer < b && this._findNeighbourLayer(s, c, b)) : (s = BubblePool.getBubble(7), s.row = g, s.col = D, s.layer = d.layer + 1, s.checked = !0, this.virtualBubbleArr.push(s), s.layer < b && this._findNeighbourLayer(s, c, b))
				}
			}
			return c
		};
		g.getCellSameTypeNeighbour = function(d) {
			this.clearMapCheckState();
			d.checked = !0;
			return this._findCellSameTypeNeighbour(d, [d])
		};
		g._findCellSameTypeNeighbour = function(d, c) {
			var b;
			b = LevelManager.instance.getRowIsOffset(d.row) ? this.DIR_2 : this.DIR_1;
			for (var a = 0; a < b.length; a++) {
				var f = d.row + b[a][1],
					g = d.col + b[a][0];
				0 > f || 0 > g || f >= Const.ROW_MAX || g >= Const.COL_MAX || (f = this.bubbles[f][g]) && !f.checked && (f.checked = !0, f.color == d.color && (c.push(f), this._findCellSameTypeNeighbour(f, c)))
			}
			return c
		};
		g.clearMapCheckState = function() {
			for (var d = 0; d < Const.ROW_MAX; d++) for (var c = 0; c < Const.COL_MAX; c++) {
				var b = this.bubbles[d][c];
				b && (b.checked = !1, b.layer = 0)
			}
		};
		g.updateEndBubbleY = function() {
			for (var d = Const.ROW_MAX - 1; 0 <= d; d--) for (var c = this.bubbles[d], b = 0; b < c.length; b++) {
				var a = c[b];
				if (a) {
					this.endBubbleY = a.y;
					return
				}
			}
		};
		return f
	}(egret.Sprite);
GameScene.prototype.__class__ = "GameScene";
var skins;
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__3_i(), this.icon_i(), this.__4_i(), this.priceTF_i(), this.nameTF_i(), this.descTF_i(), this.buyBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "y"], ["price_bg_png", 0]);
					return a
				};
				b.buyBtn_i = function() {
					var a = new egret.gui.Button;
					this.buyBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("buy_btn_png"), 346, 17]);
					return a
				};
				b.descTF_i = function() {
					var a = new egret.gui.Label;
					this.descTF = a;
					this.__s(a, "fontFamily size text textColor width x y".split(" "), ["Arial", 22, "泡泡按照路线", 3112300, 237, 104, 51]);
					return a
				};
				b.icon_i = function() {
					var a = new egret.gui.UIAsset;
					this.icon = a;
					this.__s(a, ["source", "x", "y"], ["item_icon_1_png", 6, 7]);
					return a
				};
				b.nameTF_i = function() {
					var a = new egret.gui.UIAsset;
					this.nameTF = a;
					this.__s(a, ["source", "x", "y"], ["item_txt_name_1_png", 104, 10]);
					return a
				};
				b.priceTF_i = function() {
					var a = new egret.gui.Label;
					this.priceTF = a;
					this.__s(a, "height rotation size text textAlign verticalAlign width x y".split(" "), [22, -45, 18, "2元", "center", "middle", 38, 6, 26]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["height", "left", "source", "top", "width"], [93, 0, "icon_bg_png", 0, 94]);
					return a
				};
				c._skinParts = ["icon", "priceTF", "nameTF", "descTF", "buyBtn"];
				return c
			}(egret.gui.Skin);
		d.ShopItemRendererSkin = g;
		g.prototype.__class__ = "skins.component.ShopItemRendererSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
var Const = function() {
		function d() {}
		d.WIN_W = 640;
		d.WIN_H = 960;
		d.CELL_SIZE_W = 60;
		d.CELL_SIZE_H = 50;
		d.ROW_MAX = 12;
		d.COL_MAX = 10;
		d.UP = 130;
		d.LEFT = d.CELL_SIZE_W / 2;
		d.RIGHT = d.WIN_W - d.CELL_SIZE_W / 2;
		d.VERTIFY_KEY = "sanside.com";
		d.NEXT_BUBBLE_POS = new egret.Point(d.WIN_W / 2, d.WIN_H - 100 - d.UP);
		d.NEXT2_BUBBLE_POS = new egret.Point(70, d.WIN_H - 110 - d.UP);
		d.AUDIO_BGSOUND = "bgsound_mp3";
		d.AUDIO_BOMB = "bomb_mp3";
		d.AUDIO_DROP = "drop_mp3";
		d.AUDIO_EAT = "eat_mp3";
		d.AUDIO_LOSE = "lose_mp3";
		d.AUDIO_SHOOT = "shoot_mp3";
		d.AUDIO_WIN = "win_mp3";
		return d
	}();
Const.prototype.__class__ = "Const";
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.bg_i(), this.group_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.group_i = function() {
					var a = new egret.gui.Group;
					this.group = a;
					this.__s(a, ["height", "width", "x", "y"], [173, 149, 0, 0]);
					a.elementsContent = [this.star0_i(), this.star1_i(), this.star2_i()];
					return a
				};
				b.bg_i = function() {
					var a = new egret.gui.UIAsset;
					this.bg = a;
					this.__s(a, ["height", "source", "width", "x", "y"], [173, "ch_open_png", 149, 0, 0]);
					return a
				};
				b.star0_i = function() {
					var a = new egret.gui.UIAsset;
					this.star0 = a;
					this.__s(a, ["source", "x", "y"], ["ch_star_png", 18, 104]);
					return a
				};
				b.star1_i = function() {
					var a = new egret.gui.UIAsset;
					this.star1 = a;
					this.__s(a, ["source", "x", "y"], ["ch_star_png", 56.5, 104]);
					return a
				};
				b.star2_i = function() {
					var a = new egret.gui.UIAsset;
					this.star2 = a;
					this.__s(a, ["source", "x", "y"], ["ch_star_png", 94, 104]);
					return a
				};
				c._skinParts = ["bg", "star0", "star1", "star2", "group"];
				return c
			}(egret.gui.Skin);
		d.ChapterItemRendererSkin = g;
		g.prototype.__class__ = "skins.component.ChapterItemRendererSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)]), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "percentWidth", 90), new egret.gui.SetProperty("__4", "percentHeight", 90), new egret.gui.SetProperty("__4", "horizontalCenter", 0), new egret.gui.SetProperty("__4", "verticalCenter", 0)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__4 = b;
					b.source = "music_on_png";
					return b
				};
				return c
			}(egret.gui.Skin);
		d.MusicOnSkin = g;
		g.prototype.__class__ = "skins.component.MusicOnSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)]), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "percentWidth", 90), new egret.gui.SetProperty("__4", "percentHeight", 90), new egret.gui.SetProperty("__4", "horizontalCenter", 0), new egret.gui.SetProperty("__4", "verticalCenter", 0)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__4 = b;
					b.source = "pause_music_on_png";
					return b
				};
				return c
			}(egret.gui.Skin);
		d.PauseMusicOnSkin = g;
		g.prototype.__class__ = "skins.component.PauseMusicOnSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__3_i(), this.icon_i(), this.nameTF_i(), this.descTF_i(), this.getBtn_i(), this.expTF_i(), this.__4_i(), this.geted_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "y"], ["shop_line_png", 105]);
					return a
				};
				b.descTF_i = function() {
					var a = new egret.gui.Label;
					this.descTF = a;
					this.__s(a, "fontFamily size text textColor width x y".split(" "), ["Arial", 22, "泡泡按照路线", 3112300, 237, 104, 69]);
					return a
				};
				b.expTF_i = function() {
					var a = new egret.gui.Label;
					this.expTF = a;
					this.__s(a, "size text textColor width x y".split(" "), [22, "(11/20)", 3112300, 236, 105, 40]);
					return a
				};
				b.getBtn_i = function() {
					var a = new egret.gui.Button;
					this.getBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("get_btn_png"), 346, 23]);
					return a
				};
				b.geted_i = function() {
					var a = new egret.gui.UIAsset;
					this.geted = a;
					this.__s(a, ["source", "x", "y"], ["txt_geted_png", 353, 35]);
					return a
				};
				b.icon_i = function() {
					var a = new egret.gui.UIAsset;
					this.icon = a;
					this.__s(a, ["source", "x", "y"], ["task_icon_1_png", -1, 14]);
					return a
				};
				b.nameTF_i = function() {
					var a = new egret.gui.UIAsset;
					this.nameTF = a;
					this.__s(a, ["source", "x", "y"], ["task_name_1_png", 104, 6]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["height", "left", "source", "top", "width"], [93, 0, "icon_bg_png", 6, 94]);
					return a
				};
				c._skinParts = "icon nameTF descTF getBtn expTF geted".split(" ");
				return c
			}(egret.gui.Skin);
		d.TaskItemRendererSkin = g;
		g.prototype.__class__ = "skins.component.TaskItemRendererSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.__4_i(), this.__5_i(), this.__6_i(), this.__7_i(), this.closeBtn_i(), this.group_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_title_png", 156, 171]);
					return a
				};
				b.__5_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_line_png", 95, 355]);
					return a
				};
				b.__6_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_line_png", 95, 470]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_line_png", 95, 585]);
					return a
				};
				b.closeBtn_i = function() {
					var a = new egret.gui.Button;
					this.closeBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("close_btn_png"), 544, 183]);
					return a
				};
				b.group_i = function() {
					var a = new egret.gui.Group;
					this.group = a;
					this.__s(a, ["height", "width", "x", "y"], [435, 477, 88, 252]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_bg_png", 33, 202]);
					return a
				};
				c._skinParts = ["closeBtn", "group"];
				return c
			}(egret.gui.Skin);
		d.ShopLayerSkin = g;
		g.prototype.__class__ = "skins.scene.ShopLayerSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
var ShopItem = function(d) {
		function f(e) {
			d.call(this);
			this.vo = e;
			this.skinName = skins.component.ShopItemRendererSkin
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.buyBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBuyClick, this)
		};
		g.onBuyClick = function(d) {
			this.buySuccess()
		};
		g.buySuccess = function() {
			for (var d = 0; d < this.vo.goodsArr.length; d++) {
				var c = this.vo.goodsArr[d];
				GoodsManager.instance.addGoodsCount(c.id, c.num)
			}
			GameManager.instance.saveCfg()
		};
		g.update = function() {
			1 == this.vo.id && (this.buyBtn.visible = !ShopManager.instance.isHelperLineGeted);
			this.icon.source = this.vo.icon;
			this.nameTF.source = this.vo.resId;
			this.priceTF.text = this.vo.price + "元";
			if (1 == this.vo.goodsArr.length) this.descTF.text = this.vo.goodsArr[0].baseVo.desc;
			else {
				for (var d = "", c = 0; c < this.vo.goodsArr.length; c++) d += this.vo.goodsArr[c].baseVo.name + "<font color='#ca3939'>x" + this.vo.goodsArr[c].num + "</font> ";
				this.descTF.textFlow = (new egret.HtmlTextParser).parser(d)
			}
		};
		return f
	}(egret.gui.SkinnableComponent);
ShopItem.prototype.__class__ = "ShopItem";
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)]), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "percentWidth", 90), new egret.gui.SetProperty("__4", "percentHeight", 90), new egret.gui.SetProperty("__4", "horizontalCenter", 0), new egret.gui.SetProperty("__4", "verticalCenter", 0)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__4 = b;
					b.source = "music_off_png";
					return b
				};
				return c
			}(egret.gui.Skin);
		d.MusicOffSkin = g;
		g.prototype.__class__ = "skins.component.MusicOffSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)]), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "percentWidth", 90), new egret.gui.SetProperty("__4", "percentHeight", 90), new egret.gui.SetProperty("__4", "horizontalCenter", 0), new egret.gui.SetProperty("__4", "verticalCenter", 0)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "left", 0), new egret.gui.SetProperty("__4", "right", 0), new egret.gui.SetProperty("__4", "top", 0), new egret.gui.SetProperty("__4", "bottom", 0)])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__4 = b;
					b.source = "pause_music_off_png";
					return b
				};
				return c
			}(egret.gui.Skin);
		d.PauseMusicOffSkin = g;
		g.prototype.__class__ = "skins.component.PauseMusicOffSkin"
	})(d.component || (d.component = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.__4_i(), this.homeBtn_i(), this.nextBtn_i(), this.prevBtn_i(), this.pageTF_i(), this.scroller_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					a.source = "ch_top_png";
					return a
				};
				b.__5_i = function() {
					var a = new egret.gui.Rect;
					this.__s(a, ["fillAlpha", "height", "width", "x", "y"], [0.01, 699, 1920, 0, 0]);
					return a
				};
				b.group_i = function() {
					var a = new egret.gui.Group;
					this.group = a;
					a.width = 1920;
					a.elementsContent = [this.__5_i()];
					return a
				};
				b.homeBtn_i = function() {
					var a = new egret.gui.Button;
					this.homeBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("ch_home_png"), 266, 849]);
					return a
				};
				b.nextBtn_i = function() {
					var a = new egret.gui.Button;
					this.nextBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("ch_next_png"), 527, 856.5]);
					return a
				};
				b.pageTF_i = function() {
					var a = new egret.gui.Label;
					this.pageTF = a;
					this.__s(a, "bold fontFamily size text textAlign textColor verticalAlign width x y".split(" "), [!0, "Arial", 53, "1/4", "center", 148018, "middle", 208, 215, 20]);
					return a
				};
				b.prevBtn_i = function() {
					var a = new egret.gui.Button;
					this.prevBtn = a;
					this.__s(a, ["scaleX", "skinName", "x", "y"], [-1, new egret.gui.ButtonSkin("ch_next_png"), 122, 856.5]);
					return a
				};
				b.scroller_i = function() {
					var a = new egret.gui.Scroller;
					this.scroller = a;
					this.__s(a, "autoHideDelay autoHideScrollBars height width x y".split(" "), [0, !0, 699, 640, 0, 141]);
					a.viewport = this.group_i();
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [0, 0, 0, "gamebg_jpg", 0]);
					return a
				};
				c._skinParts = "homeBtn nextBtn prevBtn pageTF group scroller".split(" ");
				return c
			}(egret.gui.Skin);
		d.ChapterSceneSkin = g;
		g.prototype.__class__ = "skins.scene.ChapterSceneSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.playBtn_i(), this.musicBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.musicBtn_i = function() {
					var a = new egret.gui.Button;
					this.musicBtn = a;
					this.__s(a, ["label", "skinName", "x", "y"], ["按钮", d.component.MusicOnSkin, 20, 846]);
					return a
				};
				b.playBtn_i = function() {
					var a = new egret.gui.Button;
					this.playBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("play_png"), 239, 396]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [0, 0, 0, "index_jpg", 0]);
					return a
				};
				c._skinParts = ["playBtn", "musicBtn"];
				return c
			}(egret.gui.Skin);
		f.IndexSceneSkin = g;
		g.prototype.__class__ = "skins.scene.IndexSceneSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.closeBtn_i(), this.__4_i(), this.shopBtn_i(), this.mainBtn_i(), this.musicBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.Label;
					this.__s(a, "bold size text textAlign textColor verticalAlign x y".split(" "), [!0, 36, "游戏暂停", "center", 2097666, "middle", 250, 357]);
					return a
				};
				b.closeBtn_i = function() {
					var a = new egret.gui.Button;
					this.closeBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("close_btn_png"), 469, 288]);
					return a
				};
				b.mainBtn_i = function() {
					var a = new egret.gui.Button;
					this.mainBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("lose_main_png"), 276, 415]);
					return a
				};
				b.musicBtn_i = function() {
					var a = new egret.gui.Button;
					this.musicBtn = a;
					this.__s(a, ["skinName", "x", "y"], [d.component.PauseMusicOnSkin, 392, 415]);
					return a
				};
				b.shopBtn_i = function() {
					var a = new egret.gui.Button;
					this.shopBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("pause_shop_png"), 163, 415]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["pause_bg_png", 101, 298]);
					return a
				};
				c._skinParts = ["closeBtn", "shopBtn", "mainBtn", "musicBtn"];
				return c
			}(egret.gui.Skin);
		f.PauseLayerSkin = g;
		g.prototype.__class__ = "skins.scene.PauseLayerSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.__4_i(), this.closeBtn_i(), this.scroller_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["task_title_png", 156, 171]);
					return a
				};
				b.closeBtn_i = function() {
					var a = new egret.gui.Button;
					this.closeBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("close_btn_png"), 544, 183]);
					return a
				};
				b.group_i = function() {
					var a = new egret.gui.Group;
					return this.group = a
				};
				b.scroller_i = function() {
					var a = new egret.gui.Scroller;
					this.scroller = a;
					this.__s(a, ["height", "horizontalScrollPolicy", "width", "x", "y"], [459, "off", 465, 96, 255]);
					a.viewport = this.group_i();
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["shop_bg_png", 33, 202]);
					return a
				};
				c._skinParts = ["closeBtn", "group", "scroller"];
				return c
			}(egret.gui.Skin);
		d.TaskLayerSkin = g;
		g.prototype.__class__ = "skins.scene.TaskLayerSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__s(b, ["fillMode", "height", "source", "verticalCenter", "percentWidth"], ["scale", 10, "hscrollbtn_png", 0, 100]);
					return b
				};
				return c
			}(egret.gui.Skin);
		d.HScrollBarThumbSkin = g;
		g.prototype.__class__ = "skins.simple.HScrollBarThumbSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.minHeight = 22;
					this.elementsContent = [this.__7_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__7", "source", "tree_btndown_png")]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__7", "source", "tree_btndisabled_png")]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__7", "source", "tree_btnupselect_png")]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__7", "source", "tree_btndownselect_png")]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__7", "source", "tree_btndisabledselect_png")])]
				}
				__extends(c, d);
				c.prototype.__7_i = function() {
					var b = new egret.gui.UIAsset;
					this.__7 = b;
					this.__s(b, ["percentHeight", "source", "percentWidth"], [100, "tree_btnup_png", 100]);
					return b
				};
				return c
			}(egret.gui.Skin);
		d.TreeDisclosureButtonSkin = g;
		g.prototype.__class__ = "skins.simple.TreeDisclosureButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__s(b, ["fillMode", "percentHeight", "horizontalCenter", "source", "width"], ["scale", 100, 0, "vscrollbtn_png", 10]);
					return b
				};
				return c
			}(egret.gui.Skin);
		d.VScrollBarThumbSkin = g;
		g.prototype.__class__ = "skins.simple.VScrollBarThumbSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
var ChapterItem = function(d) {
		function f(e) {
			d.call(this);
			this.level = e;
			this.skinName = skins.component.ChapterItemRendererSkin
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.levelTF = new egret.gui.BitmapLabel;
			this.levelTF.font = RES.getRes("chapter_fnt");
			this.levelTF.anchorX = 0.5;
			this.levelTF.x = this.width / 2;
			this.levelTF.y = 35;
			this.levelTF.text = this.level.toString();
			this.group.addElement(this.levelTF);
			for (var d = GameManager.instance.getStar(this.level), c = [this.star0, this.star1, this.star2], b = 0; b < c.length; b++) c[b].source = d - 1 >= b ? "ch_star_png" : "ch_unstar_png";
			this.level > GameManager.instance.winLevelCount + 1 ? (this.bg.source = "ch_close_png", this.group.visible = !1) : (this.bg.source = "ch_open_png", this.group.visible = !0);
			this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onClick, this)
		};
		g.onClick = function(d) {
			this.level > GameManager.instance.winLevelCount + 1 || (LevelManager.instance.level = this.level, Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_GAME))
		};
		return f
	}(egret.gui.SkinnableComponent);
ChapterItem.prototype.__class__ = "ChapterItem";
var ShopLayer = function(d) {
		function f() {
			d.call(this);
			this.skinName = skins.scene.ShopLayerSkin;
			this.addEventListener(egret.Event.ADDED_TO_STAGE, this.onAdded, this)
		}
		__extends(f, d);
		var g = f.prototype;
		Object.defineProperty(f, "instance", {
			get: function() {
				f._instance || (f._instance = new f);
				return f._instance
			},
			enumerable: !0,
			configurable: !0
		});
		g.onAdded = function(d) {
			if (this.allItems) for (d = 0; d < this.allItems.length; d++) this.allItems[d].update();
			GameManager.instance.state = 5;
			this.x = Const.WIN_W;
			egret.Tween.get(this).to({
				x: 0
			}, 500, egret.Ease.backOut)
		};
		g.childrenCreated = function() {
			var d = ShopManager.instance.shopData;
			this.allItems = [];
			for (var c = 0; c < d.length; c++) {
				var b = new ShopItem(d[c]);
				this.allItems.push(b);
				this.group.addElement(b);
				b.y = 115 * c;
				b.update()
			}
			this.closeBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onCloseClick, this);
			Const.stage.addEventListener(GameEvent.EVENT_ITEM_CHANGE, this.onItemChange, this)
		};
		g.onItemChange = function() {
			if (this.stage && this.allItems) for (var d = 0; d < this.allItems.length; d++) this.allItems[d].update()
		};
		g.onCloseClick = function(d) {
			var c = this;
			egret.Tween.get(this).to({
				x: Const.WIN_W
			}, 500, egret.Ease.backIn).call(function() {
				egret.gui.PopUpManager.removePopUp(c);
				0 == egret.gui.PopUpManager.popUpList.length && (GameManager.instance.state = 3)
			})
		};
		return f
	}(egret.gui.SkinnableComponent);
ShopLayer.prototype.__class__ = "ShopLayer";
var TaskItem = function(d) {
		function f(e) {
			d.call(this);
			this.vo = e;
			this.skinName = skins.component.TaskItemRendererSkin
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.update();
			this.getBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGetClick, this)
		};
		g.onGetClick = function(d) {
			this.vo.isFinish && !this.vo.isGetReward && (this.getReward(), this.update())
		};
		g.getReward = function() {
			for (var d = 0; d < this.vo.reward.length; d++) {
				var c = this.vo.reward[d];
				GoodsManager.instance.addGoodsCount(c.id, c.num)
			}
			this.vo.isGetReward = !0;
			GameManager.instance.saveCfg();
			Const.stage.dispatchEventWith(GameEvent.EVENT_TASK_CHANGE)
		};
		g.update = function() {
			this.getBtn.enabled = !this.vo.isGetReward || !this.vo.isFinish;
			this.getBtn.alpha = this.vo.isGetReward || !this.vo.isFinish ? 0.5 : 1;
			this.icon.source = this.vo.icon + "_png";
			this.nameTF.source = this.vo.resId + "_png";
			this.geted.visible = this.vo.isGetReward;
			this.getBtn.visible = !this.vo.isGetReward;
			this.expTF.text = "(" + this.vo.count + "/" + this.vo.maxCount + ")";
			for (var d = "奖励:", c = 0; c < this.vo.reward.length; c++) d += this.vo.reward[c].baseVo.name + "<font color='#ca3939'>x" + this.vo.reward[c].num + "</font> ";
			this.descTF.textFlow = (new egret.HtmlTextParser).parser(d)
		};
		return f
	}(egret.gui.SkinnableComponent);
TaskItem.prototype.__class__ = "TaskItem";
var AssetAdapter = function() {
		function d() {}
		d.prototype.getAsset = function(d, g, e, c) {
			function b(a) {
				g.call(e, a, d)
			}
			c = d;
			d.prototype && (c = new d);
			c instanceof egret.DisplayObject || c instanceof egret.Texture ? g.call(e, c, d) : "string" == typeof d ? RES.hasRes(d) ? RES.getResAsync(d, b, this) : RES.getResByUrl(d, b, this) : g.call(e, c, d)
		};
		return d
	}();
AssetAdapter.prototype.__class__ = "AssetAdapter";
var LoadingUI = function(d) {
		function f() {
			d.call(this);
			this.createView()
		}
		__extends(f, d);
		var g = f.prototype;
		g.createView = function() {
			this.textField = new egret.TextField;
			this.addChild(this.textField);
			this.textField.y = Const.WIN_H / 2 - 50;
			this.textField.width = Const.WIN_W;
			this.textField.height = 100;
			this.textField.textAlign = "center"
		};
		g.setProgress = function(d, c) {
			this.textField.text = "Loading..." + d + "/" + c
		};
		return f
	}(egret.Sprite);
LoadingUI.prototype.__class__ = "LoadingUI";
var LevelVo = function() {
		function d() {}
		d.prototype.setData = function(d) {
			this.id = d.id;
			this.leaf = d.leaves;
			this.star1 = d.star1;
			this.star2 = d.star2;
			this.star3 = d.star3;
			this.step = d.step;
			this.bubbleArr = d.resId;
			this.mapData = d.bubble
		};
		return d
	}();
LevelVo.prototype.__class__ = "LevelVo";
(function(d) {
	var f = function(d) {
			function e() {
				d.apply(this, arguments)
			}
			__extends(e, d);
			e.prototype.reset = function() {
				d.prototype.reset.call(this);
				this.scaleDelta = this.rotationDelta = this.tangentialAcceleration = this.radialAcceleration = this.velocityY = this.velocityX = this.startY = this.startX = 0
			};
			return e
		}(d.Particle);
	d.GravityParticle = f;
	f.prototype.__class__ = "particle.GravityParticle"
})(particle || (particle = {}));
var ChapterScene = function(d) {
		function f() {
			d.call(this);
			this.PAGES = this.currPage = 0;
			this.skinName = skins.scene.ChapterSceneSkin;
			GameManager.instance.state = 1
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.setListData();
			this.prevBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.nextBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.homeBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			AudioManager.instance.playBgSound()
		};
		g.onBtnClick = function(d) {
			d = d.currentTarget;
			d == this.prevBtn ? 0 < this.currPage && this.showListPage(--this.currPage) : d == this.nextBtn ? this.currPage < this.PAGES - 1 && this.showListPage(++this.currPage) : d == this.homeBtn && Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_INDEX)
		};
		g.setListData = function() {
			var d = this,
				c = Math.floor((LevelManager.instance.MAX_LEVEL - 1) / 16) + 1;
			this.PAGES = c;
			for (var b = 0; b < c; b++) for (var a = 0; 16 > a; a++) {
				var f = 16 * b + a + 1;
				f <= LevelManager.instance.MAX_LEVEL && (f = new ChapterItem(f), f.x = 12 + a % 4 * 155 + b * Const.WIN_W, f.y = 175 * Math.floor(a / 4), this.group.addElement(f))
			}
			this.scroller.scrollSpeed = 1E-4;
			var g = -1;
			this.scroller.addEventListener(egret.Event.COMPLETE, function() {
				var a = d.scroller.viewport.horizontalScrollPosition;
				if (g != a) {
					var b = a - Const.WIN_W * d.currPage;
					g = a;
					a = d.currPage;
					Math.abs(b) > 0.25 * Const.WIN_W && (0 < b ? a++ : a--);
					a = Util.limit(a, 0, d.PAGES - 1);
					d.showListPage(a)
				}
			}, this);
			this.showListPage(0)
		};
		g.showListPage = function(d) {
			this.currPage = d;
			this.scroller.throwHorizontally(d * Const.WIN_W, 350);
			this.pageTF.text = d + 1 + "/" + this.PAGES;
			this.nextBtn.visible = !0;
			this.prevBtn.visible = !0;
			0 == d ? this.prevBtn.visible = !1 : d == this.PAGES - 1 && (this.nextBtn.visible = !1)
		};
		return f
	}(egret.gui.SkinnableComponent);
ChapterScene.prototype.__class__ = "ChapterScene";
var IndexScene = function(d) {
		function f() {
			d.call(this);
			this.angle = 0;
			GameManager.instance.state = 1;
			this.skinName = skins.scene.IndexSceneSkin
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.playBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onStartBtnClick, this);
			this.musicBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onMusicBtnClick, this);
			this.playBtn.anchorY = 0.5;
			this.addEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this);
			egret.Ticker.getInstance().register(this.update, this);
			AudioManager.instance.playBgSound();
			this.musicShow()
		};
		g.onRemoved = function() {
			this.removeEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this);
			egret.Ticker.getInstance().unregister(this.update, this)
		};
		g.update = function(d) {
			this.angle += 2;
			this.playBtn.y = 25 * Math.sin(Util.ang2rad(this.angle)) + Const.WIN_H / 2
		};
		g.onStartBtnClick = function(d) {
			this.stage && this.stage.dispatchEventWith(GameEvent.EVENT_SHOW_CHAPTER)
		};
		g.onMusicBtnClick = function() {
			GameManager.instance.isSound = !GameManager.instance.isSound;
			this.musicShow()
		};
		g.musicShow = function() {
			this.musicBtn.skinName = GameManager.instance.isSound ? skins.component.MusicOnSkin : skins.component.MusicOffSkin
		};
		return f
	}(egret.gui.SkinnableComponent);
IndexScene.prototype.__class__ = "IndexScene";
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.mainGroup_i(), this.relayoutBtn_i(), this.bombBtn_i(), this.pauseBtn_i(), this.__5_i(), this.endLine_i(), this.__6_i(), this.exchangeBtn_i(), this.box_i(), this.taskTip_i(), this.stepGroup_i(), this.relayoutGroup_i(), this.bombGroup_i(), this.scoreGroup_i(), this.leafGroup_i(), this.goShopLayoutBtn_i(), this.goShopBombBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					a.source = "progress_back_png";
					return a
				};
				b.__5_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["height", "width", "x", "y"], [32, 458, 171, 917]);
					a.elementsContent = [this.__4_i(), this.expPro_i(), this.star1_i(), this.star2_i(), this.star3_i()];
					return a
				};
				b.__6_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["cup_png", 21, 792]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.UIAsset;
					a.source = "num_tip_png";
					return a
				};
				b.__8_i = function() {
					var a = new egret.gui.UIAsset;
					a.source = "num_tip_png";
					return a
				};
				b.bombBtn_i = function() {
					var a = new egret.gui.Button;
					this.bombBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("bomb_png"), 537, 804]);
					return a
				};
				b.bombGroup_i = function() {
					var a = new egret.gui.Group;
					this.bombGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [44, 43, 594, 795]);
					a.elementsContent = [this.__8_i(), this.bombNumTF_i()];
					return a
				};
				b.bombNumTF_i = function() {
					var a = new egret.gui.Label;
					this.bombNumTF = a;
					this.__s(a, "bold fontFamily height text textAlign verticalAlign width x y".split(" "), [!0, "Arial", 33, "1", "center", "middle", 58, -5, 4]);
					return a
				};
				b.box_i = function() {
					var a = new egret.gui.UIAsset;
					this.box = a;
					this.__s(a, ["source", "x", "y"], ["task_icon_3_png", 51, 8]);
					return a
				};
				b.endLine_i = function() {
					var a = new egret.gui.UIAsset;
					this.endLine = a;
					this.__s(a, ["scale9Grid", "source", "width", "x", "y"], [egret.gui.getScale9Grid("1,4,2,3"), "end_line_png", 640, 0, 738]);
					return a
				};
				b.exchangeBtn_i = function() {
					var a = new egret.gui.Button;
					this.exchangeBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("change_png"), 132, 837]);
					return a
				};
				b.expPro_i = function() {
					var a = new egret.gui.UIAsset;
					this.expPro = a;
					a.source = "progress_front_png";
					return a
				};
				b.goShopBombBtn_i = function() {
					var a = new egret.gui.UIAsset;
					this.goShopBombBtn = a;
					this.__s(a, ["height", "source", "width", "x", "y"], [48, "shop_add_btn_png", 45, 526, 865]);
					return a
				};
				b.goShopLayoutBtn_i = function() {
					var a = new egret.gui.UIAsset;
					this.goShopLayoutBtn = a;
					this.__s(a, ["height", "source", "width", "x", "y"], [48, "shop_add_btn_png", 45, 422, 865]);
					return a
				};
				b.leafGroup_i = function() {
					var a = new egret.gui.Group;
					this.leafGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [34, 356, 180, 6]);
					a.elementsContent = [this.leaf_0_i(), this.leaf_1_i(), this.leaf_2_i(), this.leaf_3_i(), this.leaf_4_i(), this.leaf_5_i(), this.leaf_6_i(), this.leaf_7_i()];
					return a
				};
				b.leaf_0_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_0 = a;
					this.__s(a, ["source", "y"], ["leaf_gray_png", 0]);
					return a
				};
				b.leaf_1_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_1 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 46.5, 0]);
					return a
				};
				b.leaf_2_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_2 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 92.5, 0]);
					return a
				};
				b.leaf_3_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_3 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 139.5, 0]);
					return a
				};
				b.leaf_4_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_4 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 185.5, 0]);
					return a
				};
				b.leaf_5_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_5 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 232.5, 0]);
					return a
				};
				b.leaf_6_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_6 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 278.5, 0]);
					return a
				};
				b.leaf_7_i = function() {
					var a = new egret.gui.UIAsset;
					this.leaf_7 = a;
					this.__s(a, ["source", "x", "y"], ["leaf_gray_png", 325, 0]);
					return a
				};
				b.mainGroup_i = function() {
					var a = new egret.gui.Group;
					this.mainGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [10, 100, 0, 0]);
					return a
				};
				b.pauseBtn_i = function() {
					var a = new egret.gui.Button;
					this.pauseBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("pause_png"), 550, 16]);
					return a
				};
				b.relayoutBtn_i = function() {
					var a = new egret.gui.Button;
					this.relayoutBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("relayout_png"), 432, 804]);
					return a
				};
				b.relayoutGroup_i = function() {
					var a = new egret.gui.Group;
					this.relayoutGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [44, 43, 493, 795]);
					a.elementsContent = [this.__7_i(), this.relayoutNumTF_i()];
					return a
				};
				b.relayoutNumTF_i = function() {
					var a = new egret.gui.Label;
					this.relayoutNumTF = a;
					this.__s(a, "bold fontFamily height text textAlign verticalAlign width x y".split(" "), [!0, "Arial", 33, "1", "center", "middle", 58, -5, 4]);
					return a
				};
				b.scoreGroup_i = function() {
					var a = new egret.gui.Group;
					this.scoreGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [39, 157, 352, 61]);
					return a
				};
				b.scoreStar_0_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_0 = a;
					a.source = "star_png";
					return a
				};
				b.scoreStar_1_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_1 = a;
					a.source = "star_png";
					return a
				};
				b.scoreStar_2_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_2 = a;
					this.__s(a, ["source", "x"], ["star_png", 12]);
					return a
				};
				b.scoreStar_3_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_3 = a;
					a.source = "star_png";
					return a
				};
				b.scoreStar_4_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_4 = a;
					this.__s(a, ["source", "x"], ["star_png", 13]);
					return a
				};
				b.scoreStar_5_i = function() {
					var a = new egret.gui.UIAsset;
					this.scoreStar_5 = a;
					this.__s(a, ["source", "x"], ["star_png", 25]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					a.source = "game_top_png";
					return a
				};
				b.star1_i = function() {
					var a = new egret.gui.Group;
					this.star1 = a;
					this.__s(a, ["height", "width", "x", "y"], [29, 28, 170, 1]);
					a.elementsContent = [this.scoreStar_0_i()];
					return a
				};
				b.star2_i = function() {
					var a = new egret.gui.Group;
					this.star2 = a;
					this.__s(a, ["height", "width", "x", "y"], [28, 39, 300, 1]);
					a.elementsContent = [this.scoreStar_1_i(), this.scoreStar_2_i()];
					return a
				};
				b.star3_i = function() {
					var a = new egret.gui.Group;
					this.star3 = a;
					this.__s(a, ["height", "width", "x", "y"], [29, 51, 402, 1]);
					a.elementsContent = [this.scoreStar_3_i(), this.scoreStar_4_i(), this.scoreStar_5_i()];
					return a
				};
				b.stepGroup_i = function() {
					var a = new egret.gui.Group;
					this.stepGroup = a;
					this.__s(a, ["height", "width", "x", "y"], [35, 86, 66, 901]);
					return a
				};
				b.taskTip_i = function() {
					var a = new egret.gui.UIAsset;
					this.taskTip = a;
					this.__s(a, ["source", "x", "y"], ["task_tip_png", 29, 5]);
					return a
				};
				c._skinParts = "mainGroup relayoutBtn bombBtn pauseBtn expPro scoreStar_0 star1 scoreStar_1 scoreStar_2 star2 scoreStar_3 scoreStar_4 scoreStar_5 star3 endLine exchangeBtn box taskTip stepGroup relayoutNumTF relayoutGroup bombNumTF bombGroup scoreGroup leaf_0 leaf_1 leaf_2 leaf_3 leaf_4 leaf_5 leaf_6 leaf_7 leafGroup goShopLayoutBtn goShopBombBtn".split(" ");
				return c
			}(egret.gui.Skin);
		d.GameSceneSkin = g;
		g.prototype.__class__ = "skins.scene.GameSceneSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i(), this.labelDisplay_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("labelDisplay", "textColor", 1118481)]), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "source", "closebtn_down_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 2236962)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "source", "closebtn_disabled_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 13421772)])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "bottom fontFamily left right size textAlign top verticalAlign".split(" "), [12, "Tahoma", 10, 10, 20, "center", 8, "middle"]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__4 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "closebtn_up_png", 100]);
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.CloseButtonSkin = g;
		g.prototype.__class__ = "skins.simple.CloseButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.height = 40;
					this.elementsContent = [this.__4_i(), this.__5_i(), this.labelDisplay_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "source", "app_list_item_select_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 15790320)]), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__5_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["height", "source", "percentWidth"], [1, "app_list_item_cutlline_png", 100]);
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, ["fontFamily", "left", "size", "textColor", "verticalCenter"], ["Tahoma", 32, 24, 1118481, 0]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__4 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "app_list_item_up_png", 100]);
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.DropDownListItemRendererSkin = g;
		g.prototype.__class__ = "skins.simple.DropDownListItemRendererSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "minWidth"], [60, 140]);
					this.elementsContent = [this.__4_i(), this.__5_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "source", "DropDownListButtonSkin_down_png"), new egret.gui.SetProperty("__5", "source", "dropdownlist_arrow_down_png")]), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__4 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "DropDownListButtonSkin_up_png", 100]);
					return a
				};
				b.__5_i = function() {
					var a = new egret.gui.UIAsset;
					this.__5 = a;
					this.__s(a, ["right", "source", "verticalCenter"], [4, "dropdownlist_arrow_up_png", 0]);
					return a
				};
				return c
			}(egret.gui.Skin);
		d.DropDownListOpenButtonSkin = g;
		g.prototype.__class__ = "skins.simple.DropDownListOpenButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [10, 20]);
					this.elementsContent = [this.track_i(), this.thumb_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.thumb_i = function() {
					var a = new egret.gui.Button;
					this.thumb = a;
					this.__s(a, ["height", "skinName", "verticalCenter", "width"], [10, d.simple.HScrollBarThumbSkin, 0, 24]);
					return a
				};
				b.track_i = function() {
					var a = new egret.gui.UIAsset;
					this.track = a;
					this.__s(a, "height left right source verticalCenter percentWidth".split(" "), [10, 10, 10, "hscrolltrack_png", 0, 100]);
					return a
				};
				c._skinParts = ["track", "thumb"];
				return c
			}(egret.gui.Skin);
		f.HScrollBarSkin = g;
		g.prototype.__class__ = "skins.simple.HScrollBarSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__s(b, ["fillMode", "percentHeight", "source", "percentWidth"], ["scale", 100, "hslider_thumb_png", 100]);
					return b
				};
				return c
			}(egret.gui.Skin);
		d.HSliderThumbSkin = g;
		g.prototype.__class__ = "skins.simple.HSliderThumbSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "minWidth"], [60, 140]);
					this.elementsContent = [this.__7_i(), this.labelDisplay_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__7", "source", "button_down_png")]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__7", "source", "button_disabled_png")]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__7", "source", "button_down_png")]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__7", "source", "button_down_png")]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__7", "source", "button_down_png")])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "bottom fontFamily left right size textAlign textColor top verticalAlign".split(" "), [12, "Tahoma", 10, 10, 20, "center", 1118481, 8, "middle"]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.UIAsset;
					this.__7 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "button_normal_png", 100]);
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.TabBarButtonSkin = g;
		g.prototype.__class__ = "skins.simple.TabBarButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.minHeight = 22;
					this.elementsContent = [this.contentGroup_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.contentGroup_i = function() {
					var a = new egret.gui.Group;
					this.contentGroup = a;
					this.__s(a, ["bottom", "top"], [0, 0]);
					a.layout = this.__4_i();
					a.elementsContent = [this.disclosureButton_i(), this.iconDisplay_i(), this.labelDisplay_i()];
					return a
				};
				b.disclosureButton_i = function() {
					var a = new egret.gui.ToggleButton;
					this.disclosureButton = a;
					this.__s(a, ["skinName", "verticalCenter"], [d.simple.TreeDisclosureButtonSkin, 0]);
					return a
				};
				b.iconDisplay_i = function() {
					var a = new egret.gui.UIAsset;
					this.iconDisplay = a;
					this.__s(a, ["height", "width"], [24, 24]);
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "bottom fontFamily left maxDisplayedLines right textAlign textColor top verticalAlign".split(" "), [3, "Tahoma", 5, 1, 5, "center", 7368816, 3, "middle"]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.HorizontalLayout;
					this.__s(a, ["gap", "verticalAlign"], [1, "middle"]);
					return a
				};
				c._skinParts = ["disclosureButton", "iconDisplay", "labelDisplay", "contentGroup"];
				return c
			}(egret.gui.Skin);
		f.TreeItemRendererSkin = g;
		g.prototype.__class__ = "skins.simple.TreeItemRendererSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [10, 10]);
					this.elementsContent = [this.track_i(), this.thumb_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.thumb_i = function() {
					var a = new egret.gui.Button;
					this.thumb = a;
					this.__s(a, ["height", "horizontalCenter", "skinName", "width"], [20, 0, d.simple.VScrollBarThumbSkin, 10]);
					return a
				};
				b.track_i = function() {
					var a = new egret.gui.UIAsset;
					this.track = a;
					this.__s(a, "bottom percentHeight horizontalCenter source top width".split(" "), [10, 100, 0, "vscrolltrack_png", 10, 10]);
					return a
				};
				c._skinParts = ["track", "thumb"];
				return c
			}(egret.gui.Skin);
		f.VScrollBarSkin = g;
		g.prototype.__class__ = "skins.simple.VScrollBarSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				c.prototype.__4_i = function() {
					var b = new egret.gui.UIAsset;
					this.__s(b, ["percentHeight", "source", "percentWidth"], [100, "vslider_thumb_png", 100]);
					return b
				};
				return c
			}(egret.gui.Skin);
		d.VSliderThumbSkin = g;
		g.prototype.__class__ = "skins.simple.VSliderThumbSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
var PauseLayer = function(d) {
		function f() {
			d.call(this);
			this.skinName = skins.scene.PauseLayerSkin;
			GameManager.instance.state = 5
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.y = -Const.WIN_H;
			egret.Tween.get(this).to({
				y: 0
			}, 500, egret.Ease.backOut);
			this.closeBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.shopBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.mainBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.musicBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.musicShow()
		};
		g.onBtnClick = function(d) {
			var c = this;
			d = d.currentTarget;
			if (d == this.mainBtn) egret.Tween.get(this).to({
				y: -Const.WIN_H
			}, 500, egret.Ease.backIn).call(function() {
				egret.gui.PopUpManager.removePopUp(c);
				Const.stage.dispatchEventWith(GameEvent.EVENT_SHOW_CHAPTER)
			});
			else if (d == this.shopBtn) egret.Tween.get(this).to({
				y: -Const.WIN_H
			}, 500, egret.Ease.backIn).call(function() {
				egret.gui.PopUpManager.removePopUp(c);
				egret.gui.PopUpManager.addPopUp(ShopLayer.instance, !0, !1)
			});
			else if (d == this.closeBtn) egret.Tween.get(this).to({
				y: -Const.WIN_H
			}, 500, egret.Ease.backIn).call(function() {
				egret.gui.PopUpManager.removePopUp(c);
				GameManager.instance.state = 3
			});
			else if (d == this.musicBtn) this.onMusicBtnClick()
		};
		g.onMusicBtnClick = function() {
			GameManager.instance.isSound = !GameManager.instance.isSound;
			this.musicShow()
		};
		g.musicShow = function() {
			this.musicBtn.skinName = GameManager.instance.isSound ? skins.component.PauseMusicOnSkin : skins.component.PauseMusicOffSkin
		};
		return f
	}(egret.gui.SkinnableComponent);
PauseLayer.prototype.__class__ = "PauseLayer";
var TaskLayer = function(d) {
		function f() {
			d.call(this);
			this.skinName = skins.scene.TaskLayerSkin;
			GameManager.instance.state = 5
		}
		__extends(f, d);
		var g = f.prototype;
		g.childrenCreated = function() {
			this.x = Const.WIN_W;
			egret.Tween.get(this).to({
				x: 0
			}, 500, egret.Ease.backOut);
			for (var d = TaskManager.instance.taskData, c = 0; c < d.length; c++) {
				var b = new TaskItem(d[c]);
				this.group.addElement(b);
				b.y = 115 * c;
				b.update()
			}
			this.closeBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onCloseClick, this)
		};
		g.onCloseClick = function(d) {
			var c = this;
			egret.Tween.get(this).to({
				x: Const.WIN_W
			}, 500, egret.Ease.backIn).call(function() {
				egret.gui.PopUpManager.removePopUp(c);
				GameManager.instance.state = 3
			})
		};
		return f
	}(egret.gui.SkinnableComponent);
TaskLayer.prototype.__class__ = "TaskLayer";
var Main = function(d) {
		function f() {
			d.call(this);
			this.addEventListener(egret.Event.ADDED_TO_STAGE, this.onAddToStage, this)
		}
		__extends(f, d);
		var g = f.prototype;
		g.onAddToStage = function(d) {
			egret.Injector.mapClass("egret.gui.IAssetAdapter", AssetAdapter);
			this.loadingView = new LoadingUI;
			this.stage.addChild(this.loadingView);
			RES.addEventListener(RES.ResourceEvent.CONFIG_COMPLETE, this.onConfigComplete, this);
			RES.loadConfig("resource/resource.json", "resource/")
		};
		g.onConfigComplete = function(d) {
			RES.removeEventListener(RES.ResourceEvent.CONFIG_COMPLETE, this.onConfigComplete, this);
			RES.addEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this);
			RES.addEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this);
			RES.addEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this);
			RES.loadGroup("preload")
		};
		g.onResourceLoadComplete = function(d) {
			"preload" == d.groupName && (this.stage.removeChild(this.loadingView), RES.removeEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this), RES.removeEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this), RES.removeEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this), this.createScene())
		};
		g.onResourceLoadError = function(d) {
			console.warn("Group:" + d.groupName + " has failed to load");
			this.onResourceLoadComplete(d)
		};
		g.onResourceProgress = function(d) {
			"preload" == d.groupName && this.loadingView.setProgress(d.itemsLoaded, d.itemsTotal)
		};
		g.createScene = function() {
			GoodsManager.instance.init();
			ShopManager.instance.init();
			TaskManager.instance.init();
			GameManager.instance.init();
			BubbleCfg.init();
			this.gameLayer = new egret.DisplayObjectContainer;
			this.addChild(this.gameLayer);
			this.guiLayer = new egret.gui.UIStage;
			this.addChild(this.guiLayer);
			Const.gui = this.guiLayer;
			Const.stage = this.stage;
			this.showIndex();
			this.stage.addEventListener(GameEvent.EVENT_SHOW_INDEX, this.showIndex, this);
			this.stage.addEventListener(GameEvent.EVENT_SHOW_CHAPTER, this.showChapter, this);
			this.stage.addEventListener(GameEvent.EVENT_SHOW_GAME, this.showGame, this)
		};
		g.showIndex = function() {
			this.gameLayer.removeChildren();
			this.guiLayer.removeAllElements();
			this.guiLayer.addElement(new IndexScene)
		};
		g.showChapter = function() {
			this.gameLayer.removeChildren();
			this.guiLayer.removeAllElements();
			this.guiLayer.addElement(new ChapterScene)
		};
		g.showGame = function() {
			console.log("show game");
			this.gameLayer.removeChildren();
			this.guiLayer.removeAllElements();
			this.gameLayer.addChild(new GameScene)
		};
		return f
	}(egret.DisplayObjectContainer);
Main.prototype.__class__ = "Main";
var HuHu = function(d) {
		function f() {
			var e = this;
			d.call(this);
			var c = new egret.MovieClipDataFactory(RES.getRes("throw_json"), RES.getRes("throw_png"));
			this.fac = c;
			Util.layoutMovieClip(c);
			this.mc = new egret.MovieClip(c.generateMovieClipData("throw_up"));
			this.mc.gotoAndStop(1);
			this.mc.anchorX = 0.5;
			this.mc.anchorY = 1;
			this.addChild(this.mc);
			this.mc.addEventListener(egret.Event.COMPLETE, function() {
				e.mc.gotoAndStop(1)
			}, this)
		}
		__extends(f, d);
		var g = f.prototype;
		g.changeDir = function(d) {
			this.mc.scaleX = d > -Math.PI / 2 ? -1 : 1
		};
		g.throwUp = function(d) {
			this.mc.movieClipData = this.fac.generateMovieClipData("throw_up");
			this.mc.scaleX = d > -Math.PI / 2 ? -1 : 1;
			this.mc.play(1)
		};
		g.throwLeft = function() {
			this.mc.movieClipData = this.fac.generateMovieClipData("throw_left");
			this.mc.scaleX = 1;
			this.mc.play(1)
		};
		g.throwRight = function() {
			this.mc.movieClipData = this.fac.generateMovieClipData("throw_left");
			this.mc.scaleX = -1;
			this.mc.play(1)
		};
		return f
	}(egret.Sprite);
HuHu.prototype.__class__ = "HuHu";
(function(d) {
	var f = function(f) {
			function e(b, a) {
				f.call(this, b, 200);
				this.parseConfig(a);
				this.emissionRate = this.lifespan / this.maxParticles;
				this.particleClass = d.GravityParticle
			}
			__extends(e, f);
			var c = e.prototype;
			c.parseConfig = function(b) {
				function a(a) {
					return "undefined" == typeof a ? 0 : a
				}
				this.emitterX = a(b.emitter.x);
				this.emitterY = a(b.emitter.y);
				this.emitterXVariance = a(b.emitterVariance.x);
				this.emitterYVariance = a(b.emitterVariance.y);
				this.gravityX = a(b.gravity.x);
				this.gravityY = a(b.gravity.y);
				this.maxParticles = a(b.maxParticles);
				this.speed = a(b.speed);
				this.speedVariance = a(b.speedVariance);
				this.lifespan = Math.max(0.01, a(b.lifespan));
				this.lifespanVariance = a(b.lifespanVariance);
				this.emitAngle = a(b.emitAngle);
				this.emitAngleVariance = a(b.emitAngleVariance);
				this.startSize = a(b.startSize);
				this.startSizeVariance = a(b.startSizeVariance);
				this.endSize = a(b.endSize);
				this.endSizeVariance = a(b.endSizeVariance);
				this.startRotation = a(b.startRotation);
				this.startRotationVariance = a(b.startRotationVariance);
				this.endRotation = a(b.endRotation);
				this.endRotationVariance = a(b.endRotationVariance);
				this.radialAcceleration = a(b.radialAcceleration);
				this.radialAccelerationVariance = a(b.radialAccelerationVariance);
				this.tangentialAcceleration = a(b.tangentialAcceleration);
				this.tangentialAccelerationVariance = a(b.tangentialAccelerationVariance);
				this.startAlpha = a(b.startAlpha);
				this.startAlphaVariance = a(b.startAlphaVariance);
				this.endAlpha = a(b.endAlpha);
				this.endAlphaVariance = a(b.endAlphaVariance)
			};
			c.initParticle = function(b) {
				var a = e.getValue(this.lifespan, this.lifespanVariance);
				b.currentTime = 0;
				b.totalTime = 0 < a ? a : 0;
				if (!(0 >= a)) {
					b.x = e.getValue(this.emitterX, this.emitterXVariance);
					b.y = e.getValue(this.emitterY, this.emitterYVariance);
					b.startX = this.emitterX;
					b.startY = this.emitterY;
					var c = e.getValue(this.emitAngle, this.emitAngleVariance),
						c = c * Math.PI / 180,
						d = e.getValue(this.speed, this.speedVariance);
					b.velocityX = d * Math.cos(c);
					b.velocityY = d * Math.sin(c);
					b.radialAcceleration = e.getValue(this.radialAcceleration, this.radialAccelerationVariance);
					b.tangentialAcceleration = e.getValue(this.tangentialAcceleration, this.tangentialAccelerationVariance);
					c = e.getValue(this.startSize, this.startSizeVariance);
					0.1 > c && (c = 0.1);
					d = e.getValue(this.endSize, this.endSizeVariance);
					0.1 > d && (d = 0.1);
					var f = this.texture.textureWidth;
					b.scale = c / f;
					b.scaleDelta = (d - c) / a / f;
					c = e.getValue(this.startRotation, this.startRotationVariance);
					d = e.getValue(this.endRotation, this.endRotationVariance);
					b.rotation = c;
					b.rotationDelta = (d - c) / a;
					c = e.getValue(this.startAlpha, this.startAlphaVariance);
					d = e.getValue(this.endAlpha, this.endAlphaVariance);
					b.alpha = c;
					b.alphaDelta = (d - c) / a
				}
			};
			e.getValue = function(b, a) {
				return b + a * (2 * Math.random() - 1)
			};
			c.advanceParticle = function(b, a) {
				a /= 1E3;
				var c = b.totalTime - b.currentTime;
				a = c > a ? a : c;
				b.currentTime += a;
				var c = b.x - b.startX,
					d = b.y - b.startY,
					e = Math.sqrt(c * c + d * d);
				0.01 > e && (e = 0.01);
				var c = c / e,
					d = d / e,
					e = c,
					f = d,
					c = c * b.radialAcceleration,
					d = d * b.radialAcceleration,
					g = e,
					e = -f * b.tangentialAcceleration,
					f = g * b.tangentialAcceleration;
				b.velocityX += a * (this.gravityX + c + e);
				b.velocityY += a * (this.gravityY + d + f);
				b.x += b.velocityX * a;
				b.y += b.velocityY * a;
				b.scale += b.scaleDelta * a * 1E3;
				b.rotation += b.rotationDelta * a * 1E3;
				b.alpha += b.alphaDelta * a * 1E3
			};
			return e
		}(d.ParticleSystem);
	d.GravityParticleSystem = f;
	f.prototype.__class__ = "particle.GravityParticleSystem"
})(particle || (particle = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.bg1_i(), this.bg2_i(), this.bg3_i(), this.bg4_i(), this.bg5_i(), this.tipTF_i(), this.tipTF0_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.bg2_i = function() {
					var a = new egret.gui.Rect;
					this.bg2 = a;
					this.__s(a, ["fillAlpha", "fillColor", "height", "width", "y"], [0.8, 0, 225, 204, 168]);
					return a
				};
				b.bg3_i = function() {
					var a = new egret.gui.UIAsset;
					this.bg3 = a;
					this.__s(a, ["source", "x", "y"], ["guide_cir_png", 265, 216]);
					return a
				};
				b.bg4_i = function() {
					var a = new egret.gui.Rect;
					this.bg4 = a;
					this.__s(a, "fillAlpha fillColor height right width y".split(" "), [0.8, 0, 225, 0, 203, 182]);
					return a
				};
				b.bg5_i = function() {
					var a = new egret.gui.Rect;
					this.bg5 = a;
					a.setStyle("textColor", 0);
					this.__s(a, ["fillAlpha", "fillColor", "height", "width", "y"], [0.8, 0, 537, 640, 415]);
					return a
				};
				b.bg1_i = function() {
					var a = new egret.gui.Rect;
					this.bg1 = a;
					this.__s(a, ["fillAlpha", "fillColor", "height", "width"], [0.8, 0, 116, 640]);
					return a
				};
				b.tipTF0_i = function() {
					var a = new egret.gui.Label;
					this.tipTF0 = a;
					this.__s(a, "fontFamily left right size text textAlign textColor y".split(" "), ["黑体", 0, 0, 28, "点击开始游戏", "center", 16777215, 598]);
					return a
				};
				b.tipTF_i = function() {
					var a = new egret.gui.Label;
					this.tipTF = a;
					this.__s(a, "fontFamily left right size text textAlign textColor y".split(" "), ["黑体", 0, 0, 28, "收集足够多的树叶，才可以通关", "center", 16777215, 472]);
					return a
				};
				c._skinParts = "bg1 bg2 bg3 bg4 bg5 tipTF tipTF0".split(" ");
				return c
			}(egret.gui.Skin);
		d.GuideSkin = g;
		g.prototype.__class__ = "skins.scene.GuideSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.__3_i(), this.__4_i(), this.scoreTF_i(), this.mainBtn_i(), this.playBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["lose_total_txt_png", 112, 524]);
					return a
				};
				b.mainBtn_i = function() {
					var a = new egret.gui.Button;
					this.mainBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("lose_main_png"), 213, 602]);
					return a
				};
				b.playBtn_i = function() {
					var a = new egret.gui.Button;
					this.playBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("lose_replay_png"), 367, 601]);
					return a
				};
				b.scoreTF_i = function() {
					var a = new egret.gui.BitmapLabel;
					this.scoreTF = a;
					this.__s(a, ["font", "text", "x", "y"], ["score_fnt", "0", 301, 527]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["lose_png", 100, 198]);
					return a
				};
				c._skinParts = ["scoreTF", "mainBtn", "playBtn"];
				return c
			}(egret.gui.Skin);
		d.LoseLayerSkin = g;
		g.prototype.__class__ = "skins.scene.LoseLayerSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "width"], [960, 640]);
					this.elementsContent = [this.light_i(), this.__3_i(), this.star0_i(), this.star1_i(), this.star2_i(), this.__4_i(), this.scoreTF_i(), this.mainBtn_i(), this.playBtn_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["lose_total_txt_png", 117, 568]);
					return a
				};
				b.light_i = function() {
					var a = new egret.gui.UIAsset;
					this.light = a;
					this.__s(a, ["source", "x", "y"], ["win_light_png", 49, 50]);
					return a
				};
				b.mainBtn_i = function() {
					var a = new egret.gui.Button;
					this.mainBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("win_main_png"), 195, 644]);
					return a
				};
				b.playBtn_i = function() {
					var a = new egret.gui.Button;
					this.playBtn = a;
					this.__s(a, ["skinName", "x", "y"], [new egret.gui.ButtonSkin("win_play_png"), 349, 644]);
					return a
				};
				b.scoreTF_i = function() {
					var a = new egret.gui.BitmapLabel;
					this.scoreTF = a;
					this.__s(a, ["font", "text", "x", "y"], ["score_fnt", "0", 306, 571]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["source", "x", "y"], ["win_png", 62, 192]);
					return a
				};
				b.star0_i = function() {
					var a = new egret.gui.UIAsset;
					this.star0 = a;
					this.__s(a, ["source", "x", "y"], ["win_star_png", 191, 448]);
					return a
				};
				b.star1_i = function() {
					var a = new egret.gui.UIAsset;
					this.star1 = a;
					this.__s(a, ["source", "x", "y"], ["win_star_png", 278, 474]);
					return a
				};
				b.star2_i = function() {
					var a = new egret.gui.UIAsset;
					this.star2 = a;
					this.__s(a, ["source", "x", "y"], ["win_star_png", 363, 448]);
					return a
				};
				c._skinParts = "light star0 star1 star2 scoreTF mainBtn playBtn".split(" ");
				return c
			}(egret.gui.Skin);
		d.WinLayerSkin = g;
		g.prototype.__class__ = "skins.scene.WinLayerSkin"
	})(d.scene || (d.scene = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["maxWidth", "minHeight", "minWidth"], [710, 230, 370]);
					this.elementsContent = [this.__1_i(), this.moveArea_i(), this.contentDisplay_i(), this.__4_i()]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__2_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "panel_headeback_png", 100]);
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.HorizontalLayout;
					this.__s(a, ["gap", "horizontalAlign", "paddingLeft", "paddingRight"], [10, "center", 20, 20]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["bottom", "horizontalCenter"], [25, 0]);
					a.layout = this.__3_i();
					a.elementsContent = [this.firstButton_i(), this.secondButton_i()];
					return a
				};
				b.closeButton_i = function() {
					var a = new egret.gui.Button;
					this.closeButton = a;
					this.__s(a, ["right", "skinName", "verticalCenter"], [10, d.simple.CloseButtonSkin, 0]);
					return a
				};
				b.contentDisplay_i = function() {
					var a = new egret.gui.Label;
					this.contentDisplay = a;
					this.__s(a, "bottom fontFamily left padding right size textAlign textColor top verticalAlign".split(" "), [45, "Tahoma", 1, 10, 1, 22, "center", 7499888, 36, "middle"]);
					return a
				};
				b.firstButton_i = function() {
					var a = new egret.gui.Button;
					this.firstButton = a;
					this.__s(a, ["height", "label", "width"], [50, "OK", 115]);
					return a
				};
				b.moveArea_i = function() {
					var a = new egret.gui.Group;
					this.moveArea = a;
					this.__s(a, ["height", "left", "right"], [55, 3, 9]);
					a.elementsContent = [this.__2_i(), this.titleDisplay_i(), this.closeButton_i()];
					return a
				};
				b.secondButton_i = function() {
					var a = new egret.gui.Button;
					this.secondButton = a;
					this.__s(a, ["height", "label", "width"], [50, "cancel", 115]);
					return a
				};
				b.__1_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "panel_back_png", 100]);
					return a
				};
				b.titleDisplay_i = function() {
					var a = new egret.gui.Label;
					this.titleDisplay = a;
					this.__s(a, "fontFamily left maxDisplayedLines minHeight right size textAlign textColor verticalAlign verticalCenter".split(" "), ["Tahoma", 5, 1, 28, 5, 26, "center", 7499888, "middle", 0]);
					return a
				};
				c._skinParts = "titleDisplay closeButton moveArea contentDisplay firstButton secondButton".split(" ");
				return c
			}(egret.gui.Skin);
		f.AlertSkin = g;
		g.prototype.__class__ = "skins.simple.AlertSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [60, 140]);
					this.elementsContent = [this.__4_i(), this.__6_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "source", "button_down_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 2236962)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__4", "source", "button_disabled_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 13421772)])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__5_i = function() {
					var a = new egret.gui.HorizontalLayout;
					this.__s(a, ["gap", "horizontalAlign", "verticalAlign"], [0, "center", "middle"]);
					return a
				};
				b.__6_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["bottom", "left", "right", "top"], [10, 10, 10, 10]);
					a.layout = this.__5_i();
					a.elementsContent = [this.iconDisplay_i(), this.labelDisplay_i()];
					return a
				};
				b.iconDisplay_i = function() {
					var a = new egret.gui.UIAsset;
					return this.iconDisplay = a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "fontFamily paddingLeft paddingRight size textAlign textColor verticalAlign".split(" "), ["Tahoma", 5, 5, 20, "center", 1118481, "middle"]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__4 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "button_normal_png", 100]);
					return a
				};
				c._skinParts = ["iconDisplay", "labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.ButtonSkin = g;
		g.prototype.__class__ = "skins.simple.ButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__9_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__8", "source", "checkbox_select_over_png")]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__8", "source", "checkbox_unselect_disabled_png")]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__8", "source", "checkbox_select_normal_png")]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__8", "source", "checkbox_unselect_over_png")]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__8", "source", "checkbox_select_disabled_png")])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__8_i = function() {
					var a = new egret.gui.UIAsset;
					this.__8 = a;
					this.__s(a, ["fillMode", "height", "source", "verticalCenter", "width"], ["scale", 24, "checkbox_unselect_normal_png", 1, 24]);
					return a
				};
				b.__9_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["percentHeight", "percentWidth"], [100, 100]);
					a.layout = this.__7_i();
					a.elementsContent = [this.__8_i(), this.labelDisplay_i()];
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "fontFamily maxDisplayedLines size textAlign textColor verticalAlign".split(" "), ["Tahoma", 1, 20, "center", 7368816, "middle"]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.HorizontalLayout;
					a.verticalAlign = "middle";
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.CheckBoxSkin = g;
		g.prototype.__class__ = "skins.simple.CheckBoxSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.openButton_i(), this.labelDisplay_i(), this.popUp_i()];
					this.states = [new egret.gui.State("normal", [new egret.gui.SetProperty("labelDisplay", "textColor", 1118481)]), new egret.gui.State("open", [new egret.gui.SetProperty("labelDisplay", "textColor", 2236962), new egret.gui.SetProperty("popUp", "displayPopUp", !0)]), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.dataGroup_i = function() {
					var a = new egret.gui.DataGroup;
					this.dataGroup = a;
					this.__s(a, ["percentHeight", "itemRendererSkinName", "percentWidth"], [100, d.simple.DropDownListItemRendererSkin, 100]);
					a.layout = this.__4_i();
					return a
				};
				b.dropDown_i = function() {
					var a = new egret.gui.Group;
					this.dropDown = a;
					this.__s(a, ["height", "visible"], [400, !0]);
					a.elementsContent = [this.scroller_i()];
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "fontFamily paddingLeft touchChildren touchEnabled verticalAlign verticalCenter".split(" "), ["Tahoma", 10, !1, !1, "middle", 0]);
					return a
				};
				b.openButton_i = function() {
					var a = new egret.gui.Button;
					this.openButton = a;
					this.__s(a, ["percentHeight", "skinName", "percentWidth"], [100, d.simple.DropDownListOpenButtonSkin, 100]);
					return a
				};
				b.popUp_i = function() {
					var a = new egret.gui.PopUpAnchor;
					this.popUp = a;
					this.__s(a, ["displayPopUp", "percentHeight", "popUpPosition", "percentWidth"], [!1, 100, "screenCenter", 100]);
					a.popUp = this.dropDown_i();
					return a
				};
				b.scroller_i = function() {
					var a = new egret.gui.Scroller;
					this.scroller = a;
					this.__s(a, ["percentHeight", "horizontalScrollPolicy", "percentWidth"], [100, "off", 100]);
					a.viewport = this.dataGroup_i();
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.VerticalLayout;
					this.__s(a, ["gap", "horizontalAlign"], [0, "justify"]);
					return a
				};
				c._skinParts = "openButton labelDisplay dataGroup scroller dropDown popUp".split(" ");
				return c
			}(egret.gui.Skin);
		f.DropDownListSkin = g;
		g.prototype.__class__ = "skins.simple.DropDownListSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [13, 50]);
					this.elementsContent = [this.track_i(), this.trackHighlight_i(), this.thumb_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.thumb_i = function() {
					var a = new egret.gui.Button;
					this.thumb = a;
					this.__s(a, ["height", "skinName", "verticalCenter", "width"], [24, d.simple.HSliderThumbSkin, 0, 24]);
					return a
				};
				b.trackHighlight_i = function() {
					var a = new egret.gui.UIAsset;
					this.trackHighlight = a;
					this.__s(a, ["height", "source", "verticalCenter"], [10, "hslider_fill_png", 0]);
					return a
				};
				b.track_i = function() {
					var a = new egret.gui.UIAsset;
					this.track = a;
					this.__s(a, ["height", "source", "verticalCenter", "percentWidth"], [10, "hslider_track_png", 0, 100]);
					return a
				};
				c._skinParts = ["track", "trackHighlight", "thumb"];
				return c
			}(egret.gui.Skin);
		f.HSliderSkin = g;
		g.prototype.__class__ = "skins.simple.HSliderSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.height = 85;
					this.elementsContent = [this.__4_i(), this.__5_i(), this.labelDisplay_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__4", "source", "app_list_item_select_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 15790320)]), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__5_i = function() {
					var a = new egret.gui.Rect;
					this.__s(a, "fillAlpha height strokeAlpha strokeColor strokeWeight percentWidth".split(" "), [0, 0.5, 1, 8947848, 0.5, 100]);
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, ["fontFamily", "left", "size", "textColor", "verticalCenter"], ["Tahoma", 32, 24, 1118481, 0]);
					return a
				};
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__4 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "app_list_item_up_png", 100]);
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.ItemRendererSkin = g;
		g.prototype.__class__ = "skins.simple.ItemRendererSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.Scroller;
					this.__s(a, ["percentHeight", "horizontalScrollPolicy", "percentWidth"], [100, "off", 100]);
					a.viewport = this.dataGroup_i();
					return a
				};
				b.dataGroup_i = function() {
					var a = new egret.gui.DataGroup;
					this.dataGroup = a;
					a.layout = this.__3_i();
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.VerticalLayout;
					this.__s(a, ["gap", "horizontalAlign"], [0, "contentJustify"]);
					return a
				};
				c._skinParts = ["dataGroup"];
				return c
			}(egret.gui.Skin);
		d.ListSkin = g;
		g.prototype.__class__ = "skins.simple.ListSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["maxWidth", "minHeight", "minWidth"], [710, 230, 470]);
					this.elementsContent = [this.__3_i(), this.moveArea_i(), this.contentGroup_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [-4, -2, -2, "panel_headeback_png", -2]);
					return a
				};
				b.contentGroup_i = function() {
					var a = new egret.gui.Group;
					this.contentGroup = a;
					this.__s(a, ["bottom", "clipAndEnableScrolling", "top", "percentWidth"], [0, !0, 50, 100]);
					return a
				};
				b.moveArea_i = function() {
					var a = new egret.gui.Group;
					this.moveArea = a;
					this.__s(a, ["height", "left", "right"], [50, 0, 0]);
					a.elementsContent = [this.__4_i(), this.titleDisplay_i()];
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [-10, -4, -10, "panel_back_png", -4]);
					return a
				};
				b.titleDisplay_i = function() {
					var a = new egret.gui.Label;
					this.titleDisplay = a;
					this.__s(a, "fontFamily left maxDisplayedLines minHeight right size textAlign textColor verticalAlign verticalCenter".split(" "), ["Tahoma", 5, 1, 28, 5, 26, "center", 7499888, "middle", 0]);
					return a
				};
				c._skinParts = ["titleDisplay", "moveArea", "contentGroup"];
				return c
			}(egret.gui.Skin);
		d.PanelSkin = g;
		g.prototype.__class__ = "skins.simple.PanelSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.track_i(), this.thumb_i(), this.labelDisplay_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "horizontalCenter maxDisplayedLines size textAlign textColor verticalAlign verticalCenter".split(" "), [0, 1, 20, "center", 7368816, "middle", 0]);
					return a
				};
				b.thumb_i = function() {
					var a = new egret.gui.UIAsset;
					this.thumb = a;
					a.source = "progressbar_fill_png";
					return a
				};
				b.track_i = function() {
					var a = new egret.gui.UIAsset;
					this.track = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "progressbar_track_png", 100]);
					return a
				};
				c._skinParts = ["track", "thumb", "labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.ProgressBarSkin = g;
		g.prototype.__class__ = "skins.simple.ProgressBarSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__9_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__8", "source", "radiobutton_select_over_png")]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__8", "source", "radiobutton_unselect_disabled_png")]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__8", "source", "radiobutton_select_normal_png")]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__8", "source", "radiobutton_unselect_over_png")]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__8", "source", "radiobutton_select_disabled_png")])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__8_i = function() {
					var a = new egret.gui.UIAsset;
					this.__8 = a;
					this.__s(a, ["fillMode", "height", "source", "verticalCenter", "width"], ["scale", 24, "radiobutton_unselect_normal_png", 1, 24]);
					return a
				};
				b.__9_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["percentHeight", "percentWidth"], [100, 100]);
					a.layout = this.__7_i();
					a.elementsContent = [this.__8_i(), this.labelDisplay_i()];
					return a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, "fontFamily maxDisplayedLines size textAlign textColor verticalAlign".split(" "), ["Tahoma", 1, 20, "center", 7368816, "middle"]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.HorizontalLayout;
					a.verticalAlign = "middle";
					return a
				};
				c._skinParts = ["labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.RadioButtonSkin = g;
		g.prototype.__class__ = "skins.simple.RadioButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["maxWidth", "minHeight", "minWidth"], [710, 230, 370]);
					this.elementsContent = [this.horizontalScrollBar_i(), this.verticalScrollBar_i()]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.horizontalScrollBar_i = function() {
					var a = new egret.gui.HScrollBar;
					this.horizontalScrollBar = a;
					a.skinName = d.simple.HScrollBarSkin;
					return a
				};
				b.verticalScrollBar_i = function() {
					var a = new egret.gui.VScrollBar;
					this.verticalScrollBar = a;
					a.skinName = d.simple.VScrollBarSkin;
					return a
				};
				c._skinParts = ["horizontalScrollBar", "verticalScrollBar"];
				return c
			}(egret.gui.Skin);
		f.ScrollerSkin = g;
		g.prototype.__class__ = "skins.simple.ScrollerSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["maxWidth", "minHeight", "minWidth"], [710, 230, 470]);
					this.elementsContent = [this.contentGroup_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.contentGroup_i = function() {
					var a = new egret.gui.Group;
					this.contentGroup = a;
					this.__s(a, ["percentHeight", "percentWidth"], [100, 100]);
					return a
				};
				c._skinParts = ["contentGroup"];
				return c
			}(egret.gui.Skin);
		d.SkinnableContainerSkin = g;
		g.prototype.__class__ = "skins.simple.SkinnableContainerSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [20, 60]);
					this.elementsContent = [this.dataGroup_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.dataGroup_i = function() {
					var a = new egret.gui.DataGroup;
					this.dataGroup = a;
					this.__s(a, ["percentHeight", "itemRenderer", "itemRendererSkinName", "percentWidth"], [100, new egret.gui.ClassFactory(egret.gui.TabBarButton), d.simple.TabBarButtonSkin, 100]);
					a.layout = this.__3_i();
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.HorizontalLayout;
					this.__s(a, ["gap", "horizontalAlign", "verticalAlign"], [-1, "justify", "contentJustify"]);
					return a
				};
				c._skinParts = ["dataGroup"];
				return c
			}(egret.gui.Skin);
		f.TabBarSkin = g;
		g.prototype.__class__ = "skins.simple.TabBarSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [30, 100]);
					this.elementsContent = [this.__3_i(), this.textDisplay_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [new egret.gui.SetProperty("textDisplay", "textColor", 11184810)])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "textbox_png", 100]);
					return a
				};
				b.textDisplay_i = function() {
					var a = new egret.gui.EditableText;
					this.textDisplay = a;
					this.__s(a, "bottom percentHeight left right size textColor top percentWidth".split(" "), [8, 100, 10, 10, 20, 0, 8, 100]);
					return a
				};
				c._skinParts = ["textDisplay"];
				return c
			}(egret.gui.Skin);
		d.TextAreaSkin = g;
		g.prototype.__class__ = "skins.simple.TextAreaSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [30, 100]);
					this.elementsContent = [this.__3_i(), this.textDisplay_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [new egret.gui.SetProperty("textDisplay", "textColor", 11184810)])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "textbox_png", 100]);
					return a
				};
				b.textDisplay_i = function() {
					var a = new egret.gui.EditableText;
					this.textDisplay = a;
					this.__s(a, "bottom percentHeight left right size textColor top percentWidth".split(" "), [8, 100, 10, 10, 20, 0, 8, 100]);
					return a
				};
				c._skinParts = ["textDisplay"];
				return c
			}(egret.gui.Skin);
		d.TextInputSkin = g;
		g.prototype.__class__ = "skins.simple.TextInputSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["maxWidth", "minHeight", "minWidth"], [710, 230, 470]);
					this.elementsContent = [this.__3_i(), this.moveArea_i(), this.contentGroup_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [-4, -3, -3, "panel_headeback_png", -2]);
					return a
				};
				b.closeButton_i = function() {
					var a = new egret.gui.Button;
					this.closeButton = a;
					this.__s(a, ["right", "skinName", "verticalCenter"], [10, d.simple.CloseButtonSkin, 0]);
					return a
				};
				b.contentGroup_i = function() {
					var a = new egret.gui.Group;
					this.contentGroup = a;
					this.__s(a, ["bottom", "clipAndEnableScrolling", "top", "percentWidth"], [0, !0, 51, 100]);
					return a
				};
				b.moveArea_i = function() {
					var a = new egret.gui.Group;
					this.moveArea = a;
					this.__s(a, ["height", "left", "right"], [50, 0, 0]);
					a.elementsContent = [this.__4_i(), this.titleDisplay_i(), this.closeButton_i()];
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.UIAsset;
					this.__s(a, ["bottom", "left", "right", "source", "top"], [-10, -4, -10, "panel_back_png", -4]);
					return a
				};
				b.titleDisplay_i = function() {
					var a = new egret.gui.Label;
					this.titleDisplay = a;
					this.__s(a, "fontFamily left maxDisplayedLines minHeight right size textAlign textColor verticalAlign verticalCenter".split(" "), ["Tahoma", 5, 1, 28, 5, 26, "center", 7499888, "middle", 0]);
					return a
				};
				c._skinParts = ["titleDisplay", "closeButton", "moveArea", "contentGroup"];
				return c
			}(egret.gui.Skin);
		f.TitleWindowSkin = g;
		g.prototype.__class__ = "skins.simple.TitleWindowSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["height", "minWidth"], [60, 140]);
					this.elementsContent = [this.__7_i(), this.__9_i()];
					this.states = [new egret.gui.State("up", []), new egret.gui.State("down", [new egret.gui.SetProperty("__7", "source", "togglebutton_over_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 1995877)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__7", "source", "togglebutton_disabled_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 13421772)]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__7", "source", "togglebutton_selected_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 15658476)]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__7", "source", "togglebutton_over_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 1995877)]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__7", "source", "togglebutton_disabled_png"), new egret.gui.SetProperty("labelDisplay", "textColor", 13421772)])]
				}
				__extends(c, d);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__8_i = function() {
					var a = new egret.gui.HorizontalLayout;
					this.__s(a, ["gap", "horizontalAlign", "verticalAlign"], [0, "center", "middle"]);
					return a
				};
				b.__9_i = function() {
					var a = new egret.gui.Group;
					this.__s(a, ["bottom", "left", "right", "top"], [10, 10, 10, 10]);
					a.layout = this.__8_i();
					a.elementsContent = [this.iconDisplay_i(), this.labelDisplay_i()];
					return a
				};
				b.iconDisplay_i = function() {
					var a = new egret.gui.UIAsset;
					return this.iconDisplay = a
				};
				b.labelDisplay_i = function() {
					var a = new egret.gui.Label;
					this.labelDisplay = a;
					this.__s(a, ["fontFamily", "size", "textAlign", "textColor", "verticalAlign"], ["Tahoma", 20, "center", 1995877, "middle"]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.UIAsset;
					this.__7 = a;
					this.__s(a, ["percentHeight", "source", "percentWidth"], [100, "togglebutton_normal_png", 100]);
					return a
				};
				c._skinParts = ["iconDisplay", "labelDisplay"];
				return c
			}(egret.gui.Skin);
		d.ToggleButtonSkin = g;
		g.prototype.__class__ = "skins.simple.ToggleButtonSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(d) {
		var g = function(d) {
				function c() {
					d.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__7_i(), this.__8_i(), this.__9_i(), this.__10_i(), this.__11_i(), this.__12_i()];
					this.states = [new egret.gui.State("up", [new egret.gui.SetProperty("__7", "visible", !0), new egret.gui.SetProperty("__8", "visible", !0), new egret.gui.SetProperty("__9", "visible", !0)]), new egret.gui.State("down", [new egret.gui.SetProperty("__7", "visible", !0), new egret.gui.SetProperty("__8", "visible", !0), new egret.gui.SetProperty("__9", "visible", !0)]), new egret.gui.State("disabled", [new egret.gui.SetProperty("__7", "visible", !0), new egret.gui.SetProperty("__8", "visible", !0), new egret.gui.SetProperty("__9", "visible", !0)]), new egret.gui.State("upAndSelected", [new egret.gui.SetProperty("__10", "visible", !0), new egret.gui.SetProperty("__11", "visible", !0), new egret.gui.SetProperty("__12", "visible", !0)]), new egret.gui.State("downAndSelected", [new egret.gui.SetProperty("__10", "visible", !0), new egret.gui.SetProperty("__11", "visible", !0), new egret.gui.SetProperty("__12", "visible", !0)]), new egret.gui.State("disabledAndSelected", [new egret.gui.SetProperty("__10", "visible", !0), new egret.gui.SetProperty("__11", "visible", !0), new egret.gui.SetProperty("__12", "visible", !0)])]
				}
				__extends(c, d);
				var b = c.prototype;
				b.__10_i = function() {
					var a = new egret.gui.UIAsset;
					this.__10 = a;
					this.__s(a, ["source", "visible"], ["onoffbutton_on_track_png", !1]);
					return a
				};
				b.__11_i = function() {
					var a = new egret.gui.UIAsset;
					this.__11 = a;
					this.__s(a, ["right", "source", "verticalCenter", "visible"], [1, "onoffbutton_on_thumb_png", 0, !1]);
					return a
				};
				b.__12_i = function() {
					var a = new egret.gui.UIAsset;
					this.__12 = a;
					this.__s(a, ["left", "source", "verticalCenter", "visible"], [15, "onoffbutton_on_label_png", 0, !1]);
					return a
				};
				b.__7_i = function() {
					var a = new egret.gui.UIAsset;
					this.__7 = a;
					this.__s(a, ["source", "visible"], ["onoffbutton_off_track_png", !1]);
					return a
				};
				b.__8_i = function() {
					var a = new egret.gui.UIAsset;
					this.__8 = a;
					this.__s(a, ["left", "source", "verticalCenter", "visible"], [1, "onoffbutton_off_thumb_png", 0, !1]);
					return a
				};
				b.__9_i = function() {
					var a = new egret.gui.UIAsset;
					this.__9 = a;
					this.__s(a, ["right", "source", "verticalCenter", "visible"], [15, "onoffbutton_off_label_png", 0, !1]);
					return a
				};
				return c
			}(egret.gui.Skin);
		d.ToggleSwitchSkin = g;
		g.prototype.__class__ = "skins.simple.ToggleSwitchSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.elementsContent = [this.__4_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.__4_i = function() {
					var a = new egret.gui.Scroller;
					this.__s(a, ["percentHeight", "percentWidth"], [100, 100]);
					a.viewport = this.dataGroup_i();
					return a
				};
				b.dataGroup_i = function() {
					var a = new egret.gui.DataGroup;
					this.dataGroup = a;
					a.itemRendererSkinName = d.simple.TreeItemRendererSkin;
					a.layout = this.__3_i();
					return a
				};
				b.__3_i = function() {
					var a = new egret.gui.VerticalLayout;
					this.__s(a, ["gap", "horizontalAlign"], [2, "justify"]);
					return a
				};
				c._skinParts = ["dataGroup"];
				return c
			}(egret.gui.Skin);
		f.TreeSkin = g;
		g.prototype.__class__ = "skins.simple.TreeSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
(function(d) {
	(function(f) {
		var g = function(e) {
				function c() {
					e.call(this);
					this.__s = egret.gui.setProperties;
					this.__s(this, ["minHeight", "minWidth"], [13, 13]);
					this.elementsContent = [this.track_i(), this.trackHighlight_i(), this.thumb_i()];
					this.states = [new egret.gui.State("normal", []), new egret.gui.State("disabled", [])]
				}
				__extends(c, e);
				var b = c.prototype;
				Object.defineProperty(b, "skinParts", {
					get: function() {
						return c._skinParts
					},
					enumerable: !0,
					configurable: !0
				});
				b.thumb_i = function() {
					var a = new egret.gui.Button;
					this.thumb = a;
					this.__s(a, ["height", "horizontalCenter", "skinName", "width"], [24, 0, d.simple.VSliderThumbSkin, 24]);
					return a
				};
				b.trackHighlight_i = function() {
					var a = new egret.gui.UIAsset;
					this.trackHighlight = a;
					this.__s(a, ["horizontalCenter", "source", "width"], [0, "vslider_fill_png", 10]);
					return a
				};
				b.track_i = function() {
					var a = new egret.gui.UIAsset;
					this.track = a;
					this.__s(a, ["percentHeight", "horizontalCenter", "source", "width"], [100, 0, "vslider_track_png", 10]);
					return a
				};
				c._skinParts = ["track", "trackHighlight", "thumb"];
				return c
			}(egret.gui.Skin);
		f.VSliderSkin = g;
		g.prototype.__class__ = "skins.simple.VSliderSkin"
	})(d.simple || (d.simple = {}))
})(skins || (skins = {}));
var GameUILayer = function(d) {
		function f() {
			d.call(this);
			this.EXP_W1 = 185;
			this.EXP_W2 = 320;
			this.EXP_W3 = 420;
			this.EXP_W4 = 444;
			this.skinName = skins.scene.GameSceneSkin
		}
		__extends(f, d);
		var g = f.prototype;
		g.initStepTF = function() {
			var d = new egret.gui.BitmapLabel;
			d.font = RES.getRes("score_fnt");
			d.anchorX = 0.5;
			this.stepGroup.addElement(d);
			this.stepTF = d
		};
		g.initScoreTF = function() {
			var d = new egret.gui.BitmapLabel;
			d.font = RES.getRes("score_fnt");
			d.anchorX = 0.5;
			this.scoreGroup.addElement(d);
			this.scoreTF = d
		};
		g.childrenCreated = function() {
			this.touchEnabled = !1;
			this.mainGroup.touchChildren = this.mainGroup.touchEnabled = !1;
			this.scoreStarArr = [];
			for (var d = 0; 6 > d; d++) this.scoreStarArr.push(this["scoreStar_" + d]);
			this.leafsArr = [];
			for (var c = LevelManager.instance.currLevelVo.leaf, d = 0; 8 > d; d++) {
				var b = this["leaf_" + d];
				d < c ? (this.leafsArr.push(b), b.visible = !0) : b.visible = !1
			}
			this.initStepTF();
			this.initScoreTF();
			this.scoreShow();
			this.showStep();
			this.showEndLine(!1);
			this.onItemChange();
			this.relayoutGroup.touchEnabled = this.relayoutGroup.touchChildren = !1;
			this.bombGroup.touchEnabled = this.bombGroup.touchChildren = !1;
			d = new egret.MovieClipDataFactory(RES.getRes("box_anim_json"), RES.getRes("box_anim_png"));
			this.boxMc = new egret.MovieClip(d.generateMovieClipData());
			this.box.source = this.boxMc;
			this.boxShow();
			this.goShopBombBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGoShopBtnClick, this);
			this.goShopLayoutBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGoShopBtnClick, this);
			this.relayoutBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.exchangeBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.bombBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.pauseBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			this.box.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnClick, this);
			Const.stage.addEventListener(GameEvent.EVENT_TASK_CHANGE, this.boxShow, this);
			Const.stage.addEventListener(GameEvent.EVENT_ITEM_CHANGE, this.onItemChange, this);
			this.addEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this)
		};
		g.onGoShopBtnClick = function() {
			egret.gui.PopUpManager.addPopUp(ShopLayer.instance, !0, !1)
		};
		g.playGetLeafMoveAnim = function(d, c, b) {
			var a = this;
			if (!(b >= this.leafsArr.length)) {
				var f = this.leafsArr[b],
					g = new egret.Point(d, c),
					f = new egret.Point(f.x + this.leafGroup.x + f.width / 2, f.y + this.leafGroup.y + f.height / 2),
					D = new egret.gui.UIAsset(RES.getRes("leaf_get_png"));
				D.anchorX = D.anchorY = 0.5;
				D.x = d;
				D.y = c;
				Const.gui.addElement(D);
				egret.Tween.get(D).to({
					x: f.x,
					y: f.y
				}, 2 * egret.Point.distance(g, f)).call(function() {
					a.playGetLeafGlowAnim(b);
					Const.gui.removeElement(D)
				})
			}
		};
		g.playGetLeafGlowAnim = function(d) {
			var c = this,
				b = new egret.gui.UIAsset(RES.getRes("leaf_glow_png"));
			b.anchorX = b.anchorY = 0.5;
			var a = this.leafsArr[d];
			b.x = a.x - 6 + a.width / 2;
			b.y = a.y - 6 + a.height / 2;
			this.leafGroup.addElement(b);
			egret.Tween.get(b).to({
				scaleX: 2,
				scaleY: 2,
				alpha: 0
			}, 400).call(function() {
				a.source = RES.getRes("leaf_get_png");
				c.leafGroup.removeElement(b)
			})
		};
		g.showExtTip = function(d) {
			var c = this,
				b = new egret.gui.UIAsset(RES.getRes("zan_bg_png"));
			b.anchorX = b.anchorY = 0.5;
			b.x = Const.WIN_W / 2;
			b.y = Const.WIN_H / 2 + 80;
			b.touchEnabled = !1;
			this.mainGroup.addElement(b);
			AudioManager.instance.playEffect("perfect_" + d + "_mp3");
			var a = new egret.gui.UIAsset(RES.getRes("zan_txt_" + d + "_png"));
			a.touchEnabled = !1;
			a.anchorX = a.anchorY = 0.5;
			a.x = Const.WIN_W / 2 + 25;
			a.y = Const.WIN_H / 2 + 80;
			this.mainGroup.addElement(a);
			b.scaleX = b.scaleY = a.scaleX = a.scaleY = 1.75;
			egret.Tween.get(b).to({
				scaleX: 1,
				scaleY: 1,
				y: b.y - 80
			}, 200, egret.Ease.backOut);
			egret.Tween.get(a).to({
				scaleX: 1,
				scaleY: 1,
				y: a.y - 80
			}, 250, egret.Ease.backOut).wait(1E3).call(function() {
				c.mainGroup.removeElement(b);
				c.mainGroup.removeElement(a)
			})
		};
		g.showAddScore = function(d) {
			var c = this,
				b = new egret.gui.BitmapLabel;
			b.font = RES.getRes("small_score_fnt");
			b.anchorX = b.anchorY = 0.5;
			b.x = Const.WIN_W / 2;
			b.y = Const.WIN_H / 2 - 75;
			b.text = "+" + d;
			this.mainGroup.addElement(b);
			b.alpha = 0;
			egret.Tween.get(b).to({
				alpha: 1
			}, 100).wait(300).to({
				x: 352,
				y: 70,
				alpha: 0
			}, 300).call(function() {
				c.mainGroup.removeElement(b);
				c.scoreShow()
			})
		};
		g.showCritical = function(d) {
			var c = this;
			this.showAddScore(d);
			var b = new egret.gui.UIAsset(RES.getRes("critical_png"));
			b.anchorX = b.anchorY = 0.5;
			b.x = Const.WIN_W / 2 - 50;
			b.y = Const.WIN_H / 2 - 150;
			this.mainGroup.addElement(b);
			b.scaleX = b.scaleY = 1.3;
			b.alpha = 0.5;
			egret.Tween.get(b).to({
				x: b.x + 50,
				y: b.y - 20,
				alpha: 1
			}, 100, egret.Ease.backOut).wait(350).to({
				alpha: 0
			}, 100).call(function() {
				c.mainGroup.removeElement(b)
			})
		};
		g.showHit = function(d, c) {
			var b = this;
			this.showAddScore(c);
			var a = new egret.gui.BitmapLabel;
			a.font = RES.getRes("hit_num_fnt");
			a.anchorX = a.anchorY = 0.5;
			a.x = Const.WIN_W / 2 - 50;
			a.y = Const.WIN_H / 2 - 150;
			a.text = d + " h";
			this.mainGroup.addElement(a);
			a.scaleX = a.scaleY = 1.3;
			a.alpha = 0.5;
			egret.Tween.get(a).to({
				scaleX: 1,
				scaleY: 1,
				x: a.x + 50,
				y: a.y - 20,
				alpha: 1
			}, 200, egret.Ease.backOut).wait(550).to({
				alpha: 0
			}, 100).call(function() {
				b.mainGroup.removeElement(a)
			})
		};
		g.showStepAddScore = function() {
			0 < LevelManager.instance.step && (LevelManager.instance.step--, this.showStep(), this.makeStepScoreTF(), 0 < LevelManager.instance.step && egret.setTimeout(this.showStepAddScore, this, 100))
		};
		g.makeStepScoreTF = function() {
			var d = this,
				c = new egret.gui.BitmapLabel;
			c.font = RES.getRes("small_score_fnt");
			c.text = "+100";
			c.anchorX = c.anchorY = 0.5;
			c.x = 70;
			c.y = 913;
			this.mainGroup.addElement(c);
			egret.Tween.get(c).to({
				x: 352,
				y: 70
			}, 100).call(function() {
				d.mainGroup.removeElement(c);
				LevelManager.instance.score += 100;
				GameManager.instance.score += 100;
				AudioManager.instance.playEffect("step2score_mp3");
				d.scoreShow()
			})
		};
		g.onRemoved = function(d) {
			this.removeEventListener(egret.Event.REMOVED_FROM_STAGE, this.onRemoved, this);
			Const.stage.removeEventListener(GameEvent.EVENT_ITEM_CHANGE, this.onItemChange, this);
			Const.stage.removeEventListener(GameEvent.EVENT_TASK_CHANGE, this.boxShow, this)
		};
		g.onItemChange = function() {
			var d = GoodsManager.instance.getGoodsCount(3),
				d = Util.limit(d, 0, 999);
			this.relayoutNumTF.text = d.toString();
			this.relayoutGroup.visible = 0 < d;
			d = GoodsManager.instance.getGoodsCount(2);
			d = Util.limit(d, 0, 999);
			this.bombNumTF.text = d.toString();
			this.bombGroup.visible = 0 < d
		};
		g.boxShow = function() {
			TaskManager.instance.getHasTaskCanGet() ? (this.boxMc.play(-1), this.taskTip.visible = !0) : (this.boxMc.gotoAndStop(1), this.taskTip.visible = !1)
		};
		g.scoreShow = function() {
			this.scoreTF.text = LevelManager.instance.score.toString();
			var d = LevelManager.instance.currLevelVo,
				c = LevelManager.instance.score,
				b = 0,
				b = c >= d.star3 ? 3 : c >= d.star2 ? 2 : c >= d.star1 ? 1 : 0,
				a = 0,
				a = 0;
			2 == b ? (a = (c - d.star2) / (d.star3 - d.star2), a = (this.EXP_W3 - this.EXP_W2) * a + this.EXP_W2, b = 3) : 1 == b ? (a = (c - d.star1) / (d.star2 - d.star1), a = (this.EXP_W2 - this.EXP_W1) * a + this.EXP_W1, b = 1) : 0 == b ? (a = c / d.star1, a *= this.EXP_W1, b = 0) : (a = this.EXP_W4, b = 6);
			this.expPro.mask = new egret.Rectangle(0, 0, a, this.expPro.height);
			for (d = 0; 6 > d; d++) this.scoreStarArr[d].source = d >= b ? RES.getRes("star_gray_png") : RES.getRes("star_png")
		};
		g.showStep = function() {
			this.stepTF && (this.stepTF.text = LevelManager.instance.step.toString())
		};
		g.showEndLine = function(d) {
			egret.Tween.removeTweens(this.endLine);
			d ? (this.endLine.visible = !0, egret.Tween.get(this.endLine, {
				loop: !0
			}).to({
				alpha: 0.5
			}, 300).to({
				alpha: 1
			}, 300)) : this.endLine.visible = !1
		};
		g.onBtnClick = function(d) {
			if (3 == GameManager.instance.state || 4 == GameManager.instance.state) if (d = d.currentTarget, d == this.relayoutBtn) 3 == GameManager.instance.state && (0 < GoodsManager.instance.getGoodsCount(3) ? (Const.stage.dispatchEventWith(GameEvent.EVENT_USE_RELAYOUT), GoodsManager.instance.subGoodsCount(3)) : egret.gui.PopUpManager.addPopUp(ShopLayer.instance, !0, !1));
			else if (d == this.bombBtn) {
				if (3 == GameManager.instance.state || 4 == GameManager.instance.state) 0 < GoodsManager.instance.getGoodsCount(2) ? Const.gameScene.hasBombNotUsed() || (Const.stage.dispatchEventWith(GameEvent.EVENT_USE_BOMB), GoodsManager.instance.subGoodsCount(2)) : egret.gui.PopUpManager.addPopUp(ShopLayer.instance, !0, !1)
			} else d == this.pauseBtn ? 3 != GameManager.instance.state && 4 != GameManager.instance.state || egret.gui.PopUpManager.addPopUp(new PauseLayer, !0, !1) : d == this.box ? 3 != GameManager.instance.state && 4 != GameManager.instance.state || egret.gui.PopUpManager.addPopUp(new TaskLayer, !0, !1) : d == this.exchangeBtn && Const.stage.dispatchEventWith(GameEvent.EVENT_EXCHANGE_BUBBLE)
		};
		return f
	}(egret.gui.SkinnableComponent);
GameUILayer.prototype.__class__ = "GameUILayer";
var md5 = function() {
		function d() {
			this.hexcase = 0;
			this.b64pad = ""
		}
		var f = d.prototype;
		f.hex_md5 = function(d) {
			return this.rstr2hex(this.rstr_md5(this.str2rstr_utf8(d)))
		};
		f.b64_md5 = function(d) {
			return this.rstr2b64(this.rstr_md5(this.str2rstr_utf8(d)))
		};
		f.any_md5 = function(d, e) {
			return this.rstr2any(this.rstr_md5(this.str2rstr_utf8(d)), e)
		};
		f.hex_hmac_md5 = function(d, e) {
			return this.rstr2hex(this.rstr_hmac_md5(this.str2rstr_utf8(d), this.str2rstr_utf8(e)))
		};
		f.b64_hmac_md5 = function(d, e) {
			return this.rstr2b64(this.rstr_hmac_md5(this.str2rstr_utf8(d), this.str2rstr_utf8(e)))
		};
		f.any_hmac_md5 = function(d, e, c) {
			return this.rstr2any(this.rstr_hmac_md5(this.str2rstr_utf8(d), this.str2rstr_utf8(e)), c)
		};
		f.md5_vm_test = function() {
			return "900150983cd24fb0d6963f7d28e17f72" == this.hex_md5("abc").toLowerCase()
		};
		f.rstr_md5 = function(d) {
			return this.binl2rstr(this.binl_md5(this.rstr2binl(d), 8 * d.length))
		};
		f.rstr_hmac_md5 = function(d, e) {
			var c = this.rstr2binl(d);
			16 < c.length && (c = this.binl_md5(c, 8 * d.length));
			for (var b = Array(16), a = Array(16), f = 0; 16 > f; f++) b[f] = c[f] ^ 909522486, a[f] = c[f] ^ 1549556828;
			c = this.binl_md5(b.concat(this.rstr2binl(e)), 512 + 8 * e.length);
			return this.binl2rstr(this.binl_md5(a.concat(c), 640))
		};
		f.rstr2hex = function(d) {
			try {
				this.hexcase
			} catch (e) {
				this.hexcase = 0
			}
			for (var c = this.hexcase ? "0123456789ABCDEF" : "0123456789abcdef", b = "", a, f = 0; f < d.length; f++) a = d.charCodeAt(f), b += c.charAt(a >>> 4 & 15) + c.charAt(a & 15);
			return b
		};
		f.rstr2b64 = function(d) {
			try {
				this.b64pad
			} catch (e) {
				this.b64pad = ""
			}
			for (var c = "", b = d.length, a = 0; a < b; a += 3) for (var f = d.charCodeAt(a) << 16 | (a + 1 < b ? d.charCodeAt(a + 1) << 8 : 0) | (a + 2 < b ? d.charCodeAt(a + 2) : 0), u = 0; 4 > u; u++) c = 8 * a + 6 * u > 8 * d.length ? c + this.b64pad : c + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(f >>> 6 * (3 - u) & 63);
			return c
		};
		f.rstr2any = function(d, e) {
			var c = e.length,
				b, a, f, u, D, s = Array(Math.ceil(d.length / 2));
			for (b = 0; b < s.length; b++) s[b] = d.charCodeAt(2 * b) << 8 | d.charCodeAt(2 * b + 1);
			var r = Math.ceil(8 * d.length / (Math.log(e.length) / Math.log(2))),
				k = Array(r);
			for (a = 0; a < r; a++) {
				D = [];
				for (b = u = 0; b < s.length; b++) if (u = (u << 16) + s[b], f = Math.floor(u / c), u -= f * c, 0 < D.length || 0 < f) D[D.length] = f;
				k[a] = u;
				s = D
			}
			c = "";
			for (b = k.length - 1; 0 <= b; b--) c += e.charAt(k[b]);
			return c
		};
		f.str2rstr_utf8 = function(d) {
			for (var e = "", c = -1, b, a; ++c < d.length;) b = d.charCodeAt(c), a = c + 1 < d.length ? d.charCodeAt(c + 1) : 0, 55296 <= b && 56319 >= b && 56320 <= a && 57343 >= a && (b = 65536 + ((b & 1023) << 10) + (a & 1023), c++), 127 >= b ? e += String.fromCharCode(b) : 2047 >= b ? e += String.fromCharCode(192 | b >>> 6 & 31, 128 | b & 63) : 65535 >= b ? e += String.fromCharCode(224 | b >>> 12 & 15, 128 | b >>> 6 & 63, 128 | b & 63) : 2097151 >= b && (e += String.fromCharCode(240 | b >>> 18 & 7, 128 | b >>> 12 & 63, 128 | b >>> 6 & 63, 128 | b & 63));
			return e
		};
		f.str2rstr_utf16le = function(d) {
			for (var e = "", c = 0; c < d.length; c++) e += String.fromCharCode(d.charCodeAt(c) & 255, d.charCodeAt(c) >>> 8 & 255);
			return e
		};
		f.str2rstr_utf16be = function(d) {
			for (var e = "", c = 0; c < d.length; c++) e += String.fromCharCode(d.charCodeAt(c) >>> 8 & 255, d.charCodeAt(c) & 255);
			return e
		};
		f.rstr2binl = function(d) {
			for (var e = Array(d.length >> 2), c = 0; c < e.length; c++) e[c] = 0;
			for (c = 0; c < 8 * d.length; c += 8) e[c >> 5] |= (d.charCodeAt(c / 8) & 255) << c % 32;
			return e
		};
		f.binl2rstr = function(d) {
			for (var e = "", c = 0; c < 32 * d.length; c += 8) e += String.fromCharCode(d[c >> 5] >>> c % 32 & 255);
			return e
		};
		f.binl_md5 = function(d, e) {
			d[e >> 5] |= 128 << e % 32;
			d[(e + 64 >>> 9 << 4) + 14] = e;
			for (var c = 1732584193, b = -271733879, a = -1732584194, f = 271733878, u = 0; u < d.length; u += 16) var D = c,
				s = b,
				r = a,
				k = f,
				c = this.md5_ff(c, b, a, f, d[u + 0], 7, -680876936),
				f = this.md5_ff(f, c, b, a, d[u + 1], 12, -389564586),
				a = this.md5_ff(a, f, c, b, d[u + 2], 17, 606105819),
				b = this.md5_ff(b, a, f, c, d[u + 3], 22, -1044525330),
				c = this.md5_ff(c, b, a, f, d[u + 4], 7, -176418897),
				f = this.md5_ff(f, c, b, a, d[u + 5], 12, 1200080426),
				a = this.md5_ff(a, f, c, b, d[u + 6], 17, -1473231341),
				b = this.md5_ff(b, a, f, c, d[u + 7], 22, -45705983),
				c = this.md5_ff(c, b, a, f, d[u + 8], 7, 1770035416),
				f = this.md5_ff(f, c, b, a, d[u + 9], 12, -1958414417),
				a = this.md5_ff(a, f, c, b, d[u + 10], 17, -42063),
				b = this.md5_ff(b, a, f, c, d[u + 11], 22, -1990404162),
				c = this.md5_ff(c, b, a, f, d[u + 12], 7, 1804603682),
				f = this.md5_ff(f, c, b, a, d[u + 13], 12, -40341101),
				a = this.md5_ff(a, f, c, b, d[u + 14], 17, -1502002290),
				b = this.md5_ff(b, a, f, c, d[u + 15], 22, 1236535329),
				c = this.md5_gg(c, b, a, f, d[u + 1], 5, -165796510),
				f = this.md5_gg(f, c, b, a, d[u + 6], 9, -1069501632),
				a = this.md5_gg(a, f, c, b, d[u + 11], 14, 643717713),
				b = this.md5_gg(b, a, f, c, d[u + 0], 20, -373897302),
				c = this.md5_gg(c, b, a, f, d[u + 5], 5, -701558691),
				f = this.md5_gg(f, c, b, a, d[u + 10], 9, 38016083),
				a = this.md5_gg(a, f, c, b, d[u + 15], 14, -660478335),
				b = this.md5_gg(b, a, f, c, d[u + 4], 20, -405537848),
				c = this.md5_gg(c, b, a, f, d[u + 9], 5, 568446438),
				f = this.md5_gg(f, c, b, a, d[u + 14], 9, -1019803690),
				a = this.md5_gg(a, f, c, b, d[u + 3], 14, -187363961),
				b = this.md5_gg(b, a, f, c, d[u + 8], 20, 1163531501),
				c = this.md5_gg(c, b, a, f, d[u + 13], 5, -1444681467),
				f = this.md5_gg(f, c, b, a, d[u + 2], 9, -51403784),
				a = this.md5_gg(a, f, c, b, d[u + 7], 14, 1735328473),
				b = this.md5_gg(b, a, f, c, d[u + 12], 20, -1926607734),
				c = this.md5_hh(c, b, a, f, d[u + 5], 4, -378558),
				f = this.md5_hh(f, c, b, a, d[u + 8], 11, -2022574463),
				a = this.md5_hh(a, f, c, b, d[u + 11], 16, 1839030562),
				b = this.md5_hh(b, a, f, c, d[u + 14], 23, -35309556),
				c = this.md5_hh(c, b, a, f, d[u + 1], 4, -1530992060),
				f = this.md5_hh(f, c, b, a, d[u + 4], 11, 1272893353),
				a = this.md5_hh(a, f, c, b, d[u + 7], 16, -155497632),
				b = this.md5_hh(b, a, f, c, d[u + 10], 23, -1094730640),
				c = this.md5_hh(c, b, a, f, d[u + 13], 4, 681279174),
				f = this.md5_hh(f, c, b, a, d[u + 0], 11, -358537222),
				a = this.md5_hh(a, f, c, b, d[u + 3], 16, -722521979),
				b = this.md5_hh(b, a, f, c, d[u + 6], 23, 76029189),
				c = this.md5_hh(c, b, a, f, d[u + 9], 4, -640364487),
				f = this.md5_hh(f, c, b, a, d[u + 12], 11, -421815835),
				a = this.md5_hh(a, f, c, b, d[u + 15], 16, 530742520),
				b = this.md5_hh(b, a, f, c, d[u + 2], 23, -995338651),
				c = this.md5_ii(c, b, a, f, d[u + 0], 6, -198630844),
				f = this.md5_ii(f, c, b, a, d[u + 7], 10, 1126891415),
				a = this.md5_ii(a, f, c, b, d[u + 14], 15, -1416354905),
				b = this.md5_ii(b, a, f, c, d[u + 5], 21, -57434055),
				c = this.md5_ii(c, b, a, f, d[u + 12], 6, 1700485571),
				f = this.md5_ii(f, c, b, a, d[u + 3], 10, -1894986606),
				a = this.md5_ii(a, f, c, b, d[u + 10], 15, -1051523),
				b = this.md5_ii(b, a, f, c, d[u + 1], 21, -2054922799),
				c = this.md5_ii(c, b, a, f, d[u + 8], 6, 1873313359),
				f = this.md5_ii(f, c, b, a, d[u + 15], 10, -30611744),
				a = this.md5_ii(a, f, c, b, d[u + 6], 15, -1560198380),
				b = this.md5_ii(b, a, f, c, d[u + 13], 21, 1309151649),
				c = this.md5_ii(c, b, a, f, d[u + 4], 6, -145523070),
				f = this.md5_ii(f, c, b, a, d[u + 11], 10, -1120210379),
				a = this.md5_ii(a, f, c, b, d[u + 2], 15, 718787259),
				b = this.md5_ii(b, a, f, c, d[u + 9], 21, -343485551),
				c = this.safe_add(c, D),
				b = this.safe_add(b, s),
				a = this.safe_add(a, r),
				f = this.safe_add(f, k);
			return [c, b, a, f]
		};
		f.md5_cmn = function(d, e, c, b, a, f) {
			return this.safe_add(this.bit_rol(this.safe_add(this.safe_add(e, d), this.safe_add(b, f)), a), c)
		};
		f.md5_ff = function(d, e, c, b, a, f, u) {
			return this.md5_cmn(e & c | ~e & b, d, e, a, f, u)
		};
		f.md5_gg = function(d, e, c, b, a, f, u) {
			return this.md5_cmn(e & b | c & ~b, d, e, a, f, u)
		};
		f.md5_hh = function(d, e, c, b, a, f, u) {
			return this.md5_cmn(e ^ c ^ b, d, e, a, f, u)
		};
		f.md5_ii = function(d, e, c, b, a, f, u) {
			return this.md5_cmn(c ^ (e | ~b), d, e, a, f, u)
		};
		f.safe_add = function(d, e) {
			var c = (d & 65535) + (e & 65535);
			return (d >> 16) + (e >> 16) + (c >> 16) << 16 | c & 65535
		};
		f.bit_rol = function(d, e) {
			return d << e | d >>> 32 - e
		};
		return d
	}();
md5.prototype.__class__ = "md5";