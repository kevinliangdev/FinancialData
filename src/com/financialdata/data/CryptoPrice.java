package com.financialdata.data;

import com.financialdata.data.api.API;

public class CryptoPrice implements AlphaVantage {

    String cryptoSymbol;
    String marketSymbol;

    private CryptoPrice() {

    }

    public CryptoPrice(String cryptoSymbol, String marketSymbol) {
        this.cryptoSymbol = cryptoSymbol;
        this.marketSymbol = marketSymbol;
    }

    public String getURL() {
        return "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_DAILY&symbol=" + cryptoSymbol + "&market=" + marketSymbol + "&apikey=" + API.getAPI();

    }

    public String getCryptoSymbol() {
        return cryptoSymbol;
    }

    public String getMarketSymbol() {
        return marketSymbol;
    }


}
