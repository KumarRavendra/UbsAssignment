package com.ubs.assignment.IntegrationTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubs.assignment.controllers.ServiceController;

@SpringBootTest
public class TestingContext {
	
	@Autowired
	private ServiceController sc;

	@Test
	void contextLoads() {
		assertThat(sc).isNotNull();
	}

}
