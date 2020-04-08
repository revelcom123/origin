package exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SimpleCalc2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtResult;
	private JButton btnPlus,btnReset;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDiv;
	private JLabel lblOper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc2 frame = new SimpleCalc2();
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
	public SimpleCalc2() {
		setTitle("사칙연산 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtOp1 = new JTextField();
		panel.add(txtOp1);
		txtOp1.setColumns(10);
		
		lblOper = new JLabel("?");
		lblOper.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(lblOper);
		
		txtOp2 = new JTextField();
		panel.add(txtOp2);
		txtOp2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		txtResult = new JTextField();
		panel.add(txtResult);
		txtResult.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		panel_1.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		panel_1.add(btnMinus);
		
		btnMulti = new JButton("*");
		btnMulti.addActionListener(this);
		panel_1.add(btnMulti);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(this);
		panel_1.add(btnDiv);
		
		btnReset = new JButton("reset");
		btnReset.addActionListener(this);
		panel_1.add(btnReset);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		JButton btn = (JButton)e.getSource();		
		int op1=Integer.parseInt(txtOp1.getText());
		int op2=Integer.parseInt(txtOp2.getText());
		int result=0;		
		if(btn==btnPlus) {
			lblOper.setText("+");
			result = op1+op2;			
		}else if(btn==btnMinus) {
			lblOper.setText("-");
			result = op1-op2;
		}else if(btn==btnMulti) {
			lblOper.setText("*");
			result = op1*op2;
		}else if(btn==btnDiv) {
			lblOper.setText("/");
			result = op1/op2;
		}else {
			//txtOp1, txtOp2, txtResult 내용 지우기
			txtOp1.setText("");
			txtOp2.setText("");
			txtResult.setText("");
		}	
		txtResult.setText(result+"");
	}

}








