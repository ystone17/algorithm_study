import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int w, h, n, hoVer, pos;
    static List<Integer> ho = new ArrayList<>(), ver = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hoVer = Integer.parseInt(st.nextToken());
            pos = Integer.parseInt(st.nextToken());
            if (hoVer == 0) {
                ho.add(pos);
            } else {
                ver.add(pos);
            }
        }
        ho.add(0);
        ho.add(h);
        ver.add(0);
        ver.add(w);

        Collections.sort(ho);
        Collections.sort(ver);

        int maxH = 0, maxW = 0;

        for (int i = 1; i < ho.size(); i++) {
            maxH = Math.max(maxH, ho.get(i) - ho.get(i - 1));
        }

        for (int i = 1; i < ver.size(); i++) {
            maxW = Math.max(maxW, ver.get(i) - ver.get(i - 1));
        }

        System.out.println(maxH * maxW);
    }


}
