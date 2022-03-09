import java.util.*;

public class first {
    public static void main(String[] args) {
        int a = 3;
        int[][] solution = solution(a);
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[dir.size()][2];
        for (int i = 0; i < dir.size(); i++) {
            int[] ints = dir.get(i);
            answer[i] = ints;
        }

        return answer;
    }

    static List<int[]> dir = new ArrayList<>();

    public static void hanoi(int n, int src, int mid, int dst) {
        if (n == 1) {
            dir.add(new int[]{src, dst});
            return;
        }


        hanoi(n - 1, src, dst, mid);
        dir.add(new int[]{src, dst});
        hanoi(n - 1, mid, src, dst);


    }


}
