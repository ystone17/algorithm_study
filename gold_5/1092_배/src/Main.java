import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static List<Integer> cranes = new ArrayList<>(), boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!boxes.isEmpty()) {
            time++;
            int craneIdx = 0;
            int boxIdx = 0;

            while (craneIdx < n && boxIdx < boxes.size()) {
                if (cranes.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                    continue;
                }

                boxIdx++;
            }
        }

        System.out.println(time);
    }
}
