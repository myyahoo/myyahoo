package com.example.myyahoo;

import com.example.myyahoo.common.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ComponentScan(basePackages = Constants.APP_DEFAULT_PACKAGE_NAME)
@EnableRedisHttpSession
public class MyyahooApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyyahooApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyyahooApplication.class);
	}

}
