package edu.gvsu.jmetro.engine;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Player {

	private int				id;

	private String			name;

	private Color			pColor;

	private int				score;

	private BufferedImage	currentTile;


	public Player(String name, int id, Color pColor) {
		this.name = name;
		this.id = id;
		this.pColor = pColor;
		this.score = 0;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public Color getpColor() {
		return pColor;
	}


	public int getScore() {
		return score;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setpColor(Color pColor) {
		this.pColor = pColor;
	}


	public void setScore(int score) {
		this.score = score;
	}


	/**
	 * @param currentTile
	 *            the currentTile to set
	 */
	public void setCurrentTile(BufferedImage currentTile) {
		this.currentTile = currentTile;
	}


	/**
	 * @return the currentTile
	 */
	public BufferedImage getCurrentTile() {
		return currentTile;
	}
}