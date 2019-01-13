import java.io.*;
// Find The Pair Sum.
class PairSum {
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a[] = new int[n];
		int c=0;
		for(String s : br.readLine().split(" ")) {
			
			a[c++] = Integer.parseInt(s);
			
		}
		
		int sum = Integer.parseInt(br.readLine());
		
		boolean pair = false;
		
		first:
		for(int i=0;i<n; i ++) {
			
			for(int j=i+1; j<n; j++) {
				
				if(a[i]+a[j] == sum) {
					
					pair = true;
					break first;
				}
			}
		}
		
		if(pair)
			System.out.println("True");
		else System.out.println("False");
	}
}