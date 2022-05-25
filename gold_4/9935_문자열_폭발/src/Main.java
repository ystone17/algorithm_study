import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split("");
        String[] boom = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (String s1 : s) {
            stack.push(s1);

            if (stack.size() >= boom.length) {
                boolean flag = true;

                for (int i = 0; i < boom.length; i++) {
                    if (!(stack.get(stack.size() - (boom.length - i)).equals(boom[i]))) {
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for (int i = 0; i < boom.length; i++) {
                        stack.pop();
                    }
                }

            }

        }

        if(stack.size() == 0){
            System.out.println("FRULA");
        } else{
            for (String s1 : stack) {
                sb.append(s1);
            }
            System.out.println(sb);
        }


    }

}
