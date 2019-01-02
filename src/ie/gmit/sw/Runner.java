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
		SetupGameOptions gameSetup = new SetupGameOptions();
		
		// Setup the game
		gameSetup.getPlayerName();
		gameSetup.getPlayerDifficulty();

		// Never run a GUI in the same thread as the main method... This is
		// asynchronous:
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{ 
				try
				{
					/*
					 * ---------------------------------------- Control Keys
					 * ---------------------------------------- Use the arrow keys to move the
					 * player. Move Player: 'X' Toggle View: 'Z'
					 * ----------------------------------------
					 */
					new GameWindow(); // Could be done nicer?
				} catch (Exception gameCrashError)
				{
					System.out.println("The game crashed with an unexepected error: " + gameCrashError);
				}
			}
		});
	}
}