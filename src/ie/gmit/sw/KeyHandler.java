package ie.gmit.sw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyHandler extends KeyAdapter
{
	// Instance variables
	SpecialEventsInterface specialEvents = new SpecialEventsImpl();
	PaintableInterface paintInterface = new PaintableImpl()   ;

	  public void keyPressed(KeyEvent keyPressed)
	  {
		  if (keyPressed.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				PaintableImpl.playerSprite.setDirection(Direction.RIGHT);
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_LEFT)
			{
				PaintableImpl.playerSprite.setDirection(Direction.LEFT);
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_UP)
			{
				PaintableImpl.playerSprite.setDirection(Direction.UP);
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_DOWN)
			{
				PaintableImpl.playerSprite.setDirection(Direction.DOWN);
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_Z)
			{
				paintInterface.paintAsIsometric();
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_X)
			{
				PaintableImpl.playerSprite.move();
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_G)
			{
				specialEvents.askQuestion();
			}
			else if (keyPressed.getKeyCode() == KeyEvent.VK_H)
			{
				specialEvents.showHelp();
			}
			else
			{
				return;
			}
	  }
}
