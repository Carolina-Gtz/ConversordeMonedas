package com.alura.conversordemonedas.main;

import com.alura.conversordemonedas.modelos.ConversorDeMonedas;
import com.alura.conversordemonedas.modelos.ConversorDeMonedasDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ConversorDeMonedas conversorDeMoneda = new ConversorDeMonedas();
        String claveAPIs = "a31e68ef630df1f5854f2888";
        conversorDeMoneda.printMenuConversor();
        while (true) {
            conversorDeMoneda.elegirOpcionMenu();
            if (conversorDeMoneda.getRespuestaUsuario().equalsIgnoreCase("salir")) {
                System.out.println("Has salido del programa");
                break;

            }
            conversorDeMoneda.setMonedas(conversorDeMoneda.getRespuestaUsuario());

            String dirrecionUrl = "https://v6.exchangerate-api.com/v6/"
                    + claveAPIs + "/pair/"
                    + conversorDeMoneda.getNameMonedaBase()
                    + "/" + conversorDeMoneda.getNameMonedaDestino() + "";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dirrecionUrl))
                    .build();
            HttpResponse<String> responseURL = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = responseURL.body();

            Gson gson = new Gson();
            ConversorDeMonedasDTO conversorDeMonedasDTO = gson.fromJson(json, ConversorDeMonedasDTO.class);

            conversorDeMoneda.setMonedaDest(conversorDeMonedasDTO);
            System.out.println(conversorDeMoneda);


          //  conversorDeMoneda.elegirOpcionMenu();


        }
    }
}
