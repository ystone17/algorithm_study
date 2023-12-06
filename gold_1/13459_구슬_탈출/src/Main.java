import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int y, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int rY = 0, rX = 0, bY = 0, bX = 0;
        char[][] map = new char[y][x];

        for (int yIdx = 0; yIdx < y; yIdx++) {
            st = new StringTokenizer(br.readLine());
            map[yIdx] = st.nextToken().toCharArray();
            for (int xIdx = 0; xIdx < map[yIdx].length; xIdx++) {
                if (map[yIdx][xIdx] == 'R') {
                    rY = yIdx;
                    rX = xIdx;
                } else if (map[yIdx][xIdx] == 'B') {
                    bY = yIdx;
                    bX = xIdx;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        res = Math.min(res, game(0, 1, map, rY, rX, bY, bX));
        res = Math.min(res, game(0, 2, map, rY, rX, bY, bX));
        res = Math.min(res, game(0, 3, map, rY, rX, bY, bX));
        res = Math.min(res, game(0, 4, map, rY, rX, bY, bX));

        if (res > 10) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }


    }

    static int game(int num, int dir, char[][] map, int rY, int rX, int bY, int bX) {
        if (num > 10) {
            return num;
        }

        char[][] nMap = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, nMap[i], 0, map[i].length);
        }

        int res = Integer.MAX_VALUE;
        boolean red = false, blue = false;
        switch (dir) {
            case 1:
                if (bX > rX) {
                    char temp = nMap[bY][bX];
                    for (int x = bX + 1; x < nMap[bY].length; x++) {
                        if (nMap[bY][x] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[bY][x] != '.') {
                            nMap[bY][bX] = nMap[bY][x - 1];
                            nMap[bY][x - 1] = temp;
                            bX = x - 1;
                            break;
                        }
                    }
                    temp = nMap[rY][rX];
                    for (int x = rX + 1; x < nMap[rY].length; x++) {
                        if (nMap[rY][x] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[rY][x] != '.') {
                            nMap[rY][rX] = nMap[rY][x - 1];
                            nMap[rY][x - 1] = temp;
                            rX = x - 1;
                            break;
                        }
                    }
                } else {
                    char temp = nMap[rY][rX];
                    for (int x = rX + 1; x < nMap[rY].length; x++) {
                        if (nMap[rY][x] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[rY][x] != '.') {
                            nMap[rY][rX] = nMap[rY][x - 1];
                            nMap[rY][x - 1] = temp;
                            rX = x - 1;
                            break;
                        }
                    }
                    temp = nMap[bY][bX];
                    for (int x = bX + 1; x < nMap[bY].length; x++) {
                        if (nMap[bY][x] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[bY][x] != '.') {
                            nMap[bY][bX] = nMap[bY][x - 1];
                            nMap[bY][x - 1] = temp;
                            bX = x - 1;
                            break;
                        }
                    }

                }
                break;
            case 2:
                if (bY > rY) {
                    char temp = nMap[bY][bX];
                    for (int y = bY + 1; y < nMap.length; y++) {
                        if (nMap[y][bX] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[y][bX] != '.') {
                            nMap[bY][bX] = nMap[y - 1][bX];
                            nMap[y - 1][bX] = temp;
                            bY = y - 1;
                            break;
                        }
                    }

                    temp = nMap[rY][rX];
                    for (int y = rY + 1; y < nMap.length; y++) {
                        if (nMap[y][rX] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[y][rX] != '.') {
                            nMap[rY][rX] = nMap[y - 1][rX];
                            nMap[y - 1][rX] = temp;
                            rY = y - 1;
                            break;
                        }
                    }

                } else {
                    char temp = nMap[rY][rX];
                    for (int y = rY + 1; y < nMap.length; y++) {
                        if (nMap[y][rX] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[y][rX] != '.') {
                            nMap[rY][rX] = nMap[y - 1][rX];
                            nMap[y - 1][rX] = temp;
                            rY = y - 1;
                            break;
                        }
                    }

                    temp = nMap[bY][bX];
                    for (int y = bY + 1; y < nMap.length; y++) {
                        if (nMap[y][bX] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[y][bX] != '.') {
                            nMap[bY][bX] = nMap[y - 1][bX];
                            nMap[y - 1][bX] = temp;
                            bY = y - 1;
                            break;
                        }
                    }

                }
                break;
            case 3:
                if (bX < rX) {
                    char temp = nMap[bY][bX];
                    for (int x = bX - 1; x >= 0; x--) {
                        if (nMap[bY][x] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[bY][x] != '.') {
                            nMap[bY][bX] = nMap[bY][x + 1];
                            nMap[bY][x + 1] = temp;
                            bX = x + 1;
                            break;
                        }
                    }
                    temp = nMap[rY][rX];
                    for (int x = rX - 1; x >= 0; x--) {
                        if (nMap[rY][x] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[rY][x] != '.') {
                            nMap[rY][rX] = nMap[rY][x + 1];
                            nMap[rY][x + 1] = temp;
                            rX = x + 1;
                            break;
                        }
                    }
                } else {
                    char temp = nMap[rY][rX];
                    for (int x = rX - 1; x >= 0; x--) {
                        if (nMap[rY][x] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[rY][x] != '.') {
                            nMap[rY][rX] = nMap[rY][x + 1];
                            nMap[rY][x + 1] = temp;
                            rX = x + 1;
                            break;
                        }
                    }
                    temp = nMap[bY][bX];
                    for (int x = bX - 1; x >= 0; x--) {
                        if (nMap[bY][x] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[bY][x] != '.') {
                            nMap[bY][bX] = nMap[bY][x + 1];
                            nMap[bY][x + 1] = temp;
                            bX = x + 1;
                            break;
                        }
                    }
                }
                break;
            case 4:
                if (bY < rY) {
                    char temp = nMap[bY][bX];
                    for (int y = bY - 1; y >= 0; y--) {
                        if (nMap[y][bX] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[y][bX] != '.') {
                            nMap[bY][bX] = nMap[y + 1][bX];
                            nMap[y + 1][bX] = temp;
                            bY = y + 1;
                            break;
                        }
                    }

                    temp = nMap[rY][rX];
                    for (int y = rY - 1; y >= 0; y--) {
                        if (nMap[y][rX] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[y][rX] != '.') {
                            nMap[rY][rX] = nMap[y + 1][rX];
                            nMap[y + 1][rX] = temp;
                            rY = y + 1;
                            break;
                        }
                    }

                } else {
                    char temp = nMap[rY][rX];
                    for (int y = rY - 1; y >= 0; y--) {
                        if (nMap[y][rX] == 'O') {
                            red = true;
                            nMap[rY][rX] = '.';
                            break;
                        } else if (nMap[y][rX] != '.') {
                            nMap[rY][rX] = nMap[y + 1][rX];
                            nMap[y + 1][rX] = temp;
                            rY = y + 1;
                            break;
                        }
                    }

                    temp = nMap[bY][bX];
                    for (int y = bY - 1; y >= 0; y--) {
                        if (nMap[y][bX] == 'O') {
                            blue = true;
                            nMap[bY][bX] = '.';
                            break;
                        } else if (nMap[y][bX] != '.') {
                            nMap[bY][bX] = nMap[y + 1][bX];
                            nMap[y + 1][bX] = temp;
                            bY = y + 1;
                            break;
                        }
                    }

                }
                break;
        }


        if (blue) {
            return Integer.MAX_VALUE;
        } else if (red) {
            return num + 1;
        } else {
            res = Math.min(res, game(num + 1, 1, nMap, rY, rX, bY, bX));
            res = Math.min(res, game(num + 1, 2, nMap, rY, rX, bY, bX));
            res = Math.min(res, game(num + 1, 3, nMap, rY, rX, bY, bX));
            res = Math.min(res, game(num + 1, 4, nMap, rY, rX, bY, bX));
            return res;
        }
    }


}