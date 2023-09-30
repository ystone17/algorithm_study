import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s;
        int n;
        int[] seq;
        while ((s = br.readLine()) != null) {
            n = Integer.parseInt(s.trim());
            seq = new int[n];

            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(lis(seq)).append("\n");
        }

        System.out.println(sb);
    }

    private static int lis(int[] seq) {
        int[] lis = new int[seq.length];
        int lisLastIdx = 0;

        lis[lisLastIdx] = seq[lisLastIdx];

        for (int i = 1; i < seq.length; i++) {
            if (lis[lisLastIdx] < seq[i]) {
                lis[++lisLastIdx] = seq[i];
                continue;
            }

            lis[binarySearch(lis, seq[i], lisLastIdx)] = seq[i];
        }

        return lisLastIdx + 1;
    }

    private static int binarySearch(int[] lis, int value, int lastIdx) {
        int mid;
        int left = 0;
        int right = lastIdx + 1;

        while (left < right) {
            mid = (left + right) / 2;

            if (lis[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
