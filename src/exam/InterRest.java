package exam;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InterRest extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterRest frame = new InterRest();
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
	public InterRest() {
		setTitle("이자계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("원금을 입력하시오");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("\uC774\uC728\uC744 \uC785\uB825\uD558\uC2DC\uC624");
		label.setFont(new Font("굴림", Font.BOLD, 16));
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		textField_2 = new JTextField();
		JButton btnNewButton = new JButton("\uBCC0\uD658");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(Double.parseDouble(textField.getText()));
				//원금
				int money=Integer.parseInt(textField.getText());
				//이자
				double income=Double.parseDouble(textField_1.getText());				
				
				Integer m2=(int)(money+(money*(income/100)));
				textField_2.setText(m2+" 입니다.");				
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);		
		
		panel_3.add(textField_2);
		textField_2.setColumns(20);		
	}
}
