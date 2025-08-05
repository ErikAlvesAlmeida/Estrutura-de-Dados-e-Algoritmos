import java.util.Scanner;

class FilaComArray {
    private int[] fila;
    private int tail;
    private int head;
    private int size;

    public FilaComArray(int capacity){
        this.fila = new int[capacity];
        this.tail = -1;
        this.head = -1;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.fila.length;
    }

    public int size(){
        return this.size;
    }

    public String add(int value){
        if(isFull()) return "full";
        if(isEmpty()){
            this.head = 0;
        }
        this.size++;
        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[this.tail] = value;
        return "ok";
    }

    public String element(){
        if(isEmpty()) return "empty";
        return Integer.toString(this.fila[this.head]);
    }

    public String remove(){
        if(isEmpty()) return "empty";
        if(size() == 1){
            this.head = -1;
            this.tail = -1;
            this.size = 0;           
        } 
        else{
            this.head = (this.head + 1) % this.fila.length;
            this.size--;
        }
        return "ok";
    }

    public String printable(){
        if(isEmpty()) return "empty";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size(); i++){
            int index = (head + i) % this.fila.length;
            sb.append(fila[index]);
            if(i < size() - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaComArray fa = new FilaComArray(sc.nextInt());
        String retorno;
        while(true){
            String[] input = sc.nextLine().split(" ");

            switch (input[0]) {
                case "add":
                    retorno = fa.add(Integer.parseInt(input[1]));
                    if (retorno.equals("full")) System.out.println("full");
                    break;
                case "remove":
                    retorno = fa.remove();
                    if(retorno.equals("empty")) System.out.println("empty");
                    break;
                case "element":
                    retorno = fa.element();
                    if(retorno.equals("empty")) System.out.println("empty");
                    else System.out.println(retorno);
                    break;
                case "print":
                    System.out.println(fa.printable());
                    break;
                case "end":
                    return;
            }
        }
    }
}
