import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        char[][] graphic = new char[length][length];

        for (int i = 0; i < length; i++) {
            graphic[i] = br.readLine().toCharArray();

        }

        System.out.printf("%s", zip(graphic, length, 0, 0));

    }

    static String zip(char[][] graphic, int length, int y, int x) {
        if (length == 1) {
            return graphic[y][x] + "";
        }

        char base = graphic[y][x];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (graphic[y + i][x + j] != base) {

                    int nextLen = length / 2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(zip(graphic, nextLen, y, x));
                    sb.append(zip(graphic, nextLen, y, x + nextLen));
                    sb.append(zip(graphic, nextLen, y + nextLen, x));
                    sb.append(zip(graphic, nextLen, y + nextLen, x + nextLen));
                    sb.append(")");
                    return sb.toString();
                }
            }
        }

        return String.format("%c", base);
    }
}
