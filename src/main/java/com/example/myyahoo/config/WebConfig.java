package com.example.myyahoo.config;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 *  configuration 은 Bean에 등록하는것.  프로젝트 커질수로 Bean xml에 등록이 힘들어지므로 @Configuration 사용해서 Bean 등록
 *  Spring Bean 등록 방법(@Bean, @Configuration, @Component)
 *  @Configuration 안에서 @Bean을 사용해야 싱글톤을 보장받을 수 있으므로 @Bean 어노테이션은 반드시 @Configuration과 함께 사용해주어야 한다.
 *  예를 들어 우리가 객체를 Json 메세지로 변경하기 위해 Gson과 같은 외부 라이브러리를 사용한다고 하자.
 *  그러면 해당 클래스를 싱글톤 빈으로 등록해주어야 1개의 객체만 생성하여 여러 클래스가 공유함으로써 메모리 상의 이점을 얻을 수 있을 것이다.
 *  그런데 해당 클래스는 우리가 만든게 아니라 가져다 쓰는 클래스일 뿐이므로 불가피하게 @Bean으로 등록해줘야만 한다.
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private  AuthInterceptor authInterceptor;

    @Bean(name = "tilesConfigure")
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(Constants.TILES_LAYOUT_XML_PATH);
        configurer.setCheckRefresh(true);
        return configurer;
    }
    @Bean(name = "viewResolver")
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(1);
        return resolver;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns()
                .excludePathPatterns(authInterceptor.authExPath);
    }
}
