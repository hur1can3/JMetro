package edu.gvsu.jmetro.gui;

import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import edu.gvsu.jmetro.engine.Cell;
import edu.gvsu.jmetro.engine.JMetroGame;
import edu.gvsu.jmetro.engine.Station;
import edu.gvsu.jmetro.engine.Tile;

/**
 * @author hur1can3
 */
public class JMetroGUI extends JFrame implements Observer {

	private JMetroGame		metroGame;

	private JPanel			boardPanel;

	private CellPanel[][]	gameBoard;

	private JPanel			MainPanel;

	private JMenuItem[]		menuItems;

	private JMenu[]			menus;

	private JLabel[]		playerNames;

	private JPanel			PlayerPanel;

	private JPanel[]		Players;

	private JLabel[]		playerScores;

	private CellPanel[]		playerTiles;

	private JLabel			tileBag;

	private JPanel			tileBagPanel;

	private CellPanel		tileBagStack;


	/** Creates new form GUI */
	public JMetroGUI(JMetroGame metroGame) {
		this.metroGame = metroGame;
		initComponents();
	}


	/**
*
*/
	private void initComponents() {
		initFrame();
		initMenus();
		initPanels();
		initGameBoard();
		initPlayerPanel();
		initTileBagPanel();
		pack();
	}


	private void initFrame() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setMinimumSize(new java.awt.Dimension(1024, 768));
		// setMinimumSize(new java.awt.Dimension(600, 600));
		setName("JMetro");
		setResizable(false);
		getContentPane().setLayout(
				new javax.swing.BoxLayout(getContentPane(),
						javax.swing.BoxLayout.LINE_AXIS));
	}


	private void initGameBoard() {
		// a simple counter to help setup the cell type
		int type = 0;
		gameBoard = new CellPanel[11][11];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				BufferedImage image = new BufferedImage(60, 60,
						BufferedImage.TRANSLUCENT);
				BufferedImage[] simage = new BufferedImage[4];
				try {
					for (int s = 0; s < 4; s++) {
						simage[s] = ImageIO.read(new File(
								"tiles/station" + s + ".png"));
					}
				}
				catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (type % 11 == 0 && type != 0 && type != 121 - 11) {
					gameBoard[i][j] = new StationPanel(new Station(
							null, simage[3]));
				} else if (type < 10 && type != 0) {
					gameBoard[i][j] = new StationPanel(new Station(
							null, simage[0]));
				} else if (type % 11 == 10 && type != 10
						&& type != 120) {
					gameBoard[i][j] = new StationPanel(new Station(
							null, simage[1]));
				} else if (type > 110 && type != 11 & type != 120) {
					gameBoard[i][j] = new StationPanel(new Station(
							null, simage[2]));
					gameBoard[i][j].setIgnoreRepaint(true);
				} else {
					gameBoard[i][j] = new TilePanel(new Tile(null,
							image), 2);
				}
				gameBoard[i][j].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));
				gameBoard[i][j]
						.setBackground(new Color(204, 204, 204));
				gameBoard[i][j].setMinimumSize(new java.awt.Dimension(
						60, 60));
				gameBoard[i][j]
						.setPreferredSize(new java.awt.Dimension(60,
								60));
				gameBoard[i][j].setName("" + i);
				boardPanel.add(gameBoard[i][j]);
				gameBoard[i][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						CellPanel temp = (CellPanel) e.getSource();
						int turn = metroGame.getCurentTurn();
						for (int i = 0; i < gameBoard.length; i++) {
							for (int j = 0; j < gameBoard[i].length; j++) {
								if (gameBoard[i][j] == temp
										&& Players[turn].getBorder() != null) {
									Cell source = playerTiles[turn]
											.getCell();
									Cell target = gameBoard[i][j]
											.getCell();
									target = source;
									source = metroGame.getTileBag()
											.pop();
									playerTiles[turn].setCell(source);
									playerTiles[turn].repaint();
									PlayerPanel.repaint();
									gameBoard[i][j].getCell()
											.paintComponent(
													getGraphics());
									metroGame.setCurentTurn(turn++);
								}
							}
						}
					}


					@Override
					public void mouseEntered(MouseEvent e) {}


					@Override
					public void mouseExited(MouseEvent e) {}


					@Override
					public void mousePressed(MouseEvent e) {}


					@Override
					public void mouseReleased(MouseEvent e) {}
				});
				type++;
			}
		}
		boardPanel.setName("boardPanel");
		boardPanel.setLayout(new java.awt.GridLayout(11, 11));
		MainPanel.add(boardPanel, java.awt.BorderLayout.CENTER);
		// add it to the frame
		getContentPane().add(MainPanel);
	}


	private void initMenus() {
		// TODO Auto-generated method stub
		String[] menuData = metroGame.getMenus();
		JMenuBar menubar = new JMenuBar();
		int tCount = 0;
		int sCount = 0;
		// count how many top level menus and sub menus we have
		for (int i = 0; i < menuData.length; i++) {
			String[] s = menuData[i].split(":");
			if (s[1].equals("*")) {
				tCount++;
			} else {
				sCount++;
			}
		}
		// instantiate new menu arrays
		menus = new JMenu[tCount];
		menuItems = new JMenuItem[sCount];
		tCount = 0;
		sCount = 0;
		// add menus to arrays
		for (int j = 0; j < menuData.length; j++) {
			String[] s = menuData[j].split(":");
			// make top level menus
			if (s[1].equals("*")) { // It's a top level menu
				menus[tCount] = new JMenu(s[0]);
				menus[tCount].setMnemonic(s[0].charAt(0));
				menus[tCount].setName(s[1]);
				menubar.add(menus[tCount]);
				tCount++;
			} else { // next is a sub menu item
				menuItems[sCount] = new JMenuItem(s[0]);
				menuItems[sCount].setMnemonic(s[0].charAt(0));
				menuItems[sCount].setName(s[1]);
				menus[tCount - 1].add(menuItems[sCount]);
				sCount++;
			}
		}
		// add menu bar to view
		this.setJMenuBar(menubar);
	}


	private void initPanels() {
		// TODO Auto-generated method stub
		MainPanel = new javax.swing.JPanel();
		boardPanel = new javax.swing.JPanel();
		// MainPanel
		// .setBorder(javax.swing.BorderFactory
		// .createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		MainPanel.setName("MainPanel"); // NOI18N
		MainPanel.setLayout(new java.awt.BorderLayout());
	}


	private void initTileBagPanel() {
		tileBag = new JLabel("Bag: " + metroGame.getTileBag().size());
		tileBagPanel = new javax.swing.JPanel();
		// tileBagPanel.setBorder(javax.swing.BorderFactory
		// .createEtchedBorder());
		tileBagStack = new TilePanel(metroGame.getTileBag().peek(), 1);
		tileBagStack.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		tileBagStack.setMinimumSize(new java.awt.Dimension(60, 60));
		tileBagStack.setName("stack");
		tileBagStack.setPreferredSize(new java.awt.Dimension(60, 60));
		javax.swing.GroupLayout bagLayout = new javax.swing.GroupLayout(
				tileBagPanel);
		tileBagPanel.setLayout(bagLayout);
		bagLayout
				.setHorizontalGroup(bagLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bagLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												bagLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(
																tileBag)
														.addComponent(
																tileBagStack,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		// handle vertical layout
		bagLayout
				.setVerticalGroup(bagLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bagLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												tileBagStack,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tileBag)));
		PlayerPanel.add(tileBagPanel);
	}


	private void initPlayerPanel() {
		// TODO Auto-generated method stub
		PlayerPanel = new javax.swing.JPanel();
		Players = new JPanel[metroGame.getPlayers().length];
		playerTiles = new CellPanel[metroGame.getPlayers().length];
		playerNames = new JLabel[metroGame.getPlayers().length];
		playerScores = new JLabel[metroGame.getPlayers().length];
		for (int i = 0; i < Players.length; i++) {
			Players[i] = new JPanel();
			// Players[i].setBorder(javax.swing.BorderFactory
			// .createEtchedBorder());
			Players[i].setName("player" + i);
			// playerTiles[i] = new JPanel();
			playerTiles[i] = new TilePanel(metroGame.getTileBag()
					.pop(), i);
			playerTiles[i].setBorder(javax.swing.BorderFactory
					.createLineBorder(new java.awt.Color(0, 0, 0)));
			playerTiles[i].setMinimumSize(new java.awt.Dimension(60,
					60));
			playerTiles[i].setName("pile" + i);
			playerTiles[i].setPreferredSize(new java.awt.Dimension(60,
					60));
			playerTiles[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getSource() instanceof TilePanel) {
						// TODO implement clickable interface
					}
				}


				@Override
				public void mouseEntered(MouseEvent e) {}


				@Override
				public void mouseExited(MouseEvent e) {}


				@Override
				public void mousePressed(MouseEvent e) {}


				@Override
				public void mouseReleased(MouseEvent e) {}
			});
			playerNames[i] = new JLabel(metroGame.getPlayers()[i]
					.getName());
			playerScores[i] = new JLabel("Score: "
					+ metroGame.getPlayers()[i].getScore());
			// handle horizontal layout
			javax.swing.GroupLayout PlayerLayout = new javax.swing.GroupLayout(
					Players[i]);
			Players[i].setLayout(PlayerLayout);
			PlayerLayout
					.setHorizontalGroup(PlayerLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									PlayerLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													PlayerLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.CENTER)
															.addComponent(
																	playerNames[i])
															.addComponent(
																	playerScores[i])
															.addComponent(
																	playerTiles[i],
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(
													javax.swing.GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			// handle vertical layout
			PlayerLayout
					.setVerticalGroup(PlayerLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									PlayerLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													playerTiles[i],
													javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(
													playerNames[i])
											.addComponent(
													playerScores[i])));
			PlayerPanel.add(Players[i]);
		}
		// finish setting up playerpanel
		// PlayerPanel
		// .setBorder(javax.swing.BorderFactory
		// .createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		PlayerPanel.setName("PlayerPanel");
		PlayerPanel.setLayout(new java.awt.GridLayout(7, 1));
		// add it to the frame
		getContentPane().add(PlayerPanel);
	}


	public void showError(String message) {
	// TODO Auto-generated method stub
	}


	@Override
	public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	}
}