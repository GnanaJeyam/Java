package com.producer.consumer;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		int temp = 0;
		
		while(input>0) {
			temp = temp * 10 + (input%10);
			input /= 10;
		}
		
		System.out.println("Reversed Number: "+temp);
		scanner.close();
	}

}
