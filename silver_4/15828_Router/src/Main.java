import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int bufferSize;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        bufferSize = Integer.parseInt(br.readLine());

        var input = 0;
        while (true) {
            input = Integer.parseInt(br.readLine());
            if (input == -1) {
                break;
            }

            if (input == 0) {
                q.poll();
                continue;
            }

            if (q.size() >= bufferSize) {
                continue;
            }

            q.add(input);
        }

        if(q.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
        }

        System.out.println(sb);
    }
}
