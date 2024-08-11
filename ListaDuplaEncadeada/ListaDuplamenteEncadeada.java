public class ListaDuplamenteEncadeada<T> {
    private Element<T> head;
    private Element<T> tail;

    public class Element<T> {
        T data;
        Element<T> next, prev;

        Element(T d, Element<T> p, Element<T> n) {
            data = d;
            prev = p;
            next = n;
        }

        public T getData() {
            return data;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }
    }

    public void inserirInicio(T item) {
        Element<T> temp = new Element<>(item, null, head);
        if (head == null) {
            tail = temp;
        } else {
            head.prev = temp;
        }
        head = temp;
    }

    public void inserirFim(T item) {
        Element<T> temp = new Element<>(item, tail, null);
        if (tail == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public void remover(T item) throws ObjetoNaoEncontradoException {
        Element<T> ptr = head;
        while (ptr != null && !ptr.data.equals(item)) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            throw new ObjetoNaoEncontradoException();
        }
        if (ptr == head) {
            head = ptr.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (ptr == tail) {
            tail = ptr.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            ptr.prev.next = ptr.next;
            if (ptr.next != null) {
                ptr.next.prev = ptr.prev;
            }
        }
    }

    public boolean estaVazia() {
        return head == null;
    }

    public Element<T> getHead() {
        return head;
    }

    public void setHead(Element<T> head) {
        this.head = head;
    }

    public Element<T> getTail() {
        return tail;
    }

    public void setTail(Element<T> tail) {
        this.tail = tail;
    }
}
