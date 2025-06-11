import java.io.*;
import java.util.*;
public class Duplicadas {
    
    public static void main(String[] args) {
        
        //lendo entrada padrão
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            //Cabecalho
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                //medindo tempo de execução
                long start = System.nanoTime();
                for(int i = 0; i<30; i++){
                    duplicadasSet(tokens);
                }
                //aqui fica o teste;
                long end = System.nanoTime();
                long time = end - start;

                //saída padrão: método tempo tamanho da entrada;
                System.out.println("DuplicadasSet: "+ (time/30) + " " + tokens.length);
            }
        }
        catch (IOException ioe) {}
    }

    public static boolean duplicatasForFor(String[] tokens){
        for(int i = 0; i < tokens.length; i++){
            for(int j = i+1; j < tokens.length; j++) {
                if(tokens[i].equals(tokens[j])) return true;
            }
        }
        return false;
    } 

    public static boolean duplicadasSet(String[] tokens){
        HashSet<String> set = new HashSet<>();
        for(String token : tokens){
            if(set.contains(token)) return true;
            set.add(token);
        }
        return false;
    }
}
