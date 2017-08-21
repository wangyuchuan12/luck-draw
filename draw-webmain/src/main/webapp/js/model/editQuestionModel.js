function EditQuestionModel(){
	var outThis = this;
	var questionInputItem;
	var rightOptionInputItem;
	var wrongOption1InputItem;
	var wrongOption2InputItem;
	var wrongOption3InputItem;
	var blankItem;
	var tabPanel;
	var inputItemFillTerms;
	function init(){
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
		
		inputItemFillTerms = new InputItemFillTerms("#inputItemFillTerms");
	}
	
	this.getType = function(){
		var type = tabPanel.getType();
		return type;
	}
	
	this.getRightOption = function(){
		var rightOption = rightOptionInputItem.getValue();
		return rightOption;
	}
	
	this.getWrongOption1 = function(){
		var wrongOption1 = wrongOption1InputItem.getValue();
		return wrongOption1;
	}
	
	this.getWrongOption2 = function(){
	
		var wrongOption2 = wrongOption2InputItem.getValue();
		return wrongOption2;
	}
	
	this.getWrongOption3 = function(){
		var wrongOption3 = wrongOption3InputItem.getValue();
		return wrongOption3;
	}
	
	this.getQuestion = function(){
		var question = questionInputItem.getValue();
		
		return question;
	}
	
	this.getFills = function(){
		var fillWords = inputItemFillTerms.getFills();
		return fillWords;
	}
	
	this.getAnswer = function(){
		var type = outThis.getType;
		if(type==0){
			
		}else if(type==1){
			var answer = blankItem.getValue();
		}else if(type==2){
			
			var answer = inputItemFillTerms.getAnswer();
			return answer;
		}
		
	}
	
	this.load = function(selector,callback){
		var url = "/view/manager/editQuestionModel";
		$.get(url,function(r){
			
			$(selector).css("display","block");
			$(selector).append(r);
			init();
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
	
	
}