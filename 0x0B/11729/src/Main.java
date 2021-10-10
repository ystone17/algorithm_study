import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int res = hanoi(height, 1, 2, 3);
        System.out.printf("%d\n%s", res, sb.toString());
    }

    static int hanoi(int height, int first, int second, int third) {
        int num = 0;
        if (height == 1) {
            sb.append(first).append(" ").append(third).append("\n");
            return 1;
        }

        num += hanoi(height - 1, first, third, second);
        sb.append(first).append(" ").append(third).append("\n");
        num += hanoi(height - 1, second, first, third);
        return num+1;
    }
}
