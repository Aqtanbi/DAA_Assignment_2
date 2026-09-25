public class Tests {

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("FAILED: " + message);
        }
        System.out.println("PASSED: " + message);
    }

    private static void checkThrows(Runnable action, String message) {
        try {
            action.run();
            throw new AssertionError("FAILED: " + message + " (exception was not thrown)");
        } catch (IndexOutOfBoundsException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("PASSED: " + message);
        }
    }

    private static void checkArray(DynamicArray arr, int... expected) {
        check(arr.getSize() == expected.length,"DynamicArray size");

        for (int i = 0; i < expected.length; i++) {
            check(arr.get(i) == expected[i],"DynamicArray element at index " + i);
        }
    }

    private static void checkList(LinkedList list, int... expected) {
        check(list.getSize() == expected.length,"LinkedList size");

        for (int i = 0; i < expected.length; i++) {
            check(list.get(i) == expected[i],"LinkedList element at index " + i);
        }
    }

    public static void testDynamicArray() {
        System.out.println("\n--- DynamicArray tests ---");

        DynamicArray arr = new DynamicArray();

        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(5);

        checkArray(arr, 1, 3, 2, 4, 5);

        arr.add(2, 10);
        checkArray(arr, 1, 3, 10, 2, 4, 5);

        arr.add(arr.getSize() - 1, 10);
        checkArray(arr, 1, 3, 10, 2, 4, 10, 5);

        arr.remove(0);
        checkArray(arr, 3, 10, 2, 4, 10, 5);

        arr.remove(arr.getSize() / 2);
        checkArray(arr, 3, 10, 2, 10, 5);

        arr.remove(arr.getSize() - 1);
        checkArray(arr, 3, 10, 2, 10);

        check(arr.get(arr.getSize() - 1) == 10,
                "get last element");

        check(arr.contains(3), "contains existing value");
        check(!arr.contains(0), "contains missing value");

        while (arr.getSize() > 0) {
            arr.remove(arr.getSize() - 1);
        }

        check(arr.getSize() == 0, "remove all elements");
        check(!arr.contains(0), "contains on empty array");

        checkThrows(() -> arr.get(0), "get from empty array");
        checkThrows(() -> arr.remove(0), "remove from empty array");

        arr.add(3);
        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }

        checkArray(arr, 3, 0, 1, 2, 3, 4);
        check(arr.contains(3), "contains duplicate value");

        checkThrows(() -> arr.get(7), "get invalid index");
    }

    public static void testLinkedList() {
        System.out.println("\n--- LinkedList tests ---");

        LinkedList list = new LinkedList();

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);

        checkList(list, 1, 3, 2, 4, 5);

        list.add(2, 10);
        checkList(list, 1, 3, 10, 2, 4, 5);

        list.add(list.getSize() - 1, 10);
        checkList(list, 1, 3, 10, 2, 4, 10, 5);

        list.remove(0);
        checkList(list, 3, 10, 2, 4, 10, 5);

        list.remove(list.getSize() / 2);
        checkList(list, 3, 10, 2, 10, 5);

        list.remove(list.getSize() - 1);
        checkList(list, 3, 10, 2, 10);

        check(list.get(list.getSize() - 1) == 10,
                "get last element");

        check(list.contains(3), "contains existing value");
        check(!list.contains(0), "contains missing value");

        while (list.getSize() > 0) {
            list.remove(list.getSize() - 1);
        }

        check(list.getSize() == 0, "remove all elements");
        check(!list.contains(0), "contains on empty list");

        checkThrows(() -> list.get(0), "get from empty list");
        checkThrows(() -> list.remove(0), "remove from empty list");

        list.add(3);
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        checkList(list, 3, 0, 1, 2, 3, 4);
        check(list.contains(3), "contains duplicate value");

        checkThrows(() -> list.get(7), "get invalid index");
    }

    public static void testMinHeap() {
        System.out.println("\n--- MinHeap tests ---");

        MinHeap heap = new MinHeap();

        heap.insert(7);
        heap.insert(3);
        heap.insert(7);
        heap.insert(2);
        heap.insert(9);
        heap.insert(1);

        check(heap.getSize() == 6, "heap size after insertions");
        check(heap.peekMin() == 1, "minimum after insertions");

        int[] expected = {1, 2, 3, 7, 7, 9};

        for (int value : expected) {
            check(heap.extractMin() == value,
                    "extract minimum " + value);
        }

        check(heap.isEmpty(), "heap empty after extraction");
        check(heap.getSize() == 0, "heap size is zero");

        checkThrows(() -> heap.peekMin(),
                "peek on empty heap");

        checkThrows(() -> heap.extractMin(),
                "extract from empty heap");

        heap.insert(2);
        check(!heap.isEmpty(), "heap not empty after insert");
        check(heap.getSize() == 1, "heap size one");
        check(heap.peekMin() == 2, "minimum of one element");
        check(heap.extractMin() == 2, "extract single element");
        check(heap.isEmpty(), "heap empty after single extraction");
    }

    public static void main(String[] args) {
        testDynamicArray();
        testLinkedList();
        testMinHeap();

        System.out.println("\nAll tests completed successfully!");
    }
}