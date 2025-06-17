package ordenacao;

public class SelectionSort implements SortingStrategy {

    /**
     * Ordena um array de inteiros utilizando o selection sort
     */
    public void sort(int[] v){
        for(int i = 0; i < v.length; i++){
            int iMenor = i;
            for(int j = i + 1; j < v.length; j++){
                if(v[j] < iMenor) iMenor = j;
            }
            swap(v, i, iMenor);
        }
    }

    /**
     * SelectionSort recursivo
     */
    public void sortRecursivo(int[] v){
        selectionSortRecur(v, 0);
    }

    public static void selectionSortRecur(int[] v, int inicio){
        int n = v.length - 1;

        if(inicio >= n) return;

        int menor = menorIndice(v, inicio, n);

        if(menor != inicio) swap(v, inicio, menor);

        selectionSortRecur(v, inicio + 1);
    }

    /**
     * encontra o menor valor do array de maneira recursiva
     */
    public static void menorIndice(int[] v, int inicio, int fim){
        if(inicio == fim) return inicio;

        int restante = menorIndice(v, inicio + 1, fim);

        return (v[inicio] < v[restante]) ? inicio : restante;
    }

    /**
     * Faz o swap dos valores in-place
     */
    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}