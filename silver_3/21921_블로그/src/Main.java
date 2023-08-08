import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, x;
    static int[] visitCounts, partSums;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        visitCounts = new int[n + 1];
        partSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visitCounts[i] = Integer.parseInt(st.nextToken());
            partSums[i] = partSums[i - 1] + visitCounts[i];
        }

        int max = 0;
        int maxCount = 0;
        for (int i = 0; i <= n - x; i++) {
            int temp = partSums[i + x] - partSums[i];
            if (max < temp) {
                max = temp;
                maxCount = 1;
                continue;
            }

            if (max == temp) {
                maxCount++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCount);
    }
}
