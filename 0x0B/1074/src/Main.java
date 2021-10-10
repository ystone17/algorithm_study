import java.util.Scanner;

public class Main {
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int res =z(N, 0, 0, 0);
        System.out.printf("%d\n", res);
    }

    static int z(int N, int r, int c, int count) {
        if (N == 0) {
            return count;
        }
        int t = (int) Math.pow(2, N - 1);

        if (Main.r < r + t && Main.c < c + t) {
            count = z(N - 1, r, c, count);
        } else if (Main.r < r + t && Main.c >= c + t) {
            count = z(N - 1, r, c + t, count + (t * t));
        } else if (Main.r >= r + t && Main.c < c + t) {
            count = z(N - 1, r + t, c, count + (t * t) * 2);
        } else if (Main.r >= r + t && Main.c >= c + t) {
            count = z(N - 1, r + t, c + t, count + (t * t) * 3);
        }

        return count;
    }
}
