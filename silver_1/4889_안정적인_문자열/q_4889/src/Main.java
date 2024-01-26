import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        String s;
        var count = 1;
        int res;
        while (!(s = br.readLine()).contains("-")) {
            res = 0;
            stack.clear();
            for (char c : s.toCharArray()) {
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.empty() || stack.peek() == '}') {
                        stack.push(c);
                        continue;
                    }
                    stack.pop();

                }
            }

            sb.append(count++).append(". ");

            while (!stack.isEmpty()) {
                var pop = stack.pop();
                if (pop == stack.peek()) {
                    res++;
                } else {
                    res += 2;
                }

                stack.pop();
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);

    }

}
