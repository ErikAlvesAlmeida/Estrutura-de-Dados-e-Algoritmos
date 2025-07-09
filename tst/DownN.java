import java.util.*;
class DownN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        quickSort(v, 0, v.length-1);
        int n = sc.nextInt();
        int[] out = new int[n];
        for(int i = 0; i < out.length; i++){
            out[i] = v[i];
        }

        String output = "";
        for(int i = 0; i < out.length; i++){
            output += out[i]+" ";
        }
        System.out.println(output.trim());
    }

    public static void quickSort(int[] v, int ini, int fim){
        if(ini < fim){
            
            int pivot = partitionHoare(v, ini, fim);
            quickSort(v, ini, pivot-1);
            quickSort(v, pivot+1, fim);
        }
    }

    private static int partitionHoare(int[] v, int ini, int fim) {
        int meio = (ini + fim)/2;
        int pivot = medianaTres(v, ini, meio, fim);
        swap(v, ini, pivot);
        
        int i = ini + 1;
        int j = fim;
        
        while(i <= j){
            while(i <= j && v[i] <= v[ini]) i++;
            while(i <= j && v[j] >= v[ini]) j--;
            if(i < j) swap(v, i, j);
        }
        
        swap(v, ini, j);
        return j;
    }

    public static int medianaTres(int[] v, int a, int b, int c){
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
