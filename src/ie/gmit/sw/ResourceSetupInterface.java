package ie.gmit.sw;

import java.awt.image.BufferedImage;

public interface ResourceSetupInterface
{

	Sprite loadPlayer() throws Exception;

	BufferedImage[] loadTiles() throws Exception;

	BufferedImage[] loadObjects() throws Exception;

}