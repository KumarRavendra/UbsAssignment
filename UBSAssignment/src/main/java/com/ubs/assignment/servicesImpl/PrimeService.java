package com.ubs.assignment.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubs.assignment.interfaces.Services;
import com.ubs.assignment.model.PrimeGenerator;


@Component
public class PrimeService implements Services{
	
	@Autowired
	PrimeServiceResponse res;
	@Autowired
	PrimeGenerator primeGen;
	
	public Integer getInitial() {
		return initial;
	}

	public void setInitial(Integer initial) {
		this.initial = initial;
	}

	private Integer initial;

	@Override	
	public PrimeServiceResponse serve(Optional<Object> param) {
		this.setInitial((Integer)param.orElse(0));
		res.setInitial(this.getInitial());
		res.setResList(primeGen.getPrimeNumbers(this.getInitial()));
		return res;
	}
	
}
