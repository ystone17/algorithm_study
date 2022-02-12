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
                if(map[yIdx][xIdx] == 'R'){
                    rY = yIdx;
                    rX = xIdx;
                } else if(map[yIdx][xIdx] == 'B'){
                    bY = yIdx;
                    bX = xIdx;
                }
            }
        }

        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }
        System.out.printf("%d %d\n", rY, rX);
        System.out.println();
        System.out.println();
        char[][] rotate = rotate(map);
        for (char[] chars : rotate) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }



    }


    static int game(char[][] map, int moveNum, int rY, int rX, int bY, int bX) {
        if (moveNum > 10 || rY == -1 && rX == -1 && bY != -1 && bX != -1) {
            return moveNum;
        }

        for (int i = 0; i < 4; i++) {
            map = rotate(map);

//            1. 방향돌리기;
//            2. 갈수 있는지 체크;
//            3. 구슬 움직이고;
//            4. temp();
//            5. 최솟값 구하고

        }
        return 10;

    }

    static char[][] rotate(char[][] map) {
        char[][] res = new char[map[0].length][map.length];

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                res[x][map.length - 1 - y] = map[y][x];
            }
        }

        return res;
    }
}

/*

#######
#...BR#
#.#####
#.....#
#####.#
#O....#
#######

* */


/*

#######
#....R#
#.###B#
#.....#
#####.#
#O....#
#######

* */