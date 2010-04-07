package edu.gvsu.jmetro.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Station extends Cell implements Connectable {

	private Rail[]	rails;


	public Station(String connection, BufferedImage image) {
		// TODO Auto-generated constructor stub
		super(connection, image);
		setConnections(connection);
	}


	@Override
	public void setConnections(String description) {
		if (description != null) {
			rails = new Rail[4];
			rails[0] = new Rail('N', description.charAt(0));
			rails[1] = new Rail('E', description.charAt(1));
			rails[2] = new Rail('S', description.charAt(2));
			rails[3] = new Rail('W', description.charAt(3));
		}
	}
}
