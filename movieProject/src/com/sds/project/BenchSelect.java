package com.sds.project;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class BenchSelect extends JFrame{
	Choice movieName; //��ȭ���  
	Choice selectTime; 	//�ð�
	Choice adultTicket;	//����
	Choice childTicket;	//�л�	
	
	JPanel ch,panel,seat;
	JLabel name,time,adult,child, screen,seats[],price;
	JTextField priceLabel;
	JButton next;
	boolean[] select;
	ArrayList<String> ticket;
	int member; 														// member�� �ϳ��� �����ϸ鼭 0�̵Ǹ� �¼��� ���� �� ���õȰ��� �ʱ⿡�� ���� ȭ�鿡�� �� �ο���
	/*
	 * TicketingFrame���� ��ȭ������������ �Ķ���ͷ� �Ѱ���, parent�� ticketingFrame�̴�. ���߿� ���ų����� �������Ӵ� ���� ��Ű�������̴�. 
	 */
	public BenchSelect() {
		setSize(400,600);
		setTitle("�¼� ����");	
		
		panel = new JPanel(null);
		
		name = new JLabel("��ȭ ���� : ");
		time = new JLabel("��ȭ �ð� : ");
		adult = new JLabel("��    �� :");
		child = new JLabel("û�ҳ� :");
		price = new JLabel("��    �� :");
		
		movieName=new Choice();                // ���̽� ��ü�� �����Ѵ�.
		selectTime=new Choice(); 
		
		adultTicket=new Choice();			// ����ǥ ���ż��� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ�
		childTicket=new Choice();			// û�ҳ�ǥ ���ż��� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ�
		
		priceLabel = new JTextField();
		
		for(int i=0; i < 5; i++) {                 //�ο��� �ִ� 4��
			adultTicket.add(String.valueOf(i));
			childTicket.add(String.valueOf(i));
		}
		
		
		name.setBounds(20,50,70,30);
		movieName.setBounds(100,53,120,30);
		time.setBounds(20,90,70,30);
		selectTime.setBounds(100,93,120,30);
		adult.setBounds(260, 50, 70, 30);
		adultTicket.setBounds(330,53,40,30);
		child.setBounds(260, 90, 70, 30);
		childTicket.setBounds(330,93,40,30);
		
		screen = new JLabel("SCREEN");
		screen.setBackground(Color.white);
		screen.setOpaque(true);											// �̼Ӽ��� true�� ���ָ� background color�� �����
		
		next = new JButton("�����Ϸ�");
		ticket = new ArrayList<String>();									// ticket.txt���� ������ ������ �����ϰ� ���Ű� �Ϸ�Ǹ� ���� ���ŵ� ������ add�� ����
		
		seat = new JPanel(new GridLayout(7, 7));	 						// ��ȭ �¼������� panel�� �ߴµ� gridlayout���� ��� 7x7 �¼��� ����
		seats = new JLabel[50];												// ��ȭ �¼��� ��ȣ�� ������ ���� �������� background color�� �ٲ㼭 �¼������� ǥ���Ұ���
		select = new boolean[50];											// ���� ������ ����� 49���ڸ��� ���õ����� select[49] = true��
		

		seat.setBackground(Color.white);
		seat.setOpaque(true);
		
		for(int i=0;i<7;i++) 												// �¼������� �ʱ�ȭ���ֱ����� �ݺ���
			for(int j=0;j<7;j++) {
				final int k =i*7+j;											
				seats[k] = new JLabel(Integer.toString(k+1)); 				// ���� �ϳ��� �¼� ��ȣ�� �ʱ�ȭ����
				seats[k].setHorizontalAlignment(JLabel.CENTER);				// �ؽ�Ʈ�� ��� ���� ����
				seats[k].setBackground(Color.MAGENTA);
				seats[k].addMouseListener(new MouseAdapter() {
					// �� Ŭ�� �̺�Ʈ�� �ϱ����� mosuselistener interface�� ������
					@Override
					public void mouseClicked(MouseEvent e) { 						// ������ �� �Ⱦ��ϱ� ������ click �̺�Ʈ�� ��
						Object obj=e.getSource();
						if(obj.equals(seats[k])){
							setSeatsColor(k);
						}						
					}
				});
				seat.add(seats[k]);														// ���Ͱ��� �ʱ�ȭ�� seats ���� �ϳ��� gridlayout���� ������ panel�� add��
			}
				
		screen.setBounds(20,170,350,25);
		screen.setHorizontalAlignment(SwingConstants.CENTER);
		
		// widget�� ������ǥ����
		
		seat.setBounds(20,230,350,200);
		
		price.setBounds(20,480,70, 30);
		priceLabel.setBounds(90,480,150,30);
		next.setBounds(280,480,90,30);
		
		//panel.setBackground(Color.YELLOW);
		panel.add(name);
		panel.add(time);
		panel.add(adult);
		panel.add(child);
		panel.add(movieName);
		panel.add(selectTime);
		panel.add(adultTicket);
		panel.add(childTicket);
		panel.add(priceLabel);
		
		panel.add(seat);
		panel.add(screen);
		
		panel.add(next);			
		
		panel.add(price);
		
		add(panel);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // ũ�� ���� �Ұ�
		setVisible(true);
		}	
	
	public void setSeatsColor(int k){
		if(seats[k].getBackground()==Color.MAGENTA) { 					// MAGETA�� ���� �����ߴ� �¼�
			seats[k].setBackground(Color.WHITE); 						// �ٽ� �����ϸ� �ٽ� ������� ����� �ٲ���
			select[k] = false;											// ���õ� �¼��� false�� �ٲ��ְ� member�� �ϳ�������Ŵ
			member++;
		}
		else if(member>0 && seats[k].getBackground()!=Color.GREEN){ 	// green�� ������ �ٸ������ ������ �¼�, member�� ���� 0�̾ƴϸ�
			seats[k].setBackground(Color.MAGENTA);						// ������ �� �����Ƿ� magenta�� ������ �ٲ��ְ� select�� true������
			select[k] = true;						
			member--;													// ���ڸ� ���������Ƿ� member�� ���ҽ�Ŵ
		}
		seats[k].setOpaque(true);										// �ٲ� ���� ����
	}
	
	public static void main(String[] args){
		new BenchSelect();
	}
}
