import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Record> records = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        records.add(new Record(-1, "00:00"));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            records.add(new Record(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        records.sort((o1, o2) -> {
            if (o1.t.min != o2.t.min) {
                return Integer.compare(o1.t.min, o2.t.min);
            }

            return Integer.compare(o1.t.sec, o2.t.sec);
        });
        records.add(new Record(-1, "48:00"));

        int one = 0;
        int two = 0;

        Time oneT = new Time(0, 0);
        Time twoT = new Time(0, 0);

        for (int i = 1; i < records.size(); i++) {
            Record past = records.get(i - 1);
            Record cur = records.get(i);
            if (one > two) {
                Time sub = cur.t.sub(past.t);
                oneT.add(sub);
            } else if (one < two) {
                Time sub = cur.t.sub(past.t);
                twoT.add(sub);
            }

            if (cur.teamNum == 1) {
                one++;
            } else {
                two++;
            }
        }

        System.out.println(oneT);
        System.out.println(twoT);
    }

    static class Record {
        int teamNum;
        Time t;

        public Record(int teamNum, String time) {
            this.teamNum = teamNum;
            t = new Time(time);
        }
    }

    static class Time {
        int min;
        int sec;

        public Time(int min, int sec) {
            this.min = min;
            this.sec = sec;
        }

        public Time(String time) {
            String[] split = time.split(":");
            min = Integer.parseInt(split[0]);
            sec = Integer.parseInt(split[1]);
        }

        public Time sub(Time time) {
            return new Time(this.min - time.min + (this.sec < time.sec ? -1 : 0),
                    this.sec - time.sec + (this.sec < time.sec ? 60 : 0));
        }

        public void add(Time time) {
            this.min += time.min;
            this.sec += time.sec;

            if (sec >= 60) {
                this.sec /= 60;
                this.min++;
            }
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", min, sec);
        }
    }
}
