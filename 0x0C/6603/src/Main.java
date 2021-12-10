import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k;
    static int[] input;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            input = new int[k];
            int index = 0;
            while (st.hasMoreTokens()) {
                input[index++] = Integer.parseInt(st.nextToken());
            }

            lotto(0, 0, "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void lotto(int index, int start, String numbers) throws IOException {
        if (index == 6) {
            bw.write(numbers);
            bw.newLine();
            return;
        }

        for (int i = start; i < k; i++) {
            lotto(index + 1, i + 1, numbers + input[i] + " ");
        }
    }
}
