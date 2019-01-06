package ie.gmit.sw;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Main method that starts the game by setting up the player singleton
 * and creates a new GameWindow to display the game in
 * Starts in its own thread
 * @see javax.swing.SwingUtilities.invokeLater
 * @see GameSetupInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class Runner
{
	public static void main(String[] args) throws Exception
	{
		// Instance variables
		GameSetupInterface gameSetup = new GameSetupImpl();
		
		// Setup the game
		gameSetup.setupPlayerName();
		gameSetup.setupPlayerDifficulty();
		gameSetup.showStartMessage();
		
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