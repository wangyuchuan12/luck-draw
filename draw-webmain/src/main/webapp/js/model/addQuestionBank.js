function AddQuestionBank(editQuestionModel){
	var tabPanel;
	var isImg=0;
	var imgUrl;
	var questionThemeInputSelect;
	var questionInputItem;
	var rightOptionInputItem;
	var wrongOption1InputItem;
	var wrongOption2InputItem;
	var wrongOption3InputItem;
	var blankItem;
	var flowPlug = new FlowPlug({
		
		getParams:function(){
			
			var questionError = questionInputItem.isErrorCheck();
			if(questionError){
				this.fail();
				return;
			}
			
			var theme = questionThemeInputSelect.getValue();
			
			if(!theme){
				questionThemeInputSelect.error();
				this.fail();
				return;
			}
			
			//params.themeCode = "";
			
			var rightOption = editQuestionModel.getRightOption();
			var wrongOption1 = editQuestionModel.getWrongOption1();
			var wrongOption2 = editQuestionModel.getWrongOption2();
			var wrongOption3 = editQuestionModel.getWrongOption3();
			var question = editQuestionModel.getQuestion();
			
			var params = new Object();
			var type = editQuestionModel.getType();
			params.type=type;
			params.isImg = isImg;
			params.question = question;
			if(isImg==1){
				params.imgUrl = imgUrl;
			}
			if(type==0){				
				params.wrongOptions = wrongOption1+","+wrongOption2+","+wrongOption3;
				params.rightOption = rightOption;
			}else if(type==1){
				
				var answer = editQuestionModel.getAnswer();
				params.answer = answer;
			}else if(type==2){
				var answer = editQuestionModel.getAnswer();
				var fillWords = editQuestionModel.getFills();
				
				params.fillWords = fillWords;
				params.answer = answer;
				
			}
			
			this.success(params);
		},
		
		commit:function(){
			this.setNext("getParams",function(data){
				var url = "/api/manager/addQuestionBank";
				var waitPlug = new WaitPlug();
				request(url,{
					success:function(resp){
						waitPlug.close();
						alert(JSON.stringify(resp));
					},
					failure:function(){
						waitPlug.close();
					}
				},data);
			},function(){
				alert("error");
			});
			
			this.next();
		},
		
		begin:function(){
			
			var outThis = this;
			var callback = new Object();
			callback.success = function(data){
				imgUrl = data.url;
				isImg = 1;
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
			
			
			
			questionThemeInputSelect = new InputSelect("#questionTheme",
					"#content",
					{
						select:function(value){},
						openAlert:function(){
							var waitPlug = new WaitPlug();
							request("/api/manager/subjects",{
								success:function(data){
									waitPlug.close();
									var subjects = data.data;
									var array = new Array();
									for(var i = 0;i<subjects.length;i++){
										array.push({
											text:subjects[i].name,
											value:subjects[i].id
										});
									}
									
									questionThemeInputSelect.setData(array);
									
									questionThemeInputSelect.openAlert();
								},
								failure:function(){
									waitPlug.close();
								}
							},{});
						}
					});
			
			questionInputItem = new InputItem("#questionItem",{
				keyup:function(){
					
				}
			});
			
			rightOptionInputItem = new InputItem("#rightOption",{
				keyup:function(){
					
				}
			});
			
			wrongOption1InputItem = new InputItem("#wrongOption1",{
				keyup:function(){
					
				}
			});
			
			wrongOption2InputItem = new InputItem("#wrongOption2",{
				keyup:function(){
					
				}
			});
			
			wrongOption3InputItem = new InputItem("#wrongOption3",{
				keyup:function(){
					
				}
			});
			
			blankItem = new InputItem("#blankItem",{
				keyup:function(){
					
				}
			});
			
			tabPanel = new TabPanel([{
											tab:"#inputTabChoice",
											content:"#inputItemChoice",
											type:0
										},{
											tab:"#inputTabFillBlank",
											content:"#inputItemFillBlank",
											type:1
										},{
											tab:"#inputTabFillTerms",
											content:"#inputItemFillTerms",
											type:2
										}]);
			
			tabPanel.selectTab("#inputTabChoice");
			
			
			
			$("#saveButton").click(function(){
				outThis.setNext("commit");
				
				outThis.next();
				
			});
		}
	});
}