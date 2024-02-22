import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static PriorityQueue<Counter> pq = new PriorityQueue<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Integer> seq = new ArrayList<>();
    static Stack<Integer> used = new Stack<>();
    static int n, k;
    static long res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            customers.add(new Customer(no, weight));
        }

        for (int i = k - 1; i >= 0; i--) {
            used.add(i);
        }

        int time = 0;
        for (Customer customer : customers) {
            if (pq.size() < k) {
                var nextCounterNo = used.pop();
                pq.add(new Counter(customer.no, time + customer.weight, nextCounterNo));
                continue;
            }

            time = pq.peek().cashTime;

            while (!pq.isEmpty() && pq.peek().cashTime == time) {
                var counter = pq.poll();
                used.add(counter.no);
                seq.add(counter.customerNo);
            }

            var nextCounterNo = used.pop();
            pq.add(new Counter(customer.no, time + customer.weight, nextCounterNo));
        }

        while (!pq.isEmpty()) {
            seq.add(pq.poll().customerNo);
        }

        for (int i = 0; i < seq.size(); i++) {
            res += (long) (seq.get(i)) * (i + 1);
        }

        System.out.println(res);
    }

    static class Counter implements Comparable<Counter> {
        int customerNo;
        int cashTime;
        int no;

        public Counter(int customerNo, int cashTime, int no) {
            this.customerNo = customerNo;
            this.cashTime = cashTime;
            this.no = no;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.cashTime != o.cashTime) {

                return Integer.compare(this.cashTime, o.cashTime);
            }

            return Integer.compare(o.no, this.no);
        }
    }

    static class Customer {
        int no;
        int weight;

        public Customer(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }
}
