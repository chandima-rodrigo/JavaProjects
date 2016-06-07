package com.example.university;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Exposing a university resources
@Path("/university")
public class UniversityRESTWS {

	
	//http://localhost/RESTfulWS/rest/university
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLUniversityInfo() {
		double d = Math.random();
		System.out.println("Method invoked " + d);
		return "<html>" +"<body><h1>" + "Called getHTMLUniversityInfo() " + d + 
				"</body></h1>" + "</html>";
	}

	//Replies plain text...
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getXMLUniversityInfo() {
		return "You called getXMLUniversityInfo() ";
	}

	//To test this I used Advanced API Google app. and it works. It calls the put mthod
	//http://localhost/RESTfulWS/rest/university/25
	@PUT
	@Path("{studentRollNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUniversityInfo(@PathParam("studentRollNo") String studentRollNo) {
		//UPDAT STUDENT RECORD UNSING studentRollNo
		System.out.println(studentRollNo +" updateUniversityInfo invoked " + Math.random());
		return "Done Sucessfully!! " + studentRollNo;
	}	
}
