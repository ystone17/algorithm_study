import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int soundNum, platNum, count;
    static List<Stack<Integer>> fingerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        soundNum = Integer.parseInt(st.nextToken());
        platNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 6; i++) {
            fingerList.add(new Stack<>());
        }

        for (int i = 0; i < soundNum; i++) {
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            solve(f, p);
        }

        System.out.println(count);
    }

    static void solve(int f, int p) {
        Stack<Integer> finger = fingerList.get(f);

        while (!finger.isEmpty() && finger.peek() > p) {
            finger.pop();
            count++;
        }

        if (finger.isEmpty() || finger.peek() < p) {
            finger.push(p);
            count++;
        }
    }
}
