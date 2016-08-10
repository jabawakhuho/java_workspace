package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomeWork1 extends JFrame implements ActionListener {
	JLabel path;
	JLabel copyPath;
	JTextField t_path;
	JTextField t_copyPath;
	JButton bt_open;
	JButton bt_save;
	JButton bt_run;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;

	public HomeWork1() {
		path = new JLabel("원본경로");
		copyPath = new JLabel("저장경로");
		t_path = new JTextField(30);
		t_copyPath = new JTextField(30);
		bt_open = new JButton("열기");
		bt_save = new JButton("저장");
		bt_run = new JButton("실행");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		chooser = new JFileChooser("C:/java_workspace/GUI0810/res");

		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_run.addActionListener(this);

		p1.add(path);
		p1.add(t_path);
		p1.add(bt_open);
		p2.add(copyPath);
		p2.add(t_copyPath);
		p2.add(bt_save);
		p3.add(bt_run);

		/*
		 * p1.setPreferredSize(new Dimension(100, 50)); p3.setPreferredSize(new
		 * Dimension(100, 50));
		 */
		add(p1, BorderLayout.NORTH);
		add(p2);
		add(p3, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 150);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String obj = e.getActionCommand();
		
		switch (obj) {
		case "열기":	setPath();	break;
		case "저장":	setCopyPath();	break;
		case "실행":	getRun();	break;
		}

	}

	public void setPath() {
		int result = chooser.showOpenDialog(this);
		if (result == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			t_path.setText(path);
		}
	}

	public void setCopyPath() {
		int result = chooser.showSaveDialog(this);
		if (result == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			t_copyPath.setText(path);
		}
	}

	public void getRun() {
		try {
			fis = new FileInputStream(t_path.getText());
			fos = new FileOutputStream(t_copyPath.getText());
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사중 에러 발생");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("fis closing 중 에러발생");
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("fos closing 중 에러발생");
				}
			}
			JOptionPane.showMessageDialog(this, "완료");
		}
	}

	public static void main(String[] args) {
		new HomeWork1();
	}
}
