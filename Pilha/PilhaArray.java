package Pilha;

public class PilhaArray implements Pilha {
    private Object[] array;

    private int count;

    public PilhaArray(int tam) {

        count = 0;

        array = new Object[tam];

    }

    public void fazVazia() {

        while (count > 0)

            array[--count] = null;

    }

    public boolean estaVazia() {

        return count == 0;

    }

    public void push(Object objeto) {

        if (count == array.length)

            throw new ContainerCheioException(null);

        array[count] = objeto;

        count++;

    }

    public Object pop() {

        if (count == 0)

            throw new ContainerVazioException(null);

        count--;

        Object result = array[count];

        array[count] = null;

        return result;

    }

    public Object getTop () {

        if (count == 0)
        
        throw new ContainerVazioException(null);
        
        return array [count -1];
        
        }

    

}