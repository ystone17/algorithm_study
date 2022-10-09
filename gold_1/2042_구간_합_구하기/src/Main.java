import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k;
    static long[] arr, partitionSum;
    static List<ChangeBlock> changeBlockList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        partitionSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            partitionSum[i] = partitionSum[i - 1] + arr[i];
        }

        long a, b, c, sum;
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeBlockList.add(new ChangeBlock(b, c - arr[(int) b]));
                arr[(int) b] = c;
            } else {
                sum = partitionSum[(int) c] - partitionSum[(int) (b - 1)];
                for (ChangeBlock changeBlock : changeBlockList) {
                    if (b <= changeBlock.idx && changeBlock.idx <= c) {
                        sum += changeBlock.num;
                    }
                }
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class ChangeBlock {
        long idx;
        long num;

        public ChangeBlock(long idx, long num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
