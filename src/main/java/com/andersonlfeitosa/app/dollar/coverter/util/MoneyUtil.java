package com.andersonlfeitosa.app.dollar.coverter.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyUtil {

  public static BigDecimal createBigDecimal(String value) {
    BigDecimal bigDecimal = new BigDecimal(value);
    bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    return bigDecimal;
  }

  public static String format(BigDecimal value, CurrencyFormatEnum currency) {
    return currency.getFormat().format(value);
  }

  public static String format(BigDecimal value) {
    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(0);
    df.setGroupingUsed(false);
    return df.format(value);
  }

}
