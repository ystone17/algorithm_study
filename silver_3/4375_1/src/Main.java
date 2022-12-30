import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (input.hasNext()) {
            sb.append(solve(input.nextInt())).append("\n");
        }

        System.out.println(sb);
    }

    static int solve(int n) {
        int digit = 0;
        int oneNum = 0;

        while (true) {
            digit++;
            oneNum = (oneNum * 10 + 1) % n;
            if (oneNum % n == 0) break;
        }

        return digit;
    }
}
