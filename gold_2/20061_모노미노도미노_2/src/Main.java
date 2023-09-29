import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        Board board = new Board();

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            board.putBlock(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        sb.append(board.score()).append("\n").append(board.blockNum());
        System.out.println(sb);
    }

    public static class Board {
        private final int[][] board = new int[10][10];
        private final int BLUE_S_X = 0;
        private final int BLUE_E_X = 3;
        private final int BLUE_S_Y = 4;
        private final int BLUE_E_Y = 9;
        private final int GREEN_S_X = 4;
        private final int GREEN_E_X = 9;
        private final int GREEN_S_Y = 0;
        private final int GREEN_E_Y = 3;

        private int score = 0;

        public void putBlock(int type, int x, int y) {
            switch (type) {
                case 1:
                    putBlue1(x, y);
                    putGreen1(x, y);
                    break;
                case 2:
                    putBlue2(x, y);
                    putGreen2(x, y);
                    break;
                default:
                    putBlue3(x, y);
                    putGreen3(x, y);
                    break;
            }

            clearBlueExtraZone();
            clearGreenExtraZone();
        }

        private void clearGreenExtraZone() {
            for (int i = 0; i < 2; i++) {
                for (int yi = GREEN_S_Y; yi <= GREEN_E_Y; yi++) {
                    if (board[GREEN_S_X + 1][yi] == 1) {
                        removeGreenOneLine(GREEN_E_X);
                        break;
                    }
                }
            }
        }

        private void clearBlueExtraZone() {
            for (int i = 0; i < 2; i++) {
                for (int xi = BLUE_S_X; xi <= BLUE_E_X; xi++) {
                    if (board[xi][BLUE_S_Y + 1] == 1) {
                        removeBlueOneLine(BLUE_E_Y);
                        break;
                    }
                }
            }
        }

        public int score() {
            return score;
        }

        public int blockNum() {
            int blockNum = 0;
            for (int x = BLUE_S_X; x <= BLUE_E_X; x++) {
                for (int y = BLUE_S_Y; y <= BLUE_E_Y; y++) {
                    if (board[x][y] == 1) blockNum++;
                }
            }

            for (int x = GREEN_S_X; x <= GREEN_E_X; x++) {
                for (int y = GREEN_S_Y; y <= GREEN_E_Y; y++) {
                    if (board[x][y] == 1) blockNum++;
                }
            }

            return blockNum;
        }

        private void putBlue1(int x, int y) {
            int target = BLUE_S_Y;
            for (int yi = BLUE_S_Y; yi <= BLUE_E_Y; yi++) {
                if (this.board[x][yi] == 1) {
                    break;
                }
                target = yi;
            }

            this.board[x][target] = 1;
            if (canRemoveBlueLine(target)) {
                removeBlueOneLine(target);
                score++;
            }
        }

        private void putGreen1(int x, int y) {
            int target = GREEN_S_X;
            for (int xi = GREEN_S_X; xi <= GREEN_E_X; xi++) {
                if (this.board[xi][y] == 1) {
                    break;
                }
                target = xi;
            }

            this.board[target][y] = 1;
            if (canRemoveGreenLine(target)) {
                removeGreenOneLine(target);
                score++;
            }
        }

        private void putBlue2(int x, int y) {
            int target = BLUE_S_Y;
            for (int yi = BLUE_S_Y; yi < BLUE_E_Y; yi++) {
                if (this.board[x][yi] == 1 || this.board[x][yi + 1] == 1) {
                    break;
                }
                target = yi;
            }

            this.board[x][target] = 1;
            this.board[x][target + 1] = 1;
            if (canRemoveBlueLine(target)) {
                removeBlueOneLine(target);
                score++;
            }
            if (canRemoveBlueLine(target + 1)) {
                removeBlueOneLine(target + 1);
                score++;
            }
        }

        private void putGreen2(int x, int y) {
            int target = GREEN_S_X;
            for (int xi = GREEN_S_X; xi <= GREEN_E_X; xi++) {
                if (this.board[xi][y] == 1 || this.board[xi][y + 1] == 1) {
                    break;
                }
                target = xi;
            }

            this.board[target][y] = 1;
            this.board[target][y + 1] = 1;

            if (canRemoveGreenLine(target)) {
                removeGreenOneLine(target);
                score++;
            }
        }

        private void putBlue3(int x, int y) {
            int target = BLUE_S_Y;
            for (int yi = BLUE_S_Y; yi <= BLUE_E_Y; yi++) {
                if (this.board[x][yi] == 1 || this.board[x + 1][yi] == 1) {
                    break;
                }
                target = yi;
            }

            this.board[x][target] = 1;
            this.board[x + 1][target] = 1;

            if (canRemoveBlueLine(target)) {
                removeBlueOneLine(target);
                score++;
            }
        }

        private void putGreen3(int x, int y) {
            int target = GREEN_S_X;
            for (int xi = GREEN_S_X; xi < GREEN_E_X; xi++) {
                if (this.board[xi][y] == 1 || this.board[xi + 1][y] == 1) {
                    break;
                }
                target = xi;
            }

            this.board[target][y] = 1;
            this.board[target + 1][y] = 1;

            if (canRemoveGreenLine(target)) {
                removeGreenOneLine(target);
                score++;
            }
            if (canRemoveGreenLine(target + 1)) {
                removeGreenOneLine(target + 1);
                score++;
            }
        }

        private boolean canRemoveBlueLine(int y) {
            for (int xi = BLUE_S_X; xi <= BLUE_E_X; xi++) {
                if (board[xi][y] == 0) {
                    return false;
                }
            }
            return true;
        }

        private void removeBlueOneLine(int y) {
            for (int xi = BLUE_S_X; xi <= BLUE_E_X; xi++) {
                for (int yi = y; yi >= BLUE_S_Y; yi--) {
                    board[xi][yi] = board[xi][yi - 1];
                }
            }
        }

        private boolean canRemoveGreenLine(int x) {
            for (int yi = GREEN_S_Y; yi <= GREEN_E_Y; yi++) {
                if (board[x][yi] == 0) {
                    return false;
                }
            }
            return true;
        }

        private void removeGreenOneLine(int x) {
            for (int yi = GREEN_S_Y; yi <= GREEN_E_Y; yi++) {
                for (int xi = x; xi >= GREEN_S_X; xi--) {
                    board[xi][yi] = board[xi - 1][yi];
                }
            }
        }
    }
}
