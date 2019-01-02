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
	SetupGameResources resourceSetup = new SetupGameResources();
	private Sprite player;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	
	private static final long serialVersionUID = 777L;
	private static final int DEFAULT_IMAGE_INDEX = 0;

	// Encapsulate the things that vary...
	public static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;

	// Do we really need two models like this?
	private int[][] matrix;
	private int[][] things;

	
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation

	private Timer timer; // Controls the repaint interval.
	private boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	public GameView(int[][] matrix, int[][] things) throws Exception
	{
		tiles = resourceSetup.loadTiles();
		objects = resourceSetup.loadObjects();
		player = resourceSetup.loadPlayer();
		
		System.out.println(player);
		System.out.println(tiles);
		System.out.println(objects);
		
		this.matrix = matrix;
		this.things = things;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	public void toggleView()
	{
		isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e)
	{ // This is called each time the timer reaches zero
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{ // This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];
				
				if (imageIndex >= 0 && imageIndex < tiles.length) {
					//Paint the ground tiles
					if (isIsometric) {
						x1 = getIsoX(col, row);
						y1 = getIsoY(col, row);
						
						g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null);
						if (imageIndex > DEFAULT_IMAGE_INDEX) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * TILE_WIDTH;
						y1 = row * TILE_HEIGHT;
	        			if (imageIndex < cartesian.length) {
	        				g2.setColor(cartesian[imageIndex]);
	        			}else {
	        				g2.setColor(Color.WHITE);
	        			}
						
	        			g2.fillRect(x1, y1, TILE_WIDTH, TILE_WIDTH);
					}
					//Paint the object or things on the ground
					
					
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}
		
		//Paint the player on  the ground
		point = getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}

	// This method breaks the SRP
	private int getIsoX(int x, int y)
	{
		int rshift = (DEFAULT_VIEW_SIZE / 2) - (TILE_WIDTH / 2) + (x - y); // Pan camera to the right
		return (x - y) * (TILE_WIDTH / 2) + rshift;
	}

	// This method breaks the SRP
	private int getIsoY(int x, int y)
	{
		return (x + y) * (TILE_HEIGHT / 2);
	}

	// This method breaks the SRP
	private Point getIso(int x, int y)
	{
		return new Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient...
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			toggleView();
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
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