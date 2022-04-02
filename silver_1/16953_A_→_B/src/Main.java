import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long a, b;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Queue<Long> q = new LinkedList<>();

        int res = 1;
        q.add(a);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long cur = q.poll();
                if (cur == b) {
                    System.out.println(res);
                    return;
                }

                if (cur * 2 <= b) q.add(cur * 2);
                if (cur * 10 + 1 <= b) q.add(cur * 10 + 1);
            }
            res++;
        }
        System.out.println(-1);

    }

}
