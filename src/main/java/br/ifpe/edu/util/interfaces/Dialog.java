
package br.ifpe.edu.util.interfaces;

import java.util.Map;

public interface Dialog{
    
    public void abrirDialog(Map<String, Object> opcoes, String dialog);
    
    public void fecharDialog(Object objeto);
    
}
