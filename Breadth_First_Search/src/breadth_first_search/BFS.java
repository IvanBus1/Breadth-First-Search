/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breadth_first_search;

/**
 *
 * @author danie
 */
import java.util.*;

class BFS {
    private List<List<Integer>> adjList; 

    public BFS(int numNodes) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>()); 
        }
    }

    // Agregar una arista al grafo
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    // Búsqueda en amplitud (BFS)
    public void bfs(int startNode) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        System.out.println("Iniciando BFS desde el nodo: " + startNode);
        System.out.println("Nodos visitados inicialmente: " + Arrays.toString(visited));
        System.out.println("Cola inicial: " + queue);
        System.out.println("---------");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Visitando nodo: " + node);

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    System.out.println("Nodo " + neighbor + " no ha sido visitado. Se añade a la cola.");
                    visited[neighbor] = true;
                    queue.add(neighbor);
                } else {
                    System.out.println("Nodo " + neighbor + " ya ha sido visitado.");
                }
            }

            System.out.println("Estado de la cola: " + queue);
            System.out.println("Nodos visitados: " + Arrays.toString(visited));
            System.out.println("---------");
        }

        System.out.println("BFS completado.");
    }

    public static void main(String[] args) {
        int numNodes = 9; 
        BFS graph = new BFS(numNodes);

        // Agregar aristas al grafo
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(1, 5); 
        graph.addEdge(2, 6); 
        graph.addEdge(5, 7); 
        graph.addEdge(6, 8); 
        
        

        int startNode = 0;
        System.out.println("Búsqueda en amplitud a partir del nodo " + startNode + ":");
        graph.bfs(startNode); 
    }
}



