import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int studentNum = Integer.parseInt(br.readLine());
            int[] hopeNum = new int[studentNum + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= studentNum; j++) {
                hopeNum[j] = Integer.parseInt(st.nextToken());
            }




        }
    }
}
