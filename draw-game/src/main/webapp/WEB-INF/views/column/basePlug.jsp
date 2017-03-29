<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<style>
.smartAlert{
	background-color: RGBA(243,219,190,0.7);
	width: 100%;
	height: 100%;
	text-align: center;
	color: RGBA(105,33,6,1);
	display: none;	
}

.smartAlertContext{
	
	top: 30px;
	
	padding-left: 40px;
	
	padding-right: 40px;
	
	padding-top:40px;
	
	font-size: 40px;
	
	font-weight: bolder;
}

.smartAlertButton{
	
	top:110px;
	
	position: absolute;
	
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	
	background: RGBA(226,172,4,1);
	
	color: white;
	
	width:100px;
	
	height: 40px;
	
	font-weight: bolder;
	
	padding-top: 5px;
	
	font-size: 20px;
	
	border-radius:5px;
}
</style>

<div class="smartAlert">
	<div class="smartAlertContext">你没有门票，请参加专题下的任务获取</div>
	
	<div class="smartAlertButton" onclick="alert();">确定</div>
	
	<script type="text/javascript">

	
	function showSmartAlert(){
		layer.open({
			type:1,
			content:$(".smartAlert"),
			title:false,
			skin:"layui-layer-rim",
			area:["70%","400px"]
		});
		$(".smartAlert").click(function(){
			alert("click");
		});
	}
	</script>
</div>