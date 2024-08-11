public class ListaSimples<T> {
    private Element<T> head;
    private Element<T> tail;

    public class Element<T> {
        T data;
        Element<T> next, prev;

        Element(T d, Element<T> n, Element<T> p) {
            data = d;
            next = n;
            prev = p;
        }

        public T getData() {
            return data;
        }

        public Element<T> getNext() {
            return next;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }
    }

    public void inserirInicio(T item) {
        Element<T> temp = new Element<>(item, head, null);
        if (head != null) {
            head.prev = temp;
        } else {
            tail = temp;  // se a lista estava vazia, tail também aponta para o novo elemento
        }
        head = temp;
    }

    public void inserirFim(T item) {
        Element<T> temp = new Element<>(item, null, tail);
        if (tail != null) {
            tail.next = temp;
        } else {
            head = temp;  // se a lista estava vazia, head também aponta para o novo elemento
        }
        tail = temp;
    }

    public void extrair(T item) throws ObjetoNaoEncontradoException {
        Element<T> ptr = head;
        while (ptr != null && !ptr.data.equals(item)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            throw new ObjetoNaoEncontradoException();
        }

        if (ptr.prev != null) {
            ptr.prev.next = ptr.next;
        } else {
            head = ptr.next;  // se ptr é head, atualizar head
        }

        if (ptr.next != null) {
            ptr.next.prev = ptr.prev;
        } else {
            tail = ptr.prev;  // se ptr é tail, atualizar tail
        }
    }

    public boolean estaVazia() {
        return head == null;
    }

    public Element<T> getHead() {
        return head;
    }
    
    public Element<T> getTail() {
        return tail;
    }

    public void fazVazia() {
        head = null;
        tail = null;
    }
    
    public void atribuir(ListaSimples<T> l) {
        if (l != this) {
            this.fazVazia();
            for (Element<T> ptr = l.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }
}
