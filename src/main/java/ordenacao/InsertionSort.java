package ordenacao;

public class InsertionSort implements SortingStrategy{

    public void sort(int[] v){
        for(int i = 1; i < v.length; i++){
            int j = i;
            while(j > 0 && v[j] < v[j-1]){
                swap(v, j, j-1);
                j--;
            }
        }
    }

    public void sortRecursivo(int[] v){
        sortRecursivoAux(int[] v, v.length);
    }
    
    public static void sortRecursivoAux(int[] v, int n){
        if(n <= 1) return;
        sortRecursivoAux(v, n-1);
        insereOrdenado(v, n-1);
    }

    public static void insereOrdenado(int[] v, int i){
        while(j > 0 && v[i] < v[i-1]){
            swap(v, i, i-1);
            i--;
        }
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