import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;
    static List<Character> oper = new ArrayList<>();
    static char[] opers;
    static char[] o = {'+', '-', '*', '/'};
    static int[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        opers = new char[n - 1];
        visited = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int operNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < operNum; j++) {
                oper.add(o[i]);
            }
        }

        point(0);

        bw.write(max + "");
        bw.newLine();
        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();

    }

    static void point(int num) {
        if (num == n - 1) {
            // calc
            int res = numbers[0], idx = 1;

            for (char c : opers) {
                switch (c) {
                    case '+':
                        res += numbers[idx++];
                        break;
                    case '-':
                        res -= numbers[idx++];
                        break;
                    case '*':
                        res *= numbers[idx++];
                        break;
                    case '/':
                        res /= numbers[idx++];
                        break;
                }
            }

            //res 저장

            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            opers[num] = oper.get(i);
            point(num + 1);
            visited[i] = 0;
        }

    }
}
