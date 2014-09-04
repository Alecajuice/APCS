import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class BotFrame extends JFrame implements KeyListener, ActionListener
{
	Bot bot = new Bot();
	ArrayList<JLabel> historyElements = new ArrayList<JLabel>();
	JPanel frameContent;
	JPanel history;
	JScrollPane scrollPane;
	JTextField input;
	JButton enter;
	
	public BotFrame()
	{
		super();
		this.setSize(1000, 1000);
		addKeyListener(this);
		frameContent = new JPanel(null);
		this.add(frameContent);
		history = new JPanel();
		input = new JTextField();
		input.setBounds(0, 0, frameContent.getWidth(), 20);
		scrollPane = new JScrollPane(history);
		scrollPane.setPreferredSize(new Dimension(300, 250));
        scrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.black));
        enter = new JButton("Enter");
		enter.addActionListener(this);
        frameContent.add(scrollPane);
		frameContent.add(input);
		frameContent.add(enter);
//		for(int i = 0; i < 1000; i++)
//		history.add(new JLabel("hi"));
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		initFrame();
		new ResizeThread(this).start();
	}
	
	private void initFrame()
	{
//		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.pack();
	}
	
	public void resize()
	{
		frameContent.setBounds(0, 0, this.getWidth() - 30, this.getHeight() - 50);
		input.setBounds(0, scrollPane.getHeight(), frameContent.getWidth() - 100, 20);
		enter.setBounds(input.getWidth(), scrollPane.getHeight(), 100, 20);
		scrollPane.setBounds(0, 0, frameContent.getWidth(), frameContent.getHeight() - 40);
	}

	public void resetHistory()
	{
		history.setLayout(new GridLayout(historyElements.size() + 1, 1));
		history.removeAll();
		for(Object o: historyElements)
		{
			history.add((JLabel)o);
		}
	}
	
	public void enter()
	{
		bot.input(input.getText());
		historyElements.add(new JLabel("You: " + input.getText()));
		input.setText("");
		resetHistory();
		System.out.println("hi");
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("i");
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_ENTER)
		{
			enter();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("hi");
		try {
			JButton b = (JButton)e.getSource();
			if(b.equals(enter))
			{
				enter();
			}
		} catch(Exception e1) {
		}
	}
	
	class ResizeThread extends Thread
	{
		private BotFrame f;
		public ResizeThread(BotFrame f)
		{
			this.f = f;
		}
		
		public void run()
		{
	        while(true)
	        {
	        	resize();
	        }
	    }

		public void resize()
		{
			frameContent.setBounds(0, 0, f.getWidth() - 30, f.getHeight() - 50);
			input.setBounds(0, scrollPane.getHeight(), frameContent.getWidth() - 100, 20);
			enter.setBounds(input.getWidth(), scrollPane.getHeight(), 100, 20);
			scrollPane.setBounds(0, 0, frameContent.getWidth(), frameContent.getHeight() - 40);
		}
	}
}

