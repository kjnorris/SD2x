import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks() throws IOException {
		List<Book> allBooks = new ArrayList<Book>();
		
		FileInputStream fstream = new FileInputStream(this.fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		while ((strLine = br.readLine()) != null)   {
			String[] elems = strLine.split("\t");
			elems[0] = elems[0].replaceAll("\"|#", "");
			elems[1] = elems[1].replaceAll("\"|#", "");
			Book curr = new Book(elems[0], elems[1], Integer.parseInt(elems[2]));
			allBooks.add(curr);
		}
		br.close();
		
		return allBooks;
	}

}
