public class LinkedList {
    private Node head;

    private static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void insertAfter(Node prevNode, int data){
        if(prevNode == null){
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next =prevNode.next;
        prevNode.next = newNode;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode = head;
        for (int i = 1; i < position - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void deleteNode(int key){
        Node temp = head;
        Node prevNode = null;

        if(temp != null && temp.data == key){
            head = temp.next;
            return;
        }
        while(temp != null && temp.data != key){
            prevNode = temp;
            temp = temp.next;
        }

        if(temp == null){
            return;
        }
        prevNode.next = temp.next;
    }

    public void printList(){
        Node currNode = head;

        System.out.println("Linked List: ");

        while(currNode!=null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(1);
        list.insertAtBeginning(4);
        list.insertAtBeginning(8);
        list.insertAtEnd(6);
        list.insertAfter(list.head.next.next,7);
        list.deleteNode(4);
        list.printList();
    }
}

