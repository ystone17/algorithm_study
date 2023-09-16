import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int len, sharkNum, k;
    static int[][] smell, map;
    static List<Shark> sharks = new ArrayList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
    // 0, 2, 3, 1는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
    public static void main(String[] args) throws IOException {
        read();


        for (int time = 1; time <= 1000; time++) {
            move(time);
//            if (isFinish()) {
//                System.out.println(time);
//                return;
//            }
        }

        System.out.println(-1);
    }

    private static void move(int time) {
        for (int num = sharkNum; num > 0; num--) {
            Shark shark = sharks.get(sharkNum);
            smell[shark.y][shark.x] = time;

            int rank = -1;
            for (int dir = 0; dir < 4; dir++) {
                int ny = shark.y + dy[dir];
                int nx = shark.y + dy[dir];

                if (ny < 0 || ny >= len || nx < 0 || nx >= len) {
                    continue;
                }

                if(map[ny][nx] == 0) {
                    rank = 3;
                } else if(map[ny][nx] == 0) {

                }
            }
        }


    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());

        len = Integer.parseInt(st.nextToken());
        sharkNum = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        smell = new int[len][len];
        map = new int[len][len];
        for (int i = 0; i <= sharkNum; i++) {
            sharks.add(null);
        }

        for (int y = 0; y < len; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < len; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] != 0) {
                    sharks.set(map[y][x], new Shark(y, x));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= sharkNum; i++) {
            sharks.get(i).setDir(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= sharkNum; i++) {
            for (int dir = 1; dir <= 4; dir++) {
                st = new StringTokenizer(br.readLine());
                Shark shark = sharks.get(i);
                for (int k = 0; k < 4; k++) {
                    shark.setNextDir(dir, k, Integer.parseInt(st.nextToken()));
                }
            }
        }
    }

    private static class Shark {
        int y;
        int x;
        int dir;
        int[][] nextDir = new int[4][4];

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setDir(int dir) {
            this.dir = changeDir(dir);
        }

        private int changeDir(int dir) {
            if (dir == 1) {
                return 0;
            } else if (dir == 4) {
                return 1;
            }

            return dir;
        }

        public void setNextDir(int dir, int count, int nextDir) {
            this.nextDir[changeDir(dir)][count] = changeDir(nextDir);
        }
    }
}
