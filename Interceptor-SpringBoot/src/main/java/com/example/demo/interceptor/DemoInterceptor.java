package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class DemoInterceptor implements HandlerInterceptor{

	//by implementing HandlerInterceptor. In this interceptor, we’ll log request details,
	//check for an authorization header, and measure the time taken for request processing.
	
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        // Log request details
	        System.out.println("Incoming request data - URL: " + request.getRequestURL() + ", Method: " + request.getMethod());
	        
	        // Example: Checking for a custom header "X-Auth-Token" for authorization
	        String authToken = request.getHeader("X-Auth-Token");
	        if (authToken == null || !authToken.equals("expected_token_value")) {
	            // Return false to block the request if token is missing or invalid
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            response.getWriter().write("Unauthorized");
	            return false;
	        }

	        // Store start time to calculate the time taken by the request
	        request.setAttribute("startTime", System.currentTimeMillis());

	        // Continue with the request
	        return true;
	    }
	 
	 

	    // Called after the controller has processed the request but before the view is rendered
	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        // Log post-processing details if needed
	        System.out.println("Request processed successfully by controller.");
	    }

	    // Called after the view has rendered and the request is complete
	    
	    
	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        // Calculate the time taken by the request
	        long startTime = (Long) request.getAttribute("startTime");
	        long endTime = System.currentTimeMillis();
	        long executeTime = endTime - startTime;

	        // Log the time taken
	        System.out.println("Request completed. Time taken: " + executeTime + " ms");

	        // Log any exception thrown during request processing
	        if (ex != null) {
	            System.out.println("Exception occurred: " + ex.getMessage());
	        }
	    }
}
