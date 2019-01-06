package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

/**
 * Method responsible for loading Graphics found locally such as Tiles, Objects and Sprites
 * Interfaced by ResourceSetupInterface
 * @see ResourceSetupInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class ResourceSetupImpl implements ResourceSetupInterface
{
	GraphicFactory graphicFactory = new GraphicFactory();
	Graphic playerSprite = graphicFactory.getGraphic("Sprite");
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	
	/**
	 * Handles the loading of images
	 * @see loadPlayerSprite
	 * @see loadTiles
	 * @see loadObjects
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	private BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception
	{
		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++)
		{
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

	/**
	 * Loads the playerSprite
	 * @see loadImages
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public Sprite loadPlayerSprite() throws Exception
	{
		playerSprite = new Sprite(loadImages("./resources/images/sprites/default", null));
		return (Sprite) playerSprite;
	}
	
	/**
	 * Loads Tiles
	 * @see loadImages
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public BufferedImage[] loadTiles() throws Exception
	{
		tiles = loadImages("./resources/images/ground", tiles);
		return tiles;
	}
	
	/**
	 * Loads Objects
	 * @see loadImages
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public BufferedImage[] loadObjects() throws Exception
	{
		objects = loadImages("./resources/images/objects", objects);
		return objects;
	}

}
