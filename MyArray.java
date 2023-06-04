public class MyArray {
    private int[] array;
    private int size;
    private int capacity;

    public MyArray(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        size = 0;
    }

    public void insert(int index, int value){
        if(size >= capacity){
            System.out.println("Array is Full. Cannot insert.");
            return;
        }
        if(index < 0 || index > size){
            System.out.println("Invalid index. Cannot insert.");
            return;
        }
        for(int i = size - 1; i >= index; i++){
            array[i+1] = array[i];
        }
        array[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Cannot delete.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
