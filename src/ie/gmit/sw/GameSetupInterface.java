package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface GameSetupInterface
{
	public String setupPlayerName();
	public String setupPlayerDifficulty();
	public ArrayList<String> loadQuestionsFromFile() throws IOException;
	public ArrayList<String> loadAnswersFromFile() throws IOException;
}
