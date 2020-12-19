package com.nosto.commons;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import com.nosto.model.Converter;
import com.nosto.model.ResponseObject;

public interface GenericServiceAPI<T, ID extends Serializable> {

	ResponseEntity<ResponseObject> fail(List<ObjectError> errors);
	
	ResponseEntity<ResponseObject> getConvertion(Converter converter);
}
