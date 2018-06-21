import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class LinkedListUtilsTest {

	@Test
	public void testInsertSorted() {
		// Add in the middle of the list
		LinkedList<Integer> baseList = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9));
		LinkedList<Integer> testList = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 4, 6, 6, 7, 8, 9));
		assertNotEquals(testList, baseList);
		LinkedListUtils.insertSorted(testList, 5);
		assertEquals(testList, baseList);
		
		// Add at the end of the list
		LinkedList<Integer> baseList2 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		LinkedList<Integer> testList2 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		assertNotEquals(testList2, baseList2);
		LinkedListUtils.insertSorted(testList2, 10);
		assertEquals(testList2, baseList2);
		
		// Add at the front of the list
		LinkedList<Integer> baseList3 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		LinkedList<Integer> testList3 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		assertNotEquals(testList3, baseList3);
		LinkedListUtils.insertSorted(testList3, 0);
		assertEquals(testList3, baseList3);
		
		// Empty LinkedList
		LinkedList<Integer> baseList4 = new LinkedList<Integer>(Arrays.asList(5));
		LinkedList<Integer> testList4 = new LinkedList<Integer>();
		assertTrue(testList4.isEmpty());
		LinkedListUtils.insertSorted(testList4, 5);
		assertEquals(testList4, baseList4);
		
		// Null LinkedList
		LinkedList<Integer> testList5 = null;
		assertNull(testList5);
		LinkedListUtils.insertSorted(testList5, 5);
		assertNull(testList5);
	}

	@Test
	public void testRemoveMaximumValues() {
		// Null list
		LinkedList<String> testList1 = null;
		assertNull(testList1);
		LinkedListUtils.removeMaximumValues(testList1, 1);
		assertNull(testList1);
		
		// Negative number of elements
		LinkedList<String> baseList2 = new LinkedList<String>(Arrays.asList("one", "two", "three", "four"));
		LinkedList<String> testList2 = new LinkedList<String>(Arrays.asList("one", "two", "three", "four"));
		assertEquals(testList2, baseList2);
		LinkedListUtils.removeMaximumValues(testList2, -1);
		assertEquals(testList2, baseList2);
		
		// Remove largest element
		LinkedList<String> baseList3 = new LinkedList<String>(Arrays.asList("one", "two", "three", "four"));
		LinkedList<String> testList3 = new LinkedList<String>(Arrays.asList("one", "three", "four"));
		assertNotEquals(testList3, baseList3);
		LinkedListUtils.removeMaximumValues(baseList3, 1);
		assertEquals(testList3, baseList3);
		
		// Remove two largest elements
		LinkedList<String> baseList4 = new LinkedList<String>(Arrays.asList("one", "two", "three", "four"));
		LinkedList<String> testList4 = new LinkedList<String>(Arrays.asList("one", "four"));
		assertNotEquals(testList4, baseList4);
		LinkedListUtils.removeMaximumValues(baseList4, 2);
		assertEquals(testList4, baseList4);
		
		// Remove two largest elements
		LinkedList<String> baseList5 = new LinkedList<String>(Arrays.asList("one", "two", "two", "three", "two", "four", "three"));
		LinkedList<String> testList5 = new LinkedList<String>(Arrays.asList("one", "four"));
		assertNotEquals(testList5, baseList5);
		LinkedListUtils.removeMaximumValues(baseList5, 2);
		assertEquals(testList5, baseList5);
		
		// Remove more values than in list
		LinkedList<String> baseList6 = new LinkedList<String>(Arrays.asList("one", "two", "three", "four"));
		LinkedList<String> testList6 = new LinkedList<String>();
		assertNotEquals(testList6,  baseList6);
		LinkedListUtils.removeMaximumValues(baseList6, 6);
		assertEquals(testList6, baseList6);
	}

	@Test
	public void testContainsSubsequence() {
		// Check for null lists
		LinkedList<Integer> emptyList1 = new LinkedList<Integer>();
		LinkedList<Integer> realList1 = new LinkedList<Integer>(Arrays.asList(0, 1, 2));
		assertFalse(LinkedListUtils.containsSubsequence(null, realList1));
		assertFalse(LinkedListUtils.containsSubsequence(realList1, null));
		assertFalse(LinkedListUtils.containsSubsequence(emptyList1, realList1));
		assertFalse(LinkedListUtils.containsSubsequence(realList1, emptyList1));
		
		// Check for actual contained sublist
		LinkedList<Integer> mainList2 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
		LinkedList<Integer> subList2 = new LinkedList<Integer>(Arrays.asList(2, 3));
		assertTrue(LinkedListUtils.containsSubsequence(mainList2, subList2));
		
		// Check for nonexistant sublist
		LinkedList<Integer> mainList3 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
		LinkedList<Integer> subList3 = new LinkedList<Integer>(Arrays.asList(7, 8));
		assertFalse(LinkedListUtils.containsSubsequence(mainList3, subList3));
	}

}
