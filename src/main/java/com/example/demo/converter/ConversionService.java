package com.example.demo.converter;



import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class ConversionService {
    Dotenv dotenv = Dotenv.load();
    String API_URL = dotenv.get("API_URL");
    String API_KEY = dotenv.get("API_KEY");
    
  
      public ExchangeRateResponse getExchangeRates(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(API_URL, ExchangeRateResponse.class, API_KEY, baseCurrency);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error fetching exchange rates: " + e.getResponseBodyAsString());
        }
    }


    public ConvertResponse convertCurrency(double amount, String from, String to) {
      ExchangeRateResponse exchangeRates = getExchangeRates(from);
      Double rate = exchangeRates.getRates().get(to);
      
      if (rate == null) {
          throw new RuntimeException("Conversion rate for " + to + " not found.");
      }

      double convertedAmount = amount * rate;
      return new ConvertResponse(from, to, amount, convertedAmount);
  }

}
