import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String input = br.readLine();

            for (String s : input.split("")) {
                if (s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else if (s.equals(")")) {
                    if (stack.empty() || !stack.pop().equals("(")) {
                        stack.push("No");
                    }
                } else if (s.equals("]")) {
                    if (stack.empty() || !stack.pop().equals("[")) {
                        stack.push("no");
                    }
                }
            }

            if (stack.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
        }
    }
}
