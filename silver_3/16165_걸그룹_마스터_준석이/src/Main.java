import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static Map<String, GirlGroup> girlGroupMap = new HashMap<>();
    static Map<String, String> memberNameMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            GirlGroup girlGroup = new GirlGroup(br.readLine());
            int memberCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCount; j++) {
                girlGroup.memberNames.add(br.readLine());
            }
            Collections.sort(girlGroup.memberNames);
            girlGroupMap.put(girlGroup.name, girlGroup);

            for (String memberName : girlGroup.memberNames) {
                memberNameMap.put(memberName, girlGroup.name);
            }
        }

        for (int i = 0; i < m; i++) {
            String keyword = br.readLine();
            int qType = Integer.parseInt(br.readLine());

            if (qType == 0) {
                for (String memberName : girlGroupMap.get(keyword).memberNames) {
                    sb.append(memberName).append("\n");
                }
            } else {
                sb.append(memberNameMap.get(keyword)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static class GirlGroup {
        String name;
        List<String> memberNames = new ArrayList<>();

        public GirlGroup(String name) {
            this.name = name;
        }
    }
}
