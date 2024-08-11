package Fila;
public interface Fila {

    void fazVazia();

    boolean estaVazia();

    Object getPrimeiro();

    void enfileirar(Object objeto);

    Object desenfileirar();

}