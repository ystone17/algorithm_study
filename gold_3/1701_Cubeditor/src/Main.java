import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s;

    static int[] table;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 5000; i++) {
//
//            char cValue = (char) ((Math.random() * 26) + 97);
//            sb.append(cValue);
//        }
//        s = sb.toString();
        initTable();

        int length = s.length();

        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length - i + 1; j++) {

                int count = KMP(j, j + i);
                if (count >= 2) {
                    System.out.println(i);
                    return;
                }
            }
        }

        System.out.println(0);

    }

    private static void initTable() {
        int length = s.length();
        table = new int[length];

        int idx = 0;

        for (int i = 1; i < length; i++) {
            while (idx > 0 && s.charAt(i) != s.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (s.charAt(i) == s.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }

    }

    private static int KMP(int patternStart, int patternEnd) {
        int count = 0;

        int parentLen = s.length();
        int patternLen = patternEnd - patternStart;

        int begin = 0;
        int matchedLen = 0;

        while (begin <= parentLen - patternLen) {
            if (matchedLen < patternLen && s.charAt(begin + matchedLen) == s.charAt(patternStart + matchedLen)) {
                matchedLen++;

                if (matchedLen == patternLen) {
                    count++;
                }
            } else {
                if (matchedLen == 0) {
                    begin++;
                } else {
                    begin += matchedLen - table[matchedLen - 1];
                    matchedLen = table[matchedLen - 1];
                }
            }
        }

        return count;
    }
}
