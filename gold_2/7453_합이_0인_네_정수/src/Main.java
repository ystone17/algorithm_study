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
    static int[][] arr;
    static int[] ab;
    static long answer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][4];
        ab = new int[n * n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx++] = -(arr[i][0] + arr[j][1]);
            }
        }

        Arrays.sort(ab);

        int sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = arr[i][2] + arr[j][3];
                answer += upper(sum) - lower(sum);
            }
        }


        System.out.println(answer);

    }

    static int upper(int k) {
        int left = 0;
        int right = n * n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (ab[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int lower(int k) {
        int left = 0;
        int right = n * n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (ab[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
