//escreva um programa que receba como entrada uma matriz de adjacências de um grafo simples,
//  poderando e conexo e escreva como saida as arestas(na forma de pares ordenados e seus pesos)
import java.util.*;
public class TeoriaGrafos3 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de vértices do grafo: ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];
        System.out.println("Digite os valores da matriz de adjacência linha por linha (use 0 para indicar ausência de aresta):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("\nArestas e seus pesos:");
        // Percorrendo apenas a parte triangular superior (j > i) para evitar arestas duplicadas
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matriz[i][j] != 0) {
                    System.out.println("(" + i + ", " + j + ") - Peso: " + matriz[i][j]);
                }
            }
        }
        scanner.close();
    }
}
