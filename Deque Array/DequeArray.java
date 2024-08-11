public class DequeArray implements Deque {
    private Object deque[];
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public DequeArray(int capacidade) {
        this.capacidade = capacidade;
        deque = new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void fazVazia() {
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public Object getPrimeiro() {
        if (estaVazia()) {
            throw new DequeVazioException();
        }
        return deque[inicio];
    }

    public Object getUltimo() {
        if (estaVazia()) {
            throw new DequeVazioException();
        }
        return deque[fim];
    }

    public void enfileirarInicio(Object objeto) {
        if (tamanho == capacidade) {
            throw new DequeCheioException();
        }
        inicio = (inicio - 1 + capacidade) % capacidade;
        deque[inicio] = objeto;
        tamanho++;
    }

    public void enfileirarFim(Object objeto) {
        if (tamanho == capacidade) {
            throw new DequeCheioException();
        }
        deque[fim] = objeto;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }

    public Object desenfileirarInicio() {
        if (estaVazia()) {
            throw new DequeVazioException();
        }
        Object objeto = deque[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return objeto;
    }

    public Object desenfileirarFim() {
        if (estaVazia()) {
            throw new DequeVazioException();
        }
        fim = (fim - 1 + capacidade) % capacidade;
        Object objeto = deque[fim];
        tamanho--;
        return objeto;
    }

}