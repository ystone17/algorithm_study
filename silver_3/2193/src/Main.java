import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] piNum = new long[91];
        piNum[1]= 1;
        piNum[2] =1;
        for (int i = 3; i <= 90; i++) {
            piNum[i] = piNum[i - 1] + piNum[i - 2];
        }

        System.out.println(piNum[Integer.parseInt(br.readLine())]);

    }
}
