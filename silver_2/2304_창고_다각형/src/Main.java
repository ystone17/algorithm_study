import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static List<Stick> stickList = new ArrayList<>();
    static List<Stick> sort = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stickList.add(new Stick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(stickList);

        sort.add(stickList.get(0));
        for (int i = 1; i < n; i++) {
            boolean left = false;
            boolean right = false;

            for (int j = 0; j < i; j++) {
                if (stickList.get(j).h > stickList.get(i).h) {
                    left = true;
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (stickList.get(j).h > stickList.get(i).h) {
                    right = true;
                    break;
                }
            }
            if (left && right) continue;
            sort.add(stickList.get(i));
        }

        for (int i = 0; i < sort.size() - 1; i++) {
            if (sort.get(i).h < sort.get(i + 1).h) {
                res += sort.get(i).h * (sort.get(i + 1).x - sort.get(i).x);
            } else {
                res += sort.get(i).h;
                res += sort.get(i + 1).h * (sort.get(i + 1).x - sort.get(i).x - 1);
            }
        }

        res += sort.get(sort.size() - 1).h;
        System.out.println(res);
    }

    static class Stick implements Comparable<Stick> {
        int x;
        int h;

        public Stick(int x, int h) {
            this.x = x;
            this.h = h;
        }

        @Override
        public int compareTo(Stick o) {
            return Integer.compare(x, o.x);
        }
    }
}
