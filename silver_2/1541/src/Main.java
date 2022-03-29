import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String seq = br.readLine();

        boolean flag = true;
        int answer = 0;

        for (int i = 0; i < seq.length(); i++) {

            if (flag) {
                if (seq.charAt(i) == '+') {
                    answer += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                } else if (seq.charAt(i) == '-') {
                    answer += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                    flag = false;
                } else {
                    sb.append(seq.charAt(i));
                    if (i == seq.length() - 1) answer += Integer.parseInt(sb.toString());
                }
            } else {
                if (seq.charAt(i) == '+' || seq.charAt(i) == '-') {
                    answer -= Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(seq.charAt(i));
                    if (i == seq.length() - 1) answer -= Integer.parseInt(sb.toString());
                }
            }
        }

        System.out.println(answer);
    }
}
