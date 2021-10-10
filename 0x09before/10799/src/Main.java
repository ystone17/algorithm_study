import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        String[] laserAndPipe = br.readLine().split("");
        int res = 0;
        String previous = "";

        for (String s : laserAndPipe) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                // laser
                stack.pop();
                if (previous.equals("(")) {
                    res += stack.size();
                } else { // pipe
                    res += 1;
                }
            }
            previous = s;
        }
        System.out.println(res);

    }
}
