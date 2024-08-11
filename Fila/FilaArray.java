package Fila;

public class FilaArray implements Fila {

    private Object[] array;

    private int head, tail, count;

    public FilaArray(int tam) {

        array = new Object[tam];
        head = 0;
        tail = tam - 1;
        count = 0;

    }

    public void fazVazia() {

        while (count >0) {
        array[head] = null;
        ++ head;
        
        if (head == array.length) 
        head= 0;
        --count;
        
        }
    }

    public boolean estaVazia() {
        return (count == 0);
    }

    public Object getPrimeiro() {

        if (count ==0)
        throw new ContainerVazioException(null);
        return array [head];
        
    }

    public void enfileirar (Object objeto) {

        if (count == array.length )
            throw new ContainerCheioException(null);
        ++tail;
        
        if (tail == array.length )
        tail = 0;
        array [tail] = objeto;
        ++count;
        
        }

        public Object desenfileirar () {

            if (count == 0 )
               throw new ContainerVazioException(null);
            
            Object result = array [head];
            array[head] = null;
            ++head;
            
            if (head == array.length)
            head = 0;
            --count;
            return result;
            
            }
}