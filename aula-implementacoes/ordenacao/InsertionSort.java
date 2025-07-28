package ordenacao;
public class InsertionSort {
    public void sort(int[] v){
        for(int i = 1; i < v.length; i++){
            insereOrdenado(v, i);
        }
    }
    
    public static void insereOrdenado(int[] v, int fim) {
        // Implementação do método de inserção ordenada
        // Este método deve inserir um elemento em uma posição ordenada dentro de um array
        int k = fim;
        while(k > 0 && v[k] < v[k-1]){
            swap(v, k, k-1);
            k--;
        }
    }


    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
