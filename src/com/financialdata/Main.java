package com.financialdata;

import com.financialdata.data.ExchangeRate;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static com.financialdata.parsers.JsonParser.readJsonFromUrl;


public class Main {

    public static void main(String[] args) throws IOException, JSONException {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter any pair of currency to return the realtime exchange rate. Ex: CAD USD");
        String currency1 = in.next();
        String currency2 = in.next();
        ExchangeRate exchangeRate = new ExchangeRate(currency1, currency2);
        JSONObject json = readJsonFromUrl(exchangeRate.getURL());
        String op1= json.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");

        System.out.println("Exchange rate from " + currency1 + " -> " + currency2 + " is " + op1);
    }
}
