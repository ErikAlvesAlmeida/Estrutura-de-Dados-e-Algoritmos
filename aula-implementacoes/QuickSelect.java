public class QuickSelect {
    //Busca o k-ésimo menor elemento de um array sem precisar ordená-lo.
    //Para buscar k-ésimo MAIOR elemento, basta 
    public static int quickSelect(int[] v, int k){
        return quickSelect(v, 0, v.length-1, k-1);
    }
    
    private static int quickSelect(int[] v, int ini, int fim, int k){
        
        if(ini == fim) return v[ini];
        int indexPivot = partitionHoare(v, ini, fim);
        
        if(k == indexPivot) return v[k];

        else if(k < indexPivot){
            return quickSelect(v, ini, indexPivot -1, k);
        } else {
            return quickSelect(v, indexPivot+1, fim, k);
        }
    }

    private static int partitionHoare(int[] v, int ini, int fim){

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

    private static int medianaDeTres(int[] v, int a, int b, int c){
    
        if((v[a] >= v[b] && v[a] <= v[c]) || (v[a] <= v[b] && v[a] >= v[c])) return a;

        else if ((v[b] >= v[a] && v[b] <= v[c]) || (v[b] <= v[a] && v[b] >= v[c])) return b;

        return c;
    }

    private static void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
