import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        s = s.replaceAll("c=", "a");
        s = s.replaceAll("c-", "a");
        s = s.replaceAll("dz=", "a");
        s = s.replaceAll("d-", "a");
        s = s.replaceAll("lj", "a");
        s = s.replaceAll("nj", "a");
        s = s.replaceAll("s=", "a");
        s = s.replaceAll("z=", "a");

        System.out.println(s.length());
    }
}
