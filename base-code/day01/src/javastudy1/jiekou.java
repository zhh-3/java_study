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
		System.out.println("������");
	}

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("���Թ�ͷ");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("����˯��");
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�ܵĿ�");
	}
	
}

class cat implements Imammal
{

	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

//	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

//	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("����˯��");
	}
	
}

class text implements Inext{

//	@Override
	public void Ispeak() {
		// TODO Auto-generated method stub
		System.out.println("�н�");
	}
	
}

public class jiekou {
	public static void main(String args[]) {
		Dog dog =new Dog();
		cat aCat =new cat();
		System.out.println("�����ص㣺");
		dog.speak();
		dog.eat();
		dog.sleep();
		dog.run();
		System.out.println("è���ص�");
		aCat.speak();
		aCat.eat();
		aCat.sleep();
		text text = new text();
		text.Ispeak();
	}
}
