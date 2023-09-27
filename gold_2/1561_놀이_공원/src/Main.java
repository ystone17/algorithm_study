import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int peopleNum, rideNum;
    static int[] rides;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        peopleNum = Integer.parseInt(st.nextToken());
        rideNum = Integer.parseInt(st.nextToken());

        rides = new int[rideNum];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < rideNum; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        long resTime = binarySearch(1, 60_000_000_000L);
        int res = 0;
        int resNum = 0;
        for (int i = 0; i < rides.length; i++) {
            res += resTime / rides[i] + 1;

            if (resTime % rides[i] == 0 || resTime < rides[i]) {
                resNum = i + 1;
            }

            if (res >= peopleNum) {
                System.out.println(resNum);
                return;
            }

        }

    }

    static long binarySearch(long left, long right) {
        long mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (search(mid) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int search(long time) {
        long total = 0;
        for (int ride : rides) {
            total += (time / ride) + 1;
        }

        if (total == peopleNum) {
            return 0;
        }

        if (total < peopleNum) {
            return -1;
        }

        return 1;
    }


}
