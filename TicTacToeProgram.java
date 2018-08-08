package existingProject;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeProgram {
	
	static String []box=new String[9];
	static String turn;
	public static void main(String[] args)
	{
		System.out.println("Tic-Tac-Toe Game");
		
		System.out.println("-----------------------------------------------");
		
		TicTacToeProgram m= new TicTacToeProgram();
		m.fillArray();
		m.printBoard();
	    
		turn ="X";
		
	    int input=0;
		
	    String win=null;
		
		Scanner n = new Scanner(System.in);
		System.out.println("Game Started!");
		System.out.println("Both the players, please enter the number[1-9] when your turn comes.");
		System.out.println("This is your turn "+turn);
		while(win == null){
			try{
				input = n.nextInt();
				if(!(input >0 &&input<=9)){
					System.out.println("Mismatch input");
					continue;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Please enter the valid number from 1-9");
				continue;
			}
			
			if(box[input-1].equals(String.valueOf(input))){
				
				box[input-1]= turn;
				
				if(turn.equals("X"))
					turn = "O";
				else turn ="X";
				
				m.printBoard();
				win = checkWinner();
			} 
			else {
				System.out.println("Please enter the valid number from 1-9");
			}
			
		}
		
		n.close();
		
		if(win.equals("draw")){
			System.out.println("Well Played ! The match is drawn.");
		}
		else System.out.println("Congrats! you are the winner\t"+win);
	}
	
	public static String checkWinner(){
		
		String line=null;
		
		for(int i=0;i<8;i++){
			
			switch(i){
				
				case 0:
					line=box[0]+box[1]+box[2];
					break;
				case 1:
					line=box[0]+box[3]+box[6];
					break;
				case 2:
					line=box[0]+box[4]+box[8];
					break;
				case 3:
					line = box[1]+box[4]+box[7];
					break;
				case 4:
				    line = box[2]+box[4]+box[6];
					break;
				case 5:
					line = box[2]+box[5]+box[8];
					break;
				case 6:
					line = box[3]+box[4]+box[5];
					break;
				case 7:
					line = box[6]+box[7]+box[8];
					break;
			}
			
			if(line.equals("XXX")){
				return "X";
			}
			else if(line .equals("OOO")){
				return "0";
			}
		}
			
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(box).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}
			System.out.println("This is your turn "+turn);
		
		return null;
		
	}
	
	public void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + box[0] + " | " + box[1] + " | " + box[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + box[3] + " | " + box[4] + " | " + box[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + box[6] + " | " + box[7] + " | " + box[8] + " |");
		System.out.println("/---|---|---\\");
	}
	
	public void fillArray(){
	   for(int i=0;i<box.length;i++){
		    box[i]=String.valueOf(i+1);
	    }
	}
}
