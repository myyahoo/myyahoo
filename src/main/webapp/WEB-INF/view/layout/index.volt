<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CMS</title>
<link href="/css/common.css" rel="stylesheet">
<!--[if IE 8]>
<link href="/css/ie8.css" rel="stylesheet">
<![endif]-->
<!--[if IE 7]>
<link href="/css/ie7.css" rel="stylesheet">
<![endif]-->
<link rel="stylesheet" href="/css/jquery-ui.css">
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/common.js?date=1"></script>
<script src="/js/bootstrap.js"></script>
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
{{ partial("common/left") }}
{{ content() }}
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
