package com.nosto.service.impl;

import org.springframework.stereotype.Service;

import com.nosto.commons.GenericServiceImpl;
import com.nosto.model.Converter;
import com.nosto.service.api.ConverterServiceAPI;

@Service
public class ConverterServiceImpl extends GenericServiceImpl<Converter, Long> implements ConverterServiceAPI {

}