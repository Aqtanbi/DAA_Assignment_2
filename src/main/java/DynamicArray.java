public class DynamicArray {
    private int[] data;
    private int size;
    private int capacity;

    public DynamicArray() {
        capacity = 10;
        data = new int[capacity];
        size = 0;
    }

    public  void add(int x){
        if (size == capacity) {
            resize();
        }
        data[size] = x;
        size++;
    }

    public  void add(int index, int x){
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException("Invalid value of index!");
        }
        if (size == capacity) {
            resize();
        }
        for (int i = size; i > index; i--){
            data[i]=data[i-1];
        }
        data[index] = x;
        size++;
    }
    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
    }
    public int get(int index){
        checkIndex(index);
        return data[index];
    }
    public boolean contains(int x){
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                return true;
            }
        }
        return false;
    }
    private void resize(){
        capacity = capacity * 2;
        int[] newdata = new int[capacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index!!!");
        }
    }
    public int getSize() {
        return size;
    }
}
