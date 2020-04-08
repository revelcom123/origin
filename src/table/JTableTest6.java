package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

public class JTableTest6 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest6 frame = new JTableTest6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTableTest6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 130);
		setTitle("MyTable");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTable table = new JTable(new MyTableModel());
		JScrollPane scrollPane = new JScrollPane(table);		
		contentPane.add(scrollPane);		
	}
	
	class MyTableModel extends AbstractTableModel{
		private String[] columnNames= {"First Name","Last Name",
                "Sport","# of Years","Vegetarian"};
		
		private Object[][] data = {
		        {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		        {"John", "Doe","Rowing", new Integer(3), new Boolean(true)},
		        {"Sue", "Black","Knitting", new Integer(2), new Boolean(false)},
		        {"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
		        {"Joe", "Brown","Pool", new Integer(10), new Boolean(false)}
		        };
		
		@Override
		public int getRowCount() {			
			return data.length;
		}
		@Override
		public int getColumnCount() {			
			return columnNames.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {			
			return data[rowIndex][columnIndex];
		}
		@Override
		public String getColumnName(int column) {		
			return columnNames[column];
		}			
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex < 2) {
				return false;
			}else {
				return true;
			}			
		}
		//true / false로 나오는 부분 체크박스로 나오게 만들기
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}				
	}

}
