

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		// If the graph, src, or dest are null, return -1
		if ((graph == null) || (src == null) || (dest == null)) {
			return -1;
		}

		// return breadth first search count
		BreadthFirstSearch bfsG = new BreadthFirstSearch(graph);
		int distance = bfsG.distance(graph.getNode(src), dest);
		return distance;
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if ((graph == null) || (distance < 1) || (src == null)) return null;
		
		BreadthFirstSearch bfsG = new BreadthFirstSearch(graph);
		Set<String> close = bfsG.withinDistance(graph.getNode(src), distance);
		return close;
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if ((g == null) || (values == null) || (values.isEmpty())) return false;
		
		// False if first and last elements are not the same
		if (values.get(0) != values.get(values.size()-1)) return false;
		
		BreadthFirstSearch bfsG = new BreadthFirstSearch(g);
		Set<String> allMarked = bfsG.markAll(g.getNode(values.get(0)));
		
		// False if not all nodes reachable in List
		for (String node: allMarked) {
			if (!values.contains(node)) {
				return false;
			}
		}
		
		String parent = values.get(0);
		String current;
		
		for (int i = 1; i < values.size(); i++) {
			current = values.get(i);
			if (!g.getNodeNeighbors(g.getNode(parent)).contains(g.getNode(current))) {
				return false;
			}
			parent = values.get(i);
		}
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
