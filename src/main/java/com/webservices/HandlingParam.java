package com.webservices;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/param")
public class HandlingParam {
	@GET
	@Path("/query")
	public Response query(
			@QueryParam("name") String name,
			@QueryParam("age") int age
			) {

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);

		return Response.ok("Data Submitted").build();
	}
	
	
	
	
	
	
	


	@POST
	@Path("/form")
	public Response form(
		@FormParam("name") String name,
		@FormParam("age") int age) {

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		
		return Response.ok("Data Submitted").build();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GET
	@Path("/path/{name}/{age}")
	public Response path(
			@PathParam("name") String name,
			@PathParam("age") String age
			) {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		return Response.ok("Data Submitted").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
