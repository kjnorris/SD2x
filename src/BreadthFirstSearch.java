

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}
	
	public int distance(Node start, String elementToFind) {
		if (!graph.containsNode(start)) return -1;
		if (start.getElement().equals(elementToFind)) return 0;
		
		Queue<Node> toExplore = new LinkedList<Node>();
		HashMap<Node, Integer> distanceToNode = new HashMap<Node, Integer>();
		marked.add(start);
		toExplore.add(start);
		distanceToNode.put(start, 0);
		
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return (distanceToNode.get(current)+1);
					}
					marked.add(neighbor);
					distanceToNode.put(neighbor, distanceToNode.get(current)+1);
					toExplore.add(neighbor);
				}
			}
		}
		
		return -1;
	}
	
	public Set<String> withinDistance(Node n, int distance) {
		Set<String> closeEnough = new HashSet<String>();
		
		if (!graph.containsNode(n)) return null;
		
		Queue<Node> toExplore = new LinkedList<Node>();
		HashMap<Node, Integer> distanceToNode = new HashMap<Node, Integer>();
		marked.add(n);
		toExplore.add(n);
		distanceToNode.put(n, 0);
		
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					marked.add(neighbor);
					distanceToNode.put(neighbor, distanceToNode.get(current)+1);
					toExplore.add(neighbor);
					if (distanceToNode.get(neighbor) <= distance) {
						closeEnough.add(neighbor.getElement());
					}
				}
			}
		}
		
		return closeEnough;
	}
	
	public Set<String> markAll(Node n) {
		Set<String> allMarked = new HashSet<String>();
		if (!graph.containsNode(n)) return null;
		
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(n);
		toExplore.add(n);
		allMarked.add(n.getElement());
		
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					marked.add(neighbor);
					allMarked.add(neighbor.getElement());
					toExplore.add(neighbor);
				}
			}
		}
		return allMarked;
	}
	
}
