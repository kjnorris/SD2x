import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class GraphUtilsTest {

	@Test
	public void testMinDistance() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		assertEquals(GraphUtils.minDistance(g, "7", "8"), 1);
		assertEquals(GraphUtils.minDistance(g, "0", "1"), 1);
		assertEquals(GraphUtils.minDistance(g, "0", "4"), 2);
		assertEquals(GraphUtils.minDistance(g, "0", "6"), 3);
		assertEquals(GraphUtils.minDistance(g, "0", "8"), -1);
	}
	@Test
	public void testMinDistanceNull() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		assertEquals(GraphUtils.minDistance(null, "0", "8"), -1);
		assertEquals(GraphUtils.minDistance(g, null, "8"), -1);
		assertEquals(GraphUtils.minDistance(g, "0", null), -1);
	}
	
	@Test
	public void testMinDistanceInvalid() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		assertEquals(GraphUtils.minDistance(g, "10", "8"), -1);
		assertEquals(GraphUtils.minDistance(g, "0", "9"), -1);
	}

	@Test
	public void testNodesWithinDistanceNull() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		assertNull(GraphUtils.nodesWithinDistance(g, "0", 0));
		assertNull(GraphUtils.nodesWithinDistance(g, null, 1));
		assertNull(GraphUtils.nodesWithinDistance(null, "0", 0));
		assertNull(GraphUtils.nodesWithinDistance(g, "0", -1));
	}
	
	@Test
	public void testNodesWithinDistance() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		
		Set<String> closeEnough1 = new HashSet<String>(Arrays.asList("8"));
		assertEquals(GraphUtils.nodesWithinDistance(g, "7", 1), closeEnough1);
		Set<String> closeEnough2 = new HashSet<String>(Arrays.asList("1", "2", "3", "5"));
		assertEquals(GraphUtils.nodesWithinDistance(g, "0", 1), closeEnough2);
		Set<String> closeEnough3 = new HashSet<String>(Arrays.asList("1", "2", "3", "5", "4"));
		assertEquals(GraphUtils.nodesWithinDistance(g, "0", 2), closeEnough3);
	}

	@Test
	public void testIsHamiltonianPathNull() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		
		assertFalse(GraphUtils.isHamiltonianPath(g, null));
		
		List<String> path1 = new ArrayList<String>(Arrays.asList("7", "8", "7"));
		assertFalse(GraphUtils.isHamiltonianPath(null, path1));
		
	}
	
	@Test
	public void testIsHamiltonianPath() {
		Graph g = GraphBuilder.buildUndirectedGraph("graph_builder_test2.txt");
		List<String> path1 = new ArrayList<String>(Arrays.asList("7", "8", "7"));
		assertTrue(GraphUtils.isHamiltonianPath(g, path1));
		
		List<String> path2 = new ArrayList<String>(Arrays.asList("7", "8"));
		assertFalse(GraphUtils.isHamiltonianPath(g, path2));
		
		List<String> path3 = new ArrayList<String>(Arrays.asList("0", "1", "0"));
		assertFalse(GraphUtils.isHamiltonianPath(g, path3));
		
		List<String> path4 = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "7", "0"));
		assertFalse(GraphUtils.isHamiltonianPath(g, path4));
		
		List<String> path5 = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "0"));
		assertTrue(GraphUtils.isHamiltonianPath(g, path5));
		
		Graph g2 = GraphBuilder.buildDirectedGraph("graph_builder_test2.txt");
		List<String> path6 = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "0"));
		assertTrue(GraphUtils.isHamiltonianPath(g, path6));
	}
	

}
