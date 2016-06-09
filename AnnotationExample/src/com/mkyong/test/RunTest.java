package com.mkyong.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.mkyong.test.core.AnnotationOne;
import com.mkyong.test.core.AnnotationTwo;

public class RunTest {

	
	/**
	 * RunTest --> TestExample --> AnnotationOne AND AnnotationTwo
	 * */
  public static void main(String[] args) throws Exception {

	
	System.out.println("Testing...");

	int passed = 0, failed = 0, count = 0, ignore = 0;

	Class<TestExample> testExample = TestExample.class;

	// Process @TesterInfo
	if (testExample.isAnnotationPresent(AnnotationTwo.class)) {

		Annotation annotationFromTestExample = testExample.getAnnotation(AnnotationTwo.class);
		AnnotationTwo annotationTwoInTestExample = (AnnotationTwo) annotationFromTestExample;//Casting the annotation in TestExample to TesterInfo type 

		System.out.printf("%nPriority :%s", annotationTwoInTestExample.priority());//Overridden by test Example
		System.out.printf("%nCreatedBy :%s", annotationTwoInTestExample.createdBy());//Overridden by test Example
		System.out.printf("%nTags :");
		
		//Overridden by test Example
		int tagLength = annotationTwoInTestExample.tags().length;
		for (String tag : annotationTwoInTestExample.tags()) {
			if (tagLength > 1) {
				System.out.print(tag + ", ");
			} else {
				System.out.print(tag);
			}
			tagLength--;
		}

		System.out.printf("%nLastModified :%s%n%n", annotationTwoInTestExample.lastModified());//NOT Overridden by test Example

	}

	// Process @Test
	for (Method method : testExample.getDeclaredMethods()) {//There are 3 methods

		// if method is annotated with @AnnotationOne
		if (method.isAnnotationPresent(AnnotationOne.class)) {
			
			System.out.println("TestExample.MethodName: " + method.getName());
			
			Annotation annotationFromTestExample = method.getAnnotation(AnnotationOne.class);
			AnnotationOne annotationOneInTestExample = (AnnotationOne) annotationFromTestExample;

			// if enabled = true (default)
			if (annotationOneInTestExample.enabled()) {

			  try {
				method.invoke(testExample.newInstance());//A,C,D methods invoked so those methods will print to screen 
				System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());//C Will always pass
				passed++;
			  } catch (Throwable ex) {
				System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());// A
				failed++;
			  }

			} else {
				System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());//B - @AnnotationOne(enabled = false)
				ignore++;
			}

		}

	}
	System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

	}
}