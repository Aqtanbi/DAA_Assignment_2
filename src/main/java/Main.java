public class Main {
    public static void main(String[] args) {

        MinHeap heap = new MinHeap();

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(2);
        heap.insert(8);

        System.out.println("Minimum: " + heap.peekMin());

        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");
        }

        System.out.println();
    }
}