package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PaintableImpl extends JPanel implements PaintableInterface 
{
	
	/*
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/ground/ directory.
	 */
	private int[][] matrix = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// This matrix is a representation of where objects (things) in the game are
	// placed
	private int[][] things = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, {  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{  0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	
	ResourceSetupInterface resourceSetup = new ResourceSetupImpl();
	CoordinateManager coordinateManager = new CoordinateManager();

	private static final int DEFAULT_IMAGE_INDEX = 0;

	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation
	

	static Sprite playerSprite;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	public static boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	public PaintableImpl() throws Exception
	{
		tiles = resourceSetup.loadTiles();
		objects = resourceSetup.loadObjects();
		playerSprite = resourceSetup.loadPlayer();
	}
		

	/* (non-Javadoc)
	 * @see ie.gmit.sw.PaintableInterface#paintObjects(java.awt.Graphics)
	 */
	public void paintObjects(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;

		for (int row = 0; row < matrix.length; row++)
		{
			for (int col = 0; col < matrix[row].length; col++)
			{
				imageIndex = matrix[row][col];
				// Paint the object or things on the ground
				imageIndex = things[row][col];
				g2.drawImage(objects[imageIndex], x1, y1, null);
			}
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.PaintableInterface#paintPlayer(java.awt.Graphics)
	 */
	public void paintPlayer(Graphics g)
	{
		Point point;

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Paint the player on the ground
		point = coordinateManager.getIso(playerSprite.getPosition().getX(), playerSprite.getPosition().getY());
		g2.drawImage(playerSprite.getImage(), point.getX(), point.getY(), null);
		
		
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.PaintableInterface#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{ 
		// This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;

		for (int row = 0; row < matrix.length; row++)
		{
			for (int col = 0; col < matrix[row].length; col++)
			{
				imageIndex = matrix[row][col];

				if (imageIndex >= 0 && imageIndex < tiles.length)
				{
					// Paint the ground tiles
					if (isIsometric)
					{
						x1 = coordinateManager.getIsoX(col, row);
						y1 = coordinateManager.getIsoY(col, row);

						g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null);
						
						if (imageIndex > DEFAULT_IMAGE_INDEX)
						{
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					}
					else
					{
						x1 = col * GameView.TILE_WIDTH;
						y1 = row * GameView.TILE_HEIGHT;
						if (imageIndex < cartesian.length)
						{
							g2.setColor(cartesian[imageIndex]);
						}
						else
						{
							g2.setColor(Color.WHITE);
						}

						g2.fillRect(x1, y1, GameView.TILE_WIDTH, GameView.TILE_WIDTH);
					}
				}
			}
		}

	}

	
	
}
