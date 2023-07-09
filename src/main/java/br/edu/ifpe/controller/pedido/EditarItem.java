
package br.edu.ifpe.controller.pedido;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;


@Named
@ViewScoped
public class EditarItem implements Serializable{
    
    public void abrirDialogEdicao(){
        
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("modal", true);
        options.put("closable", false);
        options.put("width", 400);
        options.put("height", 300);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        PrimeFaces.current().dialog().openDynamic("dialogs/dialogEditarItem", options, null);
        
    }
    
}
