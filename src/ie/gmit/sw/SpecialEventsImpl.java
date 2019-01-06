package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

/**
 * Handles special events that can occur during the game
 * Interfaced by SpecialEventsInterface
 * @see SpecialEventsInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class SpecialEventsImpl implements SpecialEventsInterface
{
	GameSetupInterface gameSetup = new GameSetupImpl();
	PaintableImpl paintedObjects = new PaintableImpl();
	
	Boolean isCorrect = false;
	PlayerSingleton player = PlayerSingleton.getInstance();
	ArrayList<String> questionsFromFile;
	ArrayList<String> answersFromFile;

	/**
	 * Constructor that pre-loads any sound files and set's the volume to low
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public SpecialEventsImpl()
	{
		SoundEffect.init();
		SoundEffect.volume = SoundEffect.Volume.LOW;
	}

	/**
	 * Generates a question, the questionGenerated depends on the difficulty the player singleton has
	 * @return String array containing the question and answer pair
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public String[] generateQuestion() throws IOException
	{
		// Variables
		String questionToAsk;
		String actualAnswer;
		System.out.println(player.getPlayerDifficulty());

		if (player.getPlayerDifficulty().equals("Easy"))
		{
			Question easyQuestion = new EasyQuestionDecorator(new EasyQuestion());

			questionsFromFile = easyQuestion.generateQuestion();
			answersFromFile = easyQuestion.generateAnswers();
		}
		else if (player.getPlayerDifficulty().equals("Medium"))
		{
			Question mediumQuestion = new MediumQuestionDecorator(new MediumQuestion());

			questionsFromFile = mediumQuestion.generateQuestion();
			answersFromFile = mediumQuestion.generateAnswers();
		}
		else if (player.getPlayerDifficulty().equals("Hard"))
		{
			Question hardQuestion = new HardQuestionDecorator(new HardQuestion());

			questionsFromFile = hardQuestion.generateQuestion();
			answersFromFile = hardQuestion.generateAnswers();
		}

		String[] questionAnswerPair = { "", "" };

		// Seed a random number for selecting question/answer
		int seed = (int) (Math.random() * 9 + 1);

		// Choose a random question from the list of questions
		questionToAsk = questionsFromFile.get(seed);
		actualAnswer = answersFromFile.get(seed);

		// Add the question and answer to an array so we can return it
		questionAnswerPair[0] = questionToAsk;
		questionAnswerPair[1] = actualAnswer;

		return questionAnswerPair;
	}

	/**
	 * Generates some fanfare (Applause sound effect, dialog box congratulating the player)
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void generateFanfare()
	{
		if (player.getRoundsWon() >= 3)
		{
			SoundEffect.VICTORY.play();
			JOptionPane.showMessageDialog(null, "YOU HAVE WON!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have won " + player.getRoundsWon() + "rounds. You need to win "
					+ (3 - player.getRoundsWon()) + "rounds more to win!");
		}
	}

	/**
	 * Uses the generated question to prompt the player for their answer and checks to see if they were correct
	 * @see generateQuestion
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void askQuestion()
	{
		String[] questionAnswerPair = { "", "" };
		String playerAnswer;

		try
		{
			questionAnswerPair = generateQuestion();
		} catch (IOException e)
		{
			System.out.println("Error generating question: " + e);
		}

		System.out.println("Correct Answer: " + questionAnswerPair[1]);

		// Prompt the player for their answer
		playerAnswer = JOptionPane.showInputDialog(questionAnswerPair[0]);

		// Checks to see if the player was correct
		// If they were correct, ask another question until they have answered 5 correct questions in a row
		if (playerAnswer.equalsIgnoreCase(questionAnswerPair[1]))
		{
			player.setQuestionsAnswered(player.getQuestionsAnswered() + 1);
			JOptionPane.showMessageDialog(null, "Correct Answers: " + player.getQuestionsAnswered());
			askAnotherQuestion();
		}
		else
		{
			SoundEffect.FAILURE.play();
			player.setQuestionsAnswered(0);
			JOptionPane.showMessageDialog(null, "	WRONG! \n Correct Answer: " + questionAnswerPair[1]);
			System.out.println("Correct Answer: " + questionAnswerPair[1]);
			System.out.println("Player Answer: " + playerAnswer);
		}

	}

	/**
	 * Function to check the location of the player at any given time
	 * Used to check if a player is standing at a computer
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void checkLocation()
	{
		Point playerPoint = PaintableImpl.playerSprite.getPosition();
		Point computerPoint1 = new Point(1, 9);
		Point computerPoint2 = new Point(3, 1);
		Point computerPoint3 = new Point(8, 1);
		Point printer = new Point(9,9);

		if (playerPoint.getX() == computerPoint1.getX() && playerPoint.getY() == computerPoint1.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == computerPoint2.getX() && playerPoint.getY() == computerPoint2.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == computerPoint3.getX() && playerPoint.getY() == computerPoint3.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == printer.getX() && playerPoint.getY() == printer.getY() )
		{
			generateFanfare();
		}
		else
		{
			showMoreHelp();
		}
	}

	/**
	 * Function used to ask the player another question if they get one correct
	 * Used to check if a player is standing at a computer
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void askAnotherQuestion()
	{

		if (player.getQuestionsAnswered() < 5)
		{
			askQuestion();
		}
		else if (player.getQuestionsAnswered() >= 5)
		{
			player.setQuestionsAnswered(0);
			player.setRoundsWon(player.getRoundsWon() + 1);
			JOptionPane.showMessageDialog(null, "You have won " + player.getRoundsWon() + " rounds. You need to win "
					+ (3 - player.getRoundsWon()) + " rounds more to win!");
		}
	}
	
	
	/**
	 * Shows the player the message shown at the start of the game when they press the 'H' key
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void showHelp()
	{
		JOptionPane.showMessageDialog(null,
				"Use the arrow keys to move the player. \nMove Player: 'X' \nToggle View: 'Z'");
	}

	/**
	 * Informs the player they must be standing at a computer if they wish to answer questions
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void showMoreHelp()
	{
		JOptionPane.showMessageDialog(null,
				"Welcome to DevQuest , " + player.getPlayerName() + "! \n The controls are as follows.. \n\n WASD/Arrow Keys: Change direction \n Spacebar/X: Move \n Generate Question: G \n Show Help: H \n \n The aim of the game is to answer 5 questions correctly in a row at each computer. \n Once you've done this, head to the printer to print of your qualification!");	}
}
