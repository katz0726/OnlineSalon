package jp.co.sample;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        this.packages(MyApplication.class.getPackage().getName())
            .register(JspMvcFeature.class);
    }
}
