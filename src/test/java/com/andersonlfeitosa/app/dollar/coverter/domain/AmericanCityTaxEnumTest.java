package com.andersonlfeitosa.app.dollar.coverter.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;
import org.junit.Test;

public class AmericanCityTaxEnumTest {

	@Test
	public void testGetCities() {
		assertEquals(30, AmericanCityTaxEnum.getCities().size());
		assertEquals("[DEFAULT, Orlando, Miami, Chicago, Tampa, Wisconsin, Alabama, Nova York, Las Vegas, Virginia, Washington DC, Boston, Texas, New Orleans, Los Angeles, San Francisco, Califórnia, Michigan, Utah, Ohio, Carolina do Norte, Kentucky, Arkansas, Rhode Island, Indiana, Arizona, Delaware, Montana, Oregon, New Hampshire]", AmericanCityTaxEnum.getCities().toString());
	}

	@Test
	public void testGetTaxByCityName() {
		assertEquals(MoneyUtil.createBigDecimal("0"), AmericanCityTaxEnum.getTaxByCityName("delaware"));
		assertEquals(MoneyUtil.createBigDecimal("0"), AmericanCityTaxEnum.getTaxByCityName("san diego"));
		assertEquals(MoneyUtil.createBigDecimal("0.07"), AmericanCityTaxEnum.getTaxByCityName("MiaMi"));
	}

}
