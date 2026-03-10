package com.alura.conversor.service;

import com.alura.conversor.model.ResultadoConversion;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    private final String apiKey;

    public ConsultaMoneda(String apiKey) {
        this.apiKey = apiKey;
    }

    public ResultadoConversion convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey
                + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error HTTP: " + response.statusCode());
            }

            String json = response.body();

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            String resultado = jsonObject.get("result").getAsString();

            if (!resultado.equals("success")) {
                throw new RuntimeException("La API devolvió un error: " + resultado);
            }

            String baseCode = jsonObject.get("base_code").getAsString();
            String targetCode = jsonObject.get("target_code").getAsString();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            double conversionResult = jsonObject.get("conversion_result").getAsDouble();

            return new ResultadoConversion(baseCode, targetCode, conversionRate, conversionResult);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No fue posible realizar la conversión: " + e.getMessage());
        }
    }
}