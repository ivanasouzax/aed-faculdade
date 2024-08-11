package Fila;

public class FilaEncadeada implements Fila {

    private ListaEncadeada lista;

    private int count;

    public FilaEncadeada() {

        lista = new ListaEncadeada();
        count = 0;

    }

    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }

    public Object getPrimeiro() {
        if (count == 0)
            throw new ContainerVazioException(null);
        return lista.getPrimeiro();
    }

    public void enfileirar(Object objeto) {
        lista.inserirFim(objeto);
        count++;
    }

    public Object desenfileirar() {
        if (count == 0)
            throw new ContainerVazioException(null);

        Object result = lista.getPrimeiro();
        lista.extrair(result);
        --count;
        return result;

    }

    @Override
    public boolean estaVazia() {
        throw new UnsupportedOperationException("Unimplemented method 'estaVazia'");
    }

}