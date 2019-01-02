package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class SetupGameResources
{
	private Sprite player;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;

	// Load the images from the resource folder to be used as tiles
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

	public Sprite loadPlayer() throws Exception
	{
		player = new Sprite("Player 1", new Point(0, 0), loadImages("./resources/images/sprites/default", null));
		return player;
	}
	
	public BufferedImage[] loadTiles() throws Exception
	{
		tiles = loadImages("./resources/images/ground", tiles);
		return tiles;
	}
	
	public BufferedImage[] loadObjects() throws Exception
	{
		objects = loadImages("./resources/images/objects", objects);
		return objects;
	}
	
	
	


}
