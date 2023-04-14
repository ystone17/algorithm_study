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

    static int y, x, r;
    static int[][] seq, temp2;
    static int[] temp, dy, dx;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        seq = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                seq[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(seq[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void one() {
        for (int i = 0; i < y / 2; i++) {
            temp = new int[x];

            for (int j = 0; j < x; j++) {
                temp[j] = seq[i][j];
            }

            for (int j = 0; j < x; j++) {
                seq[i][j] = seq[y - 1 - i][j];
            }

            for (int j = 0; j < x; j++) {
                seq[y - 1 - i][j] = temp[j];
            }

        }
    }

    static void two() {
        for (int i = 0; i < x / 2; i++) {
            temp = new int[y];

            for (int j = 0; j < y; j++) {
                temp[j] = seq[j][i];
            }

            for (int j = 0; j < y; j++) {
                seq[j][i] = seq[j][x - 1 - i];
            }

            for (int j = 0; j < y; j++) {
                seq[j][x - 1 - i] = temp[j];
            }

        }
    }

    static void three() {
        q = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                q.add(seq[i][j]);
            }
        }

        seq = new int[x][y];
        int temp = y;
        y = x;
        x = temp;

        for (int j = x - 1; j >= 0; j--) {
            for (int i = 0; i < y; i++) {
                seq[i][j] = q.poll();
            }
        }
    }

    static void four() {
        q = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                q.add(seq[i][j]);
            }
        }

        seq = new int[x][y];
        int temp = y;
        y = x;
        x = temp;

        for (int j = 0; j < x; j++) {
            for (int i = y - 1; i >= 0; i--) {
                seq[i][j] = q.poll();
            }
        }
    }

    static void five() {
        temp2 = new int[y][x];

        dy = new int[]{0, 0, y / 2, y / 2};
        dx = new int[]{0, x / 2, x / 2, 0};

        for (int n = 0; n < 4; n++) {

            for (int i = 0; i < y / 2; i++) {
                for (int j = 0; j < x / 2; j++) {
                    int sy = i + dy[n];
                    int sx = j + dx[n];

                    int ty = i + dy[(n + 1) % 4];
                    int tx = j + dx[(n + 1) % 4];

                    temp2[ty][tx] = seq[sy][sx];
                }
            }
        }

        seq = temp2;
    }

    static void six() {
        temp2 = new int[y][x];

        dy = new int[]{0, y / 2, y / 2, 0};
        dx = new int[]{0, 0, x / 2, x / 2};

        for (int n = 0; n < 4; n++) {

            for (int i = 0; i < y / 2; i++) {
                for (int j = 0; j < x / 2; j++) {
                    int sy = i + dy[n];
                    int sx = j + dx[n];

                    int ty = i + dy[(n + 1) % 4];
                    int tx = j + dx[(n + 1) % 4];

                    temp2[ty][tx] = seq[sy][sx];
                }
            }
        }

        seq = temp2;
    }

}
