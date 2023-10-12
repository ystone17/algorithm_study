import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, tubeSize, tubeMaxNum;
    static int[][] tubes;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tubeSize = Integer.parseInt(st.nextToken());
        tubeMaxNum = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        tubes = new int[tubeMaxNum][tubeSize];

        for (int tubeNum = 0; tubeNum < tubeMaxNum; tubeNum++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < tubeSize; i++) {
                tubes[tubeNum][i] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
