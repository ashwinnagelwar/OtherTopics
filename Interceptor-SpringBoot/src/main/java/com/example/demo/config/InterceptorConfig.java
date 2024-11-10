package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.DemoInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	
	//To apply this interceptor, we need to register it in the Spring MVC configuration.
	//We’ll create a configuration class and override the addInterceptors method.
	private  DemoInterceptor demoInterceptor;

	    // Inject the CustomInterceptor via constructor
	    public InterceptorConfig(DemoInterceptor demoInterceptor) {
	        this.demoInterceptor = demoInterceptor;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // Register the interceptor and specify URL patterns if needed
	        registry.addInterceptor(demoInterceptor)
	                .addPathPatterns("/secured/**")     // Intercept all paths
	                .excludePathPatterns("/public/**"); // Exclude specific paths if needed
	    }
}
