/**
 * 
 */
package com.crs.flipkart.restController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crs.flipkart.bean.Professor;

@Path("/professor")
public class ProfessorRestAPI {
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public Response professorLogin(Professor professor) {
		return Response.status(200).entity("Success").build();
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {
		return Response.status(200).entity("Success").build();
	}
}
