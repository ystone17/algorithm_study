import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] alpha;
    static int[] time = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
    static int answer;

    public static void main(String[] args) throws IOException {
        alpha = br.readLine().toCharArray();
        for (char c : alpha) {
            answer += time[c - 'A'];
        }

        System.out.println(answer);


    }
}
