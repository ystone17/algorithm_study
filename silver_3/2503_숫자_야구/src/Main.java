import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static Play[] plays;
    static int[] target = new int[3];
    static int[] used = new int[10];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        plays = new Play[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int numbers = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            plays[i] = new Play(numbers, strike, ball);
        }
        bf(0);
        System.out.println(res);

    }

    static void bf(int idx) {
        if (idx >= 3) {
            check();
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            target[idx] = i;
            bf(idx + 1);
            used[i] = 0;
            target[idx] = 0;
        }

    }

    static void check() {
        for (Play play : plays) {
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (target[i] != play.numbers[j]) continue;
                    if (i == j) strike++;
                    if (i != j) ball++;
                }
            }
            if (play.strike != strike || play.ball != ball) return;
        }

        res++;
    }


    static class Play {
        int[] numbers = new int[3];
        int strike;
        int ball;

        public Play(int numbers, int strike, int ball) {
            int idx = 2;
            while (numbers != 0) {
                this.numbers[idx--] = numbers % 10;
                numbers /= 10;
            }
            this.strike = strike;
            this.ball = ball;
        }
    }
}
