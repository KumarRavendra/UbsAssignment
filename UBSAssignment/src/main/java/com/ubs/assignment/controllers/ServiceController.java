package com.ubs.assignment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ubs.assignment.interfaces.ResponseObj;
import com.ubs.assignment.interfaces.Services;
import com.ubs.assignment.servicesImpl.PrimeServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = {"Prime Number Generator"})
public class ServiceController {

	@Autowired
	Services ps;
	
	@Autowired
	ResponseObj pr;

	@GetMapping("primes/{init}")
	@ApiOperation(value = "Generates the Prime Numbers less than and equal to the provided Number", notes = "Please provide the Number as init", response = PrimeServiceResponse.class)
	public String getPrime(@ApiParam(value = "Enter the Number",example = "10" )@PathVariable("init") Integer init,
			@ApiParam(value = "Enter the Response Type : XML or JSON",example = "application/json")@RequestHeader(name = "accept", required = false) String responseType)
			throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		if (responseType.equalsIgnoreCase(MediaType.APPLICATION_XML_VALUE)) {
			mapper = new XmlMapper();
		}

		String res = mapper.writeValueAsString(ps.serve(Optional.ofNullable(init)));
		return res;
	}

	@GetMapping("error")
	public String getError() {

		return "Sorry No Reponse found for your Request, "
				+ "Please ensure that you are requesting http://&lt;your server: port&gt;/primes/&lt;Number&gt;";
	}

}
