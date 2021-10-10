import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0){
                stack.pop();
            } else{
                stack.push(input);
            }
        }
        int res = 0;
        while(!stack.empty()){
            res += stack.pop();
        }

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}
