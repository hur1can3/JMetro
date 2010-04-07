package edu.gvsu.jmetro.engine;

import java.util.Stack;

public class AllRoutes<Station> {

	private Stack<String> path = new Stack<String>(); // the current path
	private SET<String> onPath = new SET<String>(); // the set of vertices on

	// the path

	public AllRoutes(Graph G, String s, String t) {
		enumerate(G, s, t);
	}

	// use DFS
	private void enumerate(Graph G, String v, String t) {

		// add node v to current path from s
		path.push(v);
		onPath.add(v);

		// found path from s to t - currently prints in reverse order because of
		// stack
		if (v.equals(t))
			System.out.println(path);

		// consider all neighbors that would continue path with repeating a node
		else {
			for (String w : G.adjacentTo(v)) {
				if (!onPath.contains(w))
					enumerate(G, w, t);
			}
		}

		// done exploring from v, so remove from path
		path.pop();
		onPath.remove(v);
	}

	public static void main(String[] args) {
		Graph G = new Graph();
		G.addVertex("1");
		G.addVertex("2");
		G.addVertex("3");
		G.addVertex("4");
		G.addVertex("5");
		G.addVertex("6");
		G.addEdge("1", "");
		G.addEdge("2", "C");
		G.addEdge("C", "D");
		G.addEdge("D", "E");
		G.addEdge("C", "F");
		G.addEdge("B", "F");
		G.addEdge("F", "D");
		G.addEdge("D", "G");
		G.addEdge("E", "G");
		System.out.println(G);
		AllRoutes allroutes1 = new AllRoutes(G, "A", "G");
		System.out.println();
		AllRoutes allroutes2 = new AllRoutes(G, "B", "F");
	}

}
