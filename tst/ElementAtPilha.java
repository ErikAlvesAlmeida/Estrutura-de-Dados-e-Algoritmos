import java.util.Scanner;

class ElementAtPilha {
    
    private String[] pilha;
    private int topo;

    public ElementAtPilha(int capacity){
        this.pilha = new String[capacity];
        this.topo = -1;
    }

    public boolean isFull(){
        return this.pilha.length - 1 == this.topo;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public void push(String value){
        if(isFull()) throw new IllegalArgumentException("pilha cheia");
        this.pilha[++this.topo] = value;
    }

    public String pop(){
        if(isEmpty()) throw new IllegalArgumentException("pilha vazia");
        String retorno = this.pilha[this.topo--];
        return retorno;
    }

    public String peek(){
        if(isEmpty()) throw new IllegalArgumentException("pilha vazia");
        return this.pilha[this.topo];
    }

    private String valueAtIndex(int index){
        if(index < 0 || index > this.pilha.length - 1) return "indice invalido";
        ElementAtPilha ep = new ElementAtPilha(this.size());
        int starterCount = -1;
        while(!this.isEmpty()){
            starterCount++;
            if(index == starterCount) return this.peek();
            ep.push(pop());
        }
        while(!ep.isEmpty()){
            this.push(ep.pop());
        }
        return "indice invalido";
    }

    private int size(){
        return this.topo+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ElementAtPilha ep = new ElementAtPilha(input.length);
        for(int i = input.length - 1; i >= 0; i--){
            ep.push(input[i]);
        }
        int index = sc.nextInt();
        System.out.println(ep.valueAtIndex(index));
    }
}
