import java.awt.*;
import javax.swing.*;


public class AzJFrame extends JFrame{//hi
	final int WIDTH = 1787;
	final int HEIGHT = 1007;
	
	public AzJFrame(String framename) {
		super(framename);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		add(new AzJPanel());
		setVisible(true);
	}
}
