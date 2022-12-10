import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Serial[] serials;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        serials = new Serial[n];

        for (int i = 0; i < n; i++) {
            serials[i] = new Serial(br.readLine());
        }

        Arrays.sort(serials);
        for (Serial serial : serials) {
            sb.append(serial.serial).append("\n");
        }

        System.out.println(sb);
    }

    static class Serial implements Comparable<Serial> {
        String serial;

        public Serial(String serial) {
            this.serial = serial;
        }

        @Override
        public int compareTo(Serial o) {
            if (serial.length() != o.serial.length()) {
                return Integer.compare(serial.length(), o.serial.length());
            }

            int a = getSum(serial);
            int b = getSum(o.serial);
            if (a != b) {
                return Integer.compare(a, b);
            }

            return serial.compareTo(o.serial);
        }

        private int getSum(String s) {
            int temp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9) {
                    temp += s.charAt(i) - '0';
                }
            }

            return temp;
        }
    }
}
