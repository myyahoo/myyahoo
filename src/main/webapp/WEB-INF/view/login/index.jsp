<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link href="/resources/css/common.css" rel="stylesheet">


<script src="/js/jquery.min.js"></script>

<script>
function chkFrm(frm){
    if(!frm.email.value){
        alert('아이디를 입력하세요');
        return false;
    }
    if(!frm.passwd.value){
        alert('비밀번호를  입력하세요');
        return false;
    }
    return true;

}
</script>

<script type="text/javascript">
 

</script>


</head>
<body>
<div class="signin-body">
<!-- logo -->
  <div class="brand"><a href=""></a></div>
  
  <form action="/index/login" class="form-signin panel" role="form" method=post onSubmit="return chkFrm(this);" enctype='multipart/form-data'>
	<input type=hidden name=done value="<?=urlencode('/admin')?>">
    <h2 class="form-signin-heading">관리자 로그인</h2>
    <input type="text" name="user_id" class="form-control" placeholder="아이디" required autofocus>
    <input type="password" name="user_pwd" class="form-control" placeholder="패스워드" required>
    <!-- 기억하기
	<label class="checkbox">
	  <input type="checkbox" value="remember-me"> 기억하기
	</label>
	--> 
    
    <!-- 보안 이미지 추가 -->
    <div class="form-group">
      <label for="exampleInputFile">보안 이미지 추가</label>
      <input name="upfile" type="file" id="exampleInputFile">
      <p class="help-block">보안 이미지를 삽입해 주세요.</p>
    </div>
	
	<!--login button-->
    <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    <!--button  class="btn btn-block btn-social btn-lg  btn-facebook" type="button" onclick="facebooklogin()">페이스북으로 로그인</button-->

	
  </form>
  
  <!-- copyright -->
  <div class="copyright">
    <p></p>
  </div>
  <!-- .copyright --> 
  
</div>
</body>
</html>


