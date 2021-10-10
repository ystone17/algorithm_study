import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long res = 0L;

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.empty() && stack.peek() <= height) {
                stack.pop();
            }
            res += stack.size();
            stack.push(height);
        }

        bw.write(Long.toString(res));
        bw.flush();

    }
}
