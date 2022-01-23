import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, w, l;
    static int[] carWeight;
    static Queue<Truck> q = new LinkedList<>();
    static int totalWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        carWeight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            carWeight[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int carNum = 0;

        while (true) {
            time++;
            if (!q.isEmpty() && q.peek().outTime == time) {
                Truck t = q.poll();
                totalWeight -= t.weight;
            }

            if (carNum == n) {
                if (q.isEmpty()) {
                    break;
                } else {
                    continue;
                }
            }

            if (q.size() == w) continue;
            if (totalWeight + carWeight[carNum] > l) continue;

            q.add(new Truck(carWeight[carNum], time + w));
            totalWeight += carWeight[carNum++];

        }

        System.out.println(time);
    }

    static class Truck {
        int weight;
        int outTime;

        public Truck(int weight, int outTime) {
            this.weight = weight;
            this.outTime = outTime;
        }
    }
}
