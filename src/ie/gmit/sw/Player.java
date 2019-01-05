package ie.gmit.sw;

public final class Player
{
	// Variables
	String playerName;
	String playerDifficulty;
	int questionsAnswered;

	private static final Player playerSingleton = new Player();

	private Player()
	{
	}

	public static Player getInstance()
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
