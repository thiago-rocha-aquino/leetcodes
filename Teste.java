import java.util.*;
public class Teste {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de vértices: ");
        int n; 
        n = scanner.nextInt();
        String [] cidades = new String[n];
        int [][] matriz = new int[n][n];


        scanner.nextLine(); // Limpa o buffer do scanner para ler as cidades corretamente
        System.out.println("Digite os valores da matriz de adjacência (linha por linha):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Digite os nomes das cidades:");
        for (int i = 0; i < n; i++) {
            cidades[i] = scanner.nextLine();
        }

        System.out.println("\n--- Resultados ---");
        //imprimirArestas(matriz);
        GerarGrafos(matriz, cidades);
        
        scanner.close();
     }
     
     public static void imprimirArestas(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] > 0){
                    System.out.println("Aresta de " + i + " para " + j);
                }
            }
        }
     }

     public static void GerarGrafos(int[][] matriz, String[] cidades){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] > 0){
                    System.out.println("Origem: " + cidades[i] + " -->| "+ "peso: "+ matriz[i][j] + " |--> Destino: " + cidades[j]);
                }
            }
        }
     } 

}
