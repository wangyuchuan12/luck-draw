function AddBattleModel(){
	var imgUrl;
	var isImg=0;
	
	var nameInputItem;
	var titleInputItem;
	var codeInputItem;
	var instructionInputItem;
	var flowPlug = new FlowPlug({
		
		getParams:function(){
			var params = new Object();
			
			params.name = nameInputItem.getValue();
			params.title = titleInputItem.getValue();
			params.code = codeInputItem.getValue();
			params.instruction = instructionInputItem.getValue();
			
			this.success(params);
			
		},
		
		commit:function(){
			var url = "/api/manager/addBattleModel";
			this.setNext("getParams",function(params){
				request(url,{
					success:function(resp){
						alert(JSON.stringify(resp));
					},
					failure:function(){
						alert("failure");
					}
				},params);
			},function(){
				
			});
			this.next();
			
		},
	
		begin:function(){
			var outThis = this;
			nameInputItem = new InputItem("#nameInputItem",{
				keyup:function(){
					
				}
			});
			
			titleInputItem = new InputItem("#titleInputItem",{
				keyup:function(){
					
				}
			});
			
			codeInputItem = new InputItem("#codeInputItem",{
				keyup:function(){
					
				}
			});
			
			instructionInputItem = new InputItem("#instructionInputItem",{
				keyup:function(){
					
				}
			});
			
			$("#saveButton").click(function(){
				outThis.setNext("commit");
				outThis.next();
			});
			var callback = new Object();
			callback.success = function(data){
				imgUrl = data.url;
				isImg = 1;
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
		}
	});
}