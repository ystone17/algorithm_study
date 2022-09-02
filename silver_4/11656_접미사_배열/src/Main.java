import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static String s;
    static String[] sArr;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        sArr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) sArr[i] = s.substring(i);
        Arrays.sort(sArr);
        for (String s1 : sArr) sb.append(s1).append("\n");
        System.out.println(sb);
    }
}
