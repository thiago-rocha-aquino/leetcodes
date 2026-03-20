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
                if (matriz[i][j] > 0) {
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

    // c) É conexo ou desconexo?
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
    public static boolean ehCiclico(int[][] matriz, boolean direcionado) {
        // DICA: Faça uma busca DFS. 
        // - Se não for direcionado: Se visitar um nó que já foi visitado e ele NÃO é o "pai" atual, tem ciclo.
        // - Se for direcionado: Precisa manter controle se o nó está na pilha de recursão atual (visitando).
        for (int i = 0; i < matriz.length; i++) {
            boolean[] visitados = new boolean[matriz.length];
            if (dfsCiclico(matriz, i, visitados, -1, direcionado)) {
                return true; // Encontrou um ciclo
            }
        }
        return false; // Não encontrou um ciclo
    
    }

    private static boolean dfsCiclico(int[][] matriz, int vertice, boolean[] visitados, int pai, boolean direcionado) {
        visitados[vertice] = true;
        for (int j = 0; j < matriz.length; j++) {
            if (matriz[vertice][j] > 0) { // Existe uma aresta (padronizado para > 0)
                if (!visitados[j]) {
                    if (dfsCiclico(matriz, j, visitados, vertice, direcionado)) {
                        return true; // Encontrou um ciclo na recursão
                    }
                } else if (direcionado || j != pai) {
                    return true; // Encontrou um ciclo
                }
            }
        }
        return false; // Não encontrou um ciclo
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
