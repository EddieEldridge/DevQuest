package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Abstract class for Question interface
 * @see Question
 * @author Eddie Eldridge
 * @version 1.0
 */
public abstract class QuestionDecorator implements Question
{
	protected Question decoratedQuestion;

	public QuestionDecorator(Question decoratedQuestion){
	      this.decoratedQuestion = decoratedQuestion;
	   }
	
	 public ArrayList<String> generateQuestion() throws IOException{
		 return decoratedQuestion.generateQuestion();
	   }	
}
