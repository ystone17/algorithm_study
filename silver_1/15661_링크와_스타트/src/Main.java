import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] synergy;
    static int[] teamInfo;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        synergy = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                synergy[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        teamInfo = new int[n];


        for (int i = 1; i <= n / 2; i++) {
            simulation(i, 0, 0);
        }

        System.out.println(answer);
    }

    private static void simulation(int teamSize, int playerCnt, int firstSearchPlayerNumber) {
        if (playerCnt == teamSize) {
            int zeroTeamSynergy = calcSynergy(0);
            int oneTeamSynergy = calcSynergy(1);
            answer = Math.min(answer, Math.abs(zeroTeamSynergy - oneTeamSynergy));
            return;
        }

        for (int playerNumber = firstSearchPlayerNumber; playerNumber < n; playerNumber++) {
            if (teamInfo[playerNumber] == 1) {
                continue;
            }

            teamInfo[playerNumber] = 1;
            simulation(teamSize, playerCnt + 1, playerNumber + 1);
            teamInfo[playerNumber] = 0;
        }
    }

    private static int calcSynergy(int teamNumber) {
        int total = 0;

        for (int y = 0; y < n; y++) {
            if (teamInfo[y] != teamNumber) {
                continue;
            }
            for (int x = 0; x < n; x++) {
                if (teamInfo[x] != teamNumber) {
                    continue;
                }

                total += synergy[y][x];
            }
        }

        return total;
    }
}
