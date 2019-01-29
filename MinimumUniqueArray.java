package com.producer.consumer;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumUniqueArray {
	
	/*
	 * @arr -> Sorted Integer Array ( arr[] ).
	 * @return -> minimum Sum of Unique Integer Array.
	 * */
	int getMinimumUniqueSum (int arr[]) {
		
		for(int i=0;i<arr.length-1;i++) {
			
			if(arr[i]==arr[i+1]) {
				int j=i+1;
				while(i<arr.length && j<arr.length && arr[i]==arr[j]) {
					
					arr[j] = arr[i]+1;
					j++;
				}
			}
		}
		
		int totalSum = 0;
		
		for(int p:arr)
			totalSum += p;

		return totalSum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int testArray []  = new int[length];
		
		for(int i=0;i<length;i++)
			testArray[i] = sc.nextInt();
		
		// Sorting the Array.
		Arrays.sort(testArray);
		
		System.out.println( " Total Sum: " +new MinimumUniqueArray().getMinimumUniqueSum(testArray));
		
		sc.close();
	}

}
