package eu.telepski.test.hazelcast.wildfly10.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hazelcast.core.IMap;

@Path("things")
public class ThingsResource {
	
	@Inject IMap<String, Object> cache;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response thing() {
		return Response.ok("Cache instance is: " + cache).build();
	}
}
