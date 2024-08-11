package Classificada;

public class TesteClassificada {
    public static void main(String[] args) {
        ListaClassificadaEncadeada lista = new ListaClassificadaEncadeada();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);

        // Encontrar a posição para inserir o valor 5
        Cursor cursor = lista.procurarPosicao(5);

        // Se o cursor é válido, remover e inserir o novo valor
        if (cursor != null) {
            // Remover o elemento se necessário
            cursor.remover();
            
            // Inserir o novo valor
            cursor.inserirDepois(5);
        } else {
            System.out.println("Não foi possível encontrar uma posição para inserir o valor.");
        }
    }
}

