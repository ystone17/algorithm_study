import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //    static int[][] bridge;
    static Map<Integer, Integer> bridge = new HashMap<>();
    static int n, m, h;
    static List<Integer> opt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;

            bridge.put(getPoint(a, b), getPoint(a, b + 1));
            bridge.put(getPoint(a, b + 1), getPoint(a, b));
        }

        if(sadari()){
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            boolean solve = solve(i, 0);
            if(solve){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    private static boolean solve(int depth, int start) {
        if (depth == 0) {

            for (Integer integer : opt) {
                bridge.put(integer, integer + 1);
                bridge.put(integer + 1, integer);
            }

            boolean sadari = sadari();

            for (Integer integer : opt) {
                bridge.remove(integer);
                bridge.remove(integer + 1);
            }

            return sadari;

        }

        for (int i = start; i < n * h; i++) {
            if (i % n == n - 1)
                continue;

            if (bridge.get(i) != null || bridge.get(i+ 1) != null) {
                continue;
            }
            opt.add(i);
            boolean solve = solve(depth - 1, i + 1);
            if (solve) {
                return  true;
            }
            opt.remove(opt.size() - 1);
        }
        return false;
    }


    private static int getPoint(int y, int x) {
        return (y * n) + x;
    }

    static boolean sadari() {
        int start;

        for (int x = 0; x < n; x++) {
            start = x;

            for (int y = 0; y < h; y++) {
                Integer next = bridge.get(getPoint(y, start));
                if (next == null)
                    continue;
                start = next % n;
            }
            if (start != x)
                return false;
        }
        return true;
    }

}
