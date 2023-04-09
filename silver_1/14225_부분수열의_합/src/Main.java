import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    static int[] isCalc = new int[2000001];
    static int[] number = new int[20];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        number = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        init(0, number.length, 0);

        for (int i = 1; i < isCalc.length; i++) {
            if(isCalc[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    static void init(int idx, int size, int value) {
        if(idx >= size) {
            isCalc[value] = 1;
            return;
        }

        init(idx + 1, size, value);
        init(idx + 1, size, value + number[idx]);
    }
}
