<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(function(){

    $("#delete").click(function(){
        document.location.href="/board/delete/${item.id}";
    });
    $("#edit").click(function(){
            document.location.href="/board/edit/${item.id}";
        });
});
</script>
<div class="col-lg-10 col-md-10 col-sm-9" id="contents-box">

<!-- 페이지 헤드라인 -->
<div class="page-header">
<h1>게시판 입니다.</small></h1>
</div>
      <div class="panel panel-default">
        <div class="panel-heading">${item.titles}</div>
        <div class="panel-body">

        <!-- 글보기 -->
        <!-- 제목 -->
        <blockquote>
            <h3 class="lead text-primary"></h3>
        </blockquote>

            ${item.contents}


        <!--댓글-->

        <!--댓글-->

        </div>
      </div>
    <hr>
<!-- btns -->
      <div>
      <button type="button" onClick="document.location.href='/board/list'"  class="btn btn-reverse">목록</button>
<c:if test="${item.user_idx eq user_idx and not empty user_idx }">
        <button type="button"  id="edit" class="btn btn-primary">수정</button>
        <button type="button"  id="delete" class="btn btn-default">삭제</button>
</c:if>
      </div>
      <!-- .btns -->

    </div>
