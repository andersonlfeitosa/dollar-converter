package com.andersonlfeitosa.app.dollar.coverter.domain;

import com.andersonlfeitosa.app.dollar.coverter.util.CurrencyFormatEnum;
import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AmericanCityTaxEnum {

	DEFAULT("DEFAULT", "0"),

	ORLANDO("Orlando", "0.065"),

	MIAMI("Miami", "0.07"),

	CHICAGO("Chicago", "0.095"),

	TAMPA("Tampa", "0.07"),

	WISCONSIN("Wisconsin", "0.05"),

	ALABAMA("Alabama", "0.0845"),

	NOVA_YORK("Nova York", "0.08875"),

	LAS_VEGAS("Las Vegas", "0.0825"),

	VIRGINIA("Virginia", "0.05"),

	WASHINGTON_DC("Washington DC", "0.06"),

	BOSTON("Boston", "0.063"),

	TEXAS("Texas", "0.0825"),

	NEW_ORLEANS("New Orleans", "0.09"),

	LOS_ANGELES("Los Angeles", "0.087"),

	SAN_FRANCISCO("San Francisco", "0.085"),

	CALIFORNIA("Califórnia", "0.0838"),

	MICHIGAN("Michigan", "0.06"),

	UTAH("Utah", "0.0667"),

	OHIO("Ohio", "0.0680"),

	CAROLINA_DO_NORTE("Carolina do Norte", "0.0687"),

	KENTUCKY("Kentucky", "0.06"),

	ARKANSAS("Arkansas", "0.0861"),

	RHODE_ISLAND("Rhode Island", "0.07"),

	INDIANA("Indiana", "0.07"),

	ARIZONA("Arizona", "0.1016"),

	DELAWARE("Delaware", "0"),

	MONTANA("Montana", "0"),

	OREGON("Oregon", "0"),

	NEW_HAMPSHIRE("New Hampshire", "0");

	private String city;

	private BigDecimal tax;

	AmericanCityTaxEnum(String city, String tax) {
		this.city = city;
		this.tax = MoneyUtil.createBigDecimal(tax);
	}

	public String getCity() {
		return city;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public static List<String> getCities() {
		return Arrays.asList(values()).stream().map(a -> a.city).collect(Collectors.toList());
	}

	public static BigDecimal getTaxByCityName(String cityName) {
		return Arrays.asList(values()).stream().filter(
				a -> a.getCity().equalsIgnoreCase(cityName)).findFirst().orElse(DEFAULT).getTax();
	}

	public String taxToString() {
	  return MoneyUtil.format(tax.multiply(MoneyUtil.createBigDecimal("100"))) + "%";
  }

}
