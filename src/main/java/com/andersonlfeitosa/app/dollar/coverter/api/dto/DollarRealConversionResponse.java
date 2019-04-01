package com.andersonlfeitosa.app.dollar.coverter.api.dto;

public class DollarRealConversionResponse {
	
	private DollarRealConversion money;
	
	private DollarRealConversion creditCard;

	public DollarRealConversion getMoney() {
		return money;
	}

	public void setMoney(DollarRealConversion money) {
		this.money = money;
	}

	public DollarRealConversion getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(DollarRealConversion creditCard) {
		this.creditCard = creditCard;
	}
}
