import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
    
    private int[] arr;
    private int size;
    private int tail;
    private int head;

    public FuraFila(int capacity){
        this.arr = new int[capacity];
        this.size = 0;
        this.tail = -1;
        this.head = -1;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.arr.length;
    }

    public void addLast(int value){
        if(isFull()) throw new IllegalArgumentException();
        if(isEmpty()){
            this.head = 0;
        }
        this.size++;
        this.tail = (this.tail + 1) % this.arr.length;
        this.arr[this.tail] = value;
    }

    public int removeFirst(){
        if(isEmpty()) throw new IllegalArgumentException();
        int removed = this.arr[this.head];
        if(size() == 1){
            this.head = -1;
            this.tail = -1;
            this.size = 0;
        }
        this.size--;
        this.head = (this.head + 1) % this.arr.length;
        return removed;
    }

    public int size(){
        return this.size;
    }

    private void teste(int index){
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        else if(index == 0) System.out.println(Arrays.toString(this.arr));
        else{
            int countAux = index;
            
        }
    }

    public void furarFila(int index){
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        else if(index == 0) System.out.println(Arrays.toString(this.arr));
        else {
            int count = this.arr.length - index;
            this.head = index;
            while(count > 0){
                addLast(removeFirst());
                System.out.println(Arrays.toString(this.arr));
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        FuraFila ff = new FuraFila(input.length);
        for(String s : input){
            ff.addLast(Integer.parseInt(s));
        }
        int index = sc.nextInt();
        ff.furarFila(index);
    }
}
