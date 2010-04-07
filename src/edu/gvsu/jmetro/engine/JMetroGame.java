package edu.gvsu.jmetro.engine;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;
import javax.imageio.ImageIO;
import edu.gvsu.jmetro.engine.Cell.CellType;
import edu.gvsu.jmetro.gui.CellPanel;
import edu.gvsu.jmetro.gui.StationPanel;
import edu.gvsu.jmetro.gui.TilePanel;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 5, 2010
 */
public class JMetroGame extends Observable {

	/**
	 * Custom Game Menu Data used to create the game menu's
	 * dynamically. the syntax is "Menu Name:method Name" or "Menu:*"
	 * the * indicates a top level menu. setChanged();
	 * notifyObservers();
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

	// private Board gameBoard;
	private Cell[][]			gameBoard;

	private int[][]				neighborMap;


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
		initBoard();
	}


	private void initBoard() {
		// TODO Auto-generated method stub
		int type = 0;
		gameBoard = new Cell[11][11];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (type % 11 == 0 && type != 0 && type != 121 - 11) {
					gameBoard[i][j] = new Cell("S", null);
				} else if (type < 10 && type != 0) {
					gameBoard[i][j] = new Cell("E", null);
				} else if (type % 11 == 10 && type != 10
						&& type != 120) {
					gameBoard[i][j] = new Cell("N", null);
				} else if (type > 110 && type != 11 & type != 120) {
					gameBoard[i][j] = new Cell("W", null);
				} else {
					gameBoard[i][j] = new Cell(null, null);
				}
			}
		}
	}


	private void initTiles() {
		// TODO Auto-generated method stub
		tiles = new ArrayList<Tile>(60);
		tileBag = new Stack<Tile>();
		for (int i = 0; i < 60; i++) {
			tiles.add(new Tile(i, null, null));
			String test = "";
			if (i > 45) {
				test = Integer.toString(i - 36, 33);
			} else if (i > 22) {
				test = Integer.toString(i - 13, 33);
			} else {
				test = Integer.toString((i + 10) % 33, 33);
			}
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
		tg.shuffle(tiles);
		tileBag.addAll(tiles);
		tg.shuffle(tileBag);
		System.out.print(tileBag.peek().toString());
	}


	private void initGame(int numOfPlayers, String playerNames,
			Color[] pColors) {
		// TODO Auto-generated method stub
		players = new Player[numOfPlayers];
		String[] plist = playerNames.split(":");
		for (int i = 0; i < numOfPlayers; i++) {
			players[i] = new Player(plist[i], i, pColors[i]);
		}
		currentPlayer = players[0];
		setCurentTurn(0);
	}


	public Player[] getPlayers() {
		return players;
	}


	public boolean placeTile() {
		// update player turn
		incrementTurn();
		setChanged();
		notifyObservers();
		return true;
	}


	public void incrementTurn() {
		System.out.print("current: " + curentTurn);
		if (getCurentTurn() == players.length - 1) {
			setCurrentPlayer(players[0]);
			setCurentTurn(players[0].getId());
		} else {
			setCurrentPlayer(players[curentTurn++]);
		}
	}


	public void setPlayers(Player[] players) {
		this.players = players;
	}


	public String[] getMenus() {
		// TODO Auto-generated method stub
		return menus;
	}
}