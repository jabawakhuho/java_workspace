package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame {
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;
	FileReader reader; // ���ڰ� ������ �ʱ����� ��Ʈ����ü
	BufferedReader buffr; // �о���϶� �� �پ� �о���̱� ���� ��Ʈ��

	public Editor() {
		bt = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		chooser = new JFileChooser("C:/java_workspace/GUI0811/res");

		add(bt, BorderLayout.NORTH);
		add(scroll);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);

	}

	// ���� ������ ������ ���پ� �о�� area�� �������!!!
	// =�������� ���� ����
	public void openFile() {
		int result = chooser.showOpenDialog(this);

		if (result == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				String data = null;
				while ((data = buffr.readLine()) != null) {
					area.append(data + "\n");
				}
				JOptionPane.showMessageDialog(this, "�б� �Ϸ�");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// �޸� ���� ���� ����� ���� ��ü �ϳ��� �ϸ� �ȴ�.
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

	public static void main(String[] args) {
		new Editor();
	}

}
