package com.financialdata;

import com.financialdata.data.CryptoPrice;
import com.financialdata.data.ExchangeRate;
import com.financialdata.data.StockPrice;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static com.financialdata.parsers.JsonParser.readJsonFromUrl;


public class Main {

    public static void main(String[] args) throws IOException, JSONException {

        Scanner in = new Scanner(System.in);


        boolean notDoneMain = true;

        while (notDoneMain) {

            System.out.println("Enter 1 for Realtime Currency Exchange Rate.");
            System.out.println("Enter 2 for StockPrice.");
            System.out.println("Enter 3 for CryptoPrice.");
            System.out.println("Enter 0 to terminate program.");
            Integer choice = in.nextInt();

            boolean notDone = true;



            while (notDone) {

                if (choice == 0) {
                    notDone = false;
                    notDoneMain = false;
                }

                if (choice == 1) {


                    System.out.println("Enter the currency pair you are trading from and trading to. Example: CAD USD");
                    String currency1 = in.next();
                    String currency2 = in.next();

                    ExchangeRate er = new ExchangeRate(currency1, currency2);
                    JSONObject json = readJsonFromUrl(er.getURL());
                    String op1 = json.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");
                    String op2 = json.getJSONObject("Realtime Currency Exchange Rate").getString("6. Last Refreshed").substring(0, 10);
                    System.out.println("The exchange rate from " + currency1 + " to " + currency2 + " is " + op1 + " on " + op2);

                    notDone = false;

                } else if (choice == 2) {


                    System.out.println("Enter a stock ticker to get current price");
                    String currency1 = in.next();

                    StockPrice stock = new StockPrice(currency1);
                    JSONObject json = readJsonFromUrl(stock.getURL());
                    String op1 = json.getJSONObject("Global Quote").getString("05. price");

                    System.out.println("Stock price of $" + currency1 + " is: " + op1);

                    notDone = false;

                } else if (choice == 3) {

                    System.out.println("Enter the cryptocurrency ticker and the market it is traded in. EX: BTC USD");
                    String crypto = in.next();
                    String market = in.next();

                    CryptoPrice cryptoPrice = new CryptoPrice(crypto, market);
                    JSONObject json = readJsonFromUrl(cryptoPrice.getURL());


                    String date = json.getJSONObject("Meta Data").getString("6. Last Refreshed");
                    JSONObject json2 = json.getJSONObject("Time Series (Digital Currency Daily)");
                    String date2 = date.substring(0, 10);
                    String price = json2.getJSONObject(date2).getString("4a. close (" + market + ")");
                    System.out.println("Value of " + cryptoPrice.getCryptoSymbol() + " on the "
                            + cryptoPrice.getMarketSymbol() + " market is " + price + " on " + date);

                    notDone = false;

                } else if (choice > 3 || choice < 1 && choice != 0) {
                    System.out.println("Please enter a valid number");
                }


            }


        }

        System.out.println("Program terminated.");


    }


}
