/*
 *Text area의 LineNumber를 알려주는 Panel 
 */

package com.huho.memo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LineNum extends JPanel{
	JLabel la_num;
	
	public LineNum(int i) {
		String num=Integer.toString(i);
		la_num = new JLabel(num);
		setBackground(Color.YELLOW);
		la_num.setFont(new Font(num,0,10));
		la_num.setPreferredSize(new Dimension(15, 15));
		setPreferredSize(new Dimension(17, 17));
		add(la_num);
	}
}
