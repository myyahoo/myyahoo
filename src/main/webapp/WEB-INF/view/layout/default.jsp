<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CMS</title>
<link href="/resources/css/common.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
.dropdown-menu {
	min-width: 200px;
}
.dropdown-menu li a {
	padding: 5px 15px;
	font-weight: 300;
}
</style>
<body>
<!-- navbar top -->
<div class="navbar navbar-inverse navbar-static-top" id="common-top">
  <div class="container col-lg-12 col-md-12 col-sm-12">
    <div class="navbar-header col-lg-2 col-md-2 col-sm-3"> <a class="navbar-brand" href="/news/list">XPORTSNEWS CMS</a> </div>


    <p class="navbar-text navbar-right"><?=$USER['user_id']?> (<?=$USER['user_name']?>) <a href="/index/logout">로그아웃</a></p>
  </div>
</div>
<!-- navbar top -->

<div class="container col-xs-12">
  <div class="row">
   <!-- contents panel -->
<tiles:insertAttribute name="left" />
<tiles:insertAttribute name="body" />

    <!-- contents panel -->
  </div>
</div>

<!-- copyright -->
<div class="container col-xs-12" id="copyright">
  <div class="row">
    <p class="navbar-text navbar-left"></p>
  </div>
</div>
<!-- .copyright -->
</body>
</html>
