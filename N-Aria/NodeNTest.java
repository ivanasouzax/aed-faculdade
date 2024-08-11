public class NodeNTest {
    public static void main(String[] args) {
        int N = 4;
        
        // Criando a árvore de inteiros
        NodeN<Integer> intTree = new NodeN<>(N);
        intTree.inserir(10);
        intTree.inserir(20);
        intTree.inserir(5);
        intTree.inserir(15);
        intTree.inserir(25);
        
        System.out.println("Árvore de inteiros:");
        printTree(intTree);
        
        // Criando a árvore de strings
        NodeN<String> stringTree = new NodeN<>(N);
        stringTree.inserir("banana");
        stringTree.inserir("morango");
        stringTree.inserir("tangerina");
        stringTree.inserir("jaca");
        stringTree.inserir("uva");
        
        System.out.println("\nÁrvore de strings:");
        printTree(stringTree);
    }
    
    public static <T> void printTree(NodeN<T> node) {
        if (node == null) return;
        
        // Imprimindo os valores do nó atual
        for (int i = 0; i < node.getNAtual(); i++) {
            System.out.print(node.getK()[i] + " ");
        }
        System.out.println();
        
        // Recursivamente imprimindo as sub-árvores
        for (int i = 0; i < node.getP().length; i++) {
            printTree(node.getP()[i]);
        }
    }
}