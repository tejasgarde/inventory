package com.chanda.inventory.managedbeans;

import java.util.Map;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;


@RequestScoped
public abstract class AbstractMB {

    @ManagedProperty(value="#{facesContext}")
    private FacesContext facesContext;

    @ManagedProperty(value="#{requestScope}")
    private Map<String, Object> requestMap;

    @ManagedProperty(value="#{sessionScope}")
    private Map<String, Object> sessionMap;

    public boolean isUserLoggedIn() {
        return getSessionMap().containsKey("currentUser");
    }

    // The compiler can optimizes calls such as this into plain field accesses.
    // Therefore, there is no performance penalty for always using the
    // accessor.
    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext context) {
        this.facesContext = context;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Map<String, Object> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, Object> requestMap) {
        this.requestMap = requestMap;
    }

    public Flash getFlash() {
        return getFacesContext().getExternalContext().getFlash();
    }

}
