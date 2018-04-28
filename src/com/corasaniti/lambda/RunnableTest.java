package com.corasaniti.lambda;

public class RunnableTest {
	public static void main(String[] args) {
		 
	     System.out.println("=== RunnableTest ===");
	 
	    // Anonymous Runnable
	    Runnable r1 = new Runnable(){
	 
	      @Override
	      public void run(){
	        System.out.println("Hello world old style!");
	      }
	    };
	 
	   // Lambda Runnable Example
	   Runnable r2 = () -> System.out.println("Hello world with Lambda!");
	 
	   r1.run();
	   r2.run();   
	 }
}