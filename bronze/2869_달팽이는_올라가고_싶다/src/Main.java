import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a,b,v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int oneDay = a-b;
        int anotherGoal = v - a;
        int res = 1;

        res += anotherGoal / oneDay;
        if(anotherGoal % oneDay > 0) res++;

        System.out.println(res);

    }
}
