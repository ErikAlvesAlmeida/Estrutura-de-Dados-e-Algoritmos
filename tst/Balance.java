import java.util.Scanner;
public class Balance {
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Balance bst = new Balance();
        String[] input = sc.nextLine().split(" ");

        for(String s : input){
            bst.add(Integer.parseInt(s));
        }
    }
}
