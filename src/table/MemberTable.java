package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.MemberDAO;
import database.MemberVO;

public class MemberTable extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtGender;
	private JTextField txtGetNo;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	
	private MemberDAO dao;
	//전체조회
	private DefaultTableModel model;
	//하나조회
	private DefaultTableModel model1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberTable frame = new MemberTable();
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
	public MemberTable() {
		setTitle("회원정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//DB객체 생성
		dao = new MemberDAO();
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("회원등록", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("나이");
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		txtAge = new JTextField();
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		txtGender = new JTextField();
		panel.add(txtGender);
		txtGender.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("회원조회", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("회원번호");
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_3);
		
		txtGetNo = new JTextField();
		panel_4.add(txtGetNo);
		txtGetNo.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		model1 = getModel();
		table = new JTable(model1);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setViewportView(table);
		panel_1.add(scrollPane1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("회원수정", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("수정할 회원 정보 입력");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 18));
		panel_2.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("번호");
		lblNewLabel_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("나이");
		lblNewLabel_6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("회원삭제", null, panel_3, null);
		
		JLabel lblNewLabel_7 = new JLabel("회원번호");
		lblNewLabel_7.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		panel_3.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("삭제");
		panel_3.add(btnNewButton_2);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("회원전체조회", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		//memberTBL의 전체 내용 가져오기		
		table_1 = new JTable(getModel());
		list();
		scrollPane.setViewportView(table_1);	
		
		//회원등록 화면의 성별
		txtGender.addActionListener(this);
	}
	
	public DefaultTableModel getModel() {
		String columnNames[]= {"번호","이름","나이","성별"};
		model = new DefaultTableModel(columnNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {			
				return false;
			}
		};
		return model;
	}
	
	
	public void list() {
		Vector<MemberVO> vecList=dao.getList();
		
		//vecList에 들어있는 값을 table에 보여주기
		for(MemberVO vo:vecList) {
			Object[] objList= {vo.getNo(),vo.getName(),vo.getAge(),vo.getGender()};
			model.addRow(objList);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==txtGender) {
			//이름과 나이와 성별을 가져온 후 
			MemberVO vo = new MemberVO();
			vo.setName(txtName.getText());
			vo.setAge(Integer.parseInt(txtAge.getText()));
			vo.setGender(txtGender.getText());
			
			//데이터베이스에 입력하기
			int result = dao.insert(vo);
			
			if(result>0) { //성공
				JOptionPane.showMessageDialog(this, "입력성공");
				//모델이 가지고 있었던 데이터 초기화
				model.setNumRows(0);
				list();
			}else { //실패
				JOptionPane.showMessageDialog(this, "입력실패");
			}
		}else if(e.getActionCommand().equals("조회")) {
			//사용자가 입력한 번호 가져오기
			int no = Integer.parseInt(txtGetNo.getText());
			//번호에 해당하는 정보 가져온 후 보여주기
			MemberVO vo = dao.getRow(no);
			Object[] rowData = {vo.getNo(),vo.getName(),vo.getAge(),vo.getGender()};
			model1.addRow(rowData);
		}else if(e.getActionCommand().equals("수정")) {
			
		}
	}else if(e.getActionComand().equals("수정")) {
		system.out.println("원격저장소 저장");

		
	}

}









