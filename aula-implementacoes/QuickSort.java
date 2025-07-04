public class QuickSort {
    public void sort(int[] v, int ini, int fim){        
        if(ini < fim){
            int pivot = partitionHoare(v, ini, fim);
            sort(v, ini, pivot-1);
            sort(v, pivot+1, fim);
        }
    }

    public static int partitionLomuto(int[] v, int ini, int fim){
        int meio = (ini + fim)/2;
        int pivot = medianaDeTres(v, ini, meio, fim);
        swap(v, pivot, ini);
        int i = ini;
        for (int j = ini + 1; j <= fim; j++){
            if(v[j] <= v[ini]){ 
                swap(v, ++i, j);
            }
        }
        swap(v, ini, i);
        return i;
    }

    public static int partitionHoare(int[] v, int ini, int fim){

        int meio = (ini + fim)/2;
        int indexPivot = medianaDeTres(v, ini, meio, fim);
        swap(v, indexPivot, ini);
        int i = ini + 1;
        int j = fim;

        while(i <= j){
            while(v[i] <= v[ini]) i++;
            while(v[j] >= v[ini]) j--;
            if(i < j) swap(v, i, j);   
        }
        swap(v, ini, j);
        return j;
    }

    public static int medianaDeTres(int[] v, int a, int b, int c){
    
        if((v[a] >= v[b] && v[a] <= v[c]) || (v[a] <= v[b] && v[a] >= v[c])) return a;

        else if ((v[b] >= v[a] && v[b] <= v[c]) || (v[b] <= v[a] && v[b] >= v[c])) return b;

        return c;
    }

    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    
}
