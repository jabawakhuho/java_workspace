package com.sds.Thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CounterPro extends JFrame implements Runnable, ActionListener {
	JButton bt;
	JPanel p1, p2;
	JLabel la_count;
	JProgressBar pro1, pro2;
	MyThread2 tr1; // 클래스 생성
	Thread tr2; // 내부입력
	Thread tr3; // Runnable
	int count, n1, n2;

	public CounterPro() {
		super("CounterPro");

		bt = new JButton("실행");
		p1 = new JPanel();
		p2 = new JPanel();

		la_count = new JLabel(Integer.toString(count));
		la_count.setFont(new Font("ariase blick", Font.BOLD, 120));
		pro1 = new JProgressBar();
		pro2 = new JProgressBar();
		tr1 = new MyThread2(this, 500);
		tr2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						tr2.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (n1 != 100) {
						n1++;
						pro1.setValue(n1);
					} else {
						n1 = 0;
					}
				}
			}
		};
		tr3 = new Thread(this);

		bt.addActionListener(this);
		p2.setPreferredSize(new Dimension(200, 350));
		pro1.setPreferredSize(new Dimension(200, 50));
		pro1.setBackground(Color.RED);
		pro2.setPreferredSize(new Dimension(200, 50));
		pro2.setBackground(Color.GREEN);
		p1.add(bt);
		p2.add(la_count);
		p2.add(pro1);
		p2.add(pro2);
		add(p1, BorderLayout.NORTH);
		add(p2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tr1.start();
		tr2.start();
		tr3.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				tr3.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (n2 != 100) {
				n2++;
				pro2.setValue(n2);
			} else {
				n2 = 0;
			}
		}
	}

	public static void main(String[] args) {
		new CounterPro();
	}
}
