class UseComputer{

	public static void main(String[] args) 	{
		//컴퓨터의 메모리를 출력하고,
		Computer com= new Computer();
		
		System.out.println("컴퓨터의 메모리는 "+com.memory+"입니다.");
		//컴퓨터를 켜시오

		com.trunOn();
	}
}
