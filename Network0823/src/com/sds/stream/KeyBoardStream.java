/*
Stream이란?  데이타의 흐름
분류
1. 방향성  (실행중인 프로그램을 기준 = 프로세스)
 - Input / Output
2. 데이터처리방식
- 바이트 기반 스트림: 기본스트림이며 1byte씩 이해
- 문자 기반 스트림 : 2byte씩 이해하는 스트림 -> 비영어권 문자도 표현할수있다. (Reader/Writer)
- 버퍼기반 스트림 : 데이터 단위의 끝을 발견할때만, 버퍼에 모아둔 데이터를 읽어들이도록 처리된 스트림!
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
		//is = 시스템에 연결된 키보드 스트림;
		//System.in // os 상에 연결된 표준 입력 도구들
		//KeyBoard, 바코드 스케너 등 System이 제어하는 스트림은 개발자가 원하는 시점에 마음대로 생성할수없다.
		//따라서 System으로 부터 얻어와야 한다!!!
		is = System.in;
		rd= new InputStreamReader(is);
		buffr = new BufferedReader(rd);

		String data2;
		int count =0;
		
		try {
			//int data2 =buffr.;
			//	System.out.println("buffr"+(char)data2);
			//키보드의 스트림의 끝 즉 return 값이-1 경우가 없다.
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
					//System.out.println("읽힌 횟수 : "+count);
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
