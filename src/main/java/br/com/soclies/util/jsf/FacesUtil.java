package br.com.soclies.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe para enviar mensagens de excessões.
 * @author Fernando Ortiz
 */

public class FacesUtil {
    
    /* metodo que verifica se a requisicao é postBack (se ja foi renderizada) */
    public static boolean isPostback(){
        return FacesContext.getCurrentInstance().isPostback();
    }
    
    public static boolean isNotPostback(){
        return !isPostback();
    }
    
    public static void addErrorMessage(String message){
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }
    
    public static void addInfoMessage(String message){
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }
    
    public static void addWarMessage(String message){
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
    }
}
 