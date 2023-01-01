import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[] arr, used;
    static Set<String> set = new HashSet<>();
    static List<Integer> idxList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        used = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        req(0);

        System.out.println(set.size());
    }

    static void req(int level) {
        if (level == k) {
            sb = new StringBuilder();
            for (Integer i : idxList) {
                sb.append(arr[i]);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            idxList.add(i);
            req(level + 1);
            idxList.remove(idxList.size() - 1);
            used[i] = 0;
        }


    }

}
