package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Profile extends JFrame {
	JPanel p_left;
	JPanel p_right;
	JButton bt;
	JScrollPane scroll;
	JFileChooser chooser;
	ProfileApp proApp;

	public Profile() {
		super("프로필APP");
		p_left = new JPanel();
		p_right = new JPanel();
		bt = new JButton("열기");
		
		scroll = new JScrollPane(p_right);
		chooser = new JFileChooser("C:/java_workspace/GUI0811/res");

		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		p_left.add(bt);
		p_left.setPreferredSize(new Dimension(100, 800));
		
		add(p_left, BorderLayout.WEST);

		add(scroll);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 800);
		setVisible(true);
	}
	//선택한 json 파일의 내용을 Data화 (ProfileApp에서 해석하여 list라는 2중 배열에 담음)
	public void getList() {
		int data;
		data = chooser.showOpenDialog(getParent());
		if (data == chooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			proApp = new ProfileApp(path);
			for (int i = 0; i < proApp.list.size(); i++) {
				getProfile(i);
			}
		}
	}
	//profile Jpanel생성 하는 매서드
	public void getProfile(int i) {
		// System.out.println(proApp.list.size());
		JLabel name = new JLabel("이름 : " + proApp.list.get(i)[0]);
		JLabel gender = new JLabel("성별 : " + proApp.list.get(i)[1]);
		JLabel age = new JLabel("나이 : " + proApp.list.get(i)[2]);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		Canvas can = new Canvas() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img = kit.getImage(proApp.list.get(i)[3]);

			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 200, 200, this);
			}
		};
		can.setPreferredSize(new Dimension(200, 200));
		p2.setPreferredSize(new Dimension(100, 180));
		name.setPreferredSize(new Dimension(100, 60));
		gender.setPreferredSize(new Dimension(100, 60));
		age.setPreferredSize(new Dimension(100, 60));
		
		p.add(can);
		p2.add(name);
		p2.add(gender);
		p2.add(age);

		p_right.add(p);
		p_right.add(p2);
		int lo = proApp.list.size()*300;
		p_right.setPreferredSize(new Dimension(400, lo));
		scroll.updateUI();
	}

	public static void main(String[] args) {
		new Profile();
	}

}
