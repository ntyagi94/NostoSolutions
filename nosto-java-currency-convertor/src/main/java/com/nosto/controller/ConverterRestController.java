package com.nosto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nosto.model.Converter;
import com.nosto.model.ResponseObject;
import com.nosto.service.api.ConverterServiceAPI;

import io.github.sercasti.tracing.Traceable;

@RestController
@RequestMapping(value = "/api/v1/")
public class ConverterRestController {
	
	@Autowired
	private ConverterServiceAPI converterServiceAPI;
	
	@GetMapping(value = "/convert")
	@Traceable
	public ResponseEntity<ResponseObject> convert(@Valid Converter converter, BindingResult errors, RedirectAttributes atts) {
		if(errors.hasErrors()) {
			return converterServiceAPI.fail(errors.getAllErrors());
		}
		return converterServiceAPI.getConvertion(converter);
	}
}
