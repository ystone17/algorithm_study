import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, s, res;
    static int[] arr;

    static int cc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        part(0, 0, 0);
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }

    static void part(int count, int sum, int size) {
        if (count == n) {
            if (sum == s && size != 0) res++;
            return;
        }

        part(count + 1, sum + arr[count], size + 1);
        part(count + 1, sum, size);
    }
}
