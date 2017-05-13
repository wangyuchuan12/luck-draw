<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:if test="${modeView=='large'}">
	<link rel="stylesheet" href="/css/largePlug.css"/>
</c:if>

<c:if test="${modeView=='small'}">
	<link rel="stylesheet" href="/css/plug.css"/>
</c:if>

<c:if test="${modeView==null}">
	<link rel="stylesheet" href="/css/plug.css"/>
</c:if>

<link rel="stylesheet" href="/css/style1.0.css"/>

<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>







