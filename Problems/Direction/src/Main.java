import java.util.Scanner;

class Main {
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int numDir = in.nextInt();
        printDirection(numDir);
    }

    static void printDirection(int numDir) {
        switch (numDir) {
            case 0:
                System.out.println("do not move");
                break;
            case 1:
                System.out.println("move up");
                break;
            case 2:
                System.out.println("move down");
                break;
            case 3:
                System.out.println("move left");
                break;
            case 4:
                System.out.println("move right");
                break;
            default:
                System.out.println("error!");
        }
    }
}