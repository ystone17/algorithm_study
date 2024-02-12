import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static PriorityQueue<Counter> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.cashTime != o2.cashTime) {
            return Integer.compare(o1.cashTime, o2.cashTime);
        }

        return Integer.compare(o1.no, o2.no);
    });
    static Stack<Counter> stack = new Stack<>();
    static int n, k, count = 1;
    static BigInteger res = BigInteger.ZERO;
    static boolean[] counterUsed;
    static int[] times;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        counterUsed = new boolean[n + 1];
        times = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int customerNo = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (pq.size() < k) {
                for (int j = 1; j < counterUsed.length; j++) {
                    if (!counterUsed[j]) {
                        pq.add(new Counter(j, customerNo, times[j] + weight));
                        times[j] += weight;
                        counterUsed[j] = true;
                        break;
                    }
                }
                continue;
            }

            var targetCounter = pq.poll();
            stack.add(targetCounter);
            while (!pq.isEmpty() && pq.peek().cashTime == targetCounter.cashTime) {
                stack.add(pq.poll());
            }

            while (!stack.isEmpty()) {
                var pop = stack.pop();
                res = res.add(BigInteger.valueOf(pop.customerNo).multiply(BigInteger.valueOf(count++)));
                counterUsed[pop.no] = false;
            }

            pq.add(new Counter(targetCounter.no, customerNo, times[targetCounter.no] + weight));
            counterUsed[targetCounter.no] = true;
            times[targetCounter.no] += weight;
        }


        while (!pq.isEmpty()) {
            var targetCounter = pq.poll();
            stack.add(targetCounter);
            while (!pq.isEmpty() && pq.peek().cashTime == targetCounter.cashTime) {
                stack.add(pq.poll());
            }

            while (!stack.isEmpty()) {
                var pop = stack.pop();
                res = res.add(BigInteger.valueOf(pop.customerNo).multiply(BigInteger.valueOf(count++)));
                counterUsed[pop.no] = false;
            }
        }

        System.out.println(res);
    }

    static class Counter {
        int no;
        int customerNo;
        int cashTime;

        public Counter(int no, int customerNo, int cashTime) {
            this.no = no;
            this.customerNo = customerNo;
            this.cashTime = cashTime;
        }

        @Override
        public String toString() {
            return "Counter{" +
                    "no=" + no +
                    ", customerNo=" + customerNo +
                    ", cashTime=" + cashTime +
                    '}';
        }
    }
}
