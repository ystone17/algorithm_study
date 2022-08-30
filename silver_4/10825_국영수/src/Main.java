import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, e, m;
    static Human[] humans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        humans = new Human[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            k = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            humans[i] = new Human(name, k, e, m);
        }

        Arrays.sort(humans);

        for (Human human : humans) {
            sb.append(human.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Human implements Comparable<Human> {
        String name;
        int korean;
        int english;
        int math;

        public Human(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Human o) {
            if (korean != o.korean) {
                return Integer.compare(o.korean, korean);
            } else if (english != o.english) {
                return Integer.compare(english, o.english);
            } else if (math != o.math) {
                return Integer.compare(o.math, math);
            } else {
                return name.compareTo(o.name);
            }
        }
    }
}
