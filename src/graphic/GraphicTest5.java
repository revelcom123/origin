package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



class DrawArc extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 200, 200);
		
		g.setColor(Color.BLACK);
		g.drawArc(90,100,50,50,0,180);
		
		g.setColor(Color.BLACK);
		g.drawArc(160,100,50,50,0,180);

		g.setColor(Color.BLACK);
		g.drawArc(120,150,70,70,170,200);
		
		
		
//		g.setColor(Color.YELLOW);
//		g.fillOval(300, 200, 200, 200);
//		
//		g.setColor(Color.BLACK);
//		g.drawArc(90,100,50,50,0,180);
//		
//		g.setColor(Color.BLACK);
//		g.drawArc(160,100,50,50,0,180);
//
//		g.setColor(Color.BLACK);
//		g.drawArc(120,150,70,70,170,200);
		
//		//원호
//		g.setColor(Color.RED);
//		g.drawArc(20, 100, 80, 80, 90, 270);
//		
//		//마름모
//		int x[]= {200,150,200,250};
//		int y[]= {50,100,150,100};
//		g.drawPolygon(x, y, 4);
	}
}

	
	
	
	
	
	public class GraphicTest5 extends JFrame {
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicTest5 frame = new GraphicTest5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphicTest5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new DrawArc());
		
	}

}
