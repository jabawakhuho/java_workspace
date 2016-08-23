package com.sds.project;

import java.awt.Choice;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class AddressFrame extends JFrame implements ItemListener, ActionListener {
	JButton bt_sub, bt_lay, bt_can;
	Choice ch_city, ch_gu;
	Choice ch_dong;
	String st_dong[];
	JTextField tf_sub;
	JTextArea ta_certify;
	JLabel lb_city, lb_certify, lb_gu, lb_tf;
	RegistForm registForm;
	
	public AddressFrame(RegistForm registForm) {
		this.registForm = registForm;
		// GridLayout gr= new GridLayout(3, 3);
		setLayout(null);

		ch_city = new Choice();
		lb_city = new JLabel("시");
		lb_gu = new JLabel("구");
		ch_dong = new Choice();
		lb_tf = new JLabel("상세주소");
		tf_sub = new JTextField();
		//bt_sub = new JButton("등록");
		//lb_certify = new JLabel("주소확인");
		//ta_certify = new JTextArea();
		bt_lay = new JButton("입력");
		bt_can = new JButton("취소");

		ch_city.add("선택▼");
		ch_city.add("서울시");
		ch_city.add("대전광역시");
		ch_city.add("광주광역시");
		ch_city.add("부산시");
		ch_city.add("대구광역시");
		ch_city.add("제주시");

		lb_city.setBounds(20, 10, 30, 30);
		ch_city.setBounds(50, 10, 150, 20);
		lb_gu.setBounds(220, 10, 30, 30);
		ch_dong.setBounds(250, 10, 150, 20);
		lb_tf.setBounds(10, 50, 70, 30);
		tf_sub.setBounds(80, 50, 250, 25);
		bt_lay.setBounds(340, 50, 70, 20);
		//lb_certify.setBounds(10, 100, 70, 20);
		//ta_certify.setBounds(80, 90, 300, 50);
		//bt_lay.setBounds(180, 180, 70, 20);

		add(lb_gu);
		add(lb_city);
		add(ch_city);
		add(lb_tf);
		add(tf_sub);
		//add(bt_sub);
		//add(lb_certify);
		//add(ta_certify);
		add(bt_lay);
		// add(bt_can);

		ch_dong.add("선택▼");
		add(ch_dong);

		ch_city.addItemListener(this);
		//bt_sub.addActionListener(this);
		bt_lay.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setSize(440, 200);
		setVisible(true);

	}

	public void DaeDong() {
		ch_dong.removeAll();
		ch_dong.add("서구");
		ch_dong.add("동구");
		ch_dong.add("중구");
		// add(ch_dong);

	}

	public void SeoulDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("동작구");
		ch_dong.add("노원구");
		ch_dong.add("강남구");
		// add(ch_dong);

	}

	public void DaeguDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("수성구");
		ch_dong.add("달서구");
		ch_dong.add("북구");
		// add(ch_dong);

	}

	public void GwangDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("북구");
		ch_dong.add("동구");
		ch_dong.add("광산구");
		// add(ch_dong);
	}

	public void BuDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("서구");
		ch_dong.add("동구");
		ch_dong.add("중구");
		// add(ch_dong);
	}

	public void JeDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("서귀포시");
		ch_dong.add("우도군");
		ch_dong.add("한라시");
		// add(ch_dong);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice ch = (Choice) e.getSource();
		String str = ch.getSelectedItem();

		if (str.equals("서울시")) {
			System.out.println("서울택했어?");
			SeoulDong();

		} else if (str.equals("대전광역시")) {
			System.out.println("대전택했어?");
			DaeDong();
		} else if (str.equals("광주광역시")) {
			System.out.println("광주택했어?");
			GwangDong();
		} else if (str.equals("부산시")) {
			System.out.println("부산택했어?");
			BuDong();
		} else if (str.equals("대구광역시")) {
			System.out.println("대구택했어?");
			DaeguDong();
		} else if (str.equals("제주시")) {
			System.out.println("제주택했어?");
			JeDong();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = ch_city.getSelectedItem();
		String str1 = ch_dong.getSelectedItem();
		Object obj = e.getSource();

		if (obj.equals(bt_sub)) {
			String msg = tf_sub.getText();
			System.out.println(str);
			ta_certify.append(str+"  "+str1+"  "+ msg );
			
			
		} else if (obj.equals(bt_lay)) {
			//System.out.println("입력눌렀어?");
			String msg = tf_sub.getText();
			registForm.ta_add1.setText(str+"  "+str1);
			registForm.ta_add2.setText(msg);
			this.dispose();
		}

	}

}