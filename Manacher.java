package existingProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manacher {
	
	public static void main(String[] args) {
		
		String s[]= {"chennai","banglore","chennai","hyderabad","chennai"};
		Map<String, Integer> ls = new HashMap<>();
		for(String k: s) {
			if(ls.get(k) == null)
				ls.put(k,1);
			else if(ls.get(k) != null)
				ls.put(k,ls.get(k)+1);
		}
		System.out.println("String and it's occurences :");
		for(String key : ls.keySet()) {
			
			System.out.println(key+" "+ls.get(key));
			
		}
		
	}
				
}




