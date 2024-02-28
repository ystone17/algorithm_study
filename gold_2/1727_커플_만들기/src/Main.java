import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<Integer> men = new ArrayList<>();
    static List<Integer> women = new ArrayList<>();
    static List<Integer> smallList;
    static Queue<Integer> q = new LinkedList<>();

    static int man, woman, res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        man = Integer.parseInt(st.nextToken());
        woman = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < man; i++) {
            men.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < woman; i++) {
            women.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(men);
        Collections.sort(women);
        if (man < woman) {
            smallList = men;
            q.addAll(women);
        } else {
            smallList = women;
            q.addAll(men);
        }

        for (int i = 0; i < smallList.size(); i++) {
            Integer s = smallList.get(i);

            if (smallList.size() - i == q.size()) {
                res += Math.abs(s - q.poll());
                continue;
            }

            var temp = 0;
            while (!q.isEmpty()) {
                temp = q.poll();
                if (smallList.size() - i > q.size()) {
                    break;
                }

                if (Math.abs(s - temp) <= Math.abs(s - q.peek())) {
                    break;
                }
            }

            res += Math.abs(s - temp);
        }

        System.out.println(res);

    }
}
