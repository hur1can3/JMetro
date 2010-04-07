package edu.gvsu.jmetro.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 5, 2010
 */
public class Tile extends Cell implements Connectable {

	private int		id;

	private Rail[]	rails;


	public Tile(int id, String connection, BufferedImage image) {
		super(connection, image);
		setId(id);
		setConnections(connection);
	}


	@Override
	public String toString() {
		return "Tile [id=" + id + ", rails=" + Arrays.toString(rails)
				+ "]";
	}


	/**
	 * @return the rails
	 */
	public Rail[] getRails() {
		return rails;
	}


	public void setConnections(String description) {
		// TODO Auto-generated method stub
		if (description != null) {
			rails = new Rail[4];
			rails[0] = new Rail('N', description.charAt(0));
			rails[1] = new Rail('E', description.charAt(1));
			rails[2] = new Rail('S', description.charAt(2));
			rails[3] = new Rail('W', description.charAt(3));
		}
	}


	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
