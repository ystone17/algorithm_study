import jdk.jfr.Frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, numLen;
    static int[] number;
    static String[] oper;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numLen = n / 2 + 1;
        number = new int[numLen];
        oper = new String[numLen];
        oper[0] = "+";

        int idx = 0;
        for (String s : br.readLine().split("")) {
            if (idx % 2 == 0) {
                number[idx / 2] = Integer.parseInt(s);
            } else {
                oper[idx / 2 + 1] = s;
            }
            idx++;
        }

        req(0, 0);
        System.out.println(answer);

    }

    static void req(int idx, int res) {
        if (idx >= numLen) {
            answer = Math.max(answer, res);
            return;
        }

        if (idx + 1 < numLen) {
            int r = calc(number[idx], number[idx + 1], idx + 1);
            req(idx + 2, calc(res, r, idx));
        }


        req(idx + 1, calc(res, number[idx], idx));
    }

    private static int calc(int a, int b, int op) {
        switch (oper[op]) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
