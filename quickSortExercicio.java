import java.util.Random;

public class quickSortExercicio {
    private static long iteracoes = 0;
    private long instrucoes = 0;

    public long getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(long instrucoes) {
        this.instrucoes = instrucoes;
    }

    public static long getIteracoes() {
        return iteracoes;
    }

    public void setIteracoes(long iteracoes) {
        this.iteracoes = iteracoes;
    }

    public void incrIteracoes(long incr) {
        setIteracoes(getIteracoes() + incr);
    }

    public void incrInstrucoes(long instr) {
        setInstrucoes(getInstrucoes() + instr);
    }

    private static long tempoIni = 0;
    private static long tempoFim = 0;

    public static void initClock() {
        tempoIni = tempoFim = System.nanoTime();
    }

    public static double getClockSec() {
        double res;

        tempoFim = System.nanoTime();

        res = ((double) tempoFim - (double) tempoIni) / (double) 1_000_000_000.0;

        return res;
    }

    public void resetCounters() {
        setIteracoes(0);
        setInstrucoes(0);
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

    public static void main(String[] args) {
        quickSortExercicio instancia = new quickSortExercicio();
        initClock();

        instancia.quickSort(instancia.geraVetor(100000, 100000), 0, 10000);
        System.out.println("Quicksort ");
        System.out.println("tamanho do vetor: " + 100000);
        System.out.println("iteracoes: " + getIteracoes());
        System.out.println("tempo: " + getClockSec());
    }

    public void quickSort(int[] v, int left, int right) {
        incrIteracoes(1);
        incrInstrucoes(1);

        if (right > left) {
            incrInstrucoes(7);

            int pivotIndex = left;
            int pivotNewIndex = partition(v, left, right, pivotIndex);
            quickSort(v, left, pivotNewIndex - 1);
            quickSort(v, pivotNewIndex + 1, right);
        }
    }

    private int partition(int[] array, int left, int right, int pivotIndex) {
        int aux;

        int pivotValue = array[pivotIndex];

        aux = array[pivotIndex];
        array[pivotIndex] = array[right];
        array[right] = aux;

        int storeIndex = left;
        incrInstrucoes(11);

        for (int i = left; i <= right - 1; i++) {
            incrIteracoes(1);
            incrInstrucoes(5);

            if (array[i] < pivotValue) {
                incrInstrucoes(9);

                aux = array[storeIndex];
                array[storeIndex] = array[i];
                array[i] = aux;

                storeIndex = storeIndex + 1;
            }
        }

        aux = array[right];
        array[right] = array[storeIndex];
        array[storeIndex] = aux;
        incrInstrucoes(8);

        return storeIndex;
    }
}
