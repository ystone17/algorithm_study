import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, kg;
    //    static int[] weight, value, dp;
    static Goods[] goods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        kg = Integer.parseInt(st.nextToken());
        goods = new Goods[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            goods[i] = new Goods(w, v);
        }

        Arrays.sort(goods);
        int answer = 0;
        for (int i = 0; i < n; i++) {

            int w = goods[i].w;
            int v = goods[i].v;

            for (int j = i + 1; j < n; j++) {
                if( w > kg) break;
                if (w + goods[j].w <= kg) {
                    w += goods[j].w;
                    v += goods[j].v;
                }
            }
            answer = Math.max(answer, v);
        }
        System.out.println(answer);
    }

    static class Goods implements Comparable<Goods>{
        int w;
        int v;

        public Goods(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Goods o) {
            return (v - o.v) * -1;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "w=" + w +
                    ", v=" + v +
                    '}';
        }
    }
}
