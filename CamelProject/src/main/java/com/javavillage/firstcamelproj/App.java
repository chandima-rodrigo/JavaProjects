package com.javavillage.firstcamelproj;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstRouteBuilder firstRouteBuilder = new FirstRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
		try  {
			ctx.addRoutes(firstRouteBuilder);
			ctx.start();
			Thread.sleep(5*60*1000);
			ctx.stop();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
