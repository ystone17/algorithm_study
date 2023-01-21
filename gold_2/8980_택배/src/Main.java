import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int townNum, truckCapacity, orderNum;
    static List<Order> orderList = new ArrayList<>();
    static int[] used;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        townNum = Integer.parseInt(st.nextToken());
        truckCapacity = Integer.parseInt(st.nextToken());

        orderNum = Integer.parseInt(br.readLine());

        used = new int[townNum + 1];

        for (int i = 0; i < orderNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            orderList.add(new Order(from, to, num));
        }

        orderList = orderList.stream().sorted((o1, o2) -> {
            if (o1.to != o2.to) return Integer.compare(o1.to, o2.to);
            return Integer.compare(o2.from, o1.from);
        }).collect(Collectors.toList());

        int res = 0;

        for (Order order : orderList) {
            int capacity = getCapacity(order);
            setCapacity(order, capacity);

            res += capacity;
        }

        System.out.println(res);
    }

    private static int getCapacity(Order order) {
        int min = 10_000;
        for (int i = order.from; i < order.to; i++) {
            int cap = Math.min(order.capacity, truckCapacity - used[i]);
            min = Math.min(cap, min);
        }

        return min;
    }

    private static void setCapacity(Order order, int capacity) {
        for (int i = order.from; i < order.to; i++) {
            used[i] += capacity;
        }
    }

    static class Order {
        int from;
        int to;
        int capacity;

        public Order(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }
    }
}
