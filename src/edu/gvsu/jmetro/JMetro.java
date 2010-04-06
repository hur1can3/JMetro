package edu.gvsu.jmetro;

import edu.gvsu.jmetro.controller.JMetroController;
import edu.gvsu.jmetro.engine.JMetroGame;
import edu.gvsu.jmetro.gui.JMetroGUI;


/**
 * The main class that instantiates the model view and controller used in the
 * game.
 * 
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Mar 9, 2010
 */
public class JMetro {

	/**
	 * Create the model, view, and controller. They are created once here and
	 * passed to the parts that need them so there is only one copy of each.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		JMetroGame model = new JMetroGame();
		JMetroGUI view = new JMetroGUI(model);
		JMetroController controller = new JMetroController(model, view);
		model.addObserver(view);
		view.setVisible(true);
	}
}
