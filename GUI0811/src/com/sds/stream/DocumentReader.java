/*문자 스트림
 * 
스트림의 종류
1.방향성 - 입력, 출력
2.문자지원여부 - 문자 기반 : 2byte씩 묶어서 이해할수있는 스트림  reader/ writer
 					바이트 기반  : 1byte씩만 이해할수있는 스트림  Input / Output
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
	BufferedReader buffr;//버퍼처리된 문자기반 입력 스트림
	BufferedWriter buffw;//버퍼처리된 문자기반 출력 스트림
	
	
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
			JOptionPane.showMessageDialog(this, "완료");
			
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
