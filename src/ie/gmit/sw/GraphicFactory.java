package ie.gmit.sw;

/**
 * Factory class used to generate types of graphics
 * 
 * @see Sprite
 * @see Tile
 * @see Object
 * @author Eddie Eldridge
 * @version 1.0
 */
public class GraphicFactory
{
	/**
	 * Factory class constructor
	 * @param graphicToUse - The graphic you wish to generate using the factory class
	 * @see Graphic
	 * @author Eddie Eldridge
	 * @return Graphic 
	 * @version 1.0
	 */
	public Graphic getGraphic(String graphicToUse) 
	{
		if(graphicToUse == null)
		{
			return null;
		}
		
		else if(graphicToUse == "Sprite")
		{
			return new Sprite();
		}
		else if(graphicToUse == "Tile")
		{
			return new Tile();
		}
		else if(graphicToUse == "Background")
		{
			return new Object();
		}
		return null;
		
	}
}
