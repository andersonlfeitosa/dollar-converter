package com.andersonlfeitosa.app.dollar.coverter.util;

import java.text.NumberFormat;
import java.util.Locale;

public enum CurrencyFormatEnum {

  REAL("pt", "BR"),

  DOLLAR("en", "US");

  private String language;

  private String country;

  private static final NumberFormat DOLLAR_FORMAT = NumberFormat.getCurrencyInstance(new Locale(DOLLAR.language, DOLLAR.country));

  private static final NumberFormat REAL_FORMAT = NumberFormat.getCurrencyInstance(new Locale(REAL.language, REAL.country));

  CurrencyFormatEnum(String language, String country) {
    this.language = language;
    this.country = country;
  }

  public NumberFormat getFormat() {
    if (this.equals(DOLLAR)) {
      return DOLLAR_FORMAT;
    }

    return REAL_FORMAT;
  }

}
