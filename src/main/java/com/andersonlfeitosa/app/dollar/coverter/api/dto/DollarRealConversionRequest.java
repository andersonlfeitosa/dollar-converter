package com.andersonlfeitosa.app.dollar.coverter.api.dto;

import com.andersonlfeitosa.app.dollar.coverter.domain.AmericanCityTaxEnum;

public class DollarRealConversionRequest {

  // original
  private String dollar;

  // original
  private AmericanCityTaxEnum city;

  // original
  private String dollarQuotation;

  public String getDollar() {
    return dollar;
  }

  public void setDollar(String dollar) {
    this.dollar = dollar;
  }

  public AmericanCityTaxEnum getCity() {
    return city;
  }

  public void setCity(AmericanCityTaxEnum city) {
    this.city = city;
  }

  public String getDollarQuotation() {
    return dollarQuotation;
  }

  public void setDollarQuotation(String dollarQuotation) {
    this.dollarQuotation = dollarQuotation;
  }
}
