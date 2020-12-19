package com.nosto.api.dao;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.nosto.model.Converter;

public class ExchangeRateApiClient {
	
	private RestTemplate restTemplate;
	private String baseApiUrl = "https://api.exchangeratesapi.io/";

    public ExchangeRateApiClient() {
    	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public String getLastestForCurrencies(Converter convertion) throws Exception {
    	String source = convertion.getSource();
    	String target = convertion.getTarget();
    	final String requestUrl = String.format("%slatest?base=%s&symbols=%s,%s", baseApiUrl, source, source, target);
    	return this.restTemplate.getForObject(requestUrl, String.class);
    }
}
