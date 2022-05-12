import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[] pokemonName;
    static Map<String, Integer> pokemonNumber = new HashMap<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pokemonName = new String[n + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            pokemonName[i + 1] = s;
            pokemonNumber.put(s, i + 1);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            Integer num = pokemonNumber.get(s);
            if(num == null){
                sb.append(pokemonName[Integer.parseInt(s)]).append("\n");
            } else{
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);

    }
}
