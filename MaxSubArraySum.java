import java.io.*;
import java.math.*; 
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {        
        
        
        int result[] = new int[2];

        int sum= arr[0];
		int max=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if (sum+arr[i] > arr[i])
				sum += arr[i];
			else sum = arr[i];
            
			max = Math.max(max, sum);
		}
		
		result[0] = max;
				
		int seqCount = 1<<arr.length;
		
		max = arr[0];
		
		for(int i=1;i<seqCount;i++) {
			sum = 0;
			for (int j = 0; j < arr.length; j++) {
                
				 if (!(BigInteger.valueOf(i).testBit(j)))
                     continue;
                 else 
                    sum += arr[j];
			} 
			max = Math.max(max, sum);
		}
			result[1] = max;
			
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

