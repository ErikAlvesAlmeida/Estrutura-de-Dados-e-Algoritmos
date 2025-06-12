import java.io.*;

public class Exemplo {

    public static void main(String[] args) {

        // lendo da entrada padrão
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            // Cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
               
                // medindo tempo de execução 
                long start = System.nanoTime();
                indexOf(tokens, "b"); 
                // TODO incluir aqui chamada para o método sob análise        
        
                long end = System.nanoTime();
                long time = end - start;
                
                // saída padrão: método tempo tamanho_da_entrada
                System.out.println("indexOf: " + (time) + " " + tokens.length);

            }
        } catch (IOException ioe) {}

    }


    public static boolean comparaExtremos(String[] tokens) {
        return tokens[0].equals(tokens[tokens.length - 1]);
    }

    public static int indexOf(String[] tokens, String key) {
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals(key)) return i;
        }
        return -1;
    }

}
