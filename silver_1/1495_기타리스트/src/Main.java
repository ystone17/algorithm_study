import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, e;
    static int[] changeVolume;
    static int[][] useVolume;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        changeVolume = new int[n];
        useVolume = new int[2][e + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            changeVolume[i] = Integer.parseInt(st.nextToken());
        }

        useVolume[0][s] = 1;
        int idx = 0;
        int nIdx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < useVolume[idx].length; j++) {
                if(useVolume[idx][j] == 1){
                    if(j + changeVolume[i] <= e){
                        useVolume[nIdx][j + changeVolume[i]] = 1;
                    }

                    if(j - changeVolume[i] >= 0){
                        useVolume[nIdx][j - changeVolume[i]] = 1;
                    }
                }
            }
            useVolume[idx] = new int[e + 1];
            idx = (idx + 1) % 2;
            nIdx = (idx + 1) % 2;
        }

        int answer = -1;
        for (int i = useVolume[idx].length - 1; i >= 0; i--) {
            if(useVolume[idx][i] == 1) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }


}
