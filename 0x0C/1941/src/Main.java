import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] position = new char[5][5];
    static int[][] visited = new int[5][5];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int res;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            position[i] = st.nextToken().toCharArray();
        }

        find(0, 0, 0, 0);

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();


    }

    //s > y
    static void find(int y, int x, int count, int yNum) {
        if (yNum > 3) return;
        if (count == 7) {
            if (checkBfs()) {
                res++;
            }
            return;
        }

        for (int i = y; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == y && j < x || visited[i][j] == 1) continue;
                visited[i][j] = 1;
                if (position[i][j] == 'Y') find(i, j, count + 1, yNum + 1);
                else find(i, j, count + 1, yNum);
                visited[i][j] = 0;
            }
        }
    }

    static boolean checkBfs() {
        int[][] bfs = new int[5][5];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j] == 1) {
                    bfs[i][j] = 1;
                    int count = 0;
                    queue.add(i * 5 + j);
                    while (!queue.isEmpty()) {
                        int now = queue.poll();
                        count++;
                        for (int c = 0; c < 4; c++) {
                            int newY = now / 5 + dy[c];
                            int newX = now % 5 + dx[c];
                            if (newY < 0 || newY >= 5 || newX < 0 || newX >= 5)
                                continue;
                            if (visited[newY][newX] == 1 && bfs[newY][newX] == 0) {
                                bfs[newY][newX] = 1;
                                queue.add(newY * 5 + newX);
                            }
                        }
                    }
                    return count == 7;
                }
            }
        }
        return false;
    }

}

