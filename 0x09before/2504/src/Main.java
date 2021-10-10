import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        class node {
            int depth;
            int value;

            public node(int depth, int value) {
                this.depth = depth;
                this.value = value;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> gwalho = new Stack<>();
        Stack<node> res = new Stack<>();
        boolean isGood = true;
        String[] inputs = br.readLine().split("");

        for (String input : inputs) {
            if (input.equals("(") || input.equals("[")) {
                gwalho.push(input);
            } else if (input.equals(")")) {
                if (gwalho.empty() || !gwalho.peek().equals("(")) {
                    isGood = false;
                    break;
                }
                gwalho.pop();
                node temp = new node(gwalho.size(), 2);
                while (!res.empty() && res.peek().depth > temp.depth) {
                    node target = res.pop();
                    temp.value *= target.value;
                }

                while (!res.empty() && res.peek().depth == temp.depth) {
                    node target = res.pop();
                    temp.value += target.value;
                }
                res.push(temp);

            } else if (input.equals("]")) {
                if (gwalho.empty() || !gwalho.peek().equals("[")) {
                    isGood = false;
                    break;
                }
                gwalho.pop();
                node temp = new node(gwalho.size(), 3);
                while (!res.empty() && res.peek().depth > temp.depth) {
                    node target = res.pop();
                    temp.value *= target.value;
                }

                while (!res.empty() && res.peek().depth == temp.depth) {
                    node target = res.pop();
                    temp.value += target.value;
                }
                res.push(temp);
            }
        }

        if (gwalho.size() != 0) {
            isGood = false;
        }

        if (isGood) {
            System.out.println(res.pop().value);
        } else {
            System.out.println(0);
        }


    }
}
