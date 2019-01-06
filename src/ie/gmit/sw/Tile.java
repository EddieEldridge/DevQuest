package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * Part of the Graphic hierarchy
 * @see Graphic
 * @author Eddie Eldridge
 * @version 1.0
 */
public class Tile extends Graphic
{
	private BufferedImage[][] images; 
	
	public Tile(BufferedImage[] img)
	{
		setName("Tile");
		
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++)
		{
			images[row][col] = img[i];
			if (col == images[row].length - 1)
			{
				row++;
				col = 0;
			}
			else
			{
				col++;
			}
		}
	}
	
	public Tile()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	BufferedImage getImage()
	{
		// TODO Auto-generated method stub
		return null;
	}


}
