<link rel="stylesheet" type="text/css" href="/js/datetimepicker/jquery.datetimepicker.css"/ >
<script src="/js/bootstrap-modal.js"></script>
<script src="/js/datetimepicker/jquery.datetimepicker.js"></script>

<script>
function onDelete(indexno){
    if(confirm('삭제하시겠습니까')){
    }
}
function goWrite(bbs_id){
    location.href="/bbs_manage/article_create?bbs_id="+bbs_id;
}


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

});

function goToDelete(){
    var id =new Array();
    $("input[name=chk_id]:checked").each(function() {
        id.push($(this).val());
    });

    if(id.length < 1) {
        alert('선택하세요');
        return;
    }

    if(confirm('삭제하시겠습니까?')){
        ids = id.join();


        $.ajax({
          type: "GET",
          timeout:30000,
          url: '/bbs_manage/ajax_bbs_delete?ids='+ids,
          success : function(data) {
console.log(data);
                if(data=='success'){
                    location.reload();
                } else {
                    alert(data);
                }
          },
          error : function(e){
               alert("처리중 장애가 발생하였습니다.");
               return;

            }
        });
    }
}

function goToBlockIP(ip,user_id){

    if(confirm('차단하시겠습니까?')){

        $.ajax({
          type: "GET",
          timeout:30000,
          //url: '/bbs_manage/ajax_block_ip?ip='+ip+"&user_id="+user_id,
          url: '/bbs_manage/ajax_block_ip',
          data: {ip:ip,user_id:user_id},
          success : function(data) {
                if(data=='success'){
                    location.reload();
                } else {
                    alert(data);
                    //location.reload();
                }
          },
          error : function(e){
               alert("처리중 장애가 발생하였습니다.");
               return;

            }
        });
    }
}



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
              <col class="col-xs-1">
              <col class="col-xs-4">
              <col class="col-xs-1">
              <col class="col-xs-2">
              <col class="col-xs-1">
              </colgroup>
              <thead>
                <tr>
                  <th><input type="checkbox" id="chk_id_all" value="">&nbsp;&nbsp;NO</th>
                  <th>게시판명</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>IP</th>
                  <th>등록일</th>
                </tr>
              </thead>
              <tbody>
        <?php if($rs_list ) { ?>
            <?php foreach($rs_list as $key=>$val) {
                    $bbs_name = ($val['bbs_id'])?@$board_list[$val['bbs_id']]['bbs_name']:"";
            ?>
                <tr>
                  <td><input type="checkbox" name="chk_id" id="" value="<?=$val['indexno']?>">&nbsp;&nbsp;<?=$val['indexno']?></td>
                  <td><?=$bbs_name?></td>
                  <td><?=($val['has_photo']=='y')?"<img src='/img/has_photo.png'>":""?><a href="<?=$vurl?>&indexno=<?=$val['indexno']?>"><?=$val['title']?></a><?=($val["comments_cnt"])?"($val[comments_cnt])":""?></td>
                  <td><a href="/bbs_manage/article_list?user_id=<?=$val['user_id']?>"><?=$val['nick_name']?>(<?=$val['user_id']?>)</a></td>
                  <td><?=$val['write_ip']?>
                    <?php if(in_array($val['write_ip'],$block_ip) ) { ?>
                    (차단됨)
                    <?php }else{ ?>
                    (<a href="javascript:void(0)" onclick="goToBlockIP('<?=$val['write_ip']?>','<?=$val['user_id']?>')" >차단</a>)
                    <?php } ?>

                    </td>
                  <td><?=substr($val['regdate'],0,-3)?></td>
                </tr>
            <?php } ?>
            <?php } ?>
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
        <button type="button" onclick="goWrite(<?=$bbs_id?>)" class="btn btn-primary">글쓰기</button>
        <button type="button" onclick="goToDelete()" class="btn btn-primary">삭제</button>

      </div>
      <!-- .btns -->

    </div>
