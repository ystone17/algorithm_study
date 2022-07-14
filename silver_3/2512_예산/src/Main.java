import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        int max = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            max = Math.max(max, number);
            sum += number;

            arr[i] = number;
        }
        m = Integer.parseInt(br.readLine());

        if (sum <= m) {
            System.out.println(max);
            return;
        }

        int answer = 0;
        int left = 0;

        while (left <= max) {
            int mid = (left + max) / 2;
            sum = 0;

            for (int a : arr) {
                sum += Math.min(a, mid);
            }

            if( sum > m){
                max = mid -1;
            } else{
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        System.out.println(answer);
    }
}
