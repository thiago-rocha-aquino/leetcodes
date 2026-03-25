//Escreva um programa que receba como enttrada um número inteiro n,
//correspondente ao número de vértices e apresente como saída a matriz e a lista de adjacências
//para o grafo completo Kn.

import java.util.*;
public class TeoriaGrafos2 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de vértices n para o grafo completo Kn: ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    matriz[i][j] = 1;
                }
            }
        }
        System.out.println(matriz.length*n);
        System.out.println("\nLista de Adjacências:");
        imprimirListaAdjacencia(matriz);
        System.out.println("\nMatriz de Adjacências:");
        imprimirMatriz(matriz);
        scanner.close();
    }


     public static void imprimirListaAdjacencia(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            System.out.print(i + ": "); // Ou i+1 se preferir base 1 para tudo
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] == 1){
                    System.out.print(j + " "); // Ou j+1 se preferir base 1 para tudo
                }
            }
            System.out.println();
        }
    }

     public static void imprimirMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}
