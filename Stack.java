import java.util.Scanner;

public class Stack {
    private int[] array;
    private int top;
    private int capacity;

    public Stack(int size){
        this.array = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Stack Overflow!");
            return;
        }
        this.array[++top] = element;
        System.out.println(element + " pushed to stack");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        int poppedElement = this.array[top--];
        System.out.println(poppedElement + " popped from stack");
        return poppedElement;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return this.array[top];
    }

    private boolean isEmpty(){
        return (top == -1);
    }

    private boolean isFull() {
        return (top == capacity - 1);
    }

    private void printstack(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
        }
        else{
            System.out.println("Elements in the stack are:");
            for(int i = top; i>=0; i--){
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the stack:");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an operation:\n1. Push\n2. Pop\n3. Display\n4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to push:");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.printstack();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
        scanner.close();
    }

}
