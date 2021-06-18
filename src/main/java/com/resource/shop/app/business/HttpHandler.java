/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.business;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bnc
 */
public class HttpHandler {
    
  private static HttpHandler instance = new HttpHandler();
	
	private HttpHandler() {
		
	}
	
	public static HttpHandler getInstance() {
		return instance;
	}
	
	public HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public void addToSession(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	public void invalidateSession() {
        getSession().invalidate();
	}
	

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public String getParameterByName(String name) {
        HttpServletRequest req = getRequest();
        return req.getParameter(name);
    }
    
    public void addErrorMessage(String clientId, String message) {
    	FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(
    		FacesMessage.SEVERITY_ERROR, message, ""));
    }
}
