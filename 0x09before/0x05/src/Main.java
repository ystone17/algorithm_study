import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
//        String[] stack = new String[100001];
//        int pos = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
//                    stack[pos++] = input[1];
                    stack.push(input[1]) ;
                    break;
                case "pop":
//                    if (pos != 0) {
//                        bw.write(stack[--pos]);
//                    } else{
//                        bw.write("-1");
//                    }
//                    bw.newLine();
                    if (!stack.empty()){
                        bw.write(stack.pop());
                    } else{
                        bw.write("-1");
                    }
                    bw.newLine();
                    break;
                case "size":
//                    bw.write(Integer.toString(pos));
//                    bw.newLine();
                    bw.write(Integer.toString(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
//                    if (pos == 0){
//                        bw.write("1");
//                    } else{
//                        bw.write("0");
//                    }
//                    bw.newLine();
                    bw.write(stack.empty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "top":
//                    if (pos != 0){
//                        bw.write(stack[pos - 1]);
//                    } else{
//                        bw.write("-1");
//                    }
//                    bw.newLine();
                    if (!stack.empty()){
                        bw.write(stack.peek());
                    } else{
                        bw.write("-1");
                    }
                    bw.newLine();
                    break;
            }


        }
        bw.flush();
        bw.close();
    }
}
