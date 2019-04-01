package com.andersonlfeitosa.app.dollar.coverter.service;

import java.math.BigDecimal;

import com.andersonlfeitosa.app.dollar.coverter.api.dto.DollarRealConversion;
import com.andersonlfeitosa.app.dollar.coverter.api.dto.DollarRealConversionRequest;
import com.andersonlfeitosa.app.dollar.coverter.api.dto.DollarRealConversionResponse;
import com.andersonlfeitosa.app.dollar.coverter.domain.*;
import com.andersonlfeitosa.app.dollar.coverter.integration.QuotationRestService;
import com.andersonlfeitosa.app.dollar.coverter.integration.dto.QuotationResult;
import com.andersonlfeitosa.app.dollar.coverter.util.CurrencyFormatEnum;
import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DollarRealConverterService {


  public static final String VALUE = "0.20";

  @Autowired
  private QuotationRestService quotationRestService;

  public DollarRealConversionResponse converter(DollarRealConversionRequest dto) {
    DollarRealConversionResponse result = new DollarRealConversionResponse();
    QuotationResult quotation = quotationRestService.getQuotation();
    BigDecimal value = MoneyUtil.createBigDecimal(dto.getDollar());
    BigDecimal dollarQuotation = dto.getDollarQuotation() == null ?
      quotation.getValue().add(MoneyUtil.createBigDecimal(VALUE)) : MoneyUtil.createBigDecimal(dto.getDollarQuotation());
    result.setMoney(moneyConvert(value, dto.getCity(), dollarQuotation));
    result.setCreditCard(creditCardConvert(value, dto.getCity(), quotation.getValue()));

    return result;
  }

  protected DollarRealConversion creditCardConvert(BigDecimal value, AmericanCityTaxEnum city, BigDecimal dollarQuotation) {
    return convert(value, city, dollarQuotation, IofTypeOperationEnum.CREDIT_CARD);
  }

  protected DollarRealConversion moneyConvert(BigDecimal value, AmericanCityTaxEnum city, BigDecimal dollarQuotation) {
    return convert(value, city, dollarQuotation, IofTypeOperationEnum.MONEY);
	}

  protected DollarRealConversion convert(BigDecimal value, AmericanCityTaxEnum city, BigDecimal dollarQuotation, IofTypeOperationEnum type) {
    BigDecimal taxTotal = calculateTaxTotal(value, city);
    BigDecimal dollarTotal = calculateDollarTotal(value, taxTotal);
    BigDecimal real = calculateReal(dollarTotal, dollarQuotation);
    BigDecimal iofTotal = calculateIofTotal(real, type);
    BigDecimal realTotal = calculateRealTotal(real, iofTotal);

    DollarRealConversion result = new DollarRealConversion();
    result.setDollar(MoneyUtil.format(value, CurrencyFormatEnum.DOLLAR));
    result.setDollarQuotation(MoneyUtil.format(dollarQuotation, CurrencyFormatEnum.REAL));
    result.setIof(type.iofToString());
    result.setTax(city.taxToString());
    result.setCity(city.getCity());

    result.setTaxTotal(MoneyUtil.format(taxTotal, CurrencyFormatEnum.DOLLAR));
    result.setDollarTotal(MoneyUtil.format(dollarTotal, CurrencyFormatEnum.DOLLAR));
    result.setReal(MoneyUtil.format(real, CurrencyFormatEnum.REAL));
    result.setIofTotal(MoneyUtil.format(iofTotal, CurrencyFormatEnum.REAL));
    result.setRealTotal(MoneyUtil.format(realTotal, CurrencyFormatEnum.REAL));

    return result;

  }

  protected BigDecimal calculateTaxTotal(BigDecimal value, AmericanCityTaxEnum city) {
		return value.multiply(city.getTax());
	}

  protected BigDecimal calculateDollarTotal(BigDecimal value, BigDecimal taxTotal) {
		return value.add(taxTotal);
	}

  protected BigDecimal calculateReal(BigDecimal value, BigDecimal dollarQuotation) {
    return value.multiply(dollarQuotation);
	}

  protected BigDecimal calculateIofTotal(BigDecimal value, IofTypeOperationEnum iof) {
    return value.multiply(iof.getIof());
	}

  protected BigDecimal calculateRealTotal(BigDecimal real, BigDecimal iofTotal) {
    return real.add(iofTotal);
  }

}
