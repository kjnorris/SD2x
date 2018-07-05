import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		Scanner s= new Scanner(System.in);
		char myChoice;
		
		System.out.println("This program can show you the number of books published in a year or the books written by an author.");
		System.out.println("Enter 'a' to view books published by an author.");
		System.out.println("Enter 'y' to view the number of books published in a year.");
		System.out.print("Your choice? (a or y):");
		myChoice = s.next().charAt(0);
		
		if (myChoice == 'a') {
			System.out.print("Which author? ");
			String author = s.next();
			showBookTitlesByAuthor(author);
		} else if(myChoice == 'y') {
			System.out.print("What year? ");
			String thisYear = s.next();
			showNumberOfBooksInYear(Integer.parseInt(thisYear));
		} else {
			System.out.println("I'm sorry, I don't understand that choice. Please try again.");
		}
	}
	
	public void showNumberOfBooksInYear(int year) {
		int numBooks = logicTier.findNumberOfBooksInYear(year);
		System.out.println("In " + year + " there were " + numBooks + " published.");
	}
	
	public void showBookTitlesByAuthor(String author) {
		List<String> byAuthor = logicTier.findBookTitlesByAuthor(author);
		String fullName = logicTier.findAuthor(author);
		System.out.println(fullName + " has written:");
		for (String curr: byAuthor) {
			System.out.println(curr);
		}
	}
	

}
