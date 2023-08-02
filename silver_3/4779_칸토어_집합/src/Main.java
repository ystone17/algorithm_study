import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = "";

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            char[] seq = new char[(int) Math.pow(3, n)];
            Arrays.fill(seq, '-');
            cantor(0, seq.length, seq);
            sb.append(seq).append("\n");
        }

        System.out.println(sb);
    }

    private static void cantor(int beginInclusiveIdx, int lastExclusiveIdx, char[] seq) {
        int middleSize = (lastExclusiveIdx - beginInclusiveIdx) / 3;

        change(beginInclusiveIdx + middleSize, middleSize, seq);

        if (middleSize <= 1) {
            return;
        }

        cantor(beginInclusiveIdx, beginInclusiveIdx + middleSize, seq);
        cantor(lastExclusiveIdx - middleSize, lastExclusiveIdx, seq);
    }

    private static void change(int beginIdx, int size, char[] seq) {
        for (int i = beginIdx; i < beginIdx + size; i++) {
            seq[i] = ' ';
        }
    }
}

