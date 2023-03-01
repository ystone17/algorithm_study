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

    static List<Integer> leftWeight = new ArrayList<>();
    static List<Integer> rightWeight = new ArrayList<>();
    static List<Long> leftPartSum = new ArrayList<>();
    static List<Long> rightPartSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                leftWeight.add(Integer.parseInt(st.nextToken()));
            } else {
                rightWeight.add(Integer.parseInt(st.nextToken()));
            }
        }

        partSum(0, 0, leftWeight, leftPartSum);
        partSum(0, 0, rightWeight, rightPartSum);

        Collections.sort(leftPartSum);
        Collections.sort(rightPartSum);

        for (Long r : rightPartSum) {
            if (r > c) break;
            int sum = upperBound(c - r);
            Main.sum += sum;
        }

        System.out.println(sum);
    }

    static void partSum(int idx, long sum, List<Integer> weight, List<Long> partSum) {
        if (idx >= weight.size()) {
            if (sum <= c) {
                partSum.add(sum);
            }
            return;
        }

        partSum(idx + 1, sum + weight.get(idx), weight, partSum);
        partSum(idx + 1, sum, weight, partSum);
    }

    static int upperBound(Long x) {
        int l = 0;
        int r = leftPartSum.size();
        int mid;

        while (l < r) {
            mid = (l + r) / 2;

            if (leftPartSum.get(mid) <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

}
