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

/**
 * Sets up things required for the game to start
 * e.g player's name, setting the player's difficulty and showing the starting message.
 * Implements an interface GameSetupInterface
 * @see GameSetupInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class GameSetupImpl implements GameSetupInterface
{
	/**
	 * Create an instance of our Player singleton
	 */
	PlayerSingleton player = PlayerSingleton.getInstance();
	
	
	public PlayerSingleton getPlayer()
	{
		return player;
	}

	public void setPlayer(PlayerSingleton player)
	{
		this.player = player;
	}
	
	private String showPlayerName;
	private String playerName;
	private String playerDifficulty;
	private String[] difficultyChoices = { "Easy", "Medium", "Hard" };

	/**
	 * Prompts the player for their name and saves it to the Player singleton instance
	 */
	public String setupPlayerName()
	{
		playerName = JOptionPane.showInputDialog("Player Name");
		player.setPlayerName(playerName);
		showPlayerName = "Good luck " + player.getPlayerName() + " you'll need it!";
		JOptionPane.showMessageDialog(null, showPlayerName);
		return playerName;
	}

	/**
	 * Prompts the player for the difficulty they wish to play on and saves it to the Player singleton instance
	 */
	public String setupPlayerDifficulty()
	{
		playerDifficulty = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choose your difficulty!",
				JOptionPane.QUESTION_MESSAGE, null, difficultyChoices, // Array of choices
				difficultyChoices[1]); // Initial choice
		player.setPlayerDifficulty(playerDifficulty);
		return playerDifficulty;
	}
	/**
	 * Shows a simple message to the player detailing the game
	 */
	public void showStartMessage()
	{
		JOptionPane.showMessageDialog(null,
				"Welcome to DevQuest , " + player.getPlayerName() + "! \n The controls are as follows.. \n\n WASD/Arrow Keys: Change direction \n Spacebar/X: Move \n Generate Question: G \n Show Help: H \n \n The aim of the game is to answer 5 questions correctly in a row at each computer. \n Once you've done this, head to the printer to print of your qualification!");
	}
	

}
