import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Shark[][] board;
    static int y, x, sharkNum, answer, targetY = 1000;
    static Queue<Shark> q = new LinkedList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        sharkNum = Integer.parseInt(st.nextToken());
        board = new Shark[y][x];

        for (int i = 0; i < sharkNum; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            switch (d) {
                case 1:
                    d = 0;
                    break;
                case 4:
                    d = 1;
                    break;
            }
            int w = Integer.parseInt(st.nextToken());

            board[y][x] = new Shark(y, x, s, d, w);
            if (x == 0 && targetY > y) targetY = y;
        }

        for (int round = 0; round < x; round++) {

            if(targetY != 1000 && board[targetY][round] != null) {
                answer += board[targetY][round].weight;
                board[targetY][round] = null;
            }
            targetY = 1000;

            for (int yi = 0; yi < y; yi++) {
                for (int xi = 0; xi < x; xi++) {
                    if (board[yi][xi] != null) {
                        q.add(board[yi][xi]);
                        board[yi][xi] = null;
                    }
                }
            }

            while (!q.isEmpty()) {
                Shark cShark = q.poll();

                int ny = cShark.y;
                int nx = cShark.x;
                int nDir = cShark.dir;
                int nSpeed = cShark.speed;

                if(nDir % 2 == 0){
                    nSpeed %= (y - 1) * 2;
                } else{
                    nSpeed %= (x - 1) * 2;
                }

                for (int i = 0; i < nSpeed; i++) {
                    ny += dy[nDir];
                    nx += dx[nDir];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) {
                        nDir = (nDir + 2) % 4;
                        ny += dy[nDir] * 2;
                        nx += dx[nDir] * 2;
                    }
                }

                if (board[ny][nx] == null || board[ny][nx].weight < cShark.weight) {
                    board[ny][nx] = new Shark(ny, nx, cShark.speed, nDir, cShark.weight);
                    if (nx == round+1 && targetY > ny) targetY = ny;
                }

            }


        }
        System.out.println(answer);
    }


    // (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다
    static class Shark {
        int y;
        int x;
        int speed;
        int dir;
        int weight;

        public Shark(int y, int x, int speed, int dir, int weight) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.dir = dir;
            this.weight = weight;
        }
    }
}
