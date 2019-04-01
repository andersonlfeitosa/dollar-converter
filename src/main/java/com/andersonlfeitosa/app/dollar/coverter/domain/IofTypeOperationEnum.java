package com.andersonlfeitosa.app.dollar.coverter.domain;

import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;

import java.math.BigDecimal;

public enum IofTypeOperationEnum {

	MONEY("0.0110"),

	CREDIT_CARD("0.0638");

	private BigDecimal iof;

	IofTypeOperationEnum(String iof) {
		this.iof = MoneyUtil.createBigDecimal(iof);
	}

	public BigDecimal getIof() {
		return iof;
	}

  public String iofToString() {
    return MoneyUtil.format(iof.multiply(MoneyUtil.createBigDecimal("100"))) + "%";
  }

}
