import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        var space = n - 2;

        sb.append("*".repeat(n)).append(" ".repeat(space * 2 + 1)).append("*".repeat(n)).append("\n");

        for (int i = 0; i < space; i++) {
            sb.append(" ".repeat(i + 1))
                    .append("*").append(" ".repeat(space)).append("*")
                    .append(" ".repeat((space * 2 + 1) - (2 * (i + 1))))
                    .append("*").append(" ".repeat(space)).append("*")
                    .append("\n");
        }

        sb.append(" ".repeat(space + 1))
                .append("*").append(" ".repeat(space))
                .append("*").append(" ".repeat(space))
                .append("*")
                .append("\n");

        for (int i = space - 1; i >= 0; i--) {
            sb.append(" ".repeat(i + 1))
                    .append("*").append(" ".repeat(space)).append("*")
                    .append(" ".repeat((space * 2 + 1) - (2 * (i + 1))))
                    .append("*").append(" ".repeat(space)).append("*")
                    .append("\n");
        }

        sb.append("*".repeat(n)).append(" ".repeat(space * 2 + 1)).append("*".repeat(n)).append("\n");

        System.out.println(sb);
    }
}
