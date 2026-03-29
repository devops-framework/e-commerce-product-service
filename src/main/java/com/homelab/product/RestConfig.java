package com.homelab.product;

import com.homelab.product.rest.ProductResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		// Explicitly register resource classes so they are available even if
		// annotation scanning is not enabled in the container.
		classes.add(ProductResource.class);
		return classes;
	}
}