import java.util.Arrays;

public class Gnome {
    
    // Método para realizar a ordenação Gnome Sort em um array
    static void gnomeSort(int arr[], int n) {
        int index = 0;  // Índice inicial

        // Loop até que o índice percorra todo o array
        while (index < n) {
            // Se o índice for 0, incrementa para avançar
            if (index == 0)
                index++;
            
            // Se o elemento atual for maior ou igual ao anterior, avança para o próximo elemento
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                // Caso contrário, troca os elementos e volta um passo
                int temp = 0;  // Variável temporária para a troca
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;  // Volta um passo para verificar novamente
            }
        }
        return;  // Retorna após a ordenação
    }

    // Método principal para testar o Gnome Sort
    public static void main(String[] args) {
        int arr[] = { 25, 20, 10, -5, 0};  // Array de exemplo para ordenação

        // Chama o método gnomeSort passando o array e seu comprimento
        gnomeSort(arr, arr.length);

        // Imprime o array ordenado
        System.out.print("Sequência classificada após aplicar a classificação do Gnome: ");
        System.out.println(Arrays.toString(arr));
    }
}
