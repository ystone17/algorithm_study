import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        for (int i = Integer.parseInt(s[0]); i <= Integer.parseInt(s[1]); i++) {
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }

        dpPrime();


        System.out.println(sb);


    }

    static boolean isPrime(int i ){
        if (i == 1) return false;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0) return false;
        }
        return true;
    }

    private static void dpPrime() {
        int[] prime = new int[21 + 1];
        for (int i = 2; i < 21; i++) {
            if(prime[i] == 1) continue;

            for (int j = 2* i; j <= 21 ; j += i) {
                prime[j] = 1;
            }

        }
    }

}
