package test;

import java.awt.FlowLayout;
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
import javax.swing.JTextField;

public class Homework0810 extends JFrame implements ActionListener {
	JLabel path;
	JLabel copyPath;
	JTextField t_path;
	JTextField t_copyPath;
	JButton bt_open;
	JButton bt_save;
	JButton bt_run;
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;

	public Homework0810() {
		super("���������ϱ�");
		path = new JLabel("����");
		copyPath = new JLabel("������");
		t_path = new JTextField(40);
		t_copyPath = new JTextField(40);
		bt_open = new JButton("����");
		bt_save = new JButton("Save");
		bt_run = new JButton("����");
		chooser = new JFileChooser("C:/java_workspace/GUI0810/res");

		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_run.addActionListener(this);

		setLayout(new FlowLayout());
		add(path);
		add(t_path);
		add(bt_open);
		add(copyPath);
		add(t_copyPath);
		add(bt_save);
		add(bt_run);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 150);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bt_open) {
			openFile();
		} else if (obj == bt_save) {
			saveFilePath();
		} else if (obj == bt_run) {
			copyFile();
		}
	}

	public void openFile() {
		int result = chooser.showOpenDialog(this);
		if (result == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			t_path.setText(path);
			t_path.updateUI();
		}
	}

	public void saveFilePath() {
		int result = chooser.showSaveDialog(this);
		if (result == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			// System.out.println(file);
			String copyPath = file.getAbsolutePath();
			t_copyPath.setText(copyPath);
			t_copyPath.updateUI();
		}
	}

	public void copyFile() {
		try {
			fis = new FileInputStream(t_path.getText());
			fos = new FileOutputStream(t_copyPath.getText());
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("���� Copy�� ���� �߻�");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// e.printStackTrace();
					System.out.println("fis Closeing �� �����߻�");
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// e.printStackTrace();
					System.out.println("fos Closeing �� �����߻�");
				}
			}
			JOptionPane.showMessageDialog(this, "���簡 �Ϸ�Ǿ����ϴ�.");
		}
	}

	public static void main(String[] args) {
		new Homework0810();
	}

}
