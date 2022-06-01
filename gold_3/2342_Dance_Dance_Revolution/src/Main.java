import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[][][] points;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        arr = new int[s.length - 1];
        points = new int[arr.length][5][5];

        for (int i = 0; i < s.length - 1; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int res = dance(0, 0, 0);
        System.out.println(res);

    }

    static int dance(int index, int left, int right) {
        if (index == arr.length) return 0;

        if (points[index][left][right] != 0) return points[index][left][right];


        int lPoint = getPoint(left, arr[index]) + dance(index + 1, arr[index], right);
        int rPoint = getPoint(right, arr[index]) + dance(index + 1, left, arr[index]);

        return points[index][left][right] = Math.min(lPoint, rPoint);
    }

    static int getPoint(int from, int to) {
        if (from == 0) {
            return 2;
        } else if (from == to) {
            return 1;
        } else if (Math.abs(from - to) == 2) {
            return 4;
        } else {
            return 3;
        }
    }

}
