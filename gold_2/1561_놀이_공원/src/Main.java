import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

        int resTime = binarySearch(1, 2_000_000_000);
        int res = 0;
        for (int i = 0; i < rides.length; i++) {
            res += resTime/ rides[i]  + 1;
            if(res == peopleNum) {
                System.out.println(i + 1);
                return;
            }

        }

    }

    static int binarySearch(int left, int right) {
        int mid;

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

    static int search(int time) {
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
