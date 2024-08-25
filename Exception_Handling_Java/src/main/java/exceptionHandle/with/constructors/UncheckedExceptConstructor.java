package exceptionHandle.with.constructors;

import java.io.FileNotFoundException;

import exceptionHandle.with.inheritance.UncheckedExcepParentClassRules;

public class UncheckedExceptConstructor {



	//scenario 1: child method can have same exception
	
	public void UncheckedExceptConstructor() {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 2: child method can have different exception
	
	public void UncheckedExceptConstructor(int a,int b) {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 3: child method cant have checked  exception
	
	public void UncheckedExceptConstructor(String abc) {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
class UncheckedExcepChildConstructor extends UncheckedExceptConstructor{
	

	public void UncheckedExcepChildConstructor() {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 2: child method can have different exception
	
	public void UncheckedExcepChildConstructor(int a,int b) {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
	//scenario 3: child method cant have checked  exception
	
	public void UncheckedExcepChildConstructor(String abc) {
		System.out.println("I am throwing some unchecked Exception");
		throw new ArithmeticException();
	}
}

