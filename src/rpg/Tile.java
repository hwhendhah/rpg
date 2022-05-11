package rpg;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
public class Tile {
	String texturePath;
	private Image texture;
	ArrayList<Player> onThisTile;
	boolean isSolid;
	boolean canInteract;
	public Tile()
	{
		onThisTile = new ArrayList<Player>();
		canInteract = false;
		texturePath = "tile.png";
		try
		{
			texture = ImageIO.read(new File(texturePath));
		}
		catch (Exception e) {System.err.print("WHY WONT THIS DAMN PICTURE GET IMPORTED");}
	}
	public void drawTile(Graphics g, int i, int j, int size)
	{
		g.drawImage(texture.getScaledInstance(size, size, Image.SCALE_SMOOTH), i, j, i+size, j+size, null);
		
	}
}
