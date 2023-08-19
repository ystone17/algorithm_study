import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int lenY, lenX, d, enemyCount, max = Integer.MIN_VALUE;
    static int[][] map;
    static int[] archers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        lenY = Integer.parseInt(st.nextToken());
        lenX = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[lenY + 1][lenX];
        for (int y = 0; y < lenY; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < lenX; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {
                    enemyCount++;
                }
            }
        }

        archers = new int[lenX];

        req(0, 0, 0);
        System.out.println(max);
    }

    static void req(int idx, int startIdx, int count) {
        if (count >= 3) {
            max = Math.max(max, solve());
            return;
        }

        for (int i = startIdx; i < lenX; i++) {
            archers[i] = 1;
            req(idx + 1, i + 1, count + 1);
            archers[i] = 0;
        }
    }


    static int solve() {
        int[][] map = copyMap();

        for (int i = 0; i < archers.length; i++) {
            map[lenY][i] = archers[i];
        }

        int moveRemoveCount = 0;
        int attackRemoveCount = 0;
        while (moveRemoveCount + attackRemoveCount != enemyCount) {
            for (int i = 0; i < map[lenY].length; i++) {
                if(map[lenY][i] == 1) {
                    attackEnemy(i);
                    attackRemoveCount += removeAttackedEnemy();
                }
            }

            moveRemoveCount += moveEnemy();
        }

        return attackRemoveCount;
    }

    static int[][] copyMap() {
        int[][] temp = new int[lenY + 1][lenX];

        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                temp[y][x] = map[y][x];
            }
        }

        return temp;
    }


    static boolean attackEnemy(int archerX) {

        for (int y = lenY - 1; y >= 0; y--) {
            for (int x = lenX - 1; lenY - y + lenX - x <= d; x--) {
                if (map[y][x] >= 1) {
                    map[y][x]++;
                    return true;
                }
            }
        }

        return false;
    }

    static int removeAttackedEnemy() {
        int removeEnemyCount = 0;
        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (map[y][x] >= 1) {
                    map[y][x] = 0;
                    removeEnemyCount++;
                }
            }
        }

        return removeEnemyCount;
    }

    static int moveEnemy() {
        int removeEnemyCount = 0;

        for (int y = lenY - 1; y >= 0; y--) {
            for (int x = lenX - 1; x >= 0; x--) {
                if (y == lenY - 1) {
                    map[y][x] = 0;
                    removeEnemyCount++;
                    continue;
                }

                map[y][x] = 0;
                map[y + 1][x] = 1;
            }
        }

        return removeEnemyCount;
    }
}
