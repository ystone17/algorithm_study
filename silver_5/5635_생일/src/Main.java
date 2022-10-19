import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Human[] humans = new Human[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            humans[i] = new Human(name, day, month, year);
        }

        Arrays.sort(humans);

        System.out.println(humans[n-1].name);
        System.out.println(humans[0].name);
    }

    static class Human implements Comparable<Human> {
        String name;
        int day;
        int month;
        int year;

        public Human(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Human o) {
            if (year != o.year) {
                return Integer.compare(year, o.year);
            } else if (month != o.month) {
                return Integer.compare(month, o.month);
            } else {
                return Integer.compare(day, o.day);
            }
        }
    }
}
