import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        int[] temp;
        for (int i = 1; i < 10; i++) {
            arr[i] = 1;
        }
        long[] dp = new long[100];


        dp[0] = 9;
        for (int i = 1; i < 100; i++) {
            temp = new int[10];
            temp[1] = arr[0] % 1000000000;
            temp[8] = arr[9] % 1000000000;
            for (int j = 1; j < 9; j++) {
                temp[j - 1] += arr[j] % 1000000000;
                temp[j + 1] += arr[j] % 1000000000;
            }
            for (int j = 0; j < 10; j++) {
                arr[j] = temp[j];
            }

            for (int i1 : arr) {

                dp[i] = (dp[i] + i1) % 1000000000;
            }

        }

        System.out.println(dp[n - 1]);

    }
}

// System.out.printf("[%02d] ", 9);
//        for (int i : arr) {
//            System.out.printf("%10d ", i);
//        }
//        System.out.println();
//        dp[0] = 9;
//        for (int i = 1; i < 100; i++) {
//            temp = new int[10];
//            temp[1] = arr[0] % 1000000000;
//            temp[8] = arr[9] % 1000000000;
//            for (int j = 1; j < 9; j++) {
//                temp[j - 1] += arr[j] % 1000000000;
//                temp[j + 1] += arr[j] % 1000000000;
//            }
//            for (int j = 0; j < 10; j++) {
//                arr[j] = temp[j];
//            }
//            System.out.printf("[%02d] ", i);
//
//            long total = 0;
//            for (int i1 : arr) {
//                System.out.printf("%10d ", i1);
//                total = (total + i1) % 1000000000;
//            }
//            System.out.printf("= %10d\n", total);
//        }