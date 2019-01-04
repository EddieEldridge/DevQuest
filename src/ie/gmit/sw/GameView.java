package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class GameView extends JPanel implements ActionListener, KeyListener
{
	// Instance variables
	SpecialEventsInterface specialEvents = new SpecialEventsImpl();
	PaintableInterface paintInterface = new PaintableImpl();

	private Player playerDetails;
	private Boolean isCorrect = true;

	private static final long serialVersionUID = 777L;
	public static final int DEFAULT_VIEW_SIZE = 1280;
	static final int TILE_WIDTH = 128;
	static final int TILE_HEIGHT = 64;

	private Timer timer; // Controls the repaint interval.

	public GameView() throws Exception
	{
		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	public void toggleView()
	{
		PaintableImpl.isIsometric = !PaintableImpl.isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		// This is called each time the timer reaches zero
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		paintInterface.paintTiles(g2);
		paintInterface.paintObjects(g2);
		paintInterface.paintPlayer(g2);
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			PaintableImpl.playerSprite.setDirection(Direction.RIGHT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			PaintableImpl.playerSprite.setDirection(Direction.LEFT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			PaintableImpl.playerSprite.setDirection(Direction.UP);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			PaintableImpl.playerSprite.setDirection(Direction.DOWN);
		}
		else if (e.getKeyCode() == KeyEvent.VK_Z)
		{
			toggleView();
		}
		else if (e.getKeyCode() == KeyEvent.VK_X)
		{
			PaintableImpl.playerSprite.move();
		}
		else if (e.getKeyCode() == KeyEvent.VK_G)
		{
			// ask question
		}
		else if (e.getKeyCode() == KeyEvent.VK_H)
		{
			specialEvents.showHelp();
		}
		else
		{
			return;
		}
	}

	public void keyReleased(KeyEvent e)
	{
	} // Ignore

	public void keyTyped(KeyEvent e)
	{
	} // Ignore
}