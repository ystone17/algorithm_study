import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long peopleNum, rideNum;
    static int[] rides;

    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//
//        peopleNum = Integer.parseInt(st.nextToken());
//        rideNum = Integer.parseInt(st.nextToken());
//
//        rides = new int[rideNum];
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < rideNum; i++) {
//            rides[i] = Integer.parseInt(st.nextToken());
//        }

        rides = new int[10000];
        Arrays.fill(rides, 30);
        for (int i = 1; i <= 30; i++) {
            rides[i - 1] = i;
        }

        long baseLcm = lcm(rides[0], rides[1]);
        for (int i = 2; i < rides.length; i++) {
            baseLcm = lcm(baseLcm, rides[i]);
        }

        peopleNum = peopleNum & baseLcm;



    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long gcd(long a, long b) {
        long temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
