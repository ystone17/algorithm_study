import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int length, width, height, n, res;
    static int[] cubeCounts = new int[20];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            cubeCounts[idx] = count;
        }

        System.out.println(solve(length, width, height) ? res : -1);
    }

    static boolean solve(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) {
            return true;
        }


        int cubeLength = -1;
        for (int i = cubeCounts.length - 1; i >= 0; i--) {
            if (cubeCounts[i] == 0) {
                continue;
            }

            cubeLength = 1 << i;
            if (cubeLength > l || cubeLength > w || cubeLength > h) {
                cubeLength = -1;
                continue;
            }

            cubeCounts[i]--;
            res++;
            break;
        }

        if (cubeLength == -1) {
            return false;
        }
        return solve(l - cubeLength, w, cubeLength)
                && solve(cubeLength, w - cubeLength, cubeLength)
                && solve(l, w, h - cubeLength);
    }
}
