import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            int top = q.poll();
            q.offer(top);
        }

        System.out.printf("%d",q.poll());

    }
}

