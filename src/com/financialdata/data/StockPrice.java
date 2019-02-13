package com.financialdata.data;

import com.financialdata.API;

public class StockPrice implements AlphaVantage{

    private String stockSymbol;

    private StockPrice() {

    }

    public StockPrice(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getURL() {

        return "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockSymbol + "&apikey=" + API.getAPI();

    }



}
