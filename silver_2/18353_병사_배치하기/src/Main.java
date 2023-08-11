import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

//    7
//15 11 4 8 5 2 4

    static int n;
    static int[] attackAbilities, lds;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        attackAbilities = new int[n];
        lds = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            attackAbilities[i] = Integer.parseInt(st.nextToken());
        }

        int inputIdx = 0;
        lds[inputIdx] = attackAbilities[inputIdx];
        inputIdx++;
        for (int i = 1; i < n; i++) {
            if (lds[inputIdx - 1] > attackAbilities[i]) {
                lds[inputIdx++] = attackAbilities[i];
                continue;
            }

            int biIdx = binarySearchUpperBound(inputIdx, attackAbilities[i]);
            lds[biIdx] = attackAbilities[i];
        }

        System.out.println(n - inputIdx);
    }

    static int binarySearchUpperBound(int lastIdx, int target) {
        int left = 0;
        int right = lastIdx;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (lds[mid] >= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
