package com.example;

import java.util.Scanner;

public class MenuSpecifier {
	
	static boolean isPalindrome(String s){
		
		if(s.length()<=1)
			return true;
		
		return s.charAt(0)==s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1));
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
		long st=System.nanoTime();
		for( int o=0;o<input;o++) {
			String s = in.next();
			int c=0;
			String l="",pa=s.charAt(0)+"";
			for(int i=0;i<s.length();i++){
				for(int j=i+1;j<s.length();j++){
					l=s.substring(i,j+1);
					if(isPalindrome(l)){
						if(l.length()>c){
							c=l.length();
							pa=l;
						}
					}
				}
			}
			System.out.println(pa);
		}
		in.close();
		//12132732781
		StringBuffer csa;
		System.out.println(System.nanoTime()-st);
	}
}			
