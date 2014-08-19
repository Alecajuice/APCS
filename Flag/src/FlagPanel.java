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
		g.setColor(Color.BLUE);
		g.fillRect(0, 100, 10, 10);
		g.setColor(new Color(224, 22, 43));
		g.fillRect(50 + 760/2, 100, (this.getWidth()) - (760/2), (int) Math.round(76.9/2));
		g.fillRect(50 + 760/2, 100 + (int) Math.round(76.9/2) * 2, (1900/2) - (760/2), (int) Math.round(76.9/2));
		g.fillRect(50 + 760/2, 100 + (int) Math.round(76.9/2) * 4, (1900/2) - (760/2), (int) Math.round(76.9/2));
		g.fillRect(50 + 760/2, 100 + (int) Math.round(76.9/2) * 6, (1900/2) - (760/2), (int) Math.round(76.9/2));
		g.fillRect(50, 100 + (int) Math.round(76.9/2) * 8, 1900/2, (int) Math.round(76.9/2));
		g.fillRect(50, 100 + (int) Math.round(76.9/2) * 10, 1900/2, (int) Math.round(76.9/2));
		g.fillRect(50, 100 + (int) Math.round(76.9/2) * 12, 1900/2, (int) Math.round(76.9/2));
		g.setColor(new Color(0, 38, 100));	
		g.fillRect(50, 100, 760/2, (int) Math.round(538.5/2));
		try {
			BufferedImage ster = ImageIO.read(new File("ster.png"));
		boolean alternate = true;
		for (int i = 1; i <= 11; i++)
		{
			for (int j = 1; j <= 9; j++)
			{
				if(alternate)
				{
					g.drawImage(ster, 50 + i * 63/2 - (int) Math.round(61.6/4), 100 + (int)(j * 54/2) - (int) Math.round(61.6/4), (int) Math.round(61.6/2), (int) Math.round(61.6/2), null);
					alternate = false;
				}
				else
				{
					alternate = true;
				}
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawSter(Graphics g, int x, int y)
	{
		
	}
	//Stolen code from the internet: creds to Syd Kerckhove and Se Norm on Stack Overflow
	
}

