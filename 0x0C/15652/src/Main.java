import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[m];

        print(0, 1);
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(int index, int start) throws IOException {
        if (index == m) {
            for (int num : res) {
                bw.write(Integer.toString(num));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i <= n; i++) {
            res[index] = i;
            print(index + 1, i);
        }
    }
}
