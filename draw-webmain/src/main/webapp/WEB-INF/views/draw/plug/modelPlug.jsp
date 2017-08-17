<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="models" id="models" style="display: none;">
				<ul>
					<li>
						<canvas style="background: url('http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png');background-size:100% 100%;" id="modelPhy"></canvas>
						<div  style="color: black;position: relative;top:-5px">爱心 </div>
						<!--  <div id="receiveLoveButton" style="background: RGBA(21,185,254,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;">升级</div> -->
						
						<div id="receiveLoveButton" style="background: RGBA(61,212,11,1);width:70px;padding-top:2px;padding-bottom:2px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarLove_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					
					</li>
					
					<li id="beanModel">
						<canvas id="modelPhy2" style="background: url('/imgs/plug/bean.png');background-size:95% 90%;background-position: 5px 0px;"></canvas>
						<div  style="color: black;position: relative;top:-5px">智慧豆</div>
						
						<div id="receiveBeanButton" style="background: RGBA(61,212,11,1);width:70px;padding-top:2px;padding-bottom:2px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarBean_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					</li>
					
					
					<li>
						<canvas id="modelPhy3" style="background: url('http://on3s1z2us.bkt.clouddn.com/strength.png')no-repeat;background-size:95% 85%;"></canvas>
						<div  style="color: black;position: relative;top:-5px">体力</div>
						
						<div style="background: red;width:70px;padding-top:2px;padding-bottom:2px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;" id="phyButton">2200000</div>
					
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarPhy_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						
						-->
					</li>
					
					<li>
						<canvas id="modelPhy4" style="background: url('http://on3s1z2us.bkt.clouddn.com/dice3.png')no-repeat;background-size:100% 80%;background-position:0 5px;"></canvas>
						<div  style="color: black;position: relative;top:-5px;">随机</div>
						
						<div id="receiveCoinButton" style="background: RGBA(61,212,11,1);width:70px;padding-top:2px;padding-bottom:2px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarRandom_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					</li>
					
				</ul>
			</div>