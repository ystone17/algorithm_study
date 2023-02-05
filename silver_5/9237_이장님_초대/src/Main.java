import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] babyTree;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        babyTree = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            babyTree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(babyTree);

        int day = 0;
        for (int i = 1; i <= n; i++) {
            day = Math.max(day, i + babyTree[n - i]);
        }

        System.out.println(day + 1);
    }
}
