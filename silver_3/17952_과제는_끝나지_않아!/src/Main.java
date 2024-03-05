import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Deque<Project> dq = new LinkedList<>();
    static int n, res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            var cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                dq.addFirst(new Project(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            if (dq.isEmpty()) {
                continue;
            }

            dq.peek().time--;
            if (dq.peek().time == 0) {
                res += dq.peek().grade;
                dq.pollFirst();
            }
        }

        System.out.println(res);
    }

    static class Project {
        int grade;
        int time;

        public Project(int grade, int time) {
            this.grade = grade;
            this.time = time;
        }
    }
}
