import java.util.Scanner;

public class ex2 {

    // Adjacency Matrix representation in Java

    public static class Graph {
        public int adjMatrix[][];
        public int numVertices;

        // Initialize the matrix
        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new int[numVertices][numVertices];
        }





        public static void DFS(Graph g, int a, int[] visited) {
            visited[a] = 1;
            for (int i = 0; i < g.numVertices; i++)
                if (g.adjMatrix[a][i] == 1 && visited[i] == 0) {
                    DFS(g, i, visited);
                }
        }

        public static void random_tree(int[][] adjMatrix,int numVertices, int a, int[] visited, int level) {
            visited[a] = 1;
            for (int i = 0; i < numVertices; i++)
                if (adjMatrix[a][i] == 1 && visited[i] == 0) {
                    for (int j = 0; j < level; j++) {
                        System.out.printf("   ");
                    }
                    level++;
                    System.out.println("node" + i);
                    random_tree(adjMatrix,numVertices, i, visited,level);
                    level--;
                }
        }

        public static void Partial_tree(Graph g, int a, int[] visited, int[][] matrix) {
            visited[a] = 1;
            for (int i = 0; i < g.numVertices; i++)
                if (g.adjMatrix[a][i] == 1 && visited[i] == 0) {
                    matrix[a][i] = matrix[i][a] = 1;
                    Partial_tree(g, i, visited, matrix);

                }
        }

        public static void Print_Matrix(int[][] matrix, int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int aux, v;
            Scanner keyboard = new Scanner(System.in);
            v = keyboard.nextInt();
            Graph g = new Graph(v);
            int[][] matrix = new int[g.numVertices][g.numVertices];
            for (int i = 0; i < g.numVertices; i++) {
                for (int j = i + 1; j < g.numVertices; j++) {
                    aux = (int) (Math.random() * 10);
                    if (aux > 5) {
                        g.adjMatrix[i][j] = 1;
                        g.adjMatrix[j][i] = 1;
                    } else {
                        g.adjMatrix[i][j] = 0;
                        g.adjMatrix[j][i] = 0;
                    }
                }
            }
            System.out.println("Matricea grafului:");
            Print_Matrix(g.adjMatrix, g.numVertices);
            System.out.println();
            int nr_comp = 0;
            int[] visited = new int[g.numVertices];
            for (int i = 0; i < g.numVertices; i++)
                if (visited[i] == 0) {
                    DFS(g, i, visited);
                    nr_comp++;
                }
            System.out.println(nr_comp);
            if (nr_comp != 1) {
                System.out.println("Nu este conex");
            } else {
                for (int i = 0; i < g.numVertices; i++)
                    visited[i] = 0;
                Partial_tree(g, 0, visited, matrix);
                Print_Matrix(matrix, g.numVertices);
                int root = g.numVertices / 2;
                for (int i = 0; i < g.numVertices; i++)
                    visited[i] = 0;
                System.out.println("node"+ root);
                int level=1;
                random_tree(matrix,g.numVertices,root,visited,level);
            }
            keyboard.close();
        }
    }
}
