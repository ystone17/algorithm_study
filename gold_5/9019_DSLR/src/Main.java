import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int tc, a, b;
    static Queue<Route> q = new LinkedList<>();
    static int[] visited = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            q.clear();
            visited = new int[10000];

            q.add(new Route(a, ""));
            visited[a] = 1;

            int sbLen = sb.length();
            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    Route curRoute = q.poll();

                    int d = D(curRoute.num);
                    if(d == b) {
                        sb.append(curRoute.route).append("D").append("\n");
                        break;
                    }
                    if(visited[d] != 1){
                        visited[d] = 1;
                        q.add(new Route(d, curRoute.route + "D"));
                    }

                    int s = S(curRoute.num);
                    if(s == b) {
                        sb.append(curRoute.route).append("S").append("\n");
                        break;
                    }
                    if(visited[s] != 1){
                        visited[s] = 1;
                        q.add(new Route(s, curRoute.route + "S"));
                    }

                    int l = L(curRoute.num);
                    if(l == b) {
                        sb.append(curRoute.route).append("L").append("\n");
                        break;
                    }
                    if(visited[l] != 1){
                        visited[l] = 1;
                        q.add(new Route(l, curRoute.route + "L"));
                    }

                    int r = R(curRoute.num);
                    if(r == b) {
                        sb.append(curRoute.route).append("R").append("\n");
                        break;
                    }
                    if(visited[r] != 1){
                        visited[r] = 1;
                        q.add(new Route(r, curRoute.route + "R"));
                    }

                }
                if(sbLen != sb.length()) break;
            }
        }

        System.out.println(sb);
    }

    static int D(int num){
        return num * 2 % 10000;
    }

    static int S(int num){
        return ((num - 1) + 10000) % 10000;
    }

    static int L(int num){
        int n = num * 10;
        return n / 10000 + n % 10000;
    }

    static int R(int num){
        int n = num / 10;
        int one = num % 10;
        return n + one * 1000;
    }

    static class Route{
        int num;
        String route;

        public Route(int num, String route) {
            this.num = num;
            this.route = route;
        }
    }

}
