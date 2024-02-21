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
    static int[] used;
    static int n, k;
    static BigInteger res = BigInteger.ZERO;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        used = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            customers.add(new Customer(no, weight));
        }

        int time = 0;
        int counterNo = 0;
        for (Customer customer : customers) {
            if (pq.size() < k) {
                for (int i = 0; i < used.length; i++) {
                    if (used[i] == 0) {
                        pq.add(new Counter(customer.no, time + customer.weight, i));
                        used[i] = 1;
                        break;
                    }
                }
                continue;
            }

            time = pq.peek().cashTime;

            while (pq.peek().cashTime == time) {
                var counter = pq.poll();
                counterNo = counter.no;
                used[counterNo] = 0;
                seq.add(counter.customerNo);
            }

            pq.add(new Counter(customer.no, time + customer.weight, counterNo));
        }

        while (!pq.isEmpty()) {
            seq.add(pq.poll().customerNo);
        }


        for (int i = 0; i < seq.size(); i++) {
            Integer customerNo = seq.get(i);
            res = res.add(BigInteger.valueOf(customerNo).multiply(BigInteger.valueOf(i + 1)));
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
