package rpg;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Player {
	private String texturePath; // path to texture
	private Image texture;
	private String username; // username
	private int x; // which tile the character is on - x value
	private int y; // which tile the character is on - y value
	private int direction; // which direction player is facing 0-left 1-right
	public int currHealth; // current health
	public int maxHealth; // maximum health
	public Player()
	{
		username = "player";
		direction = 1;
		texturePath = "player.png";
		try
		{
			texture = ImageIO.read(new File(texturePath));
		}
		catch (Exception e) { System.err.println(e);}

		username = "name";
		direction = 1;
		
	}
	public void renderPlayer(Graphics g, int i, int j, int size)
	{
		g.drawImage(texture.getScaledInstance(size, size, Image.SCALE_SMOOTH), i, j, i+size, j+size, null);
	}
	
}
