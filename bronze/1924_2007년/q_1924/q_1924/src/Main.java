import java.util.Scanner;

public class Main {

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        int total = 0;

        for (int i = 0; i < m; i++) {
            total += month[i];
        }
        total += d;

        System.out.println(week[total % 7]);
    }
}
