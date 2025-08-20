import java.util.Scanner;
public class Rotacoes {
    
    private Node root;
    private int size;
    
    
    
    private int balance(){
        if(this.root == null) return 0;
        return height(this.root.left) - height(this.root.right);
    }

    private int height(Node node){
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    }


}

class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    boolean isLeaf(){
        return left == null && right == null;
    }

    int qtdFilhos(){
        if(left != null && right != null) return 2;
        return 1;
    }
}