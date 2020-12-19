package com.nosto.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import com.nosto.model.Converter;
import com.nosto.model.ResponseObject;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	@Override
	public ResponseEntity<ResponseObject> getConvertion(Converter converter) {
		try {
			float convertionResult = converter.getConvertion();
			HttpHeaders headers = new HttpHeaders();
		    headers.add("Responded", "MyController");
		    boolean resultStatus = (convertionResult!=-1) ? true : false; 
		    if(resultStatus) {
		    	ResponseObject response = new ResponseObject(resultStatus, String.valueOf(convertionResult));
		        return ResponseEntity.accepted().headers(headers).body(response);
		    } else {
		    	ResponseObject response = new ResponseObject(resultStatus, String.valueOf(convertionResult));
		        return ResponseEntity.accepted().body(response);
		    }
		} catch(Exception e) {
			ResponseObject response = new ResponseObject(false, null, e.getMessage());
	        return ResponseEntity.accepted().body(response);
		}
	}
	
	@Override
	public ResponseEntity<ResponseObject> fail(List<ObjectError> errors) {
		List<String> errorList = new ArrayList<String>();
		for (ObjectError error : errors) {
			errorList.add(error.getDefaultMessage());
		}
		ResponseObject response = new ResponseObject(false, null, errorList.toString());
		return ResponseEntity.accepted().body(response);
	}

}