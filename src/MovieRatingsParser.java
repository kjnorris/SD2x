/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String, PriorityQueue<Integer>> movieMap = new TreeMap<String, PriorityQueue<Integer>>();
	
		if (allUsersRatings != null) {
			for (UserMovieRating rating: allUsersRatings) {
				PriorityQueue<Integer> ratings = new PriorityQueue<Integer>();
				
				try {
					String name = rating.getMovie().toLowerCase();
					int thisRating = rating.getUserRating();
					
					if (!name.isEmpty() && (thisRating >= 0)) {
						if (!movieMap.containsKey(name))  {
							ratings.add(thisRating);
							movieMap.put(name, ratings);
						} else {
							ratings = movieMap.get(name);
							ratings.add(thisRating);
							movieMap.replace(name, ratings);
						}
					}
				} catch (NullPointerException e) {
					// Do nothing
					continue;
				}
			}
		}

		return movieMap; // this line is here only so this code will compile if you don't modify it
	}

}
