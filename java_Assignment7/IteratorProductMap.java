package com.aaslin.assignments;
import java.util.*;
public class IteratorProductMap {

	public static void main(String[] args) {
		
		Map<String,Integer> products = new HashMap<>();
		
		products.put("mobile", 25000);
		products.put("Watch", 5000);
		products.put("Earpods",1000);
		products.put("Shoes", 2500);
		products.put("Bag", 680);
		
		Iterator<Map.Entry<String, Integer>> iterator = products.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<String,Integer> entry = iterator.next();
			System.out.println(entry.getKey()+ " : "+entry.getValue());
		}
	}
}
