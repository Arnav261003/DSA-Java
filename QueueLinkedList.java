import java.util.Scanner;
class Node2{
    int data;
    Node2 next;

    public Node2(int data){
        this.data = data;
        this.next = null;
    }
}

class QueueLL {
    Node2 front, rear;

    public QueueLL(){
        front = rear = null;
    }

    public void enqueue(int data){
        Node2 newNode = new Node2(data);

        if(rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue(){
        if(front == null)
            return;
        Node2 temp = front;
        front = front.next;

        if(front == null)
            rear = null;
    }

    public void display(){
        if(front == null){
            System.out.println("Queue is Empty");
            return;
        }
        Node2 temp = front;
        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class QueueLinkedList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLL queue = new QueueLL();

        while(true){
            System.out.println("\nEnter choice:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("\nEnter data to enqueue:");
                    int data = sc.nextInt();

                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("\nCurrent Queue:");
                    queue.display();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        }
    }
}

