<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script>
var img_name = new Array();
$(function(){
    CKEDITOR.replace( 'bbs_review',
    {
        height:"400", width:"100%",
        filebrowserUploadUrl : '/board/image_upload',
        extraPlugins: 'image2'
    });
});
function _onSubmit(){
    if(!$("#title").val()){
        alert('제목을 입력해주세요');
        return false;
    }
    document.frm.submit();
}
function goList(){
    document.location.href="<?=$lurl?>";
}
</script>

<div class="col-lg-10 col-md-10 col-sm-9" id="contents-box">

<!-- 페이지 헤드라인 -->
<div class="page-header">
<h1>편집국 <small>편집국 전용 게시판 입니다.</small></h1>
</div>

<form name=frm method=post action="/board/update/${item.id}" >
      <div class="panel panel-default">
        <div class="panel-heading">뉴스룸</div>
        <div class="panel-body">
        <div class="form-horizontal">
        <div class="form-group">
              <label for="" class="col-md-2 col-sm-2 col-xs-2 control-label">제목</label>
              <div class="col-md-8 col-sm-10 col-xs-10">
                <input type="text" id="title" name='titles' value="${item.titles}" class="form-control" placeholder="제목을 입력해 주세요">
              </div>
            </div>
            <div class="form-group">
              <label for="" class="col-md-2 col-sm-2 col-xs-2 control-label">공지</label>
              <label class="checkbox-inline col-lg-1 col-md-2 col-sm-2">
                <input type="checkbox" name="chk_notice" id="chk_notice" value="1" class="checkbox">
                공지로 사용 </label>

            </div>
          <!-- editor -->
            <div class="form-group editor">
              <div class="col-md-10 col-sm-12 col-xs-12"><textarea class="ckeditor" name="contents">${item.contents}</textarea></div>
            </div>
            <!-- .editor -->
          </div>
        </div>
      </div>


    <hr>

<!-- btns -->
      <div>
        <button type="button" onclick="_onSubmit()" class="btn btn-primary">저장</button>
        <button type="button"  onclick="goList()" class="btn btn-default">취소</button>
      </div>
      <!-- .btns -->
</form>
    </div>
