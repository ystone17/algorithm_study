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

    static String s;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            arr[num]++;
            total += num;
        }

        if (total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        if(arr[0] == 0){
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}
