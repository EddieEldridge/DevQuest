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
		String playerName;
		String showPlayerName;
		String[] difficultyChoices = { "Easy", "Medium", "Hard" };

		// Prompt the user for their name
		JOptionPane playerNameWindow = new JOptionPane("Player name");
		playerName = JOptionPane.showInputDialog("Player Name");
		showPlayerName = "Good luck " + playerName + " you'll need it!";
		JOptionPane.showMessageDialog(null, showPlayerName);

		// Prompt user for difficulty
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choose your difficulty!",
				JOptionPane.QUESTION_MESSAGE, null, 
				difficultyChoices, // Array of choices
				difficultyChoices[1]); // Initial choice

		// Can read in necessary information here and process it before going any
		// further...

		// Never run a GUI in the same thread as the main method... This is
		// asynchronous:
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{ // Template method....
				try
				{
					/*
					 * ---------------------------------------- Control Keys
					 * ---------------------------------------- Use the arrow keys to move the
					 * player. Move Player: 'X' Toggle View: 'Z'
					 * ----------------------------------------
					 */
					new GameWindow(); // Could be done nicer?
				} catch (Exception e)
				{
					e.printStackTrace(); // Real lazy stuff here...
				}
			}
		});
	}
}