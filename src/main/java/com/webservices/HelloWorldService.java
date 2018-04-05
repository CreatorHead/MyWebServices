package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloWorldService {
	@GET
	@Path("hello2")
	public String hello2() {

		return "Web Services";

	}

	@GET
	@Path("hello")
	public String hello() {

		return "Hello World From Web Services";

	}



}