package com.autolease.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request,
			ModelMap modelMap) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	        else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	modelMap.addAttribute("msg", "Invalid user id password");
	        	return "showLogin";
	        }
	    }
	    return "error";
	}

}
