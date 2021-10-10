import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            for (String s : input.split("")) {
                if (s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else if (s.equals(")")) {
                    if (stack.empty() || !stack.pop().equals("(")) {
                        stack.push("no");
                    }
                } else if (s.equals("]")) {
                    if (stack.empty() || !stack.pop().equals("[")) {
                        stack.push("no");
                    }
                }
            }

            if (stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            stack.clear();
        }
    }
}
