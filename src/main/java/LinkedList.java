public class LinkedList {
    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }
    public void add(int x){
        Node newNode = new Node(x);

        if (head == null){
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public  void add(int index, int x){
        checkIndex(index);

        Node newNode = new Node(x);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else{
            Node current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    public void remove(int index){
        checkIndex(index);

        if (index == 0) {
            head = head.next;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    public int get(int index){
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    public boolean contains(int x){
        Node current = head;

        while (current != null){
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private  void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }
    public int getSize(){
        return size;
    }
}
