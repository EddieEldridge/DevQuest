package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;

public class GameWindow
{
	/*
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/ground/ directory.
	 */
	private int[][] model = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// This matrix is a representation of where objects (things) in the game are
	// placed
	private int[][] objects = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public GameWindow() throws Exception
	{
		GameView view = new GameView(model, objects);
		Dimension d = new Dimension(GameView.DEFAULT_VIEW_SIZE, GameView.DEFAULT_VIEW_SIZE / 2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		// Creates and sets up the main window that the game is contained inside
		JFrame f = new JFrame("DevQuest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.addKeyListener(view);
		f.setSize(1000, 1000);
		f.setLocation(500, 200);
		f.pack();
		f.setVisible(true);
	}
}