package rpg;

// I apologize for the messy code.
// The code was in seperate files but at the
// very last minute it stopped working, and
// I had to combine them into a single file.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Runner
{
    public static void main(String[] args)
    {
		// Creates JFrame with name
        JFrame j = new JFrame("rpg");
		
		// Creates extension of JPanel
        myPanel m = new myPanel();

		// Equalizes size
		j.setSize(m.getSize());

		// Adds the JPanel and listeners to the JFrame
		j.add(m);
        j.addKeyListener(m);
	    j.addMouseListener(m);

		// Initializes JFrame
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);

		// Icon
		/*
		ImageIcon img = new ImageIcon("assets/space.jpg");
		j.setIconImage(img.getImage());
		*/
    }
}

class myPanel extends JPanel implements ActionListener, MouseListener, KeyListener
{

	// Starts a Timer
	private Timer time;
	private Screen scr;
	// Makes a new Player object
	Player p = new Player();

	// MyPanelb Constructor
	myPanel()
	{
		time = new Timer(10, this);
		setSize(1600, 900);
		setVisible(true);
		time.start();
		scr = new Screen();
	}

	// Paints every frame
	public void paintComponent(Graphics g)
	{	
		//scr.showScreen(g);
		g.setColor(Color.black);
		g.drawRect(100,100,100,100);
	}

	// Called when the mouse is clicked
	public void mouseClicked(MouseEvent e)
	{

	}	

	// Plays sound with path f
    // Derived from https://stackoverflow.com/questions/577724/trouble-playing-wav-in-java/
    // NOT AN EXACT COPY. 
    // I put the code in a seperate thread so the playing
    // of the sound does not influence any other processes
    public static synchronized void playSound(String f)
    {
		new Thread(new Runnable() 
        {
		    public void run() 
            {
			    try 
                {
				    URL url = this.getClass().getClassLoader().getResource(f);
				    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				    Clip clip = AudioSystem.getClip();

				    clip.open(audioIn);
				    clip.start();
			    } 
                catch (UnsupportedAudioFileException e) 
                {
				    e.printStackTrace();
                }
                catch (IOException e)
                {
				    e.printStackTrace();
                }
                catch (LineUnavailableException e)
                {
				    e.printStackTrace();
			    }
		    }
		}).start();
	}

	// Called to update game mechanics
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}


	// When the arrow keys are released, leftDown and RightDown
	// are reset, to stop the Player from moving indefinitely.
	public void keyReleased(KeyEvent e)
	{
	}

	// Checks to see if the left or right arrows are down
	// along with the space bar
	public void keyPressed(KeyEvent e)
    {
		
	}

	// Unused KeyEvent and MouseEvent methods
    public void keyTyped(KeyEvent e){}
    public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}