import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map = new int[7][7];

    public static void main(String[] args) throws IOException {
        var startV = -1;
        var startH = -1;
        var endV = -1;
        var endH = -1;
        var beforeV = -1;
        var beforeH = -1;

        for (int i = 0; i < 36; i++) {
            var s = br.readLine();

            var v = s.charAt(0) - 'A';
            var h = s.charAt(1) - '1';

            if (i == 0) {
                startV = v;
                startH = h;
            }
            if (i == 35) {
                endV = v;
                endH = h;
            }

            if (i != 0) {
                if (!(Math.abs(beforeV - v) == 1 && Math.abs(beforeH - h) == 2
                        || Math.abs(beforeV - v) == 2 && Math.abs(beforeH - h) == 1)) {
                    System.out.println("Invalid");
                    return;
                }
            }


            if (map[v][h] >= 1) {
                System.out.println("Invalid");
                return;
            }

            map[v][h] = 1;
            beforeV = v;
            beforeH = h;
        }

        if (!(Math.abs(startV - endV) == 1 && Math.abs(startH - endH) == 2
                || Math.abs(startV - endV) == 2 && Math.abs(startH - endH) == 1)) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }
}
