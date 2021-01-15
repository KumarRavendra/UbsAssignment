package com.ubs.assignment.cache;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CacheMgr {
	

	public List<Integer> fetchFromCache(int initial) {	
	
		if(CacheImpl.getCurr_init() >= initial && !CacheImpl.getCachedSet().isEmpty()) {
			return CacheImpl.getCachedSet().subSet(2,initial+1).stream().collect(Collectors.toList());
		}
		return CacheImpl.getCachedSet().stream().collect(Collectors.toList());
	}

	public void putInCache(List<Integer> numbers, int initial) {
	
		if(CacheImpl.getCachedSet().size() > 100000)return;
		CacheImpl.setCachedSet(new TreeSet<Integer>(numbers));
		CacheImpl.setCurr_init(initial);
		
	}

	public int getCurrInitFromCache() {
		
		return CacheImpl.getCurr_init();
	}

}
