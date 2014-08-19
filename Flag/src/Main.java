import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.add(new FlagPanel());
	}
}
