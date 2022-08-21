package com.example.myyahoo.common;

public class Constants {
    //프로젝트 패키지 이름
    public final static String APP_DEFAULT_PACKAGE_NAME = "com.example.myyahoo";

    //dao 패키지 경로
    public final static String MAPPER_PACKAGE = Constants.APP_DEFAULT_PACKAGE_NAME+".dao";

    //Tiles xml 경로
    public final static String[] TILES_LAYOUT_XML_PATH = {
            "/WEB-INF/tiles.xml"
    };

    //Runtime에서 JSP의 refresh 적용 여부
    public final static boolean REFRESH_JSP_ON_RUNTIME = true;

    public final static String SESSION_ID="member";
}
