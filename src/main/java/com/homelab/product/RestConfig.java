package com.homelab.product;

import com.homelab.product.rest.ProductResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestConfig extends Application {
}