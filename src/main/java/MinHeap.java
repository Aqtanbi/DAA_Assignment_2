public class MinHeap {
    private int[] data;
    private  int size;
    private int capacity;

    public MinHeap(){
        capacity = 10;
        data = new int[capacity];
        size = 0;
    }
    public void insert(int x){
        if (size == capacity) {
            resize();
        }
        data[size] = x;
        size++;
        shiftup(size-1);
    }
    public int peekMin(){
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        return data[0];
    }
    public int extractMin(){
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        int min = data[0];
        data[0] = data[size-1];
        size--;

        if (size > 0) {
            shiftdown(0);
        }
        return min;
    }
    private void shiftup(int index){
        while (index > 0){
            int parent = (index - 1) / 2;
            if (data[index] >= data[parent]) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }
    private void shiftdown(int index){
        while (true){
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < size && data[left] < data[smallest]) {
                smallest = left;
            }
            if (right < size && data[right] < data[smallest]) {
                smallest = right;
            }
            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }
    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    private void resize() {
        capacity = capacity * 2;
        int[] newData = new int[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
