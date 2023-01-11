import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static List<Number> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = n; i <= m; i++) {
            list.add(new Number(i));
        }

        list = list.stream().
                sorted(Comparator.comparing(o -> o.str))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).number).append(" ");
            if (i % 10 == 9) sb.append("\n");
        }

        System.out.println(sb);

    }

    static class Number {
        static String[] nToS = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };
        int number;
        String str;

        public Number(int number) {
            this.number = number;

            this.str = "";
            do {
                String nTo = nToS[number % 10];
                str = String.format("%s %s", nTo, str);
                number /= 10;
            } while (number != 0);
        }
    }
}
