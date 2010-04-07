package edu.gvsu.jmetro.gui;

import java.awt.Graphics;
import edu.gvsu.jmetro.engine.Station;

/**
 * @author hur1can3
 */
public class StationPanel extends CellPanel {

	private Station	cellStation;


	/**
	 * @param cell
	 */
	public StationPanel(Station cell) {
		super(cell);
		cellStation = cell;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		cellStation.paintComponent(g);
		//g.dispose();
	}
}
