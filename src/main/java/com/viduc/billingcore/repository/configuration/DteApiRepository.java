package com.viduc.billingcore.repository.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.dto.response.DteApiProcessingResultResponseDte;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import com.viduc.billingcore.utils.enums.RequestProcessType;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import lombok.extern.java.Log;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Log
@Stateless
public class DteApiRepository {

    @Inject
    private GlobalVariables globalVariable;
    public void authenticate() throws Exception {

        var client = HttpClient.newHttpClient();
        var jsonMapper = new ObjectMapper();

        var credentials = new HashMap<String , String>() {
            {
                put("username" , "viduc");
                put("password" , "P@ssw0rd");
            }
        };


        String form = credentials.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(new URI("http://192.168.0.208/api-viduc/ws/authenticate"))
                                        .headers("Content-Type", "application/x-www-form-urlencoded")
                                        .POST(HttpRequest.BodyPublishers.ofString(form))
                                        .build();

        var response = client.sendAsync(request , HttpResponse.BodyHandlers.ofString()).get(5 , TimeUnit.MINUTES);

        if (response.statusCode() == 200) {
            var authenticationData = jsonMapper.readValue(response.body() , HashMap.class);
            globalVariable.setToken(authenticationData.get("token").toString());
        } else {
            throw new Exception("error with authentication dte api");
        }

    }

    public DteApiProcessingResultResponseDte send(String dte , RequestProcessType type) throws Exception {

        var client = HttpClient.newHttpClient();
        var token = globalVariable.getToken();
        var jsonMapper = new ObjectMapper();
        var request = new Object();


        if (globalVariable.getToken() == null) {
            authenticate();
            token = globalVariable.getToken();
            log.info("Token: " + token);
        }


        if (type == RequestProcessType.DTE) {
                    request = HttpRequest.newBuilder()
                    .uri(new URI("http://192.168.0.208/api-viduc/datos/insertar/general"))
                    .header("Authorization" , "Bearer " + token)
                    .headers("Content-Type" , "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(dte))
                    .build();
        } else {
                     request = HttpRequest.newBuilder()
                    .uri(new URI("http://192.168.0.208/api-viduc/datos/insertar/anulacionMH"))
                    .header("Authorization" , "Bearer " + token)
                    .headers("Content-Type" , "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(dte))
                    .build();
        }


        var response = client.sendAsync((HttpRequest) request, HttpResponse.BodyHandlers.ofString()).get(5 , TimeUnit.MINUTES);

        log.info(response.body());

        return jsonMapper.readValue(response.body() , DteApiProcessingResultResponseDte.class);

    }



}
