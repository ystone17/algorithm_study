import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n != 0){
            list.add(n % 10);
            n /= 10;
        }

        list.sort(Collections.reverseOrder());

        for (Integer i : list) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
