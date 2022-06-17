import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] liquid;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        liquid = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int lNum = liquid[left];
        int rNum = liquid[right];
        int min = Integer.MAX_VALUE;

        while (left < right) {

            int sum = liquid[left] + liquid[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                lNum = liquid[left];
                rNum = liquid[right];

            }

            if(sum < 0){
                left++;
            } else{
                right--;
            }

        }

        System.out.printf("%d %d",lNum, rNum);
    }
}
