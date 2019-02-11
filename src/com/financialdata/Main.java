package com.financialdata;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static com.financialdata.parsers.JsonParser.readJsonFromUrl;


public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        String api = API.getAPI();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the JSON URL :");
        String url = in.next();
        JSONObject json = readJsonFromUrl(url);
        String op1= json.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");

        System.out.println("Exchange rate is: " + op1);
    }
}
