import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Map<Character, Integer> faces = Map.of(
            'U', 0,
            'F', 1,
            'R', 2,
            'L', 3,
            'B', 4,
            'D', 5
    );
    static int[][] reverse = {{3, 4}, {}, {5}, {0}, {0, 5}, {2, 4}};
    static char[] color = {'w', 'r', 'b', 'g', 'o', 'y'};
    static char[][][] cube = new char[6][3][3];
    static Map<Character, List<dirInfo>> dirInfoByFace;

    public static void main(String[] args) throws IOException {
        initDir();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            initCube();

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            char[] moves = br.readLine().replaceAll(" ", "").toCharArray();

            for (int j = 0; j <= m * 2 - 2; j += 2) {
                move(moves[j], moves[j + 1]);
            }

            printCube();
        }


    }

    static void initCube() {
        for (int i = 0; i < 6; i++) {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    cube[i][y][x] = color[i];
                }
            }
        }
    }

    static void initDir() {
//        {'U', 'F', 'R', 'L', 'B', 'D'};
        dirInfoByFace = new HashMap<>();

        List<dirInfo> u = new ArrayList<>();
        u.add(new dirInfo(1, 0, 0, 0, 2));
        u.add(new dirInfo(3, 0, 0, 0, 2));
        u.add(new dirInfo(4, 0, 0, 0, 2));
        u.add(new dirInfo(2, 0, 0, 0, 2));
        dirInfoByFace.put('U', u);

        List<dirInfo> f = new ArrayList<>();
        f.add(new dirInfo(5, 0, 0, 0, 2));
        f.add(new dirInfo(3, 0, 2, 2, 2));
        f.add(new dirInfo(0, 2, 2, 0, 2));
        f.add(new dirInfo(2, 0, 2, 0, 0));
        dirInfoByFace.put('F', f);

        List<dirInfo> r = new ArrayList<>();
        r.add(new dirInfo(1, 0, 2, 2, 2));
        r.add(new dirInfo(0, 0, 2, 2, 2));
        r.add(new dirInfo(4, 0, 2, 0, 0));
        r.add(new dirInfo(5, 0, 2, 2, 2));
        dirInfoByFace.put('R', r);

        List<dirInfo> l = new ArrayList<>();
        l.add(new dirInfo(0, 0, 2, 0, 0));
        l.add(new dirInfo(1, 0, 2, 0, 0));
        l.add(new dirInfo(5, 0, 2, 0, 0));
        l.add(new dirInfo(4, 0, 2, 2, 2));
        dirInfoByFace.put('L', l);

        List<dirInfo> b = new ArrayList<>();
        b.add(new dirInfo(0, 0, 0, 0, 2));
        b.add(new dirInfo(3, 0, 2, 0, 0));
        b.add(new dirInfo(5, 2, 2, 0, 2));
        b.add(new dirInfo(2, 0, 2, 2, 2));
        dirInfoByFace.put('B', b);

        List<dirInfo> d = new ArrayList<>();
        d.add(new dirInfo(1, 2, 2, 0, 2));
        d.add(new dirInfo(2, 2, 2, 0, 2));
        d.add(new dirInfo(4, 2, 2, 0, 2));
        d.add(new dirInfo(3, 2, 2, 0, 2));
        dirInfoByFace.put('D', d);

    }

    static void move(char face, char plusMinus) {
        rotateFace(face, plusMinus);
        rotateLast(face, plusMinus);
    }

    private static void rotateFace(char face, char plusMinus) {
        char[] temp = new char[8];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            temp[idx++] = cube[faces.get(face)][0][i];
        }

        temp[idx++] = cube[faces.get(face)][1][2];

        for (int i = 2; i >= 0; i--) {
            temp[idx++] = cube[faces.get(face)][2][i];
        }
        temp[idx] = cube[faces.get(face)][1][0];

        if (plusMinus == '+') {
            idx = 6;
        } else {
            idx = 2;
        }

        for (int i = 0; i < 3; i++) {
            cube[faces.get(face)][0][i] = temp[idx];
            idx = (idx + 1) % 8;
        }

        cube[faces.get(face)][1][2] = temp[idx];
        idx = (idx + 1) % 8;

        for (int i = 2; i >= 0; i--) {
            cube[faces.get(face)][2][i] = temp[idx];
            idx = (idx + 1) % 8;
        }

        cube[faces.get(face)][1][0] = temp[idx];
    }

    private static void rotateLast(char face, char plusMinus) {
        List<dirInfo> dirInfos = dirInfoByFace.get(face);
        int[] idx;
        if (plusMinus == '+') {
            idx = new int[]{0, 1, 2, 3};
        } else {
            idx = new int[]{3, 2, 1, 0};
        }

        char[] store = new char[3];
        int storeIdx = 0;
        char[] now = new char[3];
        int nowIdx = 0;

        dirInfo dirInfo = dirInfos.get(idx[3]);
        for (int y = dirInfo.ys; y <= dirInfo.ye; y++) {
            for (int x = dirInfo.xs; x <= dirInfo.xe; x++) {
                store[storeIdx++] = cube[dirInfo.face][y][x];
            }
        }

        for (int i = 0; i < 4; i++) {
            nowIdx = 0;
            dirInfo nowDirInfo = dirInfos.get(idx[i]);
            for (int y = nowDirInfo.ys; y <= nowDirInfo.ye; y++) {
                for (int x = nowDirInfo.xs; x <= nowDirInfo.xe; x++) {
                    now[nowIdx++] = cube[nowDirInfo.face][y][x];
                }
            }

            dirInfo next = dirInfos.get(idx[(i + 3) % 4]);
            boolean is = false;
            for (int i1 : reverse[next.face]) {
                if (i1 == nowDirInfo.face) {
                    is = true;
                    break;
                }
            }

            if (is) {
                storeIdx = 2;
            } else {
                storeIdx = 0;
            }

            for (int y = nowDirInfo.ys; y <= nowDirInfo.ye; y++) {
                for (int x = nowDirInfo.xs; x <= nowDirInfo.xe; x++) {
                    if (is) {
                        cube[nowDirInfo.face][y][x] = store[storeIdx--];
                    } else {
                        cube[nowDirInfo.face][y][x] = store[storeIdx++];
                    }

                }
            }

            for (int j = 0; j < 3; j++) {
                store[j] = now[j];
            }

        }


    }

    private static void printCube() {
        for (char[] c : cube[0]) {
            System.out.println(c);
        }
    }

    static class dirInfo {
        private int face;
        private int ys;
        private int ye;
        private int xs;
        private int xe;

        public dirInfo(int face, int ys, int ye, int xs, int xe) {
            this.face = face;
            this.ys = ys;
            this.ye = ye;
            this.xs = xs;
            this.xe = xe;
        }
    }

}
