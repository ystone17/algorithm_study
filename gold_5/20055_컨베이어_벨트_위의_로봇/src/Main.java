import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, kCnt;
    static Space[] up;
    static Space[] down;
    static Deque<Space> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        up = new Space[n];
        down = new Space[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            up[i] = new Space(Integer.parseInt(st.nextToken()), false);
        }
        for (int i = n - 1; i >= 0; i--) {
            down[i] = new Space(Integer.parseInt(st.nextToken()), false);
        }

        int round = 1;

        while (true) {
            rotate();
            if (move()) {
                System.out.println(round);
                return;
            }
            if (add()) {
                System.out.println(round);
                return;
            }
            round++;
        }

    }

    static void rotate() {
        for (int i = 0; i < n; i++) {
            q.add(up[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            q.add(down[i]);
        }

        q.addFirst(q.pollLast());

        for (int i = 0; i < n; i++) {
            up[i] = q.pollFirst();
        }
        for (int i = n - 1; i >= 0; i--) {
            down[i] = q.pollFirst();
        }
        up[n - 1].hasRobot = false;
    }

    static boolean move() {

        for (int i = up.length - 2; i >= 0; i--) {
            if (up[i].hasRobot && !up[i + 1].hasRobot && up[i + 1].health != 0) {
                up[i].hasRobot = false;
                up[i + 1].hasRobot = true;
                if (--up[i + 1].health == 0) {
                    kCnt++;
                }
            }
        }
        up[n - 1].hasRobot = false;

        return kCnt >= k;
    }

    static boolean add() {
        if (up[0].health != 0) {
            up[0].hasRobot = true;
            if (--up[0].health == 0) {
                kCnt++;
            }
        }

        return kCnt >= k;
    }

    static class Space {
        int health;
        boolean hasRobot;

        public Space(int health, boolean hasRobot) {
            this.health = health;
            this.hasRobot = hasRobot;
        }

        @Override
        public String toString() {
            return "Space{" +
                    "health=" + health +
                    ", hasRobot=" + hasRobot +
                    '}';
        }
    }
}
