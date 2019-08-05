package jp.co.salon;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

@ApplicationPath("/")
public class RestApplication extends ResourceConfig {
    public RestApplication() {
        this.packages(RestApplication.class.getPackage().getName())
            .register(JspMvcFeature.class);
    }
}