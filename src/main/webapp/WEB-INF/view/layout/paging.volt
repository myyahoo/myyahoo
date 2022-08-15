<?php if($PAGE) { ?>
      <div class="text-center">
        <ul class="pagination">
   		<?php if($PAGE["PREV10"]>0){?>
          <li class="<?=($PAGE["PREV10"]>0)?"":"disabled"?>"><a href="<?="$nurl&page=$PAGE[PREV10]";?>">«</a></li>
		<?php } ?>
   		<?php foreach($PAGE["NO"] as $key=>$NO){?>
          <li class="<?=($NO==$page)?"active":""?>"><a href="<?="$nurl&page=$NO";?>"><?=$NO?> <?php if($NO==$page) {?><span class="sr-only">(current)</span><?php } ?></a></li>
		<?php } ?>
   		<?php if($PAGE["NEXT10"]>0){?>
          <li><a href="<?="$nurl&page=$PAGE[NEXT10]";?>">»</a></li>
		<?php } ?>
        </ul>
      </div>
<?php } ?>
