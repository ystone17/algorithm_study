import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] used;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        used = new int[n + 1];
        answer = new int[n + 1];

        req(1);
        System.out.println(sb);
    }

    static void req(int i){
        if(i > n){
            addPrint();
            return;
        }

        for (int j = 1; j < n + 1; j++) {
            if(used[j] == 1) continue;
            used[j] = 1;
            answer[i] = j;
            req(i + 1);
            used[j] = 0;
        }
    }

    static void addPrint(){
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
    }
}
