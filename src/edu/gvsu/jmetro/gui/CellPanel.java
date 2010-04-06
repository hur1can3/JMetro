package edu.gvsu.jmetro.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import edu.gvsu.jmetro.engine.Cell;

public abstract class CellPanel extends JPanel {

	private Cell	cell;


	public CellPanel(Cell cell) {
		this.cell = cell;
		this.setVisible(true);
	}


	public Cell getCell() {
		return cell;
	}


	public void setCell(Cell cell) {
		this.cell = cell;
	}


	public void paintComponent(Graphics g) {}
}
