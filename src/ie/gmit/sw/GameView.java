package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener, KeyListener
{
	// Instance variables
	SpecialEventsInterface specialEvents = new SpecialEventsImpl();
	PaintableInterface paintInterface = new PaintableImpl();
	
	// 
	private Point position;
	private Player playerStats;
	private Sprite playerSprite;
	
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
		
		paintInterface.paintComponent(g);
		paintInterface.paintObjects(g);
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
			try
			{
				// If the player answers the question correctly then increase their score by 1
				while(isCorrect == true)
				{
					isCorrect = specialEvents.generateQuestion();	
					
					if(specialEvents.generateQuestion()==true)
					{
						JOptionPane.showMessageDialog(null, "Correct!");
						playerStats.setQuestionsAnswered(playerStats.getQuestionsAnswered()+1);
					}
				}
				
				if(isCorrect == false)
				{
					// If the player get's the question wrong, then set their score to 0
					JOptionPane.showMessageDialog(null, "Hard luck, try again!");
					playerStats.setQuestionsAnswered(0);				
				}
				else if(playerStats.getQuestionsAnswered()>=5)
				{
					specialEvents.generateFanfare();
				}
				
			} catch (IOException e1)
			{
				System.out.println("Error setting player score: " + e1);
			}
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