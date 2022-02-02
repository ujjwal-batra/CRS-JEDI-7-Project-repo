package com.crs.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig{
	
	public ApplicationConfig() {
        packages("com.crs.flipkart.restController");
    }

}
