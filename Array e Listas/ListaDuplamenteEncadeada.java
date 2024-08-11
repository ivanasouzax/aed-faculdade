public class ListaDuplamenteEncadeada {
    private Element head;
    private Element tail;

    public final class Element {
        Object data;
        Element next, prev;

        Element(Object d, Element p, Element n) {
            data = d;
            prev = p;
            next = n;
        }

        public void isnserirInicio(Object item) {
            Element temp = new Element(item, null, head);
            if (head == null) {
                tail = temp;
            } else {
                head.prev = temp;
            }
            head = temp;
        }

        public void inserirFim(Object item) {
            Element temp = new Element(item, tail, null);
            if (tail == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
        }

        public void remover(Object item) {
            Element ptr = head;
            while (ptr != null && ptr.data != item) {
                ptr = ptr.next;
            }
            if (ptr == null) {
                throw new ObjetoNaoEncontradoException();
            }
            if (ptr == head) {
                head = ptr.next;
                head.prev = null;
            }
            if (ptr == tail) {
                tail = ptr.prev;
                tail.next = null;

            } else {
                (ptr.prev).next = ptr.next;
                (ptr.next).prev = ptr.prev;
            }
        }

        public void inserirAntes(Object item) {

            Element temp = new Element(item, prev, this);
                prev = temp;

            if (this == head) {
                head = prev;

            } else {
                temp.prev.next = temp;
            }

        }

        public void inserirDepois(Object item) {

            Element temp = new Element(item, this, next);
                next = temp;

            if (tail == this) {
                tail = next;

            } else {
                temp.next.prev = temp;
            }

        }

    }
}
