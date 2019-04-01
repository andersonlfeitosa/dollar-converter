package com.andersonlfeitosa.app.dollar.coverter.domain;

public enum CurrencyEnum {

  DOLAR("USD", "Dólar"),

  EURO("EUR", "Euro"),

  PESO_ARGENTINO("ARS", "Peso Argentino"),

  LIBRA_ESTERLINA("GBP", "Libra Esterlina");

  private String abbreviation;

  private String name;

  CurrencyEnum(String abbreviation, String name) {
    this.abbreviation = abbreviation;
    this.name = name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public String getName() {
    return name;
  }

}
