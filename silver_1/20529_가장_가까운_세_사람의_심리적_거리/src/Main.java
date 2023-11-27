import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String[] MBTI = new String[]{"ENFJ", "ENFP", "ENTJ", "ENTP", "ESFJ", "ESFP", "ESTJ", "ESTP", "INFJ", "INFP", "INTJ", "INTP", "ISFJ", "ISFP", "ISTJ", "ISTP"};
    static int tc, n, min, abc, ab, bc, ca;
    static Map<String, Integer> countByMbti = new HashMap<>();
    static char[][] mbtis;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (String s : MBTI) {
            countByMbti.put(s, 0);
        }

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            mbtis = new char[100000][4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String s = st.nextToken();
                countByMbti.put(s, countByMbti.get(s) + 1);
            }

            min = Integer.MAX_VALUE;

            for (int a = 0; a < 16; a++) {
                for (int b = a + 1; b < 16; b++) {
                    for (int c = b + 1; c < 16; c++) {
                        int aCount = countByMbti.get(MBTI[a]);
                        int bCount = countByMbti.get(MBTI[b]);
                        int cCount = countByMbti.get(MBTI[c]);

                        if (aCount + bCount + cCount < 3) {
                            continue;
                        }

                        if (aCount >= 3 || bCount >= 3 || cCount >= 3) {
                            min = 0;
                            continue;
                        }

                        for (int j = 0; j < 4; j++) {
                            if (MBTI[a].charAt(j) != MBTI[b].charAt(j)) ab++;
                            if (MBTI[b].charAt(j) != MBTI[c].charAt(j)) bc++;
                            if (MBTI[c].charAt(j) != MBTI[a].charAt(j)) ca++;
                        }

                        if (aCount == 1 && bCount == 1 & cCount == 1) {
                            min = Math.min(min, ab + bc + ca);
                            continue;
                        }

                        if (aCount == 0) {
                            min = Math.min(min, bc);
                        } else if (bCount == 0) {
                            min = Math.min(min, ca);
                        } else if (cCount == 0) {
                            min = Math.min(min, ab);
                        }

                        min = Math.min(min, Math.min(Math.min(ab, bc), ca));
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
