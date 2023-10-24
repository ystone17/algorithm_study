import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Integer>> tree = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for (int i = 1; i < n; i++) {
            tree.get(Integer.parseInt(st.nextToken())).add(i);
        }

        System.out.println(f(0));
    }

    private static int f(int parent) {
        if (tree.get(parent).isEmpty()) {
            return 0;
        }

        int totalSpentTime = -1;
        List<Integer> spentTime = new ArrayList<>();

        for (Integer child : tree.get(parent)) {
            spentTime.add(f(child));
        }


        spentTime.sort(Comparator.reverseOrder());
        for (int i = 0; i < spentTime.size(); i++) {
            totalSpentTime = Math.max(totalSpentTime, spentTime.get(i) + i);
        }

        return totalSpentTime + 1;
    }
}

