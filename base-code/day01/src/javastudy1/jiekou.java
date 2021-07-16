package javastudy1;

import javastudy1.tryt.Inext;

interface Imammal{
	public abstract void speak();
	public abstract void eat();
	public abstract void sleep();
}

interface Ihaha extends Imammal
{
	public abstract void run();
}

class Dog implements Ihaha{
	public void speak()
	{
		System.out.println("ÍôÍô½Ğ");
	}

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("°®³Ô¹ÇÍ·");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("ÍíÉÏË¯¾õ");
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ÅÜµÄ¿ì");
	}
	
}

class cat implements Imammal
{

	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("ß÷ß÷½Ğ");
	}

//	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("°®³ÔÓã");
	}

//	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("°×ÌìË¯¾õ");
	}
	
}

class text implements Inext{

//	@Override
	public void Ispeak() {
		// TODO Auto-generated method stub
		System.out.println("½Ğ½Ğ");
	}
	
}

public class jiekou {
	public static void main(String args[]) {
		Dog dog =new Dog();
		cat aCat =new cat();
		System.out.println("¹·µÄÌØµã£º");
		dog.speak();
		dog.eat();
		dog.sleep();
		dog.run();
		System.out.println("Ã¨µÄÌØµã");
		aCat.speak();
		aCat.eat();
		aCat.sleep();
		text text = new text();
		text.Ispeak();
	}
}
