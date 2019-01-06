package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * Interface for ResourceSetupImpl
 * @see ResourceSetupImpl
 * @author Eddie Eldridge
 * @version 1.0
 */
public interface ResourceSetupInterface
{

	Sprite loadPlayerSprite() throws Exception;

	BufferedImage[] loadTiles() throws Exception;

	BufferedImage[] loadObjects() throws Exception;

}