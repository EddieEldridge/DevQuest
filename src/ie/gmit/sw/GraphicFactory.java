package ie.gmit.sw;

public class GraphicFactory
{
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
			return new Background();
		}
		return null;
		
	}
}
