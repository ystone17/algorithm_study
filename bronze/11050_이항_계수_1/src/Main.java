import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k < 0 || k > n) {
            System.out.println(0);
        } else if (k == 0 || k == n) {
            System.out.println(1);
        } else{
            System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
        }
    }

    static int factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }

}
