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

public class TableText0810 extends JFrame implements ActionListener{
	JLabel id;	
	JLabel name;	
	JLabel pwd;
	JTextField t_id;
	JTextField t_name;
	JTextField t_pwd;
	JButton bt1;
	JButton bt2;
	JPanel p;
	TableModel model;
	JTable table;
	JScrollPane scroll;
	ArrayList<String[]> list;
	String[] column = {"ID","이름","비밀번호"};
	
	public TableText0810() {
		super("등록창");
		id = new JLabel("ID");
		name = new JLabel("이름");
		pwd = new JLabel("비번");
		t_id = new JTextField(10);
		t_name = new JTextField(10);
		t_pwd = new JTextField(10);
		bt1 = new JButton("등록");
		bt2 = new JButton("목록");
		p = new JPanel();
		list = new ArrayList<String[]>();
		//Data 초기화
				
		model = new AbstractTableModel() {
			
			@Override
			public Object getValueAt(int row, int col) {
				// TODO Auto-generated method stub
				return list.get(row)[col];
				//return list[row][col];
			}
			
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return list.size();
			}
			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return column.length;
			}
			
			public String getColumnName(int col){
				return column[col];
			}
		};
		table = new JTable(model);
		scroll = new JScrollPane(table);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		p.setLayout(new FlowLayout());
		p.add(id);
		p.add(t_id);
		p.add(name);
		p.add(t_name);
		p.add(pwd);
		p.add(t_pwd);
		p.add(bt1);
		p.add(bt2);
		
		
		p.setPreferredSize(new Dimension(150, 400));
		this.add(p,BorderLayout.WEST);
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand()=="등록"){
			setList();
		}else if(e.getActionCommand()=="목록"){
			table.setModel(model);
			table.updateUI();
		}
		
	}
	
	public void setList(){
		String s1 =t_id.getText();
		String s2 =t_name.getText();
		String s3 =t_pwd.getText();
		String[] ss = {s1,s2,s3};
		list.add(ss);	
		
	}
	
	public static void main(String[] args){
		new TableText0810();
	}

}
