import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TeoriaGrafos4 {
  public static void main(String[] args) {
        // Nome do arquivo definido na dica do exercício
        String nomeArquivo = "entrada.txt";

        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            // Verifica se o arquivo tem pelo menos a dimensão da matriz
            if (!scanner.hasNextInt()) {
                System.out.println("Arquivo vazio ou formato incorreto.");
                scanner.close();
                return;
            }

            // Lê a primeira linha: a dimensão (N) da matriz
            int n = scanner.nextInt();
            int[][] matriz = new int[n][n];

            // Lê os elementos da matriz triangular inferior
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (scanner.hasNextInt()) {
                        int valor = scanner.nextInt();
                        
                        // Preenche a posição original (triângulo inferior)
                        matriz[i][j] = valor;
                        
                        // Reflete o valor para a posição simétrica (triângulo superior)
                        matriz[j][i] = valor; 
                    }
                }
            }
            scanner.close();

            // Imprime a matriz completa resultante
            System.out.println("Matriz Completa:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(); // Pula para a próxima linha
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo '" + nomeArquivo + "' não foi encontrado.");
            System.out.println("Certifique-se de que o arquivo entrada.txt está na mesma pasta de execução do programa.");
        }
    }
}
