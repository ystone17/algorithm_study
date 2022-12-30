import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        printAll();

        System.out.println(sb);

    }

    private static void printAll() {
        int size = (n - 1) * 4 + 1;
        for (int i = 0; i < size; i++) {
            print(n, i);
            sb.append("\n");
        }
    }

    static void print(int n, int rowNum) {
        int size = (n - 1) * 4 + 1;

        if (rowNum == 0 || rowNum == size - 1) {
            sb.append("*".repeat(size));
            return;
        }

        if (rowNum == 1 || rowNum == size - 2) {
            sb.append("*").append(" ".repeat(size - 2)).append("*");
            return;
        }

        sb.append("* ");
        print(n - 1, rowNum - 2);
        sb.append(" *");
    }

}
