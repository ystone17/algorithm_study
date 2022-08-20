import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static Queue<State> q = new LinkedList<>();
    static int res;

    public static void main(String[] args) throws IOException {

        State start = new State();

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                start.map[i][j] = new Fish(false, num, dir);
                start.index[start.map[i][j].num] = new Pos(i, j);
            }
        }

        start.total = start.map[0][0].num;
        start.map[0][0].shark = true;
        start.index[start.map[0][0].num] = null;
        start.sharkY = 0;
        start.sharkX = 0;

        q.add(start);

        while (!q.isEmpty()) {
            State cur = q.poll();

            for (int idx = 1; idx <= 16; idx++) {
                Pos pos = cur.index[idx];
                if (pos == null) continue;

//                if(cur.map[pos.y][pos.x] == null) continue;
                Fish fish = cur.map[pos.y][pos.x];

                for (int i = 0; i < 8; i++) {
                    int dir = (fish.dir + i) % 8;
                    int ny = pos.y + dy[dir];
                    int nx = pos.x + dx[dir];

                    if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) continue;
                    if (cur.map[ny][nx] != null && cur.map[ny][nx].shark) continue;

                    fish.dir = dir;

                    Fish nextFish = cur.map[ny][nx];

                    cur.map[ny][nx] = fish;
                    cur.map[pos.y][pos.x] = nextFish;

                    if (nextFish != null) {
                        cur.index[nextFish.num].y = pos.y;
                        cur.index[nextFish.num].x = pos.x;
                    }
                    pos.y = ny;
                    pos.x = nx;

                    break;
                }
            }

            Fish shark = cur.map[cur.sharkY][cur.sharkX];

            int ny = cur.sharkY + dy[shark.dir];
            int nx = cur.sharkX + dx[shark.dir];

            int size = q.size();

            while (ny >= 0 && ny < 4 && nx >= 0 && nx < 4) {
                if (cur.map[ny][nx] != null) {
                    State nState = new State();
                    nState.copy(cur, ny, nx);

                    q.add(nState);
                }
                ny += dy[shark.dir];
                nx += dx[shark.dir];
            }

            if (size == q.size()) {
                res = Math.max(res, cur.total);
            }
        }

        System.out.println(res);
    }

    static class State {
        Fish[][] map = new Fish[4][4];
        Pos[] index = new Pos[17];
        int total;
        int sharkY;
        int sharkX;


        void copy(State state, int y, int x) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (state.map[i][j] == null) continue;
                    map[i][j] = new Fish(state.map[i][j].shark, state.map[i][j].num, state.map[i][j].dir) ;
                }
            }

            for (int i = 1; i <= 16; i++) {
                if(state.index[i] == null) continue;
                index[i] = new Pos(state.index[i].y, state.index[i].x);
            }

            total = state.total + state.map[y][x].num;
            sharkY = y;
            sharkX = x;

            map[state.sharkY][state.sharkX] = null;
            map[y][x].shark = true;

            index[map[y][x].num] = null;
        }
    }

    static class Fish {
        boolean shark;
        int num;
        int dir;

        public Fish(boolean shark, int num, int dir) {
            this.shark = shark;
            this.num = num;
            this.dir = dir;
        }
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
