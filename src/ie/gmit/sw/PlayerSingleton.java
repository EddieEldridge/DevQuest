package ie.gmit.sw;

/**
 * Singleton class for the player
 * Ensures consistency of player state and makes setting and getting player info more reliable
 * @author Eddie Eldridge
 * @version 1.0
 */
public final class PlayerSingleton
{
	// Variables
	String playerName;
	String playerDifficulty;
	Sprite playerSprite;
	int roundsWon;
	int questionsAnswered;

	public int getRoundsWon()
	{
		return roundsWon;
	}


	public void setRoundsWon(int roundsWon)
	{
		this.roundsWon = roundsWon;
	}


	private static final PlayerSingleton playerSingleton = new PlayerSingleton();

	private PlayerSingleton()
	{
	}

	public static PlayerSingleton getInstance()
	{
		return playerSingleton;
	}

	public int getQuestionsAnswered()
	{
		return questionsAnswered;
	}

	public void setQuestionsAnswered(int questionsAnswered)
	{
		this.questionsAnswered = questionsAnswered;
	}

	public String getPlayerDifficulty()
	{
		return playerDifficulty;
	}

	public void setPlayerDifficulty(String playerDifficulty)
	{
		this.playerDifficulty = playerDifficulty;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

}
