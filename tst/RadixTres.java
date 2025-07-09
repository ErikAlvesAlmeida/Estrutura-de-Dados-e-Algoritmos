import java.util.Arrays;
import java.util.Scanner;

public class RadixTres {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        sc.close();

        RadixTres rt = new RadixTres();
        rt.RadixTresSort(v);
        
    }

    public void RadixTresSort(int[] v){

        //vai achar o maior elemento:
        int maiorElemento = v[0];
        for(int element : v){
            if(element > maiorElemento) maiorElemento = element;
        }

        int k = 1;
        while (maiorElemento / k > 0) {
            v = countingSort(v, k);
            k *= 1000;
            System.out.println(Arrays.toString(v));
        }
    } 

    public int[] countingSort(int[] v, int k) {
        // tamanho 10 porque é o tamanho dos digitos 0-9;
        int [] c = new int[1000];
        // vai pegar o último digito de cada número e adicionar na contagem do array +1 o digito encontrado;
        for(int element : v){
            int digito = (element / k) % 1000;
            c[digito]++;
        }
        // vai contar quantos elementos existem antes do próximo elemento;
        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }
        // cria um array novo que vai colocar na posição o array JÁ ordenado pelo digito passado;
        int[] b = new int[v.length];
        for(int i = v.length-1; i>=0; i--){
            int digito = (v[i] / k) % 1000;
            b[c[digito] - 1] = v[i];
            c[digito]--;
        }

        return b;
    }

}
