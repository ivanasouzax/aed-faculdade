public class ListaSimples {
    private Element head;
    private Element tail;
    private int count;

    public class Element {
        Object data;
        Element next, prev;

        Element(Object d, Element n, Element p) {
            data = d;
            next = n;
            prev = p;
        }

        public Object getData() {
            return data;
        }

        public Element getNext() {
            return next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }

    public void inserirInicio(Object item) {
        Element temp = new Element(item, head, null);
        if (head != null) {
            head.prev = temp;
        } else {
            tail = temp;  // se a lista estava vazia, tail também aponta para o novo elemento
        }
        head = temp;
        count++;
    }

    public void inserirFim(Object item) {
        Element temp = new Element(item, null, tail);
        if (tail != null) {
            tail.next = temp;
        } else {
            head = temp;  // se a lista estava vazia, head também aponta para o novo elemento
        }
        tail = temp;
        count++;
    }

    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ptr = head;
        while (ptr != null && !ptr.data.equals(item)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            throw new ObjetoNaoEncontradoException();
        }

        if (ptr.prev != null) {
            ptr.prev.next = ptr.next;
        } else {
            head = ptr.next;  
        }

        if (ptr.next != null) {
            ptr.next.prev = ptr.prev;
        } else {
            tail = ptr.prev;  
        }
        count--;
    }

    public boolean estaVazia() {
        return head == null;
    }

    public Element getHead() {
        return head;
    }
    
    public Element getTail() {
        return tail;
    }

    public void fazVazia() {
        head = null;
        tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void atribuir(ListaSimples l) {
        if (l != this) {
            this.fazVazia();
            for (Element ptr = l.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }
}
