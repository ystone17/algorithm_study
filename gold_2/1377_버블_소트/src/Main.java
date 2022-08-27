import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Num[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new Num[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, arr[i].idx - i);
        }

        sb.append(max + 1);
        System.out.println(sb);
    }

    static class Num implements Comparable<Num> {
        int num;
        int idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num o) {
            return Integer.compare(num, o.num);
        }
    }
}
