package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class JMenuTest extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextArea textArea;
	private JMenuItem mnNew,mnOpen,mnSave,mnExit,mnCancel,mnCut,mnCopy,mnPaste,mnAll,mnDate;
	private UndoManager undo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JMenuTest frame = new JMenuTest();
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
	public JMenuTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일(F)");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		mnNew = new JMenuItem("새로 만들기(N)");
		mnNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnNew);
		
		mnOpen = new JMenuItem("열기(O)");
		mnOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnOpen);
		
		mnSave = new JMenuItem("저장(S)");
		mnSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnSave);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		mnExit = new JMenuItem("끝내기(X)");
		mnNewMenu.add(mnExit);
		
		JMenu mnNewMenu_1 = new JMenu("편집(E)");
		mnNewMenu_1.setMnemonic('E');
		menuBar.add(mnNewMenu_1);
		
		mnCancel = new JMenuItem("실행취소");
		mnCancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCancel);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mnCut = new JMenuItem("잘라내기");
		mnCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCut);
		
		mnCopy = new JMenuItem("복사");
		mnCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCopy);
		
		mnPaste = new JMenuItem("붙여넣기");
		mnPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnPaste);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mnAll = new JMenuItem("모두선택");
		mnAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnAll);
		
		mnDate = new JMenuItem("시간/날짜");
		mnDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnNewMenu_1.add(mnDate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("나눔고딕", Font.PLAIN, 21));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		undo = new UndoManager();
		textArea.getDocument().addUndoableEditListener(undo);
			
		mnNew.addActionListener(this);
		mnOpen.addActionListener(this);
		mnSave.addActionListener(this);
		mnExit.addActionListener(this);
		mnCancel.addActionListener(this);
		mnCut.addActionListener(this);
		mnCopy.addActionListener(this);
		mnPaste.addActionListener(this);
		mnAll.addActionListener(this);
		mnDate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menu = (JMenuItem)e.getSource();
		
		if(menu==mnNew) {
			//textArea에 내용이 있다면 현재 내용에 대한
			if(textArea.getText().length()>0) {
				//변경 여부를 묻는 창을 하나 띄운 후
				String options[]= {"저장","저장안함","취소"};
				int retVal=JOptionPane.showOptionDialog(this, "변경 내용을 제목없음에 저장하시겠습니까?",
						"메모장", JOptionPane.DEFAULT_OPTION, -1, null,
						options, options[0]);
				
				//사용자의 선택 여부에 따라 일을 수행한 후
				//새창 보여주기
				if(retVal==0) { //저장
					save();
				}else if(retVal==1) { //저장안함
					textArea.setText("");
				}else {//취소
					return;
				}
			}
		}else if(menu==mnOpen) {
			JFileChooser choo = getChooser();
			//열기 or 취소
			int retVal=choo.showOpenDialog(this);
			
			if(retVal==0) { //열기 버튼 클릭한 경우
				File file = choo.getSelectedFile();
				//Reader 이용해서 읽어온 후 
				//textArea에 보여주기
//				try(BufferedReader reader=
//						new BufferedReader(new FileReader(file.getPath()))){}
				
				//한글
				try(BufferedReader reader=new BufferedReader
						(new InputStreamReader
								(new FileInputStream(file.getPath()),"ms949"))) {
					String msg;
					while((msg=reader.readLine())!=null) {
						textArea.append(msg+"\n");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}else { //취소 버튼 클릭한 경우
				return;
			}			
		}else if(menu==mnSave) {
			save();
		}else if(menu==mnExit) {
			System.exit(0);
		}else if(menu==mnCancel) {
			undo.undo();
		}else if(menu==mnCut) {
			textArea.cut();
		}else if(menu==mnCopy) {
			textArea.copy();
		}else if(menu==mnPaste) {
			textArea.paste();
		}else if(menu==mnAll) {
			textArea.selectAll();
		}else if(menu==mnDate) {
			// y : 년도, M : 월, d : 일,  h : 시, m : 분, s : 초
			// a : am/pm
			SimpleDateFormat format = new SimpleDateFormat("a h:mm yyyy-MM-dd");
			//textArea.replaceSelection(format.format(new Date()));
			textArea.insert(format.format(new Date()), textArea.getCaretPosition());
		}		
	}
	
	//JFileChooser 객체 생성 후 리턴
	private JFileChooser getChooser() {
		JFileChooser chooser = new JFileChooser();
		//기존 필터 값 지우기
		chooser.setAcceptAllFileFilterUsed(false);
		//필터 추가하기
		chooser.addChoosableFileFilter(new FileNameExtensionFilter
				("텍스트파일(*.txt)", "txt"));
		chooser.setSelectedFile(new File("*.txt"));
		return chooser;
	}
	
	private void save() {
		JFileChooser chooser = getChooser();		
		int retVal=chooser.showSaveDialog(this);
		if(retVal==0) { //저장
			//사용자가 입력한 파일명을 가져와서 해당 경로에
			//현재 textArea 값을 파일로 저장한다.
			//BufferedWriter(FileWriter)
			File file = chooser.getSelectedFile();
			
			if(file.getPath().lastIndexOf(".")<0) {
				file = new File(file.getPath()+".txt");
			}
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
					String str = textArea.getText();
					System.out.println(file.getPath());  // C:\Users\컴퓨터이름/Documents/1010
					//엔터 반영
					str = str.replaceAll("\n", "\r\n");
					bw.write(str);
			
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
	}
	
}
















