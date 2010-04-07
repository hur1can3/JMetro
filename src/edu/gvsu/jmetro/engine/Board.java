package edu.gvsu.jmetro.engine;

public class Board {

	/**
	 * a boolean flag to check for the pathfinder
	 */
	private boolean[][] visited = new boolean[10][10];

	private Cell[][] board;

	/**
	 * Clear the array marking which tiles have been visted by the path finder.
	 */
	public void clearVisited() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				visited[x][y] = false;
			}
		}
	}

	/**
	 * @see TileBasedMap#visited(int, int)
	 */
	public boolean visited(int x, int y) {
		return visited[x][y];
	}

	/**
	 * @see TileBasedMap#getCost(Mover, int, int, int, int)
	 */
	public float getCost(Mover mover, int sx, int sy, int tx, int ty) {
		return 1;
	}

	/**
	 * @see TileBasedMap#pathFinderVisited(int, int)
	 */
	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}

}
