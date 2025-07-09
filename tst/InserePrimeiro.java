import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        InserePrimeiro ip = new InserePrimeiro();

        ip.inserePrimeiro(v);
    }

    public void inserePrimeiro(int[] v){
        int i = 0;
        while(v[i] > v[i+1] && i+1 <= v.length-1){
            swap(v, i, i+1);
            i++;
        }
        System.out.println(Arrays.toString(v));
    }

    public void swap(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}