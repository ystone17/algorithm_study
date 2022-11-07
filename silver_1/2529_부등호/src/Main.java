import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int k;
    static String[] equalSigns;
    static int[] used = new int[10];
    static int[] answer;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        answer = new int[k + 1];
        equalSigns = new String[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            equalSigns[i] = st.nextToken();
        }

        max(0);
        sb.append("\n");
        used = new int[10];
        min(0);
        System.out.println(sb);
    }


    static boolean min(int idx) {
        if (idx > k) {
            for (int i : answer) {
                sb.append(i);
            }
            return true;
        }

        for (int i = 0; i < 10; i++) {
            if (used[i] == 1) continue;
            if (idx > 0 && equalSigns[idx - 1].equals(">") && answer[idx - 1] <= i) continue;
            if (idx > 0 && equalSigns[idx - 1].equals("<") && answer[idx - 1] >= i) continue;

            used[i] = 1;
            answer[idx] = i;
            if (min(idx + 1)) return true;
            used[i] = 0;
        }
        return false;
    }

    static boolean max(int idx) {
        if (idx > k) {
            for (int i : answer) {
                sb.append(i);
            }
            return true;
        }

        for (int i = 9; i >= 0; i--) {
            if (used[i] == 1) continue;
            if (idx > 0 && equalSigns[idx - 1].equals(">") && answer[idx - 1] <= i) continue;
            if (idx > 0 && equalSigns[idx - 1].equals("<") && answer[idx - 1] >= i) continue;

            used[i] = 1;
            answer[idx] = i;
            if (max(idx + 1)) return true;
            used[i] = 0;
        }
        return false;
    }

}
