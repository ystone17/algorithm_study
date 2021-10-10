import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] inputs = br.readLine().split(" ");

            switch (inputs[0]) {

                case "push":
                    q.offer(Integer.parseInt(inputs[1]));
                    break;
                case "pop":
                    if (q.peek() != null) {
                        sb.append(q.poll()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if (q.peek() != null) {
                        sb.append(q.peek()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "back":
                    if (q.peekLast() != null) {
                        sb.append(q.peekLast()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
            }
        }
        System.out.printf("%s",sb.toString());

    }
}
