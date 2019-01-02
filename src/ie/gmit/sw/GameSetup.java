package ie.gmit.sw;

import javax.swing.JOptionPane;

public class GameSetup
{
	// Instance variables
	String playerName;
	String showPlayerName;
	String[] difficultyChoices = { "Easy", "Medium", "Hard" };

	// Prompt the user for their name
	public void getPlayerName()
	{
		JOptionPane playerNameWindow = new JOptionPane("Player name");
		playerName = JOptionPane.showInputDialog("Player Name");
		showPlayerName = "Good luck " + playerName + " you'll need it!";
		JOptionPane.showMessageDialog(null, showPlayerName);
	}

	// Prompt user for difficulty
	public void getPlayerDifficulty()
	{
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choose your difficulty!",
				JOptionPane.QUESTION_MESSAGE, null, difficultyChoices, // Array of choices
				difficultyChoices[1]); // Initial choice
	}
}
