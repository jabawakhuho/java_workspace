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
	// ���� ����
	JPanel p_west;// ���� �Է����� ����� �г�
	Choice ch_top, ch_sub;// ������ ī�װ� ���
	JTextField t_bookname, t_publisher, t_author, t_price;
	JLabel lb_bookname, lb_publisher, lb_author, lb_price;
	JButton bt_regist;
	JButton bt_delete;

	// ���� ����
	JPanel p_north;
	Choice ch_category;
	JTextField t_keyword;
	JButton bt_search;

	// ���� ����
	JScrollPane scroll;
	JTable table;
	MyModel model;
	// ���� ���� ����(jdbc-java database connectivity|���� DB ����|����
	// ���|@�����ּ�|port��ȣ|��ġ�̸�)
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "java0819";
	String password = "java0819";
	// jdbc���� ��ü
	Connection con; // ������, �� ������ ���� ��ü!! ���� ������ �������� �� ��ü�� �̿��ؾ� �Ѵ�.
	PreparedStatement pstmt;// ������ ���� ��ü. �������̽��̹Ƿ� new �Ұ�!!
							// ������ �Ǿ�� �������� �����Ҽ������Ƿ�
							// con���� ���� �ν��Ͻ��� ���;��Ѵ�.
	ResultSet rs; // ���� ������ ���ڵ尡 ��ȯ�Ǵ� ��� , �� select���� �����ҽ� ��� ������ ��� ��Ȱ�� �����ϴ�
					// �������̽�!!

	// ���� ī�װ��� id���� �����س��� �÷���!!
	ArrayList<Integer> subcategory_id = new ArrayList<Integer>();

	int book_id;//������ ������ Table�� Book_id
	
	public bookMain() {
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_bookname = new JTextField(10);
		t_publisher = new JTextField(10);
		t_author = new JTextField(10);
		t_price = new JTextField("0", 10);
		lb_bookname = new JLabel("å   ��");
		lb_publisher = new JLabel("���ǻ�");
		lb_author = new JLabel("��   ��");
		lb_price = new JLabel("��   ��");

		bt_regist = new JButton("���");
		bt_delete = new JButton("����");
		
		p_north = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField(30);
		bt_search = new JButton("�˻�");

		// ���� ��� ��������
		connect();
		

		table = new JTable(model = new MyModel(con));
		scroll = new JScrollPane(table);
		
		//���̺�� ���콺�����ʿ��� ����
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
			//	int col=table.getSelectedColumn();
				String value = (String)table.getValueAt(row, 0);
				book_id = Integer.parseInt(value);
			//	System.out.println(value +"Ŭ����?");
				getRecord(row);
			}
		});

		ch_top.setPreferredSize(new Dimension(150, 30));
		ch_sub.setPreferredSize(new Dimension(150, 30));
		ch_top.add("���á�");
		ch_sub.add("���á�");

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

		ch_category.add("������");
		ch_category.add("���ǻ�");
		ch_category.add("����");
		p_north.add(ch_category);
		p_north.add(t_keyword);
		p_north.add(bt_search);
		p_north.setPreferredSize(new Dimension(800, 50));

		add(p_north, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		add(scroll);

		// ���� ī�װ� ���̽��� ������ ����
		ch_top.addItemListener(this);
		bt_regist.addActionListener(this);
		bt_delete.addActionListener(this);
		// ������� �����츮���� ����
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (con != null) { // DB ��������
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(-1); // ���μ��� ���̱�!!
			}
		});

		// setDefaultCloseOperation(EXIT_ON_CLOSE); process�� �ݱ⶧���� ������!! DB��
		// �ݾƾ���
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		getTopCategory();
		// ���� ��� ��������->�̺�Ʈ �����!!
	}

	// ���� ī�װ� ��������
	public void getTopCategory() {
		// ���� īŸ�� ��������
		try {
			String sql = "select * from topcategory";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// ������ ���� �� rs�� ResultSet�� �޾ƿ�
			while (rs.next()) {
				ch_top.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	// ���� ī�װ� ��� ��������
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

			// ������ �����!!
			ch_sub.removeAll();
			subcategory_id.removeAll(subcategory_id);
			ch_sub.add("���á�");
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

	// book table�� ���ڵ� �ֱ�
	public void registBook() {
		// ���� ������ ��������
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
		// ��������
		try {
			pstmt = con.prepareStatement(sql);
			//���ε� ������ ��Ī�� �Ѵ�.!!
			//�׷��� ���ε� ������ ���� ������?
			pstmt.setInt(1, sub_id);
			pstmt.setString(2, bookname);
			pstmt.setString(3, publisher);
			pstmt.setString(4, author);
			pstmt.setInt(5, price);
			
			// ��ȯ���� ������ ����?? �� �������� ���� ������� ���ڵ� ���� ��ȯ�ȴ�!!
			// ���� insert ������ ������ 1, update- 1�̻� , delete-1�̻� , �����ΰ�� -0�� ��ȯ
			int result = pstmt.executeUpdate();
			if (result != 0) {
				JOptionPane.showMessageDialog(this, "��� ����");
				
				//Jtable ����!!!
				model.selectAll();
				//table.updateUI();
				model.fireTableDataChanged();
			} else {
				JOptionPane.showMessageDialog(this, "��� ����");
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
			// book table�� insert�ϱ� �޼���
			System.out.println(
					ch_top.getSelectedItem() + "," + ch_sub.getSelectedItem() + "," + t_bookname.toString() + ",");

			registBook();
		} else if (obj == bt_search) {

		} else if(obj==bt_delete){
			
			int result = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?");
			if(result == JOptionPane.OK_OPTION){
				if(book_id==0){
					JOptionPane.showMessageDialog(this, "å�� �������ּ���");
					return;
				}
				if(model.deleteBook(book_id)!=0){
					JOptionPane.showMessageDialog(this, "���� ����");
					model.selectAll();
					model.fireTableDataChanged();
				}else{
					JOptionPane.showMessageDialog(this, "���� ����");
				}
			}
		}
	}

	// DB �����ϴ� �޼���
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// JOptionPane.showMessageDialog(this, "����̹� �ε� ����");
			this.setTitle("����̹��ε强��");
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				JOptionPane.showMessageDialog(this, "���ӽ���");
				return;
			}
			// JOptionPane.showMessageDialog(this, "���Ӽ���");
			this.setTitle("���Ӽ���");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "���ӽõ��� ���� �߻�");
			e.printStackTrace();
		} finally {

		}
	}

	// DB�� ������ ���� ��ü �ݴ� �޼���
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
