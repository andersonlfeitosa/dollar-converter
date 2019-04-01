/*
 * Copyright (c) 2017, Cabal Brasil and/or its affiliates. All rights reserved.
 * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.andersonlfeitosa.app.dollar.coverter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket taskApi() {
    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).apiInfo(apiInfo()).select()
        .paths(PathSelectors.regex("/api.*")).build();
  }

  @Bean
  public UiConfiguration uiConfig() {
    return new UiConfiguration(null);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Dolar to Real Converter").description("Documentation").build();
  }

}
