

import java.util.Iterator;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		if (list == null) {
			return;
		} else if (list.isEmpty()) {
			list.add(value);
			return;
		} else {
			Iterator<Integer> iterator = list.iterator();
			int index = 0;
			
			while (iterator.hasNext()) {
				if (iterator.next() <= value) {
					index++;
				} else {
					break;
				}
			}
			
			list.add(index, value);
			return;
		}
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		if ((list == null) || (N < 0)) {
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (list.isEmpty()) {
					return;
				} else { 
					Iterator<String> iterator = list.iterator();
					String largest = list.getFirst();
					String current;
					while (iterator.hasNext()) {
						current = iterator.next();
						if (current.compareTo(largest) > 0) {
							largest = current;
						}
					}

					while (list.contains(largest)) {
						list.remove(largest);
					}
				}
				
			}
		}
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		if ((one == null) || (two == null) || (one.isEmpty()) || (two.isEmpty())) {
			return false;
		} else {
			Iterator<Integer> oneIterator = one.iterator();
			int currSub = two.getFirst();
			int index = 0;
			while (oneIterator.hasNext()) {
				if (oneIterator.next() == currSub) {
					index++;
					if (index == two.size()) {
						// End of substring - return true
						return true;
					} else {
						currSub = two.get(index);
					}
				} else {
					currSub = two.getFirst();
					index = 0;
				}
			}
			return false;
		}
	}
}
