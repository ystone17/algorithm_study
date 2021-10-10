import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] inputs = br.readLine().split(" ");

            switch (inputs[0]) {
                case "push_front":
                    q.offerFirst(Integer.parseInt(inputs[1]));
                    break;
                case "push_back":
                    q.offerLast(Integer.parseInt(inputs[1]));
                    break;
                case "pop_front":
                    if (q.peekFirst() != null) {
                        sb.append(q.poll()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "pop_back":
                    if (q.peekLast() != null) {
                        sb.append(q.pollLast()).append("\n");
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
        System.out.printf("%s", sb.toString());
    }
}
