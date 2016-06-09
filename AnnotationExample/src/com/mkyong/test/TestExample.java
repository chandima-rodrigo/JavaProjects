package com.mkyong.test;

import com.mkyong.test.core.AnnotationOne;
import com.mkyong.test.core.AnnotationTwo;
import com.mkyong.test.core.AnnotationTwo.Priority;

//Annotation on the class
@AnnotationTwo(
	priority = Priority.HIGH, 
	createdBy = "cr.com",  
	tags = {"kpc_sales","kpc_test" })
public class TestExample {

	//Annotation on the method
	@AnnotationOne
	void testA() {
		System.out.println("testA1...");
	  if (true) {
		System.out.println("testA2...");
		throw new RuntimeException("This test always failed");
	  }
	}

	//Annotation on the method
	@AnnotationOne(enabled = false)
	void testB() {
		System.out.println("testB1...");
	  if (false){
		  System.out.println("testB2...");
		  throw new RuntimeException("This test always passed");
	  }
	}
	
	//Annotation on the method
	@AnnotationOne(enabled = true)
	void testC() {
		System.out.println("testC1...");
	  if (10 > 1) {
		// do nothing, this test always passed.
		System.out.println("testC2...");
	  }
	}
	
	//Annotation on the method
	@AnnotationOne(enabled = true)
	int testD() {
		System.out.println("testD...");
		return 7;
	}

	//Annotation on the method
	@AnnotationOne(enabled = false)
	int testE() {
		System.out.println("testE...");
		return 7;
	}
	

}
