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

    static int n, res;
    static Map<String, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String chat = br.readLine();

            if(chat.equals("ENTER")) {
                map.clear();
                continue;
            }

            if(map.containsKey(chat)) {
                continue;
            }

            map.put(chat, ' ');
            res++;
        }

        System.out.println(res);
    }
}
