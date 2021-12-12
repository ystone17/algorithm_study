import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] position = new char[5][5];
    static int[][] visited = new int[5][5];
    static int[] checkLink = new int[1 << 25];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int res;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            position[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visited[i][j] = 1;
                if (position[i][j] == 'S')
                    dfs(1, 0, 1 << (i * 5 + j));
                else
                    dfs(0, 1, 1 << (i * 5 + j));
                visited[i][j] = 0;
            }
        }

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int s, int y, int route) {
        if (y > 3 || checkLink[route] == 1) return;
        checkLink[route] = 1;
        if (s + y == 7) {
            res++;
            return;
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j] == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || visited[ny][nx] == 1 || (route & (1 << (ny * 5 + nx))) > 0) continue;


                    visited[ny][nx] = 1;
                    int nRoute = route | (1 << (ny * 5 + nx));
                    if (position[ny][nx] == 'S')
                        dfs(s + 1, y, nRoute);
                    else
                        dfs(s, y + 1, nRoute);
                    visited[ny][nx] = 0;
                }

            }
        }


    }


}

