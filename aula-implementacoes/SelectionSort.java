public class SelectionSort {
    
    public void sort(int[] v){
        int fim = v.length - 1;
        int ini = 0;
        while(ini < fim){
            int menor = menor(v, ini);
            swap(v, ini++, menor);
        }
    }   

    public static int menor(int[] v, int i){
    int indiceMenor = i;
    for (int j = i + 1; j < v.length; j++) {
        if (v[j] < v[indiceMenor]) {
            indiceMenor = j;
        }
    }
    return indiceMenor;
    }

    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}

