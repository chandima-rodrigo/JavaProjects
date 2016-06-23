package com.javavillage.firstcamelproj;


import org.apache.camel.builder.RouteBuilder;

public class FirstRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:C:/camel/input?noop=true")
		.process(new LogProccessor())
		.bean(new Transormer(), "TransformContentMethod")
		.to("file:C:/camel/output");
	}


}
