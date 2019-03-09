package hackerrankproblems;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnClouds {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
 
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int a[] = c;
        int j=0;
        int s=0;
        
        while(s<a.length) {
            if(s==a.length -1)
                break;
            
            if( ((!(s+2>a.length-1)) && a[s+2]==0) ){
                s += 2;
                j++;
            }
            else {
                s++;
                j++;
            }
        }
        System.out.println(j);
        scanner.close();
    }
}
