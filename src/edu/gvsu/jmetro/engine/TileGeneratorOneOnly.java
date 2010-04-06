package edu.gvsu.jmetro.engine;

import java.util.List;

/****************************************************************
 * Initialize a {@code List} of tiles to the came configuration
 * 
 * @author Zachary Kurmas
 * 
 ****************************************************************/
// (C) 2010 Zachary Kurmas
// Created Feb 23, 2010
public class TileGeneratorOneOnly extends TileGenerator
{

	private String type;

	/**************************************************************************
	 * Constructor
	 * 
	 * @param description
	 *            description of how tiles are to be initialized.
	 ************************************************************************* */
	public TileGeneratorOneOnly(String description) {
		type = description;

	}

	/**
	 * This generator initializes as many tiles as it is given.
	 */
	public int size()
	{
		return TileGeneratorOneOnly.FLEXIBLE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.metro.TileGenerator#generateTiles(java.util.Collection)
	 */
	@Override
	public void initializeTiles(List<? extends Connectable> list)
	{
		initializeMultiples(type, list.size(), list, 0);
	}

}
