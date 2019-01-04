package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;

public class GameWindow
{
	
	public GameWindow() throws Exception
	{
		GameView view = new GameView();
		
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