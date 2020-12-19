package com.nosto.model;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConvertionResponse {
	@JsonProperty("rates")
    private Object rates;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private Date date;
    
    public Object getRates() {
    	return this.rates;
    }
    
    public String getBase() {
    	return this.base;
    }
    
    public Date getDate() {
    	return this.date;
    }
    
    protected Rate[] currencyList() throws Exception {
    	Rate[] result = new Rate[2];
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString = mapper.writeValueAsString(this.rates);
    	jsonString = jsonString.replace("{", "");
    	jsonString = jsonString.replace("}", "");
    	jsonString = jsonString.replace("\"", "");
    	String[] currencies = jsonString.split(",", 2); 
    	String[] leftCurrencies = currencies[0].split(":", 2); 
    	String[] rightCurrencies = currencies[1].split(":", 2); 
    	Rate rate = new Rate(leftCurrencies[0], Float.parseFloat(leftCurrencies[1]));
    	result[0] = rate;
    	rate = new Rate(rightCurrencies[0], Float.parseFloat(rightCurrencies[1]));
    	result[1] = rate;
    	return result;
    }
    
    public Rate[] getFormatedRates() {
    	try {
    		return currencyList();
    	} catch(Exception e) {
    		
    	}
    	return null;
    }
}
