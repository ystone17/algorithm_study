import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int height, width;
    static int[] heightLen;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        heightLen = new int[width];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < width; j++) {
            heightLen[j] = Integer.parseInt(st.nextToken());
        }

        int left, temp;
        int total = 0;

        for (int i = 1; i <= height; i++) {
            left = -1;
            temp = 0;

            if (heightLen[0] >= i) {
                left = 0;
            }

            for (int j = 1; j < width; j++) {
                if (heightLen[j] >= i) {
                    if (left >= 0) {
                        total += temp;
                    }
                    temp = 0;
                    left = j;
                    continue;
                }
                temp++;
            }
        }

        System.out.println(total);
    }
}
