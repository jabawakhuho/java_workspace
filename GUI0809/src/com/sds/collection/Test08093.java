package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Test08093 extends JFrame{
	JPanel p;
	JTable table;
	TableModel model;
	JScrollPane scroll;
	JTextField t_id;
	JTextField t_name;
	JTextField t_pwd;
	JLabel id;
	JLabel name;
	JLabel pwd;
	JButton bt1;
	JButton bt2;
	
	
	public Test08093() {
		p = new JPanel();
		id = new JLabel("ID");
		name = new JLabel("이름");
		pwd = new JLabel("비번");
		t_id = new JTextField(10);
		t_name = new JTextField(10);
		t_pwd = new JTextField(10);
		bt1 = new JButton("등록");
		bt2 = new JButton("목록");
		model = new myTable();
		table = new JTable(model);
		scroll = new JScrollPane(table);
		

		
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "등록"){
					String t1 = t_id.getText();
					String t2 = t_name.getText();
					String t3 = t_pwd.getText();
					setArr(t1,t2,t3);
				}
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "목록"){
					getTable();
				}
			}
		});
		
		p.setLayout(new FlowLayout());
		p.add(id);
		p.add(t_id);
		p.add(name);
		p.add(t_name);
		p.add(pwd);
		p.add(t_pwd);
		p.add(bt1);
		p.add(bt2);
		p.setPreferredSize(new Dimension(150,500));
		
		
		add(p,BorderLayout.WEST);
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	}
	//배열 추가 등록
	public void setArr(String id, String name, String pwd){
		String[] txt = {id,name,pwd};
		((myTable)model).setListTest(txt);
//		System.out.println(list.size());
	}
	//JTable에 모델 추가하기
	public void getTable(){
		table.setModel(model);
		table.updateUI();
	}
	
	public static void main(String[] args) {
		new Test08093();
	}

}
