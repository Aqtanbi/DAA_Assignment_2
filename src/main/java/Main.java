public class Main {
    public static void main() {
        DynamicArray arr = new DynamicArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(0, 5);
        for (int i = 0; i < arr.getSize(); i++){
            System.out.print(arr.get(i));
        }
        System.out.println();
        if (arr.contains(3)) {
            System.out.println("Yes it contains");
        }
        arr.remove(0);
        System.out.println("array with removed first element:");
        for (int i = 0; i < arr.getSize(); i++){
            System.out.print(arr.get(i));
        }
    }
}
