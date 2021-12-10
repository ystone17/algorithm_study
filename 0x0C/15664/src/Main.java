import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] input, used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        used = new int[n];

        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            input[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        print(0, 0,"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(int index, int start, String res) throws IOException {
        if (index == m) {
            bw.write(res);
            bw.write("\n");
            return;
        }

        int record = -1;

        for (int inputIndex = start; inputIndex < n; inputIndex++) {
            if (used[inputIndex] == 1 || record == input[inputIndex]) {
                continue;
            }
            used[inputIndex] = 1;
            record = input[inputIndex];
            print(index + 1, inputIndex + 1, res + input[inputIndex] + " ");
            used[inputIndex] = 0;
        }
    }
}
