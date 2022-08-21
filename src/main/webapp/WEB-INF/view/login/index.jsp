<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link href="/resources/css/common.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

</head>
<body>
<div class="signin-body">
<!-- logo -->
  <div class="brand"><a href=""></a></div>
  
  <form action="/login/do" class="form-signin panel" role="form" method=post onSubmit="return chkFrm(this);" >
    <h2 class="form-signin-heading">관리자 로그인</h2>
    <input type="text" name="email" class="form-control" placeholder="아이디" required autofocus>
    <input type="password" name="passwd" class="form-control" placeholder="패스워드" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>

  </form>

</div>
</body>
</html>


