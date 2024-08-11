public class FilaEncadeada<T> {
    private static class Node<T> {
        private T elemento;
        private Node<T> proximo;

        public Node(T elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private Node<T> frente;
    private Node<T> tras;
    private int tamanho;

    public FilaEncadeada() {
        frente = null;
        tras = null;
        tamanho = 0;
    }

    public boolean vazia() {
        return frente == null;
    }

    public void enfileira(T elemento) {
        Node<T> novoNo = new Node<>(elemento);
        if (vazia()) {
            frente = novoNo;
        } else {
            tras.proximo = novoNo;
        }
        tras = novoNo;
        tamanho++;
    }

    public T desenfileira() {
        if (vazia()) {
            throw new RuntimeException("Fila vazia");
        }
        T elemento = frente.elemento;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        tamanho--;
        return elemento;
    }

    public int tamanho() {
        return tamanho;
    }
}
