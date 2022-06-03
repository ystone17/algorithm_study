import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static Sphere[] spheres;
    static int[] color, answer;
    static int[] weight = new int[2001];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        color = new int[n + 1];
        answer = new int[n];
        spheres = new Sphere[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            spheres[i] = new Sphere(c, w, i);
        }

        Arrays.sort(spheres);

        int sum = 0;
        for (int i = 0; i < spheres.length; i++) {
            Sphere sphere = spheres[i];
            sum += sphere.weight;
            color[sphere.color] += sphere.weight;
            weight[sphere.weight] += sphere.weight;

            if (i >= 1 && spheres[i - 1].color == sphere.color && spheres[i - 1].weight == sphere.weight)
                answer[sphere.index] = answer[spheres[i - 1].index];
            else answer[sphere.index] = (sum - color[sphere.color] - weight[sphere.weight] + sphere.weight);
        }

        for (int i : answer) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static class Sphere implements Comparable<Sphere> {
        int color;
        int weight;
        int index;

        public Sphere(int color, int weight, int index) {
            this.color = color;
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(Sphere o) {
            if (weight == o.weight) {
                return color - o.color;
            } else {
                return weight - o.weight;
            }
        }
    }
}
