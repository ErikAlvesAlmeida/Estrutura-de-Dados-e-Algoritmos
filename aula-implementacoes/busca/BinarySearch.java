package busca;
public class BinarySearch {
    public static int search(int[] v, int element, int ini, int fim){

        if(ini > fim) return -1;

        int mid = (ini + fim) / 2;

        if(v[mid] == element) return mid;

        if(element < v[mid]) return search(v, element, ini, mid - 1);

        else return search(v, element, mid + 1, fim);

    }
}
