package problem6;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Driver {
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		Scanner scan = new Scanner(System.in);
		String name = null;
		int vcount = 0;
		while(true) {
			System.out.println("Enter a name or type quit to terminate the program: ");
			name = scan.nextLine();
			if(name.equalsIgnoreCase("quit")) break;
			else if(!name.isEmpty()) {
				vcount = vowelCount(name.toLowerCase());
				map.put(name, vcount);
			}
		}
		
		scan.close();
		
		if(!map.isEmpty()) {
			for(Entry<String, Integer> node : map.entrySet()) {
				System.out.println("name: "+node.getKey()+"; vowel count: "+node.getValue());
			}
		}
	}
	
	public static int vowelCount(String name) {
		int vowelcount = 0;
		for(int i = 0; i<name.length(); i++) {
			if(name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i' || name.charAt(i) == 'o' || name.charAt(i) == 'u') {
				vowelcount++;
			}
		}
		return vowelcount;
	}
}
