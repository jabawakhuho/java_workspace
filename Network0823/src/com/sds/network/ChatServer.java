/*
 자바언어로 네트워크 프로그램을 작성할수있으며,
 java.net 패키지에서 대부분 지원한다.
 port - 하나의 컴퓨터 내에서 다른 네트워크 프로그램과 종복되지 않는 고유 식별 번호
 socket - 네트워크에 대한 정보를 추상화 시켜놓은 것
 에코서버 - client가 서버에 data를 전송하면 그 데이터를 재전송하여  client에게 전송해주는 서버
*/
package com.sds.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	int port=7777; // 1~1024 까지는 이미 시스템이 점유하는 포트이므로 사용해서는 안된다.
	//그리고 오라킅, mysql 등 잘 알려진 소프트웨어의 포트 번호도 피해가야한다.
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	BufferedWriter buffw;
	public ChatServer() {
		
		try {
			server = new ServerSocket(port);//서버 생성
			System.out.println("서버 소켓 생성");
			Socket client=server.accept();//클라이언트의 접속을 받아드리는 메서드!!
									//참고) 이 메서드는 접속이 있을때까지 대기상태에 빠진다!!!
									//감지용
			System.out.println("접속자 발견");
			String ip = client.getInetAddress().getHostAddress();
			System.out.println(ip+"접속자 발견");
			//socket에는 접속 클라이언트와 관련된 정보들이 포함되어있으므로, 클라이언트의 IP 추출~
			//데이터 받기용 스트림
			InputStream is = client.getInputStream();
			reader = new InputStreamReader(is);
			buffr = new BufferedReader(reader);
			
			//데이터 보내기용 스트림
			OutputStream os = client.getOutputStream();
			writer = new OutputStreamWriter(os);
			buffw = new BufferedWriter(writer);
			
			String data=null;
			while(true){
				data=buffr.readLine(); // data가 입력될때까지 지연(무한 대기)을 발생시킨다.
				System.out.println(data);
				buffw.write(data+"\n");
				//출력 스트림 계열을, 전송시 출력스트림내에 존재하는 모든 데이터를 모두 비워야한다.!!
				buffw.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
