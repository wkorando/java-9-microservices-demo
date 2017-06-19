package com.keyholesoftware.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jaime Niswonger
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulServer extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulServer.class).web(true).run(args);
	}
}
