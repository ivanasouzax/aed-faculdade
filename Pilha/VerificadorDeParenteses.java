package Pilha;

import java.util.Scanner;
public class VerificadorDeParenteses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a cadeia de parênteses:");
        String cadeia = scanner.nextLine();

        if (estaBalanceada(cadeia)) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }

        scanner.close();
    }

  
    public static boolean estaBalanceada(String cadeia) {
        PilhaArray pilha = new PilhaArray(cadeia.length()); 

        for (char caractere : cadeia.toCharArray()) {
            if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                if (pilha.estaVazia()) {
                    return false; 
                }
                pilha.pop();
            }
        }

        return pilha.estaVazia();
    }
}
