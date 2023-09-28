import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int peopleNum, rideNum;
    static int[] ridePlayTimes;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        peopleNum = Integer.parseInt(st.nextToken());
        rideNum = Integer.parseInt(st.nextToken());

        ridePlayTimes = new int[rideNum];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < rideNum; i++) {
            ridePlayTimes[i] = Integer.parseInt(st.nextToken());
        }


        long answerTime;
        long tempAnswerTime;
        long mid;
        long left = 0;
        long right = 2_000_000_000L * 30;
        while (left < right) {
            mid = (left + right) / 2;

            if (search(mid) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        answerTime = left;
        tempAnswerTime = answerTime - 1;
        int total = 0;
        int res = 0;
        if (tempAnswerTime != -1) {
            for (int ridePlayTime : ridePlayTimes) {
                total += (tempAnswerTime / ridePlayTime) + 1;
            }
        }

        for (int rideIdx = 0; rideIdx < ridePlayTimes.length; rideIdx++) {
            int ridePlayTime = ridePlayTimes[rideIdx];

            if (answerTime % ridePlayTime == 0) {
                total += 1;
            }
            if (total == peopleNum) {
                res = rideIdx;
                break;
            }
        }

        System.out.println(res + 1);
    }

    static int search(long time) {
        long total = 0;
        for (int ridePlayTime : ridePlayTimes) {
            total += (time / ridePlayTime) + 1;
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
