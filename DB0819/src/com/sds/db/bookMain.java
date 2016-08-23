package com.sds.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class bookMain extends JFrame implements ItemListener, ActionListener {
	// 좌측 관련
	JPanel p_west;// 좌측 입력폼에 사용할 패널
	Choice ch_top, ch_sub;// 상하위 카테고리 출력
	JTextField t_bookname, t_publisher, t_author, t_price;
	JLabel lb_bookname, lb_publisher, lb_author, lb_price;
	JButton bt_regist;
	JButton bt_delete;

	// 북쪽 관련
	JPanel p_north;
	Choice ch_category;
	JTextField t_keyword;
	JButton bt_search;

	// 센터 관련
	JScrollPane scroll;
	JTable table;
	MyModel model;
	// 접속 정보 선언(jdbc-java database connectivity|접속 DB 기종|접속
	// 방식|@접속주소|port번호|설치이름)
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "java0819";
	String password = "java0819";
	// jdbc관련 객체
	Connection con; // 접속후, 그 정보를 가진 객체!! 따라서 접속을 끊으려면 이 객체를 이용해야 한다.
	PreparedStatement pstmt;// 쿼리문 수행 객체. 인터페이스이므로 new 불가!!
							// 접속이 되어야 쿼리문을 실행할수있으므로
							// con으로 부터 인스턴스를 얻어와야한다.
	ResultSet rs; // 쿼리 수행후 레코드가 반환되는 경우 , 즉 select문을 수행할시 결과 집합을 담는 역활을 수행하는
					// 인터페이스!!

	// 하위 카테고리의 id값을 보관해놓을 컬렉션!!
	ArrayList<Integer> subcategory_id = new ArrayList<Integer>();

	int book_id;//유저가 선택한 Table의 Book_id
	
	public bookMain() {
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_bookname = new JTextField(10);
		t_publisher = new JTextField(10);
		t_author = new JTextField(10);
		t_price = new JTextField("0", 10);
		lb_bookname = new JLabel("책   명");
		lb_publisher = new JLabel("출판사");
		lb_author = new JLabel("저   자");
		lb_price = new JLabel("가   격");

		bt_regist = new JButton("등록");
		bt_delete = new JButton("삭제");
		
		p_north = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField(30);
		bt_search = new JButton("검색");

		// 상위 목록 가져오기
		connect();
		

		table = new JTable(model = new MyModel(con));
		scroll = new JScrollPane(table);
		
		//테이블과 마우스리스너와의 연결
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
			//	int col=table.getSelectedColumn();
				String value = (String)table.getValueAt(row, 0);
				book_id = Integer.parseInt(value);
			//	System.out.println(value +"클릭함?");
				getRecord(row);
			}
		});

		ch_top.setPreferredSize(new Dimension(150, 30));
		ch_sub.setPreferredSize(new Dimension(150, 30));
		ch_top.add("선택▼");
		ch_sub.add("선택▼");

		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(lb_bookname);
		p_west.add(t_bookname);
		p_west.add(lb_publisher);
		p_west.add(t_publisher);
		p_west.add(lb_author);
		p_west.add(t_author);
		p_west.add(lb_price);
		p_west.add(t_price);
		p_west.add(bt_regist);
		p_west.add(bt_delete);
		p_west.setPreferredSize(new Dimension(180, 550));
		p_west.setBackground(Color.WHITE);

		ch_category.add("도서명");
		ch_category.add("출판사");
		ch_category.add("저자");
		p_north.add(ch_category);
		p_north.add(t_keyword);
		p_north.add(bt_search);
		p_north.setPreferredSize(new Dimension(800, 50));

		add(p_north, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		add(scroll);

		// 상위 카테고리 초이스와 리스너 연결
		ch_top.addItemListener(this);
		bt_regist.addActionListener(this);
		bt_delete.addActionListener(this);
		// 위도우와 윈도우리스너 연결
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (con != null) { // DB 연결해제
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(-1); // 프로세스 죽이기!!
			}
		});

		// setDefaultCloseOperation(EXIT_ON_CLOSE); process만 닫기때문에 사용금지!! DB도
		// 닫아야함
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		getTopCategory();
		// 하위 목록 가져오기->이벤트 연결로!!
	}

	// 상위 카테고리 가져오기
	public void getTopCategory() {
		// 상위 카타고리 가져오기
		try {
			String sql = "select * from topcategory";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 쿼리문 수행 후 rs에 ResultSet을 받아옴
			while (rs.next()) {
				ch_top.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	// 하위 카테고리 목록 가져오기
	public void getSubCategory(String title) {
		try {
			/*
			 * String sql2="select * from subcategory " +
			 * "where topcategory_id=" +
			 * "(select topcategory_id from topcategory where title='" + title
			 * +"')";
			 */
			StringBuffer sql = new StringBuffer();
			sql.append("select * from subcategory where topcategory_id=(");
			sql.append(" select topcategory_id from topcategory where title='");
			sql.append(title);
			sql.append("')");

			System.out.println(sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// 기존꺼 지우기!!
			ch_sub.removeAll();
			subcategory_id.removeAll(subcategory_id);
			ch_sub.add("선택▼");
			while (rs.next()) {
				ch_sub.add(rs.getString("title"));
				subcategory_id.add(rs.getInt("subcategory_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	// book table에 레코드 넣기
	public void registBook() {
		// 현제 선택한 아이템의
		int selectedIndex = ch_sub.getSelectedIndex() - 1;
		int sub_id = subcategory_id.get(selectedIndex);
		JOptionPane.showMessageDialog(this, sub_id);

		String bookname = t_bookname.getText();
		String publisher = t_publisher.getText();
		String author = t_author.getText();
		int price = Integer.parseInt(t_price.getText());

		/*String sql = "insert into book (book_id,subcategory_id,bookname,publisher,author,price)"
				+ " values(sqe_book.nextval," + sub_id + ", '" + bookname + "','" + publisher + "','" + author + "',"
				+ price + ")";*/
		String sql="insert into book (book_id,subcategory_id,bookname,publisher,author,price)"
				+ " values(sqe_book.nextval,?,?,?,?,?)";
		
		
		// System.out.println(sql);
		// 쿼리실행
		try {
			pstmt = con.prepareStatement(sql);
			//바인드 변수로 매칭을 한다.!!
			//그러면 바인드 변수를 쓰는 이유는?
			pstmt.setInt(1, sub_id);
			pstmt.setString(2, bookname);
			pstmt.setString(3, publisher);
			pstmt.setString(4, author);
			pstmt.setInt(5, price);
			
			// 반환형이 숫자인 이유?? 이 쿼리문에 의해 영향받은 레코드 수가 반환된다!!
			// 따라서 insert 성공시 언제나 1, update- 1이상 , delete-1이상 , 실패인결우 -0을 반환
			int result = pstmt.executeUpdate();
			if (result != 0) {
				JOptionPane.showMessageDialog(this, "등록 성공");
				
				//Jtable 갱신!!!
				model.selectAll();
				//table.updateUI();
				model.fireTableDataChanged();
			} else {
				JOptionPane.showMessageDialog(this, "등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String item = e.getItem().toString();
		/*
		 * Choice choice = (Choice)e.getSource();
		 * System.out.println(choice.getSelectedItem());
		 */
		System.out.println(item);
		getSubCategory(item);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bt_regist) {
			// book table에 insert하기 메서드
			System.out.println(
					ch_top.getSelectedItem() + "," + ch_sub.getSelectedItem() + "," + t_bookname.toString() + ",");

			registBook();
		} else if (obj == bt_search) {

		} else if(obj==bt_delete){
			
			int result = JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?");
			if(result == JOptionPane.OK_OPTION){
				if(book_id==0){
					JOptionPane.showMessageDialog(this, "책을 선택해주세요");
					return;
				}
				if(model.deleteBook(book_id)!=0){
					JOptionPane.showMessageDialog(this, "삭제 성공");
					model.selectAll();
					model.fireTableDataChanged();
				}else{
					JOptionPane.showMessageDialog(this, "삭제 실패");
				}
			}
		}
	}

	// DB 연결하는 메서드
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// JOptionPane.showMessageDialog(this, "드라이버 로드 성공");
			this.setTitle("드라이버로드성공");
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				JOptionPane.showMessageDialog(this, "접속실패");
				return;
			}
			// JOptionPane.showMessageDialog(this, "접속성공");
			this.setTitle("접속성공");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "접속시도중 에러 발생");
			e.printStackTrace();
		} finally {

		}
	}

	// DB에 쿼리문 관련 객체 닫는 메서드
	public void disConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new bookMain();
	}
	
	public void getRecord(int row){
		t_bookname.setText((String)table.getValueAt(row, 2));
		t_publisher.setText((String)table.getValueAt(row,3));
		t_author.setText((String)table.getValueAt(row,4));
		t_price.setText((String)table.getValueAt(row, 5));
		
	}
}
