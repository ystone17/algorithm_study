import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int prime = -1;
        int sum = 0;
        for (int i = m; i >= n; i--) {
            if(check(i)){
                sum += i;
                prime = i;
            }
        }

        if(prime == -1){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(prime);
        }
    }

    static boolean check(int k) {
        if (k == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
