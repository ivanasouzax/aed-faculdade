public interface Deque{

    void fazVazia();
    
    boolean estaVazia();
    
    Object getPrimeiro();
    
    Object getUltimo();
    
    void enfileirarInicio(Object objeto);
    
    void enfileirarFim(Object objeto);
    
    Object desenfileirarInicio();
    
    Object desenfileirarFim();
    
}