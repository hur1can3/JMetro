package edu.gvsu.jmetro.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import edu.gvsu.jmetro.engine.Tile;

public class TilePanel extends CellPanel {

	private Tile	cellTile;

	private int		index;


	/**
	 * @param cell
	 * @param i
	 */
	public TilePanel(Tile tile, int i) {
		super(tile);
		setCellTile(tile);
		setIndex(i);
	}


	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		getCellTile().paintComponent(g);
		// g.dispose();
		// g2.dispose();
	}


	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}


	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}


	/**
	 * @param cellTile
	 *            the cellTile to set
	 */
	public void setCellTile(Tile cellTile) {
		this.cellTile = cellTile;
	}


	/**
	 * @return the cellTile
	 */
	public Tile getCellTile() {
		return cellTile;
	}
}
