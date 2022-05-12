import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int yLen, xLen, invenNum, answerTime, answerHeight;
    static int[] heights = new int[256 + 1];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        invenNum = Integer.parseInt(st.nextToken());

        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                int value = Integer.parseInt(st.nextToken());
                heights[value]++;
            }
        }
        answerTime = Integer.MAX_VALUE;
        solve2();

        System.out.printf("%d %d", answerTime, answerHeight);

    }

    private static void solve2() {
        for (int height = 0; height <= 256; height++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < height; j++) {
                left += (height - j) * heights[j];
            }

            for (int j = height + 1; j <= 256; j++) {
                right += (j - height) * heights[j];
            }
            if(right + invenNum < left) continue;

            if(left + right * 2 <= answerTime){
                answerTime = left + right * 2;
                answerHeight = height;
            }
        }
    }
}
