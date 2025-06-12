import java.io.*;
import java.util.*;
public class AlgBusca {
    
    public static void main(String[] args) {
        
        //lendo entrada padrão
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            //Cabecalho
            //System.out.println("alg time busca");
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                //medindo tempo de execução
                long start = System.nanoTime();
                for(int i = 0; i<30; i++){
                    buscaBinaria(tokens, "1", 0, tokens.length - 1);
                }
                //aqui fica o teste;
                long end = System.nanoTime();
                long time = end - start;

                //saída padrão: método tempo tamanho da entrada;
                System.out.println("BuscaBinaria: "+ (time/30) + " " + tokens.length);
            }
        }
        catch (IOException ioe) {}
    }

    public static int buscaLinear(String[] v, String k, int i){
        
        if(i == v.length) return -1;

        if(v[i].equals(k)) return i;

        return buscaLinear(v, k, i+1);
    }

    public static int buscaBinaria(String[] v, String k, int i, int f){
        
        if(i > f) return -1;

        int mid = (f + i)/2;
            
        if(k.equals(v[mid])) return mid;

        if(k.compareTo(v[mid]) < 0) {
            int newF = mid - 1;
            return buscaBinaria(v, k, i, newF);
        } else {
            int newI = mid + 1;
            return buscaBinaria(v, k, newI, f);
        }
    }
}
