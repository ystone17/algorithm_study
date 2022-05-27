import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] t,p, memory;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        memory = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Job> q = new LinkedList<>();
        q.add(new Job(0, 0));

        while (!q.isEmpty()) {
            Job cur = q.poll();

            for (int i = cur.day; i < n; i++) {

                int nDay = i + t[i];
                int nP = cur.total + p[i];

                if(nDay > n) continue;
                if(memory[nDay] >= nP) continue;
                memory[nDay] = nP;
                answer = Math.max(answer, memory[nDay]);
                q.add(new Job(nDay, nP));
            }
        }

        System.out.println(answer);

    }

    static class Job{
        int day;
        int total;

        public Job(int day, int total) {
            this.day = day;
            this.total = total;
        }
    }
}
