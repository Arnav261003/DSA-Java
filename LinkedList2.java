import java.sql.SQLOutput;

public class LinkedList2 {
    private Node head;

    private static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }
    public void insert(int data, int position){
        Node newNode = new Node(data);

        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        for(int i = 1; i<position-1 && currNode != null; i++){
            currNode = currNode.next;
        }

        if(currNode == null){
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

    public void delete(int position){
        if(head == null){
            return;
        }
        Node temp = head;

        if(position == 0){
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++){
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            return;
        }

        temp.next = temp.next.next;
    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node findMiddle(){
        if(head == null){
            return null;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node findNthFromEnd(int n){
        if(head == null){
            return null;
        }

        Node first = head;
        Node second = head;

        for(int i = 0; i < n; i++){
            if(second == null){
                return null;
            }
            second = second.next;
        }
        while(second != null){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public void printList(){
        Node currNode = head;
        System.out.println("Linked List:");

        while(currNode != null){
            System.out.println(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.insert(1, 1); // insert at beginning
        list.insert(2, 2); // insert at position
        list.insert(3, 3); // insert at position
        list.insert(4, 4); // insert at end
//        list.insert(5, 2); // insert after a given node
        list.insert(6,5);
        list.insert(90,8);
        list.insert(17,7);
        list.insert(45,6);
        list.insert(8,9);
        System.out.println("Linked List after inserting elements:");
        list.printList();
    }

}
