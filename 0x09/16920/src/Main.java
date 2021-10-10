import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        Node[][] visited = new Node[N][M];
        int[] pMove = new int[P + 1];
        int[] res = new int[P + 1];
        Queue<Node> q = new LinkedList<>();
        Queue<Node> tempQ = new LinkedList<>();
        List<Node> tempList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            pMove[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
                if (line[j] != '.' && line[j] != '#') {
                    tempList.add(new Node(i, j, line[j] - '0', 0));
                    visited[i][j] = new Node(i, j, line[j] - '0', 0);
                    res[line[j] - '0']++;
                }
            }
        }

        Collections.sort(tempList);

        for (Node node : tempList) {
            q.offer(node);
        }


        //로직
        int[] dn = {-1, 0, 1, 0};
        int[] dm = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node now = q.poll();

            tempQ.offer(now);
            int MaxMoveCount = pMove[now.p];
            while (!tempQ.isEmpty()) {
                Node tempNow = tempQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nextN = tempNow.n + dn[j];
                    int nextM = tempNow.m + dm[j];

                    // 맵 바깥
                    if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) {
                        continue;
                    }

                    // 벽
                    if (board[nextN][nextM] == '#') continue;

                    // 숫자
                    if (visited[nextN][nextM] != null) {

                        // 다른 숫자 일 경우
                        if (visited[nextN][nextM].p != tempNow.p) continue;

                        // 같은 숫자지만 이동횟수가 더 적을 경우
                        if (visited[nextN][nextM].p == tempNow.p && visited[nextN][nextM].moveCnt <= tempNow.moveCnt + 1) continue;
                    }

                    if (visited[nextN][nextM] == null)
                        res[tempNow.p]++;

                    if (tempNow.moveCnt + 1 == MaxMoveCount) {
                        q.offer(new Node(nextN, nextM, tempNow.p, 0));
                    } else {
                        tempQ.offer(new Node(nextN, nextM, tempNow.p, tempNow.moveCnt + 1));
                    }
                    visited[nextN][nextM] = new Node(nextN, nextM, tempNow.p, tempNow.moveCnt + 1);


                }

            }


        }


        for (int i = 1; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }

    }

    static class Node implements Comparable<Node> {
        int n;
        int m;
        int p;
        int moveCnt;

        public Node(int n, int m, int p, int moveCnt) {
            this.n = n;
            this.m = m;
            this.p = p;
            this.moveCnt = moveCnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.p < o.p) {
                return -1;
            } else if (this.p > o.p) {
                return 1;
            }
            return 0;
        }
    }
}
