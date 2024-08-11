package Classificada;
public interface Cursor {

    Object getDado();
    
    void inserirDepois (Object o);
    
    void inserirAntes (Object o);
    
    void remover();
    
    }
