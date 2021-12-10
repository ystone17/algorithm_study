import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] input, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        input = new int[n];


        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            input[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        print(0);
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(int index) throws IOException {
        if (index == m) {
            for (int num : res) {
                bw.write(Integer.toString(num));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for (int inputIndex = 0; inputIndex < n; inputIndex++) {
            res[index] = input[inputIndex];
            print(index + 1);
        }
    }
}
