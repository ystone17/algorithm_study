import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, number;
    static int[] count;
    static int[] min = {-1, -1, 1, 7, 4, 2, 0, 8};
    static int[] max = {-1, -1, 1, 7, 4, 5, 9, 8};
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static List<Integer> zeroList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            number = Integer.parseInt(br.readLine());

            count = new int[7 + 1];
            initMinCount(number);
            minPq.clear();
            zeroList.clear();

            for (int i = 2; i <= 7; i++) {
                if (i == 6) {
                    continue;
                }

                for (int j = 0; j < count[i]; j++) {
                    minPq.add(min[i]);
                }
            }

            if (minPq.isEmpty()) {
                minPq.add(6);
                count[6]--;
            }

            sb.append(minPq.poll());

            for (int j = 0; j < count[6]; j++) {
                minPq.add(0);
            }

            for (Integer integer : minPq) {
                sb.append(integer);
            }
            sb.append(" ");

            count = new int[7 + 1];
            initMaxCount(number);
            maxPq.clear();

            for (int i = 2; i <= 7; i++) {
                for (int j = 0; j < count[i]; j++) {
                    maxPq.add(max[i]);
                }
            }
            for (Integer integer : maxPq) {
                sb.append(integer);
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }

    public static boolean initMinCount(int number) {
        if (number == 0) {
            return true;
        }

        if (number < 2) {
            return false;
        }

        for (int i = 7; i >= 2; i--) {
            count[i]++;
            if (initMinCount(number - i)) {
                return true;
            }
            count[i]--;
        }

        return false;
    }

    public static boolean initMaxCount(int number) {
        if (number == 0) {
            return true;
        }

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= 7; i++) {
            count[i]++;
            if (initMaxCount(number - i)) {
                return true;
            }
            count[i]--;
        }

        return false;
    }
}
/*
108888888888 111111111111111111111111111111111111111
188888888888 711111111111111111111111111111111111111
200888888888 1111111111111111111111111111111111111111
208888888888 7111111111111111111111111111111111111111
288888888888 11111111111111111111111111111111111111111
688888888888 71111111111111111111111111111111111111111
888888888888 111111111111111111111111111111111111111111

108888888888 111111111111111111111111111111111111111
188888888888 711111111111111111111111111111111111111
788888888888 1111111111111111111111111111111111111111
488888888888 7111111111111111111111111111111111111111
288888888888 11111111111111111111111111111111111111111
808888888888 71111111111111111111111111111111111111111
888888888888 111111111111111111111111111111111111111111*/
