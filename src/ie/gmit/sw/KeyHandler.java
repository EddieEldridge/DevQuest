package ie.gmit.sw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Manages and detects key presses while the game view is active and extends
 * KeyAdapter
 * 
 * @see KeyAdapter
 * @author Eddie Eldridge
 * @version 1.0
 */
public class KeyHandler extends KeyAdapter
{
	// Instance variables
	SpecialEventsInterface specialEvents = new SpecialEventsImpl();
	PaintableInterface paintInterface = new PaintableImpl();

	/**
	 * Handles keypresses and performs actions based on those keypresses
	 */
	public void keyPressed(KeyEvent keyPressed)
	{
		if (keyPressed.getKeyCode() == KeyEvent.VK_D || keyPressed.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			PaintableImpl.playerSprite.setDirection(Direction.RIGHT);
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_A || keyPressed.getKeyCode() == KeyEvent.VK_LEFT)
		{
			PaintableImpl.playerSprite.setDirection(Direction.LEFT);
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_W || keyPressed.getKeyCode() == KeyEvent.VK_UP)
		{
			PaintableImpl.playerSprite.setDirection(Direction.UP);
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_S || keyPressed.getKeyCode() == KeyEvent.VK_DOWN)
		{
			PaintableImpl.playerSprite.setDirection(Direction.DOWN);
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_Z)
		{
			paintInterface.paintAsIsometric();
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_SPACE || keyPressed.getKeyCode() == KeyEvent.VK_X)
		{
			PaintableImpl.playerSprite.move();
		}
		else if (keyPressed.getKeyCode() == KeyEvent.VK_G)
		{
			specialEvents.checkLocation();
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
