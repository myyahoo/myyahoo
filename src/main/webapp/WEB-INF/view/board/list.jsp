<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>

$(document).ready(function(){

    $("#btn_search").click(function(){
        $("#search_frm").submit();
    });

    $("#chk_id_all").click(function(){
        if ($(this).is(":checked")){
            $("input[name=chk_id]:checkbox").prop("checked", true);
          }else{
            $("input[name=chk_id]:checkbox").prop("checked", false);
          }
    });
    $("#btn_write").click(function(){
        document.location.href=<c:choose><c:when test="${not empty userIdx}">"/board/write"</c:when><c:when test="${empty userIdx}">"/login"</c:when></c:choose>;
    });

});


</script>

<div class="col-lg-10 col-md-10 col-sm-9" id="contents-box">
<!-- 페이지 헤드라인 -->
<div class="page-header">
<h1>게시판 <small>전체 게시판 입니다.</small></h1>
</div>

      <!--검색-->
    <form id="search_frm" name="search_frm" method=GET action="/bbs_manage/article_list">
     <input type=hidden name=md value="search">
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="form-horizontal">
            <div class="form-group">
              <label for="" class="col-md-2 col-sm-2 col-xs-2 control-label">게시판명</label>
              <div class="col-md-2 col-sm-2 col-xs-3">
                <select class="form-control" name='bbs_id'>
                  <option value="">모든 게시판</option>
                    <?php foreach(@$board_list as $val){ ?>
                    <option value="<?=$val['bbs_id']?>" <?=($bbs_id==$val['bbs_id'])?"selected":""?>>
                        <?=$val['bbs_name']?>
                    </option>
                    <?php } ?>
                </select>
              </div>
            </div>
            <!--div class="form-group">
              <label for="" class="col-md-2 col-sm-2 col-xs-2 control-label">테마</label>
              <div class="col-md-2 col-sm-2 col-xs-3">
                <select class="form-control">
                  <option value="selected">모든 테마</option>
                  <option>1</option>
                  <option>2</option>
                </select>
              </div>
              <div class="col-md-3 col-sm-3 col-xs-3">
                <input type="text" class="form-control">
              </div>
            </div-->
            <div class="form-group">
              <label for="" class="col-md-2 col-sm-2 col-xs-2 control-label">검색</label>
              <div class="col-md-2 col-sm-2 col-xs-3">
                <select class="form-control" name="fkey">
                  <option value="title" <?=(!$fkey && $fkey=="title")?"selected":""?>>제목</option>
                  <option value="entry" <?=($fkey=="entry")?"selected":""?>>본문</option>
                  <option value="nick_name" <?=($fkey=="nick_name")?"selected":""?>>작성자</option>
                </select>
              </div>
              <div class="col-md-5 col-sm-5 col-xs-5">
                <input type="text" name="fword" class="form-control">
              </div>
            </div>
          </div>
        </div>

        <!-- btns -->
        <div class="btn-search">
          <button type="button" class="btn btn-primary" id="btn_search">검색</button>
        </div>
        <!-- .btns -->

      </div>
    </form>




      <div class="panel panel-default">
        <div class="panel-body">
          <div class="bs-example">
            <table class="table table-hover">
              <colgroup>
              <col class="col-xs-1">
              <col class="col-xs-4">
              <col class="col-xs-1">
              <col class="col-xs-2">
              <col class="col-xs-1">
              </colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>IP</th>
                  <th>등록일</th>
                </tr>
              </thead>
              <tbody>
            <c:forEach var="item" items="${list}" >
                <tr>
                  <td>${item.id}</td>
                  <td><a href="/board/view/${item.id}">${item.titles}</a></td>
                  <td><a href="/bbs_manage/article_list?user_id=<?=$val['user_id']?>"><?=$val['nick_name']?>(<?=$val['user_id']?>)</a></td>
                  <td><?=$val['write_ip']?></td>
                  <td>${item.regdate}</td>
                </tr>
            </c:forEach>
              </tbody>
            </table>
          </div>
          <!-- /example -->

        </div>
      </div>

          <!-- btns -->
{% include "common/paging.volt" %}
      <!-- .btns -->


    <hr>

    <!-- btns -->

      <div>
        <button type="button" id="btn_write" class="btn btn-primary">글쓰기</button>
      </div>
      <!-- .btns -->

    </div>
