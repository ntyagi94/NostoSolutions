package com.nosto.model;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosto.api.dao.ExchangeRateApiClient;
import com.nosto.validators.CorrectSource;
import com.nosto.validators.CorrectTarget;

public class Converter {
	
  private final long id;
  
  @CorrectSource
  private final String source;
  
  @CorrectTarget
  private final String target;
  
  private final float amount;

  public Converter(String source, String target, float amount) {
	AtomicLong identifier = new AtomicLong();
    this.id = identifier.incrementAndGet();
    this.source = source;
    this.target = target;
    this.amount = amount;
  }

  public long getId() {
    return id;
  }

  public String getSource() {
    return source;
  }
  
  public String getTarget() {
    return target;
  }
  
  public float getAmount() {
    return amount;
  }
  
  protected float getConversionCoefficient(Rate[] rates) {
	  for (Rate rate : rates)
	  {
		  if(rate.getName().equals(target)) {
			  return rate.getValue();
		  }
	  }
	  return -1;
  }
  
  public float getConvertion() {
	ExchangeRateApiClient externalClient = new ExchangeRateApiClient();
	ObjectMapper objectMapper = new ObjectMapper();
	try {
		ConvertionResponse response = objectMapper.readValue(externalClient.getLastestForCurrencies(this), 
				ConvertionResponse.class);
		float conversionResult = getConversionCoefficient(response.getFormatedRates());
		float result = (conversionResult==-1) ? -1 : this.amount*conversionResult;
		return result;
	} catch (Exception e) {
		return -1;
	}
  }
}