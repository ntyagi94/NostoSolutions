package com.nosto.validators;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectTargetValidator implements ConstraintValidator<CorrectTarget, String> {
	
	private final String currencyRegex = "[A-Z]{3}";
	private final String[] currencies = {
			"USD", "GBP", "EUR", "JPY", "BGN", "CZK", "DKK", "HUF", "PLN", "RON",
			"SEK", "CHF", "ISK", "NOK", "HRK", "RUB", "TRY", "AUD", "BRL", "CAD",
			"CNY", "HKD", "IDR", "ILS", "INR", "KRW", "MXN", "MYR", "NZD", "BHP",
			"SGD", "THB", "ZAR"};
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	if(value != null && !value.isEmpty()) {
    		if( value.length()!=3 ) {
    			return false;
    		}
    		if( !value.matches(currencyRegex) ) {
    			return false;
    		}
    		if(!isCurrencySupported(value)) {
    			return false;
    		}
    		return true;
    	}
        return false;
    }
    
    protected boolean isCurrencySupported(String currency) {
    	return Arrays.stream(currencies).anyMatch(currency::equals);
    }
 
}