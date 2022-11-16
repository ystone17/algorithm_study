import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int switchNum, studentNum;
    static int[] switchArr;

    public static void main(String[] args) throws IOException {
        switchNum = Integer.parseInt(br.readLine());
        switchArr = new int[switchNum + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchNum; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }
        studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = target; j <= switchNum; j += target) {
                    switchArr[j] = (switchArr[j] + 1) % 2;
                }
            } else {
                switchArr[target] = (switchArr[target] + 1) % 2;
                for (int j = 1; target - j > 0 && target + j <= switchNum; j++) {
                    if (switchArr[target - j] != switchArr[target + j]) break;
                    switchArr[target - j] = (switchArr[target - j] + 1) % 2;
                    switchArr[target + j] = (switchArr[target + j] + 1) % 2;
                }
            }
        }
        for (int i = 1; i < switchArr.length; i++) {
            sb.append(switchArr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
