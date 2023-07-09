
package br.ifpe.edu.util.interfaces;


public interface Session {
    
    public void putObjectInSession(String name, Object ob);
    public Object catchObjectFromSession(String name);
    public void removeObjectFromSession(Object bo);
    public boolean verifyIfAttributeExistsInSession(String atribute);
    
}
