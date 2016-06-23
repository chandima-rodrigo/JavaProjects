package com.javavillage.firstcamelproj;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class LogProccessor implements Processor {

	public void process(Exchange arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing " + arg0.getIn().getBody(String.class));
	}

}
