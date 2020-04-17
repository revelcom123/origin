package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GraphicTest6 extends JFrame {

class MyCanvas6 extends JPanel implements ActionListener{
	public MyCanvas6() {
		setBackground(Color.CYAN);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
	
	
	private Timer timer;
	private JPanel contentPane;
	private int posX,posY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicTest6 frame = new GraphicTest6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				posX = 0;
				posY = 250;
				timer = new Timer(20,this);
				timer.start();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphicTest6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new MyCanvas6());
	}

}
