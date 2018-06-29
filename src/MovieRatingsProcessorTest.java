import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Test;

public class MovieRatingsProcessorTest {

	@Test
	public void testRemoveAllRatingsBelow() {
		TreeMap<String, PriorityQueue<Integer>> movieRatings = new TreeMap<String, PriorityQueue<Integer>>();
		TreeMap<String, Integer> testRes = new TreeMap<String, Integer>();
		PriorityQueue<Integer> ratings = new PriorityQueue<Integer>();
		ratings.add(5);
		ratings.add(6);
		ratings.add(3);
		movieRatings.put("Test", ratings);
		testRes.put("Test", 3);
		assertEquals(MovieRatingsProcessor.removeAllRatingsBelow(movieRatings, 10), testRes);
	}

}
