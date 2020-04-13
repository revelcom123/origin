package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JTabletest1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTabletest1 frame = new JTabletest1();
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
	public JTabletest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("출력");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
//			 1. 모델 가져오기
			TableModel model = table.getModel();
			System.out.println("이름" t나이");"
					//2. 모델의 내용 출력하기
					for(int i=0;i<model.getRowCount();i++) {
						for(int j=0;j<model.getColumnCount();j++) {
							System.out.println(model.getValueAt(i, j)+"t");
						}
						System.out.println();
					
					}
});
	
	
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"khh", "30"},
				{"kww", "34"},
				{"kzz", "38"},
			},
			new String[] {
				"\uC774\uB984", "\uB098\uC774"
			}
		));
		scrollPane.setViewportView(table);
	

		
	}

}

