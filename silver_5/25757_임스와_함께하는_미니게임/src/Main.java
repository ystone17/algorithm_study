import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, res;
    static String game;
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        game = st.nextToken();

        if (game.equals("Y")) {
            m = 1;
        } else if (game.equals("F")) {
            m = 2;
        } else {
            m = 3;
        }


        var count = 0;
        for (int i = 0; i < n; i++) {
            var s = br.readLine();

            if (map.containsKey(s)) {
                continue;
            }

            map.put(s, true);
            count++;
            if (count == m) {
                res++;
                count = 0;
            }
        }

        if (count == m) {
            res++;
        }
        System.out.println(res);
    }
}
