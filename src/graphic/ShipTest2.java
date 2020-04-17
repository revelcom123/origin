package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
class Ship2 extends JPanel implements ActionListener{
	private BufferedImage img;	
	private Timer timer;
	private int posX, posY;
	private boolean left = true, right = true, up = true, down = true, fire = true;
	private boolean start = true, end = true;
	
	public Ship2() {
		setBackground(Color.BLACK);
		try {
			URL url  = getClass().getResource("ship.jpg");
			img = ImageIO.read(new File(url.getFile()));
		} catch (IOException e) {		
			e.printStackTrace();
		}
		posX = 0;
		posY = 250;
		
//		timer = new Timer(20, this);
//		timer.start();
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				switch (KeyCode) {
				case KeyEvent.VK_LEFT:
					left = true;
					posX -= 10;
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					posX += 10;
					repaint();
					break;
				case KeyEvent.VK_UP:
					up = true;
					posY -= 10;
					repaint();
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					posY += 10;
					repaint();
					break;
				
	
				}
				
			}
			
		});
		}
	
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(img,posX,posY,null);
	}
//  움직임코

	}

public class ShipTest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipTest2 frame = new ShipTest2();
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
	public ShipTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		add(new Ship2());
	}

}
