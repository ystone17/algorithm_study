import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for (int i = 0; i < num; i++) {

            int value = Integer.parseInt(br.readLine());
            while (index <= value) {
                stack.push(index++);
                sb.append("+").append("\n");
            }

            if(stack.peek() != value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb.toString());
    }
}
