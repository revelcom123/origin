package container;

import javax.swing.JFrame;

public class JFrameTest2 {
	public static void main(String[] args) {
		//컨테이너 생성하기
		JFrame f = new JFrame("첫번째 프로그램");
		// x 를 누르면 프로그램 종
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컨테이너의 크기 지정하기
		f.setSize(300, 300);
		//컨테이너 보여주기
		f.setVisible(true);

	}
}
