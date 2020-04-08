package layout;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutTest1 extends JFrame{
	public CardLayoutTest1() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("카드 레이아웃");
		
		JPanel redCard = new JPanel();
		redCard.setBackground(Color.RED);
		JPanel blueCard = new JPanel();
		blueCard.setBackground(Color.BLUE);
		JPanel orangeCard = new JPanel();
		orangeCard.setBackground(Color.ORANGE);
		
		setLayout(new CardLayout());
		add("RedCard",redCard);
		add("BlueCard",blueCard);
		add("OrangeCard",orangeCard);
		
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		CardLayoutTest1 card = new CardLayoutTest1();

	}

}
