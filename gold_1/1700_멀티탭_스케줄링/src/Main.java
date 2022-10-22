import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 987654321;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int multiTabNum, k, answer;
    static int[] process, multiTab;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        multiTabNum = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        process = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            process[i] = Integer.parseInt(st.nextToken());
        }

        multiTab = new int[multiTabNum];
        Arrays.fill(multiTab, -1);

        for (int i = 0; i < k; i++) {
            if(isPluggedIn(i)) continue;
            if(findEmptyTab(i)) continue;
            int changeIdx = findLongestNotUsedTab(i);

            multiTab[changeIdx] = process[i];
            answer++;
        }

        System.out.println(answer);


    }

    private static boolean isPluggedIn(int processNum) {
        for (int i = 0; i < multiTabNum; i++) {
            if (multiTab[i] == process[processNum]) {
                return true;
            }
        }
        return false;
    }

    private static boolean findEmptyTab(int processNum) {
        for (int i = 0; i < multiTabNum; i++) {
            if (multiTab[i] == -1) {
                multiTab[i] = process[processNum];
                return true;
            }
        }
        return false;
    }

    private static int findLongestNotUsedTab(int processNum) {

        int changeIdx = -1;
        int maxTtl = -1;

        for (int i = 0; i < multiTabNum; i++) {
            int ttl = 0;

            for (int j = processNum + 1; j < k; j++) {
                if(multiTab[i] == process[j]) {
                    break;
                }
                ttl++;
            }

            if (ttl > maxTtl) {
                changeIdx = i;
                maxTtl = ttl;
            }
        }

        return changeIdx;
    }

}
