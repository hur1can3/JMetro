package edu.gvsu.jmetro.engine;

import java.util.List;

/****************************************************************
 * Intialize a {@code List} of 60 {@code Connectable} object to represent a
 * standard Metro game.
 * 
 * @author Zachary Kurmas
 * 
 ****************************************************************/
// (C) 2010 Zachary Kurmas
// Created Feb 12, 2010
public class TileGeneratorStandardGame extends TileGenerator
{
	@Override
	public int size()
	{
		return 60;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.metro.TileGenerator#generateTiles(java.util.Collection)
	 */
	@Override
	public void initializeTiles(List<? extends Connectable> list)
	{

		// Group 1

		initializeMultiples("SWNE", 4, list, 0); // "#" shaped
		initializeMultiples("NESW", 2, list, 4); // four loops
		initializeMultiples("WNES", 2, list, 6); // four corners
		initializeMultiples("ESWN", 2, list, 8); // big arcs

		initializeMultiples("SWEN", 4, list, 10); // lines NE and arcs WS
		initializeMultiples("SNWE", 4, list, 14); // lines NW and arcs SE
		initializeMultiples("WSNE", 4, list, 28); // lines SE and arcs NW
		initializeMultiples("EWNS", 4, list, 22); // lines SW and arcs NE

		// Group 2

		initializeMultiples("NSWE", 2, list, 26); // loop N big arcs;
		initializeMultiples("SEWN", 2, list, 28); // loop E big arcs;
		initializeMultiples("EWSN", 2, list, 30); // loop S big arcs;
		initializeMultiples("ESNW", 2, list, 32); // loop W big arcs;

		initializeMultiples("NWES", 2, list, 34); // loop N small arcs;
		initializeMultiples("WENS", 2, list, 36); // loop E small arcs;
		initializeMultiples("WNSE", 2, list, 38); // loop S small arcs;
		initializeMultiples("SNEW", 2, list, 40); // loop W small arcs;

		// Group 3

		initializeMultiples("WSEN", 3, list, 42); // parallel arcs NW / SE
		initializeMultiples("ENWS", 3, list, 45); // parallel arcs NE / SW

		initializeMultiples("SENW", 2, list, 48); // lines NS and loops EW
		initializeMultiples("NWSE", 2, list, 50); // lines EW and loops NS

		initializeMultiples("WESN", 2, list, 52); // arcs NW loops SE
		initializeMultiples("NEWS", 2, list, 54); // arcs SE loops NW
		initializeMultiples("NSEW", 2, list, 56); // arcs SW loops NE
		initializeMultiples("ENSW", 2, list, 58); // arcs NE loops SW
	}

}
