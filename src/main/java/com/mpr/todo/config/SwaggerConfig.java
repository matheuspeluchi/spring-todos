package com.mpr.todo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi( ) {
		return new Docket( DocumentationType.SWAGGER_2 ).select( )
      .apis( RequestHandlerSelectors.basePackage(
          "com.mpr.todo" ) )
      .paths( regex( "/todo.*" ) )
      .build( )
      .apiInfo( metaInfo( ) );
	}

	private ApiInfo metaInfo( ) {

		return new ApiInfo( "TODO List", "Task list API REST.", "1.0.0",
    "Terms of Service", new Contact( "Matheus Peluchi",
                  "https://github.com/matheuspeluchi",
                  "matheuspeluchi@gmail.comm" ),
    "Apache License Version 2.0",
    "https://www.apache.org/licesen.html",
            new ArrayList<VendorExtension>());
    
	}

}
