package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class GameSetupImpl implements GameSetupInterface
{
	// Instance variables
	Player player = Player.getInstance();
	
	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	private String showPlayerName;
	private String playerName;
	private String playerDifficulty;
	private String[] difficultyChoices = { "Easy", "Medium", "Hard" };

	// Prompt the user for their name
	public String setupPlayerName()
	{
		playerName = JOptionPane.showInputDialog("Player Name");
		player.setPlayerName(playerName);
		showPlayerName = "Good luck " + player.getPlayerName() + " you'll need it!";
		JOptionPane.showMessageDialog(null, showPlayerName);
		return playerName;
	}

	// Prompt user for difficulty
	public String setupPlayerDifficulty()
	{
		playerDifficulty = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choose your difficulty!",
				JOptionPane.QUESTION_MESSAGE, null, difficultyChoices, // Array of choices
				difficultyChoices[1]); // Initial choice
		player.setPlayerDifficulty(playerDifficulty);
		return playerDifficulty;
	}
	
	

}
