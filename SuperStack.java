package com.producer.consumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SuperStack {

	private Stack<Integer> stack;
	
	public SuperStack() {
		this.stack = new Stack<>();
	}
	/*Push the Element to the Stack*/
	private Integer push(int value) {
		
		stack.push(value);
		
		return value;
	}
	/*Pop the top of the Element from the Stack*/
	private String pop() {
		stack.pop();
		
		if(!stack.isEmpty())
				return String.valueOf(stack.peek());
		else 
			return "EMPTY"; 
	}
	
	/*Increment Stack from bottom to totalElements by value*/
	private Integer increment(int totalElements, int value) {
 		
		for(int i=0;i<totalElements;i++)
			stack.set(i,stack.get(i)+value);
		
		return stack.peek();
	}
	
	private void processInputs(BufferedReader br) throws Exception {
		
		int totalOpertion = Integer.parseInt(br.readLine());
		
		for(int i=0;i<totalOpertion;i++) {
			
			String instruction = br.readLine();
			
			if(instruction.startsWith("push")) {
				String splitInput[] =  instruction.split(" ");
				Integer value = Integer.parseInt(splitInput[1]);
				System.out.println( push(value));
			}
			else if(instruction.startsWith("pop")) {
				
				if(stack.isEmpty()) {
					System.out.println("EMPTY");
				}
				else {
					System.out.println(pop());
				}
			}
			else {
				String splitInstuctions [] = instruction.split("\\s");
				
				Integer bottomDepth = Integer.parseInt(splitInstuctions[1]);
				Integer value = Integer.parseInt(splitInstuctions[2]);
				
				System.out.println(increment(bottomDepth, value));
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		SuperStack stack = new SuperStack();
		
		stack.processInputs(sc);
	}

}
