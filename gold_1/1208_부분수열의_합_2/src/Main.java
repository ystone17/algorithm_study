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

    static int n, s;
    static long answer;
    static int[] seq;
    static List<Integer> partA = new ArrayList<>(), partB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(seq[0] == s ? 1 : 0);
            return;
        }

        int aSize = n / 2;
        int bSize = n - aSize;

        aSize = (int) Math.pow(2, aSize);
        bSize = (int) Math.pow(2, bSize);

        int count = 0;
        while (count < aSize) {
            int sum = 0;
            int idx = 0;
            int temp = count;

            while (temp != 0) {
                if (temp % 2 == 1) {
                    sum += seq[idx];
                }

                temp /= 2;
                idx++;
            }

            partA.add(sum);
            count++;
        }
        Collections.sort(partA);

        count = 0;
        while (count < bSize) {
            int sum = 0;
            int idx = n / 2;
            int temp = count;

            while (temp != 0) {
                if (temp % 2 == 1) {
                    sum += seq[idx];
                }

                temp /= 2;
                idx++;
            }

            answer += upper(s - sum) - lower(s - sum);
            count++;
        }

        System.out.println(s == 0 ? answer - 1 : answer);

    }

    static int upper(int k) {
        int left = 0;
        int right = partA.size();
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (partA.get(mid) <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int lower(int k) {
        int left = 0;
        int right = partA.size();
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (partA.get(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
