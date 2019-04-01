package com.andersonlfeitosa.app.dollar.coverter.integration;

import com.andersonlfeitosa.app.dollar.coverter.integration.dto.QuotationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class QuotationRestService {

  @Value("${api.promasters.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Bean
  public RestTemplate createRestTemplate() {
    return new RestTemplate();
  }

  public QuotationResult getQuotation() {
    return this.restTemplate.getForObject(URI.create(endpoint), QuotationResult.class);
  }
}
