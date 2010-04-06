package edu.gvsu.jmetro.engine;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;
import javax.imageio.ImageIO;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 5, 2010
 */
public class JMetroGame extends Observable {

	/**
	 * Custom Game Menu Data used to create the game menu's
	 * dynamically. the syntax is "Menu Name:method Name" or "Menu:*"
	 * the * indicates a top level menu.
	 */
	private final String[]		menus	= { "File:*",
			"New Game:newGame", "Load Game:loadGame",
			"Save Game:saveGame", "Quit:quitGame", "Game:*",
			"Undo Move:undoMove", "Reset Game:resetGame",
			"Close Game:closeGame", "About:*", "Game:aboutGame" };

	public static final Color[]	pColors	= { Color.BLUE, Color.RED,
			Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA };

	private Player[]			players;

	private ArrayList<Tile>		tiles;

	private static Stack<Tile>	tileBag;

	private Player				currentPlayer;

	private int					curentTurn;


	public int getCurentTurn() {
		return curentTurn;
	}


	public void setCurentTurn(int curentTurn) {
		this.curentTurn = curentTurn;
	}


	public Stack<Tile> getTileBag() {
		return tileBag;
	}


	public static void setTileBag(Stack<Tile> tileBag) {
		JMetroGame.tileBag = tileBag;
	}


	public Player getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	public ArrayList<Tile> getTiles() {
		return tiles;
	}


	public JMetroGame() {
		initTiles();
		initGame(6, "John:Tim:Luke:Matt:Joseph:Isac", pColors);
	}


	private void initTiles() {
		// TODO Auto-generated method stub
		tiles = new ArrayList<Tile>(60);
		tileBag = new Stack<Tile>();
		for (int i = 0; i < 60; i++) {
			tiles.add(new Tile(null, null));
			String test = "";
			if (i > 45) {
				test = Integer.toString(i - 36, 33);
			} else if (i > 22) {
				test = Integer.toString(i - 13, 33);
			} else {
				test = Integer.toString((i + 10) % 33, 33);
			}
			System.out.print(test);
			try {
				tiles.get(i).setImage(
						ImageIO
								.read(new File("tiles/" + test
										+ ".png")));
				// tileBag.add(tiles.get(i));
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TileGeneratorStandardGame tg = new TileGeneratorStandardGame();
		tg.initializeTiles(tiles);
		System.out.println("\n" + tiles.toString());
		//tg.shuffle(tiles);
		tileBag.addAll(tiles);
	}


	private void initGame(int numOfPlayers, String playerNames,
			Color[] pColors) {
		// TODO Auto-generated method stub
		players = new Player[numOfPlayers];
		String[] plist = playerNames.split(":");
		for (int i = 0; i < numOfPlayers; i++) {
			players[i] = new Player(plist[i], i, pColors[i]);
		}
	}


	public Player[] getPlayers() {
		return players;
	}


	public void setPlayers(Player[] players) {
		this.players = players;
	}


	public String[] getMenus() {
		// TODO Auto-generated method stub
		return menus;
	}
}