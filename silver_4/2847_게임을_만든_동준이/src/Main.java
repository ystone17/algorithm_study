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

    static int n, num, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[n - 1 - i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                sum += arr[i] - arr[i - 1] + 1;
                arr[i] = arr[i - 1] - 1;
            }
        }

        System.out.println(sum);
    }
}
