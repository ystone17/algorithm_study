import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> prime = new ArrayList<>();

        boolean isDivide = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isDivide = true;
                    break;
                }
            }
            if (!isDivide) {
                prime.add(i);
            }
            isDivide = false;
        }

        int total = 0;
        int cnt = 0;
        int s = 0;
        int e = 0;

        while (e <= prime.size()) {
            if (total < n) {
                if(e == prime.size()) break;
                total += prime.get(e++);
                continue;

            }

            if (total == n) {
                cnt++;
            }

            total -= prime.get(s++);
        }

        System.out.println(cnt);

    }
}
