import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Stack<String> stack = new Stack<>();
    static String[] seq;
    static String res;


    public static void main(String[] args) throws IOException {
        seq = br.readLine().split("");
        for (String s : seq) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                while (!stack.isEmpty() && (rank(stack.peek()) >= rank(s))) {
                    sb.append(stack.pop());
                }
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(s);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    static int rank(String s) {
        if (s.equals("*") || s.equals("/")) return 2;
        else if (s.equals("+") || s.equals("-")) return 1;
        else return 0;
    }
}
