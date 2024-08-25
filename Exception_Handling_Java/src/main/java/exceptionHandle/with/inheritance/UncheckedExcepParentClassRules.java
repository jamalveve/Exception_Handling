package exceptionHandle.with.inheritance;

import java.io.FileNotFoundException;

public class UncheckedExcepParentClassRules {

	//scenario 1: child method can have same exception
	
	public void method1() {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 2: child method can have different exception
	
	public void method2() {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 3: child method cant have checked  exception
	
	public void method3() {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class UncheckedExcepChildclass extends UncheckedExcepParentClassRules{
	
	public void method1() {
		System.out.println("I am throwing some unchecked Exception");
		
		throw new ArithmeticException();
	}
	
	public void method2() {
		System.out.println("I am throwing some unchecked Exception");
		
		throw new ArrayIndexOutOfBoundsException();
	}
	public void method3() throws FileNotFoundException {
		System.out.println("I am throwing some unchecked Exception");
		
		throw new FileNotFoundException();
	}
}
