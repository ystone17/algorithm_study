import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] lake;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<node> q = new LinkedList<>();
        Queue<node> waterQ = new LinkedList<>();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        lake = new char[r][c];
        visited = new boolean[r][c];
        node swan = null;

        for (int i = 0; i < r; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                lake[i][j] = input[j];
                if (input[j] == 'L') {
                    swan = new node(i, j);
                }

                if (input[j] != 'X') {
                    waterQ.offer(new node(i, j));
                }
            }
        }

        q.offer(swan);
        visited[swan.r][swan.c] = true;

        int cnt = 0;
        boolean isContact = false;

        while (true) {
            Queue<node> nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                node nNode = q.poll();
                int nowR = nNode.r;
                int nowC = nNode.c;


                for (int i = 0; i < 4; i++) {
                    int nextR = nowR + dr[i];
                    int nextC = nowC + dc[i];

                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) {
                        continue;
                    }

                    if (visited[nextR][nextC]) {
                        continue;
                    }

                    if (lake[nextR][nextC] == 'L') {
                        isContact = true;
                        break;
                    }

                    visited[nextR][nextC] = true;

                    if (lake[nextR][nextC] == 'X') {
                        nextQ.offer(new node(nextR, nextC));
                        continue;
                    }

                    q.offer(new node(nextR, nextC));


                }
                if (isContact) break;
            }



            int size = waterQ.size();
            if (isContact) {
                break;
            }

            for (int a = 0; a < size; a++) {
                node nw = waterQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nextR = nw.r + dr[i];
                    int nextC = nw.c + dc[i];

                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) {
                        continue;
                    }

                    if (lake[nextR][nextC] == 'X') {
                        lake[nextR][nextC] = '.';
                        waterQ.offer(new node(nextR, nextC));
                    }
                }
            }

            q.clear();
            q = nextQ;

            cnt++;
        }
        System.out.println(cnt);
    }



    private static class node {
        int r;
        int c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

}
