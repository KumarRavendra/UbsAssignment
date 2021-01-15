package com.ubs.assignment.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ubs.assignment.controllers.ServiceController;
import com.ubs.assignment.model.PrimeGenerator;
import com.ubs.assignment.servicesImpl.PrimeService;
import com.ubs.assignment.servicesImpl.PrimeServiceResponse;


@ContextConfiguration(classes = {ServiceController.class, 
		PrimeServiceResponse.class, PrimeService.class, PrimeGenerator.class})
@WebMvcTest
public class TestServiceCont {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	 @Autowired
	 private PrimeServiceResponse psr;
	
	@Test
	public void testGetPrimeJson() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/primes/10").accept(MediaType.APPLICATION_JSON));
        String resultDOW = result.andReturn().getResponse().getContentAsString();
        assertNotNull(resultDOW);
        psr.setInitial(10);
        psr.setResList(Arrays.asList(2,3,5,7));
        
        ObjectMapper om = new ObjectMapper();
        String expRes = om.writeValueAsString(psr);
        
        assertEquals(expRes, resultDOW);
		
	}
	
	@Test
	public void testGetPrimeXML() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/primes/10").accept(MediaType.APPLICATION_XML));
        String resultDOW = result.andReturn().getResponse().getContentAsString();
        assertNotNull(resultDOW);
        psr.setInitial(10);
        psr.setResList(Arrays.asList(2,3,5,7));
        
        XmlMapper om = new XmlMapper();
        String expRes = om.writeValueAsString(psr);
        
        assertEquals(expRes, resultDOW);
		
	}

}
