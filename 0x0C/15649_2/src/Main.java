import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] arr, use;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        use = new int[n + 1];
        make(0);
        bw.flush();
        bw.close();
    }

    static void make(int index) throws IOException {
        if (index == m) {
            for (int num : arr) {
                bw.write(num + 48);
                bw.write(' ');
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (use[i] != 1){
                use[i] = 1;
                arr[index] = i;
                make(index + 1);
                use[i] = 0;
            }
        }

    }
}
