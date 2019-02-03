package com.producer.consumer;

import java.util.Scanner;

public class ClosestGift {
	
	public ClosestGift() {
		// TODO Auto-generated constructor stub
	}
	
	boolean isPrime(long number) {
		
		for(long i=2;i<Math.sqrt(number);i++)
			if(number % i == 0)
				return false;
		
		return true;
	}
	
	long getNearestNumber(long number) {
		
		int counter = 0;
		
		while(!isPrime(number)) {
			counter++;
			number++;
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long input = scanner.nextLong();
		ClosestGift ref = new ClosestGift();
		
		System.out.println("Closest Number: "+ref.getNearestNumber(input));
		scanner.close();
	}

}
