package com.densmore.generics;

public class Box<T> {

	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public <U> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}

	public static void main(String[] args) {
		Box<String> integerBox = new Box<String>();
		integerBox.add("some text");
		integerBox.inspect(10);
		
	}
}