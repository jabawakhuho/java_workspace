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
	Choice movieName; //영화목록  
	Choice selectTime; 	//시간
	Choice adultTicket;	//성인
	Choice childTicket;	//학생	
	
	JPanel ch,panel,seat;
	JLabel name,time,adult,child, screen,seats[],price;
	JTextField priceLabel;
	JButton next;
	boolean[] select;
	ArrayList<String> ticket;
	int member; 														// member는 하나씩 감소하면서 0이되면 좌석이 전부 다 선택된것임 초기에는 그전 화면에서 고른 인원수
	/*
	 * TicketingFrame에서 영화예매정보들을 파라미터로 넘겨줌, parent는 ticketingFrame이다. 나중에 예매끝나면 두프레임다 종료 시키기위함이다. 
	 */
	public BenchSelect() {
		setSize(400,600);
		setTitle("좌석 선택");	
		
		panel = new JPanel(null);
		
		name = new JLabel("영화 제목 : ");
		time = new JLabel("영화 시간 : ");
		adult = new JLabel("어    른 :");
		child = new JLabel("청소년 :");
		price = new JLabel("가    격 :");
		
		movieName=new Choice();                // 초이스 객체를 생성한다.
		selectTime=new Choice(); 
		
		adultTicket=new Choice();			// 여른표 구매수를 입력받기 위한 텍스트필드
		childTicket=new Choice();			// 청소년표 구매수를 입력받기 위한 텍스트필드
		
		priceLabel = new JTextField();
		
		for(int i=0; i < 5; i++) {                 //인원수 최대 4명
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
		screen.setOpaque(true);											// 이속성을 true로 해주면 background color가 적용됨
		
		next = new JButton("결제완료");
		ticket = new ArrayList<String>();									// ticket.txt에서 가져온 정보를 저장하고 예매가 완료되면 지금 예매된 정보를 add할 것임
		
		seat = new JPanel(new GridLayout(7, 7));	 						// 영화 좌석정보를 panel로 했는데 gridlayout으로 잡고 7x7 좌석을 만듬
		seats = new JLabel[50];												// 영화 좌석에 번호를 지정할 라벨임 때에따라서 background color을 바꿔서 좌석선택을 표시할것임
		select = new boolean[50];											// 현재 선택한 놈들임 49번자리가 선택됫으면 select[49] = true임
		

		seat.setBackground(Color.white);
		seat.setOpaque(true);
		
		for(int i=0;i<7;i++) 												// 좌석정보를 초기화해주기위한 반복문
			for(int j=0;j<7;j++) {
				final int k =i*7+j;											
				seats[k] = new JLabel(Integer.toString(k+1)); 				// 라벨을 하나씩 좌석 번호로 초기화해줌
				seats[k].setHorizontalAlignment(JLabel.CENTER);				// 텍스트를 가운데 정렬 해줌
				seats[k].setBackground(Color.MAGENTA);
				seats[k].addMouseListener(new MouseAdapter() {
					// 라벨 클릭 이벤트를 하기위해 mosuselistener interface를 가져옴
					@Override
					public void mouseClicked(MouseEvent e) { 						// 위에는 다 안쓰니깐 버리고 click 이벤트만 씀
						Object obj=e.getSource();
						if(obj.equals(seats[k])){
							setSeatsColor(k);
						}						
					}
				});
				seat.add(seats[k]);														// 위와같이 초기화한 seats 라벨을 하나씩 gridlayout으로 세팅한 panel에 add함
			}
				
		screen.setBounds(20,170,350,25);
		screen.setHorizontalAlignment(SwingConstants.CENTER);
		
		// widget들 절대좌표지정
		
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
		setResizable(false);				 // 크기 조절 불가
		setVisible(true);
		}	
	
	public void setSeatsColor(int k){
		if(seats[k].getBackground()==Color.MAGENTA) { 					// MAGETA는 지금 선택했던 좌석
			seats[k].setBackground(Color.WHITE); 						// 다시 선택하면 다시 흰색으로 배경을 바꿔줌
			select[k] = false;											// 선택된 좌석을 false로 바꿔주고 member를 하나증가시킴
			member++;
		}
		else if(member>0 && seats[k].getBackground()!=Color.GREEN){ 	// green는 이전에 다른사람이 예매한 좌석, member가 아직 0이아니면
			seats[k].setBackground(Color.MAGENTA);						// 선택할 수 있으므로 magenta로 색깔을 바꿔주고 select를 true로해줌
			select[k] = true;						
			member--;													// 한자리 선택했으므로 member는 감소시킴
		}
		seats[k].setOpaque(true);										// 바뀐 배경색 적용
	}
	
	public static void main(String[] args){
		new BenchSelect();
	}
}
