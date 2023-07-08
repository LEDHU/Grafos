import java.util.LinkedList;

public class DFS {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;

    private LinkedList< LinkedList<Integer> > grafo;

    public DFS(LinkedList<LinkedList<Integer>> grafo) {
        this.grafo = grafo;
        int n = grafo.size();
        this.ante = new int[n];
        this.i = new int[n];
        this.f = new int[n];
        this.cor = new int[n];
        this.tempo = 0;

        int k = 0;

        while(k < n){
            cor[k] = BRANCO;
            ante[k] = -1;
            k++;
        }
        f[0] = -2;
    }

    public void dfs_start(int s) {
        if (s != 0) tempo--;
        dfs_visit(s);
    }

    public void dfs_visit(int u) {
        cor[u] = CINZA;
        tempo++;
        i[u] = tempo;

        for (int v : grafo.get(u)) {
            if (cor[v] == BRANCO) {
                ante[v] = u;
                dfs_visit(v);
            }
        }

        cor[u] = PRETO;
        tempo++;
        if (u != 0) f[u] = tempo;
    }
}