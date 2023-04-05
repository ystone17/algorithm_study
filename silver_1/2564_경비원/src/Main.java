import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x, n, total;
    static Pos[] posSeq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());

        posSeq = new Pos[n + 1];
        for (int i = 0; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            posSeq[i] = new Pos(dir, dist);
        }

        for (int i = 0; i < n; i++) {
            total += getMin(posSeq[posSeq.length - 1], posSeq[i]);
        }

        System.out.println(total);
    }

    static int getMin(Pos source, Pos target) {
        if (source.dir == target.dir) {
            return Math.abs(source.dist - target.dist);
        }

        if (Math.abs(source.dir - target.dir) == 1 && source.dir + target.dir != 5) {
            int base = source.dir + target.dir == 3 ? x : y;
            int another = source.dir + target.dir == 3 ? y : x;

            return Math.min(source.dist + target.dist, 2 * base - source.dist - target.dist) + another;
        }

        int sy = getY(source);
        int sx = getX(source);
        int ty = getY(target);
        int tx = getX(target);

        return Math.abs(sy - ty) + Math.abs(sx - tx);
    }

    static int getY(Pos p) {
        switch (p.dir) {
            case 1:
                return 0;
            case 2:
                return y;
            case 3:
            case 4:
                return p.dist;
        }

        return 0;
    }

    static int getX(Pos p) {
        switch (p.dir) {
            case 1:
            case 2:
                return p.dist;
            case 3:
                return 0;
            case 4:
                return x;
        }

        return 0;
    }


    static class Pos {
        int dir;
        int dist;

        public Pos(int dir, int dist) {
            this.dir = dir;
            this.dist = dist;
        }
    }
}
