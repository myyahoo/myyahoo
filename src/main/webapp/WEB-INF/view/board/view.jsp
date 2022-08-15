<div class="col-lg-10 col-md-10 col-sm-9" id="contents-box">

<!-- 페이지 헤드라인 -->
<div class="page-header">
<h1>게시판 입니다.</small></h1>
</div>
      <div class="panel panel-default">
        <div class="panel-heading">게시판</div>
        <div class="panel-body">

        <!-- 글보기 -->
        <!-- 제목 -->
        <blockquote>
            <h3 class="lead text-primary"><?=$rs_view['title']?></h3>
        </blockquote>
            <p class="board-writer"><?=$rs_view['user_id']?> <em><?=strstr($rs_view['regdate']," ",true)?></em><a href="javascript:void(0)" onclick="doRecmd('<?=($rs_view['user_id']==$USER['user_id'])?"self":$rs_view['indexno'];?>',1)">추천</a><span id="recmd1"><?=$rs_view['recmd_cnt1']?></span>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="doRecmd(<?=($rs_view['user_id']==$USER['user_id'])?"self":$rs_view['indexno'];?>',2)">비추천</a><span id="recmd1">0</span>  <a href="javascript:void(0)" onclick="addScrap('<?=urlencode($scrap_url)?>','<?=urlencode($rs_view['title'])?>')">스크랩</a></p>
<?=$rs_view['contents']?>

<!-- .글보기 -->
<!--iframe src="/comments/list?article_id=<?=$rs_view['indexno']?>&cmt_type=1" frameborder="0" width=100% height=800 scrolling="no"></iframe-->
        <!--댓글-->

        <!--댓글-->

        </div>
      </div>
    <hr>
<!-- btns -->
      <div>
      <button type="button" onClick="goList()"  class="btn btn-reverse">목록</button>
        <?php if($perm_updel) { ?>
        <button type="button" onclick="_modify(<?=$rs_view['indexno']?>)" class="btn btn-primary">수정</button>
        <button type="button" onclick="_delete(<?=$rs_view['indexno']?>)" class="btn btn-default">삭제</button>
    <?php } ?>
      </div>
      <!-- .btns -->

    </div>
