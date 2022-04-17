import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int s;
    static Queue<State> q = new LinkedList<>();
    static int[][] visited = new int[10000][10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());


        q.add(new State(1, 0, 0));
        visited[1][0] = 1;

        while (!q.isEmpty()) {
            State curState = q.poll();
            if (curState.total == s) {
                System.out.println(curState.time);
                return;
            }

            if (curState.clipboard != 0 && visited[curState.total + curState.clipboard][curState.clipboard] == 0) {
                q.add(new State(curState.total + curState.clipboard, curState.clipboard, curState.time + 1));
                visited[curState.total + curState.clipboard][curState.clipboard] = 1;
            }

            if (curState.total > curState.clipboard) {
                q.add(new State(curState.total, curState.total, curState.time + 1));
            }

            if (curState.total > 0 && visited[curState.total - 1][curState.clipboard] == 0) {
                q.add(new State(curState.total - 1, curState.clipboard, curState.time + 1));
                visited[curState.total - 1][curState.clipboard] = 1;
            }
        }


    }

    static class State {
        int total;
        int clipboard;
        int time;

        public State(int total, int clipboard, int time) {
            this.total = total;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
