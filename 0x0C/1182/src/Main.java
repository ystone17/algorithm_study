import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int hopeSum;
    static int[] numbers = new int[20];
    static int cnt;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        hopeSum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens()) {
            numbers[i++] = Integer.parseInt(st.nextToken());
        }

        partition(0, 0);
        System.out.println(cnt);
    }

    static void partition(int index, int total) {
        if (index == N) {
            if (total == hopeSum && size >0) {
                cnt++;
            }
            return;
        }

        partition(index + 1, total);
        total += numbers[index];
        size++;
        partition(index + 1, total);
        size--;

    }
}


