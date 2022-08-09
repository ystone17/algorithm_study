import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = n; true; i++) {
            if (!prime(i)) continue;
            if (check(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean prime(int i){
        if(i == 1) return false;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0){
                return false;
            }
        }

        return true;
    }

    private static boolean check(int i) {
        String s = i + "";
        for (int j = 0; j < s.length() / 2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                return false;
            }
        }
        return true;
    }
}