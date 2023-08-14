import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map;
    static int lengthY, lengthX, robotNum, commandNum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        lengthX = Integer.parseInt(st.nextToken());
        lengthY = Integer.parseInt(st.nextToken());

        map = new int[lengthY + 1][lengthX + 1];

        st = new StringTokenizer(br.readLine());
        robotNum = Integer.parseInt(st.nextToken());
        commandNum = Integer.parseInt(st.nextToken());

        Robots robots = new Robots();

        for (int i = 1; i <= robotNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            map[y][x] = i;
            robots.addRobot(new Robot(i, y, x, dir));
        }

        for (int i = 0; i < commandNum; i++) {
            st = new StringTokenizer(br.readLine());
            int robotIdx = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            String commandRes = robots.command(robotIdx, dir, count);
            if (commandRes != null) {
                System.out.println(commandRes);
                return;
            }
        }

        System.out.println("OK");
    }

    private static class Robots {
        private final List<Robot> robots = new ArrayList<>();

        public void addRobot(Robot robot) {
            robots.add(robot);
        }

        public String command(int robotIdx, String command, int count) {
            Robot robot = robots.get(robotIdx - 1);

            switch (command) {
                case "F":
                    String res = go(robot, count);
                    if (res != null) {
                        return res;
                    }
                    break;
                case "L":
                    turnLeft(robot, count);
                    break;
                case "R":
                    turnRight(robot, count);
                    break;
            }

            return null;
        }

        private String go(Robot robot, int count) {
            for (int i = 0; i < count; i++) {
                String res = robot.go();
                if (res != null) {
                    return res;
                }
            }

            return null;
        }

        private void turnLeft(Robot robot, int count) {
            for (int i = 0; i < count; i++) {
                robot.turnLeft();
            }
        }

        private void turnRight(Robot robot, int count) {
            for (int i = 0; i < count; i++) {
                robot.turnRight();
            }
        }
    }

    private static class Robot {
        int id;
        int y;
        int x;
        int dir;

        static int[] dy = {0, -1, 0, 1};
        static int[] dx = {1, 0, -1, 0};
        static Map<String, Integer> toDir = Map.of("E", 0, "S", 1, "W", 2, "N", 3);

        public Robot(int id, int y, int x, String dir) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.dir = toDir.get(dir);
        }

        public void turnRight() {
            dir = (dir + 1) % 4;
        }

        public void turnLeft() {
            dir = (dir + 3) % 4;
        }

        public String go() {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny <= 0 || ny > lengthY || nx <= 0 || nx > lengthX) {
                return "Robot " + id + " crashes into the wall";
            }

            if (map[ny][nx] != 0) {
                return "Robot " + id + " crashes into robot " + map[ny][nx];
            }

            map[y][x] = 0;
            map[ny][nx] = id;
            y = ny;
            x = nx;

            return null;
        }
    }
}
