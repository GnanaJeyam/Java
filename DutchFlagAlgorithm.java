package existingProject;

import java.util.Arrays;

public class DutchFlagAlgorithm {
	
	public static void main(String[] args) {
		/* 
		 * Segregate O,1 and 2.
		 * I/P : [0,1,0,2,1,2,0,1,0]
		 * O/P : [0,0,0,0,1,1,1,2,2]
		 */
		
		int a[] = {0,1,0,2,1,2,0,1,0};
		int li=0, mi=0, hi=a.length-1;
		while(mi <= hi) {
				switch (a[mi]) {
					case 0:
						int t = a[li];
						a[li] = a[mi];
						a[mi] = t;
						li++;mi++;
						break;
					case 1:
						mi++;
						break;
					case 2:
						int t1 = a[mi];
						a[mi] = a[hi];
						a[hi] = t1;
						hi--;
						break;
				}
				
			}
		
		System.out.println(Arrays.toString(a));
	
	}
}
