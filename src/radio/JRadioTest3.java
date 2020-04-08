package radio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioTest3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioTest3 frame = new JRadioTest3();
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
	public JRadioTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.menuText, SystemColor.activeCaption, null, null));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("어떤 크기의 피자를 주문하시겠습니까?");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC0AC\uC774\uC988", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		
		JRadioButton rdosmall = new JRadioButton("Small Size");
		panel_1.add(rdosmall);
		
		JRadioButton rdomedium = new JRadioButton("Medium Size");
		panel_1.add(rdomedium);
		
		JRadioButton rdolarge = new JRadioButton("Large Size");
		panel_1.add(rdolarge);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(30);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdolarge);
		group.add(rdomedium);
		group.add(rdosmall);
		
		rdolarge.addActionListener(this);
		rdomedium.addActionListener(this);
		rdosmall.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		textField.setText(e.getActionCommand()+" 가 선택되었습니다.");
	}

}










