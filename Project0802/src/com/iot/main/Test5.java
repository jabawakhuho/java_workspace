package com.iot.main;

public class Test5{
	public static void main(String[] args) 	{
		String str="Korea java";

		System.out.println(str.charAt(3));

		int a = str.indexOf("a");
		System.out.println(a);

		System.out.println(str.lastIndexOf("a"));

		System.out.println(str.length());
		
		System.out.println(str.replace("Korea", "ÄÚ¸®¾Æ"));

		System.out.println(str.substring(3,8));
	
		System.out.println(str.toUpperCase());

		String p="photo.jpg";
		
		String[] arr=p.split("\\.");
		
		

		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
