import java.util.EmptyStackException;

public class LinkedListStack{
    private Node top;

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return top == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // prints 3
        System.out.println(stack.pop()); // prints 2
        System.out.println(stack.peek()); // prints 1
        System.out.println(stack.pop()); // prints 1
    }

}
