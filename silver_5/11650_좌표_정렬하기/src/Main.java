import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Coordinate[] coors = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coors[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(coors);

        for (Coordinate coor : coors) {
            sb.append(coor.toString()).append("\n");
        }
        System.out.println(sb);

    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (x != o.x) {
                return x - o.x;
            } else {
                return y - o.y;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
