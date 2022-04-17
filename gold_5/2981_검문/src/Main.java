import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                gcd = gcd(gcd, arr[i] - arr[j]);
            }
        }

        for (int i = 2; i <= gcd ; i++) {
            if ( gcd % i == 0) sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static int gcd(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        while (b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

}
