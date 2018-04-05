package com.webservices;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.caps.dto.Person;
import com.webservices.dao.JDBCImpl;

@Path("person")
public class GetPerson {
	
	@Path("xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getPersonXML(@QueryParam("id")int id) {
		JDBCImpl db = new JDBCImpl();
		Person p = db.getPerson(id);
		return Response.ok().entity(p).build();
	}
	
	@Path("json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonJSON(@QueryParam("id")int id) {
		JDBCImpl db = new JDBCImpl();
		Person p = db.getPerson(id);
		return Response.ok().entity(p).build();
	}

}
