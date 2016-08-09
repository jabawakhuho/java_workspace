package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Test0809 extends JFrame {
	JPanel p;
	Choice choice;
	JTable table;
	JScrollPane scroll;
	TableModel model;
	String[] modelItem = { "선택", "회원관리", "애완동물" };

	public Test0809() {
		choice = new Choice();
		p = new JPanel();
		table = new JTable();
		scroll = new JScrollPane(table);
		for (int i = 0; i < modelItem.length; i++) {
			choice.add(modelItem[i]);
		}
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = (String) e.getItem();
				setModel(item);
			}
		});

		p.add(choice);
		p.setBounds(0, 0, 100, 800);
		add(p, BorderLayout.WEST);
		add(scroll);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	}

	public void setModel(String item) {
		if (item == "회원관리") {
			table.setModel(model = new MemberModel());
		} else if (item == "애완동물") {
			table.setModel(model = new PetModel());
		} else {
			JOptionPane.showMessageDialog(this, "항목을 선택하여주세요");
		}
		table.updateUI(); // UI갱신!!!
	}

	public static void main(String[] args) {
		new Test0809();
	}
}
