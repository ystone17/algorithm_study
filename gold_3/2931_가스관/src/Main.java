import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int lenY, lenX;
    static Block[][] blocks;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[] dirs = new int[4];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        lenY = Integer.parseInt(st.nextToken());
        lenX = Integer.parseInt(st.nextToken());

        blocks = new Block[lenY][lenX];

        for (int y = 0; y < lenY; y++) {
            char[] row = br.readLine().toCharArray();
            for (int x = 0; x < row.length; x++) {
                blocks[y][x] = new Block(row[x]);
            }
        }

        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (blocks[y][x].signature != 'M' && blocks[y][x].signature != 'Z') {
                    continue;
                }
                boolean isOpen = true;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= lenY || nx < 0 || nx >= lenX) {
                        continue;
                    }

                    if (blocks[ny][nx].isOpen(dir)) {
                        isOpen = false;
                    }
                }
                if(isOpen) {
                    blocks[y][x].signature = '+';
                }
            }
        }

        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (blocks[y][x].signature != '.') continue;
                int cnt = 0;
                dirs = new int[4];

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= lenY || nx < 0 || nx >= lenX) {
                        continue;
                    }

                    if (blocks[ny][nx].isOpen(dir)) {
                        if (blocks[ny][nx].signature == 'M' || blocks[ny][nx].signature == 'Z') {
                            dirs[dir] = 1;
                        } else {
                            dirs[dir] = 2;
                        }
                        cnt++;
                    }
                }

                if (cnt == 3) {
                    System.out.printf("%d %d %c", y + 1, x + 1, getSignature(2));
                    return;
                }

                if (cnt >= 2) {
                    System.out.printf("%d %d %c", y + 1, x + 1, getSignature(1));
                    return;
                }
            }
        }

    }

    static char getSignature(int base) {
        if (dirs[0] >= base && dirs[1] >= base && dirs[2] >= base && dirs[3] >= base) {
            return '+';
        }

        if (dirs[1] >= base && dirs[3] >= base) {
            return '|';
        }

        if (dirs[0] >= base && dirs[2] >= base) {
            return '-';
        }

        if (dirs[0] >= base && dirs[1] >= base) {
            return '1';
        }

        if (dirs[0] >= base && dirs[3] >= base) {
            return '2';
        }

        if (dirs[2] >= base && dirs[3] >= base) {
            return '3';
        }

        if (dirs[1] >= base && dirs[2] >= base) {
            return '4';
        }

        return ' ';
    }

    static class Block {
        char signature;
        boolean up;
        boolean down;
        boolean left;
        boolean right;

        public Block(char signature) {
            this.signature = signature;

            if (this.signature == 'M' || this.signature == 'Z') {
                this.up = true;
                this.down = true;
                this.left = true;
                this.right = true;
            }

            if (this.signature == '|') {
                this.up = true;
                this.down = true;
                return;
            }

            if (this.signature == '-') {
                this.left = true;
                this.right = true;
                return;
            }

            if (this.signature == '+') {
                this.up = true;
                this.down = true;
                this.left = true;
                this.right = true;
                return;
            }

            if (this.signature == '1') {
                this.right = true;
                this.down = true;
            }

            if (this.signature == '2') {
                this.up = true;
                this.right = true;
            }

            if (this.signature == '3') {
                this.up = true;
                this.left = true;
            }

            if (this.signature == '4') {
                this.down = true;
                this.left = true;
            }
        }

        public boolean isOpen(int dir) {
            if (dir == 0 && this.left) {
                return true;
            }

            if (dir == 1 && this.up) {
                return true;
            }

            if (dir == 2 && this.right) {
                return true;
            }

            if (dir == 3 && this.down) {
                return true;
            }
            return false;
        }
    }
}
