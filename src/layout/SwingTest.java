package layout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingTest extends JFrame{
	public SwingTest() {
		setTitle("Swing App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				SwingTest swing = new SwingTest();
				System.out.println(Thread.currentThread().getName());
			}
		});
	}

}
