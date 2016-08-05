package human;

class UsePerson{

	public static void main(String[] args){

		WhitePerson w = new WhitePerson();
		System.out.println(w.color);
		w.openParty();

		w.walk();

		BlackPerson b = new BlackPerson();
		b.run();

		YellowPerson y = new YellowPerson();
		y.walk();
		y.run();

	}
}
