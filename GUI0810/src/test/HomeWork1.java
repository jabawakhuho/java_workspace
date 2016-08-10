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
		path = new JLabel("�������");
		copyPath = new JLabel("������");
		t_path = new JTextField(30);
		t_copyPath = new JTextField(30);
		bt_open = new JButton("����");
		bt_save = new JButton("����");
		bt_run = new JButton("����");
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
		case "����":	setPath();	break;
		case "����":	setCopyPath();	break;
		case "����":	getRun();	break;
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
			System.out.println("������ ã���� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ������ ���� �߻�");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("fis closing �� �����߻�");
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("fos closing �� �����߻�");
				}
			}
			JOptionPane.showMessageDialog(this, "�Ϸ�");
		}
	}

	public static void main(String[] args) {
		new HomeWork1();
	}
}
