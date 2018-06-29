/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> alphaList = new ArrayList<String>();
		
		if ((movieRatings == null) || (movieRatings.isEmpty())) {
			return alphaList;
		} else {
			Set<String> titles = movieRatings.keySet();

			for (String title: titles) {
				alphaList.add(title);
			}
		}
		
		return alphaList;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> alphaList = new ArrayList<String>();

		if ((movieRatings == null) || (movieRatings.isEmpty())) {
			return alphaList;
		} else {
			Set<String> titles = movieRatings.keySet();

			for (String title: titles) {
				PriorityQueue<Integer> currRating = movieRatings.get(title);
				if (currRating.peek() > rating) {
					alphaList.add(title);
				}
			}
		}

		return alphaList;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, Integer> removed = new TreeMap<String, Integer>();
		ArrayList<String> emptyReviews = new ArrayList<String>();
		
		if ((movieRatings == null) || (movieRatings.isEmpty())) {
			return removed;
		} else {
			for (String title: movieRatings.keySet()) {
				PriorityQueue<Integer> currRating = movieRatings.get(title);
				int ratingsRemoved = 0;
				
				while ((!currRating.isEmpty()) && (currRating.peek() < rating)) {
					int lostRating = currRating.poll();
					ratingsRemoved++;
				}
				
				if (ratingsRemoved > 0) {
					removed.put(title, ratingsRemoved);
					movieRatings.replace(title, currRating);
					if (movieRatings.get(title).isEmpty()) {
						emptyReviews.add(title);
					} 
				}
			}
			
			for (String title: emptyReviews) {
				movieRatings.remove(title);
			}
			
			return removed;
		}
	}
}
