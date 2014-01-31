package com.densmore.numbers;

public class FieldTest {

//	See?  Java passes by value.
	
	
	
	public static void addOne(TestPassing passedObj) {
		passedObj.a++;
		passedObj.b++;
	}
	
	public static void main(String[] args) {
		TestPassing numberOne = new TestPassing();
		
		System.out.println(numberOne.a);
		System.out.println(numberOne.b);
		
		addOne(numberOne);
		
		System.out.println(numberOne.a);
		System.out.println(numberOne.b);
	}
	
}


class TestPassing {
	public int a = 0;
	public int b = 0;
	
	public TestPassing() {
		a = 1;
		b = 2;
	}

}