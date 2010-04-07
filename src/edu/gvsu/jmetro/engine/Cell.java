package edu.gvsu.jmetro.engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Cell extends JComponent {

	private BufferedImage	image;

	enum CellType {
		EMPTY, TILE, STATION
	}

	enum Connection {
		NN, NE, NS, NW, EN, EE, ES, EW, SN, SE, SS, SW, WN, WE, WS, WW
	}

	boolean[]			isConnected;

	boolean				state;

	private boolean		locked;

	boolean				used;

	private CellType	type;

	private Tile		tile;


	public Cell(String connection, BufferedImage image) {
		setImage(image);
		if (connection == null) {
			this.type = CellType.EMPTY;
		} else if (connection.length() <= 2) {
			this.type = CellType.STATION;
		} else {
			this.type = CellType.TILE;
		}
		isConnected = new boolean[Connection.values().length];
	}


	void Reset() {
		type = CellType.EMPTY;
		state = false;
		locked = false;
		isConnected[0] = false;
		used = false;
	}


	// public void paintComponent(Graphics g) {}
	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}


	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}


	@Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		// System.out.println("Painting tile: " + id);
		// g.setColor(Color.red);
		// Graphics2D g2d = (Graphics2D) g.create();
		g.drawImage(image, 0, 0, null);
		// g.dispose();
	}


	/**
	 * @param locked
	 *            the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}


	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}


	/**
	 * @param tile
	 *            the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}


	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}
}
