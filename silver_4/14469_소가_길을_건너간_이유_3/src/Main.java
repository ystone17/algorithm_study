import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Cow> cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        cows.sort(Comparator.comparingInt(o -> o.arriveTime));
        int time = 1;
        for (Cow cow : cows) {
            if (time < cow.arriveTime) {
                time = cow.arriveTime;
            }

            time += cow.checkingTime;
        }

        System.out.println(time);
    }

    static class Cow {
        private int arriveTime;
        private int checkingTime;

        public Cow(int arriveTime, int checkingTime) {
            this.arriveTime = arriveTime;
            this.checkingTime = checkingTime;
        }
    }
}
