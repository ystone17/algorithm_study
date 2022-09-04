import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static String s;
    static double[] arr;
    static Stack<Double> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        double a, b;

        for (char c : s.toCharArray()) {
            if (0 <= c - 'A' && c - 'A' <= 26) {
                stack.push(arr[c - 'A']);
                continue;
            }

            b = stack.pop();
            a = stack.pop();

            switch (c) {
                case '+':
                    stack.push(a + b);
                    break;
                case '-':
                    stack.push(a - b);
                    break;
                case '*':
                    stack.push(a * b);
                    break;
                case '/':
                    stack.push(a / b);
                    break;
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
