package com.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webservices.beans.Person;

@Path("/json")
public class ProducingJSON {

	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(
			@QueryParam("name") String name,
			@QueryParam("age") int age,
			@QueryParam("email") String email
			) {

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setEmail(email);

		//return person;
		return Response.status(200).entity(person).build();
	}

}









