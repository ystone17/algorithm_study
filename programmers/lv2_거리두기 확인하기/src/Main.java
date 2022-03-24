import java.util.LinkedList;
import java.util.Queue;

class Solution {

    Queue<Node> pQ = new LinkedList<>();
    Queue<Node> q = new LinkedList<>();

    int[][] visited;
    char[][] map;

    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            pQ.clear();
            q.clear();
            visited = new int[5][5];
            map = new char[5][5];

            String[] place = places[i];

            for (int y = 0; y < place.length; y++) {
                char[] coor = place[y].toCharArray();
                for (int x = 0; x < coor.length; x++) {
                    map[y][x] = coor[x];
                    if (coor[x] == 'P') pQ.add(new Node(y, x, 0));
                }
            }

            boolean flag = true;
            while (!pQ.isEmpty()) {
                q.add(pQ.poll());
                visited[q.peek().y][q.peek().x] = 1;

                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        Node cur = q.poll();
                        if (cur.dist == 2) continue;

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                            if (visited[ny][nx] == 1) continue;
                            if (map[ny][nx] == 'P') {
                                flag = false;
                                break;
                            }
                            if (map[ny][nx] == 'X') continue;


                            visited[ny][nx] = 1;
                            q.add(new Node(ny, nx, cur.dist + 1));
                        }
                    }

                    if (!flag) break;
                }
            }
            if (!flag) answer[i] = 0;
            else answer[i] = 1;

        }

        return answer;
    }
}

class Node {
    int y;
    int x;
    int dist;

    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        for (int i : solution1) {
            System.out.printf("%2d ",i);
        }
    }
}

