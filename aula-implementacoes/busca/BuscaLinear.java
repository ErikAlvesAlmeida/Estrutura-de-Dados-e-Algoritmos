package busca;
public class BuscaLinear {
    public int buscaLinear(int[] v, int element){
        for(int i = 0; i < v.length; i++){
            if(v[i] == element) return i;
        }
        return -1;
    }
}
