<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="personalAttr" id="personalAttr" style="display: none;">
				<!--  
				<div class="personalAttrUserInfo">
					<div class="personalAttrUserInfoImg">
						<img src="/imgs/sadAlert.jpg">
						<div class="personalAttrUserInfoName" style="display: block;">
							<span>川川</span>
							<span> lv.7</span>
						</div>
					</div>
				</div>
				-->
				
				<div class="personalAttrData" id="personalAttrData">
					<ul>
						<li id="personalAttrDataLove">
							
							<div class="personalAttrDataHeader personalAttrDataHeaderLove" style="z-index:1000;position: absolute;top:-1px;"></div>
							
							<div id="progressbarLove" style="width:100%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="border-radius:20px;color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus" style="left:79%;top:0px;position: absolute;"></div>
							
						</li>

						<li id="personalAttrDataBean">
							<div class="personalAttrDataHeader personalAttrDataHeaderBean" style="z-index:1000;position: absolute;left:-2px;"></div>
							
							<div id="progressbarBean" style="width:100%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus" style="left:79%;top:0px;position: absolute;"></div>
							
						</li>
						
						<li id="personalAttrDataMasonry" style="margin-top: 5px;">
							<div class="personalAttrDataHeader personalAttrDataHeaderMasonry" style="z-index:1000;position: absolute;"></div>
							
							<div id="progressbarMasonry" style="width:100%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1);">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus" style="left:79%;top:0px;position: absolute;"></div>
							
						</li>
						
						<li id="personalAttrDataMoney" style="margin-top: 5px;">
							<div class="personalAttrDataHeader personalAttrDataHeaderMoney" style="z-index:1000;position: absolute;top:-3px;left:-2px;"></div>
							
							<div id="progressbarMoney" style="width:100%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="mainViewDekornButton4" style="position: absolute;left:80%;top:0px;">提现</div>
							
						</li>
						
					</ul>
		</div>
			
</div>


<div id="lifeLoveSolidAnnim" style="width:100px;height:100px;display: none;z-index:10;">
	<img src="http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png"/>
</div>

<div id="beanAnnim" style="width:100px;height:100px;display: none;z-index: 10;">
	<img src="/imgs/plug/bean.png"/>
</div>

<div id="coinAnnim" style="width:100px;height:100px;display: none;z-index:10;">
	<img src="http://on3s1z2us.bkt.clouddn.com/coin.png"/>
</div>


<style type="text/css">
    	.progress-label2{
    		position: absolute;
    		text-align:center;
    		width:100%;
    		font-weight: bold;
    		color:RGBA(77,209,255,1);
    		font-size: 10px;
    		padding-top: 1px;
    		padding-bottom: 1px;
    	}
    	
    	#progressbarLove .ui-corner-left{
    		background: RGBA(225,0,34,1);
    		height: 20px;
    		border-radius:20px;
    		position: relative;
    		top:-1px;
    	}
    	
    	#progressbarBean .ui-corner-left{
    		background: RGBA(245,192,0,1);
    		height: 20px;
    		border-radius:20px;
    		position: relative;
    		top:-1px;
    	}
    	
    	#progressbarMasonry .ui-corner-left{
    		background: RGBA(127,122,139,1);
    		height: 20px;
    		border-radius:20px;
    		position: relative;
    		top:-1px;
    		
    	}
    	
    	#progressbarMoney .ui-corner-left{
    		background: RGBA(168,134,51,1);
    		height: 20px;
    		border-radius:20px;
    		position: relative;
    		top:-1px;
    	}
</style>