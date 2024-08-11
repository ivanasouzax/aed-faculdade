package Classificada;
public interface ListaClassificada {

    Object get (int i);
    
    Cursor procurarPosicao (Object o);
    
    boolean eMembro(Object o);
    
    void inserir (Object o);
    
    void remover (Object o);
    
    Object procurar (Object o);
    
    }
