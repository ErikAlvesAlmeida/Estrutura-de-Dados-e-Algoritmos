import java.util.*;

class MoveN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        sc.close();
        int indiceQuebra = 0;
        for(int i = 0; i < v.length-1; i++){
            if(v[i+1] < v[i]) indiceQuebra = i+1;
            break;
        }
        while(indiceQuebra <= v.length-1){
            insereOrdenado(v, indiceQuebra++);
        }
    }

    public static void insereOrdenado(int[] v, int fim){
        while (fim > 0 && v[fim] < v[fim - 1]) {
            swap(v, fim, fim-1);
            System.out.println(Arrays.toString(v));
            fim--;
        }
    }

    public static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
