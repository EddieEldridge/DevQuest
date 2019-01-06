package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Responsible for the painting of Graphics in the GameWindow
 * 
 * @see JPanel
 * @see PaintableInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class PaintableImpl extends JPanel implements PaintableInterface
{

	private static final long serialVersionUID = -7572248501008209972L;

	/**
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/ground/ directory.
	 */
	private int[][] tilesMatrix = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	/**
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/objects directory.
	 */
	private int[][] objectMatrix = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 3, 0, 0, 0, 0, 0, 0, 4, 2, 0 }, { 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 } };

	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK };

	// Instance variables
	ResourceSetupInterface resourceSetup = new ResourceSetupImpl();
	CoordinateManager coordinateManager = new CoordinateManager();

	private static final int DEFAULT_IMAGE_INDEX = 0;

	static Sprite playerSprite;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	public static boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	/**
	 * Constructor for paintable impl Handles loading the tiles, objects and
	 * playerSprite
	 * 
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public PaintableImpl()
	{
		try
		{
			tiles = resourceSetup.loadTiles();
		} catch (Exception e)
		{
			System.out.println("Error loading tiles: " + e);
		}

		try
		{
			objects = resourceSetup.loadObjects();
		} catch (Exception e)
		{
			System.out.println("Error loading objects: " + e);

		}

		try
		{
			playerSprite = resourceSetup.loadPlayerSprite();
		} catch (Exception e)
		{
			System.out.println("Error loading player sprite: " + e);

		}
	}

	/**
	 * Paints objects
	 * 
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void paintObjects(Graphics2D g2)
	{
		int imageIndex = -1;
		int x1 = 0;
		int y1 = 0;

		for (int row = 0; row < tilesMatrix.length; row++)
		{
			for (int col = 0; col < tilesMatrix[row].length; col++)
			{
				imageIndex = tilesMatrix[row][col];
				x1 = coordinateManager.getIsoX(col, row);
				y1 = coordinateManager.getIsoY(col, row);

				if (imageIndex >= 0 && imageIndex < tiles.length)
				{
					imageIndex = objectMatrix[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}

	}

	/**
	 * Paints the player
	 * playerSprite
	 * 
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void paintPlayer(Graphics2D g2)
	{
		Point point;
		point = coordinateManager.getIso(playerSprite.getPosition().getX(), playerSprite.getPosition().getY());
		g2.drawImage(playerSprite.getImage(), point.getX(), point.getY(), null);
	}

	/**
	 * Paints tiles
	 * 
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void paintTiles(Graphics2D g2)
	{
		int imageIndex = -1;
		int x1 = 0;
		int y1 = 0;

		for (int row = 0; row < tilesMatrix.length; row++)
		{
			for (int col = 0; col < tilesMatrix[row].length; col++)
			{
				imageIndex = tilesMatrix[row][col];

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
						x1 = col * Graphic.TILE_WIDTH;
						y1 = row * Graphic.TILE_HEIGHT;
						if (imageIndex < cartesian.length)
						{
							g2.setColor(cartesian[imageIndex]);
						}
						else
						{
							g2.setColor(Color.WHITE);
						}

						g2.fillRect(x1, y1, Graphic.TILE_WIDTH, Graphic.TILE_WIDTH);
					}
				}
			}
		}

	}

	/**
	 * Repaints the gameView as Isometric
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void paintAsIsometric()
	{
		PaintableImpl.isIsometric = !PaintableImpl.isIsometric;
		super.repaint();
	}

}
