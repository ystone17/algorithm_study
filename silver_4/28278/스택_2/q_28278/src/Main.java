import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, cmd;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                add(x);
                continue;
            }

            switch (cmd) {
                case 2:
                    sb.append(pop()).append("\n");
                    break;
                case 3:
                    sb.append(size()).append("\n");
                    break;
                case 4:
                    sb.append(isEmpty()).append("\n");
                    break;
                case 5:
                    sb.append(peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void add(int x) {
        stack.add(x);
    }

    private static int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.pop();
    }

    private static int size() {
        return stack.size();
    }

    private static int isEmpty() {
        return stack.isEmpty() ? 1 : 0;
    }

    private static int peek() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }
}
