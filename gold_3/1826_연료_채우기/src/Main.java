import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int stationNum, goal;
    static Station now;
    static PriorityQueue<Station> stations = new PriorityQueue<>();
    static PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        stationNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < stationNum; i++) {
            st = new StringTokenizer(br.readLine());
            stations.add(new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        goal = Integer.parseInt(st.nextToken());
        now = new Station(Integer.parseInt(st.nextToken()), 0);
        int answer = 0;

        while (now.x < goal) {
            while (!stations.isEmpty() && stations.peek().x <= now.x) {
                fuels.add(stations.poll().fuel);
            }

            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            answer++;
            now.x += fuels.poll();
        }

        System.out.println(answer);


    }

    private static class Station implements Comparable<Station> {
        int x;
        int fuel;

        public Station(int x, int fuel) {
            this.x = x;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(Station o) {
            return Integer.compare(x, o.x);
        }
    }
}
