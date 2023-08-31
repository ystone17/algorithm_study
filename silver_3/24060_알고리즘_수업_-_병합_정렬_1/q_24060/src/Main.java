import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k, kCount = 1, res = -1;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, seq.length - 1);
        System.out.println(res);
    }

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        merge(start, middle, end);
    }

    private static void merge(int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int idx = start;
        int[] temp = new int[n];

        while (i <= middle && j <= end) {
            if (seq[i] <= seq[j]) {
                temp[idx++] = seq[i++];
                if (kCount++ == k) {
                    res = seq[i - 1];
                }
                continue;
            }

            temp[idx++] = seq[j++];
            if (kCount++ == k) {
                res = seq[j - 1];
            }
        }

        while (i <= middle) {
            temp[idx++] = seq[i++];
            if (kCount++ == k) {
                res = seq[i - 1];
            }
        }

        while (j <= end) {
            temp[idx++] = seq[j++];
            if (kCount++ == k) {
                res = seq[j - 1];
            }
        }

        for (int tempIdx = start; tempIdx <= end; tempIdx++) {
            seq[tempIdx] = temp[tempIdx];
        }
    }
}
