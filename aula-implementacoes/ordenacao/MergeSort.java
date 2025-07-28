package ordenacao;
public class MergeSort {
    
    public void sort(int[] v, int ini, int fim){
        if(ini < fim){
            int mid = (ini + fim) / 2;
            sort(v, ini, mid);
            sort(v, mid + 1, fim);
            merge(v, ini, mid, fim);    
        }
    }

    public static void merge(int[] v, int ini, int mid, int fim){
        int[] aux = new int[v.length];
        for(int i = ini; i <= fim; i++){
            aux[i] = v[i];
        }

        int i = ini;
        int j = mid + 1;
        int k = ini;
        
        while (i <= mid && j <= fim){
            if (aux[i] <= aux[j]) {
                v[k++] = aux[i++];
            } else {
                v[k++] = aux[j++];
            } 
        }
        while (i <= mid){
            v[k++] = aux[i++];
        }
    }

    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
