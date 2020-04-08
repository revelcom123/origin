package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class RockScissorPaper extends JFrame implements ActionListener{
	private JTextField textField;
	
	private static final int ROCK=0;
	private static final int PAPER=1;
	private static final int SCISSOR=2;	
	
	private JButton btnRock,btnScissor,btnPaper;
	
	
	public RockScissorPaper() {
		setTitle("가위바위보");
		
		JLabel lblNewLabel = new JLabel("아래의 버튼 중에서 하나를 클릭하시오");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnRock = new JButton();		
		btnRock.setIcon(new ImageIcon(RockScissorPaper.class.getResource("/exam/rock.png")));
		btnRock.setActionCommand("ROCK");
		btnRock.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnRock);
		
		btnPaper = new JButton();		
		btnPaper.setIcon(new ImageIcon(RockScissorPaper.class.getResource("/exam/paper.png")));
		btnPaper.setActionCommand("PAPER");
		btnPaper.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnPaper);
		
		btnScissor = new JButton();
		btnScissor.setIcon(new ImageIcon(RockScissorPaper.class.getResource("/exam/scissor.png")));
		btnScissor.setActionCommand("SCISSOR");
		btnScissor.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(btnScissor);
		
		btnPaper.addActionListener(this);
		btnScissor.addActionListener(this);
		btnRock.addActionListener(this);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		RockScissorPaper rock = new RockScissorPaper();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//컴퓨터의 가위,바위,보 생성하기
		Random random = new Random();
		// random.nextInt(3) : 괄호안의 숫자는 미포함해서 0,1,2 중에서
		// 나오게 함
		int computer = random.nextInt(3);		
		
		//사용자가 누른 버튼의 값을 가져온 후
		//가위,바위,보를 해서 누가 이겼는지 
		//textField 에 보여주기
		String user = e.getActionCommand();
		System.out.println(user);
		if(user.equals("ROCK")) { //사용자가 주먹을 선택한 경우
			if(computer==ROCK) {
				textField.setText("비겼네");
			}else if(computer==SCISSOR) {
				textField.setText("내가 이겼네");
			}else {
				textField.setText("컴퓨터가 이겼네");
			}
		}else if(user.equals("PAPER")) {//사용자가 보를 선택한 경우
			if(computer==ROCK) {
				textField.setText("내가 이겼네");
			}else if(computer==SCISSOR) {
				textField.setText("컴퓨터가 이겼네");
			}else {
				textField.setText("비겼네");
			}
		}else { //사용자가 가위 선택한 경우
			if(computer==ROCK) {
				textField.setText("컴퓨터가 이겼네");
			}else if(computer==SCISSOR) {
				textField.setText("비겼네");
			}else {
				textField.setText("내가 이겼네");
			}
		}
		
	}
}







