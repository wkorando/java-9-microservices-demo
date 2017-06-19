package com.keyholesoftware.employees.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class is necessary for the JPA Entity listener to access Spring Beans
 * 
 *
 */
@Component
public class JpaApplicationContext implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;

	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		CONTEXT = context;
	}

	public static <T> T getBean(Class<T> clazz) {
		return CONTEXT.getBean(clazz);
	}
}
