package assignment1;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingData {

	public static void main(String[] args) throws FileNotFoundException {

		/* read from user */
		System.out.println("Read from user:");
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter you age: ");
		int age = scan.nextInt();

		System.out.println("You entered "+age+" as your age.");

		/* read from a file */
		System.out.println("Read from file:");
		Scanner file = new Scanner(new File("random100.txt"));
		while(file.hasNext())
		{
			System.out.println(file.next());
		}

	}

}
