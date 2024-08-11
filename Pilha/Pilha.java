package Pilha;

public interface Pilha{

    void fazVazia();
    
    boolean estaVazia();
    
    Object getTop();
    
    void push(Object o);
    
    Object pop();
    
}