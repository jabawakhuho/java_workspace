/*
������ �������� �ڹ����α׷����� �о�鿩,
���ϴ� ���丮�� ������Ű�� ! = ��������!!

�ڹٿ����� ����°� ���õ� ����� java.io ��Ű������ �����Ѵ�.
�� ���������� ���� ����� ���� ����� ������ ��������� ioó���� �ǽ��غ���.
*/

package com.sds.stream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy{
	FileInputStream fis;//������ ��������� �Է� ��Ʈ��
	FileOutputStream fos;//������ ��������� ��� ��Ʈ��
	String name ="C:/java_workspace/GUI0810/res/kim.jpg";
	String dest="C:/java_workspace/GUI0810/res/kim_copy.jpg";
	
	public FileCopy(){
		//�Ʒ��� �ڵ�� ����� ������ ���ɼ��� �Ȱ��ִ� �ڵ��̴�!!!
		//���� �ùٸ��� �ʴ� ��θ� �Ǽ��� ���� ���, ���α׷��� ���������ᰡ �Ǿ� ������!!!!
		//����ó���� ������? ������������ ����!!
		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data; //�о���� �˰��� 1���� �ޱ����� ����
			//read() �޼���� Returns: the next byte of data, or -1 if the end of the file is reached.
			
			while(true){
				data = fis.read(); //1byte �б�
				System.out.print(data);
				//�о���� data�� �����Ͽ� �������
				fos.write(data);//1byte �����ϱ�
				if(data==-1)break;
			}
			
			//�� while�� �ٿ�����
			/*
			while((data=fis.read()) != -1){
				fos.write(data);
			}*/


		}catch(FileNotFoundException e){
			//e.printStackTrace();//e���� ���� �߻��� error�� ������ �������ִ�.
			System.out.println("�������� �ʴ� ����Դϴ�!!");
		}catch(IOException e){
			System.out.println("������ �б� ����");
		}finally{
			/*
			���� ó���� try���̰�, catch���� ����� ���� ������ ó���ؾ� �� ������ �ִٸ� finally���� �۾����ش�.
			finally��? try���̳� catch���� ������ ����δ� �ݵ�� finally�� �����ϰ� �Ǿ��ִ�!!���� �ݵ�� ó���ؾ� �� �۾��� ���ɼ��ִ�.
			��ǻ� ���� ��κ� db �ݴ��۾�, ��Ʈ�� �ݴ� �۾��� �е������� ���� ����~
			*/
				
			if(fos!=null){
				try{
					fos.close();//fos������ Error�߻��� fos ��ü������ ���� �ʰ� null�� �ɼ��ִ� �̶� fos.close()�� ������Ʈ�ͼ����� �߻��Ǿ�����. �׷��⶧���� null����ó���� �ؾ��Ѵ�.
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
