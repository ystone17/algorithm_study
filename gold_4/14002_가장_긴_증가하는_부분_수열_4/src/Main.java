import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr, dp, seq;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n + 1];
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > dp[idx]) {
                dp[++idx] = arr[i];
                seq[i] = idx;
            } else {
                int changeIdx = lower(arr[i], idx);
                dp[changeIdx] = arr[i];
                seq[i] = changeIdx;
            }
        }

        System.out.println(idx);

        Stack<Integer> s = new Stack<>();
        for (int i = seq.length - 1; i >= 0; i--) {
            if(seq[i] == idx){
                s.push(arr[i]);
                idx--;
            }
        }

        while (!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }


        System.out.println(sb.toString().trim());
    }

    static private int lower(int k, int last) {
        int left = 0;
        int right = last + 1;


        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static class Pos {
        int idx;
        int value;

        public Pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
