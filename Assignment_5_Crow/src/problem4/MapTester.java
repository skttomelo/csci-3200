package problem4;

public class MapTester {
	public static void main(String[] args) {
		Map<String, String> StringMap = new Map<>();
		
		System.out.println("Currently, StringMap empty status is: " + StringMap.isEmpty());
		StringMap.put("mal", "com");
		StringMap.put("Richard", "comstock");
		StringMap.put("Luis", "Regis");
		StringMap.put("X", "XX");
		StringMap.put("Ten", "Tacion");
		System.out.println("After inserting 5 things into StringMap the empty status has now become " + StringMap.isEmpty());
		System.out.println("Using the key mal returns the following: " + StringMap.get("mal"));
		System.out.println("Using other keys like X return " + StringMap.get("X"));
		StringMap.makeEmpty();
		System.out.println("String Map has been now made empty with its status showing " + StringMap.isEmpty());
		System.out.println("Using other keys like X return: " + StringMap.get("X"));
	}
}
