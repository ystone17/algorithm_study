import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static BufferedWriter bw;
    static int[] res, used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        used = new int[n+1];
        print(0, 1);
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(int index, int start) throws IOException {
        if(index == m){
            for (int num : res) {
                bw.write(Integer.toString(num));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i <= n; i++) {
            if(used[i] == 1){
                continue;
            }

            used[i] = 1;
            res[index] = i;
            print(index + 1, i + 1);
            used[i] = 0;
        }
    }
}
