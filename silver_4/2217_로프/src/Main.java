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
    static long[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long max = arr[n-1];
        int size = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if(max <= arr[i] * ++size){
                max = arr[i] * size;
                continue;
            }
        }

        System.out.println(max);
    }
}
