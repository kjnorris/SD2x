import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public int findNumberOfBooksInYear(int year) {
		List<Book> allBooks = getBookList();
		int booksInYear = 0;

		for (Book curr: allBooks) {
			if (curr.getPublicationYear() == year) {
				booksInYear++;
			}
		}
		
		return booksInYear;
		
	}
	
	public List<String> findBookTitlesByAuthor(String author) {
		List<Book> allBooks = getBookList();
		List<String> byAuthor = new ArrayList<String>();
		
		for (Book curr: allBooks) {
			if (curr.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				byAuthor.add(curr.getTitle());
			}
		}
		
		return byAuthor;
		
	}
	
	public List<Book> getBookList() {
		List<Book> allBooks = new ArrayList<Book>();
		
		try {
			allBooks = dataTier.getAllBooks();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBooks;
	}
	
	public String findAuthor(String author) {
		List<Book> allBooks = getBookList();
		for (Book curr: allBooks) {
			if (curr.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				return curr.getAuthor();
			}
		}
		return author;
	}
	

}
