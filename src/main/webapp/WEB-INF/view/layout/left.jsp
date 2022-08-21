<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-lg-2 col-md-2 col-sm-3" id="gnb-menu">

      <div class="btn-write"><button type="button" class="btn btn-primary btn-block" onclick="document.location.href='/news/create'"><span class="icon-write"></span>기사 작성</button></div>

      <!-- 셀렉트된 메뉴의 li 에 active 클래스 적용 -->
      <ul class="nav nav-phills nav-stacked">

        <li class="dropdown"> <a href="/news/list" class="dropdown-toggle" data-toggle='dropdown'><span class="icon-list"></span>기사관리<span class="caret"></span></a>

            <ul class="dropdown-menu">
                <li><a href="/news/list">전체기사</a></li>
                <li><a href="/news/create">기사작성</a></li>
                <li><a href="/news/multiphoto_upload">멀티포토기사작성</a></li>
                <li><a href="/news/del_list">삭제기사</a></li>
                <li><a href="/mp3_upload/list">mp3 upload</a></li>
            </ul>

        </li>
		<?php if($from_mobile==false) { ?>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle='dropdown'><span class="icon-notice"></span>커뮤니티<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/board_reporter/article_list?bbs_id=4">편집국전용 기사메모</a></li>
                <li><a href="/board_reporter/article_list?bbs_id=2">기사메모제출</a></li>
                <li><a href="/propose/list">제휴제안</a></li>
                <li><a href="/comments/manage">댓글</a></li>
                <li><a href="/comments/block_ip_list">차단IP</a></li>
                <!--li><a href="/board_reporter/article_list?bbs_id=3">기사수정</a></li>
                <li><a href="/board_reporter/article_list?bbs_id=5">스포츠레저</a></li>
                <li><a href="/board_reporter/article_list?bbs_id=6">방송연예</a></li-->
            </ul>
        </li>

        <li class="dropdown"><a href="/site_edit/template_list" class="dropdown-toggle"  data-toggle='dropdown'><span class="icon-setting"></span>사이트편집<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/site_edit/template_list?cate_id1=6">화면편집</a></li>
                <li><a href="/site_edit/template_list?cate_id1=7">광고편집</a></li>
            </ul>
        </li>

        <li class="dropdown"><a href="/gallery/list?gallery_type=p"><span class="icon-camera"></span>포토슬라이드<span class="caret"></span></a>
        </li>
        <li class="dropdown"><a href="/board_reporter/article_list?type=notice&bbs_id=0"><span class="icon-magic"></span>사이트 공지사항<span class="caret"></span></a>
          <!--
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">미정</a></li>
            </ul>
        -->
        </li>

        <li class="dropdown"><a href="/category/list" class="dropdown-toggle"  data-toggle='dropdown'><span class="icon-setting"></span>카테고리<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/category/list">Subject 카테고리</a></li>
                <li><a href="/category/theme_category">테마 카테고리</a></li>
                <li><a href="/category/edit_category">편집 카테고리</a></li>
                <li><a href="/category/photo_category">포토 카테고리</a></li>
            </ul>
        </li>

        <li class="dropdown"><a href="/member/list"  class="dropdown-toggle"  data-toggle='dropdown'><span class="icon-user"></span>회원관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/member/list/">전체 회원 관리</a></li>
                <li><a href="/action/list/">기능 관리</a></li>
                <li><a href="/group/list/">그룹 관리</a></li>
                <li><a href="/user/list/">일반회원</a></li>
            </ul>
        </li>

        <li class="dropdown"><a href="/statistics"  class="dropdown-toggle"  data-toggle='dropdown'><span class="icon-magic"></span>통계<span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="/statistics">통계</a></li>
                <li><a href="/statistics/crawl_search">실시간검색</a></li>
                <li><a href="/statistics/dictionary_list">사전관리</a></li>
                <!--li><a href="/search_keyword/list/">검색어 목록</a></li-->
            </ul>
        </li>
		<?php } ?>
      </ul>
    </div>

