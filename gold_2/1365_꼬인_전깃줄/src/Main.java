import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, lisSize;
    static int[] arr, lis;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        lis = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[lisSize++] = arr[1];

        for (int i = 2; i < arr.length; i++) {
            if (lis[lisSize - 1] < arr[i]) {
                lis[lisSize++] = arr[i];
            } else {
                lis[lower(arr[i])] = arr[i];
            }
        }

        System.out.println(n - lisSize);

    }

    static int lower(int k) {
        int left = 0;
        int right = lisSize;

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
