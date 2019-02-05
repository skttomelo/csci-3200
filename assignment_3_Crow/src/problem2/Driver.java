package problem2;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		CircularLinkedList<Integer> People = new CircularLinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		int amount, amount1; //will be used to determine the amount of people playing, and the amount of passes that will be done each round
		System.out.println("How many people are playing?");
		amount = scan.nextInt();
		for(int i = 1; i < amount+1; i++){
			People.add(i);
		}
		System.out.println("How many passes are to be done each round?");
		amount1 = scan.nextInt();
		for(int i = 1; i < amount; i++){
			People.pass(amount1);
		}
		System.out.println("Player "+People.get(0)+" wins!");
	}
}
