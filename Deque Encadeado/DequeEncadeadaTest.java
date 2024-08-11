public class DequeEncadeadaTest {

    public static void main(String[] args) {
        DequeEncadeada deque = new DequeEncadeada();

                System.out.println("Teste 1 - Está vazia (esperado: true): " + deque.estaVazia());
        
                deque.enfileirarInicio("Elemento");
        
                System.out.println("Teste 2 - Está vazia após enfileirar (esperado: false): " + deque.estaVazia());
        
                deque.enfileirarInicio("Primeiro");
                System.out.println("Enfileirar no início: Esperado [Primeiro], Obtido [" + deque.desenfileirarInicio() + "]");
        
                deque.enfileirarFim("Último");
                System.out.println("Enfileirar no fim: Esperado [Último], Obtido [" + deque.desenfileirarFim() + "]");
        
                deque.enfileirarInicio("Primeiro");
                deque.enfileirarFim("Segundo");
                System.out.println("Desenfileirar do início: Esperado [Primeiro], Obtido [" + deque.desenfileirarInicio() + "]");
        
                deque.enfileirarInicio("Primeiro");
                deque.enfileirarFim("Segundo");
                System.out.println("Desenfileirar do fim: Esperado [Segundo], Obtido [" + deque.desenfileirarFim() + "]");
        
    }
}