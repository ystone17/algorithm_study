import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int[] ud = new int[2];
        ud[0] = sc.nextInt();
        ud[1] = sc.nextInt() * -1;
        int[] visited = new int[f + 1];
        Queue<Integer> q = new LinkedList<>();

        if(s == g){
            System.out.println(0);
            return;
        }

        q.offer(s);
        visited[s] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 2; i++) {
                int next = cur + ud[i];

                if (next <= 0 || next > f) {
                    continue;
                }

                if (visited[next] > 0) {
                    continue;
                }

                if (next == g) {
                    System.out.println(visited[cur]);
                    return;
                }

                visited[next] = visited[cur] + 1;
                q.offer(next);
            }
        }
        System.out.println("use the stairs");
    }
}
