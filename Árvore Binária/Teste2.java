public class Teste2 {
    public static void main(String[] args){

        Node<String> raiz = new Node<>("05");

        raiz.inserirOrdenado("03");
        raiz.inserirOrdenado("10");
        raiz.inserirOrdenado("01");
        raiz.inserirOrdenado("04");
        raiz.inserirOrdenado("08");
        raiz.inserirOrdenado("20");
        raiz.inserirOrdenado("15");
        raiz.inserirOrdenado("25");
        raiz.inserirOrdenado("22");
        raiz.inserirOrdenado("20");
        
        

        System.out.println("Teste de pesquisa de valor:");
        String valorPesquisado = "25";
        Node<String> resultado = raiz.pesquisarValor(valorPesquisado);
        if (resultado != null) {
            System.out.println("Valor " + valorPesquisado + " encontrado: " + resultado.getValor());
        } else {
            System.out.println("Valor " + valorPesquisado + " não encontrado.");
        }

        raiz.removerNode("25", raiz);

        System.out.println("Impressão em Largura");
        raiz.imprimeEmLargura();
        System.out.println();

    }
}
