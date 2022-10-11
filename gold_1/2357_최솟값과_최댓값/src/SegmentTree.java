import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr, segmentTree;

    static void run() throws IOException {
        arr = new int[]{5, 8, 7, 3, 2, 5, 1, 8, 9, 8, 7, 3};

        int size = arr.length;

        size = (int) Math.pow((int) Math.sqrt(size) + 1, 2);

        segmentTree = new int[size * 2 + 1];
        System.out.println("size = " + size);
        init(0, arr.length - 1, 1);

        for (int i = 1; i < segmentTree.length; i++) {
            System.out.printf("[%2d] = %d\n", i, segmentTree[i]);
        }

        int[][] tc = {
                {0, 12},
                {0, 5},
                {0, 1},
                {2, 6},
                {3, 10},
        };

        for (int[] ints : tc) {
            System.out.printf("%d ~ %d : %d\n", ints[0], ints[1], sum(0, arr.length - 1, 1, ints[0], ints[1]));
        }

        int hopeNum = 3;
        update(0,arr.length-1, 1, 0, hopeNum - arr[0]);

        System.out.println();
        for (int[] ints : tc) {
            System.out.printf("%d ~ %d : %d\n", ints[0], ints[1], sum(0, arr.length - 1, 1, ints[0], ints[1]));
        }

    }

    static int init(int start, int end, int node) {
        if (start == end) return segmentTree[node] = arr[start];

        int mid = (start + end) / 2;

        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static int sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);

    }

    static void update(int start, int end, int node, int index, int dif) {
        if(index < start || index > end) return;

        segmentTree[node] += dif;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }

}
