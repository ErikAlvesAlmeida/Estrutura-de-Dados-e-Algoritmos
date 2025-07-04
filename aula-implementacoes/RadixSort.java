public class RadixSort {
    //procura o maior número da última casa da sequência;
    
    public int[] radixSort(int[] v){
        
        int maiorElemento = v[0];
        for(int element : v){
            if(element > maiorElemento) maiorElemento = element;
        }
        int k = 1;
        while(maiorElemento / k > 0){
            v = countingSort(v, k);
            k *= 10;
        }
        return v;
    }

    public int[] countingSort(int[] v, int k){

        int[] c = new int[10];

        int[] b = new int[v.length];

        for(int element : v){
            int digito = (element / k) % 10;
            c[digito]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        
        for(int i = v.length-1; i>=0; i--){
            int digito = (v[i] / k) % 10;
            b[c[digito]-1] = v[i];
            c[digito]--;
        }

        return b;

    }
}
