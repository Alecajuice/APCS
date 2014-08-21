import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FlagPanel extends JPanel
{
	public FlagPanel()
	{
		super();
//		this.setSize(1900, 1000);
//		this.setBackground(Color.WHITE);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		drawStripes(g);
		drawUnion(g);
	}
	public void drawStripes(Graphics g)
	{
		//Old Glory Red
		g.setColor(new Color(224, 22, 43));
		//draw stripes
		for(int i = 0; i < 13; i++)
		{
			if(i%2 == 0)
			{
				if(i < 8)
				{
					//shorter stripes
					g.fillRect((int) Math.round(this.getHeight() * 0.76), i * (int) Math.round(this.getHeight() * 0.0769), (int) Math.round(this.getHeight() * 1.14), (int) Math.round(this.getHeight() * 0.0769));
				}
				else
				{
					//longer stripes
					g.fillRect(0, i * (int) Math.round(this.getHeight() * 0.0769), (int) Math.round(this.getHeight() * 1.9), (int) Math.round(this.getHeight() * 0.0769));
				}
			}
		}
	}
	public void drawUnion(Graphics g)
	{
		//Old Glory Blue
		g.setColor(new Color(0, 38, 100));	
		//draw blue background
		g.fillRect(0, 0, (int) Math.round(this.getHeight() * 0.76), (int) Math.round(this.getHeight() * 0.5385));
		//draw stars
		boolean alternate = true;
		for (int i = 1; i <= 11; i++)
		{
			for (int j = 1; j <= 9; j++)
			{
				if(alternate)
				{
					//only draw the star every other loop
					drawSter(g, i * (int) Math.round(this.getHeight() * 0.063), j * (int) Math.round(this.getHeight() * 0.054));
					alternate = false;
				}
				else
				{
					alternate = true;
				}
			}
		}
	}
	public void drawSter(Graphics g, int x, int y)
	{
		//Took Nihar's code and tweaked it
		g.setColor(Color.WHITE);
		//Point arrays for drawing stars
		int[] polyX = new int[10];
		int[] polyY = new int[10];
		//72 degrees in radians
		double starAngle = Math.PI/5;
		//radius of star
		int radius = (int) Math.round(this.getHeight() * 0.0308);
		//find the points of the star
		for(int i = 0; i < 10; i++)
		{
			if (i % 2 == 0)
			{
				//Divide radius by 2 to get inner points
				polyX[i] = (int) (x + Math.round(radius/2 * Math.sin(i * starAngle)));
				polyY[i] = (int) (y + Math.round(radius/2 * Math.cos(i * starAngle)));
			}
			else
			{
				polyX[i] = (int) (x + Math.round(radius * Math.sin(i * starAngle)));
				polyY[i] = (int) (y + Math.round(radius * Math.cos(i * starAngle)));
			}
		}
		//Draw the star
		g.fillPolygon(polyX, polyY, 10);
	}
}

