import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        String[] s = set.toArray(new String[0]);
        Arrays.sort(s, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            } else{
                return o1.length() - o2.length();
            }
        });

        for (String s1 : s) {
            sb.append(s1).append("\n");
        }

        System.out.println(sb);

    }
}
