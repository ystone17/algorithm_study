import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int maxY, maxX;
    static int[][] map;
    static int[][][] visited2;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());

        map = new int[maxY][maxX];
        visited2 = new int[maxY][maxX][2];
        for (int i = 0; i < maxY; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                map[i][j++] = Integer.parseInt(c + "");
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, false));
        visited2[0][0][0] = 1;
        int dist = 0;
        while (!q.isEmpty()) {
            dist++;

            int size = q.size();

            for (int tc = 0; tc < size; tc++) {
                Node curPoll = q.poll();

                if (curPoll.y == maxY - 1 && curPoll.x == maxX - 1) {
                    System.out.println(dist);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = curPoll.y + dy[i];
                    int nx = curPoll.x + dx[i];

                    if (ny < 0 || ny >= maxY || nx < 0 || nx >= maxX) continue;

                    if (map[ny][nx] == 1 && !curPoll.isBreak && visited2[ny][nx][1] == 0) {
                        visited2[ny][nx][1] = 1;
                        q.add(new Node(ny, nx, true));
                    } else if (map[ny][nx] == 0 && visited2[ny][nx][0] == 0) {
                        if (curPoll.isBreak) {
                            if (visited2[ny][nx][1] == 0) {
                                visited2[ny][nx][1] = 1;
                                q.add(new Node(ny, nx, curPoll.isBreak));
                            }
                        } else {
                            if (visited2[ny][nx][0] == 0) {
                                visited2[ny][nx][0] = 1;
                                q.add(new Node(ny, nx, curPoll.isBreak));
                            }
                        }

                    }
                }

            }
        }
        System.out.println(-1);
//        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

//    static void dfs(int y, int x, boolean isBreak, int count) {
//        if (y == maxY - 1 && x == maxX - 1) {
//            answer = Math.min(answer, count);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//
//            if (ny < 0 || ny >= maxY || nx < 0 || nx >= maxX) continue;
//            if (visited[ny][nx] == 1) continue;
//
//            if (map[ny][nx] == 1 && !isBreak) {
//                visited[ny][nx] = 1;
//                if (count + 1 < answer) dfs(ny, nx, true, count + 1);
//                visited[ny][nx] = 0;
//            } else if (map[ny][nx] == 0) {
//                visited[ny][nx] = 1;
//                if (count + 1 < answer) dfs(ny, nx, isBreak, count + 1);
//                visited[ny][nx] = 0;
//            }
//        }
//    }

    static class Node {
        int y;
        int x;
        boolean isBreak;

        public Node(int y, int x, boolean isBreak) {
            this.y = y;
            this.x = x;
            this.isBreak = isBreak;
        }
    }

}
