import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s, p;
    static int[] pi;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        p = br.readLine();

        pi = new int[p.length()];

        getPi();
        int res = KMP();
        System.out.println(res);

    }

    // pi[i] i 번째 문자까지 접두사 == 접미사의 최대 길이
    // pi[0] = 0;
    static void getPi() {
        int idx = 0;

        // 주의 : 1부터 시작
        // idx 가 왼쪽 인덱스 , i 가 오른쪽 인덱스
        for (int i = 1; i < p.length(); i++) {

            //
            while (idx > 0 && p.charAt(i) != p.charAt(idx)) {
                idx = pi[idx - 1];
            }

            if (p.charAt(i) == p.charAt(idx)) {
                idx += 1;
                pi[i] = idx;
            }

        }
    }

    static int KMP() {
        int sLen = s.length();
        int pLen = p.length();

        int idx = 0;
        for (int i = 0; i < sLen; i++) {

            while (idx > 0 && s.charAt(i) != p.charAt(idx)) {
                idx = pi[idx - 1];
            }

            if (s.charAt(i) == p.charAt(idx)) {
                if (idx == pLen - 1) {
                    return 1;
                } else {
                    idx += 1;
                }
            }
        }

        return 0;
    }
}
