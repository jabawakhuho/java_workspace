class UseFlower {
	public static void main(String[] args) 	{
		for(int i=1; i<=20; i++){
			Flower f= new Flower();
			f.pin();
			System.out.println(f.color);
			System.out.println("�̸�:"+f.name);
			System.out.println("��������"+f.thorn);
		}
	}
}
