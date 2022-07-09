import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static char[] a, b;
    static int[] primeNumber = new int[10000];
    static int[] visited = new int[10000];
    static Queue<char[]> q;

    public static void main(String[] args) throws IOException {

        for (int i = 2; i < primeNumber.length; i++) {
            if (primeNumber[i] == 0) {
                for (int j = i * 2; j < primeNumber.length; j += i) {
                    primeNumber[j] = 1;
                }
            }
        }

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            visited = new int[10000];
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().toCharArray();
            b = st.nextToken().toCharArray();

            int aNum = getaNum(a);
            int bNum = getaNum(b);

            if (aNum == bNum) {
                sb.append(0).append("\n");
                continue;
            }

            if (primeNumber[aNum] == 1 ||primeNumber[bNum] == 1) {
                sb.append("Impossible").append("\n");
                continue;
            }

            q = new LinkedList<>();
            q.add(a);
            visited[aNum] = 1;

            int cnt = 0;
            boolean ok = false;
            while (!q.isEmpty()) {
                cnt++;
                int size = q.size();
                ok = false;
                for (int i = 0; i < size; i++) {
                    char[] cur = q.poll();

                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 10; k++) {
                            char[] nCur = Arrays.copyOf(cur, cur.length);
                            nCur[j] = (char) (k + '0');
                            int num = getaNum(nCur);

                            if (num == bNum) {
                                ok = true;
                                sb.append(cnt).append("\n");
                                break;
                            }

                            if (num < 1000) continue;
                            if (primeNumber[num] == 1) continue;
                            if (visited[num] == 1) continue;
                            visited[num] = 1;
                            q.add(nCur);
                        }
                        if (ok) break;
                    }
                    if (ok) break;
                }
                if (ok) break;
            }
            if (!ok) {
                sb.append("Impossible").append("\n");
                break;
            }
        }
        System.out.println(sb);


    }

    private static int getaNum(char[] n) {
        int idx = 1000;
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num += (n[i] - '0') * idx;
            idx /= 10;
        }
        return num;
    }
}
