import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] brokenNum = new boolean[10];
    static int goal, n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        goal = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        if(n != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                brokenNum[Integer.parseInt(st.nextToken())] = true;
            }
        }


        answer = Math.abs(goal - 100);
        int size = (int) Math.log10(goal) + 1;
        if (goal == 0) size = 1;
        if (size > 1)
            answer = Math.min(answer, solve(0, size - 1, ""));
        answer = Math.min(answer, solve(0, size, ""));
        answer = Math.min(answer, solve(0, size + 1, ""));
        System.out.println(answer);
    }

    static int solve(int depth, int size, String res) {
        if (depth == size) {
            return size + Math.abs(Integer.parseInt(res) - goal);
        }

        int i = 0;

        int answer = Integer.MAX_VALUE;

        for (; i < 10; i++) {
            if (brokenNum[i]) continue;
            answer = Math.min(answer, solve(depth + 1, size, res + i));
        }

        return answer;
    }


}
