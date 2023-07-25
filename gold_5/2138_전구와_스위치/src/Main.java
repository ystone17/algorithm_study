import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] goal;
    static int[] initialState;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        goal = new int[n];
        initialState = new int[n];

        int idx = 0;
        for (char c : br.readLine().toCharArray()) {
            goal[idx++] = c - '0';
        }

        idx = 0;
        for (char c : br.readLine().toCharArray()) {
            initialState[idx++] = c - '0';
        }

        int res = Integer.MAX_VALUE;
        res = Math.min(res, solve(true));
        res = Math.min(res, solve(false));

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    static int solve(boolean firstMatch) {
        int[] state = Arrays.copyOf(initialState, n);
        int count = 0;
        int idx = 1;

        if (firstMatch) {
            if (state[0] != goal[0]) {
                changeSwitch(state, 0);
                count++;
            }

            idx = 2;
        } else {
            if (state[0] == goal[0]) {
                changeSwitch(state, 0);
                count++;
            }
        }

        for (; idx < n; idx++) {
            if (state[idx - 1] != goal[idx - 1]) {
                changeSwitch(state, idx);
                count++;
            }
        }

        return state[n - 1] == goal[n - 1] ? count : Integer.MAX_VALUE;
    }

    static void changeSwitch(int[] state, int idx) {
        if (idx - 1 >= 0) {
            state[idx - 1] = (state[idx - 1] + 1) % 2;
        }

        state[idx] = (state[idx] + 1) % 2;

        if (idx + 1 < n) {
            state[idx + 1] = (state[idx + 1] + 1) % 2;
        }
    }
}
