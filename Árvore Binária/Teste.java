public class Teste {
    public static void main(String[] args) {

        // Criação dos nós
        Node<String> raiz = new Node<>("A");
        raiz.inserirOrdenado("B");
        raiz.inserirOrdenado("C");
        raiz.inserirOrdenado("D");
        raiz.inserirOrdenado("E");
        raiz.inserirOrdenado("F");
        raiz.inserirOrdenado("G");
        raiz.inserirOrdenado("H");
        raiz.inserirOrdenado("I");

        System.out.println("Impressão em Ordem");
        raiz.imprimeInOrdem();
        System.out.println();

        System.out.println("Impressão Pré Ordem");
        raiz.imprimePreOrdem();
        System.out.println();

        System.out.println("Impressão Pós Ordem");
        raiz.imprimePosOrdem();
        System.out.println();

        System.out.println("Impressão em Largura");
        raiz.imprimeEmLargura();
        System.out.println();

        
        // Teste do método pesquisarValor
        System.out.println("Teste de pesquisa de valor:");
        String valorPesquisado = "E";
        Node<String> resultado = raiz.pesquisarValor(valorPesquisado);
        if (resultado != null) {
            System.out.println("Valor " + valorPesquisado + " encontrado: " + resultado.getValor());
        } else {
            System.out.println("Valor " + valorPesquisado + " não encontrado.");
        }
    }
}
