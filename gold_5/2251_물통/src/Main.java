import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] volumes = new int[3];
    static int[][][] checked = new int[201][201][201];
    static Queue<State> q = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[][] seq = {
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 2},
            {2, 0},
            {2, 1}
    };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        q.add(new State(new int[]{0, 0, volumes[2]}));
        checked[0][0][volumes[2]] = 1;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if(cur.seq[0] == 0){
                pq.add(cur.seq[2]);
            }

            int[] temp;
            int sub;
            for (int[] ints : seq) {
                temp = Arrays.copyOf(cur.seq, 3);
                sub = volumes[ints[1]] - temp[ints[1]];

                if (temp[ints[0]] <= sub) {
                    temp[ints[1]] += temp[ints[0]];
                    temp[ints[0]] = 0;
                } else {
                    temp[ints[1]] += sub;
                    temp[ints[0]] -= sub;
                }

                if(checked[temp[0]][temp[1]][temp[2]] == 1) continue;
                checked[temp[0]][temp[1]][temp[2]] = 1;
                q.add(new State(temp));
            }
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }

    static class State {
        int[] seq;

        public State(int[] temp) {
            seq = temp;
        }
    }
}
