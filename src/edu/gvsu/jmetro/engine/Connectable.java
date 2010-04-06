package edu.gvsu.jmetro.engine;

/****************************************************************
 * Objects implementing this interface represent the tiles of a Metro
 * game that can be connected.
 * 
 * @author Zachary Kurmas
 ****************************************************************/
// (C) 2010 Zachary Kurmas
// Created Mar 16, 2010
public interface Connectable {

	/**************************************************************************
	 * Set this tile's connections.
	 * 
	 * @param description
	 *            a {@code String} describing the output to which the
	 *            North, East, South, and West inputs are connected
	 *            (in that order). The string should contain exactly
	 *            four upper-case letters from the set {@code N},
	 *            {@code E}, {@code S}, and {@code W}. For example,
	 *            calling {@code setConnections("NESW")} specifies
	 *            connections that are four "loops"). Calling {@code
	 *            setConnections("SWNE")} generates four connections
	 *            that go straight across.
	 **************************************************************************/
	public void setConnections(String description);
}
