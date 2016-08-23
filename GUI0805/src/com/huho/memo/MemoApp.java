//JFileChooser의 초기 path가 지정되어있음 -> 맴버변수명 path;

package com.huho.memo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.transform.OutputKeys;

public class MemoApp extends JFrame implements ActionListener, FileMenu {
	JMenuBar menuBar;
	JMenu[] menu;
	JMenuItem[] menuItem;
	String[] menuList = { "파일(F)", "편집(E)", "보기(V)", "검색(S)", "문서(D)", "프로젝트(P)", "도구(T)", "브라우저(B)", "ZC", "창(W)",
			"도움말(H)" };
	String[] fileItem = { "새파일", "열기", "닫기", "저장", "새이름으로저장", "종료" };
	JPanel p_center;
	JPanel p_line;
	JPanel p_area;
	JTextArea area;
	JScrollPane scroll;
	ArrayList<JPanel> lineList;// LineNum들을 담기 위한 배열
	int lineNum = 1;
	JFileChooser chooser;
	FileReader reader;
	StringReader reader2;
	FileWriter writer;
	BufferedReader buffr;
	BufferedWriter buffw;
	String path = "C:/java_workspace/workspace/GUI0812/res";// JFileChooser의 초기
															// path가 지정
	StringBuffer sb;
	Thread thread; // menuItem Enable을 처리하기 위한 Thread

	public MemoApp() {
		menuBar = new JMenuBar();
		p_center = new JPanel(new BorderLayout());
		p_center.setBackground(Color.DARK_GRAY);
		chooser = new JFileChooser(path);
		sb = new StringBuffer();

		createMenu();
		createMenuItem(0);

		thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						closeEnabled();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		};
		thread.start();

		add(menuBar, BorderLayout.NORTH);
		add(p_center);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 800);
		setVisible(true);

	}

	// Menu들은 만들어 MenuBar에 추가한다.
	public void createMenu() {
		menu = new JMenu[menuList.length];
		for (int i = 0; i < menuList.length; i++) {
			JMenu m = new JMenu(menuList[i]);
			menu[i] = m;
			menuBar.add(menu[i]);
		}
	}

	// 메뉴아이템들 만들어 해당 menu에 추가한다.
	public void createMenuItem(int index) {
		menuItem = new JMenuItem[fileItem.length];
		for (int i = 0; i < fileItem.length; i++) {
			JMenuItem m = new JMenuItem(fileItem[i]);
			menuItem[i] = m;
			menuItem[i].addActionListener(this);
			if (i == 3 || i == 5) {
				menu[index].addSeparator();
			}
			menu[index].add(menuItem[i]);

		}
	}

	// p_line에 LineNum을 만들어 붙인다.
	public void creatLineNum(int i) {
		JPanel p = new LineNum(i);
		lineList.add(p);
		p_line.add(p);
		p_line.updateUI();
	}

	// area 에따른 닫기,저장,다른이름으로저장 매뉴아이템의 Enable처리
	public void closeEnabled() {
		if (scroll != null) {
			menuItem[2].setEnabled(true);
			menuItem[3].setEnabled(true);
		} else {
			menuItem[2].setEnabled(false);
			menuItem[3].setEnabled(false);
		}
		// 다른이름저장
		if (getTitle() != "") {
			menuItem[4].setEnabled(true);
		} else {
			menuItem[4].setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == menuItem[0]) {
			newOpenFile(); // 새파일
		} else if (obj == menuItem[1]) {
			openFile(); // 열기
		} else if (obj == menuItem[2]) {
			if (getTitle() == ""&&scroll!=null) {
				switch(JOptionPane.showConfirmDialog(this, "저장하지않고 종료하시겠습니까?")){
					case JOptionPane.OK_OPTION : closeFile(); break;
					case JOptionPane.NO_OPTION : saveFile();
					exidFrame(); JOptionPane.showMessageDialog(this, "저장완료되었습니다.");break;
				}
			}else{
				closeFile();// 닫기
			}
		} else if (obj == menuItem[3]) {
			saveFile();// 저장
		} else if (obj == menuItem[4]) {
			saveAsFile();// 다른이름으로 저장
		} else if (obj == menuItem[5]) {
			exidFrame();// 종료
		}
	}

	@Override
	public void newOpenFile() {
		if (scroll == null) {
			p_line = new JPanel();
			lineList = new ArrayList<JPanel>();
			area = new JTextArea();
			scroll = new JScrollPane(area);
			// area에 키이벤트 구현
			area.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						++lineNum;
						creatLineNum(lineNum);
					} /*
						 * else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						 * if (lineNum != 1) { // 삭제시 p_line의 jpanel삭제
						 * p_line.remove(lineList.get(lineNum - 1));
						 * p_line.updateUI(); --lineNum; } }
						 * //System.out.println(lineNum);
						 */
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});

			p_line.setPreferredSize(new Dimension(20, 800));
			if (lineNum == 1) {
				creatLineNum(lineNum);
			} else {
				for (int i = 0; i < lineNum; i++) {
					creatLineNum(i);
				}
			}
			p_center.add(p_line, BorderLayout.WEST);
			p_center.add(scroll);
			p_center.updateUI();
			closeEnabled();
		} else {
			JOptionPane.showMessageDialog(this, "열려있던 파일이 저장하지않고 닫힘니다.");
		}
	}

	@Override
	public void openFile() {
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			/*System.out.println(getTitle());
			System.out.println(file.getAbsolutePath());
			System.out.println(getTitle().equals( file.getAbsolutePath()));*/
			if (getTitle().equals( file.getAbsolutePath())) {
				JOptionPane.showMessageDialog(this, "이미 열고있는 파일입니다.");
			} else {
				setTitle(file.getAbsolutePath());
				try {
					reader = new FileReader(file);
					buffr = new BufferedReader(reader);
					String data;
					sb = new StringBuffer();
					while ((data = buffr.readLine()) != null) {
						sb.append(data + "\n");
						lineNum++;
						// System.out.println(lineNum);
					}
					newOpenFile();
					area.setText(sb.toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (buffr != null) {
						try {
							buffr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@Override
	public void closeFile() {
			p_center.removeAll();
			scroll = null;// scroll 초기화
			lineNum = 1; //linNum 초기화
			p_center.updateUI();
			setTitle("");
	}

	@Override
	public void saveFile() {
		if (getTitle() == "") {
			nonTitle();
		} else {
			hasATitle();
		}
	}

	@Override
	public void saveAsFile() {
		saveFile();
		nonTitle();
	}

	@Override
	public void exidFrame() {
		System.out.println("exid");
		if (getTitle() == ""&&scroll!=null) {
		switch(JOptionPane.showConfirmDialog(this, "저장하지않고 종료하시겠습니까?")){
			case JOptionPane.OK_OPTION : dispose(); break;
			case JOptionPane.NO_OPTION : saveFile();
			exidFrame(); JOptionPane.showMessageDialog(this, "저장완료되었습니다.");break;
		}
		}else{
			dispose();
		}
		// System.exit(0);
	}

	// 처음 저장 즉 해당 파일을 생성하여 저장하여야할경우
	@Override
	public void nonTitle() {
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				writer = new FileWriter(file);
				reader2 = new StringReader(area.getText());
				buffr = new BufferedReader(reader2);
				String data;
				sb = new StringBuffer();
				while ((data = buffr.readLine()) != null) {
					sb.append(data + "\n");
				}
				writer.write(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
						buffr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			setTitle(file.getAbsolutePath());
		}
	}

	// 타이틀 즉 파일이 이미 존재하는 경우
	@Override
	public void hasATitle() {
		String path = getTitle();
		try {
			writer = new FileWriter(path);
			reader2 = new StringReader(area.getText());
			buffr = new BufferedReader(reader2);
			String data;
			sb = new StringBuffer();
			while ((data = buffr.readLine()) != null) {
				sb.append(data + "\n");
			}
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new MemoApp();
	}
}
