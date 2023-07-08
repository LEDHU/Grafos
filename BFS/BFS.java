import java.util.LinkedList;
import java.util.Queue; 

public class BFS {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] cor;
    public int[] distancia;
    public int[] ante;

    private LinkedList<LinkedList<Integer>> grafo;

    public BFS(LinkedList<LinkedList<Integer>> grafo) {
        this.grafo = grafo;
        int n = grafo.size();
        this.ante = new int[n];
        this.distancia = new int[n];
        this.cor = new int[n];
        int k = 0;

        while(k < n){
            cor[k] = BRANCO;
            ante[k] = -1;
            distancia[k] = Integer.MAX_VALUE;
            k++;
        }
    }

    public void BFS(int s){
        cor[s] = CINZA;
        distancia[s] = 0;
        bfs_visit(s);
    }

    public void bfs_visit(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        

        while (!queue.isEmpty()) {
            //se a fila nao estive vazia passa head ou null e nao de erro
            int u = queue.poll();

            for (int v : grafo.get(u)) {
                //se a cor for branca passa a ser vizitada(cinza) e passa para o seu vizinho
                if (cor[v] == BRANCO) {
                    cor[v] = CINZA;
                    distancia[v] = distancia[u] + 1;
                    ante[v] = u;
                    queue.add(v);
                }
            }
            //vizitado
            cor[u] = PRETO;
        }
    }
}