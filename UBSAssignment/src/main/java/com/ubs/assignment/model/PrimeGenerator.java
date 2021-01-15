package com.ubs.assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.ubs.assignment.cache.CacheMgr;

@Component
@ComponentScan(basePackages = "com.ubs.assignment.cache")
public class PrimeGenerator {

	@Autowired
	private CacheMgr cacheMgr;


	public List<Integer> getPrimeNumbers(int initial) {

		List<Integer> numbers = new ArrayList<>();
		
		if (initial < 2) {
			return numbers;
		}
		
		numbers = cacheMgr.fetchFromCache(initial);

		if (!numbers.isEmpty()) {

			int cache_curr_init = cacheMgr.getCurrInitFromCache();
			if (cache_curr_init < initial) {
				numbers.addAll(getRemainingPrimeNumber(cache_curr_init + 1, initial));
				cacheMgr.putInCache(numbers, initial);
			}

		} else {

			numbers.add(2);
			numbers.add(3);
			cacheMgr.putInCache(numbers, 3);
			if (3 < initial) {
				numbers.addAll(getRemainingPrimeNumber(5, initial));
				cacheMgr.putInCache(numbers, initial);
			} else
				numbers = (List<Integer>) numbers.stream().filter(p -> p <= initial).collect(Collectors.toList());

		}

		return numbers;
	}

	private List<Integer> getRemainingPrimeNumber(int cache_curr_init, int initial) {
		
		List<Integer> remNumber = new ArrayList<>();
		int temp = cache_curr_init;
		while (!checkPrime(temp)) {
			temp++;
		}
		if (temp == 3) {
			remNumber.add(3);
			temp = 5;
		}
		int i = ((temp - 1) % 6 == 0 ? (temp - 1) % 6 : (temp + 1) % 6);

		while ((6 * i - 1) <= initial) {

			if ((6 * i - 1) <= initial && (6 * i - 1) >= cache_curr_init && checkPrime(6 * i - 1)) {
				remNumber.add(6 * i - 1);
			}
			if ((6 * i + 1) <= initial && (6 * i + 1) >= cache_curr_init && checkPrime(6 * i + 1)) {
				remNumber.add(6 * i + 1);
			}
			i++;
		}
		
		return remNumber;
	}

	public boolean checkPrime(int i) {
		if (i % 2 == 0 || i % 3 == 0)
			return false;
		int k;
		for (k = 5; k * k <= i; k += 6) {
			if (i % k == 0 || i % (k + 2) == 0)
				return false;
		}
		return true;
	}

}
