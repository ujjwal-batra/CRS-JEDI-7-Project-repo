package com.crs.flipkart.utils;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig{
	
	public ApplicationConfig() {
        // this call has the same effect as
        // jersey.config.server.provider.packages
        // in the web.xml: it scans that packages for resources and providers. 
        packages("com.crs.flipkart.restController");
    }

}
