/*
 * Alex Tarng
 * 8/21/14
 * Period 6
 * 
 * THIS IS A FLAGGGGGGGGggGgGgGGGg!!!!11!1!1!one111!!eleven11one!!!!!onehundredone!!111!!1!!11!!
 * 
 * This is a fully resizable, scalable American flag that follows the exact ratios and colors of the actual American flag.
 * To scale the flag, resize the window and based on the size of the window, the flag will scale.
 * The Main class creates a JFrame and adds a FlagPanel (extends JPanel) to it. The FlagPanel class
 * contains the flag and all the methods, constants, and math to draw the flag. The flag is drawn on the
 * FlagPanel using its paint() method. The paint() method calls the setFlagHeight() method, which sets the height
 * of the flag based on the size on the window. All constants are derived from the height of the flag, so this
 * step defines all the dimensions correctly. Then, the paint() method calls all the encapsulated methods that
 * draws the stripes, the union, and the stars(drawStripes() and drawUnion() (which calls drawSter()).
 */

import java.awt.Color;

import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		//New JFrame for flag
		JFrame f = new JFrame();
		//New panel with flag drawn on it
		FlagPanel p = new FlagPanel();
		//Add panel to frame
		f.add(p);
		//Init frame
		f.setSize(1900, 1000);
		f.setBackground(Color.WHITE);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
