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

    static int n;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Integer cnt = map.getOrDefault(s, 0);
            map.put(s, cnt + 1);
        }

        int max = 0;
        String maxS = "";
        for (String s : map.keySet()) {
            if(map.get(s) > max) {
                max = map.get(s);
                maxS = s;
            } else if( map.get(s) == max) {
                 if(maxS.compareTo(s) > 0) {
                     maxS = s;
                 }
            }
        }

        System.out.println(maxS);
    }
}
