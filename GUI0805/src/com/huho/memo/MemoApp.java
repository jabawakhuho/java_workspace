//JFileChooser�� �ʱ� path�� �����Ǿ����� -> �ɹ������� path;

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
	String[] menuList = { "����(F)", "����(E)", "����(V)", "�˻�(S)", "����(D)", "������Ʈ(P)", "����(T)", "������(B)", "ZC", "â(W)",
			"����(H)" };
	String[] fileItem = { "������", "����", "�ݱ�", "����", "���̸���������", "����" };
	JPanel p_center;
	JPanel p_line;
	JPanel p_area;
	JTextArea area;
	JScrollPane scroll;
	ArrayList<JPanel> lineList;// LineNum���� ��� ���� �迭
	int lineNum = 1;
	JFileChooser chooser;
	FileReader reader;
	StringReader reader2;
	FileWriter writer;
	BufferedReader buffr;
	BufferedWriter buffw;
	String path = "C:/java_workspace/workspace/GUI0812/res";// JFileChooser�� �ʱ�
															// path�� ����
	StringBuffer sb;
	Thread thread; // menuItem Enable�� ó���ϱ� ���� Thread

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

	// Menu���� ����� MenuBar�� �߰��Ѵ�.
	public void createMenu() {
		menu = new JMenu[menuList.length];
		for (int i = 0; i < menuList.length; i++) {
			JMenu m = new JMenu(menuList[i]);
			menu[i] = m;
			menuBar.add(menu[i]);
		}
	}

	// �޴������۵� ����� �ش� menu�� �߰��Ѵ�.
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

	// p_line�� LineNum�� ����� ���δ�.
	public void creatLineNum(int i) {
		JPanel p = new LineNum(i);
		lineList.add(p);
		p_line.add(p);
		p_line.updateUI();
	}

	// area ������ �ݱ�,����,�ٸ��̸��������� �Ŵ��������� Enableó��
	public void closeEnabled() {
		if (scroll != null) {
			menuItem[2].setEnabled(true);
			menuItem[3].setEnabled(true);
		} else {
			menuItem[2].setEnabled(false);
			menuItem[3].setEnabled(false);
		}
		// �ٸ��̸�����
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
			newOpenFile(); // ������
		} else if (obj == menuItem[1]) {
			openFile(); // ����
		} else if (obj == menuItem[2]) {
			if (getTitle() == ""&&scroll!=null) {
				switch(JOptionPane.showConfirmDialog(this, "���������ʰ� �����Ͻðڽ��ϱ�?")){
					case JOptionPane.OK_OPTION : closeFile(); break;
					case JOptionPane.NO_OPTION : saveFile();
					exidFrame(); JOptionPane.showMessageDialog(this, "����Ϸ�Ǿ����ϴ�.");break;
				}
			}else{
				closeFile();// �ݱ�
			}
		} else if (obj == menuItem[3]) {
			saveFile();// ����
		} else if (obj == menuItem[4]) {
			saveAsFile();// �ٸ��̸����� ����
		} else if (obj == menuItem[5]) {
			exidFrame();// ����
		}
	}

	@Override
	public void newOpenFile() {
		if (scroll == null) {
			p_line = new JPanel();
			lineList = new ArrayList<JPanel>();
			area = new JTextArea();
			scroll = new JScrollPane(area);
			// area�� Ű�̺�Ʈ ����
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
						 * if (lineNum != 1) { // ������ p_line�� jpanel����
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
			JOptionPane.showMessageDialog(this, "�����ִ� ������ ���������ʰ� �����ϴ�.");
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
				JOptionPane.showMessageDialog(this, "�̹� �����ִ� �����Դϴ�.");
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
			scroll = null;// scroll �ʱ�ȭ
			lineNum = 1; //linNum �ʱ�ȭ
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
		switch(JOptionPane.showConfirmDialog(this, "���������ʰ� �����Ͻðڽ��ϱ�?")){
			case JOptionPane.OK_OPTION : dispose(); break;
			case JOptionPane.NO_OPTION : saveFile();
			exidFrame(); JOptionPane.showMessageDialog(this, "����Ϸ�Ǿ����ϴ�.");break;
		}
		}else{
			dispose();
		}
		// System.exit(0);
	}

	// ó�� ���� �� �ش� ������ �����Ͽ� �����Ͽ����Ұ��
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

	// Ÿ��Ʋ �� ������ �̹� �����ϴ� ���
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
