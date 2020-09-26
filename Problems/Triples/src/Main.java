import java.util.Scanner;

class Main {
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputArray();
        int triplesCount = countTriples(array);
        System.out.println(triplesCount);
    }

    static int[] inputArray() {
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static int countTriples(int[] array) {
        int count = 0;
        loop:
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < i + 3; j++) {
                if (array[j] != array[j-1] + 1) {
                    continue loop;
                }
            }
            count++;
        }
        return count;
    }
}