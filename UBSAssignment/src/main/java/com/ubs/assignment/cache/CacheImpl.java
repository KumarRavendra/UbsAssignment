package com.ubs.assignment.cache;

import java.util.TreeSet;

import org.springframework.stereotype.Component;


@Component
public class CacheImpl implements ICache{
	
	private static TreeSet<Integer> cachedSet = new TreeSet<>();
	private static Integer curr_init = 0;
	
	

	public static TreeSet<Integer> getCachedSet() {
		return cachedSet;
	}

	public static void setCachedSet(TreeSet<Integer> cachedSet) {
		CacheImpl.cachedSet = cachedSet;
	}

	public static Integer getCurr_init() {
		return curr_init;
	}

	public static void setCurr_init(Integer curr_init) {
		CacheImpl.curr_init = curr_init;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
