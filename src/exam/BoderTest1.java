package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

public class BoderTest1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoderTest1 frame = new BoderTest1();
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
	public BoderTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
	
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black));
		border.setTitle("contentPane");
		border.setTitleFont(new Font("맑은 고딕",Font.BOLD,20));
		border.setTitleColor(Color.DARK_GRAY);
		border.setTitleJustification(TitledBorder.RIGHT); //타이틀 정렬(왼쪽, 가운데 ,오른쪽 )
		border.setTitlePosition(TitledBorder.BOTTOM); //타이틀 위치()
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.BLUE, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
