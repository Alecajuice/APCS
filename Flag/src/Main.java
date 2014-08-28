/*
 * Alex Tarng
 * 8/21/14
 * Period 6
 * 
 * THIS IS A FLAGGGGGGGGggGgGgGGGg!!!!11!1!1!one111!!eleven11one!!!!!onehundredone!!111!!1!!11!!
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
