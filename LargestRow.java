package com.producer.consumer;
import java.io.*;
import java.util.*;

public class LargestRow {

	/* Read input from STDIN. Print your output to STDOUT*/
		
	  static boolean checkEqual(int a[]) {
		  
		  int iv = a[0];
		  
		  for(int i=1;i<a.length; i++) {
			  
			  if(a[i] != iv)
				  return false;
			  iv = a[i];
		  }
		  
		  return true;
	  }
	
	   public static void main(String args[] ) throws Exception {
		   
		   Scanner sc = new Scanner(System.in);
		   
		   int r = sc.nextInt();
		   
		   int c = sc.nextInt();
		   
		   int rc[] = new int[r];
		   
		   int a[][] = new int[r][c];
		   
		   int totalSum = 0;
		   int rI = 0;
		   for(int i=0;i<r;i++) {
			   int counter = 0;
			   for(int j=0;j<c;j++) {
				   
				   a[i][j]= sc.nextInt();
				   counter += a[i][j];
				   
			   }
			   rc[i] = counter;
			   if(counter > totalSum) {
				   totalSum = counter;
				   rI = i;
			   }
		   }
		   
		   if(checkEqual(rc))
			   System.out.println("Equal");
		   else System.out.println("Row "+rI);
		   
		   sc.close();
	   }
}

