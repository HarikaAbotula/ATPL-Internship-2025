package com.aaslin.springbootInterceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    // Called before the controller method
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("[PreHandle] Incoming Request URL: " + request.getRequestURL());
        return true; // proceed to controller
    }

 // Called after the controller method but before the view renders
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            System.out.println("[PostHandle] View Name: " + modelAndView.getViewName());
            System.out.println("[PostHandle] Model Data: " + modelAndView.getModel());
        } else {
            System.out.println("[PostHandle] No ModelAndView (might be @ResponseBody)");
        }
    }

 // Called after the response is sent
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("[AfterCompletion] Response Status: " + response.getStatus());
        if (ex != null) {
            System.out.println("[AfterCompletion] Exception: " + ex.getMessage());
        }
    }
}
