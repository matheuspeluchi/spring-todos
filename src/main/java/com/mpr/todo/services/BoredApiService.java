package com.mpr.todo.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClient;
import com.google.gson.Gson;
import com.mpr.todo.application.DTO.ActivityDTO;

@Service
public class BoredApiService {

  @Value("${boredApi.url}")
  private String url;

  public ActivityDTO getBoredActivity() {
    ActivityDTO activity = null;
    try {
      WebClient client = WebClient.create();
      WebClient.ResponseSpec responseSpec = client.get().uri(url).retrieve();
      activity = responseSpec.bodyToMono(ActivityDTO.class).block();
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (activity == null) {
      throw new RestClientException("Invalid response from boredApi");
    }
    return activity;
  }
}
