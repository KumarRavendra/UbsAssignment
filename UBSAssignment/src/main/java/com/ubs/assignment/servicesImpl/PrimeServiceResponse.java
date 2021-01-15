package com.ubs.assignment.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubs.assignment.interfaces.ResponseObj;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Component
@ApiModel(description = "Response Model for API")
public class PrimeServiceResponse implements ResponseObj{
	
	@JsonProperty("Initial")
	@ApiModelProperty(notes="Number provided to the API")
	private Integer initial;
	@JsonProperty("Priimes")
	@ApiModelProperty(notes="List of Prime Numbers Generated")
	private List<Integer> resList = new ArrayList<>();
	
	public Integer getInitial() {
		return initial;
	}
	public void setInitial(Integer initial) {
		this.initial = initial;
	}
	public List<Integer> getResList() {
		return resList;
	}
	public void setResList(List<Integer> resList) {
		this.resList = resList;
	}
	
	
}
