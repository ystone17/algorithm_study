import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int[] fibonacci = new int[45];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solve(n)).append("\n");
        }

        System.out.println(sb);
    }

    private static String solve(int n) {
        stack.clear();
        int i = fibonacci.length - 1;
        StringBuilder s = new StringBuilder();

        while (n != 0) {
            if (fibonacci[i] > n) {
                i--;
                continue;
            }

            n -= fibonacci[i];
            stack.push(fibonacci[i]);
            i--;
        }

        while (!stack.isEmpty()) {
            s.append(stack.pop()).append(" ");
        }
        return s.toString();
    }
}
