import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int n, m, start, end, res;
    static Human[] humans;
    static int[] used;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());


        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            res = 0;

            used = new int[n + 1];
            humans = new Human[m];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                humans[i] = new Human(start, end);
            }

            Arrays.sort(humans);

            for (Human human : humans) {
                for (int i = human.start; i <= human.end; i++) {
                    if (used[i] == 0) {
                        used[i] = 1;
                        res++;
                        break;
                    }
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);

    }

    static class Human implements Comparable<Human> {
        int start;
        int end;

        public Human(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Human o) {
            if (end != o.end) {
                return Integer.compare(end, o.end);
            } else {
                return Integer.compare(start, o.start);
            }
        }

        @Override
        public String toString() {
            return "Human{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


}
