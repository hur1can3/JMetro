package edu.gvsu.jmetro.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Station extends Cell implements Connectable {

	private BufferedImage image;

	private Rail[] rails;

	public Station(String connection, BufferedImage image) {
		// TODO Auto-generated constructor stub
		setImage(image);
		setConnections(connection);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g.drawImage(image, 0, 0, null);
		// g.dispose();
	}

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
