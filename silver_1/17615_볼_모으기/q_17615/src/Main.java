import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, min = Integer.MAX_VALUE;
    static char[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq = br.readLine().toCharArray();

        min = Math.min(min, getCount('R'));
        min = Math.min(min, getCount('B'));
        min = Math.min(min, getReverseCount('R'));
        min = Math.min(min, getReverseCount('B'));

        System.out.println(min);
    }

    private static int getCount(char target) {
        var count = 0;
        var startIdx = 0;
        while (startIdx < seq.length && seq[startIdx] == target) {
            startIdx++;
        }

        for (int i = startIdx; i < seq.length; i++) {
            char c = seq[i];
            if (c == target) {
                count++;
            }
        }

        return count;
    }

    private static int getReverseCount(char target) {
        var count = 0;
        var startIdx = seq.length - 1;
        while (startIdx >= 0 && seq[startIdx] == target) {
            startIdx--;
        }
        for (int i = startIdx; i >= 0; i--) {
            char c = seq[i];
            if (c == target) {
                count++;
            }
        }

        return count;
    }
}
