package edu.gvsu.jmetro.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.border.Border;
import edu.gvsu.jmetro.engine.Tile;

public class TilePanel extends CellPanel {

	// private Tile cellTile;
	private int		index;

	private boolean	selected;

	private Border	border;


	public Border getBorder() {
		return border;
	}


	public void setBorder(Border border) {
		this.border = border;
	}


	/**
	 * @param cell
	 * @param i
	 */
	public TilePanel(Tile tile, int i) {
		super(tile);
		setIndex(i);
	}


	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		// g.setPaintMode();
		g.clearRect(0, 0, 60, 60);
		// g.finalize();
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, 60, 60);
		super.getCell().paintComponent(g2d);
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
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}
}
