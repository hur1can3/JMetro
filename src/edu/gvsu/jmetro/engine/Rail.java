package edu.gvsu.jmetro.engine;

import java.awt.Color;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 5, 2010
 */
public class Rail {

	@Override
	public String toString() {
		return "Rail [owner=" + owner + ", sourceDir=" + sourceDir
				+ ", targetDir=" + targetDir + ", used=" + used + "]";
	}

	private Color railColor;

	private char sourceDir;

	private char targetDir;

	private boolean used;

	private int owner;

	public Rail(char s, char t) {
		// TODO Auto-generated constructor stub
		setSourceDir(s);
		setTargetDir(t);
		setRailColor(Color.GRAY);
		setOwner(-1);
	}

	public void setTargetDir(char targetDir) {
		this.targetDir = targetDir;
	}

	public char getTargetDir() {
		return targetDir;
	}

	public void setSourceDir(char sourceDir) {
		this.sourceDir = sourceDir;
	}

	public char getSourceDir() {
		return sourceDir;
	}

	public void setRailColor(Color railColor) {
		this.railColor = railColor;
	}

	public Color getRailColor() {
		return railColor;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getOwner() {
		return owner;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public boolean isUsed() {
		return used;
	}
}
