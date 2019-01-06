package ie.gmit.sw;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * Creates the actual game window to display the game in
 * @author Eddie Eldridge
 * @version 1.0
 */
public class GameWindow
{
	/**
	 * Constructor for GameWindow
	 * Performs creation of the gameWindow and setting up of KeyHandler for that window
	 * @throws Exception
	 */
	public GameWindow() throws Exception
	{
		// Instance variables
		GameView view = new GameView();
		KeyHandler keyHandler = new KeyHandler();
		
		Dimension d = new Dimension(Graphic.DEFAULT_VIEW_SIZE, Graphic.DEFAULT_VIEW_SIZE / 2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		// Creates and sets up the main window that the game is contained inside
		JFrame f = new JFrame("DevQuest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.addKeyListener(keyHandler);
		f.setSize(1000, 1000);
		f.setLocation(500, 200);
		f.pack();
		f.setVisible(true);
	}
}