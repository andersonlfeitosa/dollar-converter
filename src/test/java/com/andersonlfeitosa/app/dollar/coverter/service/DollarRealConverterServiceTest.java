package com.andersonlfeitosa.app.dollar.coverter.service;

import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;
import org.junit.Assert;
import org.junit.Test;

public class DollarRealConverterServiceTest {

  private DollarRealConverterService service = new DollarRealConverterService();

	@Test
	public void testCreditCardConvert() {
	}

	@Test
	public void testMoneyConvert() {
	}

	@Test
  public void testConvert() {
  }

  @Test
  public void testCalculateTaxTotal() {
  }

  @Test
  public void testCalculateDollarTotal() {
  }

  @Test
  public void testCalculateReal() {
    Assert.assertEquals(MoneyUtil.createBigDecimal("1264.89"), service.calculateReal(MoneyUtil.createBigDecimal("350.39"), MoneyUtil.createBigDecimal("3.61")));
  }

  @Test
  public void testCalculateIofTotal() {
  }

  @Test
  public void testCalculateRealTotal() {
  }

}
