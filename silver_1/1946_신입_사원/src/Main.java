import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int tc;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            List<Emp> empList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                empList.add(new Emp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(empList);
            int max = empList.get(0).second;
            int answer = 1;
            for (int i = 1; i < empList.size(); i++) {
                Emp emp = empList.get(i);
                if (emp.second < max) {
                    answer++;
                    max = emp.second;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Emp implements Comparable<Emp> {
        int first;
        int second;

        public Emp(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Emp o) {
            return first - o.first;
        }
    }
}
