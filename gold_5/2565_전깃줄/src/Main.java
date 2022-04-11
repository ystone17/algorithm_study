import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int n, index;
    static int[] bLine, dp;
    static Line[] lines;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        lines = new Line[n];
        dp = new int[n];
        bLine = new int[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);
        for (int i = 0; i < lines.length; i++) {
            bLine[i] = lines[i].b;
        }

        dp[index++] = bLine[0];

        for (int i = 1; i < bLine.length; i++) {
            if(bLine[i] > dp[index - 1]) {
                dp[index++] = bLine[i];
            } else {
                int i1 = biSearch(bLine[i]);
                dp[i1] = bLine[i];
            }
        }

        System.out.println(bLine.length - index);


    }

    static int biSearch(int t){
        int left = 0;
        int right = index;


        // lower bound
        while (left < right) {
            int mid = (left + right) / 2;

            if(dp[mid] >= t){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static class Line implements Comparable<Line>{
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(a, o.a);
        }
    }
}
