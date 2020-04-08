package exam;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConvertMile extends JFrame {
	private JPanel contentPane;
	
	public ConvertMile() {
		setTitle("마일 -> 킬로미터 변환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1));
		JPanel panel1 = new JPanel();
		JLabel label = new JLabel("거리를 마일 단위로 입력하세요");
		JTextField txtMile = new JTextField(10);
		panel1.add(label);
		panel1.add(txtMile);
		
		JPanel panel2 = new JPanel();
		JButton btn1 = new JButton("변환");		
		panel2.add(btn1);
		
		JPanel panel3 = new JPanel();		
		JTextField txtKm = new JTextField(30);		
		panel3.add(txtKm);
		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		setVisible(true);
	}
	public static void main(String[] args) {
		ConvertMile mile = new ConvertMile();
	}
}
