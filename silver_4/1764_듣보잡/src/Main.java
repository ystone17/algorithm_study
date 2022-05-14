import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, cnt;
    static String[] nArr, mArr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nArr = new String[n];
        mArr = new String[m];

        for (int i = 0; i < n + m; i++) {
            if(i < n){
                nArr[i] = br.readLine();
            } else{
                mArr[i - n] = br.readLine();
            }
        }

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        int idx = 0;
        for (String s : nArr) {
            while (idx < m && s.compareTo(mArr[idx]) > -1) {
                if(s.compareTo(mArr[idx]) == 0){
                    sb.append(s).append("\n");
                    idx++;
                    cnt++;
                    break;
                }
                idx++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
