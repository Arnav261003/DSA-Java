import java.util.Scanner;
public class Queue {
    private static int[] arr;
    private static int front;
    private int rear;
    private static int size;
    private static int capacity;

    public Queue(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full, can't enqueue "+data);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
        System.out.println(data+ "has been enqueued.");
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty, can't dequeue.");
            return;
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println((data+ "has been dequeued"));
    }

    public static boolean isFull() {
        return (size == capacity);
    }

    public static boolean isEmpty() {
        return (size == 0);
    }

    public static void printQueue(){
        if(isEmpty()){
            System.out.println(("Queue is empty."));
            return;
        }
        System.out.println("Queue elements are:");
        for(int i = 0; i < size; i++){
            System.out.println(arr[(front+i)%capacity]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Print Queue");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be enqueued: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.printQueue();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
