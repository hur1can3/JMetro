package edu.gvsu.jmetro.engine;

import java.util.List;

/*******************************************************************************
 * Abstract class for initializing a set of {@link projects.metro.Connectable}
 * objects.
 * 
 * @author Zachary Kurmas
 * 
 *****************************************************************************/
// (C) 2010 Zachary Kurmas
// Created Jan 21, 2010
public abstract class TileGenerator
{

	/**
	 * Indicates that this {@code TileGenerator} doesn't initialize a fixed
	 * number of tiles.
	 **/
	public static final int FLEXIBLE = -1;

	/**************************************************************************
	 * Initialize a list of tiles. The subclass implements this method to
	 * generate the desired mix of connection configurations.
	 * 
	 * @param list
	 *            the {@code List} of {@code Connectable} objects to initialize.
	 **************************************************************************/
	public abstract void initializeTiles(List<? extends Connectable> list);

	/**************************************************************************
	 * 
	 * Returns the number of tiles initialized, or {@code FLEXIBLE} if the
	 * object will initialize as many tiles as contained in the list.
	 * 
	 * @return he number of tiles initialized, or {@code FLEXIBLE} if the object
	 *         will initialize as many tiles as contained in the list.
	 **************************************************************************/
	public abstract int size();

	
	/*************************************************************************
	 * Initialize multiple copies of a {@code Connectable} in a {@code List}
	 * 
	 * @param type
	 *            A description of the connections to initialize. (See {@link
	 * @param number
	 *            the number of cells to initialize.
	 * @param bag
	 *            the {@code List} of {@code Connectable} objects to initialize.
	 *            
	 * @param position the index of the first item to initialize
	 **************************************************************************/
	public static void initializeMultiples(String type, int number,
			List<? extends Connectable> bag, int position)
	{
		if (position + number > bag.size()) {
			throw new IllegalArgumentException(
					"Cannot initialize beyond end of list.");
		}
		for (int i = position; i < position + number; i++) {
			bag.get(i).setConnections(type);
		}
	}

	/**************************************************************************
	 * Shuffle the list of {@code Connectable} objects.
	 * 
	 * @param list
	 *            the list of {@code Connectable} objects to shuffle.
	 **************************************************************************/
	public <T extends Connectable> void shuffle(List<T> list)
	{
		for (int i = 0; i < list.size(); i++) {
			int dest = (int) Math.random() * list.size();

			T temp = list.get(i);
			list.set(i, list.get(dest));
			list.set(dest, temp);
		}
	}

} // End TileGenerator
