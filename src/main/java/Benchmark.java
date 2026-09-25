import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;

public class Benchmark {
    private static final int[] sizes = {100, 1000, 10000, 100000};
    private static final int repetitions = 5;
    private static final int operations = 10_000;

    private static long checksum = 0;

    public static void main(String[] args) throws IOException {
        Random random = new Random(42);
        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("Structure,Workload,Size,Repetition,TimeNs\n");
            for (int n : sizes) {
                int[] values = new int[n];
                for (int i = 0; i < n; i++) {
                    values[i] = random.nextInt(100_000);
                }
                int[] indices = new int[operations];
                int[] searchValues = new int[operations];

                for (int i = 0; i < operations; i++) {
                    indices[i] = random.nextInt(n);
                    if (i % 2 == 0) {
                        searchValues[i] = values[random.nextInt(n)];
                    } else {
                        searchValues[i] = -1;
                    }
                }
                benchmarkDynamicArray(values, indices, n, writer);
                benchmarkLinkedList(values, indices, n, writer);
                benchmarkSearch(values, searchValues, n, writer);
            }
        }
        System.out.println("Benchmark completed.");
        System.out.println("Results saved to benchmark_results.csv");
    }

    private static void benchmarkDynamicArray(int[] values, int[] indices, int n, FileWriter writer) throws IOException {
        DynamicArray arr = new DynamicArray();
        for (int value : values) {
            arr.add(value);
        }
        for (int rep = 1; rep <= repetitions; rep++) {
            long start = System.nanoTime();
            for (int index : indices) {
                arr.get(index);
            }
            long end = System.nanoTime();
            long elapsed = end - start;
            writer.write("DynamicArray,RandomAccess," + n + "," + rep + "," + elapsed + "\n");
            System.out.println("DynamicArray n=" + n + " rep=" + rep + " time=" + elapsed + "ns");
        }
    }

    private static void benchmarkLinkedList(int[] values, int[] indices, int n, FileWriter writer) throws IOException {
        LinkedList list = new LinkedList();
        for (int value : values) {
            list.add(value);
        }
        for (int rep = 1; rep <= repetitions; rep++) {
            long start = System.nanoTime();
            for (int index : indices) {
                list.get(index);
            }
            long end = System.nanoTime();
            long elapsed = end - start;
            writer.write("LinkedList,RandomAccess," + n + "," + rep + "," + elapsed + "\n");
            System.out.println("LinkedList n=" + n + " rep=" + rep + " time=" + elapsed + "ns");
        }
    }

    private static void benchmarkSearch(int[] values, int[] searchValues, int n, FileWriter writer) throws IOException{
        DynamicArray arr = new DynamicArray();
        LinkedList list = new LinkedList();

        for (int value : values){
            arr.add(value);
            list.add(value);
        }
        for (int rep = 1; rep <= repetitions; rep++) {
            long start = System.nanoTime();
            for (int value : searchValues){
                if (arr.contains(value)){
                    checksum++;
                }
            }
            long elapsed = System.nanoTime() - start;
            writer.write("DynamicArray,Search," + n + "," + rep + "," + elapsed + "\n");
            System.out.println("DynamicArray n=" + n + " rep=" + rep + " time=" + elapsed + "ns");
        }
        for (int rep = 1; rep <= repetitions; rep++) {
            long start = System.nanoTime();
            for (int value: searchValues){
                if( list.contains(value)){
                    checksum++;
                }
            }
            long end = System.nanoTime();
            long elapsed = end - start;
            writer.write("LinkedList,Search," + n + "," + rep + "," + elapsed + "\n");
            System.out.println("LinkedList n=" + n + " rep=" + rep + " time=" + elapsed + "ns");
        }
    }
}