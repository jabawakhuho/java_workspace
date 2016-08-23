/*
 �ڹپ��� ��Ʈ��ũ ���α׷��� �ۼ��Ҽ�������,
 java.net ��Ű������ ��κ� �����Ѵ�.
 port - �ϳ��� ��ǻ�� ������ �ٸ� ��Ʈ��ũ ���α׷��� �������� �ʴ� ���� �ĺ� ��ȣ
 socket - ��Ʈ��ũ�� ���� ������ �߻�ȭ ���ѳ��� ��
 ���ڼ��� - client�� ������ data�� �����ϸ� �� �����͸� �������Ͽ�  client���� �������ִ� ����
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
	int port=7777; // 1~1024 ������ �̹� �ý����� �����ϴ� ��Ʈ�̹Ƿ� ����ؼ��� �ȵȴ�.
	//�׸��� ����, mysql �� �� �˷��� ����Ʈ������ ��Ʈ ��ȣ�� ���ذ����Ѵ�.
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	BufferedWriter buffw;
	public ChatServer() {
		
		try {
			server = new ServerSocket(port);//���� ����
			System.out.println("���� ���� ����");
			Socket client=server.accept();//Ŭ���̾�Ʈ�� ������ �޾Ƶ帮�� �޼���!!
									//����) �� �޼���� ������ ���������� �����¿� ������!!!
									//������
			System.out.println("������ �߰�");
			String ip = client.getInetAddress().getHostAddress();
			System.out.println(ip+"������ �߰�");
			//socket���� ���� Ŭ���̾�Ʈ�� ���õ� �������� ���ԵǾ������Ƿ�, Ŭ���̾�Ʈ�� IP ����~
			//������ �ޱ�� ��Ʈ��
			InputStream is = client.getInputStream();
			reader = new InputStreamReader(is);
			buffr = new BufferedReader(reader);
			
			//������ ������� ��Ʈ��
			OutputStream os = client.getOutputStream();
			writer = new OutputStreamWriter(os);
			buffw = new BufferedWriter(writer);
			
			String data=null;
			while(true){
				data=buffr.readLine(); // data�� �Էµɶ����� ����(���� ���)�� �߻���Ų��.
				System.out.println(data);
				buffw.write(data+"\n");
				//��� ��Ʈ�� �迭��, ���۽� ��½�Ʈ������ �����ϴ� ��� �����͸� ��� ������Ѵ�.!!
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
