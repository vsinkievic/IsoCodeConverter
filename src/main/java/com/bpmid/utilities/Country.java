package com.bpmid.utilities;

public final class Country {
	
	private final String alfa2Code;
	private final String alfa3Code;
	private final String numericCode;
	private final String countryName;

	public Country(String alfa2Code, String alfa3Code, String numericCode, String countryName) {
		this.alfa2Code = fix(alfa2Code);
		this.alfa3Code = fix(alfa3Code);
		this.numericCode = fix(numericCode);
		this.countryName = fix(countryName);
	}
	
	private String fix(String str) {
		if (str == null)
			return null;
		return str.trim();
	}
	
	public String getAlfa2Code() {
		return alfa2Code;
	}
	
	public String getAlfa3Code() {
		return alfa3Code;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public String getNumericCode() {
		return numericCode;
	}
}
