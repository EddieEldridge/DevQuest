package ie.gmit.sw;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Runner
{
	public static void main(String[] args) throws Exception
	{
		// Instance variables
		GameSetupInterface gameSetup = new GameSetupImpl();
		
		// Setup the game
		gameSetup.setupPlayerName();
		gameSetup.setupPlayerDifficulty();
		
		// Start the gameWindow in it's own thread
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{ 
				try
				{	
					new GameWindow();
				}
				catch (Exception gameCrashError)
				{
					System.out.println("The game crashed with an unexepected error: " + gameCrashError);
				}
			}
		});
	}
}