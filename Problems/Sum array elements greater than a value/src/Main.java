import java.util.Scanner;

class Main {
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int size = in.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int limit = in.nextInt();
        int sum = 0;
        for(int n : array) {
            if (n > limit) {
                sum += n;
            }
        }
        System.out.println(sum);
    }
}