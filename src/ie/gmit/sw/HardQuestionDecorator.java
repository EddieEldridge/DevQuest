package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

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
