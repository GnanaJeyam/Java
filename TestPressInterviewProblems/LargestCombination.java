package com.producer.consumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestCombination {
	
	static class CompareByOrder implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			
			String X=o1+o2;
			String Y=o2+o1;			
			
			return Y.compareTo(X);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s[] = new String[n];
		
		String listIntegers = br.readLine();
		
		int i = 0;
		
		for (String t : listIntegers.split("\\s")) {
			s[i++] = t;
		}
		
		
		Collections.sort(Arrays.asList(s), new CompareByOrder());
		System.out.print("Largest Number: ");
		for(String t:s)
			System.out.print(t);
	}

}
