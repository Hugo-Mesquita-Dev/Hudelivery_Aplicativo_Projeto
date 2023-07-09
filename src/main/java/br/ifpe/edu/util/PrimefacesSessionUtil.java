
package br.ifpe.edu.util;

import java.util.Map;
import org.primefaces.context.PrimeFacesContext;

public abstract class PrimefacesSessionUtil {  
    
    private static Map<String, Object> obtainSessionMap(){
        return PrimeFacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    }

    public static void putObjectInSession(String key, Object ob) {
        obtainSessionMap().put(key, ob);
    }
    
    public static Object catchObjectFromSession(String key){
        return obtainSessionMap().get(key);        
    }
    
    public static void removeObjectFromSession(String key){
        obtainSessionMap().remove(key);        
    }
    
    public boolean verifyIfAttributeExistsInSession(String atribute){
        return obtainSessionMap().containsKey(atribute);
    }
    
}
