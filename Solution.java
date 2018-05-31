import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
        public static String encryption(String s){
    		String r = s.replaceAll("\\s","");
		int l=r.length();
		int rows = (int)Math.floor(Math.sqrt(l));
		int cols = (int)Math.ceil(Math.sqrt(l));
		char ch [][]=new char[rows+1][cols];

		int ci=0;

		String f="";
		mainLoop:
		for(int i=0;i<rows+1;i++){
			for(int j=0;j<cols;j++){
				if(ci!=l)
					ch[i][j]=r.charAt(ci++);
				else
					break mainLoop;
			}
		}
        
		for(int i=0;i<cols;){
			for(int j=0;j<rows+1;j++){
				if(ch[j][i] != '\0')
					f=f+ch[j][i];
                else break;
			}
			f=f+" ";
			i++;
		}
		
		return f;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}