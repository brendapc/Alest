import java.util.Random;

class exercicios {
    public static void main(String[] args) {
        exercicios instancia = new exercicios();

        int v[] = { 5, 2, 4, 6, 1, 3 };
        // instancia.geraVetor(100000, 100000)
        /* int[] ordenado = */ instancia.testQuicksort(instancia.geraVetor(100000, 100000), 0, 100000);

        /*
         * for (int i = 0; i < ordenado.length; i++) {
         * System.out.println(ordenado[i]);
         * }
         */

    }

    public int[] geraVetor(int nroElem, int lim) {
        int dummy;
        int[] res = null;
        int cont = 0;
        Random rnd = new Random(System.nanoTime() * System.currentTimeMillis());

        if (nroElem >= 0) {

            res = new int[nroElem];

            while (cont < nroElem) {
                dummy = rnd.nextInt(lim) + 1;
                dummy = rnd.nextInt(lim) + 1;
                res[cont++] = rnd.nextInt(lim) + 1;
            }
        }
        return res;
    }

    private long tempoIni = 0, tempoFim = 0;

    public void initClock() {
        tempoIni = tempoFim = System.nanoTime();
    }

    public double getClockSec() {
        double res;

        tempoFim = System.nanoTime();

        res = ((double) tempoFim - (double) tempoIni) / (double) 1_000_000_000.0;

        return res;
    }

    // Contabilize o número de iterações, de instruções e o tempo de execução para
    // cada um deles.
    // Nós multiplicamos o tamanho do vetor por 100. Em quanto aumentou o tempo de
    // execução?

    // intruções: 14
    public int[] bubbleSortV1(int[] v) {
        int iteracoes = 0;
        initClock();
        for (int i = 0; i < v.length; i++) {
            iteracoes++;
            for (int j = 0; j < v.length - 1; j++) {
                iteracoes++;
                if (v[j] > v[j + 1]) {
                    // troca(v, j, j+1);
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        System.out.println("BubbleSort ");
        System.out.println("tamanho do vetor: " + v.length);
        System.out.println("iteracoes: " + iteracoes);
        System.out.println("tempo: " + getClockSec());
        return v;
    }

    // intruções: 12
    public int[] bubbleSortV2(int[] v) {
        int iteracoes = 0;
        initClock();
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < v.length - 1; i++) {
                iteracoes++;
                if (v[i] > v[i + 1]) {
                    int temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    trocou = true;
                }
            }

        }
        System.out.println("BubbleSort2 ");
        System.out.println("tamanho do vetor: " + v.length);
        System.out.println("iteracoes: " + iteracoes);
        System.out.println("tempo: " + getClockSec());
        return v;
    }

    public int[] insertionSort(int[] v) {
        int iteracoes = 0;
        initClock();

        int i, j, chave;
        for (j = 1; j < v.length; j++) {
            iteracoes++;
            chave = v[j];
            i = j - 1;
            while ((i >= 0) && (v[i] > chave)) {
                v[i + 1] = v[i];
                i = i - 1;
            }
            v[i + 1] = chave;
        }
        System.out.println("InsertionSort ");
        System.out.println("tamanho do vetor: " + v.length);
        System.out.println("iteracoes: " + iteracoes);
        System.out.println("tempo: " + getClockSec());
        return v;
    }

    int iteracoesMerge = 0;

    public int[] mergeSort(int[] v) {
        initClock();
        iteracoesMerge++;

        mergeSort(v, 0, v.length - 1);
        System.out.println("MergeSort ");
        System.out.println("tamanho do vetor: " + v.length);
        System.out.println("iteracoes: " + iteracoesMerge);
        System.out.println("tempo: " + getClockSec());
        return v;
    }

    public int[] mergeSort(int[] v, int inicio, int fim) {
        iteracoesMerge++;
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(v, inicio, meio);
            mergeSort(v, meio + 1, fim);
            merge(v, inicio, meio, fim);
        }
        return v;
    }

    private void merge(int[] v, int inicio, int meio, int fim) {
        int nL = meio - inicio + 1;
        int nR = fim - meio;
        int[] L = new int[nL];
        int[] R = new int[nR];

        System.arraycopy(v, inicio, L, 0, nL);

        System.arraycopy(v, meio + 1, R, 0, nR);

        int iL = 0;
        int iR = 0;
        for (int k = inicio; k <= fim; k++) {
            if (iR < nR) {
                if (iL < nL) {
                    if (L[iL] < R[iR])
                        v[k] = L[iL++];
                    else
                        v[k] = R[iR++];
                } else {
                    v[k] = R[iR++];
                }
            } else {
                v[k] = L[iL++];
            }
        }
    }

    public void testQuicksort(int[] v, int low, int high) {
        exercicios instancia = new exercicios();
        initClock();
        int iteracoesQuick = instancia.quicksort(v, 1, 5);

            
            System.out.println("QuickSort ");
            System.out.println("tamanho do vetor: " + v.length);
            System.out.println("iteracoes: " + iteracoesQuick);
            System.out.println("tempo: " + getClockSec());
    
    }

    int iteracoesQuicksort = 0;
    int quicksort(int[] v, int low, int high) {
        iteracoesQuicksort++;
        int pivot;
        if ((high - low) > 0) {
            iteracoesQuicksort++;
            pivot = partition(v, low, high);
            quicksort(v, low, pivot - 1);
            quicksort(v, pivot + 1, high);
        }

        return iteracoesQuicksort;
    }
    
    int partition(int[] v, int low, int high) {
        iteracoesQuicksort++;
        int i, p, firsthigh;
        firsthigh = low;
        p = high;
        for (i = low; i < high; i++)
        if (v[i] < v[p]) {
            swap(v, i, firsthigh);
            firsthigh = firsthigh + 1;
        }
        swap(v, p, firsthigh);
        return firsthigh;
    }
    
    static void swap(int[] v, int p, int firsthigh) {
        int aux = v[p];
        v[p] = firsthigh;
        firsthigh = aux;
    }
}