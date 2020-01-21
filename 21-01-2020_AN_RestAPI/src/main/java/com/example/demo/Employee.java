package com.example.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.*;

@Path("/apis")
public class Employee{
	static ArrayList<String> names = new ArrayList<String>();
	
	public Employee(){
		if(names.size()==0) {
		names.add("Abhijit");
		names.add("Akshat");
		}
	}
	
	@Path("/getmethod")
	@GET
	@Produces("application/json")
	public ArrayList<String> getUsers() {
		return names;
	}
	
	@Path("postmethod/{index}/{name}")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public ArrayList<String> postUsers(@PathParam("index") int index, @PathParam("name") String name) {
		if(index+1<=names.size())
			names.set(index, name);
		return names;
	}
	
	@Path("/putmethod/{name}")
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public ArrayList<String> addNames(@PathParam("name") String name) {
		names.add(name);
		return names;
	}
	
	@Path("/deletemethod/{index}")
	@Produces("application/json")
	@DELETE
	public String delete(@PathParam("index") int index) {
		String res = names.remove(index);
		return res;
	}
}