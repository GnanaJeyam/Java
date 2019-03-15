package hackerrankproblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {

      long l = n / s.length();

      long c = 0;

      for(char ch: s.toCharArray())
        if(ch == 'a') c++;

      c = c * l;

      long r  = n % s.length();
      
      if( r != 0)
         for(char ch: s.substring(0,(int)r).toCharArray())
              if(ch == 'a') c++;

      return c;    
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s = scanner.nextLine();

      long n = scanner.nextLong();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      long result = repeatedString(s, n);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
  }
}

