package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

public abstract class QuestionDecorator implements Question
{
	protected Question decoratedQuestion;

	public QuestionDecorator(Question QuestionDecorator){
	      this.decoratedQuestion = decoratedQuestion;
	   }
	
	 public ArrayList<String> generateQuestion() throws IOException{
		 return decoratedQuestion.generateQuestion();
	   }	
}
