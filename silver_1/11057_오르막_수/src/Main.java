import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] answer = new int[1001];
        int[] arr = new int[10];
        int[] temp;
        for (int i = 0; i < 10; i++) {
            arr[i] = 1;
        }


        for (int i = 0; i < n; i++) {
            temp = new int[10];

            int total = 0;

            for (int j = 0; j < 10; j++) {
                total = (total + arr[j]) % 10007;
                for (int k = j; k < 10; k++) {
                    temp[k] = (temp[k] + arr[j]) % 10007;
                }
            }
            answer[i + 1] = total;

            System.arraycopy(temp, 0, arr, 0, 10);

        }
        System.out.println(answer[n]);
    }
}
