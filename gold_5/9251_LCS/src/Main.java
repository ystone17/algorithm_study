import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] a, b;
    static int answer, temp, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        for (int j = 0; j < a.length; j++) {
            for (int i = start; i < b.length ; i++) {
                if (b[i] == a[j]) {
                    start = i + 1;
                    temp++;
                    break;
                }
            }
        }

        answer = temp;
        System.out.println(answer);
        temp = 0;
        start = 0;
        for (int j = 0; j < b.length; j++) {
            for (int i = start; i < a.length ; i++) {
                if (a[i] == b[j]) {
                    start = i + 1;
                    temp++;
                    break;
                }
            }
        }

        answer = Math.max(answer, temp);
        System.out.println(answer);


    }
}
