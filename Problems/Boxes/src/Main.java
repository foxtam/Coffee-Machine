import java.util.*;

public class Main {
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[] firstArray = readNSizeArray(3);
        int[] secondArray = readNSizeArray(3);

        sortArray(firstArray);
        sortArray(secondArray);

        int[] diff = diffArray(firstArray, secondArray);

        if (allZeros(diff)) {
            System.out.println("Box 1 = Box 2");
        } else if (allNotPositive(diff)) {
            System.out.println("Box 1 > Box 2");
        } else if (allNotPositive(diffArray(secondArray, firstArray))) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }

    static int[] readNSizeArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static void sortArray(int[] array) {
        if (array.length < 2) return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    static int[] diffArray(int[] first, int[] second) {
        assert first.length == second.length;
        int[] diff = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            diff[i] = second[i] - first[i];
        }
        return diff;
    }

    static boolean allNotPositive(int[] array) {
        for (int n : array) {
            if (n > 0) return false;
        }
        return true;
    }

    static boolean allZeros(int[] array) {
        for (int n : array) {
            if (n != 0) return false;
        }
        return true;
    }
}
