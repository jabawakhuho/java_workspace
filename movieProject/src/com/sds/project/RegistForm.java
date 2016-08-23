package com.sds.project;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistForm extends JPanel implements ActionListener {
	JTextField tf_id, tf_name, tf_add, tf_cardnum, tf_cardpwd, tf_qa, tf_img;
	JTextField ta_add1, ta_add2;
	JButton bt_overlap, bt_find, bt_img, bt_enroll, bt_cancel;
	JLabel lb_tel, lb_title, lb_id, lb_pwd, lb_pwd2, lb_name, lb_add, lb_cardnum, lb_cardpwd, lb_qachoice, lb_qa,
			lb_img;
	JPanel p_title, p_id, p_pwd, p_pwd2, p_name, p_add, p_cardnum, p_cardpwd, p_qa, p_qachoice, p_img, p_bt;
	JPanel profile;
	Choice ch_qa;
	CheckboxGroup chg;
	Checkbox ch_male, ch_female;
	JPasswordField tf_pwd, tf_pwd2;
	JFileChooser chooser;
	MainFrame mainFrame;
	
	public RegistForm(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		//GridLayout gr = new GridLayout(11, 2, 5, 20);
		//setLayout(gr);
		Dimension dim = new Dimension(150,30);

		// p_title = new JPanel();
		lb_title = new JLabel("회원가입");
		lb_title.setPreferredSize(dim);
		add(lb_title, CENTER_ALIGNMENT);
		
		// add(p_title);

		lb_tel = new JLabel("안내문의 1588-7800");
		lb_tel.setPreferredSize(dim);
		add(lb_tel);

		p_id = new JPanel();
		lb_id = new JLabel("아이디(ID)");
		lb_id.setPreferredSize(dim);
		tf_id = new JTextField(10);
		bt_overlap = new JButton("중복");
		p_id.add(tf_id);
		bt_overlap.setPreferredSize(new Dimension(60,30));
		p_id.add(bt_overlap);
		add(lb_id);
		add(p_id);

		// p_pwd = new JPanel();
		lb_pwd = new JLabel("패스워드(pwd)");
		lb_pwd.setPreferredSize(dim);
		tf_pwd = new JPasswordField(10);
		add(lb_pwd);
		add(tf_pwd);

		// p_pwd2 = new JPanel();
		lb_pwd2 = new JLabel("패스워드 확인");
		lb_pwd2.setPreferredSize(dim);
		tf_pwd2 = new JPasswordField(10);
		add(lb_pwd2);
		add(tf_pwd2);
		// add(p_pwd2);
		lb_name = new JLabel("성함");
		lb_name.setPreferredSize(dim);
		tf_name = new JTextField(10);
		add(lb_name);
		add(tf_name);
		
		// p_qachoice = new JPanel();
		lb_qachoice = new JLabel("pwd 찾기 질문선택");
		lb_qachoice.setPreferredSize(dim);
		ch_qa = new Choice();
		ch_qa.add("선 택 ▼");
		ch_qa.add("아버지 성함은?");
		ch_qa.add("가장 좋아하는 동물은?");
		ch_qa.add("졸업한 초등학교는?");
		add(lb_qachoice);
		add(ch_qa);
		// add(p_qachoice);

		// p_qa = new JPanel();
		lb_qa = new JLabel("질문답");
		lb_qa.setPreferredSize(dim);
		tf_qa = new JTextField(10);
		add(lb_qa);
		add(tf_qa);
		// add(p_qa);

		p_add = new JPanel();
		lb_add = new JLabel("주소");
		lb_add.setPreferredSize(dim);
		ta_add1 = new JTextField (10);
		ta_add2 = new JTextField (30);
		bt_find = new JButton("검색");

//		/ta_add.setPreferredSize(new Dimension(100, 20));
		
		add(lb_add);
		add(ta_add1);
		add(bt_find);
		add(ta_add2);
		//add(p_add);

		p_cardnum = new JPanel();
		lb_cardnum = new JLabel("사용카드 번호");
		lb_cardnum.setPreferredSize(dim);
		tf_cardnum = new JTextField(10);
		lb_cardpwd = new JLabel("사용카드 비밀번호");
		lb_cardpwd.setPreferredSize(dim);
		tf_cardpwd = new JTextField(10);
		chg = new CheckboxGroup();
		ch_male = new Checkbox("남자", true, chg);
		ch_female = new Checkbox("여자", false, chg);
		add(lb_cardnum);
		add(tf_cardnum);
		add(lb_cardpwd);
		add(tf_cardpwd);
		//add(p_cardnum, LEFT_ALIGNMENT);

		// p_name = new JPanel();

		// add(p_name);

		profile = new JPanel();
		profile.setLayout(new BorderLayout());
		lb_img = new JLabel("이미지선택");
		lb_img.setPreferredSize(new Dimension(300, 30));
		
		JPanel profile_center = new JPanel();
		tf_img = new JTextField(20);
		bt_img = new JButton("찾기");
		profile.add(lb_img,BorderLayout.NORTH);
		p_img = new JPanel();
		p_img.setBackground(Color.RED);
		profile.add(p_img,BorderLayout.WEST);
		profile_center.add(tf_img);
		profile_center.add(bt_img);
		profile.add(profile_center);
		add(profile);

		p_bt = new JPanel();
		bt_enroll = new JButton("등록");
		bt_cancel = new JButton("취소");
		p_bt.add(bt_enroll);
		p_bt.add(bt_cancel);
		add(p_bt);

		bt_overlap.addActionListener(this);
		bt_find.addActionListener(this);
		bt_img.addActionListener(this);
		bt_enroll.addActionListener(this);
		bt_cancel.addActionListener(this);

		chooser = new JFileChooser("C:/java_workspace/workspace/MovieProject/res");

		setSize(400, 600);

	}

	public void OpenFile() {
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			String filename = file.getName(); //DB에 저장할 파일 이름
			//System.out.println(arr);
			//p_img.setBackground(Color.BLACK);
			createProfile(file);
			profile.updateUI();
			tf_img.setText(filename);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj.equals(bt_overlap)) {
			JOptionPane.showMessageDialog(this, "사용가능 한 ID 입니다. 계속 진행시 확인을 눌러주세요");
		} else if (obj.equals(bt_find)) {
			AddressFrame sub = new AddressFrame(this);

		} else if (obj.equals(bt_img)) {
			OpenFile();
		}else if(obj==bt_enroll){
			
		} else if(obj.equals(bt_cancel)){
			System.out.println("동작 확인");
			mainFrame.setMainPanel();
		}

	}
	
	//이미지 얻어오는 메서드
	public Image getImage(String name){
		System.out.println(name);
		Image img=null;//지역변수는 컴파일러가 초기화 해주지 않으므로 , 반드시 개발자가 사용전에 초기화 하자!!!
		Class myClass = this.getClass();
		//Classloader는 JVM의 static에서 원본 class 소스를 읽는 자이다.
		URL url=myClass.getClassLoader().getResource(name);
		System.out.println(url);
		try {
			img=ImageIO.read(url);
		} catch (IOException e) {
		}
		return img;
	}
	
	public void createProfile(File file){
		String pic = file.getName();
		System.out.println("create"+pic);
		profile.remove(p_img);
		p_img = new JPanel(){
			Image img = getImage(pic);
			@Override
			public void print(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		};
		p_img.setBackground(Color.BLACK);
		p_img.setPreferredSize(new Dimension(80, 100));
		
		profile.add(p_img,BorderLayout.WEST);
	}
}


