package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Decorates hardQuestions
 * and extends QuestionDecorator
 * @see QuestionDecorator
 * @author Eddie Eldridge
 * @version 1.0
 */
public class HardQuestionDecorator extends QuestionDecorator
{

	public HardQuestionDecorator(Question QuestionDecorator)
	{
		super(QuestionDecorator);
	}
	
	@Override
	public ArrayList<String> generateQuestion() throws IOException
	{
		return decoratedQuestion.generateQuestion();
	}
	
	@Override
	public ArrayList<String> generateAnswers() throws IOException
	{
		return decoratedQuestion.generateAnswers();
	}


}
