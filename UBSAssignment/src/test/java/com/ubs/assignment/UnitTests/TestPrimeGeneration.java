package com.ubs.assignment.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubs.assignment.model.PrimeGenerator;

@SpringBootTest(classes = {com.ubs.assignment.cache.CacheMgr.class,com.ubs.assignment.cache.CacheImpl.class,com.ubs.assignment.model.PrimeGenerator.class })
public class TestPrimeGeneration {
	
	@Autowired
	private PrimeGenerator pgen;
	
	@Test
	public void genratingPrimesForZero() {
		List<Integer> expResult = new ArrayList<>();
		assertEquals(pgen.getPrimeNumbers(0),expResult);

	}
	
	@Test
	public void genratingPrimesFor5() {
		List<Integer> expResult = Arrays.asList(2,3,5);
		assertEquals(expResult,pgen.getPrimeNumbers(5));

	}
	
	@Test
	public void genratingPrimesFor2() {
		List<Integer> expResult = Arrays.asList(2);
		assertEquals(expResult,pgen.getPrimeNumbers(2));

	}
	
	@Test
	public void genratingPrimesFor3() {
		List<Integer> expResult = Arrays.asList(2,3);
		assertEquals(expResult,pgen.getPrimeNumbers(3));

	}
	
	@Test
	public void genratingPrimesFor10() {
		List<Integer> expResult = Arrays.asList(2,3,5,7);
		assertEquals(expResult,pgen.getPrimeNumbers(10));

	}
	
	@Test
	public void genratingPrimesFor100() {
		List<Integer> expResult = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
		assertEquals(expResult,pgen.getPrimeNumbers(100));

	}
	

}
