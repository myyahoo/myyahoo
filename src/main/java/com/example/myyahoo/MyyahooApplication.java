package com.example.myyahoo;

import com.example.myyahoo.common.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = Constants.APP_DEFAULT_PACKAGE_NAME)
public class MyyahooApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyyahooApplication.class, args);
	}

}
