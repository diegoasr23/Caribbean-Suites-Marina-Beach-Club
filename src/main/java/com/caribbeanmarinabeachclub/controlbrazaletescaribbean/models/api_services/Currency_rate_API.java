/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.api_services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonParser;
import lombok.Getter;

import java.util.Map;

/**
 * @author diego
 */

@Getter
public class Currency_rate_API {
    private double priceVES_USD = 0.0;

    public Currency_rate_API() {
        String url_str = "https://v6.exchangerate-api.com/v6/ea2f3b556c08b7d88e95d902/latest/USD";

        try {
            URL url = new URL(url_str);
            HttpURLConnection request = null;
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            JsonObject js = jsonobj.getAsJsonObject("conversion_rates");
            priceVES_USD = js.get("VES").getAsDouble();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
