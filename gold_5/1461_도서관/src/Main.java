import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] arr;
    static Deque<Integer> left = new LinkedList<>();
    static Deque<Integer> right = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i : arr) {
            if (i < 0) {
                left.add(i);
            } else {
                right.add(i);
            }
        }

        int sum = init();

        while (!left.isEmpty()) {
            sum += Math.abs(left.peekFirst() * 2);
            for (int i = 0; i < m && !left.isEmpty(); i++) {
                left.pollFirst();
            }
        }

        while (!right.isEmpty()) {
            sum += Math.abs(right.peekLast() * 2);
            for (int i = 0; i < m && !right.isEmpty(); i++) {
                right.pollLast();
            }
        }

        System.out.println(sum);
    }

    private static int init() {
        int sum = 0;
        if (left.isEmpty()) {
            sum += Math.abs(right.peekLast());
            for (int i = 0; i < m && !right.isEmpty(); i++) {
                right.pollLast();
            }
        } else if (right.isEmpty()) {
            sum += Math.abs(left.peekFirst());
            for (int i = 0; i < m && !left.isEmpty(); i++) {
                left.pollFirst();
            }
        } else {
            if (Math.abs(left.peekFirst()) > Math.abs(right.peekLast())) {
                sum += Math.abs(left.peekFirst());
                for (int i = 0; i < m && !left.isEmpty(); i++) {
                    left.pollFirst();
                }
            } else {
                sum += Math.abs(right.peekLast());
                for (int i = 0; i < m && !right.isEmpty(); i++) {
                    right.pollLast();
                }
            }
        }
        return sum;
    }
}
