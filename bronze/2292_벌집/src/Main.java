import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int start = 2;
        int next = 6;
        int count = 1;
        while (start <= n){
            start += next;
            next += 6;
            count++;
        }

        System.out.println(count);

    }

}
