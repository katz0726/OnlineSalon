package jp.co.sample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

@Path("api")
public class MyResource {
    @GET
    @Path("/hello-mvc")
    @Template(name="/hello-mvc")
    public String helloWorld() {
    	System.out.println("Hello, world");

        return "Hello, world";
    }

    @POST
    @Path("/confirm")
    @Template(name="/confirm")
    public Map<String, Object> confirm() {
		Map<String, Object> model = new HashMap<String, Object>();
		Date now = new Date();

		model.put("id", "0000001");
		model.put("name", "渡辺　翔也");
		model.put("email", "sample@gmail.com");
		model.put("timestamp", now);
		return model;
    }
}
