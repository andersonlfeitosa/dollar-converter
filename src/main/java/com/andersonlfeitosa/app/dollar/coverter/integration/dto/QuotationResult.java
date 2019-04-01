package com.andersonlfeitosa.app.dollar.coverter.integration.dto;

import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public class QuotationResult {

  private BigDecimal value;

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  @JsonProperty("valores")
  private void unpackNameFromNestedObject(Map<String, Map<String, String>> valores) {
    Map<String, String> usd = valores.get("USD");
    this.value = MoneyUtil.createBigDecimal(usd.get("valor"));
  }

}

