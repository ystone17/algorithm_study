import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int len, sharkNum, k, curSharkNum;
    static int[][] map, smellTime, smellShark;
    static List<Shark> sharks = new ArrayList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        read();

        System.out.println(move());
    }

    private static int move() {
        for (int time = 1; time <= 1000; time++) {
            for (int num = 1; num <= sharkNum; num++) {
                Shark shark = sharks.get(num);
                if (shark == null) {
                    continue;
                }

                boolean empty = false;

                int fy = -1;
                int fx = -1;
                int fDir = -1;

                for (int i = shark.nextDir[shark.dir].length - 1; i >= 0; i--) {
                    int dir = shark.nextDir[shark.dir][i];
                    int ny = shark.y + dy[dir];
                    int nx = shark.x + dx[dir];

                    if (ny < 0 || ny >= len || nx < 0 || nx >= len) {
                        continue;
                    }

                    if (smellTime[ny][nx] < time - k) {
                        fy = ny;
                        fx = nx;
                        fDir = dir;
                        empty = true;
                        continue;
                    }

                    if (!empty && smellShark[ny][nx] == num) {
                        fy = ny;
                        fx = nx;
                        fDir = dir;
                    }
                }

                smellTime[fy][fx] = time;
                smellShark[fy][fx] = num;

                shark.dir = fDir;
                shark.y = fy;
                shark.x = fx;

                if (map[fy][fx] != 0 && map[fy][fx] != num) {
                    sharks.set(map[fy][fx], null);
                    curSharkNum--;
                }

                map[fy][fx] = num;
                map[shark.y][shark.x] = 0;
            }

            if (curSharkNum == 1) {
                return time;
            }

        }


        return -1;
    }


    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());

        len = Integer.parseInt(st.nextToken());
        sharkNum = Integer.parseInt(st.nextToken());
        curSharkNum = sharkNum;
        k = Integer.parseInt(st.nextToken());

        smellTime = new int[len][len];
        smellShark = new int[len][len];
        map = new int[len][len];
        for (int i = 0; i <= sharkNum; i++) {
            sharks.add(null);
        }
        for (int y = 0; y < len; y++) {
            Arrays.fill(smellTime[y], -123465);
        }

        for (int y = 0; y < len; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < len; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] != 0) {
                    sharks.set(map[y][x], new Shark(y, x));
                    smellTime[y][x] = 0;
                    smellShark[y][x] = map[y][x];
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
