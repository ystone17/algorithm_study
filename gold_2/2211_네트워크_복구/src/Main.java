import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int comNum, lineNum;
    static List<List<Line>> graph = new ArrayList<>();
    static List<List<Line>> route = new ArrayList<>();
    static PriorityQueue<Line> pq = new PriorityQueue<>();
    static Set<Line> set = new HashSet<>();
    static boolean[] finish;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        comNum = Integer.parseInt(st.nextToken());
        lineNum = Integer.parseInt(st.nextToken());

        finish = new boolean[comNum + 1];
        dist = new int[comNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i <= comNum; i++) {
            graph.add(new ArrayList<>());
            route.add(new ArrayList<>());
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Line(from, to, weight));
            graph.get(to).add(new Line(to, from, weight));
        }

        pq.add(new Line(1, 1, 0));

        while (!pq.isEmpty()) {
            Line cur = pq.poll();

            if (finish[cur.to]) continue;
            finish[cur.to] = true;

            for (Line next : graph.get(cur.to)) {
                if (finish[next.to]) continue;
                if (dist[next.to] > dist[next.from] + next.weight) {
                    dist[next.to] = dist[next.from] + next.weight;
                    route.get(next.to).clear();
                    route.get(next.to).addAll(route.get(next.from));
                    route.get(next.to).add(next);
                    pq.add(new Line(next.from, next.to, dist[next.to]));
                }
            }
        }

        for (List<Line> lineList : route) {
            set.addAll(lineList);
        }

        System.out.println(set.size());
        for (Line line : set) {
            if (line.weight == 0) continue;
            sb.append(line.from).append(" ").append(line.to).append("\n");
        }
        System.out.println(sb);


    }

    static class Line implements Comparable<Line> {
        int from;
        int to;
        int weight;

        public Line(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return from == line.from && to == line.to && weight == line.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, weight);
        }
    }
}
