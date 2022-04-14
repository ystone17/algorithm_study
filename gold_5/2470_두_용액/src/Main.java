import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int left = 0;
        int right = n - 1;

        int answer = Integer.MAX_VALUE;
        int a1 = 0;
        int a2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                a1 = arr[left];
                a2 = arr[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.printf("%d %d", a1, a2);

    }
}
