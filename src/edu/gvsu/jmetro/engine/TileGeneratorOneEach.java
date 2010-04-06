package edu.gvsu.jmetro.engine;

import java.util.List;

/****************************************************************
 * 
 * Initialize one of each type of tile in a standard Metro game.
 * 
 * @author Zachary Kurmas
 * 
 ****************************************************************/
// (C) 2010 Zachary Kurmas
// Created Feb 12, 2010
public class TileGeneratorOneEach extends TileGenerator
{
	@Override
	public int size()
	{
		return 24;
	}

	@Override
	public void initializeTiles(List<? extends Connectable> list)
	{
		// Group 1

		initializeMultiples("SWNE", 1, list, 0); // "#" shaped
		initializeMultiples("NESW", 1, list, 1); // four loops
		initializeMultiples("WNES", 1, list, 2); // four corners
		initializeMultiples("ESWN", 1, list, 3); // big arcs

		initializeMultiples("SWEN", 1, list, 4); // lines NE and arcs WS
		initializeMultiples("SNWE", 1, list, 5); // lines NW and arcs SE
		initializeMultiples("WSNE", 1, list, 6); // lines SE and arcs NW
		initializeMultiples("EWNS", 1, list, 7); // lines SW and arcs NE

		// Group 2

		initializeMultiples("NSWE", 1, list, 8); // loop N big arcs;
		initializeMultiples("SEWN", 1, list, 9); // loop E big arcs;
		initializeMultiples("EWSN", 1, list, 10); // loop S big arcs;
		initializeMultiples("ESNW", 1, list, 11); // loop W big arcs;

		initializeMultiples("NWES", 1, list, 12); // loop N small arcs;
		initializeMultiples("WENS", 1, list, 13); // loop E small arcs;
		initializeMultiples("WNSE", 1, list, 14); // loop S small arcs;
		initializeMultiples("SNEW", 1, list, 15); // loop W small arcs;

		// Group 3

		initializeMultiples("WSEN", 1, list, 16); // parallel arcs NW / SE
		initializeMultiples("ENWS", 1, list, 17); // parallel arcs NE / SW

		initializeMultiples("SENW", 1, list, 18); // lines NS and loops EW
		initializeMultiples("NWSE", 1, list, 19); // lines EW and loops NS

		initializeMultiples("WESN", 1, list, 20); // arcs NW loops SE
		initializeMultiples("NEWS", 1, list, 21); // arcs SE loops NW
		initializeMultiples("NSEW", 1, list, 22); // arcs SW loops NE
		initializeMultiples("ENSW", 1, list, 23); // arcs NE loops SW

	}

}
