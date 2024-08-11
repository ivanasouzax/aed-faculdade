package Fila;
public class Teste {
    public static void main(String[] args) {
        Fila fila;

        //Testar a classe FilaArray
        fila  = new FilaArray(3);
        
        //Adicionar elementos na fila
        fila.enfileirar("Cliente 1");
        fila.enfileirar("Cliente 2");
        fila.enfileirar("Cliente 3");
        
        //Verificar se a fila está vazia
        System.out.println(fila.estaVazia());

        //Desenfileirar elementos da fila
        System.out.println("Atendendo cliente: " + fila.desenfileirar());
        System.out.println("Atendendo cliente: " + fila.desenfileirar());
        System.out.println("Atendendo cliente: " + fila.desenfileirar());


        //Testar a classe FilaEncadeada
        fila = new FilaEncadeada();
        
        //Adicionar elementos na fila
        fila.enfileirar("Cliente 4");
        fila.enfileirar("Cliente 5");
        fila.enfileirar("Cliente 6");
        
        //Desenfileirar elementos da fila
        System.out.println("Atendendo cliente: " + fila.desenfileirar());
        System.out.println("Atendendo cliente: "+ fila.desenfileirar());
        System.out.println("Atendendo cliente: "+ fila.desenfileirar());
    }
        
 }

