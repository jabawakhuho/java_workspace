/*
Stream�̶�?  ����Ÿ�� �帧
�з�
1. ���⼺  (�������� ���α׷��� ���� = ���μ���)
 - Input / Output
2. ������ó�����
- ����Ʈ ��� ��Ʈ��: �⺻��Ʈ���̸� 1byte�� ����
- ���� ��� ��Ʈ�� : 2byte�� �����ϴ� ��Ʈ�� -> �񿵾�� ���ڵ� ǥ���Ҽ��ִ�. (Reader/Writer)
- ���۱�� ��Ʈ�� : ������ ������ ���� �߰��Ҷ���, ���ۿ� ��Ƶ� �����͸� �о���̵��� ó���� ��Ʈ��!
*/

package com.sds.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class KeyBoardStream {
	InputStream is;
	InputStreamReader rd;
	BufferedReader buffr;
	FileWriter writer;
	BufferedWriter buffw;

	String path ="test2.txt";
	StringBuffer sb;

	public KeyBoardStream() {
		//is = �ý��ۿ� ����� Ű���� ��Ʈ��;
		//System.in // os �� ����� ǥ�� �Է� ������
		//KeyBoard, ���ڵ� ���ɳ� �� System�� �����ϴ� ��Ʈ���� �����ڰ� ���ϴ� ������ ������� �����Ҽ�����.
		//���� System���� ���� ���;� �Ѵ�!!!
		is = System.in;
		rd= new InputStreamReader(is);
		buffr = new BufferedReader(rd);

		String data2;
		int count =0;
		
		try {
			//int data2 =buffr.;
			//	System.out.println("buffr"+(char)data2);
			//Ű������ ��Ʈ���� �� �� return ����-1 ��찡 ����.
			writer = new FileWriter(path);
			buffw = new BufferedWriter(writer);
			
			sb	= new StringBuffer();

			while(true){
				data2 = buffr.readLine();
				if(data2.equals("exit")){
					return;
				}else{
					System.out.println(data2);
					//count++;
					//System.out.println("���� Ƚ�� : "+count);
					sb.append(data2);
				}
				writer.write(sb.toString()+"\n");
				System.out.println("file:"+sb.toString());
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(buffr != null){
				try{
					buffr.close();
				}catch (IOException e) {
				}
			}
			if(writer != null){
				try{
					writer.close();
				}catch (IOException e) {
				}
			}
		System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		new KeyBoardStream();
	}

}
