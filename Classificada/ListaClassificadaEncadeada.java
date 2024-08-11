package Classificada;
public class ListaClassificadaEncadeada implements ListaClassificada {


    protected class MeuCursor implements Cursor {

        ListaEncadeada.Element elemento;

        MeuCursor(ListaEncadeada.Element elem) {

            elemento = elem;

        }

        @Override
        public Object getDado() {

            return elemento.getData();

        }

        @Override
        public void inserirDepois(Object o) {

            elemento.inserirDepois(o);

            count++;

        }

        @Override
        public void inserirAntes(Object novoElemento) {
            if (this.elemento == null) {
               
            } else {
                this.elemento.inserirAntes(novoElemento);
            }
        }

        @Override
        public void remover() {
            lista.extrair(elemento.getData());

            count--;

        }

    }

    private ListaEncadeada lista;

    int count;

    public ListaClassificadaEncadeada() {

        lista = new ListaEncadeada();

        count = 0;

    }

    public void inserir(Object objeto) {

        Cursor cursor = procurarPosicao(objeto);
        if (cursor != null) {
            cursor.inserirAntes(objeto);
            count++;
        } else {
            throw new RuntimeException("Objeto já existe na lista");
        }
    }

    public Cursor procurarPosicaoAInserir(Object arg) {
        ListaEncadeada.Element ptr = lista.getHead();
        while (ptr != null) {
            if (ptr.getValor().equals(arg)) {
                // Objeto já existe, retorna null
                return null;
            }
            ptr = ptr.getProximo();
        }
        
        return new MeuCursor(ptr);

    }

    public Cursor procurarPosicao(Object arg) {

        ListaEncadeada.Element ptr;

        for (ptr = lista.getHead(); ptr != null; ptr = ptr.getNext()) {

            Object obj = ptr.getData();

            if (obj.equals(arg))

                break;

        }

        return new MeuCursor(ptr);

    }

    public Object get(int offset) {

        if (offset < 0 || offset >= count)

            throw new IndexOutOfBoundsException();

        ListaEncadeada.Element ptr;

        ptr = lista.getHead();

        for (int i = 0; i < offset && ptr != null; i++)

            ptr = ptr.getNext();

        return ptr.getData();

    }

    public boolean eMembro(Object objeto) {

        ListaEncadeada.Element ptr;

        for (ptr = lista.getHead();

                ptr != null; ptr = ptr.getNext()) {

            if (ptr.getData() == objeto)

                return true;

        }

        return false;

    }

    public Object procurar(Object arg) {

        ListaEncadeada.Element ptr;

        for (ptr = lista.getHead(); ptr != null; ptr = ptr.getNext()) {

            Object obj = ptr.getData();

            if (obj.equals(arg))

                return obj;

        }

        return null;

    }

    public void remover(Object objeto) {

        if (count == 0)

            throw new RuntimeException(
                    "Lista vazia");
        // throw new ContainerVazioException();

        lista.extrair(objeto);

        count--;

    }

}