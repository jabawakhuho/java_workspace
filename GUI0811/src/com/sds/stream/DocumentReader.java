/*���� ��Ʈ��
 * 
��Ʈ���� ����
1.���⼺ - �Է�, ���
2.������������ - ���� ��� : 2byte�� ��� �����Ҽ��ִ� ��Ʈ��  reader/ writer
 					����Ʈ ���  : 1byte���� �����Ҽ��ִ� ��Ʈ��  Input / Output
3.


 */
package com.sds.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DocumentReader extends JFrame{
	FileInputStream fis;
	FileOutputStream fos;
	FileReader reader;
	FileWriter	writer;
	BufferedReader buffr;//����ó���� ���ڱ�� �Է� ��Ʈ��
	BufferedWriter buffw;//����ó���� ���ڱ�� ��� ��Ʈ��
	
	
	String ori="C:/java_workspace/GUI0811/res/memo.txt";
	String dest="C:/java_workspace/GUI0811/res/memo2.txt";
	public DocumentReader() {
		
		try {
		//	fis = new FileInputStream(path+"memo.txt");
		//	fos = new FileOutputStream(path+"memo2.txt");
			
			reader = new FileReader(ori);
			writer = new FileWriter(dest);
			buffr =new BufferedReader(reader);
			buffw = new BufferedWriter(writer);
			
			String data=null;
			while((data=buffr.readLine())!=null){
				System.out.println(data);
				buffw.write(data);
			}
			JOptionPane.showMessageDialog(this, "�Ϸ�");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new DocumentReader();		
	}

}
