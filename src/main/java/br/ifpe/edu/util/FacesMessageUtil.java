package br.ifpe.edu.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public abstract class FacesMessageUtil {

    private static FacesContext context() {
        return FacesContext.getCurrentInstance();
    }

    public static void infoMessage(String message) {
        context().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
    }

    public static void warnMessage(String message) {
        context().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
    }

    public static void errorMessage(String message) {
        context().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
    }

    public static void fatalMessage(String message) {
        context().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
    }

}
