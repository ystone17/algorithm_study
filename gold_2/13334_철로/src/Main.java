import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d;
    static List<Pos> posList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            posList.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(posList);

    }

    private static class Pos implements Comparable<Pos> {
        int left;
        int right;

        public Pos(int a, int b) {
            if (a < b) {
                this.left = a;
                this.right = b;
            } else {
                this.left = b;
                this.right = a;
            }
        }

        @Override
        public int compareTo(Pos o) {
            if (this.left != o.left) {
                return Integer.compare(this.left, o.left);
            }

            return Integer.compare(this.right, o.right);
        }
    }
}
