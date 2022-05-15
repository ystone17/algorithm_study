import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int an, bn;
    static long t;
    static long[] aArr, bArr;
    static List<Long> aList = new ArrayList<>(), bList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        an = Integer.parseInt(br.readLine());
        aArr = new long[an];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < an; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        bn = Integer.parseInt(br.readLine());
        bArr = new long[bn];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bn; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int s = 0; s < an; s++) {
            long sum = aArr[s];
            aList.add(sum);
            for (int e = s + 1; e < an; e++) {
                sum += aArr[e];
                aList.add(sum);
            }
        }

        for (int s = 0; s < bn; s++) {
            long sum = bArr[s];
            bList.add(sum);
            for (int e = s + 1; e < bn; e++) {
                sum += bArr[e];
                bList.add(sum);
            }
        }

        Collections.sort(bList);
        long res = 0;

        for (Long l : aList) {
            int upper = upper(t - l);
            int lower = lower(t - l);
            res += upper - lower;
        }

        System.out.println(res);

    }

    static int upper(long k) {
        int left = 0;
        int right = bList.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (bList.get(mid) <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

    static int lower(long k) {
        int left = 0;
        int right = bList.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (bList.get(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }
}
