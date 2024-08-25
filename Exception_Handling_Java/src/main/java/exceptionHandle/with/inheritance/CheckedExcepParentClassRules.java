package exceptionHandle.with.inheritance;

import java.io.FileNotFoundException;

public class CheckedExcepParentClassRules {
	
	
//	scenario 1: if parent has one checked exception
	public void method1() throws FileNotFoundException {
		System.out.println("I am throwing some unchecked Exception");
		try {
		throw new FileNotFoundException();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	//scenario 2: f parent method can have one checked exception
	
	protected void method2() {
		System.out.println("I am throwing some unchecked Exception");
		try {
		throw new ArrayIndexOutOfBoundsException();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	//scenario 3: if parent  method  have checked  exception
	
	public static void method3() throws ClassNotFoundException {
		System.out.println("I am throwing some unchecked Exception");
		try {
		throw new ClassNotFoundException();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) throws Exception {
		System.out.println("calling method to main method");
		CheckedExcepParentClassRules.method3();
		CheckedExcepParentClassRules parentobj=new CheckedExcepParentClassRules();
		parentobj.method1();
		parentobj.method2();
		
		
	
	
	CheckedExcepChildclass childobj=new CheckedExcepChildclass();
	childobj.method1();
	childobj.method2();
	childobj.method3();
	CheckedExcepChildclass.method3();
	
	CheckedExcepParentClassRules referace=new CheckedExcepChildclass();
	
	referace.method1();
	referace.method2();
	referace.method3();
	}

}
class CheckedExcepChildclass extends CheckedExcepParentClassRules{
	
//	scenario1:
	public void method1() throws FileNotFoundException {
		System.out.println("I am throwing same checked Exception from child");
		try {
		throw new FileNotFoundException();
		}catch(Exception e){
			System.out.println(e);
		}
	}
//	//scenario 2: the child cant even have the differnt checked exception
//	public void method2() throws FileNotFoundException {
//		System.out.println("I am throwing some unchecked Exception");
//		
//		throw new FileNotFoundException();
//	}
	//scenario 3: the child can have unchecked exception also
	public static void method3() {
		System.out.println("I am throwing some unchecked Exception from childclass");
		try {
		throw new ArithmeticException();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
}
