/*
 * ���ӿ� ������ ��ü�� �����ϴ� Ŭ���� ����
 * ��ü�� ���� ������ �����ͺ��̽�ȭ ���Ѽ� �����ϵ�, �޸𸮻� �����Ͽ�~ ��ü�� ��Ƽ� ����= �÷��� �����ӿ�
 * 
 */
package com.sds.game;

import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objectList= new ArrayList<GameObject>(); //�޸𸮻� �����ͺ��̽�!!
	
	//������Ʈ �߰�
	public void addObject(GameObject gameObject){
		objectList.add(gameObject);
	}
	//������Ʈ ����
	public void removeObject(GameObject gameObject){
		objectList.remove(gameObject);
	}
}

