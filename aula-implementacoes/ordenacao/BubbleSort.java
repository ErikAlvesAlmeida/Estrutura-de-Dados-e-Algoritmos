package ordenacao;
public class BubbleSort {
    
    public void sort(int[] v){
        bubble(v, v.length-1);
    }

    public static void bubble(int[] v, int fim){
        if(fim == 0) return;

        for(int i = 0; i < fim; i++){
            if(v[i] > v[i+1]){
                swap(v, i, i+1);
            }
        }

        bubble(v, fim-1);
    }

    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
