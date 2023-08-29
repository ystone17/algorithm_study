import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Set<String> danceDance = new HashSet<>();
    static boolean isStart = false;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            if(p1.equals("ChongChong") || p2.equals("ChongChong")) {
                danceDance.add(p1);
                danceDance.add(p2);
                isStart = true;
            }

            if(isStart && (danceDance.contains(p1) || danceDance.contains(p2))) {
                danceDance.add(p1);
                danceDance.add(p2);
            }
        }

        System.out.println(danceDance.size());
    }
}
