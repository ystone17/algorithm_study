import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, total;
    static Quest[] quests;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        quests = new Quest[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            quests[i] = new Quest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(quests);

        for (Quest quest : quests) {

            pq.add(quest.result);
            if (pq.size() > quest.deadline) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        sb.append(total);
        System.out.println(sb);
    }

    static class Quest implements Comparable<Quest> {
        int deadline;
        int result;

        public Quest(int deadline, int result) {
            this.deadline = deadline;
            this.result = result;
        }

        @Override
        public int compareTo(Quest o) {
            return Integer.compare(deadline, o.deadline);
        }
    }
}
