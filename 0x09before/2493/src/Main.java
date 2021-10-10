import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        class tower {
            final int height;
            final int num;

            public tower(int height, int num) {
                this.height = height;
                this.num = num;
            }
        }
        Stack<tower> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] towers = br.readLine().split(" ");

        stack.push(new tower(Integer.MAX_VALUE, 0));
        int i = 1;
        for (String height : towers) {
            tower temp = new tower(Integer.parseInt(height), i);

            while (!stack.empty() && stack.peek().height < temp.height) {
                stack.pop();
            }

            bw.write(stack.peek().num + " ");
            stack.push(temp);
            i++;
        }
        bw.flush();
        bw.close();
    }
}
