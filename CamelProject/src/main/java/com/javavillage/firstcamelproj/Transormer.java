package com.javavillage.firstcamelproj;

public class Transormer {

	public String TransformContentMethod(String body) {
		System.out.println("Invoking the TranormerContent method");
		String upperCaseContent = body.toUpperCase();
		return upperCaseContent;
	}

}
