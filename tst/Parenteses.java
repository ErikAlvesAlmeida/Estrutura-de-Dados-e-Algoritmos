import java.util.Scanner;

class Parenteses {
    
    private char[] pilha;    
    private int topo;

    public Parenteses(int capacity){
        this.pilha = new char[capacity];
        this.topo = 0;
    }
    
    private boolean isEmpty(){
        return this.topo == 0;
    }

    private boolean isFull(){
        return this.pilha.length == this.topo;
    }

    public String push(char value){
        if(isFull()) throw new IllegalArgumentException("pilha cheia");
        if(value == '(') this.pilha[this.topo++] = value;
        else if(value == ')') {
            if(isEmpty()) return "N";
            this.topo--;
        }
        return "OK";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        Parenteses parenteses = new Parenteses(palavra.length());
        String retorno = "";
        for(char p : palavra.toCharArray()){
            if(parenteses.push(p).equals("N")) {
                retorno = "N";
                break;
            }
        }
        if(retorno.equals("") && parenteses.isEmpty()) System.out.println("S");
        else{
            System.out.println("N");
        }
    }    
}
