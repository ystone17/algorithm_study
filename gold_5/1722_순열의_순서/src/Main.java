import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, questionNumber;
    static long k;
    static int[] seq;
    static long[] pact = new long[21];

    public static void main(String[] args) throws IOException {
        pact[0] = 1;
        pact[1] = 1;
        for (int i = 2; i <= 20; i++) {
            pact[i] = pact[i - 1] * i;
        }

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        questionNumber = Integer.parseInt(st.nextToken());

        if (questionNumber == 1) {
            k = Long.parseLong(st.nextToken());
            q1();
        } else {
            seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }
            q2();
        }
    }

    static void q1() {
        int[] used = new int[n + 1];
        int[] seq = new int[n];
        long base = 0;
        for (int place = 0; place < n; place++) {
            long factorial = pact[n - (place + 1)];

            for (int i = 0; i < n - place; i++) {
                if (k <= factorial * (i + 1) + base) {

                    int cnt = i + 1;

                    for (int j = 1; j < used.length; j++) {
                        if (used[j] == 1) continue;
                        if (used[j] == 0) {
                            cnt--;
                        }

                        if (cnt == 0) {
                            used[j] = 1;
                            seq[place] = j;
                            base += factorial * i;
                            break;
                        }
                    }

                    break;
                }

            }


        }

        for (int i : seq) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void q2() {
        long res = 0;
        int[] used = new int[n + 1];

        for (int place = 0; place < seq.length; place++) {

            long factorial = pact[n - (place + 1)];

            int cnt = 0;
            for (int i = 1; i < used.length; i++) {
                if (used[i] == 1) continue;
                cnt++;

                if (seq[place] == i) {
                    used[i] = 1;
                    break;
                }
            }

            res += factorial * (cnt - 1);
        }

        System.out.println(res + 1);
    }
}
