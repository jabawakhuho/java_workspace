/*
사진을 실행중인 자바프로그램으로 읽어들여,
원하는 디렉토리에 복원시키자 ! = 복사하자!!

자바에서는 입출력과 관련된 기능을 java.io 패키지에서 지원한다.
이 예제에서는 여러 입출력 관련 기능중 파일을 대상으로한 io처리를 실습해본다.
*/

package com.sds.stream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy{
	FileInputStream fis;//파일을 대상으로한 입력 스트림
	FileOutputStream fos;//파일을 대상으로한 출력 스트림
	String name ="C:/java_workspace/GUI0810/res/kim.jpg";
	String dest="C:/java_workspace/GUI0810/res/kim_copy.jpg";
	
	public FileCopy(){
		//아래의 코드는 실행시 에러의 가능성을 안고있는 코드이다!!!
		//따라서 올바르지 않는 경로를 실수로 넣을 경우, 프로그램은 비정상종료가 되어 버린다!!!!
		//예외처리의 목적은? 비정상종료의 방지!!
		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data; //읽어들인 알갱이 1알을 받기위한 변수
			//read() 메서드는 Returns: the next byte of data, or -1 if the end of the file is reached.
			
			while(true){
				data = fis.read(); //1byte 읽기
				System.out.print(data);
				//읽어들인 data를 빈파일에 출력하자
				fos.write(data);//1byte 저장하기
				if(data==-1)break;
			}
			
			//위 while문 줄여쓰기
			/*
			while((data=fis.read()) != -1){
				fos.write(data);
			}*/


		}catch(FileNotFoundException e){
			//e.printStackTrace();//e에는 지금 발생한 error의 정보를 가지고있다.
			System.out.println("존재하지 않는 경로입니다!!");
		}catch(IOException e){
			System.out.println("파일을 읽기 에러");
		}finally{
			/*
			예외 처리시 try문이건, catch문이 수행된 이후 무조건 처리해야 할 로직이 있다면 finally에서 작업해준다.
			finally란? try문이나 catch문을 진입한 실행부는 반드시 finally에 도달하게 되어있다!!따라서 반드시 처리해야 할 작업에 사용될수있다.
			사실상 거의 대부분 db 닫는작업, 스트림 닫는 작업에 압도적으로 많이 사용됨~
			*/
				
			if(fos!=null){
				try{
					fos.close();//fos실행중 Error발생시 fos 객체생성이 되지 않고 null이 될수있다 이때 fos.close()는 널포인트익셉션이 발생되어진다. 그렇기때문에 null예외처리를 해야한다.
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close();
				}catch(IOException e){
				}
			}

		}

	}

	public static void main(String[] args) 	{
		new FileCopy();
	}
}
