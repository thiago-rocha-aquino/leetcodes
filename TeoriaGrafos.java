import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TeoriaGrafos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de vértices: ");
        int n; // Número de vértices
        n = scanner.nextInt();
        int [][] matriz = new int[n][n];
        
        System.out.println("Digite os valores da matriz de adjacência (linha por linha):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("\n--- Resultados ---");
        imprimirArestas(matriz);
        
        if (ehDirecionado(matriz)) {
            System.out.println("Dígrafo");
        } else {
            System.out.println("Não-direcionado");
        }
        if (ehConexo(matriz)) {
            System.out.println("Conexo");
        } else {
            System.out.println("Desconexo");
        }
        imprimirGraus(matriz, ehDirecionado(matriz));

        if (ehCiclico(matriz, ehDirecionado(matriz))) {
            System.out.println("Cíclico");
        } else {
            System.out.println("Acíclico");
        }
        
        List<List<Integer>> listaAdjacencia = converterParaListaAdjacencia(matriz);
        System.out.println("Lista de Adjacências:");
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            System.out.println(i + ": " + listaAdjacencia.get(i));
        }
        
        scanner.close();
    }

    // a) Quais são as arestas do grafo?
    public static void imprimirArestas(int[][] matriz) {
        // DICA: Percorra a matriz com dois 'for' (i e j). 
        // Se matriz[i][j] for maior que 0 (ou igual a 1), imprima que existe aresta de 'i' para 'j'.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 0 ) { // Evita imprimir laços (arestas de um vértice para ele mesmo)
                    System.out.println("Aresta de " + i + " para " + j);
                }
            }
        }

    }

    // b) É um dígrafo ou grafo não-direcionado?
    public static boolean ehDirecionado(int[][] matriz) {
        // DICA: Um grafo é NÃO-direcionado se a matriz for perfeitamente simétrica.
        // Ou seja, verifique se matriz[i][j] == matriz[j][i] para todos os casos.
        // Se achar algum diferente, é um dígrafo (direcionado).
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] != matriz[j][i]){
                    return true; // É direcionado
                    
                }
            }
        }
        return false; // É não-direcionado

    }
    // c) Qual é o grau de cada vértice?
    public static void imprimirGraus(int[][] matriz, boolean direcionado) {
        System.out.println("Graus dos vértices:");
        for (int i = 0; i < matriz.length; i++) {
            int grauSaida = 0;
            int grauEntrada = 0;
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > 0) grauSaida++; // Conta a linha
                if (matriz[j][i] > 0) grauEntrada++; // Conta a coluna
            }
            if (direcionado) {
                System.out.println("Vértice " + i + " -> Grau de Saída: " + grauSaida + ", Grau de Entrada: " + grauEntrada);
            } else {
                // Em grafo não-direcionado, grau de entrada = grau de saída, então usamos só um.
                System.out.println("Vértice " + i + " -> Grau: " + grauSaida);
            }
        }
    }

    // d) É conexo ou desconexo?
    public static boolean ehConexo(int[][] matriz) {
        // DICA: Inicie uma travessia (Busca em Largura - BFS ou Busca em Profundidade - DFS) 
        // a partir do vértice 0. Mantenha um array boolean[] visitados.
        // No final da busca, se houver algum vértice 'false' no array, ele é desconexo.
        if (matriz.length == 0) return true;
        
        boolean[] visitados = new boolean[matriz.length];
        Queue<Integer> fila = new LinkedList<>();
        
        // Começamos a busca pelo vértice 0
        fila.add(0);
        visitados[0] = true;
        
        // Busca em Largura (BFS)
        while (!fila.isEmpty()) {
            int atual = fila.poll(); // Tira o primeiro da fila
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[atual][j] > 0 && !visitados[j]) { // Se tem aresta e ainda não visitou
                    visitados[j] = true;
                    fila.add(j); // Coloca o vizinho na fila para visitar os vizinhos dele depois
                }
            }
        }
        
        // Verifica se alguém ficou sem ser visitado
        for (boolean visitado : visitados) {
            if (!visitado) {
                return false; // Se achou um 'false', é desconexo
            }
        }
        return true; // Se todo mundo for 'true', é conexo
    }

    // e) O grafo é cíclico ou acíclico?
    // Código corrigido para ehCiclico
    public static boolean ehCiclico(int[][] matriz, boolean direcionado) {
        boolean[] visitados = new boolean[matriz.length];
        boolean[] pilhaRecursao = new boolean[matriz.length]; // Necessário para grafos direcionados

        for (int i = 0; i < matriz.length; i++) {
            if (!visitados[i]) {
                if (dfsCiclico(matriz, i, visitados, pilhaRecursao, -1, direcionado)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCiclico(int[][] matriz, int vertice, boolean[] visitados, boolean[] pilhaRecursao, int pai, boolean direcionado) {
        visitados[vertice] = true;
        pilhaRecursao[vertice] = true;

        for (int j = 0; j < matriz.length; j++) {
            if (matriz[vertice][j] > 0) { 
                if (!visitados[j]) {
                    if (dfsCiclico(matriz, j, visitados, pilhaRecursao, vertice, direcionado)) {
                        return true;
                    }
                } else if (direcionado) {
                    // Para dígrafos: só é ciclo se o vizinho já visitado estiver na pilha atual
                    if (pilhaRecursao[j]) return true;
                } else {
                    // Para não-direcionados: é ciclo se o vizinho já foi visitado e não é o pai imediato
                    if (j != pai) return true;
                }
            }
        }
        pilhaRecursao[vertice] = false; // Tira da pilha de recursão ao terminar de explorar os vizinhos
        return false;
    }

    // f) Qual é a lista de adjacências do mesmo grafo?
    public static List<List<Integer>> converterParaListaAdjacencia(int[][] matriz) {
        // DICA: Crie uma List<List<Integer>>. Para cada linha 'i', crie uma nova lista.
        // Adicione nela todos os índices 'j' onde matriz[i][j] == 1.
        List<List<Integer>> listaAdjacencia = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            listaAdjacencia.add(new ArrayList<>());
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 0) { // Padronizado para > 0
                    listaAdjacencia.get(i).add(j);
                }
            }
        }
        return listaAdjacencia;
    }
}
