import java.util.LinkedList;
import java.util.Queue;

public class BFSs{
    private LinkedList<LinkedList<Integer>> grafo;
    public boolean tem;
    private int[] cor;
    public int[] distancia;
    public int[] ante;

    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public BFSs(LinkedList<LinkedList<Integer>> grafo, int raiz, int targetSum) {
        this.grafo = grafo;
        this.tem = false;
        this.cor = new int[grafo.size()];
        int n = grafo.size();
        this.ante = new int[n];
        this.distancia = new int[n];
        int k = 0;

        while(k < n){
            cor[k] = BRANCO;
            ante[k] = -1;
            distancia[k] = Integer.MAX_VALUE;
            k++;
        }

        bfs(raiz, targetSum);
    }

    private void bfs(int num, int targetSum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{num, 0});

        while (!queue.isEmpty()) {
            int[] vet = queue.poll();
            int raiz = vet[0];
            int somaRaiz = vet[1] + raiz;

            cor[raiz] = CINZA;

            LinkedList<Integer> vizinhos = grafo.get(raiz);

            if (vizinhos.isEmpty()) {
                if (somaRaiz == targetSum) {
                    tem = true;
                    return;
                }
            } else {
                for (int vizinho : vizinhos) {
                    if (cor[vizinho] == BRANCO) {
                        queue.add(new int[]{vizinho, somaRaiz});
                    }
                }
            }

            cor[raiz] = PRETO;
        }
    }

    public void solucionar() {
        //ainda sem nada
    }
}