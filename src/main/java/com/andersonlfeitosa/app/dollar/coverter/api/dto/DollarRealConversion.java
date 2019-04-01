package com.andersonlfeitosa.app.dollar.coverter.api.dto;

public class DollarRealConversion {

  // original
  private String dollar;

  // original
  private String tax;

  // original
  private String city;

  // original
  private String dollarQuotation;

  // original
  private String iof;

  // calc: dollar * tax
  private String taxTotal;

  // calc: dollar + taxTotal
  private String dollarTotal;

  // calc: dollarTotal * dollarQuotation
  private String real;

  // calc: real * iof
  private String iofTotal;

  // calc: real + iofTotal
  private String realTotal;

  public String getDollar() {
    return dollar;
  }

  public void setDollar(String dollar) {
    this.dollar = dollar;
  }

  public String getTax() {
    return tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }

  public String getTaxTotal() {
    return taxTotal;
  }

  public void setTaxTotal(String taxTotal) {
    this.taxTotal = taxTotal;
  }

  public String getDollarTotal() {
    return dollarTotal;
  }

  public void setDollarTotal(String dollarTotal) {
    this.dollarTotal = dollarTotal;
  }

  public String getDollarQuotation() {
    return dollarQuotation;
  }

  public void setDollarQuotation(String dollarQuotation) {
    this.dollarQuotation = dollarQuotation;
  }

  public String getReal() {
    return real;
  }

  public void setReal(String real) {
    this.real = real;
  }

  public String getIof() {
    return iof;
  }

  public void setIof(String iof) {
    this.iof = iof;
  }

  public String getIofTotal() {
    return iofTotal;
  }

  public void setIofTotal(String iofTotal) {
    this.iofTotal = iofTotal;
  }

  public String getRealTotal() {
    return realTotal;
  }

  public void setRealTotal(String realTotal) {
    this.realTotal = realTotal;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
