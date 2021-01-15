package com.ubs.assignment.IntegrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.ubs.assignment.servicesImpl.PrimeServiceResponse;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port ;
	
	@Autowired
	private TestRestTemplate restTemp;
	
	@Autowired
	private PrimeServiceResponse exp,res;
	
	@Test
	public void testingTheHttpRequest() throws Exception {
		
		exp.setInitial(7);
		exp.setResList(Arrays.asList(2,3,5,7));
		res = this.restTemp.getForObject("http://localhost:"+port+"/primes/7", PrimeServiceResponse.class);
		 assertEquals(exp.getInitial(),res.getInitial());
		 assertEquals(exp.getResList(),res.getResList());
	}
}
