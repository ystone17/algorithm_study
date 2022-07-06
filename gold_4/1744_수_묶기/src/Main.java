import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, answer;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (seq[left] < 1 && seq[left + 1] < 1) {
                answer += seq[left] * seq[left + 1];
            } else {
                break;
            }
            left += 2;
        }

        while (left < right) {
            if (seq[right] > 1 && seq[right - 1] > 1) {
                answer += seq[right] * seq[right - 1];
            } else {
                break;
            }
            right -= 2;
        }

        while (left <= right){
            answer += seq[left++];
        }
        System.out.println(answer);
    }

}
