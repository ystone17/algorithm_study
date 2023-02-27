import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long sum, c;
    static int[] weight;
    static List<Long> left = new ArrayList<>();
    static List<Long> right = new ArrayList<>();
    static int[] used;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        used = new int[n];
        for (int i = 0; i < n / 2; i++) {
            partSum(0, 0, 0, i + 1, left);
            partSum(n / 2, n / 2, 0, i + 1, right);
        }

        left.add(0L);
        right.add(0L);

        Collections.sort(left);
        Collections.sort(right);

        System.out.println(left);
        System.out.println(right);

        for (Long r : right) {
            if (r > c) break;
            int sum = upperBound(c - r);
            Main.sum += sum;
        }

        System.out.println(sum);
    }

    static void partSum(int arrStart, int start, int cnt, int size, List<Long> list) {
        if (cnt >= size) {
            long sum = 0;
            for (int i = 0; i < used.length; i++) {
                if (used[i] == 1) {
                    sum += weight[i];
                }
            }
            if (sum <= c) list.add(sum);
            return;
        }

        for (int i = start; i < arrStart + n / 2; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            partSum(arrStart, i + 1, cnt + 1, size, list);
            used[i] = 0;
        }
    }

    static int upperBound(Long x) {
        int l = 0;
        int r = left.size();
        int mid;

        while (l < r) {
            mid = (l + r) / 2;

            if (left.get(mid) <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

}
