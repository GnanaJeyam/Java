package com.producer.consumer;

import java.util.Scanner;
/*Counting Pairs*/
public class CountingPairs {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		int array[] = new int[length];
		
		for(int i=0;i<length;i++)
			array[i] = sc.nextInt();
		
		int difference = sc.nextInt();
		
		int s=0,e=s+1;
		
		while(e<length) {
			
			if(array[s]!=array[e]) {
				if(Math.abs(array[s]-array[e])==difference) {
					System.out.println(array[s]+","+array[e]);
				}
				s++;e++;
			}
			else {s++;e++;}
		}
		
		sc.close();
	}
}
