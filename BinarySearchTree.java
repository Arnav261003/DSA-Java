import java.util.Scanner;

class Node{
    int data;
    Node left, right;

    public Node(int item){
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree{
    Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int data){
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRec(root.left, data);
        }
        else if(data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void delete(int data){
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if(root == null){
            return root;
        }
        if(data < root.data){
            root.left = deleteRec(root.left, data);
        }
        else if(data > root.data){
            root.right = deleteRec(root.right, data);
        }

        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }
     public int minValue(Node root){
        int minv = root.data;
        while(root.left != null){
            minv = root.left.data;
            root = root.left;
        }
        return minv;
     }

    public void inorder(){
        inorderRec(root);
    }

//    public void inorder(Node root){
//
//        inorder(root);
//    }

    public void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        while (true) {
            System.out.println("\nBinary Search Tree Operations");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the value you want to insert:");
                    int value = scanner.nextInt();
                    tree.insert(value);
                    System.out.println((value + " inserted successfully"));
                    break;

                case 2:
                    System.out.println("Enter the value you want to delete: ");
                    int deleteValue = scanner.nextInt();
                    tree.delete(deleteValue);
                    System.out.println((deleteValue + " deleted successfully"));
                    break;

                case 3:
                    System.out.println("Inorder Traversal: ");
                    tree.inorder();
                    System.out.println();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invaid choice. Please try again.");
            }
        }
    }
}
