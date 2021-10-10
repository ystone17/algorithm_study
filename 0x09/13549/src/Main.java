import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == k) {
            System.out.println(0);
            return;
        }
        int[][] nextPos = {{1, 1}, {-1, 1}, {0, 0}};
        int[] dist = new int[100000 + 1];
        Queue<Integer> q = new LinkedList<>();

        dist[n] = 1;
        q.offer(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = now * 2;
                } else {
                    next = now + nextPos[i][0];
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (dist[next] != 0 && dist[next] < dist[now] + nextPos[i][1]) {
                    continue;
                }

                if (i == 0) {
                    if (now > k) {
                        continue;
                    }
                } else if (i == 1) {
                    if (2 * (now - 1) < k) {
                        continue;
                    }
                } else {
                    if (Math.abs(k - now) < Math.abs(k - (2 * now))) {
                        continue;
                    }
                }

                dist[next] = dist[now] + nextPos[i][1];

                q.offer(next);
            }
        }
        System.out.println(dist[k] - 1);

    }
}
