import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, maxLevel;
    static int[] parent;
    static Node[] nodes;
    static Map<Integer, List<Integer>> colsByLevel = new HashMap<>();

    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        nodes = new Node[n + 1];

        int num, l, r;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if (l != -1) parent[l] = num;
            if (r != -1) parent[r] = num;
            nodes[num] = new Node(num, l, r);
        }

        Node root = nodes[1];
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 0) {
                root = nodes[i];
                break;
            }
        }

        setCol(1, root.num, 1);
        getRes();

        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
    }

    static int setCol(int level, int num, int start) {
        Node cur = nodes[num];

        if (cur.left == -1 && cur.right == -1) {
            List<Integer> colList = colsByLevel.getOrDefault(level, new ArrayList<>());
            colList.add(start);
            colsByLevel.put(level, colList);
            maxLevel = Math.max(maxLevel, level);
            return 1;
        }

        int leftCnt = 0, rightCnt = 0;
        if (cur.left != -1) leftCnt = setCol(level + 1, cur.left, start);
        if (cur.right != -1) rightCnt = setCol(level + 1, cur.right, start + leftCnt + 1);

        List<Integer> colList = colsByLevel.getOrDefault(level, new ArrayList<>());
        colList.add(start + leftCnt);
        colsByLevel.put(level, colList);

        return leftCnt + rightCnt + 1;
    }

    static void getRes() {
        int res = 0;
        for (int level = 1; level <= maxLevel; level++) {
            List<Integer> colList = colsByLevel.get(level);
            int temp = colList.get(colList.size() - 1) - colList.get(0) + 1;
            if (temp > res) {
                answer[0] = level;
                answer[1] = temp;
                res = temp;
            }
        }
    }

    static class Node {
        int num;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}
