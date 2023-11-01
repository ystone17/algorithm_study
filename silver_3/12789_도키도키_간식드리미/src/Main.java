import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(simulate() ? "Nice" : "Sad");
    }

    static boolean simulate() {
        int target = 1;

        while (!q.isEmpty() || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
                continue;
            }

            while (!q.isEmpty() && q.peek() != target) {
                stack.add(q.poll());
            }

            if (q.isEmpty()) {
                return false;
            }

            q.poll();
            target++;
        }

        return true;
    }
}
