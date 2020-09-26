import java.util.Scanner;

class Main {
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        long a = in.nextLong();
        String op = in.next();
        long b = in.nextLong();
        switch (op) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(a / b);
                }
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}