package edu.gvsu.jmetro.engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 5, 2010
 */
public class Tile extends Cell implements Connectable {

	private BufferedImage	image;

	private Rail[]			rails;


	public Tile(String connection, BufferedImage image) {
		setImage(image);
		setConnections(connection);
	}


	public BufferedImage getImage() {
		return image;
	}


	/**
	 * @return the rails
	 */
	public Rail[] getRails() {
		return rails;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Repainting");
        g.setColor(Color.red);
		Graphics2D g2d = (Graphics2D) g.create();
		g.drawImage(image, 0, 0, null);
		// g.dispose();
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


	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
