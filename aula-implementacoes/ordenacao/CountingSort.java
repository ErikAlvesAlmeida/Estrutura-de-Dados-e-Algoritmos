package ordenacao;
public class CountingSort {
    public int[] classicCountingSort(int[] v, int k){
        int[] c = new int[k];
        
        for(int element : v){
            c[element-1]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for(int i = v.length-1; i>=0; i--){
            b[c[v[i]-1]-1] = v[i];
            c[v[i]-1]--;
        }

        return b;
    }

    public int[] zeroIncluso(int[] v, int k){
        int[] c = new int[k+1];
        int[] b = new int[v.length];
        for(int element : v){
            c[element]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        
        for(int i = v.length-1; i>=0; i--){
            b[c[v[i]]-1] = v[i];
            c[v[i]]--;
        }

        return b;

    }

    public int[] negativoIncluso(int[] v){
        int min = v[0], max = v[0];
        for (int n : v) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        int offset = -min;
        int[] c = new int[max - min + 1];

        for(int element : v){
            c[element + offset]++;
        }

        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for(int i = v.length-1; i>=0; i--){
            b[c[v[i] + offset]-1] = v[i];
            c[v[i] + offset]--;
        }

        return b;
    }
}
