/*
 * 게임에 등장할 객체를 관리하는 클래스 정의
 * 객체에 대한 정보를 데이터베이스화 시켜서 저장하되, 메모리상에 저장하여~ 객체를 모아서 관리= 컬렉션 프레임웍
 * 
 */
package com.sds.game;

import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objectList= new ArrayList<GameObject>(); //메모리상 데이터베이스!!
	
	//오브젝트 추가
	public void addObject(GameObject gameObject){
		objectList.add(gameObject);
	}
	//오브젝트 제거
	public void removeObject(GameObject gameObject){
		objectList.remove(gameObject);
	}
}

