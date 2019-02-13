package com.financialdata.data;

import com.financialdata.API;

public class ExchangeRate implements AlphaVantage{

    private static final String url1 = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=";
    private static final String url2 = "&to_currency=";
    private static final String url3 = "&apikey=";

    private String fromCurrency;
    private String toCurrency;

    private ExchangeRate() {

    }

    public ExchangeRate(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;

    }

    public String getURL() {
        return url1 + fromCurrency + url2 + toCurrency + url3 + API.getAPI();
    }









}
