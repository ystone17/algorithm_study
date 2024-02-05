import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<Rectangle> rectangles = new ArrayList<>();
    static int[] parent;
    static int n;

    public static void main(String[] args) throws IOException {
        rectangles.add(new Rectangle(0, 0, 0, 0, 0));

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        parent[0] = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            var rectangle = new Rectangle(
                    rectangles.size(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            for (Rectangle rect : rectangles) {
                if (rect.isInclude(rectangle)) {
                    parent[rectangle.idx] = getParent(rect.idx);
                    break;
                }
            }

            rectangles.add(rectangle);
        }

        var s = new HashSet<Integer>();
        for (int i : parent) {
            s.add(i);
        }

        System.out.println(s.size());
    }

    private static int getParent(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }

        return parent[idx] = getParent(parent[idx]);
    }


    private static class Rectangle {
        int idx;
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int idx, int x1, int y1, int x2, int y2) {
            this.idx = idx;
            this.x1 = Math.min(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.x2 = Math.max(x1, x2);
            this.y2 = Math.max(y1, y2);
        }

        public boolean isInclude(Rectangle r) {
            return x1 <= r.x1 && r.x1 <= x2 && y1 <= r.y1 && r.y1 <= y2
                    || x1 <= r.x1 && r.x1 <= x2 && y1 <= r.y2 && r.y2 <= y2
                    || x1 <= r.x2 && r.x2 <= x2 && y1 <= r.y1 && r.y1 <= y2
                    || x1 <= r.x2 && r.x2 <= x2 && y1 <= r.y2 && r.y2 <= y2;
        }
    }

}
